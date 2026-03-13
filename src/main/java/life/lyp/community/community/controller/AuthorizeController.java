package life.lyp.community.community.controller;

import life.lyp.community.community.dto.AccessTokenDTO;
import life.lyp.community.community.dto.GithubUser;
import life.lyp.community.community.mapper.UserMapper;
import life.lyp.community.community.model.User;
import life.lyp.community.community.provider.GithubProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * ClassName:AuthorizeController
 * Package:life.lyp.community.community.controller
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/9 - 18:10
 * @Version: v1.0
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);  //44cce246bce0e57d9f40e0514ce66019671c9294
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubuser = githubProvider.getUser(accessToken);
        System.out.println(accessToken);
        if(githubuser!=null && githubuser.getId()!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubuser.getName());
            user.setAccountId(String.valueOf(githubuser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubuser.getAvatarUrl());
            userMapper.insert(user);

            //登录成功,写cookie和session
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        }else{
            //登录失败
            return "redirect:/";
        }

    }

    
}

package life.lyp.community.community.controller;

import life.lyp.community.community.dto.AccessTokenDTO;
import life.lyp.community.community.dto.GithubUser;
import life.lyp.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("Ov23liu7u0LxU3empmnb");
        accessTokenDTO.setClient_secret("44cce246bce0e57d9f40e0514ce66019671c9294");  //44cce246bce0e57d9f40e0514ce66019671c9294
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }

    
}

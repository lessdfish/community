package life.lyp.community.community.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import life.lyp.community.community.dto.AccessTokenDTO;
import life.lyp.community.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Spliterator;

/**
 * ClassName:GIthubProvider
 * Package:life.lyp.community.community.provider
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/9 - 18:16
 * @Version: v1.0
 */
@Component
public class GithubProvider {

    @Autowired
    private OkHttpClient client;
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
            MediaType mediaType = MediaType.get("application/json; charset=utf-8");

            RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                        .url("https://github.com/login/oauth/access_token")
                    .header("Accept","application/json")
                        .post(body)
                        .build();

            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                JSONObject jsonObject = JSON.parseObject(string);
                return jsonObject.getString("access_token");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

    public GithubUser getUser(String accessToken){
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "Bearer " + accessToken)
                .header("Accept","application/json")
                .header("User-Agent","community-app")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }
}



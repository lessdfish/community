package life.lyp.community.community.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:OkHttpConfig
 * Package:life.lyp.community.community.config
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/11 - 13:58
 * @Version: v1.0
 */
@Configuration
public class OkHttpConfig {
    @Value("${proxy.enabled}")
    private boolean proxyEnabled;
    @Value("${proxy.host}")
    private String proxyHost;
    @Value("${proxy.port}")
    private int proxyPort;

    @Bean
    public OkHttpClient okHttpClient(){
        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor =
                new HttpLoggingInterceptor();

        loggingInterceptor.setLevel(
                HttpLoggingInterceptor.Level.BODY
        );
        //创建代理
        Proxy proxy = new Proxy(
                Proxy.Type.HTTP,
                new InetSocketAddress("127.0.0.1",7890)
        );
        //创建连接池
        ConnectionPool connectionPool =
                new ConnectionPool(
                        50, //最大空闲连接数
                        5, //空闲连接存活时间
                        TimeUnit.MINUTES
                );
        return new OkHttpClient.Builder()
                .proxy(proxy)
                .connectionPool(connectionPool)
                .addInterceptor(loggingInterceptor)
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build();
    }

}

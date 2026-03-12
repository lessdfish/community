package life.lyp.community.community.dto;

import lombok.Data;

/**
 * ClassName:AccessTokenDTO
 * Package:life.lyp.community.community.dto
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/9 - 18:19
 * @Version: v1.0
 */
@Data
public class AccessTokenDTO {
    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String state;
}

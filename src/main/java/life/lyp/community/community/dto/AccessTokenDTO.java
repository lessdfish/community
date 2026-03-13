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
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}

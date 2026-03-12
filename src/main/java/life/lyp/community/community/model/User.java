package life.lyp.community.community.model;

import lombok.Data;

/**
 * ClassName:User
 * Package:life.lyp.community.community.model
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/11 - 19:26
 * @Version: v1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}

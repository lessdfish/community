package life.lyp.community.community.dto;

import lombok.Data;

/**
 * ClassName:GithubUser
 * Package:life.lyp.community.community.dto
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/11 - 11:21
 * @Version: v1.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}

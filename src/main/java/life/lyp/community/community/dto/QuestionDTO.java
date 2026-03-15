package life.lyp.community.community.dto;

import life.lyp.community.community.model.User;
import lombok.Data;

/**
 * ClassName:QuestionDTO
 * Package:life.lyp.community.community.dto
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/12 - 22:25
 * @Version: v1.0
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}

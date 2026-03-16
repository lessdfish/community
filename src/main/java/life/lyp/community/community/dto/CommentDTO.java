package life.lyp.community.community.dto;

import life.lyp.community.community.model.User;
import lombok.Data;

/**
 * ClassName:CommentDTO
 * Package:life.lyp.community.community.dto
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/16 - 18:10
 * @Version: v1.0
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}

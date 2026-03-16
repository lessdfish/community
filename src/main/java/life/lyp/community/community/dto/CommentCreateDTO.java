package life.lyp.community.community.dto;

import lombok.Data;

/**
 * ClassName:CommentCreateDTO
 * Package:life.lyp.community.community.dto
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/15 - 16:05
 * @Version: v1.0
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}

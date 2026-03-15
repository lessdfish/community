package life.lyp.community.community.mapper;

import life.lyp.community.community.model.Question;

/**
 * ClassName:QuestionExtMapper
 * Package:life.lyp.community.community.mapper
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/15 - 15:27
 * @Version: v1.0
 */
public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}

package life.lyp.community.community.service;

import life.lyp.community.community.dto.QuestionDTO;
import life.lyp.community.community.mapper.QuestionMapper;
import life.lyp.community.community.mapper.UserMapper;
import life.lyp.community.community.model.Question;
import life.lyp.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:QuestionService
 * Package:life.lyp.community.community.service
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/12 - 22:33
 * @Version: v1.0
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}

package life.lyp.community.community.controller;

import life.lyp.community.community.dto.CommentCreateDTO;
import life.lyp.community.community.dto.CommentDTO;
import life.lyp.community.community.dto.QuestionDTO;
import life.lyp.community.community.service.CommentService;
import life.lyp.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * ClassName:QuestionController
 * Package:life.lyp.community.community.controller
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/14 - 15:56
 * @Version: v1.0
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model){
        QuestionDTO qustionDTO = questionService.getById(id);

        List<CommentDTO> comments = commentService.listByQuestionId(id);

        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question",qustionDTO);
        model.addAttribute("comments",comments);
        return "question";
    }
}

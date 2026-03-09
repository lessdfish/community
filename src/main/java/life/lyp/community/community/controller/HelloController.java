package life.lyp.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.DocFlavor;

/**
 * ClassName:HelloController
 * Package:life.lyp.community.community.controller
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/9 - 16:16
 * @Version: v1.0
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

}

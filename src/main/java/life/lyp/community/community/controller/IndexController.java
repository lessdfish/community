package life.lyp.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName:IndexController
 * Package:life.lyp.community.community.controller
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/9 - 17:39
 * @Version: v1.0
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}

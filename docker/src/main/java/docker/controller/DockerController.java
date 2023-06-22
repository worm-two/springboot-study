package docker.controller;

import entity.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("docker")
public class DockerController {

    @GetMapping("hello")
    public String say(Model model) {
        model.addAttribute("users", User.builder().name("西经无缺.尸").password("长琴无焰").build());
        return "world";
    }
}

package forum.controller;

import forum.model.User;
import forum.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {

    private final UserService users;


    public RegController(UserService users) {
        this.users = users;
    }

    @GetMapping({"/reg"})
    public String reg(Model model) {
        return "auth/reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        try {
            users.add(user);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "auth/reg";
        }
        return "redirect:/login";
    }

}

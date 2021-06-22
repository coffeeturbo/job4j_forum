package forum.controller;

import forum.model.Post;
import forum.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
    private final PostService posts;

    public PostController(PostService posts) {
        this.posts = posts;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "post/post";
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Post post) {
        posts.create(post);
        return "redirect:/post/" + post.getId();
    }
}

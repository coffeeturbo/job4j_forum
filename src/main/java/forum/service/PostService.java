package forum.service;

import forum.model.Post;
import forum.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post create(Post post) {
        return posts.save(post);
    }

    public Post findById(Long id) {
        return posts.findById(id).get();
    }
}

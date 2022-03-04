package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    private PostRepository postRepo;
    private UserRepository userRepo;

    private final EmailService emailService;

    public PostController(PostRepository postRepo, UserRepository userRepo, EmailService emailService) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsIndividualPage(@PathVariable long id, Model model) {
        Post post = postRepo.getById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsCreateSubmit(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setPost(user);
        emailService.prepareAndSend(post, post.getTitle(), post.getBody());
        return savePost(post);
    }

    @GetMapping("/posts/{id}/edit")
    public String postsEditForm(@PathVariable long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postRepo.getById(id);
     if (user.getId() == post.getPost().getId()) {
            model.addAttribute("post", post);
            return "posts/edit";
        } else {
            return "redirect:posts/";
        }

 }

//    @GetMapping("posts/{id}/edit")
// public String showEdit(@PathVariable long id, Model model) {
//    Post postEdit = postsDao.getById(id);
//    User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    if (postEdit.getUser().getId() == loggedInUser.getId()) {
//        model.addAttribute("postEdit", postEdit);
//        return "posts/edit";
//    }else {
//        return "redirect:/posts";
//    }


//

    @PostMapping("/posts/{id}/edit")
    public String postsEditSubmit(@PathVariable long id, @ModelAttribute Post post) {
        post.setPost((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return savePost(post);
    }

    @GetMapping("/posts/{id}/delete")
    public String deleteGet(@PathVariable long id) {
        Post post = postRepo.getById(id);
        postRepo.delete(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        Post post = postRepo.getById(id);
        postRepo.delete(post);
        return "redirect:/posts";
    }

    private String savePost(Post post) {
        postRepo.save(post);
        return "redirect:/posts";
    }
}

















//import com.codeup.springblog.models.Post;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import repositories.PostRepository;
//
//@Controller
//public class PostController{
//    private PostRepository postsDao;
//
//    public PostController(PostRepository postsDao) {
//        this.postsDao = postsDao;
//    }
//
//    @GetMapping("/posts")
//    @ResponseBody
//    public String viewPost(){
//        return "post/index";
//    }
//
//
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String postDetails(@PathVariable long id){
//        return "post/show";
//
//    }
//
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String showCreateForm(){
//        return "view form for post creation";
//
//    }
//
//    @PostMapping("/posts")
//    @ResponseBody
//
//    public String submitCreateForm(){
//        return "view submit form creation";
//    }
//
//}
//






//instructor's own solution

//package com.codeup.regulusspringblog.controllers;
//
//        import com.codeup.regulusspringblog.models.Post;
//        import com.codeup.regulusspringblog.models.User;
//        import com.codeup.regulusspringblog.repositories.PostRepository;
//        import com.codeup.regulusspringblog.repositories.UserRepository;
//        import com.codeup.regulusspringblog.services.EmailService;
//        import org.springframework.security.core.context.SecurityContextHolder;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.ui.Model;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Controller
//public class PostController {
//    private PostRepository postsDao;
//    private UserRepository usersDao;
//    private EmailService emailService;
//
//    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
//        this.postsDao = postsDao;
//        this.usersDao = usersDao;
//        this.emailService = emailService;
//    }
//
//    @GetMapping("/posts")
//    public String viewPosts(Model model) {
//        model.addAttribute("allPosts", postsDao.findAll());
//
//        return "posts/index";
//    }
//
//
//    @GetMapping("/posts/{id}")
//    public String postDetails(@PathVariable long id, Model model) {
//        model.addAttribute("singlePost", postsDao.getById(id));
//        return "posts/show";
//    }
//
//
//    @GetMapping("/posts/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("newPost", new Post());
//        return "posts/create";
//    }
//
//
//    @PostMapping("/posts/create")
//    public String submitCreateForm(@ModelAttribute Post newPost) {
//        newPost.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        emailService.prepareAndSend(newPost, "New post created", "You had posted to our blog!");
//        postsDao.save(newPost);
//
//        return "redirect:/posts";
//    }
//
//    @GetMapping("/posts/{id}/edit")
//    public String showEditForm(@PathVariable long id, Model model) {
//        Post posttoEdit = postsDao.getById(id);
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (posttoEdit.getUser().getId() == loggedInUser.getId()) {
//            model.addAttribute("postToEdit", posttoEdit);
//            return "posts/edit";
//        } else {
//            return "redirect:/posts";
//        }
//    }
//    // We can access the values submitted from the form using our @RequestParam annotation
//    @PostMapping("/posts/{id}/edit")
//    public String submitEdit(@ModelAttribute Post postToEdit, @PathVariable long id) {
//        if (postsDao.getById(id).getUser().getId() == ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()) {
//            postToEdit.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//            // grab the post from our DAO
////    Post postToEdit = postsDao.getById(id);
//            // use setters to set new values to the object
////    postToEdit.setTitle(title);
////    postToEdit.setBody(body);
//            // save the object with new values
//            postsDao.save(postToEdit);
//        }
//
//        return "redirect:/posts";
//
//    }
//
//    // For now, we need to use a GetMapping, that way, when we visit the page,
//    // our app can access the path variable, then delete the post, then redirect
//    // us back to the post index page.
//    @GetMapping("/posts/{id}/delete")
//    public String delete(@PathVariable long id) {
//        postsDao.deleteById(id);
//        return "redirect:/posts";
//    }
//}




// testing framework

//import com.codeup.springblog.models.Post;
////import com.codeup.springblog.repositories.PostRepository;
//import com.codeup.springblog.models.User;
//import com.codeup.springblog.services.EmailService;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import com.codeup.springblog.repositories.PostRepository;
//import com.codeup.springblog.repositories.UserRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class PostController {
//   private PostRepository postsDao;
//    private UserRepository userDao;
//    private final EmailService emailService;
//
//
//    public PostController(PostRepository postsDao, UserRepository userDao, EmailService emailService) {
//        this.postsDao = postsDao;
//        this.userDao = userDao;
//        this.emailService = emailService;
//    }
//
//    @GetMapping("/posts")
//    public String viewPosts(Model model) {
//        List<Post> allPosts = new ArrayList<>();
//        Post p2 = new Post(2, "Test", "This is for testing purposes");
//        Post p3 = new Post(3, "Weather Update", "It's gon rain");
//        Post p4 = new Post(4, "Codeup", "Join codeup today and get your career launched in tech!");
//
//        allPosts.add(p2);
//        allPosts.add(p3);
//        allPosts.add(p4);
//
//        model.addAttribute("allPosts", allPosts);
//
//        return "posts/index";
//    }
//
//
//    @GetMapping("/posts/{id}")
//    public String postDetails(@PathVariable long id, Model model) {
//        Post p1 = new Post(1, "Regulus Spring", "Hello, we are currently learning views in Spring!");
//        model.addAttribute("singlePost", p1);
//
//        return "posts/show";
//    }
//
//
//    @GetMapping("/posts/create")
//    public String showCreateForm() {
//
//        return "posts/create";
//    }
//
//
//    @PostMapping("/posts/create")
//    public String submitCreateForm(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
//        Post newPost = new Post(title, body);
//       // newPost.setUser(userDao.getById(1L));
//        newPost.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());// from the curriculum
//        emailService.prepareAndSend(newPost,"Create new post","you have created an email");
//        postsDao.save(newPost);
//
//        return "redirect:/posts";
//    }
//
//    @GetMapping("/posts/{id}/edit")
//    public String showEditForm(@PathVariable long id, Model model) {
//        Post posttoEdit = postsDao.getById(id);
//        posttoEdit.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());// from the curriculum
//        User logInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(posttoEdit.getUser().getId() == logInUser.getId) {
//            model.addAttribute("postToEdit", posttoEdit);
//            return "posts/edit";
//        } else {
//            return "redirect:/posts";
//        }
//    }
//    // We can access the values submitted from the form using our @RequestParam annotation
//    @PostMapping("/posts/{id}/edit")
//    public String submitEdit(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @PathVariable long id) {
//
//        // grab the post from our DAO
//        Post postToEdit = postsDao.getById(id);
//        // use setters to set new values to the object
//        postToEdit.setTitle(title);
//        postToEdit.setBody(body);
//        // save the object with new values
//        postsDao.save(postToEdit);
//        return "redirect:/posts";
//    }
//
//    // For now, we need to use a GetMapping, that way, when we visit the page,
//    // our app can access the path variable, then delete the post, then redirect
//    // us back to the post index page.
//    @GetMapping("/posts/{id}/delete")
//    public String delete(@PathVariable long id) {
//        postsDao.deleteById(id);
//        return "redirect:/posts";
//    }
//}


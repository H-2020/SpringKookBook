package be.intec.SpringCookBook03.controllers;


import be.intec.SpringCookBook03.models.Post;
import be.intec.SpringCookBook03.services.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // Generates an activity logger using LOMBOK
@RequiredArgsConstructor // Dependency Injection using LOMBOK
@RestController // Marks this class as a request and response listener
@RequestMapping ( path = "/posts" ) // Only mappings under this URL will be
//accepted
public class PostController {

    private final PostService postService;

    @GetMapping ( path = "/get-all" )
   // @ResponseStatus ( HttpStatus.FOUND )
    public List< Post > getAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping ( path = "/today" )
   // @ResponseBody
    public List< Post > getAllPostsOfToday() {
        return postService.findAllPostsPublishedToday();
    }
    // {author_id} will be read from the path variables
// to send a post request using author_id = 1, we just need to pass path
  //  variable as the following:
// for example: http://localhost:8080/1

    @PostMapping
   // @ResponseBody
    public Post addPost(@RequestBody Post post ) {
        return postService.createNewPost( post );
    }
}
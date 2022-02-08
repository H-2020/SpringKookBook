package be.intec.SpringCookBook03.services;

import be.intec.SpringCookBook03.models.Author;
import be.intec.SpringCookBook03.models.Post;
import be.intec.SpringCookBook03.repositories.IAuthorRepo;
import be.intec.SpringCookBook03.repositories.IPostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
// AIM: IMPLEMENT REQUIREMENTS & BUSINESS LOGIC
@RequiredArgsConstructor // WE CAN USE LOMBOK TO PROVIDE DEPENDENCY INJECTION
//FOR THIS CLASS
@Service
public class PostService {
    // @Autowired
    private final IPostRepo postRepo;
    private final IAuthorRepo authorRepo;
    /**
     * @param authorId existing author_id
     * @param post post data with title, content etc.
     * @return saved post entity.
     */
// SAVE_NEW_POST_TO_DATABASE
    public Post createNewPost( Post post ) {
// if author exists it will just save the new post
//        if ( authorId != null && authorRepo.findById( authorId ).isPresent() ) {
//            return postRepo.save( post );
//        } else {
// if the author does NOT exist, it will save the new author first,
// then accordingly, it will save the new post.
            Author authorToSave = post.getAuthor();
            authorRepo.save( authorToSave );
            post.setPublishedAt(LocalTime.now());
            post.setPublishedOn(LocalDate.now());
            postRepo.save( post );

      //  }

        return post;
    }
    /**
     * @param postId existing post matching with post_id
     */
    public void deletePostById( Integer postId ) {
        postRepo.deleteById( postId );
    }
    /**
     * @return all posts exist
     */
    public List< Post > findAllPosts() {
        return postRepo.findAll();
    }
    /**
     * @return all posts published today
     */
    public List< Post > findAllPostsPublishedToday() {
        return postRepo.findAllByPublishedOnBetween( LocalDate.now(),
                LocalDate.now() );
    }
    /**
     * @param authorId existing author matching with author_id
     * @return all posts that are written by a certain author
     */
    public List< Post > findAllPostsByAuthor( Integer authorId ) {
        return postRepo.findAllByAuthor( authorId );
    }


}
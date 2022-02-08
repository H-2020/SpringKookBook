package be.intec.SpringCookBook03.repositories;

import be.intec.SpringCookBook03.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
// Smart Interface: The extension will provide us basic features of JPA (such as
//save(), findAll() etc.)
// JpaRepository < Entity Class, PrimaryKey >
public interface IPostRepo extends JpaRepository<Post, Integer > {
    // We can also customise JPA queries using @Query annotation with JPQL (JPA
    // query language).
    @Query ( "select p from Post p where p.author.id = :author_id" )
    List<Post> findAllByAuthor( @Param ( "author_id" ) final Integer author_id
    );

    // We can also use Spring JPA query building rules (context) to quickly
   // generate methods without even needing JPQL
    List<Post> findAllByPublishedOnBetween( final LocalDate start, final
    LocalDate end );
}
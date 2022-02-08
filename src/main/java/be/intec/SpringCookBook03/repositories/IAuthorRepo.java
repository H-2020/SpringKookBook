package be.intec.SpringCookBook03.repositories;


import be.intec.SpringCookBook03.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepo extends JpaRepository<Author, Integer > {
}
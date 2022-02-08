package be.intec.SpringCookBook03.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String title;
    @Column ( unique = true )
    private String slug;
    private String content;
    private Integer readCount;
    private LocalDate publishedOn;
    private LocalTime publishedAt;

    @ManyToOne
    @JoinColumn ( name = "author_id", nullable = false )
    private Author author;

    @Override
    public String toString() {
        return this.getTitle();

    }
}

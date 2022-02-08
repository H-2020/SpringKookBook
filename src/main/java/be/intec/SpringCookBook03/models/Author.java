package be.intec.SpringCookBook03.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String email;
    private String passcode;
    private Boolean authenticated;


}
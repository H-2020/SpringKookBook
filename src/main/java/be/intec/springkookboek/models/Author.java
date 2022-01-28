package be.intec.springkookboek.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
}

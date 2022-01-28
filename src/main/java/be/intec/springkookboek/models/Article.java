package be.intec.springkookboek.models;

import be.intec.springkookboek.configs.CustomSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "article")
public class Article {
    @JsonProperty
    private String title;
    @JsonProperty
    private Date publicationDate;
    @JsonProperty
    @JacksonXmlElementWrapper(localName = "authors")
    @JacksonXmlProperty(localName = "author")
    private List<Author> authors;
    @JsonProperty
    @JsonSerialize(using = CustomSerializer.class)
    private String content;
}

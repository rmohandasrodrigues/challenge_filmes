package br.com.webfilmes.challengeweb.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class FilmeVO {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

}

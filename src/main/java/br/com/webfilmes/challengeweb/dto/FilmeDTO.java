package br.com.webfilmes.challengeweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FilmeDTO {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;
}

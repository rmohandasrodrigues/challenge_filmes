package br.com.webfilmes.challengeweb.vo;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;


@Data
public class FilmeVO extends RepresentationModel {
    private Long id;
    private String title;
    private String year;
}

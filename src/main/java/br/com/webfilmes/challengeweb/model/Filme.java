package br.com.webfilmes.challengeweb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "filmes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String title;

    @Column(name = "ano")
    private String year;
}

package br.com.webfilmes.challengeweb.repository;

import br.com.webfilmes.challengeweb.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}

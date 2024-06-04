package br.com.webfilmes.challengeweb.service;

import br.com.webfilmes.challengeweb.converter.FilmeConverter;
import br.com.webfilmes.challengeweb.dto.FilmeDTO;
import br.com.webfilmes.challengeweb.http.FilmeClientOMDBFeing;
import br.com.webfilmes.challengeweb.vo.FilmeOMDB;
import br.com.webfilmes.challengeweb.model.Filme;
import br.com.webfilmes.challengeweb.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Value("${imdb.apikey}")
    private String apiKey;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private FilmeClientOMDBFeing filmeClientFeing;

    @Autowired
    private FilmeConverter filmeConverter;

    public FilmeOMDB getFilme(String tema) {
        return filmeClientFeing.getFilme(tema, apiKey);
    }

    public Filme save(FilmeDTO filmeDTO){
        Filme filme = filmeConverter.converterParaFilme(filmeDTO);
        return filmeRepository.save(filme);
    }

    public Filme getById(Long id) {
        return filmeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Filme não encontrado!"));
    }
}

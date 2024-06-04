package br.com.webfilmes.challengeweb.converter;

import br.com.webfilmes.challengeweb.dto.FilmeDTO;
import br.com.webfilmes.challengeweb.model.Filme;
import br.com.webfilmes.challengeweb.vo.FilmeVO;
import org.springframework.stereotype.Component;

@Component
public class FilmeConverter {

    public Filme converterParaFilme(FilmeDTO filmeDTO){
        Filme filme = new Filme();
        filme.setTitle(filmeDTO.getTitle());
        filme.setYear(filmeDTO.getYear());
        return filme;
    }

    public FilmeVO converterParaFilmeVO(Filme filme){
        FilmeVO filmeVO = new FilmeVO();
        filmeVO.setTitle(filme.getTitle());
        filmeVO.setYear(filme.getYear());
        return filmeVO;
    }


}

package br.com.webfilmes.challengeweb.controller;

import br.com.webfilmes.challengeweb.converter.FilmeConverter;
import br.com.webfilmes.challengeweb.dto.FilmeDTO;
import br.com.webfilmes.challengeweb.service.FilmeService;
import br.com.webfilmes.challengeweb.vo.FilmeOMDB;
import br.com.webfilmes.challengeweb.vo.FilmeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private static final Logger logger = LoggerFactory.getLogger(FilmeController.class);

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private FilmeConverter filmeConverter;

    @GetMapping("/omdb/{tema}")
    public ResponseEntity<FilmeOMDB> getFilme(@PathVariable String tema) {
        try {
            FilmeOMDB filmeOMDB = filmeService.getFilme(tema);
            if (filmeOMDB == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(filmeOMDB);
        } catch (Exception e) {
            logger.error("Erro ao buscar o filme: " + tema, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<FilmeVO> saveFilme(@RequestBody FilmeDTO filmeDTO){
        try {
            FilmeVO filmeVO = filmeConverter.converterParaFilmeVO(filmeService.save(filmeDTO));

            //Cria o link no retorno do filme criado.
            addHateoas(filmeVO);
            return ResponseEntity.status(HttpStatus.CREATED).body(filmeVO);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeVO> getById(@PathVariable("id") Long id){
        try{
            FilmeVO filmeVO = filmeConverter.converterParaFilmeVO(filmeService.getById(id));
            return ResponseEntity.ok(filmeVO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void addHateoas(FilmeVO filmeVO) {
        filmeVO.add(linkTo(methodOn(FilmeController.class).getById(filmeVO.getId())).withSelfRel());
    }
}

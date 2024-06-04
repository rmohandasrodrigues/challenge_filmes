package br.com.webfilmes.challengeweb.http;

import br.com.webfilmes.challengeweb.config.FeignConfig;
import br.com.webfilmes.challengeweb.vo.FilmeOMDB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "omdbFilmes", url = "https://www.omdbapi.com", configuration = FeignConfig.class)
public interface FilmeClientOMDBFeing {

    @RequestMapping(method = RequestMethod.GET)
    FilmeOMDB getFilme(@RequestParam("t") String tema, @RequestParam("apikey") String key);

}

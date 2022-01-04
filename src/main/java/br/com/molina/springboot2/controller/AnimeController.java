package br.com.molina.springboot2.controller;

import br.com.molina.springboot2.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
public class AnimeController {
    //localhost:8080/list
    @GetMapping(path = "list")
    public List<Anime> list() {
        return List.of(new Anime("DBZ"), new Anime("Berserk"));
    }
}

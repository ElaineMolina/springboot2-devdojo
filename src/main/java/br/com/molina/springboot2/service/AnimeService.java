package br.com.molina.springboot2.service;

import br.com.molina.springboot2.domain.Anime;
import br.com.molina.springboot2.exception.BadRequestException;
import br.com.molina.springboot2.mapper.AnimeMapper;
import br.com.molina.springboot2.repository.AnimeRepository;
import br.com.molina.springboot2.request.AnimePostRequestBody;
import br.com.molina.springboot2.request.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable){
        return  animeRepository.findAll(pageable);
    }
    public List<Anime> findByName(String name){

        return  animeRepository.findByName(name);
    }


    public Anime findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("Animes not Found"));
    }
    @Transactional
    public Anime save(AnimePostRequestBody animePostResquestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostResquestBody));
    }

    public void delete(long id) {
    animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime((animePutRequestBody));
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
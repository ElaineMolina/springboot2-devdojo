package br.com.molina.springboot2.mapper;

import br.com.molina.springboot2.domain.Anime;
import br.com.molina.springboot2.domain.Anime.AnimeBuilder;
import br.com.molina.springboot2.request.AnimePostRequestBody;
import br.com.molina.springboot2.request.AnimePutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-25T16:06:11-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AnimeMapperImpl extends AnimeMapper {

    @Override
    public Anime toAnime(AnimePostRequestBody animePostRequestBody) {
        if ( animePostRequestBody == null ) {
            return null;
        }

        AnimeBuilder anime = Anime.builder();

        anime.name( animePostRequestBody.getName() );

        return anime.build();
    }

    @Override
    public Anime toAnime(AnimePutRequestBody animePostRequestBody) {
        if ( animePostRequestBody == null ) {
            return null;
        }

        AnimeBuilder anime = Anime.builder();

        anime.id( animePostRequestBody.getId() );
        anime.name( animePostRequestBody.getName() );

        return anime.build();
    }
}

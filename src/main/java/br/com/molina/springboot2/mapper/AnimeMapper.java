package br.com.molina.springboot2.mapper;

import br.com.molina.springboot2.domain.Anime;
import br.com.molina.springboot2.request.AnimePostRequestBody;
import br.com.molina.springboot2.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimePostRequestBody animePostBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
package br.com.molina.springboot2.util;

import br.com.molina.springboot2.request.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createAnimePutRequestBody() {
        return AnimePutRequestBody.builder()
                .name(AnimeCreator.createValidUpdateAnime().getName())
                .id(AnimeCreator.createValidUpdateAnime().getId())
                .build();

    }
}

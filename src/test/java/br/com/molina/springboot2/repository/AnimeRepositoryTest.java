package br.com.molina.springboot2.repository;

import br.com.molina.springboot2.domain.Anime;
import br.com.molina.springboot2.util.AnimeCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persist anime when Successful")
    void save_PersistAnime_WhenSuccessful() {
        Anime createAnimeToBeSaved = AnimeCreator.createAnimeToBeSaved();
        Anime animeSaved = this.animeRepository.save(createAnimeToBeSaved);
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(createAnimeToBeSaved.getName());

    }

    @Test
    @DisplayName("Save update anime when Successful")
    void Update_PersistAnime_WhenSuccessful() {
        Anime createAnimeToBeSaved = AnimeCreator.createAnimeToBeSaved();
        Anime animeSaved = this.animeRepository.save(createAnimeToBeSaved);
        animeSaved.setName("Overlord");
        Anime animeUpdate = this.animeRepository.save(animeSaved);

        Assertions.assertThat(animeUpdate).isNotNull();
        Assertions.assertThat(animeUpdate.getId()).isNotNull();
        Assertions.assertThat(animeUpdate.getName()).isEqualTo(animeUpdate.getName());

    }

    @Test
    @DisplayName("Delete remove anime when Successful")
    void delete_RemovesAnime_WhenSuccessful() {
        Anime createAnimeToBeSaved = AnimeCreator.createAnimeToBeSaved();
        Anime animeSaved = this.animeRepository.save(createAnimeToBeSaved);
        this.animeRepository.delete(animeSaved);
        Optional<Anime> animeOptional = this.animeRepository.findById(animeSaved.getId());
        Assertions.assertThat(animeOptional.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Find By Name returns list anime when Successful")
    void findByName_ReturnListOfAnime_WhenSuccessful() {
        Anime createAnimeToBeSaved = AnimeCreator.createAnimeToBeSaved();
        Anime animeSaved = this.animeRepository.save(createAnimeToBeSaved);
        String name = animeSaved.getName();
        List<Anime> animes = this.animeRepository.findByName(name);
        Assertions.assertThat(animes)
                .isNotEmpty()
                .contains(animeSaved);
    }
    @Test
    @DisplayName("Find By Name returns empty list when no  anime when found")
    void findByName_ReturnEmptyist_WhenAnimeIsNotFound() {
        List<Anime> animes = this.animeRepository.findByName("nãoexisteteste");
        Assertions.assertThat(animes).isEmpty();
    }
    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void save_ThrowConstrainVaiolationException_WhenNameIsEmpty() {
        Anime anime = new Anime();
//        Assertions.assertThatThrownBy(() -> this.animeRepository.save(anime))
//            .isInstanceOf(ConstraintViolationException.class);

            Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                    .isThrownBy(() -> this.animeRepository.save(anime))
                    .withMessageContaining("The anime name cannot be empty");

    }


}
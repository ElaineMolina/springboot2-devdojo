package br.com.molina.springboot2.repository;

import br.com.molina.springboot2.domain.Anime;
import br.com.molina.springboot2.domain.MolinaUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MolinaUserRepository extends JpaRepository<MolinaUser, Long> {

    MolinaUser findByUsername(String name);

}


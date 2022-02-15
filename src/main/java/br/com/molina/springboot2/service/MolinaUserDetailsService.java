package br.com.molina.springboot2.service;

import br.com.molina.springboot2.repository.MolinaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MolinaUserDetailsService implements UserDetailsService {
    private final MolinaUserRepository molinaUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(molinaUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Molina User not found "));
    }
}
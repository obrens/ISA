package isa.projekat.service;

import isa.projekat.model.CustomUserDetails;
import isa.projekat.model.Korisnik;
import isa.projekat.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Korisnik> optionalKorisnik=korisnikRepository.findByImejl(username);
        optionalKorisnik.orElseThrow(()->new UsernameNotFoundException("Korisnicki imejl nije pronadjen"));
        return optionalKorisnik.map( CustomUserDetails::new).get();
    }
}

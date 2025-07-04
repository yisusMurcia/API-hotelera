package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsJpa implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByNombreUsuario(username)
                .map(user -> User.builder()
                .username(user.getNombreUsuario()).password(user.getPassword())
                .authorities("ROLE-USER").build())
                .orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username));
    }
}

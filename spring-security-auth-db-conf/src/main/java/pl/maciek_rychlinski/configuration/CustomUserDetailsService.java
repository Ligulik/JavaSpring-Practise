package pl.maciek_rychlinski.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.maciek_rychlinski.models.User;
import pl.maciek_rychlinski.models.UserRole;
import pl.maciek_rychlinski.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;


/**
 * Configuracja autoryzacji, poprzez zaimplementowanie UserDetailsService
 *
 * nadpisuje loadUserByUsername
 * w polu Username podaje żądaną przeze mnie wartość podlegającą sprawdzeniu
 * sprawdzam czy uzytkownik o takim e-mail i hasle istnieje - jezeli tak to loguje go
 *
 * converter sluzy do zamiany zwyklego set'a na set dla springa <GrantedAuthority>
 */

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        org.springframework.security.core.userdetails.User userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        convertAuthorities(user.getRoles()));
        return userDetails;

    }


    public Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles){
        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        for(UserRole user:userRoles){
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        }
    return grantedAuthorities;
    }
}

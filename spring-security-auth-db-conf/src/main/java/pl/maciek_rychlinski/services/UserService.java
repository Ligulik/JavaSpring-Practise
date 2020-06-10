package pl.maciek_rychlinski.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.maciek_rychlinski.models.User;
import pl.maciek_rychlinski.models.UserRole;
import pl.maciek_rychlinski.repositories.UserRepository;
import pl.maciek_rychlinski.repositories.UserRoleRepository;

@Service
public class UserService {

    private static final String DEFAULT_ROLE="ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;


    /**
     *
     * szyfrowanie za pomocą passwordEncodera
     * Musze stworzyc jego bean w konfiguracji zabezpieczen
     * szyfruje on hasla w bazie danych
     */

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository){
        this.userRoleRepository=userRoleRepository;
    }


    public void addWithDefaultRole(User user){
        UserRole defaultRole=userRoleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        String passwordHash=passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }
}

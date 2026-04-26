package lt.techin.taskmanager.authconfig;

import lt.techin.taskmanager.model.user.Role;
import lt.techin.taskmanager.model.user.User;
import lt.techin.taskmanager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedUsers (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            createUserIfMissing(userRepository, passwordEncoder, "admin@example.com", "admin123", Set.of(Role.ADMIN, Role.USER));
        };
    }

    private static void createUserIfMissing(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            String email,
            String rawPassword,
            Set<Role> roles
    ) {
        if (userRepository.existsByEmail(email)) {
            return;
        }

        userRepository.save(new User(email, passwordEncoder.encode(rawPassword), roles));
    }
}

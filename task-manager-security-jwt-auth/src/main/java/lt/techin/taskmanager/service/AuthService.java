package lt.techin.taskmanager.service;

import lt.techin.taskmanager.dto.auth.AuthResponse;
import lt.techin.taskmanager.dto.auth.LoginRequest;
import lt.techin.taskmanager.exception.customexception.DuplicateEmailException;
import lt.techin.taskmanager.exception.customexception.InvalidCredentialsException;
import lt.techin.taskmanager.exception.customexception.UserNotFoundException;
import lt.techin.taskmanager.model.JwtToken;
import lt.techin.taskmanager.model.user.Role;
import lt.techin.taskmanager.model.user.User;
import lt.techin.taskmanager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
    }

    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException(user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.USER));

        return userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {
        User existingUser = userRepository.findByEmail(request.email())
                .orElseThrow(InvalidCredentialsException::new);

        if(!passwordEncoder.matches(request.password(), existingUser.getPassword())) {
            throw new InvalidCredentialsException();
        }

        JwtToken token = jwtTokenService.createToken(existingUser);

        return new AuthResponse(
                "Bearer",
                token.value(),
                token.expiresAt(),
                existingUser.getEmail(),
                List.of(existingUser.getRoles() + "")
        );
    }
}

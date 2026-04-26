package lt.techin.taskmanager.dto.user;

import lt.techin.taskmanager.model.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class UserMapper {

    public User toUser(CreateUserRequest request) {
        User user = new User();

        user.setName(request.name());
        user.setEmail(request.email());

        return user;
    }

    public User toUser(UpdateUserRequest request, Long id) {
        User user = new User();

        user.setId(id);
        user.setName(request.name());
        user.setEmail(request.email());

        return user;
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRoles()
        );
    }

    public List<UserResponse> toResponseList(List<User> users) {
        List<UserResponse> responses = new ArrayList<>();

        for (User user : users) {
            responses.add(toResponse(user));
        }

        return responses;
    }

    public UserSummaryResponse toResponseUserSummary(User user) {
        return new UserSummaryResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}

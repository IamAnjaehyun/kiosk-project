package com.example.kiosk.dto.auth;
import com.example.kiosk.domain.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignupDto {
    private String username;
    private String password;
    private String name;
    private String role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .role(role)
                .build();
    }
}
package com.garby.dashboard.models;

import com.garby.dashboard.enums.Role;
import jakarta.persistence.*;
import lombok.*;

// import javax.security.enterprise.credential.Password;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;

    //    @Enumerated(EnumType.STRING)
    //    private Role role;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}
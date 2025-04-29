package com.garby.dashboard.services;


import com.garby.dashboard.models.User;
import org.springframework.security.core.userdetails.*;
import com.garby.dashboard.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

//        return new User(
        return new org.springframework.security.core.userdetails.User(       // Todo: done => returned fully qualified name.
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        // .collect(Collectors.toSet())
                        .collect(Collectors.toList()) // <-- Must return a Collection
        );
    }
}

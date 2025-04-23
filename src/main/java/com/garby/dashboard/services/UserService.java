package com.garby.dashboard.services;



import com.garby.dashboard.domains.requests.UserRequest;
import com.garby.dashboard.domains.responses.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
    Page<UserResponse> getUsersPage(int page, int size);
}

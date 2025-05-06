package com.secure.notes.services;

import com.secure.notes.models.User;
import com.secure.notes.dtos.UserDTO;

import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);
    List<User> getAllUsers();
    UserDTO getUserBy(Long id);
}

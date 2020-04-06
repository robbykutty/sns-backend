package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.User;

public interface UserService {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean activateUser(UUID userId);
	public boolean deactivateUser(UUID userId);
	public User getUserById(UUID userId);
	public List<User> getAllUsers();
}

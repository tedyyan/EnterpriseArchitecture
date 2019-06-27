package edu.mum.service;

import java.util.List;

import edu.mum.domain.User;
 
public interface UserService {
	public void flush();
	public void delete(Long id);
	public void update(User user);
	public void save(User user);
	public List<User> findAll();
	public User findByEmail(String email);
}

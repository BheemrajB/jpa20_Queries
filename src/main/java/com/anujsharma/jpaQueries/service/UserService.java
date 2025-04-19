package com.anujsharma.jpaQueries.service;

import com.anujsharma.jpaQueries.entity.User;
import com.anujsharma.jpaQueries.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public List<User> getUsersByName(String name) {
        return repository.findByName(name);
    }

    public List<User> getUsersAboveAge(int age) {
        return repository.findByAgeGreaterThan(age);
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public int getTotalUsers() {
        return repository.countUsers();
    }

    public double getAverageAge() {
        return repository.averageAge();
    }

    public List<User> getUsersSortedByAge() {
        return repository.findUsersSortedByAgeDesc();
    }

    public List<User> getUsersWithPagination(int limit, int offset) {
        return repository.findUsersWithPagination(limit, offset);
    }

    public User getOldestUser() {
        return repository.findOldestUser();
    }

    public User getYoungestUser() {
        return repository.findYoungestUser();
    }

    public List<User> getUsersByNameAndAge(String name, int age) {
        return repository.findByNameAndAge(name, age);
    }

    public int countUsersWithAge(int age) {
        return repository.countUsersWithAge(age);
    }

    public List<User> getUsersOlderThan30() {
        return repository.findUsersOlderThan30();
    }

    public List<User> getUsersByAgeRange(int min, int max) {
        return repository.findByAgeBetween(min, max);
    }

    public List<User> getUsersByNameKeyword(String keyword) {
        return repository.findByNameContaining(keyword);
    }

    public List<User> getUsersByEmailDomain(String domain) {
        return repository.findByEmailDomain(domain);
    }

    public List<User> getUsersWithNoName() {
        return repository.findUsersWithNoName();
    }

    public List<User> getUsersWithAverageAge() {
        return repository.findUsersWithAverageAge();
    }
}

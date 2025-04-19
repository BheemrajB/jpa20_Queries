package com.anujsharma.jpaQueries.controller;

import com.anujsharma.jpaQueries.entity.User;
import com.anujsharma.jpaQueries.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    public final UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/name/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return service.getUsersByName(name);
    }

    @GetMapping("/above/{age}")
    public List<User> getUsersAboveAge(@PathVariable int age) {
        return service.getUsersAboveAge(age);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }

    @GetMapping("/count")
    public int getTotalUsers() {
        return service.getTotalUsers();
    }

    @GetMapping("/average")
    public double getAverageAge() {
        return service.getAverageAge();
    }

    @GetMapping("/sorted")
    public List<User> getUsersSortedByAge() {
        return service.getUsersSortedByAge();
    }

    @GetMapping("/pagination")
    public List<User> getUsersWithPagination(@RequestParam int limit, @RequestParam int offset) {
        return service.getUsersWithPagination(limit, offset);
    }

    @GetMapping("/oldest")
    public User getOldestUser() {
        return service.getOldestUser();
    }

    @GetMapping("/youngest")
    public User getYoungestUser() {
        return service.getYoungestUser();
    }

    @GetMapping("/name-age")
    public List<User> getUsersByNameAndAge(@RequestParam String name, @RequestParam int age) {
        return service.getUsersByNameAndAge(name, age);
    }

    @GetMapping("/count/age/{age}")
    public int countUsersWithAge(@PathVariable int age) {
        return service.countUsersWithAge(age);
    }

    @GetMapping("/older-than-30")
    public List<User> getUsersOlderThan30() {
        return service.getUsersOlderThan30();
    }

    @GetMapping("/age-range")
    public List<User> getUsersByAgeRange(@RequestParam int min, @RequestParam int max) {
        return service.getUsersByAgeRange(min, max);
    }

    @GetMapping("/search")
    public List<User> getUsersByNameKeyword(@RequestParam String keyword) {
        return service.getUsersByNameKeyword(keyword);
    }

    @GetMapping("/email-domain")
    public List<User> getUsersByEmailDomain(@RequestParam String domain) {
        return service.getUsersByEmailDomain(domain);
    }

    @GetMapping("/no-name")
    public List<User> getUsersWithNoName() {
        return service.getUsersWithNoName();
    }

    @GetMapping("/average-age-users")
    public List<User> getUsersWithAverageAge() {
        return service.getUsersWithAverageAge();
    }

}

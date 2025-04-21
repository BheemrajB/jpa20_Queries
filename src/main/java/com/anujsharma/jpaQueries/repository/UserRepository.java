package com.anujsharma.jpaQueries.repository;

import com.anujsharma.jpaQueries.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByName(String name);
    List<User> findByAgeGreaterThan(int age);
    User findByEmail(String email);

    @Query("SELECT COUNT(u) FROM User u")
    int countUsers();

    @Query("SELECT AVG(u.age) FROM User u")
    double averageAge();

    List<User> findByAge(int age);

    @Query("SELECT u FROM User u ORDER BY u.age DESC")
    List<User> findUsersSortedByAgeDesc();

    @Query(value = "SELECT * FROM users LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<User> findUsersWithPagination(@Param("limit") int limit, @Param("offset") int offset);

    @Query("SELECT u FROM User u WHERE u.age = (SELECT MAX(u2.age) FROM User u2)")
    User findOldestUser();

    @Query("SELECT u FROM User u WHERE u.age = (SELECT MIN(u2.age) FROM User u2)")
    User findYoungestUser();

    List<User> findByNameAndAge(String name, int age);

    @Query("SELECT COUNT(u) FROM User u WHERE u.age = :age")
    int countUsersWithAge(@Param("age") int age);

    @Query("SELECT u FROM User u WHERE u.age > 30")
    List<User> findUsersOlderThan30();

    List<User> findByAgeBetween(int min, int max);

    List<User> findByNameContaining(String keyword);

    @Query("SELECT u FROM User u WHERE u.email LIKE %:domain")
    List<User> findByEmailDomain(@Param("domain") String domain);

    @Query("SELECT u FROM User u WHERE u.name IS NULL")
    List<User> findUsersWithNoName();

    @Query("SELECT u FROM User u WHERE u.age = FUNCTION('ROUND', (SELECT AVG(u2.age) FROM User u2))")
    List<User> findUsersWithAverageAge();

}

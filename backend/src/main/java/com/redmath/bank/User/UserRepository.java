package com.redmath.bank.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUserName(String userName);
//
//    @Query(value = "SELECT u FROM Users u WHERE u.userName = ?1")
//    User findByUserName2(String userName);
//@Query(value = "SELECT * FROM User WHERE userName = :userName", nativeQuery = true)
//User findByUserName(@Param("userName") String userName);


}

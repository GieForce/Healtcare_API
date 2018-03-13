package com.pharmacy.healthcare.repository;

import com.pharmacy.healthcare.domain.Patient;
import com.pharmacy.healthcare.domain.User;
import com.pharmacy.healthcare.domain.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUsername(String username);
    @Query(value = "select * from users u inner join users_tokens uts on u.user_id = uts.user_user_id inner join user_token ut on uts.tokens_id = ut.id where token = :token", nativeQuery = true)
    User findAllByToken(@Param("token") String token);
}

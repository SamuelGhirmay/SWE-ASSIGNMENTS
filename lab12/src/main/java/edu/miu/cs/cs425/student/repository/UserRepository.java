package edu.miu.cs.cs425.student.repository;

import edu.miu.cs.cs425.student.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findUserByUserName(String userName);
}

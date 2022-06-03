package com.dinel13.belajar.java.ws;

import com.dinel13.belajar.java.ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
//    UserEntity findUserByEmail(String email);
    // sudah ready to use karena extend dari parent
    UserEntity findByEmail(String email);
}

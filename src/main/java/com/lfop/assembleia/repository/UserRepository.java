package com.lfop.assembleia.repository;

import com.lfop.assembleia.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    UserModel findByLogin(String login);
}

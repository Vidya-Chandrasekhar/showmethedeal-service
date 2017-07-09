package com.vcs.shoppingbuddy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcs.shoppingbuddy.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	@Query(value = "select * from users where email = ?1", nativeQuery = true)
	List<User> findUserByemailId(String email);

	
}

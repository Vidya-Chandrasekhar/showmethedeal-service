package com.vcs.shoppingbuddy.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcs.shoppingbuddy.model.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {


}

package com.vcs.shoppingbuddy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcs.shoppingbuddy.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

	@Query(value = "select * from item where item_category_id =?1", nativeQuery = true)
	List<Item> findItemByCategory(Long categoryId);

}

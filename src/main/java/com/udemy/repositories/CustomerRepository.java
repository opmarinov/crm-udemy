package com.udemy.repositories;

import com.udemy.entity.CustomerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
  List<CustomerEntity> findAll();

  //@Query("FROM CustomerEntity c where c.firstname like LOWER(CONCAT('%', :firstname, '%')) or c.lastname like LOWER(CONCAT('%', :lastname, '%')) ")
  @Query("FROM CustomerEntity c where LOWER(c.firstname) like "
      + "LOWER(CONCAT('%', :firstname, '%')) or "
      + "LOWER(c.lastname) like "
      + "LOWER(CONCAT('%', :lastname, '%'))")
  List<CustomerEntity> findCustomersEntitiesByFirstnameOrLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);
}

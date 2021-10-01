package com.nibblebytes.postgresql.repository;

import com.nibblebytes.postgresql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> { //Farklı repositoryler var. PagingAndSortingRepository gibi
}

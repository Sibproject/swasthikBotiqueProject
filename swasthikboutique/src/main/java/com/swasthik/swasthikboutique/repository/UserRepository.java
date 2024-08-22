package com.swasthik.swasthikboutique.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swasthik.swasthikboutique.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>{
	List<UserDetails> findByFirstName(String firstName);

}

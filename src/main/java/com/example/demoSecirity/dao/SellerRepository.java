package com.example.demoSecirity.dao;

import com.example.demoSecirity.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

	// that's it ... no need to write any code LOL!
	
}

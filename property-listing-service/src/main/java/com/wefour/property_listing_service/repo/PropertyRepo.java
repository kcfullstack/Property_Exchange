package com.wefour.property_listing_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wefour.property_listing_service.entity.Property;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer>{

}

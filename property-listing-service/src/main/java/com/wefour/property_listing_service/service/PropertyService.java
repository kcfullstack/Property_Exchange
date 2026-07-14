package com.wefour.property_listing_service.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.wefour.property_listing_service.dto.PropertyDto;
import com.wefour.property_listing_service.entity.Property;
import com.wefour.property_listing_service.mapper.PropertyMapper;
import com.wefour.property_listing_service.repo.PropertyRepo;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepo propertyRepo;
	
	public List<PropertyDto> fetchAllProperty(){
		
		List<Property> properties = propertyRepo.findAll();
		List<PropertyDto> propertyDtoList = properties.stream().map(
				property -> PropertyMapper.INSTANCE.mapPropertyToPropertyDto(property)).collect(Collectors.toList());
		return propertyDtoList;
	}
	
	public PropertyDto addPropertyInDB(PropertyDto propertyDTO) {
        Property savedProperty =  propertyRepo.save(PropertyMapper.INSTANCE.mapPropertyDtoToProperty(propertyDTO));
        return PropertyMapper.INSTANCE.mapPropertyToPropertyDto(savedProperty);
    }

    public ResponseEntity<PropertyDto> fetchPropertyById(Integer id) {
        Optional<Property> property = propertyRepo.findById(id);
        if(property.isPresent()){
            return new ResponseEntity<>(PropertyMapper.INSTANCE.mapPropertyToPropertyDto(property.get()), 
            		HttpStatus.OK);
        }
        //return null;
        //return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
	

}

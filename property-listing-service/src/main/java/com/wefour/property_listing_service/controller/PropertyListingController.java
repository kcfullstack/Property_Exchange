package com.wefour.property_listing_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wefour.property_listing_service.dto.PropertyDto;
import com.wefour.property_listing_service.service.PropertyService;



@RestController
@RequestMapping("/property_listing")
@CrossOrigin
public class PropertyListingController {
	
	@Autowired
    PropertyService propertyService;


    
    @GetMapping("/fetchAllProperties")
    public ResponseEntity<List<PropertyDto>> fetchAllProperties(){
        List<PropertyDto> allProperty = propertyService.fetchAllProperty();
        return new ResponseEntity<>(allProperty, HttpStatus.OK);
    }

    @PostMapping("/addProperty")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDTO) {
        PropertyDto propertyAdded = propertyService.addPropertyInDB(propertyDTO);
        return new ResponseEntity<>(propertyAdded, HttpStatus.CREATED);
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<PropertyDto> findRestaurantById(@PathVariable Integer id) {
       return propertyService.fetchPropertyById(id);
    }
	

}

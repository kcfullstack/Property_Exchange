package com.wefour.property_listing_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wefour.property_listing_service.dto.PropertyDto;
import com.wefour.property_listing_service.entity.Property;

@Mapper
public interface PropertyMapper {
	
	PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);
	
	Property mapPropertyDtoToProperty(PropertyDto propertyDto);
	PropertyDto mapPropertyToPropertyDto(Property property);
	

}

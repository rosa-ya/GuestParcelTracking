package com.parcel.parcelMicroservice.model.mapper;

import com.parcel.parcelMicroservice.model.dto.ParcelDto;
import com.parcel.parcelMicroservice.model.entity.ParcelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author Rose
 * This class use @Mapper from mapstruct library for map new product to old one
 * MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach
 * MapStruct is an annotation processor which is plugged into the Java compiler and can be used in command-line builds (Maven, Gradle etc.) as well as from within your preferred IDE.
 * MapStruct uses sensible defaults but steps out of your way when it comes to configuring or implementing special behavior.
 * In contrast to other mapping frameworks MapStruct generates bean mappings at compile-time which ensures a high performance, allows for fast developer feedback and thorough error checking.
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ParcelMapper {

    ParcelEntity mapDtoToEntity(ParcelDto parcelDto);


    ParcelDto mapEntityToDto(ParcelEntity parcelEntity);

    List<ParcelDto> mapEntityToDtoList(List<ParcelEntity> parcelEntities);

    List<ParcelEntity> mapDtoToEntityList(List<ParcelDto> parcelDtos);


}

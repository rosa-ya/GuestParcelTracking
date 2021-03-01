package com.parcel.parcelMicroservice.service.impl;

import com.parcel.parcelMicroservice.errors.ErrorCreation;
import com.parcel.parcelMicroservice.model.dto.ParcelDto;
import com.parcel.parcelMicroservice.model.mapper.ParcelMapper;
import com.parcel.parcelMicroservice.repository.ParcelRepository;
import com.parcel.parcelMicroservice.service.ParcelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rose
 */
@Service
@AllArgsConstructor
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    ParcelRepository parcelRepository;
    ParcelMapper parcelMapper;


    @Override
    public ParcelDto addParcel(ParcelDto parcelDto) {
        return parcelMapper.mapEntityToDto(parcelRepository.save(parcelMapper.mapDtoToEntity(parcelDto)));
    }

    @Override
    public List<ParcelDto> findAndUpdateParcels(long guestId) {
        List<ParcelDto> parcelDtos = findParcelsByGuestId(guestId);
        if (parcelDtos.isEmpty()) {
            throw ErrorCreation.THERE_IS_NO_PARCEL.ErrorCreation();
        }
        parcelDtos.forEach(parcelDto -> {
            parcelDto.setDelivered(true);
            log.info("Parcel {} delivered to guest {}", parcelDto.getParcelCode(), guestId);
        });

        return parcelMapper.mapEntityToDtoList(parcelRepository.saveAll(parcelMapper.mapDtoToEntityList(parcelDtos)));
    }


    @Override
    public List<ParcelDto> findParcelsByGuestId(long guestId) {
        List<ParcelDto> parcelDtos = parcelMapper.mapEntityToDtoList(parcelRepository.findByGuestId(guestId));
        log.info("Parcel for {} is {} ", guestId, parcelDtos.toString());
        return parcelDtos;
    }


}

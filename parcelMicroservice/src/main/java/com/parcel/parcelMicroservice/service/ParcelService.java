package com.parcel.parcelMicroservice.service;

import com.parcel.parcelMicroservice.model.dto.ParcelDto;

import java.util.List;

/**
 * @author Rose
 */
public interface ParcelService {

    ParcelDto addParcel(ParcelDto parcelDto);

    List<ParcelDto> findAndUpdateParcels(long guestId);

    List<ParcelDto> findParcelsByGuestId(long guestId);
}

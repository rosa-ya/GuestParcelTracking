package com.parcel.parcelMicroservice.repository;

import com.parcel.parcelMicroservice.model.entity.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rose
 */
@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {

    List<ParcelEntity> findByGuestId(long guestId);
}

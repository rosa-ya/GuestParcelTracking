package com.guest.guestMicroservice.repository;

import com.guest.guestMicroservice.model.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rose
 */
@Repository
public interface GuestRepository extends JpaRepository<GuestEntity,Long> {

    GuestEntity findByFirstNameAndLastName(String firstName, String lastName);
}

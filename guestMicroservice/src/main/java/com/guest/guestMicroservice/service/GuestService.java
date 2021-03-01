package com.guest.guestMicroservice.service;

import com.guest.guestMicroservice.model.dto.GuestDto;

/**
 * @author Rose
 */
public interface GuestService {
    void newGuest(GuestDto guestDto);

    void updateGuest(GuestDto guestDto, Long id);

    GuestDto findGuest(String firstName,String LastName);
}

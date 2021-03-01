package com.guest.guestMicroservice.service.impl;

import com.guest.guestMicroservice.errors.ErrorCreation;
import com.guest.guestMicroservice.model.dto.GuestDto;
import com.guest.guestMicroservice.model.entity.GuestEntity;
import com.guest.guestMicroservice.model.mapper.GuestMapper;
import com.guest.guestMicroservice.service.GuestService;
import com.guest.guestMicroservice.repository.GuestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Rose
 */
@Service
@AllArgsConstructor
@Slf4j
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;

    @Override
    public void newGuest(GuestDto guestDto) {
        guestRepository.save(guestMapper.DtoToEntity(guestDto));
    }

    @Override
    public void updateGuest(GuestDto guestDto, Long guestId) {
        GuestEntity GuestToUpdate = guestRepository.findById(guestId).orElseThrow(() -> ErrorCreation.INVALID_ID.ErrorCreation(""));
        guestMapper.updateGuestFromDto(guestDto, GuestToUpdate);
        guestRepository.save(GuestToUpdate);
        log.info("Guest {} data's updated",guestId);
    }

    @Override
    public GuestDto findGuest(String firstName, String lastName) {
        log.info("Guest {} {} data's fetching",firstName,lastName);
        GuestDto guestDto = guestMapper.EntityToDto(guestRepository.findByFirstNameAndLastName(firstName, lastName));
        log.info("Guest {} {} data's fetched",firstName,lastName);
        if (guestDto == null || guestDto.getCheckOut() != null) {
            throw ErrorCreation.GUEST_IS_NOT_IN_HOTEL.ErrorCreation();
        }
        return guestDto;
    }


}

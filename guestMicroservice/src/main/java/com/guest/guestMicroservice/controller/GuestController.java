package com.guest.guestMicroservice.controller;

import com.guest.guestMicroservice.model.dto.GuestDto;
import com.guest.guestMicroservice.model.dto.ParcelDto;
import com.guest.guestMicroservice.service.GuestService;
import com.guest.guestMicroservice.service.ParcelClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * @author Rose
 */
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Guest ")
@Slf4j
@RestController
@RequestMapping("/guest")
@AllArgsConstructor
public class GuestController {

    private final GuestService guestService;

    private final ParcelClient parcelClient;

    @ApiOperation(value = "Check Guest Availability for Taking Parcel", response = ResponseEntity.class, tags = "Check Guest Availability")
    @PostMapping("checkGuest/{firstName}/{lastName}")
    public @ResponseBody
    ResponseEntity<GuestDto> checkGuestAvailabilityAndTakeParcel(@Valid @RequestBody ParcelDto parcelDto, @PathVariable String firstName, @PathVariable String lastName) {
        GuestDto guestDto = guestService.findGuest(firstName, lastName);
        log.info("Guest {}{} is in hotel", firstName, lastName);
        parcelDto.setGuestId(guestDto.getId());
        ResponseEntity<ParcelDto> parcelDtoResponseEntity = parcelClient.addParcel(parcelDto);
        log.info("Parcel for Guest {} {} taken and added to DB", firstName, lastName);
        return ResponseEntity.status(HttpStatus.CREATED).body(guestDto);
    }

    @ApiOperation(value = "Check Parcel and Deliver it", response = ResponseEntity.class, tags = "Check Parcel Availability")
    @GetMapping("checkAndDeliverParcel/{firstName}/{lastName}")
    public @ResponseBody
    ResponseEntity<GuestDto> checkAndDeliverParcel(@PathVariable String firstName, @PathVariable String lastName) {
        GuestDto guestDto = guestService.findGuest(firstName, lastName);
        if (guestDto != null) {
            if (parcelClient.checkParcelAvailability(guestDto.getId()) != null) {
                log.info("Guest {} {} is in hotel and have a parcel", firstName, lastName);
                guestDto.setCheckOut(LocalDateTime.now());
                guestService.updateGuest(guestDto, guestDto.getId());
                log.info("Parcel delivered to guest {} {}", firstName, lastName);
                return ResponseEntity.status(HttpStatus.CREATED).body(guestDto);
            } else {
                log.info("Guest {} {} is in hotel but don't have any parcel", firstName, lastName);
            }
        }
        log.info("Guest {} {} is not in hotel", firstName, lastName);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(guestDto);
    }


}

package com.guest.guestMicroservice.service;

import com.guest.guestMicroservice.model.dto.ParcelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rose
 */

@FeignClient(name = "parcel-microservice")
@RequestMapping("/parcel-microservice/parcel")
public interface ParcelClient {

    @GetMapping("/{guestId}")
    ResponseEntity<List<ParcelDto>> checkParcelAvailability(@PathVariable long guestId);

    @PostMapping
    ResponseEntity<ParcelDto> addParcel(@RequestBody ParcelDto parcelDto);
}

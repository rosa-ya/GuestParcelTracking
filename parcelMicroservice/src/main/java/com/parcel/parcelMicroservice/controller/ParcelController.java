package com.parcel.parcelMicroservice.controller;

import com.parcel.parcelMicroservice.model.dto.ParcelDto;
import com.parcel.parcelMicroservice.service.ParcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rose
 */
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to parcel ")
@Slf4j
@RestController
@RequestMapping("{applicationName}/parcel")
@AllArgsConstructor
public class ParcelController {

    private final ParcelService parcelService;

    /**
     * This method is used to check parcel availability for guest
     *
     * @param guestId
     * @return List of ParcelDto with Parcel information
     */
    @ApiOperation(value = "Check Parcel Availability for Guest", response = ParcelDto.class, tags = "Check Parcel Availability")
    @GetMapping("/{guestId}")
    public ResponseEntity<List<ParcelDto>> checkParcelAvailability(@PathVariable long guestId) {
        log.info("checking parcel availability for guest " + guestId);
        return new ResponseEntity<>(parcelService.findAndUpdateParcels(guestId), HttpStatus.OK);
    }

    /**
     * This method is used to add parcel to Database
     *
     * @param parcelDto specifies the parcel information
     */
    @ApiOperation(value = "Add Parcel to DB", response = ParcelDto.class, tags = "Adding Parcel")
    @PostMapping
    public ResponseEntity<ParcelDto> addParcel(@RequestBody ParcelDto parcelDto) {
        log.info("parcel {} added" , parcelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcelService.addParcel(parcelDto));
    }


}

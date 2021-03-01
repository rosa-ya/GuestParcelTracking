package com.guest.guestMicroservice;

import com.guest.guestMicroservice.model.dto.GuestDto;
import com.guest.guestMicroservice.model.dto.ParcelDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Rose
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Tag("integration-test")
public class GuestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    @DisplayName("Save product work successfully")
    public void checkGuestAvailabilityAndTakeParcelTest() {
        ParcelDto parcelDto = new ParcelDto();
        parcelDto.setParcelCode("codeTest");
        parcelDto.setGuestId(2);

        String firstName="Mike";
        String lastName="Mike";
        ResponseEntity responseEntity = this.restTemplate.postForEntity
                ("http://localhost:" + port + "/guest/checkGuest/"+firstName+"/"+lastName, parcelDto, GuestDto.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    @DisplayName("Save product work successfully")
    public void checkAndDeliverParcelTest() {
        ParcelDto parcelDto = new ParcelDto();
        parcelDto.setParcelCode("codeTest");
        parcelDto.setGuestId(2);

        String firstName="Mike";
        String lastName="Mike";
        ResponseEntity responseEntity = this.restTemplate.getForEntity
                ("http://localhost:" + port + "/guest/checkAndDeliverParcel/"+firstName+"/"+lastName, GuestDto.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }
}

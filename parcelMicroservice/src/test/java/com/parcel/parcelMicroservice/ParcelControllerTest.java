package com.parcel.parcelMicroservice;

import com.parcel.parcelMicroservice.model.dto.ParcelDto;
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
public class ParcelControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    @DisplayName("Save parcel work successfully")
    public void addParcelTest() {
        ParcelDto parcelDto = new ParcelDto();
        parcelDto.setParcelCode("codeTest");
        parcelDto.setGuestId(2);
        ResponseEntity responseEntity = this.restTemplate.postForEntity
                ("http://localhost:" + port + "/parcel-microservice/parcel/", parcelDto, ParcelDto.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }
}

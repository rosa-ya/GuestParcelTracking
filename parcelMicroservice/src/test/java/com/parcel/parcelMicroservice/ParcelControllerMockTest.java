package com.parcel.parcelMicroservice;

import com.parcel.parcelMicroservice.controller.ParcelController;
import com.parcel.parcelMicroservice.service.ParcelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Rose
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ParcelController.class)
public class ParcelControllerMockTest {

    @MockBean
    private ParcelService parcelService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkParcelAvailabilityTest() throws Exception {
        mockMvc.perform(get("/parcel-microservice/parcel/" + 2))
                .andExpect(status().isOk())
                .andDo(print());
    }

}

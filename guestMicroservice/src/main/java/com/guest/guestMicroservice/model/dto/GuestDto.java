package com.guest.guestMicroservice.model.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Rose
 */
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}

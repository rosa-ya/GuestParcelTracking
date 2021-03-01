package com.guest.guestMicroservice.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

/**
 * @author Rose
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBL_GUEST")
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min=2, message="First name should have at least 2 characters")
    private String firstName;
    @NotBlank
    @Size(min=2, message="Last name should have at least 2 characters")
    private String lastName;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;


}

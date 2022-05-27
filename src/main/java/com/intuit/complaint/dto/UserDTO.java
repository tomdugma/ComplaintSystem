package com.intuit.complaint.dto;

import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private UUID id;

    private String fullName;

    private String emailAddress;

    private String physicalAddress;

}

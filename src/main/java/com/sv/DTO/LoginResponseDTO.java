package com.sv.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class LoginResponseDTO {

    private String jwtToken;
    private String username;
    private Set<String> roles;
}

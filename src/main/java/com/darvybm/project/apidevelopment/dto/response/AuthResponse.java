package com.darvybm.project.apidevelopment.dto.response;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private UUID id;
    private String username;
    private String accessToken;
}
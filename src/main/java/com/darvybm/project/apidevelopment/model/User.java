package com.darvybm.project.apidevelopment.model;

import com.darvybm.project.apidevelopment.model.enums.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private UUID id;

    private String username;
    private String password;
    private String email;
    private UserRole role;
}
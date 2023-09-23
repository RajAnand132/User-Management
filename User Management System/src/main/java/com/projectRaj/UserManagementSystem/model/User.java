package com.projectRaj.UserManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    private Long userId;

    @NotBlank(message = "Username is required")
    private String username;

    @NotNull(message = "Date of Birth is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of Birth must be in yyyy-MM-dd format")
    private String dateOfBirth;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\d{12}", message = "Phone number must be 12 digits")
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in yyyy-MM-dd format")
    private String date;

    @Pattern(regexp = "\\d{2}:\\d{2}:\\d{2}", message = "Time must be in HH:mm:ss format")
    private String time;

    // Constructors, getters, setters will be hamdled by lombok dependency
}


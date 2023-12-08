package com.apirestfulspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @JsonProperty
    @NotEmpty(message = "not empty")
    private String name;

    @Email(message = "not valid")
    @JsonProperty
    @NotEmpty(message = "not empty")
    private String email;

    @JsonProperty
    @NotEmpty(message = "not empty")
    @Pattern(regexp = "[A-Z][a-z]+[0-9]{2}", message = "not valid")
    private String password;

    @Valid
    private List<PhoneRequestDto> phones = new ArrayList<>();
}

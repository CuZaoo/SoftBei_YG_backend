package me.softbei.modules.security.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class AuthUserRegisterDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";
    @NotBlank
    private String nickName;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
}

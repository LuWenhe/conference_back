package com.kj.dto;

import com.kj.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Principal {

    private String username;
    private AdminRole role;

}

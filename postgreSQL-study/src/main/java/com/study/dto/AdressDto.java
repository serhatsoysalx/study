package com.study.dto;

import com.study.config.AdressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdressDto {

    private String adress;

    private AdressType adressType;

    private boolean status;

}

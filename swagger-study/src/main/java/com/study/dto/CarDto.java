package com.study.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Api içerisinde olması gereken")
public class CarDto {

    @ApiModelProperty(value = "car id")
    private Long id;

    @ApiModelProperty(value = "car brand")
    private String brand;

    @ApiModelProperty(value = "car model")
    private String model;

    @ApiModelProperty(value = "car plate")
    private String plate;

    @ApiModelProperty(value = "car date")
    private Date date;
}

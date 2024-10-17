package com.study.controller;

import com.study.dto.CarDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/car")
@Api(value = "Car Api informations")
public class CarController {

    List<CarDto> listOfCarDTo;

    @javax.annotation.PostConstruct
    void init(){
        listOfCarDTo = new ArrayList<>();
        listOfCarDTo.add(new CarDto(1L, "Tofaş", "Şahin", "10dd1000", new Date()));
        listOfCarDTo.add(new CarDto(2L, "Tofaş", "Doğan", "20dd2000", new Date()));
    }

    @PostMapping("/save")
    @ApiOperation(value = "Araç ekleme")
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto){
        listOfCarDTo.add(carDto);
        return ResponseEntity.ok(carDto);
    }

    @GetMapping("/carlist")
    @ApiOperation(value = "Araç listesi")
    public ResponseEntity<List<CarDto>> getListCar(){
        return ResponseEntity.ok(listOfCarDTo);
    }
}

package verca.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import verca.example.City;
import verca.example.dto.WeatherDto;
import verca.example.services.WeatherService;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class WeatherController {

    @Autowired
    WeatherService service;
    @RequestMapping("/weather")
    Collection<WeatherDto> getWeather(){
        ArrayList<WeatherDto> weatherDtoList=new ArrayList<>();
        for (City city:City.values()){
           WeatherDto weatherDto= service.getWeatherForCity(city);
           weatherDtoList.add(weatherDto);
        }
        return weatherDtoList;



    }
    @RequestMapping("/weather/{city}")
    WeatherDto getWeatherForCity(@PathVariable("city") String city){
        City cityEnum=City.valueOf(city.toUpperCase());
        return service.getWeatherForCity(cityEnum);
    }

}

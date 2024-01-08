package verca.example.connector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import verca.example.City;
import verca.example.dto.WeatherApiDto;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherApiConnector {
    //https://api.weatherapi.com/v1/current.json?key=0c82b916cbab42c8aa784611240501&q=Ostrava&aqi=no
    //https://api.weatherapi.com/v1/current.json?key=0c82b916cbab42c8aa784611240501&q=Stockholm&aqi=no

    private static String baseUrl="https://api.weatherapi.com/v1/";
    private static String urlParameters="current.json?key=";
    private static String APIKey="0c82b916cbab42c8aa784611240501";
    private static String url=baseUrl+urlParameters+APIKey+"&q=";

    public WeatherApiDto getWeatherForCity(City city){
        RestTemplate template=new RestTemplate();
        URI uri= null;
        try {
            uri = new URI(url+city.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherApiDto> responseEntity=template.getForEntity(uri, WeatherApiDto.class);
        return responseEntity.getBody();
    }
}


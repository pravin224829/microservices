package com.hotel.ratingsservice;

import com.hotel.ratingsservice.entity.Hotel;
import com.hotel.ratingsservice.entity.Ratings;
import com.hotel.ratingsservice.repository.RatingsRepository;
import com.hotel.ratingsservice.service.HotelService;
import com.hotel.ratingsservice.service.RatingsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingsServiceApplication.class, args);

	}
	@Bean
	public RatingsService ratingsService(){
		return new RatingsService();
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Bean public Ratings ratings(){
		return new Ratings();
	}
	@Bean
	public Hotel hotelService(){
		return new Hotel();
		}



}

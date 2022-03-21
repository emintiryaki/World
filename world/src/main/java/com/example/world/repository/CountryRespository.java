package com.example.world.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.world.document.CountryDocument;

public interface CountryRespository extends MongoRepository<CountryDocument, String> {
	List<CountryDocument> findAllByContinent(String continent);

	@Aggregation(pipeline="{ '&group' : {'_id': 'continent'} }")
	List<String> getAllContinents();

}

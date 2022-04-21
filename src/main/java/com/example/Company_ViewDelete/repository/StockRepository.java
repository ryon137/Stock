package com.example.Company_ViewDelete.repository;


import com.example.Company_ViewDelete.model.Company;
import com.example.Company_ViewDelete.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends MongoRepository<Stock, String> {
}

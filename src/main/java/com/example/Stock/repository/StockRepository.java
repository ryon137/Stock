package com.example.Stock.repository;


import com.example.Stock.model.Stock;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockRepository extends MongoRepository<Stock, String> {
    public List<Stock> findByCompanyCode(ObjectId companyCode);

}

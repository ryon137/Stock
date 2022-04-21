package com.example.Company_ViewDelete.repository;

import com.example.Company_ViewDelete.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}

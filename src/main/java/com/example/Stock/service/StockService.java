package com.example.Stock.service;

import com.example.Stock.model.Company;
import com.example.Stock.model.Stock;
import com.example.Stock.repository.CompanyRepository;
import com.example.Stock.repository.StockRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class StockService {
    private StockRepository stockRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Optional<Stock> getStock(ObjectId stockId) {
        return stockRepository.findById(String.valueOf(stockId));
    }

    //list of stock price of a company btw time frame
    public List<Double> getCompanyStockPrice(LocalDateTime startDate, LocalDateTime endDate, ObjectId companyCode) {
        List<Stock> stocks = stockRepository.findByCompanyCode(companyCode);
        List<Double> companyStockPrice = new ArrayList<>();
        for (Stock stock : stocks) {
            if (stock.getDate().isAfter(startDate) && stock.getDate().isBefore(endDate)) {
                companyStockPrice.add(stock.getPrice());
            }
        }
        return companyStockPrice;
    }

    //display max, min, and avg stock price btw time frame
    public List<Double> companyStockMaxMinAvg(LocalDateTime startDate, LocalDateTime endDate,ObjectId companyCode) {
        List<Double> stocks = getCompanyStockPrice(startDate, endDate, companyCode);

        double max = stocks.stream().mapToDouble(a -> a).max().getAsDouble();
        double min = stocks.stream().mapToDouble(a -> a).min().getAsDouble();
        double avg = stocks.stream().mapToDouble(a -> a).average().getAsDouble();
        List<Double> values = new ArrayList<>();
        values.add(max);
        values.add(min);
        values.add(avg);
        return values;
    }


    public Stock addStock(Stock stock) {
        stock.setDate(LocalDateTime.now());
        Optional<Company> company = companyRepository.findById(String.valueOf(stock.getCompanyCode()));
        Company company1 = company.get();
        company1.setRelatedStock(stock);
        companyRepository.save(company1);
        return stockRepository.save(stock);
    }
}

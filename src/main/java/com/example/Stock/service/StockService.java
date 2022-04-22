package com.example.Stock.service;

import com.example.Stock.model.Stock;
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
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    public Optional<Stock> getStock(UUID stockId) {
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
//        double sum=0;
//        for(int i=0;i<=stocks.size();i++){
//            sum+=stocks.get(i);
//        }
//        double avg = sum/ stocks.size();
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
        System.out.println(LocalDateTime.now());
        return stockRepository.save(stock);
    }
//    public void deleteStock(int stockId){
//        stockRepository.deleteById(String.valueOf(stockId));
//        System.out.println("Stock is deleted");
//    }
}

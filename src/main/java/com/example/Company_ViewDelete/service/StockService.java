//package com.example.HackFSE.service;
//
//import main.java.com.example.HackFSE.model.Company;
//import com.example.HackFSE.model.Stock;
//import com.example.HackFSE.repository.StockRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class StockService {
//    private StockRepository stockRepository;
//    @Autowired
//    public StockService(StockRepository stockRepository){
//        this.stockRepository=stockRepository;
//    }
//
//    public List<Stock> getStocks(){
//        return stockRepository.findAll();
//    }
//    public Optional<Stock> getStock(UUID stockId){
//        return stockRepository.findById(String.valueOf(stockId));
//    }
//
//    public List<Stock> getCompanyStock(Optional<Company> relatedCompany){
//        return stockRepository.findByRelatedCompany(relatedCompany);
//    }
//    public Stock addStock (Stock stock){
//        return stockRepository.save(stock);
//    }
//    public void deleteStock(int stockId){
//        stockRepository.deleteById(String.valueOf(stockId));
//        System.out.println("Stock is deleted");
//    }
//}

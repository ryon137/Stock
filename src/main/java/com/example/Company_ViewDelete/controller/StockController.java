//package com.example.HackFSE.controller;
//
//import com.example.HackFSE.model.Stock;
//import com.example.HackFSE.service.CompanyService;
//import com.example.HackFSE.service.StockService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/v1.0/market/stock")
//public class StockController {
//    private StockService stockService;
//
//    private CompanyService companyService;
//
//    @Autowired
//    public StockController(StockService stockService) {
//        this.stockService = stockService;
//    }
//
//    @PostMapping("/add/{companyCode}")
//    public ResponseEntity<Stock> createStock(@PathVariable UUID companyCode, @RequestBody Stock stock){
//        stock.setRelatedCompany(companyService.getCompany(companyCode));
//        return new ResponseEntity(stockService.addStock(stock), HttpStatus.OK);
//    }
//
//    @GetMapping("/get/{companyCode}/{startDate}/{endDate}")
//    public ResponseEntity<Stock> getStock(@PathVariable UUID companyCode, @PathVariable LocalDateTime startDate, @PathVariable LocalDateTime endDate){
//        //for a given company,
//        // returns list of stocks that reside within the start and end date
//        List<Stock> stockList = stockService.getCompanyStock(companyService.getCompany(companyCode));
//        List<Stock> newStockList = new ArrayList<>();
//        for(int i = 0; i < stockList.size(); ++i){
//            if(stockList.get(i).getDate().isAfter(startDate) && stockList.get(i).getDate().isBefore(endDate)){
//                newStockList.add(stockList.get(i));
//            }
//        }
//
//        return new ResponseEntity(newStockList, HttpStatus.OK);
//    }
//
//
//}

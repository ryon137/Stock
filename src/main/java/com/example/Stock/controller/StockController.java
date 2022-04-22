package com.example.Stock.controller;

import com.example.Stock.model.Stock;
import com.example.Stock.service.StockService;
import org.apache.tomcat.jni.Local;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/api/v1.0/market/stock")
public class StockController {
    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    //add new stock price
    @PostMapping("/add/{companyCode}")
    public ResponseEntity<Stock> createStock(@PathVariable ObjectId companyCode, @RequestBody Stock stock) {
        stock.setCompanyCode(companyCode);
        return new ResponseEntity(stockService.addStock(stock), HttpStatus.OK);
    }

    //fetch stock price list btw time frame
    @GetMapping("/get/{companyCode}/{startDate}/{endDate}")
    public ResponseEntity<Double> getStock(@PathVariable ObjectId companyCode, @PathVariable @DateTimeFormat String startDate, @PathVariable("endDate") @DateTimeFormat String endDate) {
        LocalDateTime newStartDate = LocalDateTime.parse(startDate);
        LocalDateTime newEndDate = LocalDateTime.parse(endDate);
        //for a given company,
        // returns list of stock price that reside within the start and end date
        List<Double> stockPrice = stockService.getCompanyStockPrice(newStartDate, newEndDate, companyCode);
        return new ResponseEntity(stockPrice, HttpStatus.OK);
    }

    //fetch stock max/min/avg btw time frame
    @GetMapping("/get/breakdown/{companyCode}/{startDate}/{endDate}")
    public ResponseEntity<Double> getStockPriceBreakDown(@PathVariable ObjectId companyCode, @PathVariable @DateTimeFormat String startDate, @PathVariable @DateTimeFormat String endDate){
        LocalDateTime newStartDate = LocalDateTime.parse(startDate);
        LocalDateTime newEndDate = LocalDateTime.parse(endDate);
        List<Double> breakDown = stockService.companyStockMaxMinAvg(newStartDate,newEndDate,companyCode);
        return new ResponseEntity(breakDown, HttpStatus.OK);
    }





}

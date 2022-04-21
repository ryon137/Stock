package com.example.Company_ViewDelete.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class Stock {
    private UUID companyCode;
    private double price;
    private LocalDateTime date;

    public Stock(UUID companyCode, double price, LocalDateTime date) {
        this.companyCode = companyCode;
        this.price = price;
        this.date = date;
    }

    public UUID getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(UUID companyCode) {
        this.companyCode = companyCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "companyCode=" + companyCode +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
    //    @Id
//    private UUID stockId;
//    private double price;
//    private LocalDateTime date;
//    private Optional<Company> relatedCompany;
//
//    public Stock(UUID id, double price, Date date, Company relatedCompany) {
//        this.stockId = id;
//        this.price = price;
//        this.date = LocalDateTime.now();
//        this.relatedCompany = Optional.ofNullable(relatedCompany);
//    }
//
//    public UUID getStockId() {
//        return stockId;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public Optional<Company> getRelatedCompany() {
//        return relatedCompany;
//    }
//
//    public void setStockId(UUID stockId) {
//        this.stockId = stockId;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public void setRelatedCompany(Optional<Company> relatedCompany) {
//        this.relatedCompany = relatedCompany;
//    }
//
//    @Override
//    public String toString() {
//        return "Stock{" +
//                "stockId=" + stockId +
//                ", price=" + price +
//                ", date=" + date +
//                ", relatedCompany=" + relatedCompany +
//                '}';
//    }
}

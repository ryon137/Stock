package com.example.Company_ViewDelete.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Company {

    @Id
    private UUID companyCode;
    @NotBlank(message = "mandatory")
    private String companyName;
    @NotBlank(message = "mandatory")
    private String companyCEO;
    @NotBlank(message = "mandatory")
    @Min(value = 10000000, message = "should not be less than 10cr")
    private Double companyTurnover;
    @NotBlank(message = "mandatory")
    private String companyWebsite;
    @NotBlank(message = "mandatory")
    private String listedStockExchange;
    private Optional<Stock> relatedStock;

    public Company(UUID companyCode, String companyName, String companyCEO, Double companyTurnover, String companyWebsite, String listedStockExchange, Optional<Stock> relatedStock) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyCEO = companyCEO;
        this.companyTurnover = companyTurnover;
        this.companyWebsite = companyWebsite;
        this.listedStockExchange = listedStockExchange;
        this.relatedStock = relatedStock;
    }

    public UUID getCompanyCode() {
        return companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyCEO() {
        return companyCEO;
    }

    public Double getCompanyTurnover() {
        return companyTurnover;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public String getListedStockExchange() {
        return listedStockExchange;
    }

    public Optional<Stock> getRelatedStock() {
        return relatedStock;
    }

    public void setCompanyCode(UUID companyCode) {
        this.companyCode = companyCode;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public void setCompanyTurnover(Double companyTurnover) {
        this.companyTurnover = companyTurnover;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public void setListedStockExchange(String listedStockExchange) {
        this.listedStockExchange = listedStockExchange;
    }

    public void setRelatedStock(Optional<Stock> relatedStock) {
        this.relatedStock = relatedStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyCode, company.companyCode) && Objects.equals(companyName, company.companyName) && Objects.equals(companyCEO, company.companyCEO) && Objects.equals(companyTurnover, company.companyTurnover) && Objects.equals(companyWebsite, company.companyWebsite) && Objects.equals(listedStockExchange, company.listedStockExchange) && Objects.equals(relatedStock, company.relatedStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyCode, companyName, companyCEO, companyTurnover, companyWebsite, listedStockExchange, relatedStock);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyCode=" + companyCode +
                ", companyName='" + companyName + '\'' +
                ", companyCEO='" + companyCEO + '\'' +
                ", companyTurnover=" + companyTurnover +
                ", companyWebsite='" + companyWebsite + '\'' +
                ", listedStockExchange='" + listedStockExchange + '\'' +
                ", relatedStock=" + relatedStock +
                '}';
    }
}

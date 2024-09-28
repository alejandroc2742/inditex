package com.inditex.prices.domain.model;


import java.time.LocalDateTime;

public class Price {

    private Long id; 
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private Float price;
    private String currency;

    public Price(Long id, Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId,
                 Integer priority, Float price, String currency) {
        super();
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    private Price(Builder builder) {
        this.id = builder.id;
        this.brandId = builder.brandId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.priceList = builder.priceList;
        this.productId = builder.productId;
        this.priority = builder.priority;
        this.price = builder.price;
        this.currency = builder.currency;
    }

 


 
    public static class Builder {
        private Long id; 
        private Long brandId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Long priceList;
        private Long productId;
        private Integer priority;
        private Float price;
        private String currency;

        public Builder id(Long id) { 
            this.id = id;
            return this;
        }

        public Builder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder priceList(Long priceList) {
            this.priceList = priceList;
            return this;
        }

        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder priority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public Builder price(Float price) {
            this.price = price;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Price build() {
            return new Price(this);
        }
    }

    // Getters

    public Long getId() {
        return id;
    }
    
    public Long getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public Float getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}

package com.inditex.prices.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Price {
	
	private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private BigDecimal price;
    private String currency;

    public Price(Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId,
			Integer priority, BigDecimal price, String currency) {
		super();
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
        private Long brandId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Long priceList;
        private Long productId;
        private Integer priority;
        private BigDecimal price;
        private String currency;

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

        public Builder price(BigDecimal price) {
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

	/**
	 * @return the brandId
	 */
	public Long getBrandId() {
		return brandId;
	}

	/**
	 * @return the startDate
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public LocalDateTime getEndDate() {
		return endDate;
	}

	/**
	 * @return the priceList
	 */
	public Long getPriceList() {
		return priceList;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

}

package com.kidrola.rest.webservices.product.bean;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long productId;
	 
	private String productImageUrl;
	private String productName;
	private float productRating;
	private String productDescription;
	private float productCost;
	private float productOldPrice;
	
//	protected Product() {}
//		
//	public Product(long productId, String productImageUrl, String productName, float productRating,
//			String productDescription, float productCost, float productOldPrice) {
//		super();
//		this.productId = productId;
//		this.productImageUrl = productImageUrl;
//		this.productName = productName;
//		this.productRating = productRating;
//		this.productDescription = productDescription;
//		this.productCost = productCost;
//		this.productOldPrice = productOldPrice;
//	}
//
//	public long getProductId() {
//		return productId;
//	}
//
//	public String getProductImageUrl() {
//		return productImageUrl;
//	}
//
//	public String getProductName() {
//		return productName;
//	}
//
//	public float getProductRating() {
//		return productRating;
//	}
//
//	public String getProductDescription() {
//		return productDescription;
//	}
//
//	public float getProductCost() {
//		return productCost;
//	}
//
//	public float getProductOldPrice() {
//		return productOldPrice;
//	}
//
//	public void setProductId(long productId) {
//		this.productId = productId;
//	}
//
//	public void setProductImageUrl(String productImageUrl) {
//		this.productImageUrl = productImageUrl;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	public void setProductRating(float productRating) {
//		this.productRating = productRating;
//	}
//
//	public void setProductDescription(String productDescription) {
//		this.productDescription = productDescription;
//	}
//
//	public void setProductCost(float productCost) {
//		this.productCost = productCost;
//	}
//
//	public void setProductOldPrice(float productOldPrice) {
//		this.productOldPrice = productOldPrice;
//	}
//
//	// toString() should always be present at the end
//	@Override
//	public String toString() {
//		return "Product [productId=" + productId + ", productImageUrl=" + productImageUrl + ", productName="
//				+ productName + ", productRating=" + productRating + ", productDescription=" + productDescription
//				+ ", productCost=" + productCost + ", productOldPrice=" + productOldPrice + "]";
//	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Product other = (Product) obj;
	    return Objects.equals(productId, other.productId);
	}


}

package com.kidrola.rest.webservices.category.bean;

//import java.awt.Image;
import java.time.LocalDateTime;
import java.util.Objects;

import com.kidrola.rest.webservices.image.Image;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_category")
public class Category {
	
	
 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_image_id", referencedColumnName = "image_id")
    private Image categoryImage;

    @Column(name = "created_timestamp")
    private LocalDateTime createdTimestamp;
	    
//	protected Category() {}
	
	public long getCategoryId() {
		return categoryId;
	}
	
	public String getCategoryName() {
		return name;
	}
		
//	public Category(long productId, String productImageUrl, String productName, float productRating,
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
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(productId);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		return productId == other.productId;
//	}

}

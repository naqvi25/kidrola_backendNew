package com.kidrola.rest.webservices.image;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_image")
public class Image {
	
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "image_id")
//    private Long imageId;
//
//    @Lob
//    @Column(name = "image_data", nullable = false)
//    private byte[] imageData;
//
//    @Column(name = "description", columnDefinition = "TEXT")
//    private String description;
//
//    @Column(name = "created_timestamp")
//    private LocalDateTime createdTimestamp;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "file_size")
    private Integer fileSize;

    @Column(name = "metadata", columnDefinition = "json")
    private String metadata;

    @Column(name = "created_timestamp")
    private LocalDateTime createdTimestamp;

    @Column(name = "image_type", length = 50)
    private String imageType;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "dimensions", length = 20)
    private String dimensions;

    @Column(name = "mime_type", length = 50)
    private String mimeType;

    @Column(name = "visibility", length = 20)
    private String visibility;

    @Column(name = "licensing_info", columnDefinition = "text")
    private String licensingInfo;

    @Column(name = "file_name", length = 255)
    private String fileName;

    @Column(name = "alt_text", length = 255)
    private String altText;

    @Column(name = "description", columnDefinition = "text")
    private String description;

}

package com.superapp.BlitzKing.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "content_restrictions")
public class ContentRestriction {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int minAge;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private String restrictedContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getRestrictedContent() {
		return restrictedContent;
	}

	public void setRestrictedContent(String restrictedContent) {
		this.restrictedContent = restrictedContent;
	}
    
    
}

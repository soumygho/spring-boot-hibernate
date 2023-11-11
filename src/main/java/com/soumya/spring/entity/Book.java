package com.soumya.spring.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="BOOK")
public class Book {
	@Id
	@Column(name="ISBN")
	String isbn;
	@Column(name="BOOK_NAME")
	String bookName;
	@ManyToOne
	@JoinColumn(name="PUBLISHER_CODE", nullable=false)
	Publisher publisher;
}

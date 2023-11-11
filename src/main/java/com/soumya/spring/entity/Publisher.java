package com.soumya.spring.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="PUBLISHER")
public class Publisher {
	@Id
	@Column(name="CODE")
	String code;
	@Column(name="PUBLISHER")
	String publisher;
	@OneToMany(mappedBy = "publisher")
	Set<Book> books;
}

package com.soumya.spring.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="CHAPTER")
public class Chapter {
	@EmbeddedId
	ChapterId chapterId;
	@Column(name="CHAPTER_NUM")
	int chapterNumber;
	
	@ManyToOne
	@JoinColumn(name="BOOK_ISBN", nullable = false, updatable = false, insertable = false)
	Book book;
	
	@Embeddable
	@Data
	@Builder
	static class ChapterId implements Serializable {
		@Column(name="BOOK_ISBN")
		String bookIsbn;
		@Column(name="TITLE")
		String title;
	}
}

package de.laliluna.search;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
public class Article {
	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Field(index = Index.NO_NORMS, store = Store.NO)
	private String title;

	@Field
	private String content;

	public Article() {
	}

	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("Article id=%d, title=%s, content=%s...", id,
				title, content == null ? "" : content.substring(0, content.length()>50 ? 50 : content.length()));
	}

}

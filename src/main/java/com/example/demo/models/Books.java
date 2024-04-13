package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "books")
@Entity
public class Books {
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	@Column(columnDefinition = "LONGTEXT")
	private String description;
	private String bookstore;
	private String locationBookstore;
	
	public Books() {}
	
	public Books(String title, String description, String bookstore, String locationBookstore) {
		this.setTitle(title);
		this.setDescription(description);
		this.setBookstore(bookstore);
		this.setLocationBookstore(locationBookstore);
	}
	
	public Books(int id, String title, String description, String bookstore, String locationBookstore) {
		this.setId(id);
		this.setDescription(description);
		this.setBookstore(bookstore);
		this.setLocationBookstore(locationBookstore);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookstore() {
		return bookstore;
	}

	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}

	public String getLocationBookstore() {
		return locationBookstore;
	}

	public void setLocationBookstore(String locationBookstore) {
		this.locationBookstore = locationBookstore;
	}
	
	@Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title +
                ", description='" + description +
                ", bookstore='" + bookstore +
                ", locationBookstore='" + locationBookstore +
                '}';
    }
}

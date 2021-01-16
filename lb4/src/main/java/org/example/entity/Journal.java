package org.example.entity;

public class Journal {
    private Long id;
    private String title;
    private double price;
    private String authorName;

    public Journal() {
    }

    public Journal(final Long id, final String title, final double price, final String authorName) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
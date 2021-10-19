package com.example.tellYourStory;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Stories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String author;
    private String title;
    private String content;
    private Date date;
    private Integer disapproved;
    private Integer approved;
    private boolean published;

    public Stories(Long id, String author, String title, String content, Date  date , boolean published, Integer approved) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.published = published;
        this.approved = approved;
        this.date=date;
    }
    public Stories(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStoryTitle() {
        return title;
    }

    public void getStoryTitle(String storyText) {
        this.title = storyText;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Integer getApproved() { return approved; }

    public void setApproved(Integer approved) { this.approved = approved; }

    public Integer getDisapproved() { return disapproved; }

    public void setDisapproved(Integer disapproved) { this.disapproved = disapproved;   }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stories)) return false;
        Stories stories = (Stories) o;
        return isPublished() == stories.isPublished() && Objects.equals(getId(), stories.getId()) && Objects.equals(getAuthor(), stories.getAuthor()) && Objects.equals(getTitle(), stories.getTitle()) && Objects.equals(getContent(), stories.getContent()) && Objects.equals(getDate(), stories.getDate()) && Objects.equals(getDisapproved(), stories.getDisapproved()) && Objects.equals(getApproved(), stories.getApproved());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getTitle(), getContent(), getDate(), getDisapproved(), getApproved(), isPublished());
    }

    @Override
    public String toString() {
        return "Stories{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", disapproved=" + disapproved +
                ", approved=" + approved +
                ", published=" + published +
                '}';
    }
}

package com.cqu.recommendation.repository.entity;

public class Movie extends BaseEntity {
    private Long mid;
    private String title;
    private String genres;

    @Override
    public String toString() {
        return "Movie{" +
                "mid=" + mid +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", id='" + id + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}

package com.domingosm.bookcity.book;

public class Genre {

    private Long genreId;
    private String genreName;

//    public Genre() {
//    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public Genre(Long genreId,
                 String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public Long getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}

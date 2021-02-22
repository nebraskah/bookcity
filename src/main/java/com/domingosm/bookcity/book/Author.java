package com.domingosm.bookcity.book;

public class Author {

    private Long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorEmail;
    private String authorCountry;
    private String authorTelephone;
    private String authorWebsite;

//    public Author() {
//    }

    public Author(String authorFirstName,
                  String authorLastName,
                  String authorEmail,
                  String authorCountry,
                  String authorTelephone,
                  String authorWebsite) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorEmail = authorEmail;
        this.authorCountry = authorCountry;
        this.authorTelephone = authorTelephone;
        this.authorWebsite = authorWebsite;
    }

    public Author(Long authorId,
                  String authorFirstName,
                  String authorLastName,
                  String authorEmail,
                  String authorCountry,
                  String authorTelephone,
                  String authorWebsite) {
        this.authorId = authorId;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorEmail = authorEmail;
        this.authorCountry = authorCountry;
        this.authorTelephone = authorTelephone;
        this.authorWebsite = authorWebsite;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public String getAuthorTelephone() {
        return authorTelephone;
    }

    public String getAuthorWebsite() {
        return authorWebsite;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", authorCountry='" + authorCountry + '\'' +
                ", authorTelephone='" + authorTelephone + '\'' +
                ", authorWebsite='" + authorWebsite + '\'' +
                '}';
    }
}

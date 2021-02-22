package com.domingosm.bookcity.book;

public class Publisher {

    private Long publisherId;
    private String publisherName;
    private String publisherEmail;
    private String publisherCountry;
    private String publisherTelephone;
    private String publisherWebsite;

//    public Publisher() {
//    }

    public Publisher(String publisherName,
                     String publisherEmail,
                     String publisherCountry,
                     String publisherTelephone,
                     String publisherWebsite) {
        this.publisherName = publisherName;
        this.publisherEmail = publisherEmail;
        this.publisherCountry = publisherCountry;
        this.publisherTelephone = publisherTelephone;
        this.publisherWebsite = publisherWebsite;
    }

    public Publisher(Long publisherId,
                     String publisherName,
                     String publisherEmail,
                     String publisherCountry,
                     String publisherTelephone,
                     String publisherWebsite) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publisherEmail = publisherEmail;
        this.publisherCountry = publisherCountry;
        this.publisherTelephone = publisherTelephone;
        this.publisherWebsite = publisherWebsite;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublisherEmail() {
        return publisherEmail;
    }

    public String getPublisherCountry() {
        return publisherCountry;
    }

    public String getPublisherTelephone() {
        return publisherTelephone;
    }

    public String getPublisherWebsite() {
        return publisherWebsite;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", publisherName='" + publisherName + '\'' +
                ", publisherEmail='" + publisherEmail + '\'' +
                ", publisherCountry='" + publisherCountry + '\'' +
                ", publisherTelephone='" + publisherTelephone + '\'' +
                ", publisherWebsite='" + publisherWebsite + '\'' +
                '}';
    }
}

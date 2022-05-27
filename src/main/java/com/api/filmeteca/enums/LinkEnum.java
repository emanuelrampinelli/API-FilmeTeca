package com.api.filmeteca.enums;

public enum LinkEnum {

    URL_LIST_GENEROS("https://api.themoviedb.org/3/genre/movie/list"),
    URL_BASE_FILME("https://api.themoviedb.org/3/movie/"),
    URL_BASE_POPULARES("https://api.themoviedb.org/3/movie/popular"),
    URL_DIRETOR("https://api.themoviedb.org/3/movie/"),
    URL_SEARCH("https://api.themoviedb.org/3/search/multi");

    private String url;

    private LinkEnum(String url) {
        this.setUrl(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

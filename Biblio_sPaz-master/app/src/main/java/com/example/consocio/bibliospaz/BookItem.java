package com.example.consocio.bibliospaz;

public class BookItem {

    private String urlImg;
    private String titolo;
    private String autore;
    private String data;
    private String categoria;

    public BookItem(String urlImg, String titolo, String autore, String data, String categoria) {
        this.urlImg = urlImg;
        this.titolo = titolo;
        this.autore = autore;
        this.data = data;
        this.categoria = categoria;
    }

    public BookItem(String titolo, String autore, String data, String categoria) {
        this.titolo = titolo;
        this.autore = autore;
        this.data = data;
        this.categoria = categoria;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getData() {
        return data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

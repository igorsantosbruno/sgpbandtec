package br.com.sgp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "produto")
@Entity(name = "Produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "quantidade")
    private int quantity;

    @Column(name = "valor")
    private double price;

    @Column(name = "titulo")
    private String title;

    @Column(name = "background")
    private String background;

    @Column(name = "descricao")
    private String description;

    @Column(name = "quantidade_p")
    private int p;

    @Column(name = "quantidade_m")
    private int m;

    @Column(name = "quantidade_g")
    private int g;

    @Column(name = "quantidade_gg")
    private int gg;

    @Column(name = "quantidade_unico")
    private int isUnique;

    @Column(name = "id_tipo")
    private int idType;

    public Produto() {

        this.id = 0;
        this.quantity = 0;
        this.price = 0;
        this.title = "";
        this.background = "";
        this.description = "";
        this.p = 0;
        this.m = 0;
        this.g = 0;
        this.gg = 0;
        this.isUnique = 0;
        this.idType = 0;
    }

    public Produto(long id, int quantity, double price, String title, String background, String description, int p, int m, int g, int gg, int isUnique, int idType) {

        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
        this.background = background;
        this.description = description;
        this.p = p;
        this.m = m;
        this.g = g;
        this.gg = gg;
        this.isUnique = isUnique;
        this.idType = idType;

    }

    public long getId() {

        return this.id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public int getQuantity() {

        return this.quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public double getPrice() {

        return this.price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public String getTitle() {

        return this.title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getBackground() {

        return this.background;
    }

    public void setBackground(String background) {

        this.background = background;
    }

    public String getDescription() {

        return this.description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getGg() {
        return gg;
    }

    public void setGg(int gg) {
        this.gg = gg;
    }

    public int getisUnique() {
        return isUnique;
    }

    public void setisUnique(int unique) {
        isUnique = unique;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
}












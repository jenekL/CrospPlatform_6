package Entities;

import javax.persistence.*;

@Entity
@Table(name = "tzakupka", schema = "krosp_lab6", catalog = "")
public class TzakupkaEntity {
    private int id;
    private String namee;
    private Double price;
    private String ed;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Namee", nullable = true, length = 20)
    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    @Basic
    @Column(name = "Price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Ed", nullable = true, length = 10)
    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TzakupkaEntity that = (TzakupkaEntity) o;

        if (id != that.id) return false;
        if (namee != null ? !namee.equals(that.namee) : that.namee != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (ed != null ? !ed.equals(that.ed) : that.ed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (namee != null ? namee.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (ed != null ? ed.hashCode() : 0);
        return result;
    }
}

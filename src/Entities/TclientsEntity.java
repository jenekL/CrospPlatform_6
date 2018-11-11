package Entities;

import javax.persistence.*;

@Entity
@Table(name = "tclients", schema = "krosp_lab6", catalog = "")
public class TclientsEntity {
    private int id;
    private String firm;
    private String country;
    private String adress;
    private Integer telephone;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Firm", nullable = true, length = 20)
    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    @Basic
    @Column(name = "Country", nullable = true, length = 20)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "Adress", nullable = true, length = 20)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "Telephone", nullable = true)
    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TclientsEntity that = (TclientsEntity) o;

        if (id != that.id) return false;
        if (firm != null ? !firm.equals(that.firm) : that.firm != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firm != null ? firm.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }
}

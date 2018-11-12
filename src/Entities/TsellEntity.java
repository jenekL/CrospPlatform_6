package Entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tsell", schema = "krosp_lab6", catalog = "")
public class TsellEntity {
    private int id;
    private Timestamp datee;
    private Integer counting;
    private TclientsEntity tclientsByIdKlienta;
    private TzakupkaEntity tzakupkaByIdTovara;

//    public String getName(){
//        return tzakupkaByIdTovara.getNamee();
//    }
//    public void setName(String name){
//        tzakupkaByIdTovara.setNamee(name);
//    }
//
//    public String getFirm(){
//        return tclientsByIdKlienta.getFirm();
//    }
//    public void setFirm(String firm){
//        tzakupkaByIdTovara.setNamee(firm);
//    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Datee", nullable = true)
    public Timestamp getDatee() {
        return datee;
    }

    public void setDatee(Timestamp datee) {
        this.datee = datee;
    }

    @Basic
    @Column(name = "Counting", nullable = true)
    public Integer getCounting() {
        return counting;
    }

    public void setCounting(Integer counting) {
        this.counting = counting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TsellEntity that = (TsellEntity) o;

        if (id != that.id) return false;
        if (datee != null ? !datee.equals(that.datee) : that.datee != null) return false;
        if (counting != null ? !counting.equals(that.counting) : that.counting != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datee != null ? datee.hashCode() : 0);
        result = 31 * result + (counting != null ? counting.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_klienta", referencedColumnName = "id")
    public TclientsEntity getTclientsByIdKlienta() {
        return tclientsByIdKlienta;
    }

    public void setTclientsByIdKlienta(TclientsEntity tclientsByIdKlienta) {
        this.tclientsByIdKlienta = tclientsByIdKlienta;
    }

    @ManyToOne
    @JoinColumn(name = "id_tovara", referencedColumnName = "id")
    public TzakupkaEntity getTzakupkaByIdTovara() {
        return tzakupkaByIdTovara;
    }

    public void setTzakupkaByIdTovara(TzakupkaEntity tzakupkaByIdTovara) {
        this.tzakupkaByIdTovara = tzakupkaByIdTovara;
    }
}

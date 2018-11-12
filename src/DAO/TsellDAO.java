package DAO;

import Entities.TsellEntity;
import Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TsellDAO {
    public void addSell(TsellEntity tsellEntity) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(tsellEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            assert session != null;
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }

        }
    }

    public void deleteSell(TsellEntity tsellEntity){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(tsellEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            assert session != null;
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAllSell(){
        Session session = null;
        ObservableList<TsellEntity> tableData = FXCollections.observableArrayList();
        List sells = new ArrayList<TsellEntity>();
        try {
            session = HibernateUtil.getSession();
            sells = session.createCriteria(TsellEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        for (Object o: sells){
            tableData.add((TsellEntity)o);
        }
        return tableData;
    }
}

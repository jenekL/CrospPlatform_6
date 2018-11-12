package DAO;

import Entities.TclientsEntity;
import Entities.TzakupkaEntity;
import Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TzakupkaDAO {
    public void addZakupka(TzakupkaEntity tzakupkaEntity) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(tzakupkaEntity);
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

    public void deleteZakupka(TzakupkaEntity tzakupkaEntity){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(tzakupkaEntity);
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

    public Collection getAllZakupki(){
        Session session = null;
        ObservableList<TzakupkaEntity> tableData = FXCollections.observableArrayList();
        List zakupka = new ArrayList<TzakupkaEntity>();
        try {
            session = HibernateUtil.getSession();
            zakupka = session.createCriteria(TzakupkaEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        for (Object o: zakupka){
            tableData.add((TzakupkaEntity)o);
        }
        return tableData;
    }

    public TzakupkaEntity getZakupkaEntity(int id){
        Session session = null;
        TzakupkaEntity tzakupkaEntity;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(TzakupkaEntity.class);
            criteria.add(Restrictions.eq("id", id));
            tzakupkaEntity = (TzakupkaEntity) criteria.list().get(0);

            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tzakupkaEntity;

    }
}

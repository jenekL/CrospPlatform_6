package DAO;

import Entities.TclientsEntity;
import Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TclientsDAO {
    public void addClient(TclientsEntity tclientsEntity) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(tclientsEntity);
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
    public void deleteClient(TclientsEntity tclientsEntity){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(tclientsEntity);
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

    public Collection getAllClients(){
        Session session = null;
        ObservableList<TclientsEntity> tableData = FXCollections.observableArrayList();
        List clients = new ArrayList<TclientsEntity>();
        try {
            session = HibernateUtil.getSession();
            clients = session.createCriteria(TclientsEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        for (Object tclientsEntity: clients){
            tableData.add((TclientsEntity)tclientsEntity);
        }
        return tableData;
    }

    public TclientsEntity getClientEntity(int id){
        Session session = null;
        TclientsEntity tclientsEntity;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(TclientsEntity.class);
            criteria.add(Restrictions.eq("id", id));
            tclientsEntity = (TclientsEntity) criteria.list().get(0);

            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tclientsEntity;
    }
}

package com.iticbcn.mariapalomeque.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iticbcn.mariapalomeque.Model.Compania;

public class CompaniaDAO {
    private SessionFactory sessionFactory;

    public CompaniaDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void guardarCompania(Compania compania) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(compania);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static List<Compania> listarCompanias(SessionFactory sf) {
        List<Compania> companias = null;
        try (Session session = sf.openSession()) {
            companias = session.createQuery("FROM Compania", Compania.class).list();
        } catch (Exception e) {
            System.err.println("Error al listar compañías: " + e.getMessage());
        }
        return companias;
    }


    public static List<Compania> obtenerCompanias(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            return session.createQuery("FROM Compania", Compania.class).list();
        } catch (Exception e) {
            System.err.println("Error al obtener compañías: " + e.getMessage());
            return null;
        }
    }

    public static Compania obtenerCompaniaPorId(SessionFactory sf, int idCompania) {
        try (Session session = sf.openSession()) {
            return session.get(Compania.class, idCompania);
        } catch (Exception e) {
            System.err.println("Error al buscar la compañía: " + e.getMessage());
            return null;
        }
    }

    public static void eliminarCompania(SessionFactory sf, Compania compania) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            session.remove(compania);
            transaction.commit();
            System.out.println("Compañía eliminada correctamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al eliminar la compañía: " + e.getMessage());
        }
    }
}

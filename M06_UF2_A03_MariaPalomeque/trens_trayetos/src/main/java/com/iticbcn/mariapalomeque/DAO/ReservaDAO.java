package com.iticbcn.mariapalomeque.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iticbcn.mariapalomeque.Model.Compania;
import com.iticbcn.mariapalomeque.Model.Reserva;

public class ReservaDAO {

    public static void agregarReserva(SessionFactory sf, Reserva reserva) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            session.persist(reserva);
            transaction.commit();
            System.out.println("Reserva añadida correctamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al agregar la reserva: " + e.getMessage());
        }
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
}

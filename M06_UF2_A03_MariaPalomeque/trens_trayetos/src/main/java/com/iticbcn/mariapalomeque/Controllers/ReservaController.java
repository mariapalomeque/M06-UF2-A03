package com.iticbcn.mariapalomeque.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;

import com.iticbcn.mariapalomeque.DAO.ReservaDAO;
import com.iticbcn.mariapalomeque.Model.Compania;
import com.iticbcn.mariapalomeque.Model.Reserva;

public class ReservaController {

    public static void agregarReserva(BufferedReader bf, SessionFactory sf) {
        try {
            System.out.print("Ingrese el ID del cliente: ");
            int idCliente = Integer.parseInt(bf.readLine());

            System.out.print("Ingrese el coste total: ");
            double costeTotal = Double.parseDouble(bf.readLine());

            System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
            String fecha = bf.readLine();

            // Mostrar todas las compañías disponibles antes de pedir el ID
            List<Compania> companias = ReservaDAO.obtenerCompanias(sf);
            if (companias == null || companias.isEmpty()) {
                System.out.println("No hay compañías registradas. Primero añada una compañía.");
                return;
            }

            System.out.println("\n===== LISTA DE COMPAÑÍAS DISPONIBLES =====");
            for (Compania c : companias) {
                System.out.println("ID: " + c.getIdCompania() + " - Nombre: " + c.getNombre());
            }

            Compania companiaSeleccionada = null;
            while (companiaSeleccionada == null) {
                System.out.print("\nIngrese el ID de la compañía para la reserva: ");
                try {
                    int idCompania = Integer.parseInt(bf.readLine());
                    companiaSeleccionada = ReservaDAO.obtenerCompaniaPorId(sf, idCompania);
                    if (companiaSeleccionada == null) {
                        System.out.println("ID inválido. Intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Introduzca un número.");
                }
            }

            Reserva nuevaReserva = new Reserva(idCliente, costeTotal, fecha, companiaSeleccionada);
            ReservaDAO.agregarReserva(sf, nuevaReserva);

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error en la entrada de datos: " + e.getMessage());
        }
    }
}

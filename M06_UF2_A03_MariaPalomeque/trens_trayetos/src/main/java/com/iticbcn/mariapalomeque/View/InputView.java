package com.iticbcn.mariapalomeque.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;

import com.iticbcn.mariapalomeque.Controllers.CompaniaController;
import com.iticbcn.mariapalomeque.Controllers.ReservaController;
import com.iticbcn.mariapalomeque.Model.Compania;

public class InputView {
    public static void MostrarMenu(BufferedReader bf, SessionFactory sf) {
        boolean continuar = true;
        while (continuar) {
            mostrarOpcions();
            try {
                int opcion = Integer.parseInt(LecturaEntrada(bf));
                switch (opcion) {
                    case 1:
                        CompaniaController.agregarCompania(bf, sf);
                        break;
                    case 2:
                        mostrarCompanias(sf);
                        break;
                        case 3:
                                    ReservaController.agregarReserva(bf, sf);

                        break;
                        case 4:
                        CompaniaController.eliminarCompania(bf, sf);

                        break;
                    case 5:
                        continuar = false;
                        System.out.println("Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Entrada no válida. Introduzca un número.");
            } catch (Exception ex) {
                System.err.println("Error general: " + ex.getMessage());
            }
        }
    }

    private static void mostrarOpcions() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Registrar Compañía");
        System.out.println("2. Listar Compañías");
        System.out.println("3. Registrar una reserva");
        System.out.println("4.Borrar compania por ID");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static String LecturaEntrada(BufferedReader bf) {
        try {
            return bf.readLine();
        } catch (IOException e) {
            System.err.println("Error de entrada: " + e.getMessage());
            return "";
        }
    }

    public static void mostrarCompanias(SessionFactory sf) {
        List<Compania> companias = CompaniaController.listarCompanias(sf);
        if (companias.isEmpty()) {
            System.out.println("No hay compañías registradas.");
        } else {
            System.out.println("\n===== LISTA DE COMPAÑÍAS =====");
            for (Compania compania : companias) {
                System.out.println(compania);
            }
        }
    }
}

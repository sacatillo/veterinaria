/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vet;

/**
 *
 * @author Martin Montes
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Veterinaria veterinaria = new Veterinaria();

        while (true) {
            System.out.println("Ingrese los datos del paciente:");
            System.out.print("Nombre del paciente: ");
            String nombre = scanner.nextLine();
            System.out.print("Tipo de animal (Perro/Gato/etc.): ");
            String tipoDeAnimal = scanner.nextLine();
            System.out.print("Raza o tamaño: ");
            String razaOTamaño = scanner.nextLine();
            System.out.print("Tipo de atencion (Médica/Estética): ");
            String tipoDeAtencion = scanner.nextLine();

            Paciente paciente = new Paciente(nombre, tipoDeAnimal, razaOTamaño, tipoDeAtencion);

            System.out.print("Fecha de la cita (YYYY-MM-DD): ");
            String fecha = scanner.nextLine();
            System.out.print("Hora de la cita (HH:MM): ");
            String hora = scanner.nextLine();
            System.out.print("Descripción del diagnóstico: ");
            String descripcionDiagnostico = scanner.nextLine();
            Diagnostico diagnostico = new Diagnostico(descripcionDiagnostico);

            Cita cita = new Cita(fecha, hora, paciente, diagnostico);
            veterinaria.agregarCita(cita);

            System.out.print(" Desea agregar otra cita? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }

        System.out.println("\nCitas programadas:");
        veterinaria.mostrarCitas();

        scanner.close();
    }

    static class Paciente {
        private String nombre;
        private String tipoDeAnimal;
        private String razaOTamaño;
        private String tipoDeAtencion;
        private Diagnostico diagnostico;

        public Paciente(String nombre, String tipoDeAnimal, String razaOTamaño, String tipoDeAtencion) {
            this.nombre = nombre;
            this.tipoDeAnimal = tipoDeAnimal;
            this.razaOTamaño = razaOTamaño;
            this.tipoDeAtencion = tipoDeAtencion;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipoDeAnimal() {
            return tipoDeAnimal;
        }

        public void setTipoDeAnimal(String tipoDeAnimal) {
            this.tipoDeAnimal = tipoDeAnimal;
        }

        public String getRazaOTamaño() {
            return razaOTamaño;
        }

        public void setRazaOTamaño(String razaOTamaño) {
            this.razaOTamaño = razaOTamaño;
        }

        public String getTipoDeAtencion() {
            return tipoDeAtencion;
        }

        public void setTipoDeAtencion(String tipoDeAtencion) {
            this.tipoDeAtencion = tipoDeAtencion;
        }

        public Diagnostico getDiagnostico() {
            return diagnostico;
        }

        public void setDiagnostico(Diagnostico diagnostico) {
            this.diagnostico = diagnostico;
        }
    }

    static class Cita {
        private String fecha;
        private String hora;
        private Paciente paciente;
        private Diagnostico diagnostico;

        public Cita(String fecha, String hora, Paciente paciente, Diagnostico diagnostico) {
            this.fecha = fecha;
            this.hora = hora;
            this.paciente = paciente;
            this.diagnostico = diagnostico;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public void setPaciente(Paciente paciente) {
            this.paciente = paciente;
        }

        public Diagnostico getDiagnostico() {
            return diagnostico;
        }

        public void setDiagnostico(Diagnostico diagnostico) {
            this.diagnostico = diagnostico;
        }
    }

    static class Diagnostico {
        private String descripcion;

        public Diagnostico(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }

    static class Veterinaria {
        private List<Cita> citas;

        public Veterinaria() {
            this.citas = new ArrayList<>(); // Inicializa la lista de citas
        }

        public void agregarCita(Cita cita) {
            citas.add(cita); // Agrega una nueva cita a la lista
        }

        public void mostrarCitas() {
            for (Cita cita : citas) {
                System.out.println("Fecha: " + cita.getFecha() + ", Hora: " + cita.getHora() +
                        ", Paciente: " + cita.getPaciente().getNombre() +
                        ", Diagnostico: " + cita.getDiagnostico().getDescripcion());
            }
        }
    }
}
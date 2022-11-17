package dam.main;

import dam.db.AccesoBibliotecaDB;
import dam.pojo.Autor;
import dam.pojo.Libro;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionBiblioteca {

    static AccesoBibliotecaDB accesoDB;
    static Scanner sc;

    public static void main(String[] args) {

        accesoDB = new AccesoBibliotecaDB();


        Boolean cont = true;
        System.out.println("Bienvenido a la biblioteca");

        while(cont){
            System.out.println("Selecciona una opcion");
            System.out.println("\nIL. Insertar autores y libros" +
                    "\nML. Modificar el numero de paginas de un libro" +
                    "\nCT. Consultar todos los libros" +
                    "\nCL. Consultar los libros con más de 300 paginas" +
                    "\nS. Terminar el proceso");

            Scanner sc = new Scanner(System.in);

            String opc = sc.nextLine().toUpperCase();
            System.out.println(opc);

            switch (opc){
                case "IL":
                    insertarAutoresYLibros();
                    break;
                case "ML":
                    modificarNumPaginas();
                    break;
                case "CT":
                    consultarTodosLibros();
                    break;
                case "CL":
                    consultarLibros300();
                    break;
                case "S":
                    System.out.println("Hasta pronto");
                    cont = false;
                    break;
                default:
                    System.out.println("El valor que has introducido no es correcto");
            }

        }



        sc.close();

        accesoDB.cerrarDB();

    }

    private static void consultarLibros300() {
        int numPag = 300;
        ArrayList<Libro> libros300 = accesoDB.consultarLibros300(numPag);

        if (libros300.isEmpty()){
            System.out.println("No se han encontrado libros con más de " + numPag + " páginas");
        } else {
            System.out.println("Libros con más de " + numPag + " páginas");

            for (Libro libro : libros300){
                System.out.println(libro);
            }
        }
    }

    private static void consultarTodosLibros() {
        ArrayList<Libro> listaLibros = accesoDB.consultarTodosLibros();
        if (listaLibros.isEmpty()){
            System.out.println("No hay libros en la biblioteca");
        } else {
            System.out.println("Libros de la biblioteca");
            for (Libro libro : listaLibros) {
                System.out.println(libro);
            }
        }

    }

    private static void modificarNumPaginas() {
        sc = new Scanner(System.in);
        System.out.println("Introduce el titulo del libro");
        String titulo = sc.nextLine();

        if (accesoDB.consultarLibro(titulo) == null){
            System.out.println("El libro no existe");
        } else {
            System.out.println("Introduce el nuevo numero de paginas");
            int numPagN = sc.nextInt();
            accesoDB.modificarNumPaginas(titulo, numPagN);
            System.out.println("El numero de paginas se ha modificado correctamente");
        }

    }

    private static void insertarAutoresYLibros() {
        sc = new Scanner(System.in);
        System.out.println("Introduce el titulo");
        String titulo = sc.nextLine();

        System.out.println("Introduce el autor");
        String nombreA = sc.nextLine();

        System.out.println("Introduce las iniciales");
        String inicialesA = sc.nextLine();

        System.out.println("Introduce la nacionalidad del Autor");
        String nacionalidadA = sc.nextLine();

        System.out.println("Introduce la información del autor");
        String infoA = sc.nextLine();

        Autor autor = new Autor(nombreA, inicialesA, nacionalidadA, infoA);

        System.out.println("Introduce el número de páginas");
        int numPag = sc.nextInt();

        Libro libros[] = {new Libro(titulo, autor, numPag)};

        for (Libro libro : libros){
            accesoDB.insertar(libro);
        }

    }

}

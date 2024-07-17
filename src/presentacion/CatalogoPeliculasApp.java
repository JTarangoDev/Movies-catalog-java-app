package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        Scanner consola = new Scanner(System.in);

        //Agregamos la implementación del servicio
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();

        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            } catch (Exception e){
                System.out.println("Ha ocurrido un error; " + e.getMessage());
            }
            System.out.println();
        }// end while
    }

    private static void mostrarMenu(){
        System.out.println("""
                *** Catalogo de peliculas ***
                1. Agregar peliculas
                2. Listar peliculas
                3. Buscar pelicula
                4. Salir
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas){
        int opcion = Integer.parseInt(consola.nextLine());
        boolean salir = false;

        switch (opcion){
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }

            case 2 -> {
                servicioPeliculas.listarPeliculas();
            }

            case 3 -> {
                System.out.println("Introduce el nombre de la pelicula a buscar: ");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }

            case 4 -> {
                System.out.println("Hasta la proxima...");
                salir = true;
            }

            default -> System.out.println("Opción no reconocida: " + opcion);
        }
        return salir;

    }
}
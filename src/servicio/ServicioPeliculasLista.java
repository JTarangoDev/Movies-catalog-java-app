package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agregó la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1) {
            System.out.println("Pelicula no encontrada" + pelicula);
        }else {
            System.out.println("Pelicula encontrada en el indice: " + indice);
        }

    }

    /*public static void main(String[] args) {
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");

        //Creamos el servicio (Patrón de diseño service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        //Agregamos peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        //Listamos las peliuculas
        servicioPeliculas.listarPeliculas();

        //Buscamos pelicula
        //Se debe implementar equals y hashCode
        servicioPeliculas.buscarPelicula(new Pelicula("Top Gun"));

    }*/
}

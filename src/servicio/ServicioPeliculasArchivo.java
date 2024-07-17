package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo(){
        // Se crea objeto de tipo archivo en la variable archivo pasandole el nombre del archivo como argumento
        File archivo = new File(NOMBRE_ARCHIVO);
        try{
            if(archivo.exists()){
                System.out.println("El archivo ya existe");
            }else {
                //Se escribe el archivo en el disco, se cierra con metodo .close() para que no se quede abierto
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Ha ocurrido un error al abrir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        //Volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de Peliculas");
            //Abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //Leemos linea a linea el archivo
            String linea = entrada.readLine();
            //Leemos todas las lineas disponibles
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de terminar volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }
            //Cerrar archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Revisamos si el archivo existe
            anexar = archivo.exists();

            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            //Agregamos la pelicula (toString)
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agregó al archivo: " + pelicula);
        }catch (Exception e){
            System.out.println("Ocurrió un error al agregar pelicula: " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = entrada.readLine();

            int indice = 1;
            boolean encontrada = false;
            var peliculaBuscar = pelicula.getNombre();

            while (lineaTexto != null){
                //Buscamos sin importar mayus/minus
                if (pelicula != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                //Cada que se manda a llamar metodo .readLine() se itera la linea que se va a leer
                lineaTexto = entrada.readLine();
                indice++;
            }
            if(encontrada){
                System.out.println("Pelicula " + peliculaBuscar + " encontrada en linea: " + indice);
            }else {
                System.out.println("Pelicula no encontrada: " + peliculaBuscar);
            }
            entrada.close();

        }catch (Exception e){
            System.out.println("Ocurrió un error al buscar el archivo: " + e.getMessage());
        }
    }
}

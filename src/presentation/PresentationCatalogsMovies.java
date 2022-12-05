package presentation;

import business.*;
import java.util.Scanner;

public class PresentationCatalogsMovies {
    public static void main(String[] args) {
        var opcion = -1;
        Scanner scanner = new Scanner(System.in);
        ICatalogsMovies catalogsMovies = new CatalogsMoviesImp();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n"
                + "1. Iniciar catalogo pelicula\n"
                + "2. Agregar Pelicula\n"
                + "3. Listar Pelicula\n"
                + "4. Buscar pelicula\n"
                + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1:
                    catalogsMovies.initFile();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var name= scanner.nextLine();
                    catalogsMovies.addMovil(name);
                    break;
                case 3:
                    catalogsMovies.listMovil();
                    break;
                case 4:
                    System.out.println("Introduce el nombre a buscar");
                    var name2 =scanner.nextLine();
                    catalogsMovies.searchMovil(name2);
                    break;
                case 5:
                    opcion=0;
                    break;
            }
        }
    }
}

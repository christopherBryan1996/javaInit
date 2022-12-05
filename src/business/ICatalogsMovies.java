package business;

public interface ICatalogsMovies {
    String NAME_FILE="pelicula.txt";
    void addMovil(String nameMovil);

    void listMovil();

    void searchMovil(String search);

    void initFile();
}

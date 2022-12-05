package business;

import data.*;
import domain.Movi;
import exception.AccessControlEX;
import exception.ReadDataEx;

public class CatalogsMoviesImp implements ICatalogsMovies {
    private final IAccessData data;

    public CatalogsMoviesImp() {
        this.data = new AccessDataImp();
    }

    @Override
    public void addMovil(String nameMovil) {
        Movi movi = new Movi(nameMovil);
        boolean append = false;
        try {
            append = data.exists(NAME_FILE);
            data.write(movi, NAME_FILE, append);
        } catch (AccessControlEX e) {
            System.out.println("Error access to data");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listMovil() {
        try {
            var movis = this.data.list(NAME_FILE);
            for(var movi:movis){
                System.out.println("Movi: " + movi);
            }
        } catch (AccessControlEX e) {
            System.out.println("Error access data");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void searchMovil(String search) {
        String result = null;
        try {
            result = this.data.search(NAME_FILE, search);
        } catch (ReadDataEx e) {
            System.out.println("Error in search movil");
            e.printStackTrace(System.out);
        }
        System.out.println("Result: "+ result);
    }

    @Override
    public void initFile() {
        try {
            if(this.data.exists(NAME_FILE)){
                data.delete(NAME_FILE);
                data.create(NAME_FILE);
            }else {
                data.create(NAME_FILE);
            }
        } catch (AccessControlEX e) {
            System.out.println("Error in initial catalog the movils");
            e.printStackTrace(System.out);
        }
    }
}

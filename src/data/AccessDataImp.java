package data;

import domain.Movi;
import exception.*;

import java.io.*;
import java.util.*;

public class AccessDataImp implements IAccessData {

    @Override
    public boolean exists(String nameFile) throws AccessControlEX {
        var file = new File(nameFile);
        return file.exists();
    }

    @Override
    public List<Movi> list(String name) throws ReadDataEx {
        var file = new File(name);
        List<Movi> movis = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String linea = input.readLine();
            while (linea != null) {
                Movi movi = new Movi(linea);
                movis.add(movi);
                linea = input.readLine();
            }
            input.close();
        } catch (FileNotFoundException e) {
            throw new ReadDataEx("Exception in list the Movil: " + e.getMessage());
        } catch (IOException e) {
            throw new ReadDataEx("Exception in read list Movils: " + e.getMessage());
        }
        return movis;
    }

    @Override
    public void write(Movi movi, String nameFile, boolean append) throws WriteDataEX {
        var file = new File(nameFile);
        try {
            var out = new PrintWriter(new FileWriter(file, append));
            out.println(movi.toString());
            out.close();
            System.out.println("The file is written: " + movi);
        } catch (IOException e) {
            throw new WriteDataEX("Exception write the monils: " + e);
        }
    }

    @Override
    public String search(String nameFile, String search) throws ReadDataEx {
        var file = new File(nameFile);
        String result = null;
        try {
            var out = new BufferedReader(new FileReader(file));
            String line = out.readLine();
            int index = 1;
            while (line != null) {
                if (search != null && search.equalsIgnoreCase(line)) {
                    result = "Movil: " + line + " index: " + index;
                    break;
                }
                line = out.readLine();
                index++;
            }
            out.close();
        } catch (FileNotFoundException e) {
            throw new ReadDataEx("Exception in search Movil: " + e.getMessage());
        } catch (IOException e) {
            throw new ReadDataEx("Exception in search Movil: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void create(String nameFile) throws AccessControlEX {
        var file = new File(nameFile);
        try {
            var out = new PrintWriter(new FileWriter(file));
            out.close();
            System.out.println("Success in create file");
        } catch (IOException e) {
            throw new ReadDataEx("Exception in create file: " + e.getMessage());
        }
    }

    @Override
    public void delete(String nameFile) throws AccessControlEX {
        var file = new File(nameFile);
        if (file.exists())
            file.delete();
        System.out.println("Success in delete file");
    }
}

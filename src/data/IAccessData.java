package data;

import domain.Movi;
import exception.*;

import java.util.List;

public interface IAccessData {
    boolean exists(String nameFile) throws AccessControlEX;

    List<Movi> list(String name) throws ReadDataEx;

    void write(Movi movi, String nameFile, boolean append) throws WriteDataEX;

    String search(String nameFile, String search) throws ReadDataEx;

    void create(String nameFile) throws AccessControlEX;

    void delete(String nameFile) throws AccessControlEX;
}

package dam.db;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import dam.pojo.Libro;

import java.util.ArrayList;

public class AccesoBibliotecaDB {

    static final String PATH_DB = "src/main/resources/ddbb/biblioteca.yap";
    ObjectContainer db;

    public AccesoBibliotecaDB() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), PATH_DB);
    }

    public void cerrarDB() {
        db.close();
    }

    public void insertar(Libro libro){
        db.store(libro);
    }


    public ArrayList<Libro> consultarTodosLibros() {
        ArrayList<Libro> listaLibros = new ArrayList<Libro>();

        ObjectSet<Libro> setLibros = db.queryByExample(Libro.class);

        listaLibros.addAll(setLibros);

        return listaLibros;
    }

    public ArrayList<Libro> consultarLibros300(int numPag) {
        Query consulta = db.query();
        consulta.constrain(Libro.class);

        consulta.descend("numPaginas").constrain(numPag).greater();

        ObjectSet<Libro> setLibros = consulta.execute();

        return new ArrayList<Libro>(setLibros);

    }

    public void modificarNumPaginas(String titulo, int numPagN) {
        Query consulta = db.query();
        consulta.constrain(Libro.class);

        consulta.descend("titulo").constrain(titulo);

        ObjectSet<Libro> setNumPag = consulta.execute();

        Libro libro = setNumPag.next();

        libro.setNumPaginas(numPagN);

        db.store(libro);

    }
}

package dam.pojo;

public class Autor {

    private String iniciales;
    private String nombre;
    private String nacionalidad;
    private String informacion;

    public Autor(String iniciales, String nombre, String nacionalidad, String informacion) {
        this.iniciales = iniciales;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.informacion = informacion;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "iniciales='" + iniciales + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", informacion='" + informacion + '\'' +
                '}';
    }
}

public class Alumno { // creación de clase Alumnos (objeto)

    // Atributos del objeto Alumno
    private String nombre;
    private double notaFinal;
    private int edad;

    // Constructor de la clase sabiendo nombre y edad
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // métodos Setter y Getter para introducción y extracción de los valores de los atributos de un Alumno

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //Método para presentar la información de un Alumno por pantalla
    @Override
    public String toString() {
        return "Alumno/a " +
                nombre +
                ", notaFinal= " + notaFinal +
                ", edad= " + edad;
    }
}

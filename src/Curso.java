public class Curso { // creación de clase Curso (objeto contenedor)

    private static final int N_ALUMNOS=30; // Constante que supone el número máximo de alumnos por curso

    // Atributos de un curso
    private Alumno[] alumnos; // array de objetos Alumno que contiene la clase Curso
    private int nAlumno; // contador que nos permite controlar cuantos alumnos hay en el curso

    // Constructor del contenedor Curso vacío.
    public Curso() {
        alumnos = new Alumno[N_ALUMNOS];
        nAlumno = 0;
    }
    // método para introducir un alumno en el curso
    // devuelve true si inserta un alumno o false si no lo hace por estar el curso completo
    public boolean introducirAlumno(Alumno l){
        if (nAlumno >= N_ALUMNOS){// si no caben más alumnos devuelve un false
            return false;
        }
        else { // si caben estudiantes, introduce el alumno y devuelve un true
            alumnos[nAlumno]= l;
            nAlumno++;
            return true;
        }
    }
    /// método para introducir una nota en un alumno
    // devuelve true si introduce la nota o false si no lo hace por no estar el alumno en el curso
    public boolean introducirNota (String nombreA, double nota){
        for (int i = 0; i < nAlumno; i++) {
            if(alumnos[i].getNombre().equalsIgnoreCase(nombreA)){ // compara el nombre sin tener en cuenta si las letras están en mayúscula o minúscula
                alumnos[i].setNotaFinal(nota);
                return true;
            }
        }
        return false;
    }

    // método que muestra el listado de alumnos y sus notas y muestra también la nota media del curso
    public void mostrarInformacionCurso(){
        double sumaNota=0;
        if (nAlumno == 0) System.out.println("No hay alumnos en este curso\n"); // si no hay ningún alumnos en el curso lo muestra por pantalla
        else { // si hay alumnos en el curso
            System.out.println("LISTADO DE ALUMNOS DEL CURSO\n");

            for (int i = 0; i < nAlumno; i++) { // recorre el curso llamando al método toString para cada alumno y así mostrar su información por pantalla
                System.out.println(alumnos[i].toString());
                sumaNota += alumnos[i].getNotaFinal(); // acumulado de notas para el cálculo de la media
            }
            System.out.println("\nLa nota media del curso es: " + sumaNota/nAlumno);
        }
    }

    // método que muestra la información de los estudiantes que empiezan por una letra y muestra también la nota media de esos alumnos
    public void mostrarInformacionPorLetra(char l){
        double sumaNota =0;
        int contAlumnos=0;
        System.out.println("Alumnos que empiezan por la letra: "+l);
        for (int i = 0; i < nAlumno; i++) { // recorre el contenedor0
            if(alumnos[i].getNombre().toLowerCase().charAt(0) == l || alumnos[i].getNombre().charAt(0) == l){ // compara la inicial de cada alumno con la solicitada tanto en mayúscula como en minúscula
                System.out.println(alumnos[i].toString()); // si coincide letra e inicial muestra la información del alumno
                sumaNota += alumnos[i].getNotaFinal(); // acumula la nota para calculo de media
                contAlumnos++;
            }
        }
        if(contAlumnos != 0) System.out.println("La nota media de estos alumnos es: " + sumaNota/contAlumnos);
        else System.out.println("No hay alumnos que empiecen por esa inicial");
    }
}


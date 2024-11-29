
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);// declara un objeto escaner estático y público para poder acceder desde cualquier método
    public static void main(String[] args) {
        gestionMenu(menu());
    }
    public static int menu(){ // muestra el menú y devuelve la opción deseada introducida por teclado
        System.out.println("\nMENÚ ALUMNOS");
        System.out.println("(selecciona la opción deseada)");
        System.out.println("1 - Introducir alumno");
        System.out.println("2 - Introducir nota de alumno");
        System.out.println("3 - Mostrar notas del curso");
        System.out.println("4 - Mostrar alumnos por inicial");
        System.out.println("5 - Salir");
        int opcion =sc.nextInt();
        sc.nextLine();
        return opcion;
    }
    public static void gestionMenu(int opcion){ // mantiene el menú, solicita información por teclado y realiza las llamadas a los métodos necesarios
        Curso curso = new Curso(); // genera un objeto Curso (contenedor)
        while (opcion!=5) { // mantiene el menú mientras la opción seleccionada no sea 5 - Salir
            switch (opcion) {
                case 1: //Introducir alumno
                    System.out.println("Nombre del alumno: ");
                    String nombre = sc.nextLine();
                    System.out.println("Dime la edad del alumno");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    Alumno alumno = new Alumno(nombre,edad); // crea un nuevo objeto alumno

                    if (curso.introducirAlumno(alumno)) // llama al método de introducción de alumnos y ejcuta el condicional según pueda introducirlo o no
                        System.out.println("Alumno introducido en el curso");
                    else System.out.println("No se ha podido introducir el alumno por estar el curso completo");
                    break;


                    case 2: //Introducción de nota del alumno
                        double nota;
                        System.out.println("Nombre del alumno: ");
                        String name = sc.nextLine();
                        do {
                            System.out.println("Nota a introducir: ");
                            nota = sc.nextDouble();
                            if (nota < 0 || nota > 10)
                                System.out.println("La nota introducida debe estar entre 0 y 10");
                        } while (nota < 0 || nota>10); // vuelve a solicitar la nota mientras no esté entre los valores 0 y 10
                        sc.nextLine();
                        if (curso.introducirNota(name,nota)) // llama al método de introducción de nota y ejecuta el condicional según pueda introducirla o no
                            System.out.println("Nota introducida correctamente");
                        else System.out.println("No se ha podido introducir la nota por no existir el alumno");
                        break;

                    case 3: // muestra la información del curso
                        curso.mostrarInformacionCurso(); // llama al método definido para mostrar la información del curso
                        break;

                    case 4: // mostrar alumnos por inicial
                        System.out.println("Introducir inicial: ");
                        char inicial = sc.nextLine().charAt(0); //extrae la inicial solicitada

                        curso.mostrarInformacionPorLetra(inicial); // llama al método definido para mostrar los alumnos que empiezan por la letra
                        break;

                    case 5: // salir
                        System.out.println("ADIÓS");
                        sc.close();
                        System.exit(0);

                    default: // caso en el que se indica un número de opción no definido en el menú
                        System.out.println("La opción indicada no es válida");
            }
            opcion=menu();
        }
    }
}






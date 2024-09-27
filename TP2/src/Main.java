import java.io.File;
import java.util.Scanner;
import controladores.ProcesadorDeTexto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        //Paso 1 ) eliminar archivos en la carpeta archivoTexto
        String rutaYArchivo = "./TP2/src/archivoTexto/Frases.txt";

        File archivo = new File(rutaYArchivo);
        if (archivo.delete()) {
            System.out.println("El archivo ha sido eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo. Asegúrate de que existe y no está en uso.");
        }

        //Paso 2 crear ProcesadorDeTexto
        ProcesadorDeTexto nuevoProcesador = new ProcesadorDeTexto();
        nuevoProcesador.setFileName(rutaYArchivo);

        //Punto A
        mostrarBienvenida();
        menuOpciones(nuevoProcesador);
    }

    public static void mostrarBienvenida() {
        System.out.println("Bienvenido a la aplicación de procesamiento de texto...");
    }
    public static void menuOpciones(ProcesadorDeTexto procesador) {

        Scanner nuevoScanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n ********************* Menú de Opciones: **********************");
            System.out.println("\n El programa funciona si se siguen las siguientes opciones en orden.");

            System.out.println(" a) Mensaje de Bienvenida");
            System.out.println(" b) Ingresar Texto que termine en punto (puede contener varias oraciones separadas por punto)");
            System.out.println(" c) Cantidad de Palabras separadas por espacio.");
            System.out.println(" d) Cantidad de Vocales");
            System.out.println(" e) Cantidad de Consonantes");
            System.out.println(" f) Validar cantidad de caracteres");
            System.out.println(" g) Guardar las Frases separadas por punto");
            System.out.println(" h) Imprimir el total de frases separadas por punto");
            System.out.println(" i) Seleccionar frases");
            System.out.println(" j) Generar fichero txt/csv con las frases\n");
            System.out.println(" Presione cualquier letra para Salir \n");
            System.out.print(" Seleccione una opción: ");

            char opcion = nuevoScanner.next().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a':
                    System.out.println("Opción: Mensaje de Bienvenida");
                    // Llamar a la función correspondiente
                    mostrarBienvenida();
                    break;
                case 'b':
                    System.out.println("Opción: Ingresar Texto");
                    // Llamar a la función correspondiente
                    //Punto B
                    procesador.ingresarTexto();
                    //acceder a getTexto(), acceder al método.
                    //aplicando encapsulamiento.
                    String textoIngresado = procesador.getTexto();
                    System.out.println("Texto ingresado: " + textoIngresado);
                    break;
                case 'c':
                    System.out.println("Opción: Cantidad de Palabras");
                    // Llamar a la función correspondiente
                    //Punto C - Cantidad Palabras
                    int cantidadDePalabras = procesador.contarPalabras();
                    System.out.println("Cantidad de palabras: " + cantidadDePalabras);
                    break;
                case 'd':
                    System.out.println("Opción: Cantidad de Vocales");
                    // Llamar a la función correspondiente
                    //Punto D - cantidad de vocales
                    int cantidadDeVocales = procesador.contarVocales();
                    System.out.println("Cantidad de vocales: " + cantidadDeVocales);
                    break;
                case 'e':
                    System.out.println("Opción: Cantidad de Consonantes");
                    // Llamar a la función correspondiente
                    //Punto E - cantidad de consonantes
                    int cantidadDeConsonantes = procesador.contarConsonantes();
                    System.out.println("Cantidad de consonantes: " + cantidadDeConsonantes);

                    break;
                case 'f':
                    System.out.println("Opción: Validar cantidad de caracteres");
                    // Llamar a la función correspondiente
                    if (procesador.validarLongitud()) {
                        System.out.println("El texto ingresado no supera los 140 caracteres");
                    } else {
                        System.out.println("Error: el texto supera los 140 caracteres");
                    }
                    break;
                case 'g':
                    System.out.println("Opción: Guardar las frases, las frases terminan con .,?!;");
                    // Llamar a la función correspondiente
                    //Punto G - Permitir al usuario guardar las frases
                    //procesador.guardarFrases();
                    procesador.AgregarFrasesALaLista();
                    procesador.EnumerarFrases();


                    break;
                case 'h':
                    System.out.println("Opción: Imprimir el total de frases");
                    // Llamar a la función correspondiente
                    procesador.EnumerarFrases();

                    break;
                case 'i':
                    System.out.println("Opción: Seleccionar frases");
                    // Llamar a la función correspondiente
                    //Punto I - Permitir al usuario seleccionar frases de un listado, editarlas y guardarlas
                    procesador.EnumerarFrases();
                    procesador.seleccionarFrase();
                    procesador.EnumerarFrases();

                    break;
                case 'j':
                    System.out.println("Opción: Generar fichero txt/csv con las frases");
                    // Llamar a la función correspondiente
                    //crear archivo  txt/csv con las frases
                    procesador.generarFichcero();
                    procesador.imprimirTotalDeFrases();

                    break;
                default:
                    System.out.println("Saliendo del programa...\n Gracias por utilizar la aplicación de procesamiento de texto");
                    continuar = false;
                    break;
            }
        }
        nuevoScanner.close();
    }

    //función Menú de opciones.
    //función para mostrar opciones



    /*"P n2
    Consigna
    Crear una aplicacion de consola que procese texto y permita realizar los siguientes puntos:
    a- Mostrar saludo de bienvenida
    b- Permitir ingresar texto
    c- Mostrar por pantalla la cantidad de palabras ingresadas
    d- Mostrar por pantalla la cantidad de vocales ingresadas
    e- Mostrar por pantalla la cantidad de consonantes ingresadas
    Opcionales
    f- Mostrar mensaje de error y no permitir al usuario ingresar frases con mas de 140
    caracteres
    g- Permitir al usuario guardar las frases
    h- Imprimir por pantalla el total de frases
    i- Permitir al usuario seleccionar frases de un listado, editarlas y guardarlas
    j- Generar fichero txt/csv con las frases"

    mandar ahí: liferreira90@gmail.com */


}
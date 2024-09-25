import java.util.Scanner;
import controladores.ProcesadorDeTexto;
public class Main {
    public static void main(String[] args) {

        //Punto A
        mostrarBienvenida();

        //crear un objeto de la clase ProcesadordeTexto que reciba por parámetro un string
        ProcesadorDeTexto procesador = new ProcesadorDeTexto();

        //Punto B
        procesador.ingresarTexto();
        String textoIngresado = procesador.texto;
        System.out.println("Texto ingresado: " + textoIngresado);

        //Punto C - Cantidad Palabras
        int cantidadDePalabras = procesador.contarPalabras();
        System.out.println("Cantidad de palabras: " + cantidadDePalabras);

        //Punto D - cantidad de vocales
        int cantidadDeVocales = procesador.contarVocales();
        System.out.println("Cantidad de vocales: " + cantidadDeVocales);

        //Punto E - cantidad de consonantes
        int cantidadDeConsonantes = procesador.contarConsonantes();
        System.out.println("Cantidad de consonantes: " + cantidadDeConsonantes);

        //Punto F - Validar cantidad de caracteres

        //Punto G - Permitir al usuario guardar las frases
        //despedida
        System.out.println("Gracias por utilizar la aplicación de procesamiento de texto");
    }

    public static void mostrarBienvenida() {
        System.out.println("Bienvenido a la aplicación de procesamiento de texto");
    }
    public static String ingresarTexto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese el texto:");
        return scanner.nextLine();
    }

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
    j- Generar fichero txt/csv con las frases"*/

}
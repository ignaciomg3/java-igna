package controladores;
import java.util.Scanner;

public class ProcesadorDeTexto {
    // Atributos
    public String texto;
    public int cantidadPalabras;
    public int cantidadVocales;
    public int cantidadConsonantes;

    // Constructor
    public ProcesadorDeTexto() {
        this.texto = "";
        this.cantidadPalabras = 0;
        this.cantidadVocales = 0;
        this.cantidadConsonantes = 0;
    }
    //crear un metodo que no sea static


    public void  ingresarTexto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese el texto:");
        String textoIngresado = scanner.nextLine();
        boolean esValido = validarLongitud(textoIngresado);
        //si validarLongitud() devuelve true entonces se ejecuta el this.texto = scanner.nextLine(); de lo contrario volver a pedir
        while (!esValido) {
            System.out.println("Error: el texto no puede superar los 140 caracteres. Por favor, ingrese nuevamente:");
            textoIngresado = scanner.nextLine();
            esValido = validarLongitud(textoIngresado);
        }
        this.texto = textoIngresado;
    }

    public int contarPalabras() {
         this.cantidadPalabras = this.texto.split(" ").length;
         return this.cantidadPalabras;
    }

    public int contarVocales() {
        int contador = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            char caracter = this.texto.charAt(i);
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                contador++;
            }
        }
        this.cantidadVocales = contador;
        return contador;
    }

    public int contarConsonantes() {
        int contador = 0;
        //haceme una lista de letras consonantes
        String textoMinusculas = this.texto.toLowerCase();
        String listaConsonantes = "bcdfghjklmnñpqrstvwxyz";
        // Recorremos cada carácter del texto
        for (char c : textoMinusculas.toCharArray()) {
            // Si el carácter actual está en la lista de consonantes, suma al contador
            // Verifica si el carácter actual es una consonante, devolviendo un valor distinto
            // de -1 si la letra está en la lista de consonantes.
            if (listaConsonantes.indexOf(c) != -1) {
                contador++;
            }
        }
        this.cantidadConsonantes = contador;
        return contador;
    }

    //Punto F - Validar cantidad de caracteres
    private boolean validarLongitud(String textoIngresado) {
        return textoIngresado.split(" ").length <= 140;

    }



    public static void guardarTexto(String texto) {
        // Implementar
    }

    public static void imprimirTotalDeFrases() {
        // Implementar
    }

    public static void seleccionarFrase() {
        // Implementar
    }

    public static void generarFichero(String texto) {
        // Implementar
    }


}

package controladores;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ProcesadorDeTexto {
    // Atributos puedo hacerlos privado.
    private String texto;
    public int cantidadPalabras;
    public int cantidadVocales;
    public int cantidadConsonantes;
    public List<String> listaFrases;
    private String fileName;

    // Constructor
    public ProcesadorDeTexto() {
        this.texto = "";
        this.cantidadPalabras = 0;
        this.cantidadVocales = 0;
        this.cantidadConsonantes = 0;
        this.listaFrases = new ArrayList<>();
        this.fileName = "";

    }

    Scanner scanner = new Scanner(System.in);
    // Métodos
    //comentarios: puedo hacerlos static.
    //Comentario: puedo usar el mismo objeto Scanner en toda la clase.

    public void  ingresarTexto() {
        //Ccomentario: puedo usar el mismo objeto Scanner en toda la clase.
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese el texto:");
        String textoIngresado = scanner.nextLine();
        boolean esValido = validarLongitud();
        //si validarLongitud() devuelve true entonces se ejecuta el this.texto = scanner.nextLine(); de lo contrario volver a pedir
        while (!esValido) {
            System.out.println("Error: el texto no puede superar los 140 caracteres. Por favor, ingrese nuevamente:");
            textoIngresado = scanner.nextLine();
            esValido = validarLongitud();
        }
        this.texto = textoIngresado;
    }

    public int contarPalabras() {
         this.cantidadPalabras = this.texto.split("[.,!? ]+").length;
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
    public boolean validarLongitud() {
        //función que retorne true si la cantidad de palabras es menor o igual a 140
        return this.texto.length() <= 140;
        //return this.texto.split(" ").length <= 140;
    }

    public void AgregarFrasesALaLista() {
        // Implementar
        // Dividir el texto en frases usando el punto, coma o ? como delimitador.
        String[] frases = texto.split("[.,!?]");

        // Recorrer el array de frases y agregar cada una a la lista de Strings.
        for (String frase : frases) {
            // Trim elimina espacios en blanco adicionales
            frase = frase.trim();   //agregar punto al final de la frase

            if (!frase.isEmpty()) {
                listaFrases.add(frase + ".");
            }
        }
    }
    //función que recorra la listaFrases y la enumere.
    public void EnumerarFrases() {
        // Implementar
        // Recorrer la lista de frases y mostrar cada una con un número de índice
        int indice = 1;
        for (String frase : listaFrases) {
            System.out.println("Frase " + indice + "): " + frase );
            indice++;
        }
    }



    public void generarFichero() {

        try (FileWriter fileWriter = new FileWriter(this.fileName)) {
            // Itera sobre cada objeto Conteo en la lista
            //for que recorra la listaFrases y las guarde en el archivo

            for (String frase : listaFrases) {
                fileWriter.write(frase + "\n"); // Escribe el texto de la frase en el archivo

            }

            fileWriter.close();
            System.out.println("Texto guardado en " + this.fileName);




        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el archivo: " + e.getMessage());
        }


    }

    public void imprimirTotalDeFrases() {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linea;
            System.out.println("Contenido del archivo:");

            int indice = 1;
            while ((linea = reader.readLine()) != null) {
                //mostrar número de frase
                System.out.println("Frase " + indice + "): " + linea);
                indice++;
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }
    }

    public void seleccionarFrase() {
        // Implementar
        // Punto i - Permitir al usuario seleccionar frases de un listado, editarlas y guardarlas
        //String fileName = "./TP2/src/archivoTexto/Frases.txt";  // Nombre del archivo


        // Leer el archivo y mostrar el contenido
        //pedir numero de frase
        System.out.println("Por favor, ingrese el número de la frase que desea editar:");
        int numeroFrase = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        BuscarFraseYModificar(numeroFrase);


    }

    private void BuscarFraseYModificar(int numeroFrase) {
        // Implementar

        //recorrer el atributo this.listaFrases y mostrar la frase que corresponda al número ingresado}
        for (int i = 0; i < listaFrases.size(); i++) {
            if (i == numeroFrase - 1) {
                System.out.println("Frase seleccionada: " + listaFrases.get(i));
                System.out.println("Por favor, ingrese la nueva frase:");
                String nuevaFrase = scanner.nextLine();
                listaFrases.set(i, nuevaFrase);
                System.out.println("Frase modificada con éxito.");
                break;
            }
        }

    }



    //métodos get y set
    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    //get y set de fileName
    public String getFileName() {
        return this.fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }



}

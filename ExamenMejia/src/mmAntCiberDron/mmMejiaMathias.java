package mmAntCiberDron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mmMejiaMathias {

    public static void main(String[] args) {
        String miNombre = "Mathías Mejía";
        String miCedula = "1750711473"; 

        mmAntCiberDron miDron = new mmAntCiberDron(miNombre, miCedula);

        System.out.println("=== SISTEMA ANT-CIBER-DRON INICIADO ===");
        System.out.println("Operador: " + miDron.getMmNombre() + " | ID: " + miDron.getMmCedula());
        
        // Prueba de vida (Hormiga Carnívora)
        mmCarnivoro comida = new mmCarnivoro();
        if(miDron.mmComer(comida)) {
            System.out.println("Estado Biológico: VIVO (Alimentado con " + comida.toString() + ")");
        }

        System.out.println("\n[+] LECTURA DE RADAR (CSV):");
        
        // IMPORTANTE: El archivo debe estar en la raíz del proyecto
        String archivoCSV = "MejiaMathias.csv"; 
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            br.readLine(); // Saltar cabecera

            while ((linea = br.readLine()) != null) {
                if(linea.trim().isEmpty()) continue;

                miDron.mmMostrarLoading(); // Efecto visual

                String[] datos = linea.split(";");
                if (datos.length > 0) {
                    String coord = datos[0];
                    String arsenal = datos[datos.length - 1]; // Última columna
                    
                    // Definir palabra de prueba (W) según coordenada
                    String palabraW = (coord.contains("07")) ? "abcdd" : (coord.contains("03") ? "abc" : "a");
                    
                    if (miDron.mmBuscar(arsenal)) {
                        boolean explota = miDron.mmValidarAutomata(palabraW);
                        String estado = explota ? "DETONACIÓN EXITOSA" : "FALLO EN DETONACIÓN";
                        
                        System.out.printf(">> %s detectado en %s. Autómata (%s): %s\n", 
                            arsenal, coord, palabraW, estado);
                    } else {
                        System.out.println(">> " + coord + ": Objetivo ignorado (" + arsenal + ")");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: No encuentro el archivo 'MejiaMathias.csv'");
            System.out.println("Asegúrate de ponerlo fuera de la carpeta src.");
        }
    }
}
package mmAntCiberDron;

public class mmAntCiberDron implements mmIHormiga, mmIIA {
    
    // Atributos Privados
    private String mmNombre;
    private String mmCedula;
    
    // Variable auxiliar para el archivo (Justifica tu Diagrama de Clases)
    private String mmRutaArchivo; 

    public mmAntCiberDron(String nombre, String cedula) {
        this.mmNombre = nombre;
        this.mmCedula = cedula;
        
        // --- CORRECCIÓN AQUÍ ---
        // Asignamos un valor por defecto para que VS Code no marque advertencia amarilla
        this.mmRutaArchivo = "MejiaMathias.csv"; 
    }

    // --- Implementación de mmIHormiga ---
    @Override
    public boolean mmComer(mmAlimento alimento) {
        // Tu hormiga es Carnívora (Cédula impar 3), solo come carne
        return alimento instanceof mmCarnivoro;
    }

    // --- Implementación de mmIIA ---
    @Override
    public boolean mmBuscar(String tipoArsenal) {
        // Tu autómata ataca Dron (Coord-07) y Avión (Coord-03)
        // Retorna true si encuentra alguno de estos
        return tipoArsenal.contains("Dron") || tipoArsenal.contains("Avión");
    }
    
    // --- Método Auxiliar: Validación del Autómata ---
    public boolean mmValidarAutomata(String palabra) {
        // Regex para el patrón abcd* (cubre abc y abcdd...)
        return palabra.matches("abcd*");
    }

    // --- Método Auxiliar: Loading Visual ---
    public void mmMostrarLoading() {
        try {
            System.out.print("Cargando: [");
            for (int i = 0; i <= 10; i++) { 
                System.out.print("="); // Carácter de la barra
                Thread.sleep(20);      // Velocidad de la animación
            }
            System.out.print("] 100%\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Getters
    public String getMmNombre() { return mmNombre; }
    public String getMmCedula() { return mmCedula; }
    
    // Getter para la ruta (Opcional, pero ayuda a limpiar warnings)
    public String getMmRutaArchivo() { return mmRutaArchivo; }
}
public class Robot {
    private int codigo;
    private String nombre;
    private String faccion; // "Autobot" o "Decepticon"
    private int poder;
    private String funcion;

    public Robot() {
        this.codigo = 1;
        this.nombre = "Optimus Prime";
        this.faccion = "Autobot";
        this.poder = 100;
        this.funcion = "Liderazgo";
    }

    // Constructor con parámetros
    public Robot(int codigo, String nombre, String faccion, int poder, String funcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.faccion = faccion;
        this.poder = poder;
        this.funcion = funcion;
    }

    // Getters
    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getFaccion() { return faccion; }
    public int getPoder() { return poder; }
    public String getFuncion() { return funcion; }

    // Método para calcular valor de ataque
    public double getValorAtaque() {
        if (faccion.equalsIgnoreCase("Autobot")) {
            return poder * 1.25;
        } else if (faccion.equalsIgnoreCase("Decepticon")) {
            return poder * 1.10;
        }
        return poder;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Nombre: " + nombre +
                ", Facción: " + faccion +
                ", Poder: " + poder +
                ", Función: " + funcion +
                ", Ataque: " + getValorAtaque();
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class ColaRobot {
    private Queue<Robot> cola;

    public ColaRobot() {
        cola = new LinkedList<>();
    }

    // R1: Encolar 5 robots (1 por defecto y 4 definidos)
    public void inicializarCola() {
        cola.clear();
        cola.add(new Robot());
        cola.add(new Robot(2, "Bumblebee", "Autobot", 90, "Velocidad"));
        cola.add(new Robot(3, "Megatron", "Decepticon", 120, "Evolución"));
        cola.add(new Robot(4, "Starscream", "Decepticon", 95, "Volar"));
        cola.add(new Robot(5, "Ironhide", "Autobot", 110, "Defensa"));
    }

    // Obtener todos los elementos
    public String mostrarCola() {
        StringBuilder sb = new StringBuilder();
        for (Robot r : cola) {
            sb.append(r.toString()).append("\n");
        }
        return sb.toString();
    }

    // R3: Copiar por función
    public ColaRobot copiarPorFuncion(String funcion) {
        ColaRobot nueva = new ColaRobot();
        for (Robot r : cola) {
            if (r.getFuncion().equalsIgnoreCase(funcion)) {
                nueva.cola.add(r);
            }
        }
        return nueva;
    }

    public Queue<Robot> getCola() {
        return cola;
    }
}

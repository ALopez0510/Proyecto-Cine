import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JTextArea txt_colacomp;
    private JTextArea txt_colauq;
    private JButton r1MostrarObjetosColaButton;
    private JButton r2ValorDeAtaqueButton;
    private JButton r3FunciónEspecificaButton;
    private JComboBox cbox_atributos;
    public JPanel panelPrincipal;

    private ColaRobot cola;

    public VentanaPrincipal() {
        cola = new ColaRobot();

        // Llenar ComboBox con funciones posibles
        cbox_atributos.addItem("Liderazgo");
        cbox_atributos.addItem("Velocidad");
        cbox_atributos.addItem("Evolución");
        cbox_atributos.addItem("Volar");
        cbox_atributos.addItem("Defensa");

        // R1: Generar los objetos de la cola
        r1MostrarObjetosColaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola.inicializarCola();
                txt_colauq.setText(cola.mostrarCola());
                txt_colacomp.setText("");
            }
        });

        // R2: Mostrar valor de ataque
        r2ValorDeAtaqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_colauq.setText(cola.mostrarCola());
            }
        });

        // R3: Copiar cola por función
        r3FunciónEspecificaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String funcionSeleccionada = (String) cbox_atributos.getSelectedItem();
                ColaRobot copia = cola.copiarPorFuncion(funcionSeleccionada);
                txt_colacomp.setText(copia.mostrarCola());
            }
        });
    }

    // Método main para ejecutar la interfaz
    public static void main(String[] args) {
        JFrame frame = new JFrame("Evaluación - Cola de Robots");
        frame.setContentPane(new VentanaPrincipal().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

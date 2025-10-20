import javax.swing.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class VentanaPrincipal {

    private JTextArea txt_colacomp;

    private JTextArea txt_column;

    private JButton r1MostrarObjetosColaButton;

    private JButton r2ValorDeAtaqueButton;

    private JButton r3FuncionEspecificaButton;

    private JComboBox<String> cbox_atributos;

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

                txt_column.setText(cola.mostrarCola());

                txt_colacomp.setText("");

            }

        });

        // R2: Mostrar valor de ataque

        r2ValorDeAtaqueButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                txt_column.setText(cola.mostrarCola());

            }

        });

        // R3: Copiar cola por función

        r3FuncionEspecificaButton.addActionListener(new ActionListener() {

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

        SwingUtilities.invokeLater(new Runnable() {

            @Override

            public void run() {

                crearYMostrarGUI();

            }

        });

    }

    private static void crearYMostrarGUI() {

        try {

            // Usar UIManager para mejor apariencia

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());

        } catch (Exception e) {

            e.printStackTrace();

        }

        JFrame frame = new JFrame("Evaluación - Cola de Robots");

        // Crear instancia de VentanaPrincipal

        VentanaPrincipal ventana = new VentanaPrincipal();

        // Verificar que panelPrincipal no sea null

        if (ventana.panelPrincipal == null) {

            JOptionPane.showMessageDialog(null, "Error: panelPrincipal es null. Verifica el diseño de la interfaz.");

            return;

        }

        frame.setContentPane(ventana.panelPrincipal);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);

        frame.setLocationRelativeTo(null); // Centrar la ventana

        frame.setVisible(true);

    }

}
 

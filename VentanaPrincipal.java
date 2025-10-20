import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private ColaRobot cola;
    private JTextArea txtColaOriginal;
    private JTextArea txtColaCopia;
    private JComboBox<String> cmbFuncion;

    public VentanaPrincipal() {
        setTitle("Gestión de Transformers");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        cola = new ColaRobot();

        JLabel lblTitulo = new JLabel("Evaluación Progreso 1 - Transformers");
        lblTitulo.setBounds(250, 10, 400, 30);
        add(lblTitulo);

        JButton btnGenerar = new JButton("R1: Generar Robots");
        btnGenerar.setBounds(50, 60, 200, 30);
        add(btnGenerar);

        JButton btnMostrarAtaque = new JButton("R2: Mostrar Valor de Ataque");
        btnMostrarAtaque.setBounds(270, 60, 230, 30);
        add(btnMostrarAtaque);

        cmbFuncion = new JComboBox<>(new String[]{"Liderazgo", "Velocidad", "Evolución", "Volar", "Defensa"});
        cmbFuncion.setBounds(520, 60, 120, 30);
        add(cmbFuncion);

        JButton btnCopiar = new JButton("R3: Copiar por Función");
        btnCopiar.setBounds(650, 60, 120, 30);
        add(btnCopiar);

        txtColaOriginal = new JTextArea();
        txtColaOriginal.setEditable(false);
        JScrollPane scroll1 = new JScrollPane(txtColaOriginal);
        scroll1.setBounds(50, 120, 330, 400);
        add(scroll1);

        txtColaCopia = new JTextArea();
        txtColaCopia.setEditable(false);
        JScrollPane scroll2 = new JScrollPane(txtColaCopia);
        scroll2.setBounds(420, 120, 330, 400);
        add(scroll2);

        // Eventos
        btnGenerar.addActionListener(e -> {
            cola.inicializarCola();
            txtColaOriginal.setText(cola.mostrarCola());
            txtColaCopia.setText("");
        });

        btnMostrarAtaque.addActionListener(e -> {
            txtColaOriginal.setText(cola.mostrarCola());
        });

        btnCopiar.addActionListener(e -> {
            String funcionSel = (String) cmbFuncion.getSelectedItem();
            ColaRobot copia = cola.copiarPorFuncion(funcionSel);
            txtColaCopia.setText(copia.mostrarCola());
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}

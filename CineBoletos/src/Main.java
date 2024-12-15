import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private final Venta venta;
    private final JComboBox<String> peliculasComboBox;
    private final JComboBox<String> categoriaComboBox;
    private final JComboBox<String> salaComboBox;
    private final JTextField boletosField;
    private final JTextArea resumenArea;

    public Main() {
        venta = new Venta();
        setTitle("Venta de Boletos de Cine");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de la GUI
        peliculasComboBox = new JComboBox<>(new String[]{"Pelicula 1", "Pelicula 2", "Pelicula 3"});
        categoriaComboBox = new JComboBox<>(new String[]{"Adulto", "Niño", "Adulto Mayor"});
        salaComboBox = new JComboBox<>(new String[]{"Normal", "3D"});
        boletosField = new JTextField(5);
        JButton venderButton = new JButton("Vender");
        resumenArea = new JTextArea(10, 30);
        resumenArea.setEditable(false);

        // Agregar componentes a la ventana
        add(new JLabel("Selecciona la película:"));
        add(peliculasComboBox);
        add(new JLabel("Número de boletos:"));
        add(boletosField);
        add(new JLabel("Categoría:"));
        add(categoriaComboBox);
        add(new JLabel("Tipo de sala:"));
        add(salaComboBox);
        add(venderButton);
        add(new JScrollPane(resumenArea));

        // Acción del botón
        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarVenta();
            }
        });
    }

    private void procesarVenta() {
        try {
            int numBoletos = Integer.parseInt(boletosField.getText());
            int categoria = categoriaComboBox.getSelectedIndex(); // 0: Adulto, 1: Niño, 2: Adulto Mayor
            String tipoSala = (String) salaComboBox.getSelectedItem();

            // Aquí puedes agregar lógica para determinar si es miércoles o si es antes de las 18:00
            boolean esMiércoles = false; // Cambia esto según la lógica que desees implementar
            boolean esAntesDeLas18 = true; // Cambia esto según la lógica que desees implementar

            double precio = venta.calcularPrecio(categoria, tipoSala, esMiércoles, esAntesDeLas18);
            for (int i = 0; i < numBoletos; i++) {
                venta.registrarVenta(tipoSala, precio);
            }

            // Mostrar resumen
            mostrarResumen();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido de boletos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResumen() {
        StringBuilder resumen = new StringBuilder();
        for (Sala sala : venta.getSalas()) {
            resumen.append("Sala: ").append(sala.getTipo())
                    .append(" - Boletos Vendidos: ").append(sala.getBoletosVendidos())
                    .append(" - Total Recaudado: $").append(sala.getTotalRecaudado()).append("\n");
        }
        resumenArea.setText(resumen.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
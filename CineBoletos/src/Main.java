/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private final JComboBox<String> peliculasComboBox;
    private final JTextField boletosField;
    private final JComboBox<String> categoriaComboBox;
    private final JComboBox<String> salaComboBox;
    private final JButton venderButton;
    private final JButton resumenButton;
    private final Venta venta;

    public Main() {
        venta = new Venta();
        setTitle("Venta de Boletos de Cine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de la GUI
        peliculasComboBox = new JComboBox<>(new String[]{"Pelicula 1", "Pelicula 2", "Pelicula 3"});
        boletosField = new JTextField(5);
        categoriaComboBox = new JComboBox<>(new String[]{"Adulto", "Niño", "Adulto Mayor"});
        salaComboBox = new JComboBox<>(new String[]{"Normal", "3D"});
        venderButton = new JButton("Vender");
        resumenButton = new JButton("Mostrar Resumen");

        add(new JLabel("Selecciona la Película:"));
        add(peliculasComboBox);
        add(new JLabel("Número de Boletos:"));
        add(boletosField);
        add(new JLabel("Categoría:"));
        add(categoriaComboBox);
        add(new JLabel("Tipo de Sala:"));
        add(salaComboBox);
        add(venderButton);
        add(resumenButton);

        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarVenta();
            }
        });

        resumenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });
    }

    private void procesarVenta() {
        try {
            int numBoletos = Integer.parseInt(boletosField.getText());
            int categoria = categoriaComboBox.getSelectedIndex(); // 0: Adulto, 1: Niño, 2: Adulto Mayor
            String tipoSala = (String) salaComboBox.getSelectedItem();
            boolean esMiércoles = (JOptionPane.showConfirmDialog(this, "¿Es miércoles?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
            boolean esAntesDeLas18 = (JOptionPane.showConfirmDialog(this, "¿Es antes de las 18:00?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

            double precioPorBoleto = venta.calcularPrecio(categoria, tipoSala, esMiércoles, esAntesDeLas18);
            double total = precioPorBoleto * numBoletos;

            venta.registrarVenta(tipoSala, total);
            JOptionPane.showMessageDialog(this, "Venta realizada. Total: $" + total);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido de boletos.");
        }
    }

    private void mostrarResumen() {
        StringBuilder resumen = new StringBuilder("Resumen de Ventas:\n");
        for (Sala sala : venta.getSalas()) {
            resumen.append("Sala ").append(sala.getTipo())
                    .append(": Boletos Vendidos: ").append(sala.getBoletosVendidos())
                    .append(", Total Recaudado: $").append(sala.getTotalRecaudado()).append("\n");
        }
        JOptionPane.showMessageDialog(this, resumen.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
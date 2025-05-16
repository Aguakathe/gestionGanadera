/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

class PanelGrafica extends JPanel {
    ArrayList<String> fechas;
    ArrayList<Integer> compras;
    ArrayList<Integer> ventas;

    public PanelGrafica(ArrayList<String> fechas, ArrayList<Integer> compras, ArrayList<Integer> ventas) {
        this.fechas = fechas;
        this.compras = compras;
        this.ventas = ventas;
        int height = fechas.size() * 60 + 100;
        setPreferredSize(new Dimension(700, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fechas.isEmpty()) {
            g.setColor(Color.RED);
            g.drawString("No hay datos disponibles para graficar.", 100, 100);
            return;
        }

        int y = 100;
        int max = Math.max(
            compras.stream().max(Integer::compareTo).orElse(1),
            ventas.stream().max(Integer::compareTo).orElse(1)
        );

        for (int i = 0; i < fechas.size(); i++) {
            int compBar = compras.get(i) * 300 / max;
            int ventBar = ventas.get(i) * 300 / max;

            g.setColor(Color.GREEN);
            g.fillRect(150, y, compBar, 20);
            g.setColor(Color.BLUE);
            g.fillRect(150, y + 25, ventBar, 20);

            g.setColor(Color.BLACK);
            g.drawString(fechas.get(i), 10, y + 15);
            g.drawString("Compra: " + compras.get(i), 460, y + 15);
            g.drawString("Venta: " + ventas.get(i), 460, y + 40);

            y += 60;
        }
    }
}

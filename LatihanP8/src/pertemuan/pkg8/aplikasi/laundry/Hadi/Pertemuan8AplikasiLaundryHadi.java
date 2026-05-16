package pertemuan.pkg8.aplikasi.laundry.Hadi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pertemuan8AplikasiLaundryHadi extends JFrame {

    private JTextField txtCustomer, txtWeight, txtTotal;
    private JComboBox<String> cbService;
    private JButton btnCalculate, btnClear, btnExit;

    public Pertemuan8AplikasiLaundryHadi() {
        setTitle("Aplikasi Laundry Hadi");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label & Field Customer
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Nama Pelanggan:"), gbc);
        gbc.gridx = 1;
        txtCustomer = new JTextField(15);
        add(txtCustomer, gbc);

        // Label & Combo Service
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Jenis Layanan:"), gbc);
        gbc.gridx = 1;
        String[] services = {"Cuci Kering (Rp 5.000)", "Cuci Setrika (Rp 7.000)", "Setrika Saja (Rp 4.000)"};
        cbService = new JComboBox<>(services);
        add(cbService, gbc);

        // Label & Field Weight
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Berat (Kg):"), gbc);
        gbc.gridx = 1;
        txtWeight = new JTextField(15);
        add(txtWeight, gbc);

        // Label & Field Total
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Total Harga:"), gbc);
        gbc.gridx = 1;
        txtTotal = new JTextField(15);
        txtTotal.setEditable(false);
        txtTotal.setBackground(Color.LIGHT_GRAY);
        add(txtTotal, gbc);

        // Buttons
        JPanel panelButtons = new JPanel();
        btnCalculate = new JButton("Hitung");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Keluar");
        panelButtons.add(btnCalculate);
        panelButtons.add(btnClear);
        panelButtons.add(btnExit);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(panelButtons, gbc);

        // Action Listeners
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCustomer.setText("");
                txtWeight.setText("");
                txtTotal.setText("");
                cbService.setSelectedIndex(0);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void calculateTotal() {
        try {
            double weight = Double.parseDouble(txtWeight.getText());
            int price = 0;
            int selectedIndex = cbService.getSelectedIndex();
            
            if (selectedIndex == 0) price = 5000;
            else if (selectedIndex == 1) price = 7000;
            else if (selectedIndex == 2) price = 4000;

            double total = weight * price;
            txtTotal.setText("Rp " + String.format("%,.0f", total));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan berat dalam angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Pertemuan8AplikasiLaundryHadi().setVisible(true);
            }
        });
    }
}

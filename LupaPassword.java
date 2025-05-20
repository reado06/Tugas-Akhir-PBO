package Project.PenjualanSepeda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LupaPassword extends JFrame implements ActionListener {
    private JLabel lblJudul, lblUsername, lblEmail, lblPertanyaanKeamanan;
    private JTextField txtUsername, txtEmail, txtJawabanKeamanan;
    private JButton btnReset, btnKembali;

    public LupaPassword() {
        super("CyclePro - Lupa Password");

        // * Inisialisasi Komponen
        lblJudul = new JLabel("Reset Password");
        lblJudul.setFont(new Font("Arial", Font.BOLD, 20));

        lblUsername = new JLabel("Username");
        lblEmail = new JLabel("Email");
        lblPertanyaanKeamanan = new JLabel("Nama hewan peliharaan favorit Anda");

        txtUsername = new JTextField(20);
        txtEmail = new JTextField(20);
        txtJawabanKeamanan = new JTextField(20);

        btnReset = new JButton("Reset Password");
        btnKembali = new JButton("Kembali ke Login");

        setLayout(null);

        // * Set posisi dan ukuran

        lblJudul.setBounds(120, 30, 200, 30);

        lblUsername.setBounds(50, 80, 100, 25);
        txtUsername.setBounds(50, 110, 300, 25);

        lblEmail.setBounds(50, 145, 100, 25);
        txtEmail.setBounds(50, 175, 300, 25);

        lblPertanyaanKeamanan.setBounds(50, 210, 300, 25);
        txtJawabanKeamanan.setBounds(50, 240, 300, 25);

        btnReset.setBounds(50, 290, 140, 30);
        btnKembali.setBounds(210, 290, 140, 30);

        setSize(420, 420);

        add(lblJudul);
        add(lblUsername);
        add(txtUsername);
        add(lblEmail);
        add(txtEmail);
        add(lblPertanyaanKeamanan);
        add(txtJawabanKeamanan);
        add(btnReset);
        add(btnKembali);

        btnReset.addActionListener(this);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReset) {
            // * Validasi Input
            if (txtUsername.getText().isEmpty() || txtEmail.getText().isEmpty() ||
            txtJawabanKeamanan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String username = txtUsername.getText();
            String jawabanKeamanan = txtJawabanKeamanan.getText().toLowerCase(); 

            boolean validasiSukses = false;

            // * Contoh validasi (untuk demo)
            if (username.equals("ridho") && jawabanKeamanan.equals("kucing")) {
                validasiSukses = true;
            }

            if (validasiSukses) {
                // * Karena berhasil, buat password baru
                String passwordBaru = "password123";

                JOptionPane.showMessageDialog(this, "Password Anda telah direset!\n" + 
                "Password baru Anda adalah " + passwordBaru + "\n", "Reset Password berhasil", 
                JOptionPane.INFORMATION_MESSAGE);

                this.dispose();
                new Login();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Informasi yang Anda masukkan tidak valid.", 
                    "Validasi Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnKembali) {
            this.dispose(); // * Tutup jendela lupa password
            new Login(); // * Kembali ke login
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LupaPassword().setVisible(true));
    }
}
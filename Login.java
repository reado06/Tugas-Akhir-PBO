package Project.PenjualanSepeda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    // * Deklarasi Komponen GUI
    JLabel lblJudul, lblUsername, lblPassword;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin, btnLupaPassword, btnBuatAkun;

    public Login() {
        // * Judul Aplikasi
        super("CyclePro Login");

        lblJudul = new JLabel("Selamat Datang di CyclePro");
        lblJudul.setFont(new Font("Arial", Font.BOLD, 20));

        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");

        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);

        btnLogin = new JButton("Login");
        btnLupaPassword = new JButton("Lupa Password?");
        btnBuatAkun = new JButton("Buat Akun Cycle Pro");

        setLayout(null);

        // * Posisi dan Ukuran Komponen
        lblJudul.setBounds(90, 30, 300, 30);

        lblUsername.setBounds(50, 90, 80, 25);
        txtUsername.setBounds(150, 90, 200, 25);

        lblPassword.setBounds(50, 130, 80, 25);
        txtPassword.setBounds(150, 130, 200, 25);

        btnLogin.setBounds(150, 180, 100, 30);

        btnLupaPassword.setBounds(50, 230, 150, 25);
        btnBuatAkun.setBounds(220, 230, 150, 25);

        add(lblJudul);
        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(btnLogin);
        add(btnLupaPassword);
        add(btnBuatAkun);

        btnLogin.addActionListener(this);
        btnLupaPassword.addActionListener(this);
        btnBuatAkun.addActionListener(this);

        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (username.equals("ridho") && password.equals("qwerty")) {
                JOptionPane.showMessageDialog(this, "Login Berhasil!");
                // Pindah ke halaman utama ==> BELUM ADA
            } else {
                JOptionPane.showMessageDialog(this, "Username atau Password salah!", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Tombol Login diklik. Username: " + username + ", Password: " + password);
        } else if (e.getSource() == btnLupaPassword) {
            this.dispose();
            new LupaPassword().setVisible(true); // * Buka Halaman Lupa Password
            System.out.println("Tombol Lupa Password diklik.");
        } else if (e.getSource() == btnBuatAkun) {
            JOptionPane.showMessageDialog(this, "Fitur Buat Akun belum diimplementasikan.");
            System.out.println("Tombol Buat Akun diklik.");
            // Pindah ke halaman Buat Akun ==> BELUM ADA
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}

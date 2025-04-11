/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihm;

/**
 *
 * @author DELL
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import javax.swing.JLabel;

import javax.swing.JButton;

public class Authentification extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Authentification frame = new Authentification();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Authentification() {
        setTitle("Authentification");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 320);
        setLocationRelativeTo(null); // Centrer la fenêtre
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon("D:\\Gestion de Parc Informatique\\Icone\\logo.png"));
        lblLogo.setBounds(150, 10, 150, 50);
        panel.add(lblLogo);

        JLabel lblLogin = new JLabel("Nom d'utilisateur :");
        lblLogin.setBounds(50, 80, 120, 25);
        panel.add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setBounds(180, 80, 200, 25);
        panel.add(txtLogin);

        JLabel lblPassword = new JLabel("Mot de passe :");
        lblPassword.setBounds(50, 120, 120, 25);
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 120, 200, 25);
        panel.add(txtPassword);

        JButton btnLogin = new JButton("Se connecter");
        btnLogin.setBackground(new Color(70, 130, 180));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBounds(180, 170, 200, 30);
        panel.add(btnLogin);

        JButton btnCancel = new JButton("Annuler");
        btnCancel.setBounds(180, 210, 200, 30);
        panel.add(btnCancel);

        // Action bouton connexion
        btnLogin.addActionListener(e -> {
            String login = txtLogin.getText();
            String password = new String(txtPassword.getPassword());

            if (login.equals("Admin") && password.equals("123456")) {
                JOptionPane.showMessageDialog(this, "Connexion réussie !");
              // TODO: rediriger vers la page d’accueil
                new ihm().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nom d'utilisateur ou mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action bouton annuler
        btnCancel.addActionListener(e -> System.exit(0));
    }
}


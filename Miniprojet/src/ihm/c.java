package ihm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class c extends JFrame {

    private JTextField txtIdCommande;
    private JTextField txtNomMateriel;
    private JTextField txtMarque;
    private JTextField txtPrix;
    private JTextField txtQuantite;

    private JTable tableLignesCommande;
    private DefaultTableModel model;

    public c() {
        setTitle("Gestion Simplifiée des Commandes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTitre = new JLabel("Nouvelle Commande");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitre.setBounds(20, 10, 300, 30);
        add(lblTitre);

        // Champs de saisie
        JLabel lblIdCmd = new JLabel("ID Commande :");
        JLabel lblNom = new JLabel("Nom Matériel :");
        JLabel lblMarque = new JLabel("Marque :");
        JLabel lblPrix = new JLabel("Prix :");
        JLabel lblQte = new JLabel("Quantité :");

        txtIdCommande = new JTextField();
        txtNomMateriel = new JTextField();
        txtMarque = new JTextField();
        txtPrix = new JTextField();
        txtQuantite = new JTextField();

        lblIdCmd.setBounds(20, 60, 100, 25);
        txtIdCommande.setBounds(130, 60, 150, 25);

        lblNom.setBounds(20, 100, 100, 25);
        txtNomMateriel.setBounds(130, 100, 150, 25);

        lblMarque.setBounds(20, 140, 100, 25);
        txtMarque.setBounds(130, 140, 150, 25);

        lblPrix.setBounds(20, 180, 100, 25);
        txtPrix.setBounds(130, 180, 150, 25);

        lblQte.setBounds(20, 220, 100, 25);
        txtQuantite.setBounds(130, 220, 150, 25);

        add(lblIdCmd); add(txtIdCommande);
        add(lblNom); add(txtNomMateriel);
        add(lblMarque); add(txtMarque);
        add(lblPrix); add(txtPrix);
        add(lblQte); add(txtQuantite);

        // Boutons
        JButton btnAjouter = new JButton("Ajouter Ligne");
        JButton btnModifier = new JButton("Modifier Ligne");

        btnAjouter.setBounds(20, 270, 130, 30);
        btnModifier.setBounds(160, 270, 130, 30);

        add(btnAjouter);
        add(btnModifier);

        // Tableau
        model = new DefaultTableModel(new String[]{"ID Cmd", "Nom", "Marque", "Prix", "Quantité"}, 0);
        tableLignesCommande = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableLignesCommande);
        scrollPane.setBounds(320, 60, 500, 400);
        add(scrollPane);

        // Ajouter une ligne
        btnAjouter.addActionListener(e -> {
            if (champsRemplis()) {
                model.addRow(new Object[]{
                    txtIdCommande.getText(),
                    txtNomMateriel.getText(),
                    txtMarque.getText(),
                    txtPrix.getText(),
                    txtQuantite.getText()
                });
                viderChamps();
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            }
        });

        // Cliquer sur une ligne pour la charger
        tableLignesCommande.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int ligne = tableLignesCommande.getSelectedRow();
                if (ligne != -1) {
                    txtIdCommande.setText(model.getValueAt(ligne, 0).toString());
                    txtNomMateriel.setText(model.getValueAt(ligne, 1).toString());
                    txtMarque.setText(model.getValueAt(ligne, 2).toString());
                    txtPrix.setText(model.getValueAt(ligne, 3).toString());
                    txtQuantite.setText(model.getValueAt(ligne, 4).toString());
                }
            }
        });

        // Modifier la ligne sélectionnée
        btnModifier.addActionListener(e -> {
            int ligne = tableLignesCommande.getSelectedRow();
            if (ligne != -1 && champsRemplis()) {
                model.setValueAt(txtIdCommande.getText(), ligne, 0);
                model.setValueAt(txtNomMateriel.getText(), ligne, 1);
                model.setValueAt(txtMarque.getText(), ligne, 2);
                model.setValueAt(txtPrix.getText(), ligne, 3);
                model.setValueAt(txtQuantite.getText(), ligne, 4);
                viderChamps();
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne et remplir les champs.");
            }
        });

        setVisible(true);
    }

    private boolean champsRemplis() {
        return !txtIdCommande.getText().isEmpty()
            && !txtNomMateriel.getText().isEmpty()
            && !txtMarque.getText().isEmpty()
            && !txtPrix.getText().isEmpty()
            && !txtQuantite.getText().isEmpty();
    }

    private void viderChamps() {
        txtIdCommande.setText("");
        txtNomMateriel.setText("");
        txtMarque.setText("");
        txtPrix.setText("");
        txtQuantite.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new c());
    }
}

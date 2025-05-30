/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ihm;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JPanel;



/**
 *
 * @author hp
 */
public class FenetreProfil extends javax.swing.JFrame{
   private Map<String, String> ttrData = new HashMap<>();
   private Map<String, List<String>> ticsParPerso = new HashMap<>();


    /**
     * Creates new form FenetreProfil
     */
    public FenetreProfil() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 248, 255)); 

 

        comboPersonnage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
         "", "Chandler", "Joey", "Monica", "Phoebe", "Rachel", "Ross"
        }));
        labelImage.setVisible(false);
        textTics.setVisible(false);
        textProfil.setVisible(false); // TTR
        jLabelTics.setVisible(false);


        chargerTTRDepuisCSV(); // pour charger les TTR dès le démarrage
        chargerTicsDepuisCSV();
        comboPersonnage.addActionListener(e -> comboPersonnageActionPerformed(null));
        comboPersonnage.setSelectedIndex(0); // Sélectionne la case vide
        comboPersonnageActionPerformed(null);

        List<String> testTics = ticsParPerso.get("joey");
        System.out.println("TEST — Tics de joey : " + testTics);

  
    }
    private void chargerTTRDepuisCSV() {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        getClass().getResourceAsStream("/ihm/idf_ttr_per_character.csv")))) {

        String line = reader.readLine(); // on saute l’en-tête
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                ttrData.put(parts[0].toLowerCase(), parts[1]);
            }
        }
    } catch (IOException | NullPointerException e) {
        e.printStackTrace();
    }
  }
    private void chargerTicsDepuisCSV() {
    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(getClass().getResourceAsStream("/ihm/tics_langagiers_result.csv")))) {

        String line = reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", 2); // juste 2 colonnes

            if (parts.length >= 2) {
                String perso = parts[0].trim().toLowerCase();
                String tic = parts[1].trim();

                if (!tic.isEmpty()) {
                    List<String> tics = ticsParPerso.getOrDefault(perso, new ArrayList<>());
                    if (!tics.contains(tic)) {
                        tics.add(tic);
                    }
                    ticsParPerso.put(perso, tics);
                }
            }
        }

        System.out.println("TICS CHARGÉS : " + ticsParPerso.keySet());

    } catch (IOException | NullPointerException e) {
        e.printStackTrace();
    }
}
public JPanel getContent() {
    return (JPanel) this.getContentPane();
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboPersonnage = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textProfil = new javax.swing.JTextArea();
        labelImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textTics = new javax.swing.JTextArea();
        labelFace = new javax.swing.JLabel();
        jLabelTics = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        comboPersonnage.setBackground(new java.awt.Color(249, 247, 249));
        comboPersonnage.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        comboPersonnage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chandler", "Joey", "Monica", "Phoebe", "Rachel", "Ross" }));
        comboPersonnage.setOpaque(true);
        comboPersonnage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPersonnageActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(245, 248, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sélectionnez un personnage");
        jLabel1.setOpaque(true);

        textProfil.setEditable(false);
        textProfil.setBackground(new java.awt.Color(215, 236, 248));
        textProfil.setColumns(20);
        textProfil.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        textProfil.setLineWrap(true);
        textProfil.setRows(5);
        textProfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(166, 201, 226)));
        jScrollPane2.setViewportView(textProfil);

        labelImage.setBackground(new java.awt.Color(249, 249, 249));
        labelImage.setPreferredSize(new java.awt.Dimension(400, 250));

        textTics.setEditable(false);
        textTics.setBackground(new java.awt.Color(248, 214, 223));
        textTics.setColumns(20);
        textTics.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        textTics.setRows(5);
        textTics.setWrapStyleWord(true);
        textTics.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 155, 179)));
        textTics.setName("textTics\n"); // NOI18N
        jScrollPane3.setViewportView(textTics);

        labelFace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFace.setText("jLabel3");
        labelFace.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabelTics.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTics.setForeground(new java.awt.Color(102, 0, 102));
        jLabelTics.setText("Tics de langage  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboPersonnage, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelTics)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(76, 76, 76)
                                .addComponent(labelFace, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(231, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 492, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 493, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPersonnage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTics)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(labelFace, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 420, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 420, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboPersonnageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPersonnageActionPerformed
      // TODO add your handling code here:
        String nom = comboPersonnage.getSelectedItem().toString();
        
        if (nom == null || nom.isEmpty()) {
            // Masquer tous les composants
            textProfil.setText("");
            textTics.setText("");
            labelImage.setIcon(null);

            
            labelImage.setVisible(false);
            textProfil.setVisible(false);
            textTics.setVisible(false);
            jScrollPane2.setVisible(false);
            jScrollPane3.setVisible(false);
            labelFace.setVisible(false);
            // En plus : Rétrécit les scrollpane à 0x0
            jScrollPane2.setPreferredSize(new java.awt.Dimension(0, 0));
            jScrollPane3.setPreferredSize(new java.awt.Dimension(0, 0));

            this.revalidate(); // Relayout
            this.repaint();    // Redessine

            return;
        }

        // Afficher les composants
        labelImage.setVisible(true);
        textProfil.setVisible(true);
        textTics.setVisible(true);
        jScrollPane2.setVisible(true);
        jScrollPane3.setVisible(true);
        labelFace.setVisible(true);
        jLabelTics.setVisible(true);
        jScrollPane2.setPreferredSize(null); // remet taille auto
        jScrollPane3.setPreferredSize(null);


      // Texte du TTR depuis le CSV
      String ttr = ttrData.getOrDefault(nom.toLowerCase(), "inconnu");
      textProfil.setText("TTR : " + ttr);
      // Tics
      List<String> tics = ticsParPerso.getOrDefault(nom.toLowerCase(), new ArrayList<>());
      StringBuilder sb = new StringBuilder();
      for (String tic : tics) {
        if (tic.contains(".")) {
            String[] parts = tic.split("\\.");
            if (parts.length == 2) {
                sb.append("• ").append(parts[0]).append(" — ").append(parts[1]).append("\n");
            } else {
                sb.append("• ").append(tic).append("\n");
            }
        } else {
            sb.append("• ").append(tic).append("\n");
        }
    }

    textTics.setText(sb.toString());
    System.out.println("DEBUG — Perso : " + nom.toLowerCase());
    System.out.println("TICS TROUVÉS : " + tics);

     
    String imagePath = "/ihm/images/phrases_" + nom.toLowerCase() + ".png";
    labelImage.setIcon(new ImageIcon(getClass().getResource(imagePath)));
    String facePath = "/ihm/images/faces/" + nom.toLowerCase() + "_face.png";
    System.out.println("Tentative de chargement : " + facePath);

    try {
        java.net.URL url = getClass().getResource(facePath);
        System.out.println("URL trouvée = " + url);

        if (url == null) {
            labelFace.setIcon(null);
            labelFace.setText("Image non trouvée");
            return;
        }

        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        labelFace.setIcon(new ImageIcon(img));
        labelFace.setText("");
    } catch (Exception ex) {
        ex.printStackTrace();
        labelFace.setIcon(null);
        labelFace.setText("Erreur");
    }

    labelFace.setVisible(true);
    labelFace.repaint();

    }//GEN-LAST:event_comboPersonnageActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FenetreProfil().setVisible(true));
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboPersonnage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTics;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelFace;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextArea textProfil;
    private javax.swing.JTextArea textTics;
    // End of variables declaration//GEN-END:variables
}

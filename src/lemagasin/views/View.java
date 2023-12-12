/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lemagasin.views;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import lemagasin.ctrl.Ctrl;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author waeberla
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        ouvert = false;
        turnOnApplication(ouvert);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAjout = new javax.swing.JPanel();
        lTitre = new javax.swing.JLabel();
        lGenreStock = new javax.swing.JLabel();
        tGenreStock = new javax.swing.JTextField();
        lNbrStock = new javax.swing.JLabel();
        tNbrStock = new javax.swing.JTextField();
        lPrixStock = new javax.swing.JLabel();
        tPrixStock = new javax.swing.JTextField();
        bAjouteStock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taListeStock = new javax.swing.JTextArea();
        lTitre2 = new javax.swing.JLabel();
        tNbrEnStock = new javax.swing.JTextField();
        lTitre3 = new javax.swing.JLabel();
        tNbrMaxStock = new javax.swing.JTextField();
        panelAchat = new javax.swing.JPanel();
        lTitre1 = new javax.swing.JLabel();
        bAjoutePanier = new javax.swing.JButton();
        lGenreAchat = new javax.swing.JLabel();
        lNbrAchat = new javax.swing.JLabel();
        tNbrAchat = new javax.swing.JTextField();
        cChoixGenre = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        taFacture = new javax.swing.JTextArea();
        lTitreFacture = new javax.swing.JLabel();
        bNouvelleFacture = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tMontantDeLaCaisse = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tNbrElemFacture = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tNbrMaxElemFacture = new javax.swing.JTextField();
        panelLogo = new javax.swing.JPanel();
        lLogo = new javax.swing.JLabel();
        bOuverture = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mon petit magasin  logus EMF  2015");

        panelAjout.setBackground(new java.awt.Color(204, 255, 204));

        lTitre.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitre.setText("LE STOCK");

        lGenreStock.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lGenreStock.setText("Article");

        tGenreStock.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lNbrStock.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lNbrStock.setText("Nbr en stock");

        tNbrStock.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tNbrStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tNbrStockFocusLost(evt);
            }
        });

        lPrixStock.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lPrixStock.setText("Prix unitaire");

        tPrixStock.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tPrixStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tPrixStockFocusLost(evt);
            }
        });

        bAjouteStock.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        bAjouteStock.setText("Ajoute au stock");
        bAjouteStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouteStockActionPerformed(evt);
            }
        });

        taListeStock.setEditable(false);
        taListeStock.setColumns(20);
        taListeStock.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        taListeStock.setRows(5);
        taListeStock.setFocusable(false);
        jScrollPane1.setViewportView(taListeStock);

        lTitre2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lTitre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitre2.setText("Nombre de d'articles en stock");

        tNbrEnStock.setEditable(false);
        tNbrEnStock.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tNbrEnStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tNbrEnStock.setText("0");
        tNbrEnStock.setFocusable(false);

        lTitre3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lTitre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitre3.setText("/");

        tNbrMaxStock.setEditable(false);
        tNbrMaxStock.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tNbrMaxStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tNbrMaxStock.setText("10");
        tNbrMaxStock.setFocusable(false);

        javax.swing.GroupLayout panelAjoutLayout = new javax.swing.GroupLayout(panelAjout);
        panelAjout.setLayout(panelAjoutLayout);
        panelAjoutLayout.setHorizontalGroup(
            panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAjoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAjoutLayout.createSequentialGroup()
                        .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bAjouteStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAjoutLayout.createSequentialGroup()
                                .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lNbrStock)
                                    .addComponent(lGenreStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lPrixStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNbrStock, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(tGenreStock)
                                    .addComponent(tPrixStock))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAjoutLayout.createSequentialGroup()
                        .addComponent(lTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lTitre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tNbrEnStock, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lTitre3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tNbrMaxStock, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelAjoutLayout.setVerticalGroup(
            panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAjoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNbrMaxStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTitre3)
                    .addComponent(tNbrEnStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTitre2)
                    .addComponent(lTitre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAjoutLayout.createSequentialGroup()
                        .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lGenreStock, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tGenreStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNbrStock)
                            .addComponent(tNbrStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tPrixStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPrixStock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAjouteStock))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelAchat.setBackground(new java.awt.Color(255, 255, 204));

        lTitre1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lTitre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitre1.setText("Achat d'article");

        bAjoutePanier.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/images/panier1.gif"))); // NOI18N
        bAjoutePanier.setToolTipText("Ajoute un achat au panier");
        bAjoutePanier.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bAjoutePanier.setBorderPainted(false);
        bAjoutePanier.setOpaque(false);
        bAjoutePanier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjoutePanierActionPerformed(evt);
            }
        });

        lGenreAchat.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lGenreAchat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lGenreAchat.setText("Article");

        lNbrAchat.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lNbrAchat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNbrAchat.setText("Nombre");

        tNbrAchat.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tNbrAchat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tNbrAchatFocusLost(evt);
            }
        });

        cChoixGenre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        taFacture.setBackground(new java.awt.Color(255, 255, 153));
        taFacture.setColumns(20);
        taFacture.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        taFacture.setRows(5);
        jScrollPane2.setViewportView(taFacture);

        lTitreFacture.setBackground(new java.awt.Color(255, 255, 153));
        lTitreFacture.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lTitreFacture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitreFacture.setText("Facture du ");
        lTitreFacture.setOpaque(true);

        bNouvelleFacture.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        bNouvelleFacture.setText("Nouvelle facture");
        bNouvelleFacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNouvelleFactureActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Montant de la CAISSE");

        tMontantDeLaCaisse.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tMontantDeLaCaisse.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tMontantDeLaCaisse.setText("0.0");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Nombre d'articles sur la facture");

        tNbrElemFacture.setEditable(false);
        tNbrElemFacture.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tNbrElemFacture.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tNbrElemFacture.setText("0");
        tNbrElemFacture.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("/");

        tNbrMaxElemFacture.setEditable(false);
        tNbrMaxElemFacture.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tNbrMaxElemFacture.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tNbrMaxElemFacture.setText("5");
        tNbrMaxElemFacture.setFocusable(false);

        javax.swing.GroupLayout panelAchatLayout = new javax.swing.GroupLayout(panelAchat);
        panelAchat.setLayout(panelAchatLayout);
        panelAchatLayout.setHorizontalGroup(
            panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAchatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelAchatLayout.createSequentialGroup()
                        .addComponent(bNouvelleFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tMontantDeLaCaisse))
                    .addComponent(lTitreFacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelAchatLayout.createSequentialGroup()
                        .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lTitre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelAchatLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tNbrElemFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tNbrMaxElemFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 36, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelAchatLayout.createSequentialGroup()
                                .addComponent(lGenreAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cChoixGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelAchatLayout.createSequentialGroup()
                                .addComponent(lNbrAchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tNbrAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAjoutePanier)))
                .addContainerGap())
        );
        panelAchatLayout.setVerticalGroup(
            panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAchatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAchatLayout.createSequentialGroup()
                        .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lTitre1)
                            .addComponent(lGenreAchat)
                            .addComponent(cChoixGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tNbrAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lNbrAchat))
                            .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(tNbrElemFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(tNbrMaxElemFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(bAjoutePanier, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lTitreFacture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNouvelleFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tMontantDeLaCaisse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelLogo.setBackground(new java.awt.Color(255, 255, 255));

        lLogo.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/images/miniMarketLogo.jpg"))); // NOI18N
        lLogo.setText("Mon petit magasin");

        bOuverture.setBackground(new java.awt.Color(255, 255, 255));
        bOuverture.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        bOuverture.setForeground(new java.awt.Color(255, 255, 255));
        bOuverture.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/images/ferme.gif"))); // NOI18N
        bOuverture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOuvertureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addComponent(lLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOuverture, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bOuverture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAjout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAjout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAjouteStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouteStockActionPerformed
        String genre = tGenreStock.getText();
        String nbrStr = tNbrStock.getText();
        int nbr = 0;
        try {
            nbr = Integer.parseInt(nbrStr);
        } catch (Exception ex) {
            // rien car déjà à 0 et pasnécessaire car test sur sortie TextField déjà fait
        }
        String prixStr = tPrixStock.getText();
        double prix = 0;
        try {
            prix = Double.parseDouble(prixStr);
        } catch (Exception ex) {
            // rien car déjà à 0 et pasnécessaire car test sur sortie TextField déjà fait
        }
        refCtrl.ajouteArticleStock(genre, nbr, prix);
    }//GEN-LAST:event_bAjouteStockActionPerformed

    private void tNbrStockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNbrStockFocusLost
        String nbrStr = tNbrStock.getText();
        try {
            int nbr = Integer.parseInt(nbrStr);
        } catch (Exception ex) {
            afficheErreur("Veuillez introduire un nombre entier");
            tNbrStock.requestFocus();
            tNbrStock.setSelectionStart(0);
            tNbrStock.setSelectionEnd(tNbrStock.getWidth());
        }
    }//GEN-LAST:event_tNbrStockFocusLost

    private void tPrixStockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPrixStockFocusLost
        String prixStr = tPrixStock.getText();
        try {
            double prix = Double.parseDouble(prixStr);
        } catch (Exception ex) {
            afficheErreur("Veuillez introduire un nombre entier");
            tPrixStock.requestFocus();
            tPrixStock.setSelectionStart(0);
            tPrixStock.setSelectionEnd(tPrixStock.getWidth());
        }
    }//GEN-LAST:event_tPrixStockFocusLost

    private void tNbrAchatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNbrAchatFocusLost
        String genre = (String) cChoixGenre.getSelectedItem();
        String nbrStr = tNbrAchat.getText();
        int nbr = 0;
        boolean ok = false;
        try {
            nbr = Integer.parseInt(nbrStr);
            ok = refCtrl.controleSiStockDisponible(genre, nbr);
        } catch (Exception ex) {
            nbr = 0;
            tNbrAchat.setText("" + nbr);
            afficheErreur("Entrez un nombre SVP!");
        }
        if (!ok) {
            nbr = 0;
            tNbrAchat.setText("" + nbr);
            afficheErreur("Il n'y a pas assez de stock pour le nombre désiré");
        }
    }//GEN-LAST:event_tNbrAchatFocusLost

    private void bAjoutePanierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjoutePanierActionPerformed
        String genre = (String) cChoixGenre.getSelectedItem();
        String nbrStr = tNbrAchat.getText();
        int nbr = 0;
        try {
            nbr = Integer.parseInt(nbrStr);
        } catch (Exception ex) {
            nbr = 0;
            afficheErreur("Entrez un nombre SVP!");
        }
        if (nbr > 0) {
            refCtrl.ajouteArticleFacture(genre, nbr);
        }
    }//GEN-LAST:event_bAjoutePanierActionPerformed

    private void bNouvelleFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNouvelleFactureActionPerformed
        refCtrl.creeNouvelleFacture();
    }//GEN-LAST:event_bNouvelleFactureActionPerformed

    private void bOuvertureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOuvertureActionPerformed
        ouvert = !ouvert;
        turnOnApplication(ouvert);
    }//GEN-LAST:event_bOuvertureActionPerformed

    private void turnOnApplication(boolean on) {
        panelAjout.setVisible(on);
        panelAchat.setVisible(on);
        if (on) {
            bOuverture.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/images/ouvert.gif")));
        } else {
            bOuverture.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/images/ferme.gif")));
        }
    }

    public void ouvreLeMagasin() {
        ouvert = true;
        turnOnApplication(true);
    }

    private String aligneADroite(int val, int taille) {
        String dim = "%" + taille + "d";
        String infoAligneDroite = String.format(dim, val);
        return infoAligneDroite;
    }

    private String aligneADroite(String info, int taille) {
        String infoAligneDroite = " ";
        if (info.length() < taille) {
            for (int i = 0; i < (taille - info.length()); i++) {
                infoAligneDroite = infoAligneDroite + " ";
            }
            infoAligneDroite = infoAligneDroite + info;
        } else {
            infoAligneDroite = info;
        }
        return infoAligneDroite;
    }
    private String aligneAGauche(String info, int taille) {
        String infoAligneDroite = " ";
        if (info.length() < taille) {
            for (int i = 0; i < (taille - info.length()); i++) {
                infoAligneDroite = infoAligneDroite + " ";
            }
            infoAligneDroite = info + infoAligneDroite;
        } else {
            infoAligneDroite = info;
        }
        return infoAligneDroite;
    }

    public void afficheLaListeDesArticlesEnStock(String[] laListe) {
        taListeStock.setText("");
        for (int i = 0; i < laListe.length; i++) {
            if (laListe[i] != null) {
                String[] infos = laListe[i].split("\t");
                if (infos != null) {
                    String quantite = infos[0];
                    String genre = infos[1];
                    String prix = infos[2];
                    int quantiteInt = Integer.parseInt(quantite);
                    quantite = aligneADroite(quantiteInt, 5);
                    genre = aligneAGauche(genre, 20);
                    prix = aligneADroite(prix, 13);
                    String ligne = quantite + "\t" + genre + "\t" + prix + "\n";
                    taListeStock.append(ligne);
                }
            }
        }
    }

    public void metAJourInfoDuStock(int nbrEnStock, int nbrMaxEnStock) {
        String nbr = "" + nbrEnStock;
        String nbrMax = "" + nbrMaxEnStock;
        tNbrEnStock.setText(nbr);
        tNbrMaxStock.setText(nbrMax);
    }
    
    public void metAJourInfoFacture(int nbrElemFact, int nbrMaxElemFact){
        String nbr = ""+nbrElemFact;
        String nbrMax = ""+nbrMaxElemFact;
        tNbrElemFacture.setText(nbr);
        tNbrMaxElemFacture.setText(nbrMax);
    }

    public void afficheComboGenresFacture(String[] lesGenres) {
        cChoixGenre.removeAllItems();
        for (int i = 0; i < lesGenres.length; i++) {
            if (lesGenres[i] != null) {
                cChoixGenre.addItem(lesGenres[i]);
            }
        }
    }

    public void afficheTitreFacture(String dateDuJour) {
        lTitreFacture.setText("Facture du " + dateDuJour);
    }

    public void afficheFacture(String[] laFacture) {
        if (laFacture != null) {
            taFacture.setText("\n");
            for (int i = 0; i < laFacture.length - 1; i++) {
                if (laFacture[i] != null) {
                    String[] infos = laFacture[i].split("\t");
                    String nbr = infos[0];
                    String genre = infos[1];
                    String prixUnit = infos[2];
                    String prix = infos[3];
                    nbr = aligneADroite(nbr, 4);
                    genre = aligneAGauche(genre, 20);
                    prixUnit = aligneADroite(prixUnit, 13);
                    prix = aligneADroite(prix, 19);
                    String ligne = nbr + "\t" + genre + " \t" + prixUnit + "\t" + prix+ "\n";
                    taFacture.append(ligne);
                } else {
                    taFacture.append("\n");
                }
            }
            taFacture.append("\n\t");
            taFacture.append(laFacture[laFacture.length - 1]);
        }
    }

    public void effaceFacture() {
        taFacture.setText("");
        lTitreFacture.setText("Facture du ");
        tNbrElemFacture.setText("0");
    }

    public void afficheMontantDeLaCaisse(double montant) {
        DecimalFormat formateur = new DecimalFormat("#,###.00");
        String montantFormate = formateur.format(montant);
        tMontantDeLaCaisse.setText(montantFormate);
    }

    /**
     * Cette mÃ©thode affiche un message d'erreur dans une pop up avec l'icone
     * ERREUR.
     *
     * @param erreur String le message d'erreur Ã  afficher.
     */
    public void afficheErreur(String erreur) {
        JOptionPane.showMessageDialog(null, erreur, "ERREUR",
                JOptionPane.ERROR_MESSAGE);

    }

    /**
     * Cette mÃ©thod affiche un message d'information dans une pop up avec
     * l'icone INFORMATION.
     *
     * @param msg String le message Ã  afficher.
     */
    public void afficheMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Message",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public Ctrl getRefCtrl() {
        return refCtrl;
    }

    public void setRefCtrl(Ctrl refCtrl) {
        this.refCtrl = refCtrl;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAjoutePanier;
    private javax.swing.JButton bAjouteStock;
    private javax.swing.JButton bNouvelleFacture;
    private javax.swing.JButton bOuverture;
    private javax.swing.JComboBox cChoixGenre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lGenreAchat;
    private javax.swing.JLabel lGenreStock;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lNbrAchat;
    private javax.swing.JLabel lNbrStock;
    private javax.swing.JLabel lPrixStock;
    private javax.swing.JLabel lTitre;
    private javax.swing.JLabel lTitre1;
    private javax.swing.JLabel lTitre2;
    private javax.swing.JLabel lTitre3;
    private javax.swing.JLabel lTitreFacture;
    private javax.swing.JPanel panelAchat;
    private javax.swing.JPanel panelAjout;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JTextField tGenreStock;
    private javax.swing.JTextField tMontantDeLaCaisse;
    private javax.swing.JTextField tNbrAchat;
    private javax.swing.JTextField tNbrElemFacture;
    private javax.swing.JTextField tNbrEnStock;
    private javax.swing.JTextField tNbrMaxElemFacture;
    private javax.swing.JTextField tNbrMaxStock;
    private javax.swing.JTextField tNbrStock;
    private javax.swing.JTextField tPrixStock;
    private javax.swing.JTextArea taFacture;
    private javax.swing.JTextArea taListeStock;
    // End of variables declaration//GEN-END:variables
    private Ctrl refCtrl;
    private boolean ouvert;
}

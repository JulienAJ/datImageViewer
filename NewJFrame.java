/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julien
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LeftPanel = new javax.swing.JPanel();
        ImageDataPanel = new javax.swing.JPanel();
        ChangeTabsButton = new javax.swing.JButton();
        ImageNameLabel = new javax.swing.JLabel();
        ImageRenameButton = new javax.swing.JButton();
        TagsLabel = new javax.swing.JLabel();
        TagsArea = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        RepertoryPanel = new javax.swing.JPanel();
        PathField = new javax.swing.JTextField();
        BrowseButton = new javax.swing.JButton();
        RightPanel = new javax.swing.JPanel();
        RightTopBar = new javax.swing.JPanel();
        SearchButton = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        DisplayList = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSeparator2 = new javax.swing.JSeparator();
        MainMenu = new javax.swing.JMenuBar();
        RepertoryMenu = new javax.swing.JMenu();
        ChangeRepertory = new javax.swing.JMenuItem();
        DisplayMenu = new javax.swing.JMenu();
        LargeItem = new javax.swing.JRadioButtonMenuItem();
        MediumItem = new javax.swing.JRadioButtonMenuItem();
        SmallItem = new javax.swing.JRadioButtonMenuItem();
        LanguageMenu = new javax.swing.JMenu();
        EnglishItem = new javax.swing.JRadioButtonMenuItem();
        FrenchItem = new javax.swing.JRadioButtonMenuItem();
        RussianItem = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("datImageViewer");
        setResizable(false);

        ImageDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Image"));

        ChangeTabsButton.setText("Modifier");

        ImageNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageNameLabel.setText("Nom de l'image");

        ImageRenameButton.setText("Renommer");
        ImageRenameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageRenameButtonActionPerformed(evt);
            }
        });

        TagsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TagsLabel.setText("Tags associés");
        TagsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        TagsArea.setViewportView(jTextArea1);

        javax.swing.GroupLayout ImageDataPanelLayout = new javax.swing.GroupLayout(ImageDataPanel);
        ImageDataPanel.setLayout(ImageDataPanelLayout);
        ImageDataPanelLayout.setHorizontalGroup(
            ImageDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImageDataPanelLayout.createSequentialGroup()
                .addGroup(ImageDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImageDataPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ChangeTabsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ImageDataPanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(ImageDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ImageRenameButton)
                            .addComponent(ImageNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TagsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ImageDataPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TagsArea)))
                .addContainerGap())
        );
        ImageDataPanelLayout.setVerticalGroup(
            ImageDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImageDataPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ImageNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImageRenameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(TagsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TagsArea, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChangeTabsButton)
                .addGap(19, 19, 19))
        );

        RepertoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Répertoire"));

        PathField.setText("Chemin");
        PathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PathFieldActionPerformed(evt);
            }
        });

        BrowseButton.setText("...");
        BrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RepertoryPanelLayout = new javax.swing.GroupLayout(RepertoryPanel);
        RepertoryPanel.setLayout(RepertoryPanelLayout);
        RepertoryPanelLayout.setHorizontalGroup(
            RepertoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RepertoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PathField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        RepertoryPanelLayout.setVerticalGroup(
            RepertoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RepertoryPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(RepertoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BrowseButton))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RepertoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ImageDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(RepertoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(ImageDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        SearchButton.setText("Rechercher");

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        DisplayList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Grand", "Petit", "Moyen" }));

        jLabel1.setText("Affichage");

        javax.swing.GroupLayout RightTopBarLayout = new javax.swing.GroupLayout(RightTopBar);
        RightTopBar.setLayout(RightTopBarLayout);
        RightTopBarLayout.setHorizontalGroup(
            RightTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightTopBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(DisplayList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchButton)
                .addContainerGap())
        );
        RightTopBarLayout.setVerticalGroup(
            RightTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightTopBarLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(RightTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchButton)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DisplayList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))))
        );

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightPanelLayout.createSequentialGroup()
                .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RightTopBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addComponent(RightTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        RepertoryMenu.setText("Répertoire");

        ChangeRepertory.setText("Changer");
        ChangeRepertory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeRepertoryActionPerformed(evt);
            }
        });
        RepertoryMenu.add(ChangeRepertory);

        MainMenu.add(RepertoryMenu);

        DisplayMenu.setText("Affichage");

        LargeItem.setSelected(true);
        LargeItem.setText("Grand");
        DisplayMenu.add(LargeItem);

        MediumItem.setText("Moyen");
        DisplayMenu.add(MediumItem);

        SmallItem.setText("Petit");
        DisplayMenu.add(SmallItem);

        MainMenu.add(DisplayMenu);

        LanguageMenu.setText("Langues");

        EnglishItem.setText("English");
        LanguageMenu.add(EnglishItem);

        FrenchItem.setSelected(true);
        FrenchItem.setText("Français");
        FrenchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrenchItemActionPerformed(evt);
            }
        });
        LanguageMenu.add(FrenchItem);

        RussianItem.setText("русский");
        LanguageMenu.add(RussianItem);

        MainMenu.add(LanguageMenu);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PathFieldActionPerformed

    private void BrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BrowseButtonActionPerformed

    private void ImageRenameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageRenameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImageRenameButtonActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void ChangeRepertoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeRepertoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChangeRepertoryActionPerformed

    private void FrenchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrenchItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FrenchItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseButton;
    private javax.swing.JMenuItem ChangeRepertory;
    private javax.swing.JButton ChangeTabsButton;
    private javax.swing.JComboBox DisplayList;
    private javax.swing.JMenu DisplayMenu;
    private javax.swing.JRadioButtonMenuItem EnglishItem;
    private javax.swing.JRadioButtonMenuItem FrenchItem;
    private javax.swing.JPanel ImageDataPanel;
    private javax.swing.JLabel ImageNameLabel;
    private javax.swing.JButton ImageRenameButton;
    private javax.swing.JMenu LanguageMenu;
    private javax.swing.JRadioButtonMenuItem LargeItem;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JRadioButtonMenuItem MediumItem;
    private javax.swing.JTextField PathField;
    private javax.swing.JMenu RepertoryMenu;
    private javax.swing.JPanel RepertoryPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JPanel RightTopBar;
    private javax.swing.JRadioButtonMenuItem RussianItem;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JRadioButtonMenuItem SmallItem;
    private javax.swing.JScrollPane TagsArea;
    private javax.swing.JLabel TagsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

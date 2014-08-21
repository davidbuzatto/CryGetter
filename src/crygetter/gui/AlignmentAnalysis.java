/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.gui;

import crygetter.model.CryToxin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class AlignmentAnalysis extends javax.swing.JDialog {

    private DefaultListModel<CryToxin> proteinListModel1;
    private DefaultListModel<CryToxin> proteinListModel2;
    
    private CryToxin selectedCt1;
    private CryToxin selectedCt2;
    
    private List<CryToxin> ctList;
    Map<String, List<String>> extractedData;
    
    /**
     * Creates new form AlignmentAnalysis
     */
    public AlignmentAnalysis( JDialog parent, boolean modal, List<CryToxin> ctList, Map<String, List<String>> extractedData ) {
        
        super( parent, modal );
        initComponents();
        
        this.ctList = ctList;
        this.extractedData = extractedData;
        
        proteinListModel1 = new DefaultListModel<>();
        proteinListModel2 = new DefaultListModel<>();
        
        listProteins1.setModel( proteinListModel1 );
        listProteins2.setModel( proteinListModel2 );
        
        listProteins1.setCellRenderer( new CryToxinListCellRenderer() );
        listProteins2.setCellRenderer( new CryToxinListCellRenderer() );
        
        loadProteinLists();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProteins = new javax.swing.JPanel();
        panelProtein1 = new javax.swing.JPanel();
        scrollProteins1 = new javax.swing.JScrollPane();
        listProteins1 = new javax.swing.JList<CryToxin>();
        panelProtein2 = new javax.swing.JPanel();
        scrollProteins2 = new javax.swing.JScrollPane();
        listProteins2 = new javax.swing.JList<CryToxin>();
        btnAnalyse = new javax.swing.JButton();
        checkDoNotIncludeGaps = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Protein Analysis");
        setResizable(false);

        panelProteins.setBorder(javax.swing.BorderFactory.createTitledBorder("Proteins to Analyse"));

        panelProtein1.setBorder(javax.swing.BorderFactory.createTitledBorder("Protein 1"));

        listProteins1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listProteins1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listProteins1ValueChanged(evt);
            }
        });
        scrollProteins1.setViewportView(listProteins1);

        javax.swing.GroupLayout panelProtein1Layout = new javax.swing.GroupLayout(panelProtein1);
        panelProtein1.setLayout(panelProtein1Layout);
        panelProtein1Layout.setHorizontalGroup(
            panelProtein1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProtein1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollProteins1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelProtein1Layout.setVerticalGroup(
            panelProtein1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProtein1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollProteins1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelProtein2.setBorder(javax.swing.BorderFactory.createTitledBorder("Protein 2"));

        listProteins2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listProteins2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listProteins2ValueChanged(evt);
            }
        });
        scrollProteins2.setViewportView(listProteins2);

        javax.swing.GroupLayout panelProtein2Layout = new javax.swing.GroupLayout(panelProtein2);
        panelProtein2.setLayout(panelProtein2Layout);
        panelProtein2Layout.setHorizontalGroup(
            panelProtein2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProtein2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollProteins2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelProtein2Layout.setVerticalGroup(
            panelProtein2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProtein2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollProteins2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAnalyse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crygetter/gui/icons/accept.png"))); // NOI18N
        btnAnalyse.setText("Analyse");
        btnAnalyse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalyseActionPerformed(evt);
            }
        });

        checkDoNotIncludeGaps.setSelected(true);
        checkDoNotIncludeGaps.setText("Do not include gaps");

        javax.swing.GroupLayout panelProteinsLayout = new javax.swing.GroupLayout(panelProteins);
        panelProteins.setLayout(panelProteinsLayout);
        panelProteinsLayout.setHorizontalGroup(
            panelProteinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProteinsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProtein1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelProtein2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProteinsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkDoNotIncludeGaps)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalyse)
                .addContainerGap())
        );
        panelProteinsLayout.setVerticalGroup(
            panelProteinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProteinsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProteinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelProtein2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelProtein1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProteinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalyse)
                    .addComponent(checkDoNotIncludeGaps))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProteins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProteins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(475, 477));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listProteins1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listProteins1ValueChanged

        if ( listProteins1 != null ) {

            CryToxin selectedNow = (CryToxin) listProteins1.getSelectedValue();

            if ( selectedNow != null ) {
                selectedCt1 = selectedNow;
            }

        }

    }//GEN-LAST:event_listProteins1ValueChanged

    private void listProteins2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listProteins2ValueChanged
        
        if ( listProteins2 != null ) {

            CryToxin selectedNow = (CryToxin) listProteins2.getSelectedValue();

            if ( selectedNow != null ) {
                selectedCt2 = selectedNow;
            }

        }
        
    }//GEN-LAST:event_listProteins2ValueChanged

    private void btnAnalyseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalyseActionPerformed
        
        if ( selectedCt1 != null && selectedCt2 != null && selectedCt1 != selectedCt2 ) {
            
            List<String> proteinData1 = extractedData.get( selectedCt1.name );
            List<String> proteinData2 = extractedData.get( selectedCt2.name );
            List<AminoacidDifference> aaDiffs = new ArrayList<>();
            
            for ( int i = 0; i < proteinData1.size(); i++ ) {
                
                char[] seq1 = proteinData1.get( i ).toCharArray();
                char[] seq2 = proteinData2.get( i ).toCharArray();
                
                for ( int j = 0; j < seq1.length; j++ ) {
                    
                    if ( checkDoNotIncludeGaps.isSelected() ) {
                        if ( seq1[j] != seq2[j] && seq1[j] != '-' && seq2[j] != '-' ) {
                            aaDiffs.add( new AminoacidDifference( seq1[j], seq2[j], (i * 60) + j + 1 ) );
                        }
                    } else {
                        if ( seq1[j] != seq2[j] ) {
                            aaDiffs.add( new AminoacidDifference( seq1[j], seq2[j], (i * 60) + j + 1 ) );
                        }
                    }
                    
                }
                
            }
            
            if ( !aaDiffs.isEmpty() ) {
                
                for ( AminoacidDifference aad : aaDiffs ) {
                    System.out.println( aad );
                }
                
            } else {
                JOptionPane.showMessageDialog( this, "There are no differences between the\n"
                        + "proteins \"" + selectedCt1.name + "\" and \"" + selectedCt2.name + "\"", 
                        "Information", JOptionPane.INFORMATION_MESSAGE );
            }
            
        } else {
            JOptionPane.showMessageDialog( this, "You must select two different proteins to analyse.",
                    "Warning", JOptionPane.WARNING_MESSAGE );
        }
        
    }//GEN-LAST:event_btnAnalyseActionPerformed

    private void loadProteinLists() {
        
        for ( Entry<String, List<String>> e : extractedData.entrySet() ) {
            
            if ( !e.getKey().equals( "aln" ) ) {
                
                for ( int i = 0; i < ctList.size(); i++ ) {
                    
                    CryToxin ct = ctList.get( i );
                    
                    if ( ct.name.equals( e.getKey() ) ) {
                        proteinListModel1.addElement( ct );
                        proteinListModel2.addElement( ct );
                    }
                    
                }
                
            }
            
        }
        
        listProteins1.updateUI();
        listProteins2.updateUI();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalyse;
    private javax.swing.JCheckBox checkDoNotIncludeGaps;
    private javax.swing.JList<CryToxin> listProteins1;
    private javax.swing.JList<CryToxin> listProteins2;
    private javax.swing.JPanel panelProtein1;
    private javax.swing.JPanel panelProtein2;
    private javax.swing.JPanel panelProteins;
    private javax.swing.JScrollPane scrollProteins1;
    private javax.swing.JScrollPane scrollProteins2;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.Telas;

import br.senac.tads.pi3.Servicos.ServicoContato;
import br.senac.tads.pi3.Classes.Contato;
import br.senac.tads.pi3.Exceptions.AgendaException;
import br.senac.tads.pi3.Exceptions.DataSourceException;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jonata.hmoliveira
 */
public class TelaInicial extends javax.swing.JFrame {

    TelaPesquisar telaPesquisar = null;

    /**
     * Creates new form NewJFrame
     */
    public TelaInicial() {
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

        jDesktop = new javax.swing.JDesktopPane();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelDataDeNascimento = new javax.swing.JLabel();
        jFormattedTextFieldDataDeNascimento = new javax.swing.JFormattedTextField();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelTelefone1 = new javax.swing.JLabel();
        jFormattedTextFieldCelular = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 220, 220));

        jDesktop.setBackground(new java.awt.Color(153, 153, 153));
        jDesktop.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome");

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTelefone.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefone.setText("Telefone");

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("E-mail");

        jLabelDataDeNascimento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDataDeNascimento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataDeNascimento.setText("Data de Nascimento");

        try {
            jFormattedTextFieldDataDeNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataDeNascimento.setToolTipText("");

        jButtonAdicionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAdicionar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonPesquisar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(102, 102, 102));
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelTelefone1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTelefone1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefone1.setText("Celular");

        try {
            jFormattedTextFieldCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jDesktop.setLayer(jLabelNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jTextFieldNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jLabelTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jFormattedTextFieldTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jLabelEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jTextFieldEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jLabelDataDeNascimento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jFormattedTextFieldDataDeNascimento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jButtonAdicionar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jButtonPesquisar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jButtonSair, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jLabelTelefone1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktop.setLayer(jFormattedTextFieldCelular, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopLayout.createSequentialGroup()
                        .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopLayout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(92, 92, 92))
                    .addGroup(jDesktopLayout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 552, Short.MAX_VALUE))
                    .addGroup(jDesktopLayout.createSequentialGroup()
                        .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelDataDeNascimento)
                            .addGroup(jDesktopLayout.createSequentialGroup()
                                .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTelefone)
                                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(105, 105, 105)
                                .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTelefone1))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopLayout.createSequentialGroup()
                        .addComponent(jButtonPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAdicionar))
                .addGap(21, 21, 21))
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jLabelTelefone1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDataDeNascimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButtonAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonPesquisar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktop)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        int erro = 0;
        Contato contato = new Contato();
        
        contato.setNomeContato(jTextFieldNome.getText());
        contato.setEmailContato(jTextFieldEmail.getText());
        contato.setDataNascimento(jFormattedTextFieldDataDeNascimento.getText());
        contato.setTelefoneContato(jFormattedTextFieldTelefone.getText());
        contato.setCelularContato(jFormattedTextFieldCelular.getText());


        ServicoContato servicoContato = new ServicoContato();

        boolean nomeContato = servicoContato.verificarNomeContato(contato.getNomeContato());
        boolean emailContato = servicoContato.verificarEmailContato(contato.getEmailContato());
        boolean dataNascimento = servicoContato.verificarDataNascimento(contato.getDataNascimento());
        boolean telefoneContato = servicoContato.verificarTelefoneContato(contato.getTelefoneContato());
        boolean celularContato = servicoContato.verificarCelularContato(contato.getCelularContato());

        if (nomeContato == false) {
            jTextFieldNome.setBackground(Color.PINK);
            erro++;

        } else {
            jTextFieldNome.setBackground(Color.WHITE);
        }
        if (emailContato == false) {
            jTextFieldEmail.setBackground(Color.PINK);
            erro++;

        } else {
            jTextFieldEmail.setBackground(Color.WHITE);
        }
        if (dataNascimento == false) {
            jFormattedTextFieldDataDeNascimento.setBackground(Color.PINK);
            erro++;

        } else {
            jFormattedTextFieldDataDeNascimento.setBackground(Color.WHITE);
        }
        if (telefoneContato == false && celularContato == false) {
            jFormattedTextFieldTelefone.setBackground(Color.PINK);
            jFormattedTextFieldCelular.setBackground(Color.PINK);
            erro++;

        } else if (telefoneContato == true && celularContato == false) {
            jFormattedTextFieldTelefone.setBackground(Color.WHITE);
            jFormattedTextFieldCelular.setBackground(Color.WHITE);
            
        } else if (telefoneContato == false && celularContato == true) {
            jFormattedTextFieldTelefone.setBackground(Color.WHITE);
            jFormattedTextFieldCelular.setBackground(Color.WHITE);
            
        }else if (telefoneContato == true && celularContato == true) {
            jFormattedTextFieldTelefone.setBackground(Color.WHITE);
            jFormattedTextFieldCelular.setBackground(Color.WHITE);
        }

        if (erro == 0) {
            try {
                ServicoContato.adicionarContato(contato);
                JOptionPane.showMessageDialog(null, "Contato Adicionado!");

            } catch (AgendaException ex) {
                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DataSourceException ex) {
                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTextFieldNome.setText("");
            jTextFieldEmail.setText("");
            jFormattedTextFieldDataDeNascimento.setText("");
            jFormattedTextFieldTelefone.setText("");
            jFormattedTextFieldCelular.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Verficique os campos destacados", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        if (telaPesquisar == null || !telaPesquisar.isDisplayable()) {
            telaPesquisar = new TelaPesquisar();
            jDesktop.add(telaPesquisar);
            this.openFrameInCenter(telaPesquisar);
        }
        telaPesquisar.toFront();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(this, "Deseja realmente fechar o programa?");
        if (dialogResult == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = jDesktop.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSair;
    public javax.swing.JDesktopPane jDesktop;
    public javax.swing.JFormattedTextField jFormattedTextFieldCelular;
    public javax.swing.JFormattedTextField jFormattedTextFieldDataDeNascimento;
    public javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabelDataDeNascimento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTelefone1;
    public javax.swing.JTextField jTextFieldEmail;
    public javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.Telas;

import br.senac.tads.pi3.Classes.Contato;
import br.senac.tads.pi3.Exceptions.AgendaException;
import br.senac.tads.pi3.Exceptions.DataSourceException;
import br.senac.tads.pi3.Servicos.ServicoContato;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonat
 */
public class TelaPesquisar extends javax.swing.JInternalFrame {
    
    TelaEditar telaEditar = null;
    TelaInicial telaInicial = null;
    public static int contatoId = 0;

    /**
     * Creates new form NovoJInternalFrame
     */
    public TelaPesquisar() {
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

        jButtonFechar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jTextPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jButtonFechar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonFechar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonRemover.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonRemover.setForeground(new java.awt.Color(102, 102, 102));
        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Celular", "E-mail", "Data de Nascimento", "Adicionado em:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAgenda);

        jTextPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPesquisaActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(442, Short.MAX_VALUE)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemover)
                    .addComponent(jButtonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        int dialogResult = JOptionPane.showInternalConfirmDialog(this, "Deseja realmente fechar?");
        if (dialogResult == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        try {

            final int row = jTableAgenda.getSelectedRow();

            if (row >= 0) {

                Integer id = (Integer) jTableAgenda.getValueAt(row, 0);
                List<Contato> resultado = ServicoContato.obterContato(id);
                
                for (Contato contato : resultado) {
                    if (contato.getIdContato() == id){   
                        if (telaEditar == null || !telaEditar.isDisplayable()) {
                            telaEditar = new TelaEditar();
                            telaEditar.jTextFieldNome.setText(contato.getNomeContato());
                            telaEditar.jFormattedTextFieldCelular.setText(contato.getCelularContato());
                            telaEditar.jTextFieldEmail.setText(contato.getEmailContato());
                            telaEditar.jFormattedTextFieldDataNasc.setText(contato.getDataNascimento());
                            telaEditar.jFormattedTextFieldTelefone.setText(contato.getTelefoneContato());
                            contatoId = contato.getIdContato();
                            this.getParent().add(telaEditar);              
                            telaEditar.toFront();
                            telaEditar.setVisible(true);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            //Exibe uma mensagem de erro genérica ao usuário
            JOptionPane.showMessageDialog(rootPane, "Não é possível "
                + "exibir os detalhes deste cliente.",
                "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        try {
            final int row = jTableAgenda.getSelectedRow();
            int dialogResult = JOptionPane.showInternalConfirmDialog(this, "Deseja realmente Remover " + jTableAgenda.getValueAt(row, 1).toString()  + "?");
            if (dialogResult == 0) {
                if (row >= 0) {
                    Integer id = (Integer) jTableAgenda.getValueAt(row, 0);
                    
                    ServicoContato.removerContato(id);
                    JOptionPane.showMessageDialog(this, "Contato removido com sucesso!");
                }
        } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Selecione o contato a ser removido!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jTextPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPesquisaActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        List<Contato> resultado = null;
        
        //Retornar todos os Contatos
        if (jTextPesquisa.getText().equals("")) {
            try {
                resultado = ServicoContato.retornarTodos();
                DefaultTableModel model = (DefaultTableModel) jTableAgenda.getModel();
                model.setRowCount(0);
  
            if (resultado == null || resultado.size() <= 0) {
                JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ",
                    "Sem resultados", JOptionPane.ERROR_MESSAGE);            
                return;
            }
        
            int size = resultado.size();        
        
            for (int i = 0; i < size; i++){
                Contato contato = resultado.get(i);
                if (contato != null) {
                    Object[] row = new Object[7];
                    row[0] = contato.getIdContato();
                    row[1] = contato.getNomeContato();
                    row[2] = contato.getTelefoneContato();
                    row[3] = contato.getCelularContato();
                    row[4] = contato.getEmailContato();
                    row[5] = contato.getDataNascimento();
                    row[6] = contato.getAdicionadoEm();
                    model.addRow(row);                
                }            
            }             
        
            } catch (AgendaException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao pesquisar contato no Banco de Dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (DataSourceException ex) {
                Logger.getLogger(TelaPesquisar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        //Retornar os contatos pesquisados    
        } else {
            try {
                resultado = ServicoContato.pesquisarContato(jTextPesquisa.getText());
            } catch (AgendaException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao pesquisar contato no Banco de Dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (DataSourceException ex) {
                Logger.getLogger(TelaPesquisar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DefaultTableModel model = (DefaultTableModel) jTableAgenda.getModel();
            model.setRowCount(0);
  
            if (resultado == null || resultado.size() <= 0) {
                JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ",
                    "Sem resultados", JOptionPane.ERROR_MESSAGE);            
                return;
            }
        
            int size = resultado.size();        
        
            for (int i = 0; i < size; i++){
                Contato contato = resultado.get(i);
                if (contato != null) {
                    Object[] row = new Object[7];
                    row[0] = contato.getIdContato();
                    row[1] = contato.getNomeContato();
                    row[2] = contato.getTelefoneContato();
                    row[3] = contato.getCelularContato();
                    row[4] = contato.getEmailContato();
                    row[5] = contato.getDataNascimento();
                    row[6] = contato.getAdicionadoEm();
                    model.addRow(row);                
                }            
            }             
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = telaInicial.jDesktop.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }
    
    public javax.swing.JDesktopPane jDesktop;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgenda;
    private javax.swing.JTextField jTextPesquisa;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mahasiswa.view;

import com.mahasiswa.controller.MahasiswaController;
import com.mahasiswa.model.HibernateUtil;
import com.mahasiswa.model.ModelMahasiswa;
import com.mahasiswa.model.ModelTabelMahasiswa;
import java.util.List;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MahasiswaView extends javax.swing.JFrame {

    private MahasiswaController controller;
    private JTextField tfSearch;
    private JButton btnSearch;
    private JTable tableMahasiswa;
    private JLabel jLabel5;
    private JTextField searchField;
    private JButton searchButton;
    
    public MahasiswaView() {
        initComponents();
        this.controller = new MahasiswaController() {
            @Override
            public void addMhs(ModelMahasiswa mhs) {
                Transaction trx = null;
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    trx = session.beginTransaction();
                    session.save(mhs);
                    trx.commit();
                } catch (Exception e) {
                    if (trx != null) {
                        trx.rollback();
                    }
                    e.printStackTrace();
                }
            }

            @Override
            public void updateMhs(ModelMahasiswa mhs) {
                Transaction trx = null;
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    trx = session.beginTransaction();
                    session.update(mhs);
                    trx.commit();
                } catch (Exception e) {
                    if (trx != null) {
                        trx.rollback();
                    }
                    e.printStackTrace();
                }
            }

            @Override
            public void deleteMhs(int id) {
                Transaction trx = null;
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    trx = session.beginTransaction();
                    ModelMahasiswa mhs = session.get(ModelMahasiswa.class, id);
                    if (mhs != null) {
                        session.delete(mhs);
                    }
                    trx.commit();
                } catch (Exception e) {
                    if (trx != null) {
                        trx.rollback();
                    }
                    e.printStackTrace();
                }
            }

            @Override
            public List<ModelMahasiswa> getAllMahasiswa() {
                Transaction trx = null;
                List<ModelMahasiswa> listMhs = null;
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    trx = session.beginTransaction();
                    Query<ModelMahasiswa> query = session.createQuery("from ModelMahasiswa", ModelMahasiswa.class);
                    listMhs = query.list();
                    trx.commit();
                } catch (Exception e) {
                    if (trx != null) {
                        trx.rollback();
                    }
                    e.printStackTrace();
                }
                return listMhs;
            }

            @Override
            public List<ModelMahasiswa> searchMahasiswa(String keyword) {
                Transaction trx = null;
                List<ModelMahasiswa> listMhs = null;
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    trx = session.beginTransaction();
                    Query<ModelMahasiswa> query = session.createQuery("from ModelMahasiswa where npm like :keyword or nama like :keyword", ModelMahasiswa.class);
                    query.setParameter("keyword", "%" + keyword + "%");
                    listMhs = query.list();
                    trx.commit();
                } catch (Exception e) {
                    if (trx != null) {
                        trx.rollback();
                    }
                    e.printStackTrace();
                }
                return listMhs;
            }

            @Override
            public ModelMahasiswa getMhs(int id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        HibernateUtil.testConnection();
        loadMahasiswaTable();
    }

    public void loadMahasiswaTable() {
        List<ModelMahasiswa> listMahasiswa = controller.getAllMahasiswa();
        ModelTabelMahasiswa tableModel = new ModelTabelMahasiswa(listMahasiswa);
        dataTable.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        npmField = new javax.swing.JTextField();
        namaField = new javax.swing.JTextField();
        semesterField = new javax.swing.JTextField();
        ipkField = new javax.swing.JTextField();
        simpanButton = new javax.swing.JButton();
        buangButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NPM");
        jLabel2.setText("NAMA");
        jLabel3.setText("SEMESTER");
        jLabel4.setText("IPK");

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(evt -> simpanButtonActionPerformed(evt));

        buangButton.setText("Buang");
        buangButton.addActionListener(evt -> buangButtonActionPerformed(evt));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(evt -> refreshButtonActionPerformed(evt));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}
        ));
        jScrollPane1.setViewportView(dataTable);

        jLabel5.setText("Cari Mahasiswa:");

        searchButton.setText("Cari");
        searchButton.addActionListener(evt -> searchButtonActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(122, 122, 122)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(65, 65, 65)
                                                                .addComponent(npmField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel4))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ipkField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(semesterField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(namaField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(89, 89, 89)
                                                                .addComponent(simpanButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(refreshButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(buangButton))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(90, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(searchButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(89, 89, 89)
                                                .addComponent(simpanButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(refreshButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(buangButton)))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(npmField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(semesterField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ipkField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(simpanButton)
                                                .addComponent(buangButton)
                                                .addComponent(refreshButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchButton))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = searchField.getText();
        List<ModelMahasiswa> listMahasiswa = controller.searchMahasiswa(keyword);
        ModelTabelMahasiswa tableModel = new ModelTabelMahasiswa(listMahasiswa);
        dataTable.setModel(tableModel);
    }

    private void npmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npmFieldActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        // TODO add your handling code here:
        String npm = getNpmField().getText();
        String nama = getNamaField().getText();
        int semester = Integer.parseInt(getSemesterField().getText());
        float ipk = Float.parseFloat(getIpkField().getText());
        ModelMahasiswa mahasiswa = new ModelMahasiswa(0, npm, nama, semester, ipk);
        controller.addMhs(mahasiswa);
        loadMahasiswaTable();
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void buangButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buangButtonActionPerformed
        // TODO add your handling code here:
        // Membuat JTextField untuk memasukkan ID
        JTextField idField = new JTextField(10);

        // Membuat panel untuk menampung JTextField
        JPanel panel = new JPanel();
        panel.add(new JLabel("Masukkan ID yang ingin dihapus:"));
        panel.add(idField);

        // Menampilkan dialog box dengan JTextField, tombol OK, dan Cancel
        int result = JOptionPane.showConfirmDialog(null, panel, 
            "Hapus Mahasiswa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Jika tombol OK ditekan
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Mengambil input ID dan memanggil metode deleteMhs
                int id = Integer.parseInt(idField.getText());
                controller.deleteMhs(id);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                // Menangani error jika ID yang dimasukkan bukan angka
                JOptionPane.showMessageDialog(null, "ID harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buangButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        loadMahasiswaTable();
    }//GEN-LAST:event_refreshButtonActionPerformed
    

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
            java.util.logging.Logger.getLogger(MahasiswaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buangButton;
    private javax.swing.JTable dataTable;
    private javax.swing.JTextField ipkField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaField;
    private javax.swing.JTextField npmField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField semesterField;
    private javax.swing.JButton simpanButton;
    // End of variables declaration//GEN-END:variables

    public JTextField getIpkField() {
        return ipkField;
    }

    public void setIpkField(JTextField ipkField) {
        this.ipkField = ipkField;
    }

    public JTextField getNamaField() {
        return namaField;
    }

    public void setNamaField(JTextField namaField) {
        this.namaField = namaField;
    }

    public JTextField getNpmField() {
        return npmField;
    }

    public void setNpmField(JTextField npmField) {
        this.npmField = npmField;
    }

    public JTextField getSemesterField() {
        return semesterField;
    }

    public void setSemesterField(JTextField semesterField) {
        this.semesterField = semesterField;
    }

    private static class searchButton {

        public searchButton() {
        }
    }

}
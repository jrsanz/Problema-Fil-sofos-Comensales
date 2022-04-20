//Autores:
//Jesús Ricardo Delgado Sánchez
//Isaías Juarez Esparza

package problema.filosofos.comensales;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Filosofos_Comensales extends javax.swing.JFrame {

    
    public Filosofos_Comensales() {
        initComponents();
        
        //Configuración de la ventana
        this.setSize(600, 550);
        this.setResizable(false);
        this.setTitle("Productor-Consumidor");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(192, 220, 240));   //#C0DCF0
        
        //////////////////////////////////////////////////
        //                    SILLAS                    //
        //////////////////////////////////////////////////
        
        //Esquinas 1
        ImageIcon silla1 = new ImageIcon("src/img/silla.png");
        Icon icono_silla1 = new ImageIcon(silla1.getImage().getScaledInstance(lblSilla2.getWidth(), lblSilla2.getHeight(), Image.SCALE_DEFAULT));
        lblSilla2.setIcon(icono_silla1);
        lblSilla2.setLocation(lblSilla2.getX(), lblSilla2.getY() - 30);
        
        //Esquinas 2
        ImageIcon silla2 = new ImageIcon("src/img/silla.png");
        Icon icono_silla2 = new ImageIcon(silla2.getImage().getScaledInstance(lblSilla3.getWidth(), lblSilla3.getHeight(), Image.SCALE_DEFAULT));
        lblSilla3.setIcon(icono_silla2);
        
        //Esquinas 3
        ImageIcon silla3 = new ImageIcon("src/img/silla.png");
        Icon icono_silla3 = new ImageIcon(silla3.getImage().getScaledInstance(lblSilla4.getWidth(), lblSilla4.getHeight(), Image.SCALE_DEFAULT));
        lblSilla4.setIcon(icono_silla3);
        
        //Esquinas 4
        ImageIcon silla4 = new ImageIcon("src/img/silla.png");
        Icon icono_silla4= new ImageIcon(silla4.getImage().getScaledInstance(lblSilla5.getWidth(), lblSilla5.getHeight(), Image.SCALE_DEFAULT));
        lblSilla5.setIcon(icono_silla4);
        
        //Esquinas 5
        ImageIcon silla5 = new ImageIcon("src/img/silla.png");
        Icon icono_silla5 = new ImageIcon(silla5.getImage().getScaledInstance(lblSilla1.getWidth(), lblSilla1.getHeight(), Image.SCALE_DEFAULT));
        lblSilla1.setIcon(icono_silla5);
        
        //////////////////////////////////////////////////
        //                  TENEDORES                   //
        //////////////////////////////////////////////////
        
        ImageIcon tenedor1 = new ImageIcon("src/img/tenedor.png");
        Icon icono_tenedor1 = new ImageIcon(tenedor1.getImage().getScaledInstance(lblTenedor1.getWidth(), lblTenedor1.getHeight(), Image.SCALE_DEFAULT));
        lblTenedor1.setIcon(icono_tenedor1);
        
        ImageIcon tenedor2 = new ImageIcon("src/img/tenedor.png");
        Icon icono_tenedor2 = new ImageIcon(tenedor2.getImage().getScaledInstance(lblTenedor2.getWidth(), lblTenedor2.getHeight(), Image.SCALE_DEFAULT));
        lblTenedor2.setIcon(icono_tenedor2);
        
        ImageIcon tenedor3 = new ImageIcon("src/img/tenedor.png");
        Icon icono_tenedor3 = new ImageIcon(tenedor3.getImage().getScaledInstance(lblTenedor3.getWidth(), lblTenedor3.getHeight(), Image.SCALE_DEFAULT));
        lblTenedor3.setIcon(icono_tenedor3);
        
        ImageIcon tenedor4 = new ImageIcon("src/img/tenedor.png");
        Icon icono_tenedor4 = new ImageIcon(tenedor4.getImage().getScaledInstance(lblTenedor4.getWidth(), lblTenedor4.getHeight(), Image.SCALE_DEFAULT));
        lblTenedor4.setIcon(icono_tenedor4);
        
        ImageIcon tenedor5 = new ImageIcon("src/img/tenedor.png");
        Icon icono_tenedor5 = new ImageIcon(tenedor5.getImage().getScaledInstance(lblTenedor5.getWidth(), lblTenedor5.getHeight(), Image.SCALE_DEFAULT));
        lblTenedor5.setIcon(icono_tenedor5);
        
        //////////////////////////////////////////////////
        //                     MESA                     //
        //////////////////////////////////////////////////
        
        ImageIcon mesa = new ImageIcon("src/img/mesa.png");
        Icon icono_mesa = new ImageIcon(mesa.getImage().getScaledInstance(lblMesa.getWidth(), lblMesa.getHeight(), Image.SCALE_DEFAULT));
        lblMesa.setIcon(icono_mesa);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblF5 = new javax.swing.JLabel();
        lblF4 = new javax.swing.JLabel();
        lblF3 = new javax.swing.JLabel();
        lblF2 = new javax.swing.JLabel();
        lblF1 = new javax.swing.JLabel();
        lblTenedor5 = new javax.swing.JLabel();
        lblTenedor4 = new javax.swing.JLabel();
        lblTenedor3 = new javax.swing.JLabel();
        lblTenedor2 = new javax.swing.JLabel();
        lblTenedor1 = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        lblSilla5 = new javax.swing.JLabel();
        lblSilla4 = new javax.swing.JLabel();
        lblSilla3 = new javax.swing.JLabel();
        lblSilla2 = new javax.swing.JLabel();
        lblSilla1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblF5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF5.setText("F5");
        getContentPane().add(lblF5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        lblF4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF4.setText("F4");
        getContentPane().add(lblF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        lblF3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF3.setText("F3");
        getContentPane().add(lblF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        lblF2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF2.setText("F2");
        getContentPane().add(lblF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        lblF1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF1.setText("F1");
        getContentPane().add(lblF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));
        getContentPane().add(lblTenedor5, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 320, 24, 24));
        getContentPane().add(lblTenedor4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 24, 24));
        getContentPane().add(lblTenedor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 24, 24));
        getContentPane().add(lblTenedor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 24, 24));
        getContentPane().add(lblTenedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 24, 24));
        getContentPane().add(lblMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 128, 128));
        getContentPane().add(lblSilla5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 64, 64));
        getContentPane().add(lblSilla4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 64, 64));
        getContentPane().add(lblSilla3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 64, 64));
        getContentPane().add(lblSilla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 64, 64));
        getContentPane().add(lblSilla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 64, 64));

        lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Problema Filósofos Comensales");
        lblTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 380, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Filosofos_Comensales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filosofos_Comensales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filosofos_Comensales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filosofos_Comensales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filosofos_Comensales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblF1;
    private javax.swing.JLabel lblF2;
    private javax.swing.JLabel lblF3;
    private javax.swing.JLabel lblF4;
    private javax.swing.JLabel lblF5;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblSilla1;
    private javax.swing.JLabel lblSilla2;
    private javax.swing.JLabel lblSilla3;
    private javax.swing.JLabel lblSilla4;
    private javax.swing.JLabel lblSilla5;
    private javax.swing.JLabel lblTenedor1;
    private javax.swing.JLabel lblTenedor2;
    private javax.swing.JLabel lblTenedor3;
    private javax.swing.JLabel lblTenedor4;
    private javax.swing.JLabel lblTenedor5;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}

package problema.filosofos.comensales;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Autores del código
 * @author Jesús Ricardo Delgado Sánchez
 * @author Isaías Juarez Esparza
 */
public class Filosofos_Comensales extends javax.swing.JFrame {

    
    public Filosofos_Comensales() {
        initComponents();
        
        //Configuración de la ventana
        this.setSize(750, 600);
        this.setResizable(false);
        this.setTitle("Productor-Consumidor");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(192, 220, 240));   //#C0DCF0
        
        //////////////////////////////////////////////////
        //                     MESA                     //
        //////////////////////////////////////////////////
        
        ImageIcon mesa = new ImageIcon("src/img/plantilla.png");
        Icon icono_mesa = new ImageIcon(mesa.getImage().getScaledInstance(lblMesa.getWidth(), lblMesa.getHeight(), Image.SCALE_DEFAULT));
        lblMesa.setIcon(icono_mesa);
        
        //////////////////////////////////////////////////
        //               BLOQUEAR TENEDOR               //
        //////////////////////////////////////////////////
        
        ImageIcon bloquear = new ImageIcon("src/img/bloquear.png");
        Icon icono_bloquear = new ImageIcon(bloquear.getImage().getScaledInstance(lblOcupado1.getWidth(), lblOcupado1.getHeight(), Image.SCALE_DEFAULT));
        
        lblOcupado1.setIcon(icono_bloquear);
        lblOcupado2.setIcon(icono_bloquear);
        lblOcupado3.setIcon(icono_bloquear);
        lblOcupado4.setIcon(icono_bloquear);
        lblOcupado5.setIcon(icono_bloquear);
        
        for(int i = 1; i <= 5; i++)
            tenedor_disponible(i, false);
    }

    /**
     * Se utiliza para poner o quitar el icono de bloqueo a un tenedor
     * @param num Hace referencia al número de icono de bloqueo
     * @param disponible Hace visible u oculta el icono de bloqueo
     */
    public void tenedor_disponible(int num, boolean disponible) {
        switch(num) {
            case 1: lblOcupado1.setVisible(disponible); break;
            case 2: lblOcupado2.setVisible(disponible); break;
            case 3: lblOcupado3.setVisible(disponible); break;
            case 4: lblOcupado4.setVisible(disponible); break;
            case 5: lblOcupado5.setVisible(disponible); break;
        }
    }
    
    /**
     * Se utiliza para asignar el número de veces que ha comido cada filósofo al campo de texto
     * @param num Hace referencia al número de filósofo
     * @param veces Contiene el número de veces que ha comido un filósofo
     */
    public void comido_veces(int num, int veces) {
        switch(num) {
            case 1: txtF1.setText(String.valueOf(veces)); break;
            case 2: txtF2.setText(String.valueOf(veces)); break;
            case 3: txtF3.setText(String.valueOf(veces)); break;
            case 4: txtF4.setText(String.valueOf(veces)); break;
            case 5: txtF5.setText(String.valueOf(veces)); break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOcupado5 = new javax.swing.JLabel();
        lblOcupado4 = new javax.swing.JLabel();
        lblOcupado3 = new javax.swing.JLabel();
        lblOcupado2 = new javax.swing.JLabel();
        lblOcupado1 = new javax.swing.JLabel();
        txtF5 = new javax.swing.JTextField();
        txtF4 = new javax.swing.JTextField();
        txtF3 = new javax.swing.JTextField();
        txtF2 = new javax.swing.JTextField();
        txtF1 = new javax.swing.JTextField();
        lblFilosofo5 = new javax.swing.JLabel();
        lblFilosofo4 = new javax.swing.JLabel();
        lblFilosofo3 = new javax.swing.JLabel();
        lblFilosofo2 = new javax.swing.JLabel();
        lblFilosofo1 = new javax.swing.JLabel();
        lblVecesQueHaComido = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblF5 = new javax.swing.JLabel();
        lblF4 = new javax.swing.JLabel();
        lblF3 = new javax.swing.JLabel();
        lblF2 = new javax.swing.JLabel();
        lblF1 = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblOcupado5, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 422, 24, 24));
        getContentPane().add(lblOcupado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 355, 24, 24));
        getContentPane().add(lblOcupado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 355, 24, 24));
        getContentPane().add(lblOcupado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 252, 24, 24));
        getContentPane().add(lblOcupado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 257, 24, 24));

        txtF5.setEditable(false);
        txtF5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtF5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtF5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 60, 25));

        txtF4.setEditable(false);
        txtF4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 60, 25));

        txtF3.setEditable(false);
        txtF3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtF3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 60, 25));

        txtF2.setEditable(false);
        txtF2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 60, 25));

        txtF1.setEditable(false);
        txtF1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 60, 25));

        lblFilosofo5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblFilosofo5.setText("Filósofo 5:");
        getContentPane().add(lblFilosofo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        lblFilosofo4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblFilosofo4.setText("Filósofo 4:");
        getContentPane().add(lblFilosofo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        lblFilosofo3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblFilosofo3.setText("Filósofo 3:");
        getContentPane().add(lblFilosofo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        lblFilosofo2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblFilosofo2.setText("Filósofo 2:");
        getContentPane().add(lblFilosofo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        lblFilosofo1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblFilosofo1.setText("Filósofo 1:");
        getContentPane().add(lblFilosofo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        lblVecesQueHaComido.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblVecesQueHaComido.setText("Veces que han comido:");
        getContentPane().add(lblVecesQueHaComido, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        jPanel1.setBackground(new java.awt.Color(240, 212, 192));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 190, 250));

        lblF5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF5.setText("F5");
        getContentPane().add(lblF5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 40, 40));

        lblF4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF4.setText("F4");
        getContentPane().add(lblF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 40, 40));

        lblF3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF3.setText("F3");
        getContentPane().add(lblF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 40, 40));

        lblF2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF2.setText("F2");
        getContentPane().add(lblF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 40, 40));

        lblF1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF1.setText("F1");
        getContentPane().add(lblF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 40, 40));
        getContentPane().add(lblMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 256, 256));

        lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Problema Filósofos Comensales");
        lblTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 30, 380, 40));

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblF1;
    private javax.swing.JLabel lblF2;
    private javax.swing.JLabel lblF3;
    private javax.swing.JLabel lblF4;
    private javax.swing.JLabel lblF5;
    private javax.swing.JLabel lblFilosofo1;
    private javax.swing.JLabel lblFilosofo2;
    private javax.swing.JLabel lblFilosofo3;
    private javax.swing.JLabel lblFilosofo4;
    private javax.swing.JLabel lblFilosofo5;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblOcupado1;
    private javax.swing.JLabel lblOcupado2;
    private javax.swing.JLabel lblOcupado3;
    private javax.swing.JLabel lblOcupado4;
    private javax.swing.JLabel lblOcupado5;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVecesQueHaComido;
    private javax.swing.JTextField txtF1;
    private javax.swing.JTextField txtF2;
    private javax.swing.JTextField txtF3;
    private javax.swing.JTextField txtF4;
    private javax.swing.JTextField txtF5;
    // End of variables declaration//GEN-END:variables
}

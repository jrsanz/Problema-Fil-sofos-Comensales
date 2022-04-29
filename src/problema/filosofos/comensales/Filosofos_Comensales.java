package problema.filosofos.comensales;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.Random;

/**
 * Autores del código
 * @author Jesús Ricardo Delgado Sánchez
 * @author Isaías Juarez Esparza
 */
public class Filosofos_Comensales extends javax.swing.JFrame {
    
    HashMap<Integer, Integer> filosofos = new HashMap<>();   //Contiene el número de filósofo y su contador de veces que ha comido
    HiloPrograma filosofos_comensales = new HiloPrograma();   //Hilo que se encargará de ejecutar el programa
    ArrayList<Integer> numero_filosofos = new ArrayList<>();   //Contiene los números de los filósofos que serán tomados en cuenta en el semáforo
    
    ImageIcon pensando = new ImageIcon("src/img/pensando.png");
    ImageIcon comiendo = new ImageIcon("src/img/comiendo.png");
    ImageIcon descansando = new ImageIcon("src/img/descansando.png");
    
    /**
     * Constructor de la clase
     */
    public Filosofos_Comensales() {
        initComponents();
        
        //Configuración de la ventana
        this.setSize(750, 620);
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
        lblOcupado5.setIcon(icono_bloquear);
        lblOcupado2.setIcon(icono_bloquear);
        lblOcupado4.setIcon(icono_bloquear);
        lblOcupado3.setIcon(icono_bloquear);
        
        //////////////////////////////////////////////////
        //              PROGRAMA TERMINADO              //
        //////////////////////////////////////////////////
        
        ImageIcon terminado = new ImageIcon("src/img/terminado.png");
        Icon icono_terminado = new ImageIcon(terminado.getImage().getScaledInstance(lblTerminado.getWidth(), lblTerminado.getHeight(), Image.SCALE_DEFAULT));
        lblTerminado.setIcon(icono_terminado);
        lblTerminado.setVisible(false);
        
        //////////////////////////////////////////////////
        //               INICIALIZACIONES               //
        //////////////////////////////////////////////////
        
        for(int i = 1; i <= 5; i++) {
            numero_filosofos.add(i);        //Arreglo que incluye los números de los filósofos
            comido_veces(i, 0);             //Se inicializan los contadores de cada filósofo (interfaz)
            filosofos.put(i, 0);            //Se inicializan los contadores de cada filósofo (arreglo asociativo)  
            estadoFilosofos(i, false);      //Empiezan todos pensando
            tenedor_ocupado(i, false);      //Todos los tenedores están disponibles
        }
    }
    
    /**
     * Le asigna el icono al proyecto (tanto en la ventana como en el programa)
     * @return Devuelve la imagen que tendrá como icono el proyecto
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/tenedor.png"));
        return retValue;
    }
    
    /**
     * Es un semáforo que indica el número del filósofo que va a comer
     * @return Devuelve el número del filósofo seleccionado de manera aleatoria (valor entre 1 y 5)
     */
    private int lanzarMoneda() {
        Random random = new Random();
        int numero_aleatorio = numero_filosofos.get(random.nextInt(numero_filosofos.size()));   //Números aleatorios del 1 - 5
        return numero_aleatorio;
    }
    
    /**
     * Se utiliza para saber que filósofo será el siguiente en comer
     * @return Devuelve un valor entre 1 y 2
     */
    private int lanzarMoneda2Valores() {
        int numero_aleatorio = (int) (Math.floor(Math.random() * 2) + 1);   //Números aleatorios del 1 - 2
        return numero_aleatorio;
    }
    
    /**
     * Se utiliza para poner o quitar el icono de bloqueo a un tenedor
     * @param num Hace referencia al número de icono de bloqueo
     * @param disponible Hace visible u oculta el icono de bloqueo
     */
    public void tenedor_ocupado(int num, boolean disponible) {
        switch(num) {
            case 1: lblOcupado1.setVisible(disponible); break;
            case 2: lblOcupado2.setVisible(disponible); break;
            case 3: lblOcupado3.setVisible(disponible); break;
            case 4: lblOcupado4.setVisible(disponible); break;
            case 5: lblOcupado5.setVisible(disponible); break;
        }
    }
    
    /**
     * Se utiliza para asignar al campo de texto el número de veces que ha comido cada filósofo
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
    
    /**
     * Se utiliza para cambiar los iconos de los estados de los filósofos (comiendo o pensando)
     * @param num Hace referencia al número de filósofo
     * @param comiendo Evalua si el filósofo esta comiendo o no (pensando)
     */
    private void estadoFilosofos(int num, boolean filosofoComiendo) {
        if(!filosofoTerminado(num)) {
            if(!filosofoComiendo) {   //Pensando
                Icon icono_pensando = new ImageIcon(pensando.getImage().getScaledInstance(lblF1Estado.getWidth(), lblF1Estado.getHeight(), Image.SCALE_DEFAULT));
                switch(num) {
                    case 1: lblF1Estado.setIcon(icono_pensando); break;
                    case 2: lblF2Estado.setIcon(icono_pensando); break;
                    case 3: lblF3Estado.setIcon(icono_pensando); break;
                    case 4: lblF4Estado.setIcon(icono_pensando); break;
                    case 5: lblF5Estado.setIcon(icono_pensando); break;
                }
            }
            else {   //Comiendo
                Icon icono_comiendo = new ImageIcon(comiendo.getImage().getScaledInstance(lblF1Estado.getWidth(), lblF1Estado.getHeight(), Image.SCALE_DEFAULT));
                switch(num) {
                    case 1: lblF1Estado.setIcon(icono_comiendo); break;
                    case 2: lblF2Estado.setIcon(icono_comiendo); break; 
                    case 3: lblF3Estado.setIcon(icono_comiendo); break;
                    case 4: lblF4Estado.setIcon(icono_comiendo); break;
                    case 5: lblF5Estado.setIcon(icono_comiendo); break;
                }
            }
        }
    }
    
    /**
     * Evalua si el filósofo ha comido 5 veces
     * @param num Hace referencia al número de filósofo
     * @return Devuelve cierto o falso según sea el caso
     */
    private boolean filosofoTerminado(int num) {
        boolean filosofo_eliminado = false;
        if(filosofos.get(num) == 5) {
            for(int i = 0; i < numero_filosofos.size(); i++) {
                if(numero_filosofos.get(i) == num) {
                    numero_filosofos.remove(new Integer(num));
                    filosofo_eliminado = true;
                }
                System.out.println("Filosofos que aun pueden comer: " + numero_filosofos);
            }
            
            if(!filosofo_eliminado) {
                Icon icono_descansando= new ImageIcon(descansando.getImage().getScaledInstance(lblF1Estado.getWidth(), lblF1Estado.getHeight(), Image.SCALE_DEFAULT));
                switch(num) {
                    case 1: lblF1Estado.setIcon(icono_descansando); break;
                    case 2: lblF2Estado.setIcon(icono_descansando); break;
                    case 3: lblF3Estado.setIcon(icono_descansando); break;
                    case 4: lblF4Estado.setIcon(icono_descansando); break;
                    case 5: lblF5Estado.setIcon(icono_descansando); break;
                }
            }
            
            return !filosofo_eliminado;   //Si el filósofo fue eliminado, no se cambiará inmediatamente el icono al estado descansando
        }
        return false;
    }
    
    /**
     * Asigna los tenedores ocupados, estado actual del filósofo y aumenta el contador de cada uno de manera automática
     * @param num Hace referencia al número de filósofo
     */
    private boolean filosofoComiendo(int num) {
        if (filosofos.get(num) < 5) {
            tenedor_ocupado(num, true);

            if(num != 1)
                tenedor_ocupado(num-1, true);
            else
                tenedor_ocupado(5, true);

            filosofos.put(num, filosofos.get(num) + 1);
            estadoFilosofos(num, true);
            
            switch(num) {
                case 1: txtF1.setText(String.valueOf(filosofos.get(1))); break;
                case 2: txtF2.setText(String.valueOf(filosofos.get(2))); break;
                case 3: txtF3.setText(String.valueOf(filosofos.get(3))); break;
                case 4: txtF4.setText(String.valueOf(filosofos.get(4))); break;
                case 5: txtF5.setText(String.valueOf(filosofos.get(5))); break;
            }

            return true;
        }
        
        return false;
    }
    
    /**
     * Evalua que filósofo va a comer y realiza todo el proceso
     * @param num Hace referencia al número de filósofo
     */
    private void comer(int num) {
        switch (num) {
            case 1:
                if(filosofoComiendo(1)) {
                    System.out.println("El filósofo " + num + " está comiendo.");
                    if (lanzarMoneda2Valores() == 1) {
                        if (filosofoComiendo(3))
                            System.out.println("El filósofo 3 está comiendo.");
                    } else {
                        if (filosofoComiendo(4))
                            System.out.println("El filósofo 4 está comiendo.");
                    }
                }
                break;
            case 2:                                 
                if(filosofoComiendo(2)) {
                    System.out.println("El filósofo " + num + " está comiendo.");
                    if (lanzarMoneda2Valores() == 1) {
                        if (filosofoComiendo(4))
                            System.out.println("El filósofo 4 está comiendo.");
                    } else {
                        if (filosofoComiendo(5))
                            System.out.println("El filósofo 5 está comiendo.");
                    }
                }
                break;
            case 3:
                if(filosofoComiendo(3)) {
                    System.out.println("El filósofo " + num + " está comiendo.");
                    if (lanzarMoneda2Valores() == 1) {
                        if (filosofoComiendo(5))
                            System.out.println("El filósofo 5 está comiendo.");
                    } else {
                        if (filosofoComiendo(1))
                            System.out.println("El filósofo 1 está comiendo.");
                    }
                }
                break;
            case 4:                                   
                if(filosofoComiendo(4)) {
                    System.out.println("El filósofo " + num + " está comiendo.");                   
                    if (lanzarMoneda2Valores() == 1) {
                        if (filosofoComiendo(1))
                            System.out.println("El filósofo 1 está comiendo.");
                    } else {
                        if (filosofoComiendo(2))
                            System.out.println("El filósofo 2 está comiendo.");
                    }
                }
                break;
            case 5:
                if(filosofoComiendo(5)) {
                    System.out.println("El filósofo " + num + " está comiendo.");
                    if (lanzarMoneda2Valores() == 1) {
                        if (filosofoComiendo(2))
                            System.out.println("El filósofo 2 está comiendo.");
                    } else {
                        if (filosofoComiendo(3))
                            System.out.println("El filósofo 3 está comiendo.");
                    }
                }
                break;
            default:
                break;
        }
        
        System.out.println("------------------------------");
        
        try{
            Thread.sleep(5000);   //Tiempo que el filósofo pasa comiendo
        } catch(InterruptedException e){  }
        
        for(int i = 1; i <= 5; i++) {
            tenedor_ocupado(i, false);
            estadoFilosofos(i, false);
        }
    }
    
    private boolean terminarPrograma() {
        return filosofos.get(1) == 5 && filosofos.get(2) == 5 && filosofos.get(3) == 5 && filosofos.get(4) == 5 && filosofos.get(5) == 5;
    }
    
    /**
     * Es el hilo que lleva el programa, el cual se ejecutará hasta que cada filósofo halla comido 5 veces
     */
    private class HiloPrograma extends Thread {
        public void run() {
            int num;
            while (true) {
                num = lanzarMoneda();
                comer(num);               
                if (terminarPrograma()) {
                    lblTerminado.setVisible(true);
                    System.out.println("¡Hemos terminado!");
                    filosofos_comensales.stop();
                }
            } 
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTerminado = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
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
        lblF5Estado = new javax.swing.JLabel();
        lblF4Estado = new javax.swing.JLabel();
        lblF3Estado = new javax.swing.JLabel();
        lblF2Estado = new javax.swing.JLabel();
        lblF1Estado = new javax.swing.JLabel();
        lblF5 = new javax.swing.JLabel();
        lblF4 = new javax.swing.JLabel();
        lblF3 = new javax.swing.JLabel();
        lblF2 = new javax.swing.JLabel();
        lblF1 = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblTerminado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 150, 150));

        btnIniciar.setBackground(new java.awt.Color(153, 192, 169));
        btnIniciar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnIniciar.setText("Iniciar programa");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 150, 50));
        getContentPane().add(lblOcupado5, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 252, 24, 24));
        getContentPane().add(lblOcupado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 355, 24, 24));
        getContentPane().add(lblOcupado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 422, 24, 24));
        getContentPane().add(lblOcupado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 355, 24, 24));
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
        getContentPane().add(lblF5Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 80, 80));
        getContentPane().add(lblF4Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 80, 80));
        getContentPane().add(lblF3Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 80, 80));
        getContentPane().add(lblF2Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 80, 80));
        getContentPane().add(lblF1Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 80, 80));

        lblF5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF5.setText("F5");
        getContentPane().add(lblF5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 40, 40));

        lblF4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF4.setText("F4");
        getContentPane().add(lblF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 40, 40));

        lblF3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF3.setText("F3");
        getContentPane().add(lblF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 40, 40));

        lblF2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF2.setText("F2");
        getContentPane().add(lblF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 40, 40));

        lblF1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF1.setText("F1");
        getContentPane().add(lblF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 40, 40));
        getContentPane().add(lblMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 256, 256));

        lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Problema Filósofos Comensales");
        lblTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 30, 380, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        System.out.println("Filosofos que aun pueden comer: " + numero_filosofos);
        filosofos_comensales.start();   //Comienza el hilo del programa
        btnIniciar.setVisible(false);
    }//GEN-LAST:event_btnIniciarActionPerformed

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
    private javax.swing.JButton btnIniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblF1;
    private javax.swing.JLabel lblF1Estado;
    private javax.swing.JLabel lblF2;
    private javax.swing.JLabel lblF2Estado;
    private javax.swing.JLabel lblF3;
    private javax.swing.JLabel lblF3Estado;
    private javax.swing.JLabel lblF4;
    private javax.swing.JLabel lblF4Estado;
    private javax.swing.JLabel lblF5;
    private javax.swing.JLabel lblF5Estado;
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
    private javax.swing.JLabel lblTerminado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVecesQueHaComido;
    private javax.swing.JTextField txtF1;
    private javax.swing.JTextField txtF2;
    private javax.swing.JTextField txtF3;
    private javax.swing.JTextField txtF4;
    private javax.swing.JTextField txtF5;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MapManager;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.IConstants;
import model.Nodo;
import model.Posicion;
import model.Linea;

/**
 *
 * @author dark1
 */
public class Mapa extends javax.swing.JFrame implements IConstants, Observer, ActionListener {

    /**
     * Creates new form Mapa
     */
    private MapManager MP;
    private Hashtable<Button, Nodo> hashBotones;
    private ArrayList<Linea> listaLineas;
    
    public Mapa() {
        initComponents();
        Imagen imagen = new Imagen();
        this.MP = new MapManager();
        this.MP.addObserver(this);
        pnl_img_ciudad.add(imagen);
        this.hashBotones = new Hashtable<Button, Nodo>();
        this.listaLineas = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_img_ciudad = new javax.swing.JPanel();
        btn_iniciarRecorrido = new javax.swing.JButton();
        lbl_Carro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 1000));

        pnl_img_ciudad.setBackground(new java.awt.Color(255, 0, 0));
        pnl_img_ciudad.setPreferredSize(new java.awt.Dimension(743, 450));
        pnl_img_ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_img_ciudadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_img_ciudadLayout = new javax.swing.GroupLayout(pnl_img_ciudad);
        pnl_img_ciudad.setLayout(pnl_img_ciudadLayout);
        pnl_img_ciudadLayout.setHorizontalGroup(
            pnl_img_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_img_ciudadLayout.setVerticalGroup(
            pnl_img_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        btn_iniciarRecorrido.setText("Iniciar recorrido");
        btn_iniciarRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarRecorridoActionPerformed(evt);
            }
        });

        lbl_Carro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_iniciarRecorrido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(lbl_Carro)
                .addGap(180, 180, 180))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_img_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_img_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_iniciarRecorrido)
                    .addComponent(lbl_Carro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_img_ciudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_img_ciudadMouseClicked
        if (!this.MP.isIniciarRecorrido()) {
            this.MP.createNode(evt.getX(), evt.getY()); 
            
        }
    }//GEN-LAST:event_pnl_img_ciudadMouseClicked

    private void btn_iniciarRecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarRecorridoActionPerformed
        this.MP.setIniciarRecorrido(true);
        JOptionPane.showMessageDialog(this, "Presione el nodo al cual se quiere dirigir.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        
        
    }//GEN-LAST:event_btn_iniciarRecorridoActionPerformed

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
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mapa().setVisible(true);
            }
        });
    }
    
    @Override
    public void update(Observable o, Object pNodo) {
        Nodo<Posicion> nodoAgregado = (Nodo<Posicion>)pNodo;
        
        Button btn = new Button("");
        btn.setBounds(nodoAgregado.getDato().getX(), nodoAgregado.getDato().getY(), DIAMETRO, DIAMETRO);
        btn.setBackground(Color.blue);
        btn.addActionListener(this);
        this.add(btn);
        this.hashBotones.put(btn, nodoAgregado);
        
        if (this.MP.getUltimoInsertado() != this.MP.getPuntoPartida()) {
            crearLinea(nodoAgregado, NO_ES_BOTON);
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Nodo<Posicion> nodoSeleccionado = hashBotones.get(ae.getSource());
        crearLinea(nodoSeleccionado, SI_ES_BOTON);
        repaint();
        this.MP.setUltimoInsertado(nodoSeleccionado);
        if (!this.MP.isIniciarRecorrido()) {
            this.MP.createEdge(this.MP.getUltimoInsertado(), nodoSeleccionado);
            
        }else{
            if (nodoSeleccionado != this.MP.getPuntoPartida()) {
                mostrarRecorrido(nodoSeleccionado);
            }else{
                JOptionPane.showMessageDialog(this, "No es posible seleccionar el punto de partida como destino", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public class Imagen extends javax.swing.JPanel implements IConstants{
 
    public Imagen() {
        this.setSize(ANCHO_IMAGEN, LARGO_IMAGEN); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics

        public void paint(Graphics grafico) {
        Dimension height = getSize();

        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

        ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/ciudad.png")); 

        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciarRecorrido;
    private javax.swing.JLabel lbl_Carro;
    private javax.swing.JPanel pnl_img_ciudad;
    // End of variables declaration//GEN-END:variables

    public void mostrarRecorrido(Nodo<Posicion> pNodoSeleccionado){
        Stack<Nodo> recorrido = this.MP.getGrafo().travelGraph(pNodoSeleccionado, this.MP.getPuntoPartida());
            
            new Thread(){
                public void run(){

                    while(!recorrido.isEmpty()){
                        Nodo<Posicion> nodoActual = recorrido.pop();
                        lbl_Carro.setLocation(nodoActual.getDato().getX(), nodoActual.getDato().getY()-25);
                        
                        repaint();
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                        }    
                    }
                }
            }.start();
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
    
        for (Linea linea : listaLineas) {
            linea.pintarLinea(g);
        }
        
    }
    
    public void crearLinea(Nodo <Posicion> pNodo, boolean esBoton){
        Linea linea = null;
        if (esBoton) {
            Nodo <Posicion> nodoActual = this.MP.getUltimoInsertado();
            linea = new Linea(nodoActual.getDato().getX()+FIX_X,
                                    nodoActual.getDato().getY()+FIX_Y,
                                    pNodo.getDato().getX()+FIX_X,
                                    pNodo.getDato().getY()+FIX_Y);
        }else{
            Nodo <Posicion> nodoActual = this.MP.getUltimoInsertado();
             linea = new Linea(nodoActual.getListaAdyacentes().get(NODO_ANTERIOR).getDato().getX()+FIX_X,
                     nodoActual.getListaAdyacentes().get(NODO_ANTERIOR).getDato().getY()+FIX_Y,
                     nodoActual.getDato().getX()+FIX_X, 
                     nodoActual.getDato().getY()+FIX_Y);
        }
        listaLineas.add(linea);
    }
}



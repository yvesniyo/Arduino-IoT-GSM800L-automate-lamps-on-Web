
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//password of server gH3*gB3%;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class webLeds extends javax.swing.JFrame {

    /**
     * Creates new form webLeds
     */
    public static  String button;
    public static  String State="OFF";
    public static String lamp1,lamp2;
    public static String all_action="OFF";
    //public static String db=""+"jdbc:mysql://localhost:3306/lamps"+","+"root"+",";
    //Connection conn;
    public static void status() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        //Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lamps","root","");
        Connection conn=DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com:3306/sql2211572", "sql2211572","gH3*gB3%");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM activity where id='1'");
        while(rs.next()){
            lamp1=rs.getString("lamp1");
            lamp2=rs.getString("lamp2");
        }
        if(lamp1.equals("ON") && lamp2.equals("ON")){
            all_action="ON";
        }else if(lamp1.equals("OFF") && lamp2.equals("OFF")){
            all_action="OFF";
        }
    }
    public  void logged(){
        initComponents();
        connection.setText("Connection Established");
        try {
            status();
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"There is no Connection");
            connection.setText("Connection Not Available");
            Logger.getLogger(webLeds.class.getName()).log(Level.SEVERE, null, ex);
        }
        lm1.setText(lamp1);
        lm2.setText(lamp2);
    }
    
    public  webLeds()  {
        initComponents();
        connection.setText("Connection Established");
        try {
            status();
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"There is no Connection");
            connection.setText("Connection Not Available");
            Logger.getLogger(webLeds.class.getName()).log(Level.SEVERE, null, ex);
        }
        lm1.setText(lamp1);
        lm2.setText(lamp2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lm1 = new javax.swing.JLabel();
        lm2 = new javax.swing.JLabel();
        refl = new javax.swing.JButton();
        connection = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lamps");
        setBackground(new java.awt.Color(0, 102, 102));
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.lightGray);

        jLabel1.setFont(new java.awt.Font("Meiryo", 0, 24)); // NOI18N
        jLabel1.setText("Lamp Management System Project ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));

        jPanel3.setBackground(new java.awt.Color(204, 204, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Registerd Lamps");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToggleButton1.setText("Lamp 1");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Lamp 2");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("All");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("Lamp 2 :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Lamp 1 :");

        lm1.setFont(new java.awt.Font("Lucida Sans Typewriter", 2, 12)); // NOI18N

        lm2.setFont(new java.awt.Font("Lucida Sans Typewriter", 2, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jToggleButton1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jToggleButton2)
                        .addGap(33, 33, 33)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lm1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lm2)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lm1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lm2))
                .addGap(59, 59, 59))
        );

        refl.setText("Refresh");
        refl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        refl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reflActionPerformed(evt);
            }
        });

        connection.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        connection.setForeground(new java.awt.Color(204, 153, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(refl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(connection, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(connection, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        button="lamp1";
        try {
            status();
            send_request(button,State);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"There is no Connection");
            connection.setText("Connection Not Available");
            Logger.getLogger(webLeds.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        button="lamp2";
        try {
            status();
            send_request(button,State);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"There is no Connection");
            connection.setText("Connection Not Available");
            Logger.getLogger(webLeds.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lamps","root","");
            conn=DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com:3306/sql2211572", "sql2211572","gH3*gB3%");
            Statement stmt=conn.createStatement();
            if(all_action.equals("OFF")){
                all_action="ON";
            }else{
                all_action="OFF";
            }
            
            String query="UPDATE activity SET all_lamps='"+all_action+"',lamp1='"+all_action+"',lamp2='"+all_action+"' WHERE id='1'";
            stmt.executeUpdate(query);
            status();
            lm1.setText(lamp1);
            lm2.setText(lamp2);
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"There is no Connection");
            connection.setText("Connection Not Available");
            Logger.getLogger(webLeds.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void reflActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflActionPerformed
        try {
            reflesh();
            connection.setText("Connection Available");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(webLeds.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            connection.setText("Connection Not Available");
            Logger.getLogger(webLeds.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_reflActionPerformed
    public static void send_request(String button,String State) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        //Connectio conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lamps", "root","");
        Connection conn=DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com:3306/sql2211572", "sql2211572","gH3*gB3%");
        Statement stmt=conn.createStatement();
        if(button.equals("lamp1")){
            if(lamp1.equals("ON")){
                State="OFF";
            }else{
                State="ON";
            }            
        }else if(button.equals("lamp2")){
            if(lamp2.equals("ON")){
                State="OFF";
            }else{
                State="ON";
            }
        }
        String query="UPDATE activity SET "+button+"='"+State+"' where id=1";
        stmt.executeUpdate(query);
        status();
        lm1.setText(lamp1);
        lm2.setText(lamp2);
        
        
    }
    public static void reflesh() throws ClassNotFoundException, SQLException{
        status();
        lm1.setText(lamp1);
        lm2.setText(lamp2);
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
            java.util.logging.Logger.getLogger(webLeds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(webLeds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(webLeds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(webLeds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new webLeds().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel connection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private static javax.swing.JLabel lm1;
    private static javax.swing.JLabel lm2;
    private javax.swing.JButton refl;
    // End of variables declaration//GEN-END:variables
}

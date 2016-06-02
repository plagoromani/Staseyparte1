package login;

import aplicacion.Anuncio;
import aplicacion.MainForm;
import aplicacion.Usuario;
import database.DataBase;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jota
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        titulo_lbl = new javax.swing.JLabel();
        usuario_lbl = new javax.swing.JLabel();
        password_lbl = new javax.swing.JLabel();
        usuario_txt = new javax.swing.JTextField();
        password_txt = new javax.swing.JPasswordField();
        login_btn = new javax.swing.JButton();
        signup_btn = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        titulo_lbl.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        titulo_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_lbl.setText("Login");

        usuario_lbl.setText("Usuario:");

        password_lbl.setText("Contraseña:");

        login_btn.setText("Login");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        signup_btn.setText("Sign Up");
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(signup_btn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(password_lbl)
                                    .addComponent(usuario_lbl))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usuario_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(password_txt))))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario_lbl)
                    .addComponent(usuario_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_lbl)
                    .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_btn)
                    .addComponent(signup_btn))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        boolean incorrecto = true;
        for (Usuario usuario : Usuario.getUsuarios()) {
            if(usuario.getNickName().equals(usuario_txt.getText()) && usuario.getPassword().equals(password_txt.getText())){
                System.out.println("Login correcto");
                MainForm.setU(usuario);
                this.dispose();
                MainForm f = new MainForm();
                f.setVisible(true);
                incorrecto=false;
                break;
            }
        }
        if(incorrecto){
            System.out.println("Login incorrecto");
        }
    }//GEN-LAST:event_login_btnActionPerformed

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        JPanel panel = new JPanel();
        panel.setSize(200, 500);
        JTextField nickname = new JTextField(10);
        JTextField nombre = new JTextField(10);
        JTextField apellidos = new JTextField(10);
        JTextField edad = new JTextField(10);
        JTextField descripcion = new JTextField(10);
        JPasswordField password = new JPasswordField(10);
        panel.add(new JLabel("NickName:"));
        panel.add(nickname);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombre);
        panel.add(new JLabel("Apellidos:"));
        panel.add(apellidos);
        panel.add(new JLabel("Edad:"));
        panel.add(edad);
        panel.add(new JLabel("Descripcion:"));
        panel.add(descripcion);
        panel.add(new JLabel("Contraseña:"));
        panel.add(password);
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Registro", JOptionPane.OK_CANCEL_OPTION);
        if(opcion==JOptionPane.OK_OPTION){
            Usuario.getUsuarios().add(new Usuario(nickname.getText(),nombre.getText(),apellidos.getText(),
            Integer.parseInt(edad.getText()),descripcion.getText(),password.getText()));
            DataBase.insertarUsuario(nickname.getText(),nombre.getText(),apellidos.getText(),
            edad.getText(),descripcion.getText(),password.getText());
        }
    }//GEN-LAST:event_signup_btnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DataBase.cerrarConexion();
    }//GEN-LAST:event_formWindowClosing

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(DataBase.conectar());
        Anuncio.mostrarAnuncios();
        Usuario.mostrarUsuarios();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_btn;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JPasswordField password_txt;
    private javax.swing.JButton signup_btn;
    private javax.swing.JLabel titulo_lbl;
    private javax.swing.JLabel usuario_lbl;
    private javax.swing.JTextField usuario_txt;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import aplicacion.Anuncio;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jota
 */
public class DataBase {

    private static Connection conexion;
    private static final String BD = "stacey";
    private static final String USER = "root";
    private static final String PASSWORD = "003100729011j";
    private static final String HOST = "localhost";
    private static final String SERVER = "jdbc:mysql://" + HOST + "/" + BD;

    public static String conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(SERVER, USER, PASSWORD);
            importUsers();
            importAnuncios();
            return "Conexión a base de datos " + SERVER + " ... OK";
        } catch (ClassNotFoundException ex) {
            return "Error cargando el Driver MySQL JDBC ... FAIL";
        } catch (SQLException ex) {
            return "Imposible realizar conexion con " + SERVER + " ... FAIL";
        }

    }

    public static void insertarUsuario(String nickName, String nombre, String apellidos, String edad, String descripcion, String password) {
        Statement s = null;
        try {
            s = conexion.createStatement();
            s.executeUpdate("insert into usuarios values('" + nickName + "','" + nombre + "','" + apellidos + "'," + edad + ",'" + descripcion
                    + "','" + password + "');");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                s.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ResultSet consultarDatos() {
        ResultSet rs = null;
        Statement s = null;
        try {
            s = conexion.createStatement();
            rs = s.executeQuery("select * from alumnos;");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return rs;
    }

    public static void eliminar(String primaryKey) throws Exception {
        if (primaryKey.equals("null")) {
            throw new Exception("Fila inválida");
        }
        Statement s = null;
        try {
            s = conexion.createStatement();
            s.executeUpdate("delete from alumnos where id=" + primaryKey + ";");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                s.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public static void actualizar(String columna, String valor, String primaryKey) {
        try {
            Statement s = conexion.createStatement();
            s.executeUpdate("update alumnos set " + columna + "='" + valor + "' where id=" + primaryKey);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void importUsers() throws SQLException {
        Statement s = null;
        ResultSet rs = null;
        s = conexion.createStatement();
        rs = s.executeQuery("select * from usuarios");
        while (rs.next()) {
            Usuario.getUsuarios().add(new Usuario(rs.getString("nickName"), rs.getString("nombre"),
                    rs.getString("apellidos"), rs.getInt("edad"), rs.getString("descripcion"), rs.getString("password")));
        }
        rs.close();
        s.close();
    }

    public static void importAnuncios() throws SQLException {
        Statement s=conexion.createStatement();
        ResultSet rs;
        String titulo, descripcion;
        String propietario;
        float alquiler;
        String[] imagenes = new String[3];
        rs = s.executeQuery("select * from anuncios");
        while (rs.next()) {
            titulo = rs.getString("titulo");
            descripcion = rs.getString("descripcion");
            propietario = rs.getString("propietario");
            alquiler = rs.getFloat("alquiler");
            imagenes = rs.getString("imagenes").split(",");
            Usuario user = null;
            for (int i = 0; i < Usuario.getUsuarios().size(); i++) {
                if (propietario.equals(Usuario.getUsuarios().get(i).getNickName())) {
                    user = Usuario.getUsuarios().get(i);
                    break;
                }
            }
            Anuncio.getAnuncios().add(new Anuncio(titulo, user, descripcion, imagenes, alquiler));
        }
        rs.close();
        s.close();

    }
}

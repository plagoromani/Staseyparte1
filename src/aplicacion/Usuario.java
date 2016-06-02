/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;

/**
 *
 * @author jota
 */
public class Usuario {
    
    private static ArrayList<Usuario> usuarios = new ArrayList();
    
    private String nickName;
    private String nombre;
    private String apellidos;
    private int edad;
    private String descripcion;    
    private String password;
    
    public Usuario(String nickname,String nombre,String apellidos,int edad,String descripcion,String password){
        this.nickName=nickname;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.edad=edad;
        this.descripcion=descripcion;
        this.password=password;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nickName=" + nickName + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", descripcion=" + descripcion + ", password=" + password + '}';
    }
    
    public static void mostrarUsuarios(){
        System.out.println(usuarios.toString());
    }
    
    
}

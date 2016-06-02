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
public class Anuncio {
    
    private static ArrayList<Anuncio> anuncios = new ArrayList();
    
    private String titulo;
    private Usuario propietario;
    private String descripcion;
    private String imagen;
    private int alquiler;

    public Anuncio(String titulo, Usuario propietario, String descripcion, String imagen, int alquiler) {
        this.titulo = titulo;
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.alquiler = alquiler;
    }

    public static ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public float getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }
    
    

    @Override
    public String toString() {
        return "Anuncio{" + "titulo=" + titulo + ", propietario=" + propietario + ", descripcion=" + descripcion + ", imagen=" + imagen + ", alquiler=" + alquiler + '}';
    }
    
    public static void mostrarAnuncios(){
        System.out.println(anuncios.toString());
    }
    
    
}

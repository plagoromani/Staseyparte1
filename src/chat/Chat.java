/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Pablite5
 */
public class Chat {

  
JFrame ventana_chat=null;
JButton btn_enviar = null;
    JTextField txt_mensaje=null;
    JTextArea area_chat=null;
    JPanel contains_Areachat=null;
    JPanel contains_btntxt=null;
    JScrollPane scroll=null;
   ServerSocket chat=null;
   Socket socket = null;
   BufferedReader lector=null;
   PrintWriter escritor=null;
   JButton btn_cerrar=null;
    public Chat(){
        crearInterfaz();
       
    }
    public void crearInterfaz(){
        ventana_chat=new JFrame("CHAT OFERTADOR");
        btn_enviar=new JButton("ENVIAR");
        txt_mensaje=new JTextField(4);//4columnas de ancho
        area_chat=new JTextArea(10,12);//10 filas,12 columnas
        scroll = new JScrollPane(area_chat);
        contains_Areachat=new JPanel();
        contains_Areachat.setLayout(new GridLayout(1,1));//para que solo quepa un componente
        contains_Areachat.add(scroll);
        contains_btntxt = new JPanel();
        contains_btntxt.setLayout(new GridLayout(1,2));//así caben 2 componentes
        contains_btntxt.add(txt_mensaje);
        contains_btntxt.add(btn_enviar);
        ventana_chat.setLayout(new BorderLayout());
        ventana_chat.add(contains_Areachat,BorderLayout.NORTH);
         ventana_chat.add(contains_btntxt,BorderLayout.SOUTH);
          ventana_chat.setSize(300,220);//altura y anchura
           ventana_chat.setVisible(true);
            ventana_chat.setResizable(false);//Aquí utilizamos esto para no poder cambiar su tamaño,que siempre sea igual
             ventana_chat.setLocationRelativeTo(null);
              btn_cerrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    area_chat.setVisible(false);
                }
                });
                
             
             
             Thread principal = new Thread(new Runnable(){
                 public void run(){
                     try{
                         chat = new ServerSocket(9000);
                         while(true){
                             socket = chat.accept();
                             leer();
                             escribir();
                         }
                   }catch(Exception ex){
                         ex.printStackTrace();
                     }
                 }
                 });
             principal.start();
    }
                               
                     
    public void leer(){
       Thread leer_hilo = new Thread(new Runnable(){

           public void run(){
               try{ 
            lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));//obtenemos la entrada del objeto socket y a su vez leer lo que nos están enviando
       while(true){
           String mensaje_recibido = lector.readLine();
           area_chat.append("Cliente dice : " + mensaje_recibido + " \n");
       }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
           });
        leer_hilo.start();
            
        }
    //Esto vale para obtener lo que tenga la caja de texto, guardarlo en el objeto enviar_mensaje y enviarlo con el println()
        public void escribir(){
            Thread escribir_hilo = new Thread(new Runnable(){
                public void run(){
                        try{
                       escritor = new PrintWriter(socket.getOutputStream(),true);//obtengo la salida, es decir lo que envio y pongo el true para que nos deje enviar mensajes
          btn_enviar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String enviar_mensaje = txt_mensaje.getText();
                    escritor.println(enviar_mensaje);
                    txt_mensaje.setText("");
                }
            });
            }catch(Exception ex){
                ex.printStackTrace();
            }
                }
            });
            escribir_hilo.start();
        }
              
            
        public static void main(String[] args) {
     Chat nuevo=new Chat();
    
       
    }

  
    
}

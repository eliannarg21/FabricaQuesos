package logico;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor extends Thread
{
  
  public static void main (String args[])
  {
    ServerSocket sfd = null;
    try
    {
      sfd = new ServerSocket(6666);
    }
    catch (IOException ioe)
    {
      System.out.println("Comunicación rechazada."+ioe);
      System.exit(1);
    }
    
    while (true) {
      try
      {
        Socket nsfd = sfd.accept();
        System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
        DataInputStream dis = new DataInputStream(new BufferedInputStream(nsfd.getInputStream()));
        String str = dis.readUTF();
        File archivo = new File("respaldo/factura.txt");
        FileWriter escritor;
        escritor = new FileWriter(archivo);

        if(!str.equals("")) {
         escritor.write(str);
        }
        escritor.close();
      }
      catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
      }
    }
  }
}
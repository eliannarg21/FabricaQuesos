package logico;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;
 
public class texto extends Thread
{
  Socket nsfd;
  DataInputStream FlujoLectura;
  static DataOutputStream FlujoEscritura;

  public texto (Socket sfd) {
    nsfd = sfd;
    try
    {
      FlujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
      FlujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
    }
    catch(IOException ioe)
   {
     System.out.println("IOException(Flujo): "+ioe);
   }
 }
  
  public void run(){
	  File archivo = new File("respaldo/factura.txt");
      FileWriter escritor;
    while(true)
    {
      try
      {
    	escritor = new FileWriter(archivo);
        String linea = FlujoLectura.readUTF();
        if (!linea.equals(""))
        {
            texto.FlujoEscritura.writeUTF(linea);
     	    texto.FlujoEscritura.flush();
     	    escritor.write(linea);
     	   escritor.close();
        }
      }
      catch(IOException ioe)
      {
 	break;
      }
    }
  }
  
  /*
  public void sendMessage(String message) throws IOException {
      FlujoEscritura.writeUTF(message);
      FlujoEscritura.flush();
  }
  
  public String receiveMessage() throws IOException {
      String message = FlujoLectura.readUTF();
      return message;
  } // end receiveMessage
  
  public void sendFile(File file) throws IOException {
      FileInputStream fileIn = new FileInputStream(file);
      byte[] buf = new byte[Short.MAX_VALUE];
      int bytesRead;        
      while( (bytesRead = fileIn.read(buf)) != -1 ) {
          FlujoEscritura.writeShort(bytesRead);
          FlujoEscritura.write(buf,0,bytesRead);
      }
      FlujoEscritura.writeShort(-1);
      fileIn.close();
  }



  public void receiveFile(File file) throws IOException {
      FileOutputStream fileOut = new FileOutputStream(file);
      byte[] buf = new byte[Short.MAX_VALUE];
      int bytesSent;        
      while( (bytesSent = FlujoLectura.readShort()) != -1 ) {
          FlujoLectura.readFully(buf,0,bytesSent);
          fileOut.write(buf,0,bytesSent);
      }
      fileOut.close();
  }  */
 

}

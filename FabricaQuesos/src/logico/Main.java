package logico;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner captu = new Scanner(System.in);
		
		System.out.print("Ingrese el nombre del cliente");
		Cliente.nombre = captu.next();
		
	
		 List<String> misquesos = new ArrayList<String>();
		 
		misquesos.add("queso cilindrico");
	    misquesos.add("queso esfera");
	    misquesos.add("queso hueco");
	    
	    System.out.println("Productos a facturar:"
                + misquesos); 
	    
	    
	
	    System.out.print("Ingrese el precio de los productos:\n");
		 
	
	    
	    
	    
	    
		
	    Calendar fecha = new GregorianCalendar();
	    
                                                        
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
  
     
        System.out.println("Fecha Actual: " + dia + "/" + (mes+1) + "/" + año);
        
                System.out.printf("Hora Actual: %02d:%02d:%02d %n", hora, minuto, segundo); 
	    
	}

}

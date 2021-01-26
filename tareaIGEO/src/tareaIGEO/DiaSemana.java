package tareaIGEO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

 

public class DiaSemana {
	//Objeto con fecha formateada
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//Creo objeto de tipo calendario
	public static Calendar calendar = new GregorianCalendar();
	
	public static void main(String[] args) {
		/*
		// Mostrar Fecha Actual
		Date fechaActual = new Date();
		System.out.println(DateASting(fechaActual));
		*/
		/*
		//  Mostrar la cadena de la fecha que le paso
		    cargarFecha(05, 05, 1995);
			Date fecha = getDateCalendar();
			String fechaCadena = DateAString(fecha);
			System.out.println(fechaCadena);
		*/
		/*
		//Mostrar de Date a Calendar
		    Date fechaActual = new Date();
			setDateACalendar(fechaActual);//cargo fecha actual directamente al calendario
			Date fechaDelCalendar = getDateCalendar();//consigo la fecha en el calendar
			String fechaCadena = DateAString(fechaDelCalendar);//lo convierto a cadena
			System.out.println(fechaCadena);//lo muestro			
		*/
		/*
		//Mostrar dia, mes y año de la fecha que introducimos
			 cargarFecha(05, 01, 1995);
			 System.out.println("DIA= " + getDia());
			 System.out.println("MES= " + getMes());
			 System.out.println("AÑO= " + getAño());
		*/
		/*
		//Pedir al usuario que ingrese una fecha en formato cadena dd/MM/aaaa
			Scanner sc = new Scanner(System.in); 
			System.out.println("Ingrese una fecha en formato dd/MM/aaaa");
			String fechaCadena = sc.nextLine();
			Date fechaConvertida = StringADate(fechaCadena);
			//Preguntar si se ha podido convertir
			if(fechaConvertida != null) {
				System.out.println(fechaConvertida);
				System.out.println(DateAString(fechaConvertida));
			}
			else {
				System.out.println("Fecha no valida");
				
			}
		*/
		/*
		//mostrar el día de la semana que corresponde a una fecha
			cargarFecha(11,02,2004);
			// Array con los dias de la semana
			// El dia de la semana inicia en el 1 mientras que el indice del array empieza en el 0
			String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves",
					                        "Viernes","Sabado"};
			System.out.println("Ese día fué: " + strDays[getDiaSemana()]);
		*/
		/*
		//Pedir al usuario que ingrese una fecha en formato cadena dd/MM/aaaa y muestre el dia de la semana
		Scanner sc = new Scanner(System.in); 
		System.out.println("Ingrese una fecha en formato dd/MM/aaaa");
		String fechaCadena = sc.nextLine();
		Date fechaConvertida = StringADate(fechaCadena);// convertido a DATE
		String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves",
                "Viernes","Sabado"};
		    //Preguntar si se ha podido convertir
		if(fechaConvertida != null) {
			System.out.println("diaSolicitado: "+DateAString(fechaConvertida));
			setDateACalendar(fechaConvertida);// lo paso a calendario para poder obtener el indice correcto de la semana		
			System.out.println("diaSemanaFechaSolicitada: "+strDays[getDiaSemana()]);
		}
		else {
			System.out.println("Fecha no valida");
			
		}
		*/
	/*
		//mostrar el día de la semana que corresponde a una fecha y el correspondiente al año siguiente
		String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves",
                "Viernes","Sabado"};
		cargarFecha(05,05,1965);
		System.out.println("Ese día fué: " + strDays[getDiaSemana()]);
		diaAñoSiguiente(05,05,1965);
		// Array con los dias de la semana
		// El dia de la semana inicia en el 1 mientras que el indice del array empieza en el 0
		
		System.out.println("Ese día fué: " + strDays[getDiaSemana()]);
		
		*/

		//Pedir al usuario que ingrese una fecha en formato cadena dd/MM/aaaa y muestre 
		//el dia de la semana y el dia de la semana del año siguiente
		
		//Pedir al usuario que ingrese una fecha en formato cadena dd/MM/aaaa y muestre el dia de la semana
		String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves",
                "Viernes","Sabado"};
		Scanner sc = new Scanner(System.in); 
		System.out.println("Ingrese una fecha en formato dd/MM/aaaa");
		String fechaCadena = sc.nextLine();
		Date fechaConvertida = StringADate(fechaCadena);// convertido a DATE
		
		    //Preguntar si se ha podido convertir
		if(fechaConvertida != null) {
			Calendar nuevoAño;
			
			System.out.println("diaSolicitado: "+fechaCadena);
			setDateACalendar(fechaConvertida);// lo paso a calendario para poder obtener el indice correcto de la semana		
			System.out.println("diaSemanaFechaSolicitada: "+strDays[getDiaSemana()]);
			cargarFecha(getDia(), getMes(), getAño()+1);
			System.out.println("diaSemanaAnioSiguiente: "+strDays[getDiaSemana()]);
		}
		else {
			System.out.println("Fecha no valida");	
		}
			
	}

	//Metodo de String a Date
	public static Date StringADate(String fechaCadena) {
		Date fecha= null;//Para almacenar la fecha
		try {
			fecha = sdf.parse(fechaCadena);// convierte a DATE el string que le mande
		} catch (ParseException e) {
			// TODO: handle exception
			System.out.println("error en la conversion");
		}
		return fecha;
	}
	
	//Método  pasar Date a cadena
	public static String DateAString(Date fecha) {
		return sdf.format(fecha);	
	}
	
	//Metodo setter para ingresar la fecha 
	public static void cargarFecha(int dia,int mes ,int año) {
		calendar.set(año, mes-1, dia);//-1 Por que utiliza el indice desde 0=Enero
	}
	//Metodo getter para obtener el date del metodo calendar de arriba
	public static Date getDateCalendar() {
		return calendar.getTime();//Devuelve tipo Date ya armado con los valores
	}
	
	//Metodo para asignar a Calendar un tipo Date
	public static void  setDateACalendar(Date fecha) {
		calendar.setTime(fecha);
	}
	//metodos para conseguir el dia,mes y año
	public static int getDia() {
		return calendar.get(calendar.DATE);		
	}
	public static int getMes() {
		return calendar.get(calendar.MONTH)+1;		
	}
	public static int getAño() {
		return calendar.get(calendar.YEAR);		
	}
	//Metodo para obtener día de la semana
		public static int getDiaSemana() {
			return calendar.get(calendar.DAY_OF_WEEK)-1;		
	}
		/*//Metodo para obtener año sumado de la semana
		public static int getañoSumado(Date fecha) {
			
			return calendar.get(calendar.YEAR)+1;		
	}
	*/
		public static void diaAñoSiguiente(int dia,int mes ,int año) {
			calendar.set(año+1, mes-1, dia);
			}


}	
	
package tareaIGEO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class EjercicioRefinado {
	//Objeto con fecha formateada
		public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//Creo objeto de tipo calendario
		public static Calendar calendar = new GregorianCalendar();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pedir al usuario que ingrese una fecha en formato cadena dd/MM/aaaa y muestre el dia de la semana
		// y el correspondiente del a�o siguiente
		
		String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
		Scanner sc = new Scanner(System.in); 
		System.out.println("Ingrese una fecha en formato dd/MM/aaaa");
		String fechaCadena = sc.nextLine();
		
		//Recojo la fecha introducida para controlar valores negativos 
		String [] arrayFecha = fechaCadena.split("/");
		//-Paso a entero 
		int dia= Integer.parseInt(arrayFecha[0]);
		int mes = Integer.parseInt(arrayFecha[1]);
		int a�o = Integer.parseInt(arrayFecha[2]);
		//Fitro de fecha
		if(verificarFecha(dia, mes, a�o)==true) {
			Date fechaConvertida = StringADate(fechaCadena);// convertido a DATE
		    //Preguntar si se ha podido convertir
			if(fechaConvertida != null) {
				
				System.out.println("diaSolicitado: "+fechaCadena);//Fecha literal
				
				setDateACalendar(fechaConvertida);// lo paso a calendario para poder obtener el indice correcto de la semana		
				System.out.println("diaSemanaFechaSolicitada: "+strDays[getDiaSemana()]);
				
				a�oSiguiente();//calendar.set(getDia(), getMes()+1, getA�o()+1);
				System.out.println("diaSemanaAnioSiguiente: "+strDays[getDiaSemana()]);
			}
		}else {
			System.out.println("Fecha incorrecta"); }		
	}//MAin
	//Metodo de String a Date
		public static Date StringADate(String fechaCadena) {
			Date fecha= null;//Para almacenar la fecha
			try {
				fecha = sdf.parse(fechaCadena);// convierte a DATE el string del simpledateformat
			} catch (ParseException e) {
				// TODO: handle exception
				System.out.println("error en la conversion");
			}
			return fecha;
		}
		//Metodo para asignar a Calendar un tipo Date
		public static void  setDateACalendar(Date fecha) {
			calendar.setTime(fecha);
		}
		//Metodo para obtener d�a de la semana
		public static int getDiaSemana() {
			return calendar.get(calendar.DAY_OF_WEEK)-1;		
	    }

		//metodos para conseguir el dia,mes y a�o
		public static int getDia() {
			return calendar.get(calendar.DATE);		
		}
		public static int getMes() {
			return calendar.get(calendar.MONTH)+1;		
		}
		public static int getA�o() {
			return calendar.get(calendar.YEAR);		
		}
		//Cargar a�o siguiete
		public static void a�oSiguiente() {
			calendar.set(getDia(), getMes()+1, getA�o()+1);
		}
		static boolean aBisiesto(int a�o) {
			if ((a�o % 4 == 0) && (a�o % 100 != 0 || a�o % 400 == 0)) {
				return true;
				}else 
					return false;

		}
		static boolean verificarFecha(int dia,int mes,int a�o) {
			boolean v;
			int maxDias=0;
			if(a�o>0) {
				if (mes==1 || mes==3 || mes==5|| mes==7 ||mes==8|| mes==10||mes==12) {
					maxDias=31;
				}
				else if(mes == 4 ||mes==6 || mes==9 || mes==11) {
					maxDias=30;
				}else if (mes==2) {
					v=aBisiesto(a�o);
					if(v==true) {
						maxDias=29;
					}else
						maxDias=28;
				}else
					System.out.println("Mes incorrecto: El calendario gregoriano tiene 12 meses");
				if (dia>0 && dia<=maxDias) {
					return true;					
				}else {
					System.out.println("D�a incorrecto: El mes elegido es incorrecto o tiene menos d�as que los seleccionados");
				}
			}else
			System.out.println("A�o incorrecto: Le recomendamos probrar con a�os superiores a 0");
			return false;
       }
		
}



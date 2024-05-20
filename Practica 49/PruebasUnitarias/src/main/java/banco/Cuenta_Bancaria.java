package banco;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

import main.Main;

public class Cuenta_Bancaria{
	String nombre;
	String dni;
	String ccc;
	String codBancario;
	String codSucursal;
	String numCuenta;
	String digitoControl;
	Double saldo;
	
	public Cuenta_Bancaria() {
		this.crearNombre();
		this.crearDNI();
		this.crearCcc();
		this.saldo = 1500.0;
		String[] cuenta = this.ccc.split("\\s");
		this.codBancario = cuenta[0];
		this.codSucursal = cuenta[1];
		this.digitoControl = cuenta[2];
		this.numCuenta = cuenta[3];
	}
	
	public Cuenta_Bancaria(String nombre, String DNI, String ccc) {
		super();
		this.nombre = nombre;
		this.dni = DNI;
		this.ccc = ccc;
		this.saldo = 1500.0;
		String[] cuenta = this.ccc.split("\\s");
		this.codBancario = cuenta[0];
		this.codSucursal = cuenta[1];
		this.digitoControl = cuenta[2];
		this.numCuenta = cuenta[3];
	}
	
	public Cuenta_Bancaria(String nombre, String DNI, String ccc, Double saldo) {
		super();
		this.nombre = nombre;
		this.dni = DNI;
		this.ccc = ccc;
		this.saldo = saldo;
		String[] cuenta = this.ccc.split("\\s");
		this.codBancario = cuenta[0];
		this.codSucursal = cuenta[1];
		this.digitoControl = cuenta[2];
		this.numCuenta = cuenta[3];
	}
	
	public void crearNombre(){
		System.out.println("Porfavor introduzca su usuario:");
		this.nombre = Main.entrada.nextLine();
		// 20 carácteres como máximo
		Pattern patronUsuario = Pattern.compile("^.{1,20}$");
		while (!patronUsuario.matcher(this.nombre).matches()) {
			System.out.println("El DNI introducido es incorrecto");
			System.out.println("Su nombre debe tener como máximo 20 carácteres:");
			this.nombre = Main.entrada.nextLine().toUpperCase();
		}
	}
	
	public void crearDNI(){
		System.out.println("Porfavor introduzca su DNI:");
		this.dni = Main.entrada.nextLine().toUpperCase();
		Pattern patronDNI = Pattern.compile("^[0-9]{8}[A-Z]$");	
		while (!patronDNI.matcher(this.dni).matches()) {
			System.out.println("El DNI introducido es incorrecto");
			System.out.println("Deben ser ocho dígitos seguidos de una letra mayúscula, ejemplo:\n"+
            "\n12345678A\n" + "\nPorfavor vuelve a introducir tu DNI:");
			this.dni = Main.entrada.nextLine().toUpperCase();
		}
	}
	
	public void crearCcc(){
		System.out.println("Porfavor introduzca su CCC separado por espacios:");
		this.ccc = Main.entrada.nextLine();
		Pattern patronccc = Pattern.compile("^[0-9]{4}\\s[0-9]{4}\\s[0-9]{2}\\s[0-9]{10}$");
		while (!patronccc.matcher(this.ccc).matches()) {
            System.out.println("El CCC introducido es incorrecto");
            System.out.println("Deben ser cuatro dígitos de entidad, cuatro dígitos de sucursal,"+
            " dos dígitos de control y diez dígitos de número de cuenta, ejemplo:\n"+
            "\n1500 4300 00 2056100328\n" + "\nPorfavor vuelve a introducir tu ccc:");
            this.ccc = Main.entrada.nextLine();
        }	
	}
	
	public String getDigitoControl() {
		return digitoControl;
	}

	public void setDigitoControl(String digitoControl) {
		this.digitoControl = digitoControl;
	}

	public String getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public String getCodBancario() {
		return codBancario;
	}

	public void setCodBancario(String codBancario) {
		this.codBancario = codBancario;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	public Double sumarSaldo(Double dinero) {			
		try {
			if (dinero > 0) {
				this.saldo = this.saldo + dinero;
			} else {
				System.out.println("Debes utilizar un número positivo mayor que 0");
				Main.entrada.nextLine();
				System.out.println("¿Cuanto dinero quieres ingresar en la cuenta?");
				Double dinero2 = Main.entrada.nextDouble();
				this.sumarSaldo(dinero2);
			}
		} catch (InputMismatchException e) {
			System.out.println("Debes utilizar un número positivo mayor que 0, y en caso "+
			"de tener decimales tienes que usar la coma \",\" y no el punto.");
		}
		return this.saldo;
	}
	
	
	public Double restarSaldo(Double dinero) {
		try {
			Double saldop = this.saldo;
			if (dinero > 0) {
				Double dinerototal = saldop - dinero;
				if (dinerototal >= 0 ) {
					this.saldo = this.saldo - dinero;
				} else if (dinerototal < -1500) {
					System.out.println("No puedes retirar dinero si te deja por debajo de los -1500€");
				} else {
					this.saldo = this.saldo - dinero;
	                System.out.println("Tu cuenta esta en números rojos, el banco puede liquidar por "+
	                "ellos comisión de apertura e intereses, intente pagar lo antes posible.");
				}
			} else {
				System.out.println("Debes utilizar un número positivo mayor que 0");
				Main.entrada.nextLine();
				System.out.println("¿Cuanto dinero quieres retirar de la cuenta?");
				Double dinero2 = Main.entrada.nextDouble();
				this.restarSaldo(dinero2);
			}
		} catch (InputMismatchException e) {
			System.out.println("Debes utilizar un número positivo mayor que 0, y en caso "+
			"de tener decimales tienes que usar la coma \",\" y no el punto.");
			Main.entrada.nextLine();
			System.out.println("¿Cuanto dinero quieres retirar de la cuenta?");
			Double dinero2 = Main.entrada.nextDouble();
			this.restarSaldo(dinero2);
		}
		return this.saldo;
	}
}

package main;

import java.util.*;

import banco.Cuenta_Bancaria;

public class Main {
	public static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {

		//Cuenta_Bancaria nusuario = new Cuenta_Bancaria();
		Cuenta_Bancaria nusuario = new Cuenta_Bancaria("Manolo","85579922T","1500 4300 00 2056100328", 2500.00);
		Boolean consola = true;
		Double dinero;
		while (consola== true) {
            
            System.out.print("\nPresionar enter para entrar en la consola: ");
            entrada.nextLine();
            System.out.println("\t1. Mostrar el número completo de cuenta bancaria.");
            System.out.println("\t2. Mostrar el nombre del titular de la cuenta.");
            System.out.println("\t3. Mostrar el código de la entidad bancaria.");
            System.out.println("\t4. Mostrar el código de la sucursal.");
            System.out.println("\t5. Mostrar solo el número de la cuenta, excluyendo entidad, sucursal y dígitos de control.");
            System.out.println("\t6. Mostrar los dígitos de control de la cuenta.");
            System.out.println("\t7. Depositar dinero. Se solicitará ingresar la cantidad deseada mediante el teclado.");
            System.out.println("\t8. Retirar dinero. Se solicitará ingresar la cantidad que desea retirar mediante el teclado.");
            System.out.println("\t9. Consultar el saldo actual.");
            System.out.println("\t10. Cerrar la aplicación.\n");
            System.out.print("Ingrese una opción el número de la opción que deseas: ");
            try {
            	int opcion = entrada.nextInt();
            	entrada.nextLine();
            	switch (opcion) {	
            		case 1:
            			System.out.println(nusuario.getCcc());
            			break;
                    case 2:	
                    	System.out.println(nusuario.getNombre());
                    	break;
                    case 3:
                    	System.out.println(nusuario.getCodBancario());
                    	break;
                    case 4:
                    	System.out.println(nusuario.getCodSucursal());
                    	break;
                    case 5:
                    	System.out.println(nusuario.getNumCuenta());
                    	break;
                    case 6:
                    	System.out.println(nusuario.getDigitoControl());
                    	break;
                    case 7:
                    	System.out.println("¿Cuanto dinero quieres ingresar en la cuenta?");
            			dinero = entrada.nextDouble();
            			System.out.println(nusuario.sumarSaldo(dinero));
                    	break;
                    case 8:
                    	System.out.println("¿Cuanto dinero quieres retirar de la cuenta?");
            			dinero = entrada.nextDouble();
                    	System.out.println(nusuario.restarSaldo(dinero));
                    	break;
                    case 9:
                    	System.out.println(nusuario.getSaldo());
                    	break;
                    case 10:
                    	consola = false;
                    	entrada.close();
                    	break;
            	}
            } catch (InputMismatchException e) {
            	System.out.println("Debes utilizar un número entero de entre las opciones disponibles.");
            }
		}
	}
}
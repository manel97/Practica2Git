/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucom_royale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Uri
 */
public class EnterData {
    
    public static double pedirDouble(String msj){
		 BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		 double answer=0;
		 boolean error;
		 do{
			 try{
				 System.out.println(msj);
				 answer=Double.parseDouble(br.readLine());
				 error=false;
			 }catch(IOException ex){
				 System.out.println("Error");
				 error=true;
			 }catch(NumberFormatException ex){
				 System.out.println("Introduce un numero decimal");
				 error=true;
			 }
		 }while(error);
		 return answer;
	 }
	 public static String pedirCadena(String msj){
		 BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		 String answer="";
		 boolean error;
		 do{
			 try{
			 System.out.println(msj);
			 answer=br.readLine();
			 error=false;
			 }catch(IOException ex){
				 System.out.println("Error");
				 error=true;
			 }
		 }while(error);
		 return answer;
	 }
	 public static int pedirEntero(String msj){
		 BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		 System.out.println(msj);
		 int number=0;
		 boolean error=false;
		 do{
			try {
				number = Integer.parseInt(br.readLine());
			} 
			catch (IOException ex) {
				System.out.println("Error");
			} 
			catch (NumberFormatException ex){ 
				System.out.println("Inroduce un numero entero");
			}
		 }while(error);
		 return number;
	 }
}

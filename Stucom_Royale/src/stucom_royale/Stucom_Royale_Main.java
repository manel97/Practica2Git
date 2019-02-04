/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucom_royale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Uri and Alvaro
 */
public class Stucom_Royale_Main {
  
	System.out.println("Cambios");
System.out.println("dasdasda");

    public static List<Player> player = new ArrayList<>();
    public static List<Cards> cards = new ArrayList<>();
    
    public static void main(String[] args) { 
        //Jugadores añadidos
        player.add(new Player ("Uri", "a",20));
        player.add(new Player ("Alvaro", "a",40));
        player.add(new Player ("Ferransito", "a",50));
        player.add(new Player ("Profe", "a",10));
        
        //Cartas de tropas añadidas
        cards.add(new Troops (15, "Montapuercas",  2, 40));
        cards.add(new Troops (10, "Valkyria", 3, 50));
        cards.add(new Troops (20, "Pekka", 5, 80));
        
        //Cartas de estructura añadidas
        cards.add(new Structure (40, "Choza de Barbaros", 3, 40));
        cards.add(new Structure (30, "Sacafuego", 2, 70));
        cards.add(new Structure (50, "Murallote", 3, 45));

        //Cartas de hechizos añadidas
        cards.add(new Spells (5, "Ata/Def" , "Tronquito", 2, 20));
        cards.add(new Spells (5, "Ata/Def", "Zap", 1, 15));
        cards.add(new Spells (7, "Ata/Def","Veneno", 2, 10));
        
        
            
        int opcion = 0;
		do{
                    menu();
                    opcion= EnterData.pedirEntero("Escoge una opción");
                    switch(opcion){
			case 1:
                            obtainCards();
			break;
			case 2:
                            battle();
			break;
			case 3:
                            ranking();
			break;
                        case 4:
                            System.out.println("Fin");
			break;
			default: System.out.println("");
                    }
		}while(opcion!=4);
    }
    public static void menu(){
        System.out.println("--- Menú ---");
        System.out.println("[1] - Obtener cartas");
        System.out.println("[2] - Batalla");
        System.out.println("[3] - Ranking");
        System.out.println("[4] - Salir");
    }
    public static String pedirCadenaNoVacia(String msg){
        String cadena;
	do{
            cadena=EnterData.pedirCadena(msg);
            if(cadena.equals("")){
                System.out.println("No se puede dejar un espacio en blanco");
            }
	}while(cadena.equals(""));
	return cadena;
    }
    //Metodo para validar usuarios
    public static Player validar(){
        String user = pedirCadenaNoVacia("Introduce el usuario:");
        String pass = pedirCadenaNoVacia("Introduce la contraseña:");
        Player validar = null;
        
        for(Player j : player){
            if(j.getUser().equalsIgnoreCase(user) && j.getPass().equalsIgnoreCase(pass)){
               validar = j;
            }
        }
        System.out.println("\n Usuario logueado correctamente \n");
        return validar;
    }
    //Metodo para que el jugador obtenga cartas
    public static void obtainCards(){
        
        Player p = validar();
        boolean salir = false;
        
        if(p == null){
            System.out.println("El usuario o la contraseña no son validos");
        } else {
            if(p.getGroupCards().size()<6){
                while(!salir){
                    mostrarCartas(cards);
                    String nameCard = pedirCadenaNoVacia("Introduce el nombre de la carta que quieres incluir en tus cartas:");

                    boolean comprobarExisteCarta = comprobarCarta(cards, nameCard);
                    boolean comprobarCarta = comprobarCarta(p.getGroupCards(), nameCard);
                    if(!comprobarCarta && comprobarExisteCarta){
                
                    Cards c = obtenerCarta(nameCard);
                    p.getGroupCards().add(c);
                    System.out.println("Carta añadida con exito.");
                    salir = true;
                }
                    else { 
                    System.out.println("Ya tienes está carta o no existe");
                }
            }
            }
            else{ 
               System.out.print("Ya tienes el máximo de cartas. \n");
               System.out.println("Tus cartas son : \n");
               System.out.print(p.getGroupCards());
            }
        }
    }
    public static Cards obtenerCarta(String carta2){
            for(Cards c : cards){
                if (c.getName().equalsIgnoreCase(carta2) ){
                return c;
                }
            }
        return null;
    }
    //Metodo para comprobar si una carta existe dentro de un array
    public static boolean comprobarCarta(List<Cards> lista, String carta2){
        
        boolean laTiene=false;
        for(Cards carta1 : lista){
            if(carta1.getName().equalsIgnoreCase(carta2)){
               return true;
            }
        }
        return laTiene;
    }
    //Metodo para mostrar todas las cartas
    public static void mostrarCartas(List<Cards> cartas){
        cartas.forEach((c) -> {
            System.out.println(c);
        });
    }
    //Metodo para la batalla
    public static void battle(){
       
        List<Cards> cartasJ1 = new ArrayList<>();
        List<Cards> cartasJ2 = new ArrayList<>();
       
        Player j1 = validar();
        Player j2 = validar();
        
        if(j1 == j2){
            System.out.println("Error, no puedes luchar contra ti mismo");
        } else {
           
            if((comprobarCosteElixir(j1.getGroupCards()) && j1.getGroupCards().size()==3) 
                    || (comprobarCosteElixir(j2.getGroupCards()) && j2.getGroupCards().size()==3) 
                    || j1.getGroupCards().size()<3 || j2.getGroupCards().size()<3){
                System.out.println("Error.");
            } else {
                
                cartasJ1 = (List<Cards>) elegirCartas(j1, j1.getGroupCards());
                cartasJ2 = (List<Cards>) elegirCartas(j2, j2.getGroupCards());
               
                if(cartasJ1.size()>0 && cartasJ2.size()>0){
                    System.out.println("Cartas para la batalla de "+j1.getUser()+":");
                    System.out.println(cartasJ1);
                    System.out.println("Cartas para la batalla de "+j2.getUser()+":");
                    System.out.println(cartasJ2);
                   
                    accionCartas(cartasJ1, cartasJ2, j1.getUser(), j2.getUser());
                   
                    ganador(cartasJ1, cartasJ2, j1, j2);
                }
            }
        }
    }
    public static void accionCartas(List<Cards> cartas1, List<Cards> cartas2, String nombre1, String nombre2){
       
        int random = (int)(Math.random()*2);
        if(random == 0){
            System.out.println("Comienza "+nombre1);
            ataca(cartas1, cartas2);
            ataca(cartas2, cartas1);
        }else{
            System.out.println("Comienza "+nombre2);
            ataca(cartas2, cartas1);
            ataca(cartas1, cartas2);
        }  
    }
    
    //Metodo para atacar
    public static void ataca(List<Cards> cartas1, List<Cards> cartas2){
     
        for (int i=0; i<3; i++){
            
            if (cartas1.get(i).getClass()== Troops.class){
                 
            Troops cartaT = (Troops) cartas1.get(i);
            int damage = cartaT.actionCard();
            damage = cartas2.get(i).getLvlLife()- damage;
            cartas2.get(i).setLvlLife(damage);
            } 
            else if(cartas1.get(i).getClass()== Spells.class){
               Spells cartaH = (Spells) cartas1.get(i);

               if(cartaH.getMode().equals("ataque")){
                   cartas2.get(0).setLvlLife(cartas2.get(0).getLvlLife()- cartaH.actionCard());
                   cartas2.get(1).setLvlLife(cartas2.get(1).getLvlLife() - cartaH.actionCard());
                   cartas2.get(2).setLvlLife(cartas2.get(2).getLvlLife() - cartaH.actionCard());
                }else{
                   cartas1.get(0).setLvlLife(cartas1.get(0).getLvlLife() + cartaH.actionCard());
                   cartas1.get(1).setLvlLife(cartas1.get(1).getLvlLife() + cartaH.actionCard());
                   cartas1.get(2).setLvlLife(cartas1.get(2).getLvlLife() + cartaH.actionCard());
                }
            } 
            //Error, no se pueden tener mas de dos estructuras
            else if(cartas1.get(i).getClass()== Structure.class) {  
               Structure cartaE = (Structure) cartas1.get(i);
               cartas1.get(i).setLvlLife(cartaE.getLvlLife()+ cartaE.actionCard());
            }
        }
    }
    public static void ganador(List<Cards> cartas1, List<Cards> cartas2, Player j1, Player j2){
        int vidaJ1 = 0;
        int vidaJ2 = 0;
     
        for(int i = 0; i<3; i++){
            vidaJ1 += cartas1.get(i).getLvlLife();
            vidaJ2 += cartas2.get(i).getLvlLife();
        }
    
        if(vidaJ1>vidaJ2){
            j1.setTrophies(j1.getTrophies()+5);
            j2.setTrophies(j2.getTrophies()+1);
            System.out.println(j1.getUser()+" has ganado con una vida de "+vidaJ1+" a "+j2.getUser()+" con una vida de "+vidaJ2);
        }else if(vidaJ2>vidaJ1){
            j2.setTrophies(j2.getTrophies()+5);
            j1.setTrophies(j1.getTrophies()+1);
            System.out.println(j2.getUser()+" has ganado con una vida de "+vidaJ2+" a "+j1.getUser()+" con una vida de "+vidaJ1);
        }else{
            System.out.println(j1.getUser()+" has empatado a "+j2.getUser()+" con una vida de "+vidaJ1);
        }
    }
    public static boolean comprobarCosteElixir(List<Cards> cartasJugador, Cards cardd){
     
        int elixir  = cardd.getCostElixir();
        elixir = cartasJugador.stream().map((card) -> card.getCostElixir()).reduce(elixir, Integer::sum);
        return elixir>10;
    }
    public static boolean comprobarCosteElixir(List<Cards> cartasJugador){
     
        int elixir=0;
        elixir = cartasJugador.stream().map((card) -> card.getCostElixir()).reduce(elixir, Integer::sum);
        return elixir>10;
    }
    public static List<Cards> elegirCartas(Player j, List<Cards> cartasJ){
        
        List<Cards> cartaCopias = new ArrayList<>();
        int contador = 1;
        System.out.println(j.getUser()+" elige 3 cartas:");
        while(contador<4){
           boolean salir=false;
           do{ 
            System.out.println(j.getGroupCards());
           
            String nombre = pedirCadenaNoVacia("Selecciona el nombre de la "+contador+" carta que quieres elegir:");
           
            boolean comprobarQueLaCartaEsteEnSuLista = comprobarCarta(j.getGroupCards(), nombre);
          
            boolean comprobarSiYaLaHaSeleccionado = comprobarCarta(cartaCopias, nombre);
            
            if(comprobarQueLaCartaEsteEnSuLista && !comprobarSiYaLaHaSeleccionado){
               
                Cards cardd = obtenerCarta(nombre);
               
                boolean elixir = comprobarCosteElixir(cartaCopias, cardd);
                if(!elixir){
                    try{
                    //clono la carta
                    Cards copia = (Cards) cardd.clone();
                    cartaCopias.add(copia);
                    contador++;
                    salir=true;
                    } catch (CloneNotSupportedException ex) {  
                    } 
                }else{
                    System.out.println("Superas el coste de elixir, el máximo es 10.");
                }
            }else{
                System.out.println("La carta seleccionada no está en tu mazo, no existe o ya la has seleccionado.");
            }
           }while(!salir);
        }
        
        return cartaCopias;
    }
    public static void ranking(){
        int num = 1;
       
        Collections.sort(player);
        System.out.println("<~~ Ranking ~~>");
        for(Player j: player){
                System.out.println("");
                System.out.println(num+". "+ j.getUser()+", trofeos: "+j.getTrophies());
                num++;
        }
        System.out.println("\n");
    }
}

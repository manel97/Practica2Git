/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucom_royale;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Uri and Alvaro
 */
public class Player implements Comparable<Player>{

    /*
    User: Para identificar al usuario
    Pass: Para la contraseña del usuario
    Trophies: Para saber los trofeos del usuario
    */
    private String user;
    private String pass;
    private int trophies = 0;

    private List<Cards> groupCards = new ArrayList<>();
    
    public Player(String user, String pass, int trophies) {
        this.user = user;
        this.pass = pass;
        this.trophies = trophies;
        
    } 
    public Player(String user, String pass, int trophies, ArrayList<Cards> groupCards) {
        this(user, pass, trophies);
        this.groupCards = groupCards;
    }
    public List<Cards> getGroupCards() {
        return groupCards;
    }
    public void setGrupoCartas(List<Cards> grupoCartas) {
        this.groupCards = grupoCartas;
    }
    public int getTrophies() {
        return trophies; 
    }
    public void setTrophies(int trophies) {
        this.trophies = trophies; 
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int compareTo(Player o) {
       if (trophies > o.getTrophies()) {
           return -1;
       } else if (trophies < o.getTrophies()) {
           return 1;
       } else {
           return 0;
       }
    }
    @Override
    public String toString() {
        return "Player{" + "user=" + user + ", trophies=" + trophies + ", groupCards=" + groupCards + '}';
    }
}

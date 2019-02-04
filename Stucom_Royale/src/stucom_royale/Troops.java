/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucom_royale;

/**
 *
 * @author Uri and Alvaro
 */
public class Troops extends Cards {
    
    private int lvlAtk;

    public Troops (int lvlAtk, String name, int costElixir, int lvlLife) {
        super (name, costElixir, lvlLife);
        this.lvlAtk = lvlAtk;
    }
    public int getLvlAtk() {return lvlAtk;}
    public void setLvlAtk(int lvlAtk) {this.lvlAtk = lvlAtk;}
    
    @Override public int actionCard() {
       return lvlAtk/2;
    }
    @Override
    public String toString() {
        return "Troop{" + "name=" + this.getName() + ", costElixir=" + this.getCostElixir() + ", lvlLife=" + this.getLvlLife()  + ", lvlAtk=" + lvlAtk + '}'+"\n";
    }   
}

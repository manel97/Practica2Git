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

public class Spells extends Cards {
    private int lvlScope;
    
    private String mode;
    public Spells (int lvlScope, String mode, String name, int costElixir, int lvlLife) {
        super (name, costElixir, lvlLife);
        this.lvlScope = lvlScope;
        this.mode = mode;
    }
    public int getLvlScope() {return lvlScope;}
    public void setLvlScope(int lvlScope) {this.lvlScope = lvlScope;}
    public String getMode() {return mode;}
    public void setMode(String mode) {this.mode = mode;}
    
    @Override public int actionCard() {
        return (lvlScope*2)/3;
    }
  
     @Override
    public String toString() {
        return "Spells{" + "name=" + this.getName()+ ", costElixir=" + this.getCostElixir()+ ", lvlLife=" + this.getLvlLife()+ ", lvlScope=" + lvlScope + ", mode=" + mode + '}'+"\n";
    }
}

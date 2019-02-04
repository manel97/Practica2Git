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
public class Structure extends Cards{
        private int lvlDef;
        
        public Structure (int lvlDef, String name, int costElixir, int lvlLife) {
        super (name, costElixir, lvlLife);
        this.lvlDef = lvlDef;
    }
    public int getLvlDef() {return lvlDef;}
    public void setLvlDef(int lvlDef) {this.lvlDef = lvlDef;}
    
    @Override public int actionCard() {
        return lvlDef+8;
    }

    @Override
    public String toString() {
        return "Structure{" + "name=" + this.getName() + ", costElixir=" + this.getCostElixir() + ", lvlLife=" + this.getLvlLife()  + ", lvlDef=" + lvlDef + '}'+"\n";
    }

}

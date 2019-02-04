/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucom_royale;

/**
 *
 * @author Uri
 */
public abstract class Cards implements Cloneable{
    
    private String name;
    private int costElixir;
    private int lvlLife;
   
    public Cards(String name, int costElixir, int lvlLife) {
        this.name = name;
        this.costElixir = costElixir;
        this.lvlLife = lvlLife;
    }

    public int getLvlLife() {
        return lvlLife;
    }
    public void setLvlLife(int lvlLife) {
        this.lvlLife = lvlLife;
    }
    public int getCostElixir() {
        return costElixir;
    }
    public void setCostElixir(int costElixir) {
        this.costElixir = costElixir;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract int actionCard();
    @Override
    public String toString() {
        return "Cards{" + "name=" + name + ", costElixir=" + costElixir + ", lvlLife=" + lvlLife + '}';
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

  
}

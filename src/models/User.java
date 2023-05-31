package models;

public class User {
    private int lifes = 5;
  

    public int getLifes() {
        return lifes;
    }

    public void reduceLife() {
        this.lifes--;
    }


}

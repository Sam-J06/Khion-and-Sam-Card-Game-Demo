package cards;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import main.GamePanel;

public class Card {
    public int x;
    public int y;
    public int pattern;
    GamePanel gp = new GamePanel();
    KeyHandler keyH;

    public void card(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;
        setValue();
    }

    public void setValue() {
        x = gp.w / 2;
        y = gp.h / 2;
    }

    public void getCardImage() {
        try {
            


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        
    }
}

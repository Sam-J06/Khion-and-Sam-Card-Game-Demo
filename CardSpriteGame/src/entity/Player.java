package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import main.GamePanel;
import main.KeyHandler;

/**
 * All player information and methods.
 */
public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    public int x;
    public int y;

    /**
     * Constructor.
     */
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    /**
     * sets default values.
     */
    public void setDefaultValues() {
        x = 10;
        y = 10;
        speed = gp.w / 100;
        drawDirection = 0;
    }

    /**
     * imports sprites from resource file.
     */
    public void getPlayerImage() {
        
        try {

            for (int i = 2; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    sprite[i][j] = ImageIO.read(getClass().getResourceAsStream("/res/king_s/king_"
                    + i + "_" + j + ".png"));
                    System.out.println("balls");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates direction, speed, and player sprite. Gets called in GamePanel class.
     */
    public void update() {

        spriteCounter++;
        if (spriteCounter > 10) {
            spriteNum++;
            if (spriteNum == 4) {
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            if (keyH.upPressed) {
                moveDirection = 0;
            } else if (keyH.downPressed) {
                moveDirection = 1;
            } else if (keyH.leftPressed) {
                moveDirection = 2;
                drawDirection = 2;
            } else if (keyH.rightPressed) {
                moveDirection = 3;
                drawDirection = 3;
                
            }

            if (!collisionOn) {
                switch (moveDirection) {
                    case 0: y -= speed;
                        break;
                    case 1: y += speed;
                        break;
                    case 2: x -= speed;
                        break;
                    case 3: x += speed;
                        break;
                    default:
                        break;
                }
            }

            //add animation here.
            
        }
    }

    /**
     * Draws elements.
     */
    public void draw(Graphics2D g2) {
        
        BufferedImage image = null;


        image = sprite[(drawDirection % 2) + 2][spriteNum];

       
        g2.drawImage(image, x, y, 27 * gp.scale, 55 * gp.scale, null);
    }
    
}

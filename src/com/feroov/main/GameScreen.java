package com.feroov.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel
{
    private Random random;
    private BufferedImage img;

    private Dimension size;

    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    public GameScreen(BufferedImage img)
    {
        this.img = img;

        setPanelSize();
        loadSprites();
        random = new Random();


    }

    private void setPanelSize()
    {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    private void loadSprites()
    {
        for(int y = 0; y < 10; y++)
        {
            for(int x = 0; x < 10; x++)
            {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(sprites.get(19), 345, 600, null);

        for (int y = 0; y < 20; y++)
        {
            for (int x = 0; x < 20; x++)
            {
                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
            }
        }
    }

    private int getRndInt()
    {
        return random.nextInt(100);
    }

    private Color getRndColor()
    {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }
}

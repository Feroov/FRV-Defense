package com.feroov.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame implements Runnable
{
    private GameScreen gameScreen;
    private BufferedImage img;
    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    public Game()
    {
        importImg();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gameScreen = new GameScreen(img);
        add(gameScreen);
        pack();

        setVisible(true);
    }

    private void importImg()
    {
        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try { img = ImageIO.read(is); }
        catch(IOException e) { e.printStackTrace(); }
    }

    private void start()
    {
        gameThread = new Thread(this) {};
        gameThread.start();
    }

    private void updateGame() {}

    public static void main(String[] args)
    {
        System.out.println("\n\n&&&&&&&&&&& System logging stuff... &&&&&&&&&&&");
        System.out.println("\n\nStarting the game...");
        Game game = new Game();
        game.start();
    }

    @Override
    public void run()
    {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while(true)
        {
            now = System.nanoTime();
            // Render
            if (now - lastFrame >= timePerFrame)
            {
                repaint();
                lastFrame = now;
                frames++;
            }
            // Updates
            if(now - lastUpdate >= timePerUpdate)
            {
                updateGame();
                lastUpdate = now;
                updates++;
            }

            if(System.currentTimeMillis() - lastTimeCheck >= 1000)
            {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}

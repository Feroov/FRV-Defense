package com.feroov.main;

import com.feroov.scenes.Menu;
import com.feroov.scenes.Playing;
import com.feroov.scenes.Settings;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;

public class Game extends JFrame implements Runnable
{
    private GameScreen gameScreen;
    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    ImageIcon icon;

    // Classes
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    public Game()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initClasses();

        add(gameScreen);
        pack();

        icon = new ImageIcon("res/frvlogo.png");
        setIconImage(icon.getImage());
        setVisible(true);
    }

    private void initClasses()
    {
        render = new Render(this);
        gameScreen = new GameScreen(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
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
        game.gameScreen.initInputs();
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

    /*** Getters & Setters ***/
    public Render getRender() {return render;}

    public Menu getMenu() {return menu;}
    public Playing getPlaying() {return playing;}
    public Settings getSettings() {return settings;}
}

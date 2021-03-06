package com.feroov.scenes;

import com.feroov.helpmethods.LoadSave;
import com.feroov.main.Game;
import com.feroov.ui.Buttons;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import static com.feroov.main.GameStates.*;

public class Menu extends GameScene implements SceneMethods
{
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    private Buttons bPlaying, bSettings, bQuit;

    public BufferedImage mainMenu;

    public Menu(Game game)
    {
        super(game);
        importImg();
        loadSprites();
        initButtons();
    }

    private void initButtons()
    {
        int w = 150;
        int h = w / 3;
        int x = 640 / 2 - w / 2;
        int y = 330;
        int yOffset = 100;

        bPlaying = new Buttons("Play", x, y, w, h);
        bSettings = new Buttons("Settings", x, y + yOffset, w, h);
        bQuit = new Buttons("Quit", x, y + yOffset * 2, w, h);
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(LoadSave.importImg(),0,0,null);
        drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y)
    {
        if (bPlaying.getBounds().contains(x, y))
        {
            SetGameState(PLAYING);
        }
        else if (bSettings.getBounds().contains(x, y))
        {
            SetGameState(SETTINGS);
        }
        else if (bQuit.getBounds().contains(x, y))
            System.exit(0);
    }

    @Override
    public void mouseMoved(int x, int y)
    {
        bPlaying.setMouseOver(false);
        bSettings.setMouseOver(false);
        bQuit.setMouseOver(false);

        if (bPlaying.getBounds().contains(x, y))
        {
            bPlaying.setMouseOver(true);
        }
        else if (bSettings.getBounds().contains(x, y))
        {
            bSettings.setMouseOver(true);
        }
        else if (bQuit.getBounds().contains(x, y))
        {
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y)
    {
        if (bPlaying.getBounds().contains(x, y))
        {
            bPlaying.setMousePressed(true);
        }
        else if (bSettings.getBounds().contains(x, y))
        {
            bSettings.setMousePressed(true);
        }
        else if (bQuit.getBounds().contains(x, y))
        {
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y)
    {
        resetButtons();
    }

    @Override
    public void mouseDragged(int x, int y) {}

    private void resetButtons()
    {
        bPlaying.resetBooleans();
        bSettings.resetBooleans();
        bQuit.resetBooleans();
    }

    private void drawButtons(Graphics g)
    {
        bPlaying.draw(g);
        bSettings.draw(g);
        bQuit.draw(g);
    }

    private void importImg()
    {
        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try { img = ImageIO.read(is); }
        catch(IOException e) { e.printStackTrace(); }
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
}

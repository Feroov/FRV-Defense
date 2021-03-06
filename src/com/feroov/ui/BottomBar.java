package com.feroov.ui;

import com.feroov.objects.Tile;
import com.feroov.scenes.Playing;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static com.feroov.main.GameStates.*;


public class BottomBar
{
    private int x, y, width, height;
    private Buttons bMenu;
    private Playing playing;

    private Tile selectedTile;

    private ArrayList<Buttons> tileButtons = new ArrayList<>();

    public BottomBar(int x, int y, int width, int height, Playing playing)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;
        initButtons();
    }

    private void initButtons()
    {
        bMenu = new Buttons("Menu", 10, 652, 100, 30);

        int w = 50;
        int h = 50;
        int xStart = 120;
        int yStart = 650;
        int xOffset = (int)(w * 1.1f);

        int i = 0;
        for(Tile tile : playing.getTileManager().tiles)
        {
            tileButtons.add(new Buttons(tile.getName(), xStart + xOffset * i, yStart, w, h, i));
            i++;
        }
    }

    private void drawButtons(Graphics g)
    {
        bMenu.draw(g);
        drawTileButtons(g);
        drawSelectedTile(g);
    }

    private void drawSelectedTile(Graphics g)
    {
        if(selectedTile != null)
        {
            g.drawImage(selectedTile.getSprite(), 550, 650, 50, 50, null);
            g.setColor(Color.BLACK);
            g.drawRect(550, 650, 50, 50);
        }
    }

    private void drawTileButtons(Graphics g)
    {
        for(Buttons b : tileButtons)
        {
            // Sprite
            g.drawImage(getButtonImg(b.getId()), b.x, b.y, b.width, b.height, null);

            // MouseOver
            if(b.isMouseOver())
                g.setColor(Color.WHITE);
             else  g.setColor(Color.BLACK);

            // Border
            g.drawRect(b.x, b.y, b.width, b.height);

            // MousePressed
            if(b.isMousePressed())
            {
                g.drawRect(b.x + 1, b.y + 1, b.width - 2, b.height - 2);
                g.drawRect(b.x + 2, b.y + 2, b.width - 4, b.height - 4);
            }
        }
    }

    public BufferedImage getButtonImg(int id)
    {
       return playing.getTileManager().getSprite(id);
    }

    public void draw(Graphics g)
    {
        // Background
        g.setColor(new Color(93,93,93));
        g.fillRect(x, y, width, height);

        // Buttons
        drawButtons(g);
    }

    public void mouseClicked(int x, int y)
    {
        if (bMenu.getBounds().contains(x, y))
            SetGameState(MENU);
        else
        {
            for(Buttons b : tileButtons)
            {
                if(b.getBounds().contains(x, y))
                {
                    selectedTile = playing.getTileManager().getTile(b.getId());
                    playing.setSelectedTile(selectedTile);
                    return;
                }
            }
        }
    }

    public void mouseMoved(int x, int y)
    {
        bMenu.setMouseOver(false);
        for(Buttons b : tileButtons)
            b.setMouseOver(false);

        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);
        else
        {
            for(Buttons b : tileButtons)
            {
                if(b.getBounds().contains(x, y))
                {
                    b.setMouseOver(true);
                    return;
                }
            }
        }
    }

    public void mousePressed(int x, int y)
    {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);
        else
        {
            for(Buttons b : tileButtons)
            {
                if (b.getBounds().contains(x, y))
                {
                    b.setMousePressed(true);
                    return;
                }
            }
        }
    }

    public void mouseReleased(int x, int y)
    {
        bMenu.resetBooleans();

        for(Buttons b : tileButtons)
            b.resetBooleans();
    }
}

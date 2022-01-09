package com.feroov.scenes;

import com.feroov.main.Game;
import com.feroov.ui.Buttons;
import java.awt.*;
import static com.feroov.main.GameStates.*;


public class Settings extends GameScene implements SceneMethods
{

    private Buttons bMenu;

    public Settings(Game game)
    {
        super(game);
        initButtons();
    }

    private void initButtons()
    {
        bMenu = new Buttons("Menu", 2, 2, 100, 30);
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,640,640);

        drawButtons(g);
    }

    private void drawButtons(Graphics g)
    {
        bMenu.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y)
    {
        if (bMenu.getBounds().contains(x, y))
            SetGameState(MENU);
    }

    @Override
    public void mouseMoved(int x, int y)
    {
        bMenu.setMouseOver(false);
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);
    }

    @Override
    public void mousePressed(int x, int y)
    {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);
    }

    @Override
    public void mouseReleased(int x, int y)
    {
        resetButtons();
    }

    @Override
    public void mouseDragged(int x, int y) {}

    private void resetButtons() { bMenu.resetBooleans(); }
}

package com.feroov.main;

import com.feroov.main.inputs.KeyboardListener;
import com.feroov.main.inputs.MouseListener;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel
{
    private Dimension size;
    private Game game;

    private MouseListener mouseListener;
    private KeyboardListener keyboardListener;

    public GameScreen(Game game)
    {
        this.game = game;
        setPanelSize();
    }

    public void initInputs()
    {
        mouseListener = new MouseListener(game);
        keyboardListener = new KeyboardListener();

        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        addKeyListener(keyboardListener);

        requestFocus();
    }

    private void setPanelSize()
    {
        size = new Dimension(640, 740);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        game.getRender().render(g);
    }
}

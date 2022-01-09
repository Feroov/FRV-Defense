package com.feroov.ui;

import java.awt.*;

public class Buttons
{
    private int x, y, width, height;
    private String text;
    private Rectangle bounds;
    private boolean mouseOver, mousePressed;

    public Buttons(String text, int x, int y, int width, int height)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBounds();
    }

    private void initBounds()
    {
        this.bounds = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g)
    {
        // Body
        drawBody(g);
        // Border
        drawBorder(g);
        // Text
        drawText(g);

    }

    private void drawBorder(Graphics g)
    {
        g.setFont(new Font("serif", Font.ROMAN_BASELINE, 19));
        if(mousePressed)
        {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);
            g.drawRect(x + 1, y + 1, width - 2, height - 2);
            g.drawRect(x + 2, y + 2, width - 4, height - 4);
        }
        else { g.setColor(Color.BLACK);g.drawRect(x, y, width, height); }
    }

    private void drawBody(Graphics g)
    {
        if(mouseOver)
            g.setColor(Color.GRAY);
        else
            g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    private void drawText(Graphics g)
    {
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(text, x - w / 2 + width / 2 , y + h / 3 + height / 2);
    }

    public void resetBooleans()
    {
        this.mouseOver = false;
        this.mousePressed = false;
    }

    public void setMousePressed(boolean mousePressed)
    {
        this.mousePressed = mousePressed;
    }

    public void setMouseOver(boolean mouseOver)
    {
        this.mouseOver = mouseOver;
    }

    public Rectangle getBounds()
    {
        return bounds;
    }
}
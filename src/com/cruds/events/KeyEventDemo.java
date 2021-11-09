package com.cruds.events;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventDemo extends Applet implements KeyListener {
	String msg = "";
	
	@Override
	public void init() {
		addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString(msg, 10, 10);
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		showStatus("key released");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		showStatus("key pressed");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		msg = msg + e.getKeyChar();
		repaint();
		
	}
	
	

}

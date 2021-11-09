package com.cruds.events;

import java.applet.Applet;
import java.awt.event.MouseAdapter;

import org.w3c.dom.events.MouseEvent;

public class MouseAdaptedDemo extends Applet {
	
	@Override
	public void init() {
		addMouseListener(new MyMouseAdapter(this));
		//super.init();
	}

}

class MyMouseAdapter extends MouseAdapter
{
	Applet app;
	
	public MyMouseAdapter(Applet app) {
		this.app = app;
	
	}
	 @Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
	 app.showStatus("***Mouse Clicked***");
		//super.mouseClicked(e);
	}

}

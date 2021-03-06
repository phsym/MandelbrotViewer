/*
* MandelBrotViewer
* Copyright (C) 2012 Pierre-Henri Symoneaux
* 
* This work is licensed under the Creative Commons 
* Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0)
* 
* To view a copy of this license,
* visit http://creativecommons.org/licenses/by-sa/3.0/legalcode .
*/

package phsym.mandelbrot;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
*	@author Pierre-Henri Symoneaux
*/
public class MainFrame extends JFrame implements WindowListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FractalCanvas canvas;
	private static JFrame f = null;

	public MainFrame(String name) throws HeadlessException {
		super(name);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		canvas = new FractalCanvas(this);
		add(canvas);
	}
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		canvas.setSize(width, height);
	}
	
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b)
		{
			new Thread(canvas).start();
		}
		else
			canvas.stop();
	}
	
	public static void main(String[] args) {
		// Get the native look and feel class name
		String nativeLF = UIManager.getSystemLookAndFeelClassName();

		// Install the look and feel
		try {
		    UIManager.setLookAndFeel(nativeLF);
		} catch (Exception e) {
			System.err.println("Could not set native look and feel");
		}
		
		f = new MainFrame("Mandelbrot");
		f.setSize(1600, (int)((2d/3.5d)*1600d));
		f.setVisible(true);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(JOptionPane.showConfirmDialog(this, "Are you sure ?", "Quit ?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		{
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	
	
	/* UNUSED IMPLEMENTED METHODS */
	
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}
}

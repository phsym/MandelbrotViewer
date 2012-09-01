package phsym.mandelbrot.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import phsym.mandelbrot.FractalCanvas;
import phsym.mandelbrot.dialogs.OptionDialog;

public class PopMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5824583909243693974L;
	
//	private FractalCanvas canvas;
	
	private OptionDialog options;

	public PopMenu(final FractalCanvas canvas) {
		super("Popup Menu");
		
//		this.canvas = canvas;
		options = new OptionDialog(canvas);
		
		JMenuItem itm = new JMenuItem("Settings");
		itm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				options.setVisible(true);
			}
		});
		
		add(itm);
		
		itm = new JMenuItem("Screenshot");
		itm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				canvas.takeScreenShot();
			}
		});
		add(itm);
	}

}

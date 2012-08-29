import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
*	@author Pierre-Henri Symoneaux
*/
public class MainFrame extends Frame implements WindowListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MyCanvas canvas;
	private static Frame f = null;

	public MainFrame(String name) throws HeadlessException {
		super(name);
		canvas = new MyCanvas();
		add(canvas);
	}
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		canvas.setSize(width, height);
		addWindowListener(this);
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
		f = new MainFrame("Mandelbrot");
		f.setSize(1600, (int)((2d/3.5d)*1600d));
		f.setVisible(true);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false);
		dispose();
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

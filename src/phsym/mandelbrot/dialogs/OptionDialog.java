package phsym.mandelbrot.dialogs;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import phsym.mandelbrot.FractalCanvas;

public class OptionDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3775821772884902700L;
	
	private FractalCanvas canvas;
	
	private GridLayout layout;
	
	private JTextField iterations;
	
	private JButton b_cancel;
	private JButton b_OK;

	public OptionDialog(final FractalCanvas canvas) {
		super(canvas.getFrame(), "Settings", true);
		this.canvas = canvas;
		
		setLocationRelativeTo(canvas);
		
		layout = new GridLayout(2, 2);
		
		setLayout(layout);
		add(new JLabel("Iterations : "));
		iterations = new JTextField(Integer.toString(canvas.getMax_iteration()));
		
		add(iterations);
		
		b_cancel = new JButton("Cancel");
		b_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		add(b_cancel);
		
		b_OK = new JButton("OK");
		b_OK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setMax_iteration(Integer.parseInt(iterations.getText()));
				setVisible(false);
			}
		});
		add(b_OK);
		
		pack();
		validate();
	}
	
	@Override
	public void setVisible(boolean b) {
		if(b)
		{
			iterations.setText(Integer.toString(canvas.getMax_iteration()));
		}
		super.setVisible(b);
	}
}

import java.awt.Color;

/**
*	@author Pierre-Henri Symoneaux
*/
public class ColorMap {
	
	public enum ColorMode {
		FIRE,
		LINEAR,
		MULTIPLICATION
	}

	public static Color getColor(int iterations, int max_iterations, ColorMode mode)
	{
		Color c = null;
		
		switch(mode)
		{
		
		case FIRE:
			if(iterations == max_iterations)
				c = new Color(0, 0, 0);
			else if(iterations < 64)
				c = new Color(iterations*2, 0, 0);
			else if (iterations < 128)
				c = new Color((((iterations-64)*128)/126)+128, 0, 0);
			else if (iterations < 256)
				c = new Color((((iterations-128)*62)/127)+193, 0, 0);
			else if (iterations < 512)
				c = new Color(255, (((iterations-256)*62)/255)+1, 0);
			else if (iterations < 1024)
				c = new Color(255, (((iterations-512)*63)/511)+64, 0);
			else if (iterations < 2048)
				c = new Color(255, (((iterations-1024)*63)/1023)+128, 0);
			else if (iterations < 4096)
				c = new Color(255, (((iterations-2048)*63)/2047)+192, 0);
			else
				c = new Color(255, 255, 0);
			break;
			
			
		case LINEAR:
			if(iterations == max_iterations)
				c = Color.BLACK;
			else if(iterations < max_iterations/12)
				c = Color.CYAN;
			else if(iterations < 2*max_iterations/12)
				c = Color.BLUE;
			else if(iterations < 3*max_iterations/12)
				c = Color.GREEN;
			else if(iterations < 4*max_iterations/12)
				c = Color.YELLOW;
			else if(iterations < 5*max_iterations/12)
				c = Color.ORANGE;
			else if(iterations < 6*max_iterations/12)
				c = Color.RED;
			else if(iterations < 7*max_iterations/12)
				c = Color.MAGENTA;
			else if(iterations < 8*max_iterations/12)
				c = Color.PINK;
			else if(iterations < 9*max_iterations/12)
				c = Color.WHITE;
			else if(iterations < 10*max_iterations/12)
				c = Color.LIGHT_GRAY;
			else if(iterations < 11*max_iterations/12)
				c = Color.GRAY;
			else
				c = Color.DARK_GRAY;
			break;
			
			
		case MULTIPLICATION:
			c = new Color(iterations*iterations*iterations*iterations);
			break;
		}
			
		return c;
	}

}

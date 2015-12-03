package data;

/**
 * Singleton data control class for Assignment Submitting System(ASS)
 * @author Dongwon
 *
 */
public class Singleton {
	
	private static Singleton data;
	
	public Singleton() {
		if(data == null)
			data = new Singleton();
	}
	
	public Singleton getSingletonData() {
		return data;
	}
}

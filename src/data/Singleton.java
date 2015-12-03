package data;

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

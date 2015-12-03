package data;

public class SingletonData {
	
	static SingletonData data;
	
	public SingletonData() {
	}
	
	public void setSingletonData(SingletonData data) {
		this.data = data;
	}
	
	public SingletonData getSingletonData() {
		if(data == null)
			return new SingletonData();
		return data;
	}
}

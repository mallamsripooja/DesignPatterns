// EARLY instantiation i.e., instance is created at load time.
class Singleton
{
	private static Singleton earlySingleton = new Singleton(); 
	private Singleton(){}  

	public static Singleton getSingleton(){  
		return earlySingleton;  
	}  

	public void sampleMethod(){
		System.out.println("Sample method of Singleton class called.");
	}
}

public class SingletonClient
{
	public static void main(String[] args){
		Singleton.getSingleton().sampleMethod();
	}
}
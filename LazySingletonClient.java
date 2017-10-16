// LAZY instantiation i.e., instance is created only when required.
class Singleton
{
	private static Singleton lazySingleton; 
	private Singleton(){}  

	public static Singleton getSingleton(){
		if (lazySingleton == null)
		{
			lazySingleton = new Singleton();
		}
		return lazySingleton;

		// Use the commented lines of code to make the method THREAD SAFE.
		/*synchronized (Singleton.class) {
			if (lazySingleton == null) {
				lazySingleton = new Singleton();
			}
		}*/

	}  

	public void sampleMethod(){
		System.out.println("Sample method of Singleton class called.");
	}
}

public class LazySingletonClient
{
	public static void main(String[] args){
		Singleton.getSingleton().sampleMethod();
	}
}
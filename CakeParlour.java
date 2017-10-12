// ------------------------------------------------------------------ //
// Cake class represents cake properties
class Cake
{
	String doughType;
	String cakeShape;
}

// ------------------------------------------------------------------ //
// Cake builder interface which defines steps in cake building
interface CakeBuilder
{
	public Cake cake = new Cake();
	public void buildDough();
	public void buildCakeShape();
	public Cake getCake();
}

// ------------------------------------------------------------------ //
// Implementation 1 for CakeBuilder (Small Cake)
class SmallCake implements CakeBuilder
{
	public void buildDough(){
		cake.doughType = "Less dough with strawberry essence";
	}
	public void buildCakeShape(){
		cake.cakeShape = "Circular";
	}
	public Cake getCake(){
		return cake;
	}
}

// ------------------------------------------------------------------ //
// Implementation 2 for CakeBuilder (Cup Cake)
class CupCake implements CakeBuilder
{
	public void buildDough(){
		cake.doughType = "Very less dough with vanilla essence";
	}
	public void buildCakeShape(){
		cake.cakeShape = "Cup cake shape";
	}
	public Cake getCake(){
		return cake;
	}
}

// ------------------------------------------------------------------ //
// Implementation 3 for CakeBuilder (Big Cake)
class BigCake implements CakeBuilder
{
	public void buildDough(){
		cake.doughType = "More dough with grapes and kiwi essence";
	}
	public void buildCakeShape(){
		cake.cakeShape = "Two layered shape";
	}
	public Cake getCake(){
		return cake;
	}
}

// ------------------------------------------------------------------ //
// Cake director directs the desired cake builder to build a cake
class CakeDirector
{
	public Cake createCake(CakeBuilder builder){
		builder.buildDough();
		builder.buildCakeShape();
		return builder.getCake();
	}
}

// ------------------------------------------------------------------ //
// The client places order for cake here
public class CakeParlour
{
	public static void main(String[] args){
		CakeDirector director = new CakeDirector();
		CakeBuilder builder = null;
		switch(args[0]) {
			case "SMALL_CAKE":
				builder = new SmallCake();
				break;
			case "CUP_CAKE":
				builder = new CupCake();
				break;
			case "BIG_CAKE":
				builder = new BigCake();
				break;
		}

		Cake cake = director.createCake(builder);
		// Print output
		System.out.println(cake.doughType);
		System.out.println(cake.cakeShape);
	}
}
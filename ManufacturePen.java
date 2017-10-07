// Defining PEN types
enum Pen{
	BALL, GEL
}

// -----------------------------------------------------------------//

// Interface for creating a pen
interface PenBody
{
	public void createPenBody();
}

// Creates a BALL pen body
class BallPenBody implements PenBody
{
	public void createPenBody(){
		System.out.println("Creating BALL pen body");
	}
}

// Creates a GEL pen body
class GelPenBody implements PenBody
{
	public void createPenBody(){
		System.out.println("Creating GEL pen body");
	}
}

// -----------------------------------------------------------------//

// Interface to fill ink in pens
interface Ink
{
	public void fillInk();
}

// Fills BALL pen ink
class BallPenInk implements Ink
{
	public void fillInk(){
		System.out.println("Filling BALL pen ink");
	}
}

// Fills GEL pen ink
class GelPenInk implements Ink
{
	public void fillInk(){
		System.out.println("Filling GEL pen ink");
	}
}

// -----------------------------------------------------------------//

// Produces PEN of required type to the manufacturer
abstract class AbstractPenFactory{
	static AbstractPenFactory getPenFactory(Pen pen){
		AbstractPenFactory penFactory = null;
		switch(pen){
			case BALL:  penFactory=new BallPen();
										break;
			case GEL: penFactory = new GelPen();
										break;
		}
		return penFactory;
	}

	public abstract PenBody getPenBody();
	public abstract Ink getInk();
}

// Produces BALL pen
class BallPen extends AbstractPenFactory
{
	@Override
	public PenBody getPenBody(){
		return new BallPenBody();
	}

	@Override
	public Ink getInk(){
		return new BallPenInk();
	}
}

// Produces GEL pen
class GelPen extends AbstractPenFactory
{
	@Override
	public PenBody getPenBody(){
		return new GelPenBody();
	}

	@Override
	public Ink getInk(){
		return new GelPenInk();
	}
}

// -----------------------------------------------------------------//

// Manufactures various tyes of pens using the AbstractPenFactory
public class ManufacturePen{
	public static void main(String[] args){
		AbstractPenFactory penFactory = AbstractPenFactory.getPenFactory(Pen.BALL);
		penFactory.getPenBody().createPenBody();
		penFactory.getInk().fillInk();
		
		penFactory = AbstractPenFactory.getPenFactory(Pen.GEL);
		penFactory.getPenBody().createPenBody();
		penFactory.getInk().fillInk();
	}
}
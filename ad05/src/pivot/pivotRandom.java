package pivot;

import impl.Element;

public class pivotRandom implements pivotSucher{

	public pivotRandom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPivotElement(Element[] array) {
		return ((int)((array.length-1) * Math.random()));
	}

}

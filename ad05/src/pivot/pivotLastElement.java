package pivot;

import impl.Element;

public class pivotLastElement implements pivotSucher{

	public pivotLastElement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPivotElement(Element[] array) {
		return (array.length-1);
	}

}

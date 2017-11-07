package pivot;

import impl.Element;

public class pivotMedian implements pivotSucher {

	public pivotMedian() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPivotElement(Element[] array) {
		Element a = array[0];
		Element b = array[(array.length-1)/2];
		Element c = array[array.length-1];
		if ( a.getKey() < c.getKey() &&  a.getKey() > b.getKey()) {
			return 0;
		}
		if ( a.getKey() > c.getKey() &&  a.getKey() < b.getKey()) {
			return 0;
		}
		if ( c.getKey() < a.getKey() &&  c.getKey() > b.getKey()) {
			return array.length-1;
		}
		if ( c.getKey() > a.getKey() &&  c.getKey() < b.getKey()) {
			return array.length-1;
		}
		if ( b.getKey() < a.getKey() && b.getKey() > c.getKey()) {
			return (array.length-1)/2;
		}
		if ( b.getKey() > a.getKey() && b.getKey() < c.getKey()) {
			return (array.length-1)/2;
		}
		else {
			return 0;
		}	
	}

}

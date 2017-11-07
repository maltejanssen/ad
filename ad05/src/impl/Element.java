package impl;


public class Element {
	
	private int key;

	public Element(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj.getClass() != this.getClass())
			return false;
		
		Element that = (Element) obj;
		return (that.getKey() == this.getKey());
	}
	
	@Override
	public int hashCode()
	{
		return key;
	}
}

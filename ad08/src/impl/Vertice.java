package impl;

public class Vertice<T> {
	
	public final int ID;
	private T value;
	
	private static int nextID = 0;
	
	public Vertice(T value) {
		this.ID = nextID;
		nextID++;
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		
		if(o instanceof Vertice<?>) {
			Vertice<T> v = (Vertice<T>) o;
			return this.value.equals(v.getValue());
		} else {
			return false;
		}
		
	}

	@Override
	public int hashCode(){
		return ID;
	}
}

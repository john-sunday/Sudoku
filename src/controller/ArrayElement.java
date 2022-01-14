package controller;

public class ArrayElement {
	
	private int value;
	private boolean fixed;
	private final int solution;
		
	public ArrayElement(int value, boolean fixed, final int solution) {
		this.setValue(value);
		this.setFixed(fixed);
		this.solution = solution;
	}

	public ArrayElement(int value, boolean fixed) {
		this.setValue(value);
		this.setFixed(fixed);
		this.solution = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isFixed() {
		return fixed;
	}
	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
	public int getSolution() {
		return solution;
	}
}

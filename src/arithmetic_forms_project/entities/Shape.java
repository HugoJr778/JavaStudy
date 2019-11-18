package arithmetic_forms_project.entities;

import arithmetic_forms_project.entities.enums.Color;

public abstract class Shape {
	
	private Color color;
	
	public Shape() {
	}
	
	public Shape(Color color) {
		this.color = color;
	}

	public abstract double area();

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
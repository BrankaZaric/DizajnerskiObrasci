 package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DlgPoint;

public class Point extends Shape implements Cloneable{

	private int x;
	private int y;
    protected Color color;
	
	public Point() {
		
	}
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point (int x, int y, boolean selected) {
		this (x,y);
		//this.x = x;
		//this.y = y;
		setSelected(selected);
	}
	
	
	public Point (int x, int y, boolean selected, Color color) {
		this (x, y, selected);
		this.color = color;
	}
	
	public Point (int x, int y, Color color) {
		this(x, y);
		setColor(color);
	}
	
	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	 public boolean equals (Object obj) {
	   if (obj instanceof Point) {
		   Point pomocna = (Point)obj;
		   if (this.x == pomocna.x && this.y == pomocna.y)
			   return true;
		   else
			   return false; 
	   }
	   else
		   return false;
	 }
	
	 
	 public boolean contains (int x, int y) {
	 /* if (this.distance(x, y)<= 2) {
		  return true;
	  }
	  return false;*/
		 return this.distance(x, y)<= 2;
	 }
	 
	 
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		
		//da se nacrta plavi kvadratic ako je tacka selektovana
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void moveBy(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
		
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
		return (int) (this.distance(0, 0)-((Point)o).distance(0,0));
		}
		return 0;
	}
	

	@Override
	public Point clone(){
		
		Point p = new Point();
		p.setX(this.getX());
		p.setY(this.getY());
		p.setColor(this.getColor());
		
		return p;
	}

	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return this.x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return this.y;
	}
	
	
	public String toString() {
		return "Point:" + "(" + x + "," + y + ")"
					+ " " + "Outline color:" + getColor();
	}
	
}


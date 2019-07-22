package org.kemetkoder.astevens;

public class HealthyBurger extends Hamburger{
	public enum HBTopping{
		carrot(0.15),
		spinach(0.20);
		
		private double hbtPrice;
		
		HBTopping(double topPrice) {
			this.hbtPrice = topPrice;
		}
		
		double getHbtPrice() {
			return this.hbtPrice;
		}
	}
}

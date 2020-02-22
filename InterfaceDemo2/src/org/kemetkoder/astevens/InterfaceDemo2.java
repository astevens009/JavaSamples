package org.kemetkoder.astevens;

public class InterfaceDemo2 {

    public static void main(String[] args) {
	    StarfleetShip enterprise = new StarfleetShip();
        System.out.println(enterprise.toString());

        enterprise.navigate(2.55, 3.0, 0.0);
	    enterprise.goToWarp();
        enterprise.performDiagnostic(1);

    }
}

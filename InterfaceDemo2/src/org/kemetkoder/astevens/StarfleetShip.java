package org.kemetkoder.astevens;

import java.util.*;

public class StarfleetShip implements ISpaceVessel {

    private double speed;
    private int diagnosticLevel;  // used to determine the diagnosticLevel of diagnostic to perform
    private VesselClass shipClass;
    private VesselStatus currentVesselStatus;
    private String shipName;

    public StarfleetShip(){
        this.speed = 0.0;
        this.diagnosticLevel = 0;
        this.shipClass = VesselClass.None;
        this.shipName = "Ital Odo";
        this.setCurrentVesselStatus(VesselStatus.Active);
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public VesselClass getShipClass() {
        return shipClass;
    }

    public void setShipClass(VesselClass shipClass) {
        this.shipClass = shipClass;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDiagnosticLevel() {
        return diagnosticLevel;
    }

    public void setDiagnosticLevel(int diagnosticLevel) {
        this.diagnosticLevel = diagnosticLevel;
    }

    public VesselStatus getCurrentVesselStatus() {
        return currentVesselStatus;
    }

    public void setCurrentVesselStatus(VesselStatus currentVesselStatus) {
        this.currentVesselStatus = currentVesselStatus;
    }

    @Override
    public void navigate(double pitch, double yaw, double roll) {
        // TODO: Make more interactive so that the user has to input pitch, yaw, and roll
        System.out.println("Navigating to " + pitch + " mark " + yaw);
    }

    @Override
    public void goToWarp() {
        Scanner warpSpeed = new Scanner(System.in);
        //double speed = 0.0;

        System.out.println("Enter the warp speed: ");
        this.setSpeed(warpSpeed.nextDouble());
        warpSpeed.nextLine();

        if(this.getSpeed() > 8.5)
            System.out.println("Warp speed " + this.getSpeed() + " is NOT recommended!");
        // TODO: Allow the captain to override.
        else {
            System.out.println("Going to warp speed " + speed);
            for (double sp = 1.0; sp <= speed; sp += 0.5) {
                if (sp == speed)
                    System.out.println("Warp " + sp + " achieved!");
                else
                    System.out.println("Warp " + sp + "... ");
            }
        }
    }

    @Override
    public VesselDiagnostic performDiagnostic(int level) {
        VesselDiagnostic diagnostic = new VesselDiagnostic();

        System.out.println("\nDiagnostic Level: " + level +
                "\nShip Status: " + diagnostic.displayDiagnosticReport());

        return diagnostic;
    }

    @Override
    public VesselStatus showVesselStatus() {
        return this.getCurrentVesselStatus();
    }

    @Override
    public String toString() {
        //String statusStr = "Current status of the ship is: " + this.getCurrentVesselStatus();
        String statusStr =
                String.format("\nShip Name: %s\nCurrent Speed: %f\nDiagnostic Level: %d" +
                        "\nShip Class: %s\nShip Status: %s\n",
                        this.getShipName(),
                        this.getSpeed(),
                        this.getDiagnosticLevel(),
                        this.getShipClass(),
                        this.getCurrentVesselStatus());

        return statusStr;
    }
}

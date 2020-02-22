package org.kemetkoder.astevens;

public interface ISpaceVessel {
    enum VesselStatus{
        NonCommissioned,    // a ship that is brand new
        DeCommissioned,
        Active,
        Repairing,
        Upgrading,
        Destroyed,
        Missing
    }

    enum VesselClass {
        None,
        Galaxy,
        Consitution,
        Constellation,
        Defiant,
        Dreadnaught,
        Nebula,
        Intrepid,
        Scientific
    }


    void navigate(double pitch, double yaw, double roll);
    void goToWarp();
    VesselDiagnostic performDiagnostic(int level);
    VesselStatus showVesselStatus();
}

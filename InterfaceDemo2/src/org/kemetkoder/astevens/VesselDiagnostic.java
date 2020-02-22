package org.kemetkoder.astevens;

public class VesselDiagnostic implements IDiagnostic {
    private ComponentStatus cmpStat;

    public VesselDiagnostic() {
        cmpStat = ComponentStatus.Online;
    }

    public VesselDiagnostic(ComponentStatus cmpStat) {
        this.cmpStat = cmpStat;
    }

    public ComponentStatus getCmpStat() {
        return cmpStat;
    }

    public void setCmpStat(ComponentStatus cmpStat) {
        this.cmpStat = cmpStat;
    }

    @Override
    public ComponentStatus displayStatus() {
        return getCmpStat();
    }

    @Override
    public String displayDiagnosticReport() {
        return "TEST: All systems are online and functioning.";
    }
}

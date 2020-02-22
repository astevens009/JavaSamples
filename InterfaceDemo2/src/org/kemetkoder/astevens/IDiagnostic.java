package org.kemetkoder.astevens;

/**
 * Provides a diagnostic report on the status of the systems on a space vessel
 * NOTE: Modify this later to be an abstract class
 */
public interface IDiagnostic {
    enum ComponentStatus{
        Impaired,
        Damaged,
        Functional,
        Online,
        Offline
    }

    ComponentStatus displayStatus();
    String displayDiagnosticReport();
}

package org.kemetkoder.astevens;

public class StarfleetPersonnel {
    enum Rank{
        Civilian,
        Ensign,
        Lieutenant,
        LieutenantCmdr,
        Commander,
        Captain,
        Admiral,
        FleetAdmiral
    }

    enum DutyStatus{
        Active,
        Retired,
        Resigned,
        Reserves,
        Missing,
        Discharged,
        Deceased,
    }

    enum Department{
        Medical,
        Enegineering,
        Mathematics,
        PlanetarySciences,
        Military,
        Diplomatic,
        Linguistics
    }

    enum HomePlanet{
        Earth,
        MarsColony,
        LunarColony,
        Kronos,
        Khitomer,
        Vulcan,
        Riisa,
        Bajor,
        Cardassians,
        Romulus,
        Remus
    }

    String lastName;
    String firstName;
    Rank starfleetRank;
    Department dept;
    DutyStatus dutyStat;
    HomePlanet homePlanet;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Rank getStarfleetRank() {
        return starfleetRank;
    }

    public void setStarfleetRank(Rank starfleetRank) {
        this.starfleetRank = starfleetRank;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public DutyStatus getDutyStat() {
        return dutyStat;
    }

    public void setDutyStat(DutyStatus dutyStat) {
        this.dutyStat = dutyStat;
    }

    public HomePlanet getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(HomePlanet homePlanet) {
        this.homePlanet = homePlanet;
    }

    void displayPersonnelRecord(){

    }
}

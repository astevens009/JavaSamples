package org.kemetkoder.astevens;

public class AcademyStudent{
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

    private String lastName;
    private String firstName;
    private Rank starfleetRank;
    private DutyStatus dutyStat;


    public AcademyStudent() {
        this.starfleetRank = Rank.Ensign;
        this.dutyStat = DutyStatus.Active;
    }

    public AcademyStudent(String lastName, String firstName, Rank starfleetRank,
                          DutyStatus dutyStat) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.starfleetRank = starfleetRank;
        this.dutyStat = dutyStat;
    }

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

    public DutyStatus getDutyStat() {
        return dutyStat;
    }

    public void setDutyStat(DutyStatus dutyStat) {
        this.dutyStat = dutyStat;
    }

    /**
     * Demonstrating inner class here...
     */
    public class StudentAddress{
        private String homePlanet;
        private String country;
        private String city;
        private String state;
        private String postalCode;

        public StudentAddress(String homePlanet, String country, String city, String state,
                              String postalCode) {
            this.homePlanet = homePlanet;
            this.country = country;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
        }

        public void displayAddress(){
            String address = String.format("Student: %s %s, %s\nHome Planet: %s\nCountry: %s" +
                            "\nCity: %s\nState: %s\nPostal Code: %s",
                    AcademyStudent.this.starfleetRank,
                    AcademyStudent.this.lastName,
                    AcademyStudent.this.firstName,
                    this.homePlanet,
                    this.country,
                    this.city,
                    this.state,
                    this.postalCode);

            System.out.println(address);
        }
    }
}

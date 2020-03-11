package org.kemetkoder.astevens;

public class InnerClassDemo {

    public static void main(String[] args) {
	    AcademyStudent siskoB01 = new AcademyStudent();
	    siskoB01.setStarfleetRank(AcademyStudent.Rank.Lieutenant);
	    siskoB01.setLastName("Sisko");
	    siskoB01.setFirstName("Benjamin");
	    siskoB01.setDutyStat(AcademyStudent.DutyStatus.Active);

	    AcademyStudent.StudentAddress siskoAddress = siskoB01.new StudentAddress("Earth", "United States",
                "New Orleans", "La", "12345");

        siskoAddress.displayAddress();
    }
}

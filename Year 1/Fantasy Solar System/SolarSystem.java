
import java.util.ArrayList;
import java.util.Scanner;

public class SolarSystem {

    String systemName;
	//declaring the name and the constructor
    public SolarSystem(String name) {
        systemName = name;
    }

    //inputting the arraylist
	public ArrayList<Planets> planetList = new ArrayList<Planets>();

    public void addPlanet(String name, double mass, double distance) {
        planetList.add(new Planets (name, mass, distance));		

	}
	
	//changing string to toString for the table output
    public String toString() {

        StringBuilder planetString = new StringBuilder();

        planetString.append(systemName + "\n");

        for (Planets currentPlanets : planetList) {
			planetString.append(currentPlanets.toString());
        }
        return planetString.toString();
    }

    public String planetInformation() {
        StringBuilder infoString = new StringBuilder();
		
		//appends name, mass and distance to table
        infoString.append("Name\t");
        infoString.append("\tMass\t");
        infoString.append("\tDistance \t");
		infoString.append("Orbit ");
        infoString.append("Period (Years)\n");

        for (Planets currentPlanets : planetList) {
			
			infoString.append(currentPlanets.planetInformation());

        }
		//returns the toString
	   return infoString.toString();
    }

}


 
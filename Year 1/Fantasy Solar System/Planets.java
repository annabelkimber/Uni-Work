
public class Planets {

    //declaring the variables
    private String name;
    private double mass;
    private double distance;
    private double period;
    private double orbit;

    Planets(String name, double mass, double distance) {

        //referencing the current object 
        this.name = name;
        this.mass = mass;
        this.distance = distance;
        orbit = Math.sqrt(distance * distance * distance);
        period = (orbit * 365.26);

    }

    public static double roundVal(double orbit) {
        return Math.round(orbit * 1000) / 1000.0;
    }

    //getting the name
    public String getName() {
        return name;
    }

    //setting the period
    public void setName(String name) {
        this.name = name;
    }

    //getting the period
    public double getMass() {
        return mass;
    }

    //setting the mass
    public void setMass(double mass) {
        this.mass = mass;
    }

    //setting the distance
    public double getDistance() {
        return distance;
    }

    //setting the distance
    public void setDistance(double distance) {
        this.distance = distance;
    }

    //getting the period
    public double getPeriod() {
        return period;
    }

    //setting the period
    public void setPeriod(double period) {
        this.period = period;
    }

    public void setOrbit(double orbit) {

        this.orbit = orbit;
    }

    public double getOrbit(double orbit) {
        return Math.sqrt(getDistance() * getDistance() * getDistance());
    }

    public String planetInformation() {
        StringBuilder informationString = new StringBuilder();

		//rounding the values
        String planetName = name;
        double planetMass = roundVal(mass);
        double planetDistance = roundVal(distance);
        double planetOrbit = roundVal(orbit);

        informationString.append(planetName + "\t\t" + planetMass + "\t");
        informationString.append("\t" + planetDistance + "\t");
        informationString.append("\t" + planetOrbit + "\n");

        return informationString.toString();

    }

    public String toString() {

        StringBuilder planetString = new StringBuilder();

		//rounding the values
        String planetName = name;
        double planetMass = roundVal(mass);
        double planetDistance = roundVal(distance);
        double planetOrbit = roundVal(orbit);
        double planetPeriod = roundVal(getPeriod());

        // for every system.out.print replace
        // StringB.append("Planet " + planetName);
        planetString.append("Planet " + planetName);
        planetString.append(" has a mass of " + planetMass);
        planetString.append((" Earths, is " + planetDistance) + "AU from its star,");

		//if else statement deciding the days and years 
        if (planetOrbit <= 1.0) {
            planetOrbit = roundVal(planetOrbit * 365.25);
            planetString.append(" and orbits in " + planetOrbit + " days\n");
        } else {
            planetString.append(" and orbits in " + planetOrbit + " years\n");
        }
        return planetString.toString();
    }
}

//Student Number 864191


import java.util.Scanner;
import java.util.Random;

public class FantasySolarSystem {

    public static void main(String[] args) {
        //entering the solar system name
        Scanner in = new Scanner(System.in);
        System.out.print("Enter solar system name: ");
        String systemName = in.nextLine();

        SolarSystem mySystem = new SolarSystem(systemName);

        String newName = "";
        //using a boolean loop to have the ability to end the loop with done
        boolean loop = true;

        //adding new planets, with randomly generated mass and distance 
        //enter done to finish
        while (loop == true) {
            System.out.print("Enter planet name: ");
            newName = in.nextLine();
            //if anything other than done is entered then a name will be accepted and a mass and distance allocated
            if (!newName.equalsIgnoreCase("done")) {
                double newMass = Math.random() * 10;
                //Random rnd = new Random(10);
                double newDistance = Math.random() * 15;
                //Random random = new Random(15);
                //double newOrbit;

                Planets planet = new Planets(newName, newMass, newDistance);
                mySystem.addPlanet(newName, newMass, newDistance);

                System.out.println(planet.toString());
            } else {
                loop = false;
            }
        }

        System.out.println("\n" + mySystem.planetInformation());
    }
}

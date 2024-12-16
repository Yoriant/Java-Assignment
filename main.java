import java.util.ArrayList;
import java.util.List;

public class MyProgram {
    public static void main(String[] args) {
        System.out.println("\nExample Java OOP: creating and using object instances:\n");

        // upcasting to Animal class used
        Animal animal0 = new Animal();
        Animal animal1 = new Dog(11, 30.5, "squeaky toy");    // upcasting to Animal
        Animal animal2 = new Pig(3, 75.3);                    // upcasting to Animal
        Animal animal3 = new Animal(0, "undefined", 0);       // upcasting to Animal
        Animal animal4 = new Cat(5, 20.1, "fluffy");         // new subclass instance

        ////////////////////////////// MODIFICATION 3 /////////////////////////////
        // Create an ArrayList to store Animal objects
        List<Animal> animalList = new ArrayList<>();
        animalList.add(animal0);
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);

        // Iterate through the list and call animalSound() for each object
        for (Animal animal : animalList) {
            animal.animalSound();
        }
        ///////////////////////////////////////////////////////////////////////////

        System.out.printf("The object's kingdom is %s.\n", Animal.KINGDOM);
        System.out.println(String.format("The animal1's species is %s.", animal1.species));

        /* Downcasting to Dog class to use overloaded animalSound() method */
        if (animal1 instanceof Dog) {
            Dog dog = (Dog) animal1;           // downcasting from Animal to Dog
            System.out.println("Downcasting performed");
            dog.animalSound(2);
            System.out.println(String.format("The dog's favourite toy is %s.", dog.getFavToy()));
        }

        ////////////////////////////// MODIFICATION 5 ///////////////////////////
        // Using the if statement above, call the unique method for Cat
        if (animal4 instanceof Cat) {
            Cat cat = (Cat) animal4;           // downcasting from Animal to Cat
            System.out.println("Downcasting performed");
            System.out.println(String.format("The cat's fur type is %s.", cat.getFurType()));
        }
        ///////////////////////////////////////////////////////////////////////////
    }
} // end base class


class Animal {
    // class attributes
    public static final String KINGDOM = "Animal";

    // instance attributes
    protected int age;
    protected String species;
    protected double heightMetres;

    // default constructor
    public Animal() {
        this.age = 1;
        this.species = "species";
        this.heightMetres = 2.0;
        System.out.println("Default constructor of Animal used.");
    }

    ////////////////////////////// MODIFICATION 0 ///////////////////////////
    // Add 1 or 2 more parameters to the custom Animal constructor below
    public Animal(int age, String species, double heightM) {
        this.age = age;
        this.species = species;
        this.heightMetres = heightM;
    }

    // is overriding
    public void animalSound() {
        System.out.println("Animal sound not implemented in base class\n");
    }

    ////////////////////////////// MODIFICATION 4 ///////////////////////////
    // Add another method to the base class and override it in each derived class
    public void animalInfo() {
        System.out.println("This is an animal.");
    }
}

// Derived classes
class Pig extends Animal {
    // constructor
    public Pig(int age, double heightM) {
        super(age, "little piggy", heightM);
    }

    // overriding Animal's animalSound()
    @Override
    public void animalSound() {
        System.out.println("The pig says: oink oink\n");
    }

    @Override
    public void animalInfo() {
        System.out.println("This is a pig.");
    }
}

class Dog extends Animal {
    private String favouriteToy;

    // constructor
    public Dog(int age, double heightM, String favToy) {
        super(age, "Canis familiaris", heightM);
        this.favouriteToy = favToy;
    }

    // overriding Animal's animalSound()
    @Override
    public void animalSound() {
        System.out.println("The dog says: bow wow\n");
    }

    // overloading animalSound()
    public void animalSound(int sound) {
        switch (sound) {
            case 0:
                System.out.println("ruff ruff");
                break;
            case 1:
                System.out.println("bow wow");
                break;
            case 2:
                System.out.println("bark bark");
                break;
            case 3:
                System.out.println("meow meow");
                break;
            case 4:
                System.out.println("growl");
                break;
            default:
                System.out.println("unknown sound requested");
                break;
        }
        System.out.println();
    }

    public String getFavToy() {
        return this.favouriteToy;
    }

    public void setFavToy(String newFavToy) {
        this.favouriteToy = newFavToy;
    }

    @Override
    public void animalInfo() {
        System.out.println("This is a dog.");
    }
}

////////////////////////////// MODIFICATION 1 ///////////////////////////
// Add another animal subclass below
class Cat extends Animal {
    private String furType;

    // constructor
    public Cat(int age, double heightM, String furType) {
        super(age, "Felis catus", heightM);
        this.furType = furType;
    }

    @Override
    public void animalSound() {
        System.out.println("The cat says: meow meow\n");
    }

    public String getFurType() {
        return this.furType;
    }

    public void setFurType(String furType) {
        this.furType = furType;
    }

    @Override
    public void animalInfo() {
        System.out.println("This is a cat.");
    }
}

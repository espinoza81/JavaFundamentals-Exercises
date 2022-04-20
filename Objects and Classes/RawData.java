import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {

    static class Car {
        private String model;
        private Engine engine;
        private Cargo cargo;
        private Tires tires;

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public void setCargo(Cargo cargo) {
            this.cargo = cargo;
        }

        public Tires getTires() {
            return tires;
        }

        public void setTires(Tires tires) {
            this.tires = tires;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Car(String model, Engine engine, Cargo cargo, Tires tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }
    }

    static class Engine {
        private int engineSpeed;
        private int enginePower;

        public int getEngineSpeed() {
            return engineSpeed;
        }

        public void setEngineSpeed(int engineSpeed) {
            this.engineSpeed = engineSpeed;
        }

        public int getEnginePower() {
            return enginePower;
        }

        public void setEnginePower(int enginePower) {
            this.enginePower = enginePower;
        }

        public Engine(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }
    }

    static class Cargo {
        private int cargoWeight;
        private String cargoType; //fragile, flamable

        public int getCargoWeight() {
            return cargoWeight;
        }

        public void setCargoWeight(int cargoWeight) {
            this.cargoWeight = cargoWeight;
        }

        public String getCargoType() {
            return cargoType;
        }

        public void setCargoType(String cargoType) {
            this.cargoType = cargoType;
        }

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }
    }

    static class Tires {
        private double tireOnePressure;
        private int tireOneAge;
        private double tireTwoPressure;
        private int tireTwoAge;
        private double tireThreePressure;
        private int tireThreeAge;
        private double tireFourPressure;
        private int tireFourAge;

        public double getTireOnePressure() {
            return tireOnePressure;
        }

        public void setTireOnePressure(double tireOnePressure) {
            this.tireOnePressure = tireOnePressure;
        }

        public int getTireOneAge() {
            return tireOneAge;
        }

        public void setTireOneAge(int tireOneAge) {
            this.tireOneAge = tireOneAge;
        }

        public double getTireTwoPressure() {
            return tireTwoPressure;
        }

        public void setTireTwoPressure(double tireTwoPressure) {
            this.tireTwoPressure = tireTwoPressure;
        }

        public int getTireTwoAge() {
            return tireTwoAge;
        }

        public void setTireTwoAge(int tireTwoAge) {
            this.tireTwoAge = tireTwoAge;
        }

        public double getTireThreePressure() {
            return tireThreePressure;
        }

        public void setTireThreePressure(double tireThreePressure) {
            this.tireThreePressure = tireThreePressure;
        }

        public int getTireThreeAge() {
            return tireThreeAge;
        }

        public void setTireThreeAge(int tireThreeAge) {
            this.tireThreeAge = tireThreeAge;
        }

        public double getTireFourPressure() {
            return tireFourPressure;
        }

        public void setTireFourPressure(double tireFourPressure) {
            this.tireFourPressure = tireFourPressure;
        }

        public int getTireFourAge() {
            return tireFourAge;
        }

        public void setTireFourAge(int tireFourAge) {
            this.tireFourAge = tireFourAge;
        }

        public Tires(double tireOnePressure, int tireOneAge, double tireTwoPressure, int tireTwoAge, double tireThreePressure, int tireThreeAge, double tireFourPressure, int tireFourAge) {
            this.tireOnePressure = tireOnePressure;
            this.tireOneAge = tireOneAge;
            this.tireTwoPressure = tireTwoPressure;
            this.tireTwoAge = tireTwoAge;
            this.tireThreePressure = tireThreePressure;
            this.tireThreeAge = tireThreeAge;
            this.tireFourPressure = tireFourPressure;
            this.tireFourAge = tireFourAge;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String input = console.nextLine();
            String[] attribute = input.split(" ");
            String model = attribute[0];
            int engineSpeed = Integer.parseInt(attribute[1]);
            int enginePower = Integer.parseInt(attribute[2]);
            int cargoWeight = Integer.parseInt(attribute[3]);
            String cargoType = attribute[4];
            double tireOnePressure = Double.parseDouble(attribute[5]);
            int tireOneAge = Integer.parseInt(attribute[6]);
            double tireTwoPressure = Double.parseDouble(attribute[7]);
            int tireTwoAge = Integer.parseInt(attribute[8]);
            double tireThreePressure = Double.parseDouble(attribute[9]);
            int tireThreeAge = Integer.parseInt(attribute[10]);
            double tireFourPressure = Double.parseDouble(attribute[11]);
            int tireFourAge = Integer.parseInt(attribute[12]);

            Engine singleEngine = new Engine(engineSpeed, enginePower);
            Cargo singleCargo =  new Cargo(cargoWeight, cargoType);
            Tires singleTires = new Tires(tireOnePressure, tireOneAge, tireTwoPressure, tireTwoAge, tireThreePressure, tireThreeAge, tireFourPressure, tireFourAge);

            Car singleCar = new Car(model, singleEngine, singleCargo, singleTires);
            carList.add(singleCar);
        }
        String command = console.nextLine(); //fragile, flamable
        if("fragile".equals(command)) {
            carList.stream().filter(s -> s.getCargo().getCargoType().
                    equals(command) && (s.getTires().getTireOnePressure() < 1.00 || s.getTires().getTireTwoPressure() < 1.00 || s.getTires().getTireThreePressure() < 1.00 || s.getTires().getTireFourPressure() < 1.00)).
                    forEach(s -> System.out.println(s.getModel()));
        }
        else {
            carList.stream().filter(s -> s.getCargo().getCargoType().equals(command) && s.getEngine().getEnginePower() > 250).forEach(s -> System.out.println(s.getModel()));
        }
    }
}
//<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>

import java.util.*;

public class CarSalesman {
    static class Car {
        private String model;
        private Engine engine;
        private String weight;
        private String color;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Car(String model, Engine engine, String weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("%s:%n" +
                    "%s" +
                    "  Weight: %s%n" +
                    "  Color: %s", getModel(), getEngine().toString(), getWeight(), getColor());
        }
    }
    static class Engine{
        private String model;
        private String power;
        private String displacement;
        private String efficiency;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }

        public Engine(String model, String power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        @Override
        public String toString() {
            return String.format("  %s:%n" +
                    "    Power: %s%n" +
                    "    Displacement: %s%n" +
                    "    Efficiency: %s%n", getModel(), getPower(), getDisplacement(), getEfficiency());
        }
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numberEngine = Integer.parseInt(console.nextLine());
        List<Engine> engineList = new ArrayList<>();
        String input;
        for (int i = 0; i < numberEngine; i++) {
            input = console.nextLine();
            String[] attribute = input.split(" ");
            String model = attribute[0];
            String power = attribute[1];
            String displacement  = "n/a";
            String efficiency = "n/a";

            if(attribute.length >= 3) {
                if(attribute[2].matches("-?\\d+"))  displacement = attribute[2];
                else efficiency = attribute[2];
            }
            if(attribute.length == 4) {
                efficiency = attribute[3];
            }
            Engine singleEngine = new Engine(model, power, displacement, efficiency);
            engineList.add(singleEngine);
        }

        int numberCars = Integer.parseInt(console.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberCars; i++) {
            input = console.nextLine();
            String[] attribute = input.split(" ");
            String model  = attribute[0];
            String engine  = attribute[1];
            String weight = "n/a";
            String color = "n/a";

            if(attribute.length >= 3) {
                if(attribute[2].matches("-?\\d+"))  weight = attribute[2];
                else color = attribute[2];
            }
            if(attribute.length == 4) {
                color = attribute[3];
            }

            String engineModel = null;
            String enginePower = null;
            String engineDisplacement = null;
            String engineEfficiency = null;
            for (Engine engineForCar: engineList) {
                if(engineForCar.getModel().equals(engine)){
                    engineModel = engineForCar.getModel();
                    enginePower = engineForCar.getPower();
                    engineDisplacement = engineForCar.getDisplacement();
                    engineEfficiency = engineForCar.getEfficiency();
                    break;
                }
            }
            Engine engineForThisCar = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            Car singleCar = new Car(model, engineForThisCar, weight, color);
            carList.add(singleCar);
        }

        carList.forEach(s -> System.out.println(s.toString()));
    }
}

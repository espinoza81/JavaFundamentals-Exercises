import java.util.*;

public class VehicleCatalogue {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public VehicleCatalogue(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        List<VehicleCatalogue> vehicleList = new ArrayList<>();

        while(!"End".equals(input= console.nextLine())){
            String[] attribute = input.split(" ");
            String type = attribute[0];
            String model = attribute[1];
            String color = attribute[2];
            int horsepower = Integer.parseInt(attribute[3]);

            VehicleCatalogue singleVehicle = new VehicleCatalogue(type, model, color, horsepower);
            vehicleList.add(singleVehicle);
        }

        String modelToPrint;

        while(!"Close the Catalogue".equals(modelToPrint= console.nextLine())){
            String finalModelToPrint = modelToPrint;
            Optional<VehicleCatalogue> matchingObject = vehicleList.stream().filter(p -> p.getModel().equals(finalModelToPrint)).findFirst();
            matchingObject.ifPresent(vehicle -> {
                System.out.println("Type: " + vehicle.getType().substring(0, 1).toUpperCase() + vehicle.getType().substring(1));
                System.out.println("Model: " + vehicle.getModel());
                System.out.println("Color: " + vehicle.getColor());
                System.out.println("Horsepower: " + vehicle.getHorsepower());

            });
        }
        int sumHorseCar = 0;
        double countCar = 0.00000000000000000000000000000000000000001;
        int sumHorseTruck = 0;
        double countTruck = 0.0000000000000000000000000000000000000001;
        for (VehicleCatalogue car: vehicleList) {
            if(car.getType().equals("car")) {
                sumHorseCar += car.getHorsepower();
                countCar++;
            }
            else {
                sumHorseTruck += car.getHorsepower();
                countTruck ++;
            }
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", sumHorseCar*1.0/countCar);
        System.out.printf("Trucks have average horsepower of: %.2f.", sumHorseTruck*1.0/countTruck);
    }
}

public class VehicleFactory {
    public static Vehicle getVehicle(String type){
        if (type.equals("BuilderCar")){
            return new Car();
        } else if (type.equals("Truck")){
            return new Truck();
        } else if (type.equals("Bike")){
            return new Bike();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type");
        }
    }

}

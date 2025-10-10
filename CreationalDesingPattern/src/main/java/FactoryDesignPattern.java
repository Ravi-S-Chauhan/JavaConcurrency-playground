public class FactoryDesignPattern {
    public static void main(String args[]){
        Vehicle car = VehicleFactory.getVehicle("BuilderCar");
        Vehicle Bike = VehicleFactory.getVehicle("Bike");
        car.start();
        Bike.start();
        Bike.stop();
        car.stop();
    }
}

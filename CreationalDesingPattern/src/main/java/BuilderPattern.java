// "static void main" must be defined in a public class.
public class BuilderPattern {
    public static void main(String[] args){
        Director director = new Director();
        Builder builder = new CarBuilder();
        BuilderCar sportsBuilderCar = director.buildSportsCar(builder);
        Builder pickUp = new PickUpBuilder();
        BuilderCar pickup = director.buildPickUpCar(pickUp);
    }
}

interface Builder{
    void reset();
    void setBody(String material);
    void setEngine(String engine);
    void setInterior(String interior);
    BuilderCar getCar();
}

class Director{
    public BuilderCar buildSportsCar(Builder builder){
        builder.reset();
        builder.setBody("Aluminum");
        builder.setEngine("V8");
        builder.setInterior("leather");
        return builder.getCar();
    }

    public BuilderCar buildPickUpCar(Builder builder){
        builder.reset();
        builder.setBody("Steel");
        builder.setEngine("V6");
        builder.setInterior("leather");
        return builder.getCar();
    }
}

class CarBuilder implements Builder{
    private BuilderCar builderCar;
    public void reset(){
        builderCar = new SportsBuilderCar();
    }

    public void setBody(String material){
        builderCar.setMaterial(material);
        System.out.println("Setting body as "+material);
    }

    public void setEngine(String engine){
        builderCar.setEngine(engine);
        System.out.println("Setting engine as "+engine);
    }

    public void setInterior(String interior){
        builderCar.setInterior(interior);
        System.out.println("Setting interior as "+interior);
    }
    public BuilderCar getCar(){
        return builderCar;
    }
}

class PickUpBuilder implements Builder{
    private BuilderCar builderCar;
    public void reset(){
        builderCar = new PickupBuilderCar();
    }

    public void setBody(String material){
        builderCar.setMaterial(material);
        System.out.println("Setting body as "+material);
    }

    public void setEngine(String engine){
        builderCar.setEngine(engine);
        System.out.println("Setting engine as "+engine);
    }

    public void setInterior(String interior){
        builderCar.setInterior(interior);
        System.out.println("Setting interior as "+interior);
    }
    public BuilderCar getCar(){
        return builderCar;
    }
}

interface BuilderCar {
    void setInterior(String interior);
    void setEngine(String engine);
    void setMaterial(String material);
}

class SportsBuilderCar implements BuilderCar {
    private String material;
    private String engine;
    private String interior;

    public void setMaterial(String it){
        this.material = it;
    }

    public void setEngine(String e){
        this.engine = e;
    }

    public void setInterior(String i){
        this.interior = i;
    }
    public String toString() {
        return "SportsBuilderCar [material=" + material + ", engine=" + engine + ", interior=" + interior + "]";
    }
}

class PickupBuilderCar implements BuilderCar {
    private String material;
    private String engine;
    private String interior;

    public void setMaterial(String it){
        this.material = it;
    }

    public void setEngine(String e){
        this.engine = e;
    }

    public void setInterior(String i){
        this.interior = i;
    }
    public String toString() {
        return "PickupBuilderCar [material=" + material + ", engine=" + engine + ", interior=" + interior + "]";
    }
}

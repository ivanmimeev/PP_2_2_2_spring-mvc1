package web.model;

public class Car {
    private int id;
    private String engine;
    private String color;

    public Car(int id, String engine, String color) {
        this.id = id;
        this.engine = engine;
        this.color = color;
    }

    public Car(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

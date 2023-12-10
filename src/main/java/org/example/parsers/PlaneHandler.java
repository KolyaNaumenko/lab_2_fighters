package org.example.parsers;
import java.math.BigDecimal;
import org.example.generated.planes.Plane;
import org.example.generated.planes.CharsType;
import org.example.generated.planes.ParametersType;
import org.example.generated.planes.PlaneType;



public class PlaneHandler {
    private Plane currentPlane;
    private CharsType currentChars;
    private ParametersType currentParameters;
    private CharsType.Ammunition currentAmmunition;

    public PlaneHandler() {
        // Initialize any necessary variables
    }

    public void startPlane() {
        currentPlane = new Plane();
    }

    public void setId(String id) {
        currentPlane.setId(id);
    }

    public void setModel(String model) {
        currentPlane.setModel(model);
    }

    public void setOrigin(String origin) {
        currentPlane.setOrigin(origin);
    }

    public void startChars() {
        currentChars = new CharsType();
    }

    public void setType(String type) {
        currentChars.setType(PlaneType.valueOf(type.toUpperCase()));
    }

    public void setSeats(int seats) {
        currentChars.setSeats(seats);
    }

    public void startAmmunition() {
        currentAmmunition = new CharsType.Ammunition();
    }

    public void setMissiles(int missiles) {
        currentAmmunition.setMissiles(missiles);
    }

    public void setRadar(boolean radar) {
        currentAmmunition.setRadar(radar);
    }

    public void endChars() {
        currentChars.setAmmunition(currentAmmunition);
        currentPlane.setChars(currentChars);
    }

    public void startParameters() {
        currentParameters = new ParametersType();
    }

    public void setLength(BigDecimal length) {
        currentParameters.setLength(length);
    }

    public void setWidth(BigDecimal width) {
        currentParameters.setWidth(width);
    }

    public void setHeight(BigDecimal height) {
        currentParameters.setHeight(height);
    }

    public void endParameters() {
        currentPlane.setParameters(currentParameters);
    }

    public void setPrice(BigDecimal price) {
        currentPlane.setPrice(price);
    }

    public Plane endPlane() {
        return currentPlane;
    }
}
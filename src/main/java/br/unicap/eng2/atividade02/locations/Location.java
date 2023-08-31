package br.unicap.eng2.atividade02.locations;

public class Location {
    private String direction;
    private Location neighbor;

    public Location(String direction) {
        this.direction = direction;
    }

    public void addNeighbor(Location locationNeighbor) {
        this.neighbor = new Location(locationNeighbor.direction);
    }
}

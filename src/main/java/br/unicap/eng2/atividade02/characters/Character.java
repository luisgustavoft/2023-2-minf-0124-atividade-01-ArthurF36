package br.unicap.eng2.atividade02.characters;

import br.unicap.eng2.atividade02.locations.Location;

public class Character {
    private String name;
    private Location local;
    private boolean possibleChangeLocal;

    public Character(String name, Location local, boolean possibleChangeLocal) {
        this.name = name;
        this.local = local;
        this.possibleChangeLocal = possibleChangeLocal;
    }
}

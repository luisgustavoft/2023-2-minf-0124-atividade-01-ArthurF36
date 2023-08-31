package br.unicap.eng2.atividade02.states;

import br.unicap.eng2.atividade02.characters.Character;

public class State {
    private Character person;
    private Character chiken;
    private Character corn;
    private Character fox;

    public State(Character person, Character chiken, Character corn, Character fox) {
        this.person = person;
        this.chiken = chiken;
        this.corn = corn;
        this.fox = fox;
    }
}

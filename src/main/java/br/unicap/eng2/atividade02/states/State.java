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

    public State change(Character changeLocal) {
        if (this.person.getName().equals(changeLocal.getName())) {
            this.person = changeLocal;
        } else if (this.chiken.getName().equals(changeLocal.getName())) {
            this.chiken = changeLocal;
        } else if (this.corn.getName().equals(changeLocal.getName())) {
            this.corn = changeLocal;
        } else {
            this.fox = changeLocal;
        }
        return new State(this.person, this.chiken, this.corn, this.fox);
    }
}

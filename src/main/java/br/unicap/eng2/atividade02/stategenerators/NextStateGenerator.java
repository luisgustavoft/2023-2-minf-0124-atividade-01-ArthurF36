package br.unicap.eng2.atividade02.stategenerators;

import br.unicap.eng2.atividade02.states.State;

public class NextStateGenerator {
    private State stateCurrent;

    public NextStateGenerator(State stateCurrent) {
        this.stateCurrent = stateCurrent;
    }
}

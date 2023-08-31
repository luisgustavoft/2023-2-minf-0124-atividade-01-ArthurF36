package br.unicap.eng2.atividade02.stategenerators;

import br.unicap.eng2.atividade02.states.State;

import java.util.ArrayList;
import java.util.List;

public class NextStateGenerator {
    private State stateCurrent;

    public NextStateGenerator(State stateCurrent) {
        this.stateCurrent = stateCurrent;
    }

    public Iterable<State> generate() {
        List<State> next = new ArrayList<>();
    }
}

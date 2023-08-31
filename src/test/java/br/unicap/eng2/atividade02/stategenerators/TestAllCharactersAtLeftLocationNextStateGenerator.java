package br.unicap.eng2.atividade02.stategenerators;

import java.util.stream.StreamSupport;

import br.unicap.eng2.atividade02.Location;
import br.unicap.eng2.atividade02.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicap.eng2.atividade02.characters.Character;
import br.unicap.eng2.atividade02.locations.Location;
import br.unicap.eng2.atividade02.states.State;

public class TestAllCharactersAtLeftLocationNextStateGenerator {

  Location locationLeft;
  Location locationRight;
  Character characterPerson;
  Character characterChicken;
  Character characterCorn;
  Character characterFox;
  State stateCurrent;
  NextStateGenerator nextStateGenerator;
  State stateOnlyPersonAtRightLocation;

  @BeforeEach
  void setUp() {
    initializeLocations();
    initializeCharacters();
    stateCurrent = new State(characterPerson, characterChicken, characterCorn, characterFox);
    nextStateGenerator = new NextStateGenerator(stateCurrent);
    stateOnlyPersonAtRightLocation = stateCurrent.change(characterPerson.setLocation(locationRight));
  }

  private void initializeLocations() {
    locationLeft = new Location("left");
    locationRight = new Location("right");
    locationLeft.addNeighbor(locationRight);
    locationRight.addNeighbor(locationLeft);
  }

  private void initializeCharacters() {
    boolean canChangeLocationAlone = true;
    characterPerson = new Character("person", locationLeft, canChangeLocationAlone);
    characterChicken = new Character("chicken", locationLeft, !canChangeLocationAlone);
    characterCorn = new Character("corn", locationLeft, !canChangeLocationAlone);
    characterFox = new Character("fox", locationLeft, !canChangeLocationAlone);
  }

  @Test
  void testNextStatesContainsExactlyFourStates() {
    Iterable<State> nextStates = nextStateGenerator.generate();
    long expected = 4;
    long actual = StreamSupport
      .stream(nextStates.spliterator(), false)
      .count();
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void testNextStatesNotContainsAllPersonaLeftLocation() {
    Iterable<State> nextStates = nextStateGenerator.generate();
    boolean contains = StreamSupport
        .stream(nextStates.spliterator(), false)
        .noneMatch(o -> o.equals(stateCurrent));
    Assertions.assertTrue(contains);
  }

  @Test
  void testNextStatesContainsOnlyPersonAtRightLocation() {
    Iterable<State> nextStates = nextStateGenerator.generate();
    boolean contains = StreamSupport
      .stream(nextStates.spliterator(), false)
      .anyMatch(o -> o.equals(stateOnlyPersonAtRightLocation));
    Assertions.assertTrue(contains);
  }

  @Test
  void testNextStatesContainsPersonAndChinkenAtRightLocation() {
    Iterable<State> nextStates = nextStateGenerator.generate();
    State statePersonAndChickenAtRightLocation = stateOnlyPersonAtRightLocation
        .change(characterChicken.setLocation(locationRight));
    boolean contains = StreamSupport.stream(nextStates.spliterator(), false)
      .anyMatch(o -> o.equals(statePersonAndChickenAtRightLocation));
    Assertions.assertTrue(contains);
  }

  @Test
  void testNextStatesContainsPersonAndFoxAtRightLocation() {
    Iterable<State> nextStates = nextStateGenerator.generate();
    State statePersonAndFoxAtRightLocation = stateOnlyPersonAtRightLocation
        .change(characterFox.setLocation(locationRight));
    boolean contains = StreamSupport.stream(
      nextStates
      .spliterator(), false)
      .anyMatch(o -> o.equals(statePersonAndFoxAtRightLocation));
    Assertions.assertTrue(contains);
  }

  @Test
  void testNextStatesContainsPersonAndCornAtRightLocation() {
    Iterable<State> nextStates = nextStateGenerator.generate();
    State statePersonAndCornAtRightLocation = stateOnlyPersonAtRightLocation
        .change(characterCorn.setLocation(locationRight));
    boolean contains = 
      StreamSupport.stream(nextStates.spliterator(), false)
        .anyMatch(o -> o.equals(statePersonAndCornAtRightLocation));
    Assertions.assertTrue(contains);
  }
}
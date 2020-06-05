package generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GenericsTests {

  @Test
  void test() {
    FootballPlayer bart = new FootballPlayer("Bart");
    BaseballPlayer kirby = new BaseballPlayer("Kirby");
    BasketballPlayer kg = new BasketballPlayer("KG");

    Team<FootballPlayer> packers = new Team<>("Packers");
    packers.addPlayer(bart);

    Team<FootballPlayer> bears = new Team<>("Bears");
    bears.addPlayer(new FootballPlayer("Walter"));

    assertEquals(1, packers.numPlayers());

    Team<BaseballPlayer> twins = new Team<>("Twins");
    twins.addPlayer(kirby);

    Team<BasketballPlayer> wolves = new Team<>("Wolves");
    wolves.addPlayer(kg);

    packers.matchResult(bears, 55, 3);
    System.out.println("Rankings");
    System.out.println(packers.getName() + ": " + packers.ranking());
    System.out.println(bears.getName() + ": " + bears.ranking());
    System.out.println(packers.compareTo(bears));
  }
}

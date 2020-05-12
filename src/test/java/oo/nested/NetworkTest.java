package oo.nested;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NetworkTest {
  private Network myFace;

  @BeforeEach
  void setup() {
    myFace = new Network();
  }

  @Test
  void unenrollByOperatingOnOuterClassMemberVariable() {
    Network.Member jim = myFace.enroll("Jim");
    jim.deactivate1();
  }

  @Test
  void unenrollByOperatingOnOuterClassMethod() {
    Network.Member jon = myFace.enroll("Jon");
    jon.deactivate2();
  }
  
  @Test
  void invokeInnerClassConstructorOnAnyInstanceOfAnOuterClass() {
    Network.Member jane = myFace.new Member("Jane");
  }
}

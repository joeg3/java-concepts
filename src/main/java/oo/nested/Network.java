package oo.nested;

import java.util.ArrayList;

/**
 * This is an example of a Inner Class
 * I think if inside class is non-static, it's called an Inner Class
 * Use a non-static inner class if it needs to know and access its enclosing class
 */
public class Network {

  // With not being static, a Member object knows to which network it belongs
  public class Member {
    private String name;
    private ArrayList<Member> friends;

    public Member(String name) {
      this.name = name;
      friends = new ArrayList<>();
    }

    // Operate on outer class member variable
    public void deactivate1() {
      // Method of inner class can access instance variables and methods
      // of its outer class. A static nested class couldn't do this
      // Each inner class object has a reference to an object of the enclosing class
      members.remove(this); // members is a field of the outer class

      // In this case members.remove() implicitly uses the outer class reference
      // To explicitly use the outer class reference, use Network.this.members.remove(this);
    }

    // Use this way to check whether a Member object belongs to a particular Network:
    public boolean belongsTo(Network n) {
      return Network.this == n;
    }

    // Operate on outer class method
    public void deactivate2() {
      unenroll(this); // unenroll() is a method of the outer class
    }
  }

  private ArrayList<Member> members = new ArrayList<>();

  public Member enroll(String name) {
    Member newMember = new Member(name);
    members.add(newMember);
    return newMember;
  }

  public void unenroll(Member m) {
    members.remove(m);
  }
}

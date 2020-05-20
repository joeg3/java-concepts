package oo.interfaces;

import java.nio.channels.Channel;

public class ExtendInterfaces implements Channel {

  // Closeable is an interface with a single method:
  // public interface Closeable { void close(); }

  // Channel is an interface that extends Closeable
  // public interface Channel extends Closeable { boolean isOpen(); }

  // For this class to implement Channel, it also has to implement Closeable's method

  public boolean isOpen() {return true;}

  public void close() {}
}

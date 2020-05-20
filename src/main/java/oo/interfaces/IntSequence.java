package oo.interfaces;

public interface IntSequence {
  boolean hasNext(); // Since these are not a default implementation, they are called "abstract"
  int next();        // All methods of an interface are automatically public, so not necessary to declare public
}

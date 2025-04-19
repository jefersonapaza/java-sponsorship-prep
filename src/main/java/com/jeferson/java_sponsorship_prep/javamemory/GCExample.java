package com.jeferson.java_sponsorship_prep.javamemory;

public class GCExample {

  static class Person {
      private String name;

      Person(String name) {
          this.name = name;
      }

      @SuppressWarnings("removal")
      @Override
      protected void finalize() throws Throwable {
          System.out.println("🚮 Object '" + name + "' is being garbage collected.");
      }
  }

  public static void main(String[] args) {

        createGarbage();

        // Sugerimos al GC que haga su trabajo (no es obligatorio que lo haga inmediatamente)
        System.out.println("🧹 Suggesting GC to run...");
        System.gc();

        // Esperamos un poco para dar tiempo al GC
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Program finished.");
    }

    private static void createGarbage() {

        Person p1 = new Person("Jeferson");
        Person p2 = new Person("Apaza");

        // Quitamos referencias para que puedan ser recolectados
        p1 = null;
        p2 = null;

    }
}

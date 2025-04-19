package com.jeferson.java_sponsorship_prep.javamemory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Demo of using PhantomReference and ReferenceQueue
 * to detect when an object is ready for garbage collection.
 */
public class PhantomReferenceDemo {

    // Simple class to be tracked by the GC
    static class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "👤 Person{name='" + name + "'}";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create a queue to receive notification when GC is ready to clean the object
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();

        // Create a Person object
        Person person = new Person("Jeferson");

        // Create a PhantomReference that tracks the 'person' object
        PhantomReference<Person> phantomRef = new PhantomReference<>(person, referenceQueue);

        // Remove the strong reference so the object can be garbage collected
        person = null;

        System.out.println("🧹 Suggesting the JVM to run garbage collector...");
        System.gc(); // Suggest GC to run (not guaranteed)

        // Wait a bit to give time to the GC
        Thread.sleep(2000);

        // Check if the PhantomReference has been enqueued (ready to be cleared)
        if (referenceQueue.poll() != null) {
            System.out.println("✅ Object is ready to be garbage collected.");
        } else {
            System.out.println("⏳ Object is not collected yet.");
        }

        System.out.println("🏁 Program finished.");
    }


}

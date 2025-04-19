package com.jeferson.java_sponsorship_prep.javamemory;

import java.util.ArrayList;
import java.util.List;

// 🔴 Why it's bad:
//
// 1. The 'cache' list is declared as static.
//    This means it lives as long as the class is loaded in memory.
//
// 2. The list never gets cleared or removed.
//    All the elements added to it will stay in memory forever.
//
// 3. The elements are still referenced inside the static list.
//    Because of this, the Garbage Collector (GC) cannot remove them.
//
// ➜ This creates a memory leak:
//    Memory is used but never freed, so it grows and grows over time.


public class StaticMemoryLeakExample {

    // ❌ Static list: stays alive as long as the class is loaded
    private static final List<String> cache = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            // ❌ Adding more and more elements
            cache.add("Leaking memory... " + System.nanoTime());

            // Just to slow it down a bit
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

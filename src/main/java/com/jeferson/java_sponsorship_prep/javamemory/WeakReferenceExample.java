package com.jeferson.java_sponsorship_prep.javamemory;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// 🟢 Why it's better:
//
// 1. Using WeakReference allows the object to be collected by the Garbage Collector (GC).
//    Even if the object is still in the list, it can be removed when memory is needed.
//
// 2. This is good for caching systems or temporary storage.
//    It avoids keeping strong references to objects that are no longer needed.
//
// ➜ This reduces the risk of memory leaks.


public class WeakReferenceExample {

    public static void main(String[] args) {
        List<WeakReference<String>> weakCache = new ArrayList<>();

        while (true) {
            // ✅ Using WeakReference: GC can collect the object if needed
            String data = new String("Can be collected");
            weakCache.add(new WeakReference<>(data));

            System.out.println("Size: " + weakCache.size());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
package com.jeferson.java_sponsorship_prep.javamemory;

import java.lang.ref.SoftReference;

/*
 *  ------------------ SoftReference vs WeakReference -------------------
 *
 *  - **SoftReference**:
 *    - Keeps the referenced object in memory as long as there is enough free memory.
 *    - The object is only garbage collected when the JVM is running low on memory.
 *    - Ideal for caching purposes, where you want to keep the object in memory if possible but allow it to be collected when necessary.
 *
 *  - **WeakReference**:
 *    - The object is eligible for garbage collection as soon as there are no strong references pointing to it.
 *    - It is more aggressive than SoftReference and is typically used for objects that do not need to persist in memory.
 *    - Ideal for things like listeners, keys in maps, or other objects that should be collected quickly.
 *
 *  ------------------ Which one to choose? ------------------------------
 *
 *  - Use **SoftReference** when you want to cache objects and only remove them if memory is needed.
 *  - Use **WeakReference** for objects that can be discarded as soon as they are no longer in use (like event listeners or short-lived objects).
 */

public class SoftReferenceExample {
    public static void main(String[] args) {
        // Create a large object
        byte[] bigData = new byte[10 * 1024 * 1024]; // 10MB

        // Wrap it in a SoftReference
        SoftReference<byte[]> softRef = new SoftReference<>(bigData);

        // Nullify strong reference
        bigData = null;

        // Suggest GC (may or may not collect it yet)
        System.gc();

        // Check if the object is still there
        if (softRef.get() != null) {
            System.out.println("✅ Object is still in memory (SoftReference)");
        } else {
            System.out.println("❌ Object was collected by GC");
        }
    }
}


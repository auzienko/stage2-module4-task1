package com.mjc.stage2;

public class ThreadSafeSingleton {
    // Write your code here!
    private static volatile ThreadSafeSingleton instance;
    private static final Object mutex = new Object();

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        ThreadSafeSingleton result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    result = instance = new ThreadSafeSingleton();
                }
            }
        }
        return result;
    }
}

package com.mjc.stage2;

public class ThreadSafeSingleton {
    // Write your code here!
    private static volatile ThreadSafeSingleton instatce;
    private static final Object mutex = new Object();

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        ThreadSafeSingleton result = instatce;
        if (result == null) {
            synchronized (mutex) {
                result = instatce;
                if (result == null) {
                    result = instatce = new ThreadSafeSingleton();
                }
            }
        }
        return result;
    }
}

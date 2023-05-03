package org.example;

import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher {
    private static volatile Instrumentation instrumentation;

    public static void premain(String args, Instrumentation instrumentation) {
        ObjectSizeFetcher.instrumentation = instrumentation;
    }

    public static long getObjectSize(Object o) {
        if (instrumentation == null) {
            throw new IllegalStateException("Instrumentation not initialized");
        }
        return instrumentation.getObjectSize(o);
    }
}

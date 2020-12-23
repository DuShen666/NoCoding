package org.ds.nocoding.logging;

import org.ds.nocoding.logging.jdk.Jdk14LoggingImpl;

import java.lang.reflect.Constructor;

public final class LogFactory {
    private static Constructor<? extends Log> logConstructor;

    static {
        tryImplementation(LogFactory::useJdkLogging);
    }

    public static synchronized void useJdkLogging() {
        setImplementation(Jdk14LoggingImpl.class);
    }

    private LogFactory() {
        // disable construction
    }

    public static Log getLog(Class<?> clazz) {
        try {
            return logConstructor.newInstance(clazz.getName());
        } catch (Throwable t) {
            throw new LogException("Error creating logger for logger " + clazz.getName() + ".  Cause: " + t, t);
        }
    }

    private static void tryImplementation(Runnable runnable) {
        if (logConstructor == null) {
            try {
                runnable.run();
            } catch (Throwable t) {
                // ignore
            }
        }
    }

    private static void setImplementation(Class<? extends Log> implClass) {
        try {
            Constructor<? extends Log> candidate = implClass.getConstructor(String.class);
            Log log = candidate.newInstance(LogFactory.class.getName());
            if (log.isDebugEnabled()) {
                log.debug("Logging initialized using '" + implClass + "' adapter.");
            }
            logConstructor = candidate;
        } catch (Throwable t) {
            throw new LogException("Error setting Log implementation.  Cause: " + t, t);
        }
    }
}

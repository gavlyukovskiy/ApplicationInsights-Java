package com.microsoft.applicationinsights.web.internal;

import javax.servlet.http.HttpServletRequest;

abstract class ServletRuntime {
    private static final boolean IS_SERVLET_3X_RUNTIME = resolveIsServlet3xRuntime();

    private ServletRuntime() {
    }

    static boolean isServlet3xRuntime() {
        return IS_SERVLET_3X_RUNTIME;
    }

    /** Attempt to match the host runtime to a capable Platform implementation. */
    private static boolean resolveIsServlet3xRuntime() {
        // Find Servlet v3 new methods
        try {
            Class.forName("javax.servlet.AsyncEvent");
            HttpServletRequest.class.getMethod("isAsyncStarted");
            return true;
        } catch (NoSuchMethodException e) {
            // pre Servlet v3
        } catch (ClassNotFoundException e) {
            // pre Servlet v3
        }

        // Servlet 2.5
        return false;
    }
}
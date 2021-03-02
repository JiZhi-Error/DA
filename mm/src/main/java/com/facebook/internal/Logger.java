package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    private static final HashMap<String, String> stringsToReplace = new HashMap<>();
    private final LoggingBehavior behavior;
    private StringBuilder contents;
    private int priority = 3;
    private final String tag;

    static {
        AppMethodBeat.i(17858);
        AppMethodBeat.o(17858);
    }

    public static synchronized void registerStringToReplace(String str, String str2) {
        synchronized (Logger.class) {
            AppMethodBeat.i(17841);
            stringsToReplace.put(str, str2);
            AppMethodBeat.o(17841);
        }
    }

    public static synchronized void registerAccessToken(String str) {
        synchronized (Logger.class) {
            AppMethodBeat.i(17842);
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(str, "ACCESS_TOKEN_REMOVED");
            }
            AppMethodBeat.o(17842);
        }
    }

    public static void log(LoggingBehavior loggingBehavior, String str, String str2) {
        AppMethodBeat.i(17843);
        log(loggingBehavior, 3, str, str2);
        AppMethodBeat.o(17843);
    }

    public static void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        AppMethodBeat.i(17844);
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            log(loggingBehavior, 3, str, String.format(str2, objArr));
        }
        AppMethodBeat.o(17844);
    }

    public static void log(LoggingBehavior loggingBehavior, int i2, String str, String str2, Object... objArr) {
        AppMethodBeat.i(17845);
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            log(loggingBehavior, i2, str, String.format(str2, objArr));
        }
        AppMethodBeat.o(17845);
    }

    public static void log(LoggingBehavior loggingBehavior, int i2, String str, String str2) {
        AppMethodBeat.i(17846);
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            String replaceStrings = replaceStrings(str2);
            if (!str.startsWith(LOG_TAG_BASE)) {
                str = LOG_TAG_BASE.concat(String.valueOf(str));
            }
            Log.println(i2, str, replaceStrings);
            if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception();
            }
        }
        AppMethodBeat.o(17846);
    }

    private static synchronized String replaceStrings(String str) {
        synchronized (Logger.class) {
            AppMethodBeat.i(17847);
            for (Map.Entry<String, String> entry : stringsToReplace.entrySet()) {
                str = str.replace(entry.getKey(), entry.getValue());
            }
            AppMethodBeat.o(17847);
        }
        return str;
    }

    public Logger(LoggingBehavior loggingBehavior, String str) {
        AppMethodBeat.i(17848);
        Validate.notNullOrEmpty(str, "tag");
        this.behavior = loggingBehavior;
        this.tag = LOG_TAG_BASE.concat(String.valueOf(str));
        this.contents = new StringBuilder();
        AppMethodBeat.o(17848);
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i2) {
        AppMethodBeat.i(17849);
        Validate.oneOf(Integer.valueOf(i2), "value", 7, 3, 6, 4, 2, 5);
        this.priority = i2;
        AppMethodBeat.o(17849);
    }

    public String getContents() {
        AppMethodBeat.i(17850);
        String replaceStrings = replaceStrings(this.contents.toString());
        AppMethodBeat.o(17850);
        return replaceStrings;
    }

    public void log() {
        AppMethodBeat.i(17851);
        logString(this.contents.toString());
        this.contents = new StringBuilder();
        AppMethodBeat.o(17851);
    }

    public void logString(String str) {
        AppMethodBeat.i(17852);
        log(this.behavior, this.priority, this.tag, str);
        AppMethodBeat.o(17852);
    }

    public void append(StringBuilder sb) {
        AppMethodBeat.i(17853);
        if (shouldLog()) {
            this.contents.append((CharSequence) sb);
        }
        AppMethodBeat.o(17853);
    }

    public void append(String str) {
        AppMethodBeat.i(17854);
        if (shouldLog()) {
            this.contents.append(str);
        }
        AppMethodBeat.o(17854);
    }

    public void append(String str, Object... objArr) {
        AppMethodBeat.i(17855);
        if (shouldLog()) {
            this.contents.append(String.format(str, objArr));
        }
        AppMethodBeat.o(17855);
    }

    public void appendKeyValue(String str, Object obj) {
        AppMethodBeat.i(17856);
        append("  %s:\t%s\n", str, obj);
        AppMethodBeat.o(17856);
    }

    private boolean shouldLog() {
        AppMethodBeat.i(17857);
        boolean isLoggingBehaviorEnabled = FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
        AppMethodBeat.o(17857);
        return isLoggingBehaviorEnabled;
    }
}

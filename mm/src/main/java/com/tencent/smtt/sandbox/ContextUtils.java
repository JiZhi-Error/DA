package com.tencent.smtt.sandbox;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContextUtils {
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static void initApplicationContext(Context context) {
        AppMethodBeat.i(53785);
        if (sApplicationContext == null || sApplicationContext == context) {
            initJavaSideApplicationContext(context);
            AppMethodBeat.o(53785);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("Attempting to set multiple global application contexts.");
        AppMethodBeat.o(53785);
        throw runtimeException;
    }

    private static void initJavaSideApplicationContext(Context context) {
        AppMethodBeat.i(53786);
        if (context == null) {
            RuntimeException runtimeException = new RuntimeException("Global application context cannot be set to null.");
            AppMethodBeat.o(53786);
            throw runtimeException;
        }
        sApplicationContext = context;
        AppMethodBeat.o(53786);
    }
}

package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MMStack {
    private static final String TAG = "MicroMsg.Util.MMStack";

    public String toString() {
        AppMethodBeat.i(157710);
        String stack = getStack(true);
        AppMethodBeat.o(157710);
        return stack;
    }

    public static String getCaller() {
        AppMethodBeat.i(157711);
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 3) {
                AppMethodBeat.o(157711);
                return "";
            }
            String str = (stackTrace[2].getClassName().substring(15) + ":" + stackTrace[2].getMethodName()) + "(" + stackTrace[2].getLineNumber() + ")";
            AppMethodBeat.o(157711);
            return str;
        } catch (Throwable th) {
            Log.e(TAG, "getCaller e:%s", stackTraceToString(th));
            AppMethodBeat.o(157711);
            return "";
        }
    }

    public static String getStack(boolean z) {
        AppMethodBeat.i(230358);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            AppMethodBeat.o(230358);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 3; i2 < stackTrace.length; i2++) {
            if (stackTrace[i2].getClassName().contains("com.tencent.mm") && !stackTrace[i2].getClassName().contains("sdk.platformtools.Log")) {
                sb.append("[");
                sb.append(stackTrace[i2].getClassName().substring(15));
                sb.append(":");
                sb.append(stackTrace[i2].getMethodName());
                if (z) {
                    sb.append("(" + stackTrace[i2].getLineNumber() + ")]");
                } else {
                    sb.append("]");
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(230358);
        return sb2;
    }

    public static String stackTraceToString(Throwable th) {
        AppMethodBeat.i(157713);
        if (th == null) {
            AppMethodBeat.o(157713);
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            th.printStackTrace(printStream);
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            printStream.close();
            byteArrayOutputStream.close();
            AppMethodBeat.o(157713);
            return byteArrayOutputStream2;
        } catch (Exception e2) {
            AppMethodBeat.o(157713);
            return "";
        }
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.i(157714);
        if (stackTraceElementArr == null || stackTraceElementArr.length < 4) {
            AppMethodBeat.o(157714);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 3; i2 < stackTraceElementArr.length; i2++) {
            if (stackTraceElementArr[i2].getClassName().contains("com.tencent.mm") && !stackTraceElementArr[i2].getClassName().contains("sdk.platformtools.Log")) {
                sb.append("[");
                sb.append(stackTraceElementArr[i2].getClassName().substring(15));
                sb.append(":");
                sb.append(stackTraceElementArr[i2].getMethodName());
                sb.append("(" + stackTraceElementArr[i2].getLineNumber() + ")]");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(157714);
        return sb2;
    }
}

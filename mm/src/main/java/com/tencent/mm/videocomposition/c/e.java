package com.tencent.mm.videocomposition.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class e {
    public static String stackTraceToString(Throwable th) {
        AppMethodBeat.i(216715);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            th.printStackTrace(printStream);
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            printStream.close();
            byteArrayOutputStream.close();
            AppMethodBeat.o(216715);
            return byteArrayOutputStream2;
        } catch (Exception e2) {
            AppMethodBeat.o(216715);
            return "";
        }
    }

    public final String toString() {
        AppMethodBeat.i(216714);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            AppMethodBeat.o(216714);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 3; i2 < stackTrace.length; i2++) {
            if (stackTrace[i2].getClassName().contains("com.tencent.mm") && !stackTrace[i2].getClassName().contains("sdk.platformtools.Log")) {
                sb.append("[");
                sb.append(stackTrace[i2].getClassName().substring(15));
                sb.append(":");
                sb.append(stackTrace[i2].getMethodName());
                sb.append("(" + stackTrace[i2].getLineNumber() + ")]");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(216714);
        return sb2;
    }
}

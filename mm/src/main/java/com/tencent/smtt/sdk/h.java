package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread;

public class h implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.i(188240);
        if (th instanceof SQLiteException) {
            AppMethodBeat.o(188240);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(th);
        AppMethodBeat.o(188240);
        throw runtimeException;
    }
}

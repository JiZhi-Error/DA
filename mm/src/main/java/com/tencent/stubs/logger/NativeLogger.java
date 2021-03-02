package com.tencent.stubs.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

final class NativeLogger implements Log.Logger {
    private static final NativeLogger sInstance = new NativeLogger();

    @Override // com.tencent.stubs.logger.Log.Logger
    public final native boolean isLoggable(String str, int i2);

    @Override // com.tencent.stubs.logger.Log.Logger
    public final native void println(int i2, String str, String str2);

    NativeLogger() {
    }

    static {
        AppMethodBeat.i(4040);
        AppMethodBeat.o(4040);
    }

    private static void setLogger(long j2) {
        Log.sLoggerPtr = j2;
        Log.sLogger = sInstance;
    }
}

package com.tencent.stubs.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

final class AndroidLogcat implements Log.Logger {
    AndroidLogcat() {
    }

    @Override // com.tencent.stubs.logger.Log.Logger
    public final void println(int i2, String str, String str2) {
        AppMethodBeat.i(73495);
        android.util.Log.println(i2, str, str2);
        AppMethodBeat.o(73495);
    }

    @Override // com.tencent.stubs.logger.Log.Logger
    public final boolean isLoggable(String str, int i2) {
        AppMethodBeat.i(73496);
        boolean isLoggable = android.util.Log.isLoggable(str, i2);
        AppMethodBeat.o(73496);
        return isLoggable;
    }
}

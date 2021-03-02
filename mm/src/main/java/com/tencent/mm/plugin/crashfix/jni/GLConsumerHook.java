package com.tencent.mm.plugin.crashfix.jni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GLConsumerHook {
    public static native int hook();

    @Keep
    public static void report(long j2) {
        AppMethodBeat.i(145625);
        if (j2 == -1) {
            Log.i("MicroMsg.GLConsumerHook", "test succ");
            AppMethodBeat.o(145625);
        } else if (j2 == 0) {
            Log.e("MicroMsg.GLConsumerHook", "null pointer");
            AppMethodBeat.o(145625);
        } else {
            Log.i("MicroMsg.GLConsumerHook", "pointer addr " + Long.toHexString(j2));
            AppMethodBeat.o(145625);
        }
    }
}

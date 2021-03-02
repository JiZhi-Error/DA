package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JsInspector {
    private static a cMH;

    public interface a {
        int Ru();

        int Rv();
    }

    static native int JniNotify(long j2, long j3, String str);

    static native void JniReceiveData(long j2, String str);

    @Keep
    public static int jniCallbackSendData(long j2, String str) {
        AppMethodBeat.i(139987);
        if (cMH == null) {
            AppMethodBeat.o(139987);
            return -1;
        }
        int Ru = cMH.Ru();
        AppMethodBeat.o(139987);
        return Ru;
    }

    @Keep
    public static int jniCallbackNotify(long j2, long j3, String str) {
        AppMethodBeat.i(139988);
        if (cMH == null) {
            AppMethodBeat.o(139988);
            return -1;
        }
        int Rv = cMH.Rv();
        AppMethodBeat.o(139988);
        return Rv;
    }
}

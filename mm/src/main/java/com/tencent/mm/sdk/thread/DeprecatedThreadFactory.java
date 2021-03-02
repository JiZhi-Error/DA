package com.tencent.mm.sdk.thread;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class DeprecatedThreadFactory {
    private static final String TAG = "[D]";

    @Deprecated
    public static HandlerThread createHandlerThread(String str) {
        AppMethodBeat.i(182972);
        HandlerThread handlerThread = new HandlerThread("[D]#".concat(String.valueOf(str)));
        handlerThread.start();
        AppMethodBeat.o(182972);
        return handlerThread;
    }
}

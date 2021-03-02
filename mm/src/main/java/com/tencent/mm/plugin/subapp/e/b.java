package com.tencent.mm.plugin.subapp.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static void d(String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(29004);
        Log.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, result: %d", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        h.INSTANCE.a(14220, 0, 0, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i3 + i4), Integer.valueOf(i5), str);
        AppMethodBeat.o(29004);
    }
}

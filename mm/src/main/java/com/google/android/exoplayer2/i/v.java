package com.google.android.exoplayer2.i;

import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v {
    public static void beginSection(String str) {
        AppMethodBeat.i(93210);
        if (x.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
        AppMethodBeat.o(93210);
    }

    public static void endSection() {
        AppMethodBeat.i(93211);
        if (x.SDK_INT >= 18) {
            Trace.endSection();
        }
        AppMethodBeat.o(93211);
    }
}

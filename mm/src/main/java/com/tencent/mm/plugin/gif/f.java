package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    public final int[] ydT = new int[6];

    public f(String str) {
        AppMethodBeat.i(104654);
        try {
            MMGIFJNI.recycle(MMGIFJNI.openByFilePath(q.k(str, false), this.ydT));
            Log.i("MMGIFInfo", "width:%d height:%d", Integer.valueOf(this.ydT[0]), Integer.valueOf(this.ydT[1]));
            AppMethodBeat.o(104654);
        } catch (MMGIFException e2) {
            Log.e("MMGIFInfo", Util.stackTraceToString(e2));
            AppMethodBeat.o(104654);
        }
    }
}

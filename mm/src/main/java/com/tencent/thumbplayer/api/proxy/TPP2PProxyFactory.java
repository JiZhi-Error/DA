package com.tencent.thumbplayer.api.proxy;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.e.e;

public class TPP2PProxyFactory {
    public static ITPPreloadProxy createPreloadManager(Context context, int i2) {
        AppMethodBeat.i(189085);
        e eVar = new e(context, i2);
        AppMethodBeat.o(189085);
        return eVar;
    }
}

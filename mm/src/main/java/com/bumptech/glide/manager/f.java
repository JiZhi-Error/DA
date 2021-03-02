package com.bumptech.glide.manager;

import android.content.Context;
import android.support.v4.content.b;
import android.util.Log;
import com.bumptech.glide.manager.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f implements d {
    @Override // com.bumptech.glide.manager.d
    public final c a(Context context, c.a aVar) {
        AppMethodBeat.i(77552);
        boolean z = b.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        if (z) {
            e eVar = new e(context, aVar);
            AppMethodBeat.o(77552);
            return eVar;
        }
        j jVar = new j();
        AppMethodBeat.o(77552);
        return jVar;
    }
}

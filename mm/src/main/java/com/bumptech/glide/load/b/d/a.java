package com.bumptech.glide.load.b.d;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private final e aCj;
    private final h aCk;
    private final b aJD;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public a(h hVar, e eVar, b bVar) {
        AppMethodBeat.i(77198);
        this.aCk = hVar;
        this.aCj = eVar;
        this.aJD = bVar;
        AppMethodBeat.o(77198);
    }
}

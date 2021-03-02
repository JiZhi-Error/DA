package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends d {
    public a RaM;
    Looper mLooper;
    private String mType;

    private h(Looper looper, a aVar, String str) {
        this.mLooper = looper;
        this.RaM = aVar;
        this.mType = str;
    }

    public h(Handler handler, String str) {
        this(new b(handler), str);
        AppMethodBeat.i(74915);
        AppMethodBeat.o(74915);
    }

    public h(a aVar, String str) {
        this(aVar.getLooper(), aVar, str);
        AppMethodBeat.i(74916);
        AppMethodBeat.o(74916);
    }

    public h(Looper looper, String str) {
        this(new Handler(looper), str);
        AppMethodBeat.i(74917);
        AppMethodBeat.o(74917);
    }

    @Override // com.tencent.mm.vending.h.d
    public final String getType() {
        return this.mType;
    }

    @Override // com.tencent.mm.vending.h.d
    public final void cancel() {
        AppMethodBeat.i(74918);
        this.RaM.fS();
        AppMethodBeat.o(74918);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrange(Runnable runnable) {
        AppMethodBeat.i(74919);
        this.RaM.post(runnable);
        AppMethodBeat.o(74919);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrangeInterval(Runnable runnable, long j2) {
        AppMethodBeat.i(74920);
        if (j2 >= 0) {
            this.RaM.c(runnable, j2);
            AppMethodBeat.o(74920);
            return;
        }
        this.RaM.post(runnable);
        AppMethodBeat.o(74920);
    }
}

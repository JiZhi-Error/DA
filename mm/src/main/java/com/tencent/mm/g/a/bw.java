package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bw extends IEvent {
    public a dFg;

    public static final class a {
        public Context context;
        public String[] dBX;
        public String[] selectionArgs;
    }

    public bw() {
        this((byte) 0);
    }

    private bw(byte b2) {
        AppMethodBeat.i(19793);
        this.dFg = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19793);
    }
}

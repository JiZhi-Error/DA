package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cq extends IEvent {
    public a dFJ;

    public static final class a {
        public int action = 0;
        public Context context;
        public String[] dBX;
        public String[] selectionArgs;
    }

    public cq() {
        this((byte) 0);
    }

    private cq(byte b2) {
        AppMethodBeat.i(19794);
        this.dFJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19794);
    }
}

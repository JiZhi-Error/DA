package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fr extends IEvent {
    public a dIP;

    public static final class a {
        public Context context;
        public String[] dBX;
        public String dIQ;
        public int op = 0;
        public String[] selectionArgs;
        public int source = -1;
    }

    public fr() {
        this((byte) 0);
    }

    private fr(byte b2) {
        AppMethodBeat.i(19803);
        this.dIP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19803);
    }
}

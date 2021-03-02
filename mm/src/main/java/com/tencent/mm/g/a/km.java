package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class km extends IEvent {
    public a dPC;

    public static final class a {
        public Context context;
        public String[] dBX;
        public String[] selectionArgs;
    }

    public km() {
        this((byte) 0);
    }

    private km(byte b2) {
        AppMethodBeat.i(19813);
        this.dPC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19813);
    }
}

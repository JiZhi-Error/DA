package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tc extends IEvent {
    public a dZy;

    public static final class a {
        public Context context;
        public String[] dBX;
        public boolean dZz = false;
        public String[] selectionArgs;
    }

    public tc() {
        this((byte) 0);
    }

    private tc(byte b2) {
        AppMethodBeat.i(19832);
        this.dZy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19832);
    }
}

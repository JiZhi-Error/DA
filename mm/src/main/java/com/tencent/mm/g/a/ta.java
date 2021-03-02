package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ta extends IEvent {
    public a dZw;

    public static final class a {
        public Context context;
        public String[] dBX;
        public String[] selectionArgs;
    }

    public ta() {
        this((byte) 0);
    }

    private ta(byte b2) {
        AppMethodBeat.i(19830);
        this.dZw = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19830);
    }
}

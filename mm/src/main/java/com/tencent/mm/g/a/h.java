package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class h extends IEvent {
    public a dBW;

    public static final class a {
        public Context context;
        public String[] dBX;
        public String[] selectionArgs;
    }

    public h() {
        this((byte) 0);
    }

    private h(byte b2) {
        AppMethodBeat.i(19786);
        this.dBW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19786);
    }
}

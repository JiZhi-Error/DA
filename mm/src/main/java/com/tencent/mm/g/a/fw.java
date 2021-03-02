package com.tencent.mm.g.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fw extends IEvent {
    public a dJq;
    public b dJr;

    public static final class a {
        public String[] dJs;
    }

    public static final class b {
        public int dIY = 0;
        public MatrixCursor dJt;
    }

    public fw() {
        this((byte) 0);
    }

    private fw(byte b2) {
        AppMethodBeat.i(19806);
        this.dJq = new a();
        this.dJr = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19806);
    }
}

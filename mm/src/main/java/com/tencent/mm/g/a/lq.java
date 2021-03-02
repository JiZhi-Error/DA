package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class lq extends IEvent {
    public a dQX;
    public b dQY;

    public static final class a {
        public Context context;
        public ArrayList dQZ;
        public String dRa;
    }

    public static final class b {
    }

    public lq() {
        this((byte) 0);
    }

    private lq(byte b2) {
        AppMethodBeat.i(63290);
        this.dQX = new a();
        this.dQY = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(63290);
    }
}

package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class px extends IEvent {
    public a dVZ;
    public b dWa;

    public static final class a {
        public Context context;
        public String dWb;
        public int opType = 0;
    }

    public static final class b {
        public boolean dFE = false;
        public String dWc;
        public String thumbPath;
    }

    public px() {
        this((byte) 0);
    }

    private px(byte b2) {
        AppMethodBeat.i(117551);
        this.dVZ = new a();
        this.dWa = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117551);
    }
}

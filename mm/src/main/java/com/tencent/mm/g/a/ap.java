package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ap extends IEvent {
    public a dDt;
    public b dDu;

    public static final class a {
        public int action = 0;
        public Context context;
        public String dDv;
        public long dDw = 0;
        public boolean dDx = false;
        public Runnable dDy;
        public int fromScene = 0;
        public int offset = 0;
        public String title;
    }

    public static final class b {
        public boolean dDz = false;
    }

    public ap() {
        this((byte) 0);
    }

    private ap(byte b2) {
        AppMethodBeat.i(131616);
        this.dDt = new a();
        this.dDu = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(131616);
    }
}

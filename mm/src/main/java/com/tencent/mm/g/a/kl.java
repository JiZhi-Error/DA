package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kl extends IEvent {
    public a dPA;
    public b dPB;

    public static final class a {
        public Context context;
        public int enterScene = 0;
        public int scene = 0;
    }

    public static final class b {
        public String targetActivity;
    }

    public kl() {
        this((byte) 0);
    }

    private kl(byte b2) {
        AppMethodBeat.i(93325);
        this.dPA = new a();
        this.dPB = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(93325);
    }
}

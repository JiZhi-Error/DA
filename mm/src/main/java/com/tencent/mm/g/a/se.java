package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class se extends IEvent {
    public a dYI;
    public b dYJ;

    public static final class a {
        public Activity dKq;
        public String dYK;
        public String dYL;
        public String dYM;
        public String packageName;
        public int requestCode;
        public int scene;
    }

    public static final class b {
        public boolean dYN;
        public Bundle extras;
    }

    public se() {
        this((byte) 0);
    }

    private se(byte b2) {
        AppMethodBeat.i(149883);
        this.dYI = new a();
        this.dYJ = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149883);
    }
}

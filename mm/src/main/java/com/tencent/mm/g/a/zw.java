package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zw extends IEvent {
    public b egA;
    public a egz;

    public static final class a {
        public Activity activity;
        public int egB;
    }

    public zw() {
        this((byte) 0);
    }

    private zw(byte b2) {
        AppMethodBeat.i(153020);
        this.egz = new a();
        this.egA = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(153020);
    }

    public static final class b {
        public Object data = 0;

        public b() {
            AppMethodBeat.i(153019);
            AppMethodBeat.o(153019);
        }
    }
}

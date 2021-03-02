package com.tencent.mm.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class th extends IEvent {
    public a dZJ;

    public static final class a {
        public String cardType;
        public int dZK = 0;
        public String dZL;
        public Bitmap dZM;
    }

    public th() {
        this((byte) 0);
    }

    private th(byte b2) {
        AppMethodBeat.i(146077);
        this.dZJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(146077);
    }
}

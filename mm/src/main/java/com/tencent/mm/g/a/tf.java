package com.tencent.mm.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tf extends IEvent {
    public a dZF;

    public static final class a {
        public int action = 0;
        public String cardNum;
        public Bitmap dZG;
    }

    public tf() {
        this((byte) 0);
    }

    private tf(byte b2) {
        AppMethodBeat.i(146075);
        this.dZF = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(146075);
    }
}

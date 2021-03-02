package com.tencent.mm.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tg extends IEvent {
    public a dZH;

    public static final class a {
        public String cardId;
        public Bitmap dZI;
    }

    public tg() {
        this((byte) 0);
    }

    private tg(byte b2) {
        AppMethodBeat.i(146076);
        this.dZH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(146076);
    }
}

package com.tencent.mm.g.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.event.IEvent;

public final class lw extends IEvent {
    public a dRo;
    public b dRp;

    public static final class a {
        public q dGJ;
        public int dRq = 0;
        public String dRr;
        public float dRs = 0.0f;
        public int dRt = 0;
        public String filename;
        public int height = 0;
        public float latitude = 0.0f;
        public View view;
        public int width = 0;
    }

    public static final class b {
        public String path;
    }

    public lw() {
        this((byte) 0);
    }

    private lw(byte b2) {
        AppMethodBeat.i(127406);
        this.dRo = new a();
        this.dRp = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127406);
    }
}

package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class dg extends IEvent {
    public a dGm;
    public b dGn;

    public static final class a {
        public WeakReference aWF;
        public String appId;
        public Runnable callback;
        public String dGo;
        public String dGp;
        public String dGq;
        public String dmc;
        public String nonceStr;
        public String packageExt;
        public int payChannel = 0;
        public String signType;
        public String signature;
        public String token;
    }

    public static final class b {
        public int retCode = 0;
    }

    public dg() {
        this((byte) 0);
    }

    private dg(byte b2) {
        AppMethodBeat.i(130926);
        this.dGm = new a();
        this.dGn = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130926);
    }
}

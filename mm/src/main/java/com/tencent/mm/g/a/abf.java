package com.tencent.mm.g.a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abf extends IEvent {
    public a eiy;

    public static final class a {
        public CdnLogic.C2CDownloadResult eiz;
        public int event = 0;
    }

    public abf() {
        this((byte) 0);
    }

    private abf(byte b2) {
        AppMethodBeat.i(230552);
        this.eiy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(230552);
    }
}

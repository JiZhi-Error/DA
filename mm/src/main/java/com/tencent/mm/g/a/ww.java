package com.tencent.mm.g.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ww extends IEvent {
    public a edk;
    public b edl;

    public static final class a {
        public Activity dKq;
        public Intent edm;
        public int requestCode;
    }

    public static final class b {
        public boolean isSuccess;
    }

    public ww() {
        this((byte) 0);
    }

    private ww(byte b2) {
        AppMethodBeat.i(153018);
        this.edk = new a();
        this.edl = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(153018);
    }
}

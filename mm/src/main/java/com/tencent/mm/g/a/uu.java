package com.tencent.mm.g.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uu extends IEvent {
    public a ebc;

    public static final class a {
        public Context context;
        public String ebd;
        public DialogInterface.OnDismissListener ebe;
        public Bundle ebf;
    }

    public uu() {
        this((byte) 0);
    }

    private uu(byte b2) {
        AppMethodBeat.i(77798);
        this.ebc = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(77798);
    }
}

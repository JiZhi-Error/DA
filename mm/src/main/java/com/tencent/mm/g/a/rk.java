package com.tencent.mm.g.a;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rk extends IEvent {
    public a dXZ;

    public static final class a {
        public com.tencent.mm.pluginsdk.ui.a.a dYa;
        public EditText dYb;
    }

    public rk() {
        this((byte) 0);
    }

    private rk(byte b2) {
        AppMethodBeat.i(19827);
        this.dXZ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19827);
    }
}

package com.tencent.mm.g.a;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.event.IEvent;

public final class kk extends IEvent {
    public a dPw;

    public static final class a {
        public b dPx;
        public DialogInterface.OnClickListener dPy;
        public DialogInterface.OnClickListener dPz;
        public int type = 0;
    }

    public kk() {
        this((byte) 0);
    }

    private kk(byte b2) {
        AppMethodBeat.i(123714);
        this.dPw = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(123714);
    }
}

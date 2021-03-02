package com.tencent.mm.g.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.widget.snackbar.a;

public final class cz extends IEvent {
    public a dFZ;
    public b dGa;

    public static final class a {
        public Activity activity;
        public String dFN;
        public anb dGb;
        public anp dGc;
        public int dGd = 0;
        public int dGe = 0;
        public int dGf = 0;
        public DialogInterface.OnClickListener dGg;
        public a.c dGh;
        public boolean dGi = true;
        public String desc;
        public Fragment fragment;
        public int scene = 0;
        public String sessionId;
        public String title;
        public int type = 0;
    }

    public static final class b {
        public int ret = 0;
    }

    public cz() {
        this((byte) 0);
    }

    private cz(byte b2) {
        AppMethodBeat.i(127402);
        this.dFZ = new a();
        this.dGa = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127402);
    }
}

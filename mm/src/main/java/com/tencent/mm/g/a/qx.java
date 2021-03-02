package com.tencent.mm.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.Set;

public final class qx extends IEvent {
    public a dXu;

    public static final class a {
        public Bitmap bitmap;
        public long dDZ;
        public Set dXv;
        public boolean dXw;
        public int dXx;
        public String filePath;
    }

    public qx() {
        this((byte) 0);
    }

    private qx(byte b2) {
        AppMethodBeat.i(116040);
        this.dXu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116040);
    }
}

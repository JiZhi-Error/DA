package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class h {
    public int IXD;
    public int IXE;
    public int IXF;
    public final List<cfy> IXG;
    public int IXH;
    public long IXI;

    /* synthetic */ h(byte b2) {
        this();
    }

    public static final class a {
        private static final h IXJ = new h((byte) 0);

        static {
            AppMethodBeat.i(78861);
            AppMethodBeat.o(78861);
        }
    }

    private h() {
        AppMethodBeat.i(78862);
        this.IXD = 20480;
        this.IXE = 30720;
        this.IXF = 51200;
        this.IXG = new LinkedList();
        this.IXH = 0;
        this.IXI = 0;
        AppMethodBeat.o(78862);
    }

    public static void ii(List<cdi> list) {
        AppMethodBeat.i(78863);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(78863);
            return;
        }
        for (cdi cdi : list) {
            g.gdx().IXB.set(Integer.valueOf(cdi.Mjf), Long.valueOf(Util.nowSecond() + ((long) cdi.Mjg)));
        }
        g.gdx().gct();
        AppMethodBeat.o(78863);
    }
}

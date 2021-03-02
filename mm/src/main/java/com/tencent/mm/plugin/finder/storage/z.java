package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayr;
import kotlin.g.b.p;

public final class z {
    public static final int vEJ = 1;
    public static final int vEK = 2;
    public static final int vEL = 3;
    public static final a vEM = new a((byte) 0);
    public int qcr;
    public aa uNH;
    public o vEF;
    public FinderItem vEG;
    public long vEH;
    public final ayr vEI;

    public z(ayr ayr) {
        p.h(ayr, "viewItemPb");
        AppMethodBeat.i(251812);
        this.vEI = ayr;
        AppMethodBeat.o(251812);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251813);
        AppMethodBeat.o(251813);
    }
}

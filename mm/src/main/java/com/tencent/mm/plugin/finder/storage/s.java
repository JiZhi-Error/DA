package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.cj;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public final class s extends cj {
    private static final IAutoDBItem.MAutoDBInfo info = cj.ajs();
    public static final a vEi = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251799);
        AppMethodBeat.o(251799);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(251796);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "info");
        AppMethodBeat.o(251796);
        return mAutoDBInfo;
    }

    public final boolean dxN() {
        return this.field_giftType == 2;
    }

    public final boolean dxO() {
        AppMethodBeat.i(251797);
        boolean cW = d.cW(this.field_state, 1);
        AppMethodBeat.o(251797);
        return cW;
    }

    public final boolean dxP() {
        AppMethodBeat.i(251798);
        boolean cW = d.cW(this.field_state, 2);
        AppMethodBeat.o(251798);
        return cW;
    }

    public final void dxQ() {
        this.field_state &= -3;
    }
}

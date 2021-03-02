package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ck;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public final class u extends ck {
    private static final IAutoDBItem.MAutoDBInfo info;
    public static final a vEk = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251804);
        IAutoDBItem.MAutoDBInfo ajs = ck.ajs();
        p.g(ajs, "initAutoDBInfo(FinderLocalOperation::class.java)");
        info = ajs;
        AppMethodBeat.o(251804);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}

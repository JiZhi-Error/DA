package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public final class q extends ci {
    private static final IAutoDBItem.MAutoDBInfo info;
    public static final a vEf = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251789);
        IAutoDBItem.MAutoDBInfo ajs = ci.ajs();
        p.g(ajs, "initAutoDBInfo(FinderLiveConfig::class.java)");
        info = ajs;
        AppMethodBeat.o(251789);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}

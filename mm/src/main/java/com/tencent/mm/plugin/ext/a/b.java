package com.tencent.mm.plugin.ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.id;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public final class b extends id {
    private static final IAutoDBItem.MAutoDBInfo info = id.ajs();
    public static final a sMw = new a((byte) 0);

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(39598);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "info");
        AppMethodBeat.o(39598);
        return mAutoDBInfo;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(39599);
        AppMethodBeat.o(39599);
    }
}

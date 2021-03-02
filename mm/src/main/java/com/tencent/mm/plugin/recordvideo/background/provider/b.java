package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hu;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public final class b extends hu {
    public static final a BMF = new a((byte) 0);
    private static final String[] INDEX_CREATE = hu.INDEX_CREATE;
    private static final String TABLE = TABLE;
    private static final IAutoDBItem.MAutoDBInfo iBg = hu.ajs();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75340);
        AppMethodBeat.o(75340);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(75339);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = iBg;
        p.g(mAutoDBInfo, "INFO");
        AppMethodBeat.o(75339);
        return mAutoDBInfo;
    }
}

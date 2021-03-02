package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public class am extends cd {
    private static final IAutoDBItem.MAutoDBInfo info;
    private static final String vFq = vFq;
    private static final String vFr = vFr;
    public static final a vFs = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(167032);
        IAutoDBItem.MAutoDBInfo ajs = cd.ajs();
        p.g(ajs, "initAutoDBInfo(LocalFinderAction::class.java)");
        info = ajs;
        AppMethodBeat.o(167032);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}

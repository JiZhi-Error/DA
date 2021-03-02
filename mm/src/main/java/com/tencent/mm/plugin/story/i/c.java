package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gq;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public final class c extends gq {
    public static final a FvZ = new a((byte) 0);
    private static final IAutoDBItem.MAutoDBInfo info = gq.ajs();
    public String Foa = "";
    public String dRL = "";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119482);
        AppMethodBeat.o(119482);
    }

    public final void aSr(String str) {
        AppMethodBeat.i(119479);
        p.h(str, "<set-?>");
        this.dRL = str;
        AppMethodBeat.o(119479);
    }

    public final void aSd(String str) {
        AppMethodBeat.i(119480);
        p.h(str, "<set-?>");
        this.Foa = str;
        AppMethodBeat.o(119480);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(119481);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "info");
        AppMethodBeat.o(119481);
        return mAutoDBInfo;
    }
}

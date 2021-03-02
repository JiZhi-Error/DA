package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public final class ao extends cm {
    private static final String TABLEINDEXUSERNAME = TABLEINDEXUSERNAME;
    private static final IAutoDBItem.MAutoDBInfo info;
    public static final a vFu = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(167038);
        IAutoDBItem.MAutoDBInfo ajs = cm.ajs();
        p.g(ajs, "BaseFinderMention.initAu…inderMention::class.java)");
        info = ajs;
        AppMethodBeat.o(167038);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean isOverlap() {
        return (this.field_aggregatedContacts == null || this.field_aggregatedContacts.LII == 0) ? false : true;
    }

    public final int dym() {
        aym aym = this.field_aggregatedContacts;
        if (aym != null) {
            return aym.LII;
        }
        return 0;
    }
}

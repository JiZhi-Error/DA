package com.tencent.mm.plugin.gamelife.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.db;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;

public final class a extends db implements e {
    private static final IAutoDBItem.MAutoDBInfo info;
    public static final C1421a yct = new C1421a((byte) 0);

    /* renamed from: com.tencent.mm.plugin.gamelife.j.a$a */
    public static final class C1421a {
        private C1421a() {
        }

        public /* synthetic */ C1421a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241418);
        IAutoDBItem.MAutoDBInfo ajs = db.ajs();
        p.g(ajs, "initAutoDBInfo(GameLifeSessionInfo::class.java)");
        info = ajs;
        AppMethodBeat.o(241418);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.e
    public final String getSelfUsername() {
        AppMethodBeat.i(241414);
        String str = this.field_selfUserName;
        p.g(str, "field_selfUserName");
        AppMethodBeat.o(241414);
        return str;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.e
    public final String getSessionId() {
        AppMethodBeat.i(241415);
        String str = this.field_sessionId;
        p.g(str, "field_sessionId");
        AppMethodBeat.o(241415);
        return str;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.e
    public final String ajO() {
        AppMethodBeat.i(241416);
        String str = this.field_talker;
        p.g(str, "field_talker");
        AppMethodBeat.o(241416);
        return str;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.e
    public final c dXh() {
        return this.field_extInfo;
    }

    public final String toString() {
        AppMethodBeat.i(241417);
        String str = "GameLifeSessionInfo(self:" + this.field_selfUserName + " talker:" + this.field_talker + " sessionId:" + this.field_sessionId + ')';
        AppMethodBeat.o(241417);
        return str;
    }
}

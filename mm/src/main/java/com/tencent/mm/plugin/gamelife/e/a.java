package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.da;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.t;

public final class a extends da {
    private static final IAutoDBItem.MAutoDBInfo info;
    public static final C1417a ybW = new C1417a((byte) 0);
    String nickname;
    public CharSequence tyr;
    public com.tencent.mm.plugin.gamelife.d.a ybV;

    /* renamed from: com.tencent.mm.plugin.gamelife.e.a$a */
    public static final class C1417a {
        private C1417a() {
        }

        public /* synthetic */ C1417a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241340);
        IAutoDBItem.MAutoDBInfo ajs = da.ajs();
        p.g(ajs, "initAutoDBInfo(GameLifeConversation::class.java)");
        info = ajs;
        AppMethodBeat.o(241340);
    }

    public final long dXi() {
        AppMethodBeat.i(241335);
        if (dXj()) {
            AppMethodBeat.o(241335);
            return 103;
        }
        AppMethodBeat.o(241335);
        return 101;
    }

    public final boolean dXj() {
        AppMethodBeat.i(241336);
        boolean j2 = p.j(this.field_sessionId, "@gamelifehistory");
        AppMethodBeat.o(241336);
        return j2;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(241337);
        if (this == obj) {
            AppMethodBeat.o(241337);
            return true;
        }
        if (!p.j(getClass(), obj != null ? obj.getClass() : null)) {
            AppMethodBeat.o(241337);
            return false;
        } else if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.conversation.GameLifeConversation");
            AppMethodBeat.o(241337);
            throw tVar;
        } else if (!p.j(this.field_sessionId, ((a) obj).field_sessionId)) {
            AppMethodBeat.o(241337);
            return false;
        } else {
            AppMethodBeat.o(241337);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(241338);
        String str = this.field_sessionId;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(241338);
            return hashCode;
        }
        AppMethodBeat.o(241338);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(241339);
        String str = "GameLifeConversation(talker:" + this.field_talker + " sessionId:" + this.field_sessionId + " self:" + this.field_selfUserName + " nickname:" + this.nickname + ')';
        AppMethodBeat.o(241339);
        return str;
    }
}

package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.byp.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.e;
import kotlin.g.b.p;

public final class d extends e {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(b.info, "gamelifemessage"), "CREATE INDEX IF NOT EXISTS  gamelifemessageSvrIdIndex ON gamelifemessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerIndex ON gamelifemessage ( talker )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerStatusIndex ON gamelifemessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  gamelifemessageCreateTimeIndex ON gamelifemessage ( createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageCreateTalkerTimeIndex ON gamelifemessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageSendCreateTimeIndex ON gamelifemessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerTypeIndex ON gamelifemessage ( talker,type )"};
    public static final a yck = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(i iVar) {
        super(iVar);
        p.h(iVar, "storage");
        AppMethodBeat.i(241401);
        e(getDB(), "gamelifemessage");
        a(new i.b(1024, "gamelifemessage", i.b.a(4500001, 5000000, 208000001, 308000000)));
        AppMethodBeat.o(241401);
    }

    static {
        AppMethodBeat.i(241402);
        b.a aVar = b.pOW;
        AppMethodBeat.o(241402);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    @Override // com.tencent.mm.storage.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String avu(java.lang.String r5) {
        /*
            r4 = this;
            r2 = 0
            r3 = 241400(0x3aef8, float:3.38273E-40)
            r1 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            if (r5 == 0) goto L_0x0029
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0027
            r0 = r1
        L_0x0014:
            if (r0 != r1) goto L_0x0029
            r0 = r1
        L_0x0017:
            junit.framework.Assert.assertTrue(r0)
            boolean r0 = com.tencent.mm.storage.as.bju(r5)
            if (r0 == 0) goto L_0x002b
            java.lang.String r0 = "gamelifemessage"
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0026:
            return r0
        L_0x0027:
            r0 = r2
            goto L_0x0014
        L_0x0029:
            r0 = r2
            goto L_0x0017
        L_0x002b:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gamelife.g.d.avu(java.lang.String):java.lang.String");
    }
}

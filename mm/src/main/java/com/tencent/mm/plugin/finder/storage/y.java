package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.storage.e;
import com.tencent.sqlitelint.config.SharePluginInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "Lcom/tencent/mm/storage/AbstractMessageStorage;", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "(Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;)V", "recognizeTableByTalker", "", "talker", "Companion", "plugin-finder_release"})
public final class y extends e {
    public static final a vEE = new a((byte) 0);

    static {
        AppMethodBeat.i(251811);
        AppMethodBeat.o(251811);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(i iVar) {
        super(iVar);
        p.h(iVar, "storage");
        AppMethodBeat.i(251810);
        e(getDB(), "findermessage006");
        a(new i.b(512, "findermessage006", i.b.a(4000001, 4500000, 108000001, 208000000)));
        AppMethodBeat.o(251810);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage$Companion;", "", "()V", "TABLE_NAME", "", "TAG", "getSqlCreate", "", SharePluginInfo.ISSUE_KEY_TABLE, "(Ljava/lang/String;)[Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    @Override // com.tencent.mm.storage.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String avu(java.lang.String r5) {
        /*
            r4 = this;
            r2 = 0
            r3 = 251809(0x3d7a1, float:3.5286E-40)
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
            boolean r0 = com.tencent.mm.storage.as.avl(r5)
            if (r0 == 0) goto L_0x002b
            java.lang.String r0 = "findermessage006"
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.y.avu(java.lang.String):java.lang.String");
    }
}

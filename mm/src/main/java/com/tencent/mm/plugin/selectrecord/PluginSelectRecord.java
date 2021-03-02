package com.tencent.mm.plugin.selectrecord;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.selectrecord.d.b;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginSelectRecord extends f implements a, c, a {
    private static HashMap<Integer, h.b> baseDBFactories;
    private com.tencent.mm.plugin.selectrecord.c.a CWL = new com.tencent.mm.plugin.selectrecord.c.a();
    private b CWM = null;

    public PluginSelectRecord() {
        AppMethodBeat.i(187901);
        AppMethodBeat.o(187901);
    }

    static {
        AppMethodBeat.i(187906);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("SELECTRECORD_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.selectrecord.PluginSelectRecord.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(187906);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(187902);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("revokehistoryinjoinroommsg", this.CWL);
        AppMethodBeat.o(187902);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(187903);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("revokehistoryinjoinroommsg", this.CWL);
        AppMethodBeat.o(187903);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(187904);
        if (gVar.aBb()) {
            g.b(v.class, new com.tencent.mm.plugin.selectrecord.a.a());
        }
        AppMethodBeat.o(187904);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    public b getSelectRecordStorage() {
        AppMethodBeat.i(187905);
        g.aAf().azk();
        if (this.CWM == null) {
            g.aAi();
            this.CWM = new b(g.aAh().hqK);
        }
        b bVar = this.CWM;
        AppMethodBeat.o(187905);
        return bVar;
    }
}

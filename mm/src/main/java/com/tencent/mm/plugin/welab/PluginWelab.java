package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.welab.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginWelab extends f implements a, c, d, com.tencent.mm.plugin.welab.a.a {
    private b JFN = new b();
    private boolean JFO;

    public PluginWelab() {
        AppMethodBeat.i(146191);
        AppMethodBeat.o(146191);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(146192);
        alias(com.tencent.mm.plugin.welab.a.a.class);
        AppMethodBeat.o(146192);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(146193);
        dependsOn(s.class);
        AppMethodBeat.o(146193);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(146194);
        if (!gVar.aBb()) {
            AppMethodBeat.o(146194);
            return;
        }
        Log.v("PluginWelab", "configure");
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.d.class, new e(new c()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.b.a.class, new e(new b()));
        AppMethodBeat.o(146194);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(146195);
        Log.v("PluginWelab", "execute");
        AppMethodBeat.o(146195);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-welab";
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(146196);
        Log.v("PluginWelab", "onDataBaseOpened");
        a.gjg().JFR = new com.tencent.mm.plugin.welab.d.a(hVar);
        AppMethodBeat.o(146196);
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(146197);
        Log.v("PluginWelab", "onAccountInitialized");
        MMApplicationContext.getContext();
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
        this.JFO = cVar.hrc;
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("newabtestlabs", (cj.a) this.JFN, true);
        AppMethodBeat.o(146197);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(146198);
        Log.v("PluginWelab", "onAccountRelease");
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("newabtestlabs", this.JFN, true);
        AppMethodBeat.o(146198);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(146199);
        Log.v("PluginWelab", "collectDatabaseFactory");
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.welab.PluginWelab.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(198778);
                String[] strArr = {MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.welab.d.a.a.info, "LabAppInfo")};
                AppMethodBeat.o(198778);
                return strArr;
            }
        });
        AppMethodBeat.o(146199);
        return hashMap;
    }
}

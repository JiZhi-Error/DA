package com.tencent.mm.plugin.forcenotify;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginForceNotify extends f implements a, c, com.tencent.mm.plugin.forcenotify.a.c {
    public static HashMap<Integer, h.b> baseDBFactories = new HashMap<>();

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(149129);
        alias(com.tencent.mm.plugin.forcenotify.a.c.class);
        AppMethodBeat.o(149129);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(149130);
        dependsOn(s.class);
        AppMethodBeat.o(149130);
    }

    static {
        AppMethodBeat.i(149133);
        final String[] strArr = {MAutoStorage.getCreateSQLs(d.info, "ForceNotifyData")};
        baseDBFactories.put(Integer.valueOf("ForceNotifyData".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.forcenotify.PluginForceNotify.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return strArr;
            }
        });
        AppMethodBeat.o(149133);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(149131);
        Log.i("MicroMsg.PluginForceNotify", "[transformOldData] count:%s cost:%s", Integer.valueOf(com.tencent.mm.plugin.forcenotify.d.a.wLU.dMr()), Long.valueOf(SystemClock.uptimeMillis() - SystemClock.uptimeMillis()));
        com.tencent.mm.plugin.forcenotify.b.c.wLS.start();
        com.tencent.mm.kernel.g.b(b.class, com.tencent.mm.plugin.forcenotify.b.c.wLS);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.forcenotify.a.a.class, com.tencent.mm.plugin.forcenotify.b.b.wLO);
        AppMethodBeat.o(149131);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(149132);
        com.tencent.mm.plugin.forcenotify.b.c.wLS.release();
        com.tencent.mm.kernel.g.ag(b.class);
        AppMethodBeat.o(149132);
    }
}

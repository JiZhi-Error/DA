package com.tencent.mm.plugin.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.ai.f.b;
import com.tencent.mm.plugin.ai.f.d;
import com.tencent.mm.plugin.expt.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public class PluginAi extends f implements c, a {
    private static HashMap<Integer, h.b> kvw;
    private r.a kvx;

    static {
        AppMethodBeat.i(238855);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        kvw = hashMap;
        hashMap.put(Integer.valueOf("FINDERREDDOTHISTORY_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ai.PluginAi.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        kvw.put(Integer.valueOf("WechatAppHistory_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ai.PluginAi.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.ai.f.f.SQL_CREATE;
            }
        });
        AppMethodBeat.o(238855);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(238847);
        alias(a.class);
        AppMethodBeat.o(238847);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(238848);
        super.configure(gVar);
        if (gVar.aBb()) {
            y.b("aimodel", "aimodel", 7776000000L, 19);
        }
        AppMethodBeat.o(238848);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(238849);
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(a.class);
        }
        AppMethodBeat.o(238849);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(238850);
        Log.i("MicroMsg.PluginAi", "Plugin ai execute IAiService [%d]", Integer.valueOf(hashCode()));
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.ai.a.a.class, com.tencent.mm.plugin.ai.e.a.bqx());
        AppMethodBeat.o(238850);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-ai";
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(238851);
        Log.i("MicroMsg.PluginAi", "Plugin ai onAccountInitialized [%d]", Integer.valueOf(hashCode()));
        b bqC = b.bqC();
        Log.i("MicroMsg.AiStorageLogic", "init  [%s] [%s]", com.tencent.mm.kernel.g.aAh().cachePath, com.tencent.mm.kernel.g.aAh().hqG);
        bqC.kxM = com.tencent.mm.kernel.g.aAh().hqG + "aimodel/";
        bqC.kxN = bqC.kxM + "aifinder/";
        b.l(new String[]{bqC.kxM, bqC.kxN});
        initDB();
        com.tencent.mm.plugin.ai.e.a bqx = com.tencent.mm.plugin.ai.e.a.bqx();
        Log.i("MicroMsg.AiService", "AiService onAccountInitialized [%d]", Integer.valueOf(bqx.hashCode()));
        com.tencent.mm.plugin.ai.b.a.a.c bqt = com.tencent.mm.plugin.ai.b.a.a.c.bqt();
        Log.i("MicroMsg.AiFinderData", "register listener");
        EventCenter.instance.add(bqt.kvR);
        EventCenter.instance.add(bqt.kvS);
        EventCenter.instance.add(bqt.kvT);
        EventCenter.instance.add(bqt.kvU);
        EventCenter.instance.add(bqt.kvQ);
        EventCenter.instance.add(bqx.kxm);
        EventCenter.instance.add(bqx.kxn);
        com.tencent.mm.plugin.ai.b.a.b.a bqv = com.tencent.mm.plugin.ai.b.a.b.a.bqv();
        EventCenter.instance.add(bqv.kvR);
        EventCenter.instance.add(bqv.kvT);
        EventCenter.instance.add(bqv.kxn);
        AppMethodBeat.o(238851);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(238852);
        Log.i("MicroMsg.PluginAi", "Plugin ai onAccountRelease [%d]", Integer.valueOf(hashCode()));
        com.tencent.mm.plugin.ai.e.a bqx = com.tencent.mm.plugin.ai.e.a.bqx();
        Log.i("MicroMsg.AiService", "AiService onAccountRelease [%d]", Integer.valueOf(bqx.hashCode()));
        com.tencent.mm.plugin.ai.b.a.a.c bqt = com.tencent.mm.plugin.ai.b.a.a.c.bqt();
        Log.i("MicroMsg.AiFinderData", "unregister listener");
        EventCenter.instance.removeListener(bqt.kvR);
        EventCenter.instance.removeListener(bqt.kvS);
        EventCenter.instance.removeListener(bqt.kvT);
        EventCenter.instance.removeListener(bqt.kvU);
        EventCenter.instance.removeListener(bqt.kvQ);
        EventCenter.instance.removeListener(bqx.kxm);
        EventCenter.instance.removeListener(bqx.kxn);
        closeDB();
        com.tencent.mm.plugin.ai.b.a.b.a bqv = com.tencent.mm.plugin.ai.b.a.b.a.bqv();
        EventCenter.instance.removeListener(bqv.kvR);
        EventCenter.instance.removeListener(bqv.kvT);
        EventCenter.instance.removeListener(bqv.kxn);
        AppMethodBeat.o(238852);
    }

    private void initDB() {
        AppMethodBeat.i(238853);
        long currentTicks = Util.currentTicks();
        if (this.kvx != null) {
            closeDB();
        }
        this.kvx = r.a(hashCode(), com.tencent.mm.kernel.g.aAh().cachePath + "WxExptAi.db", kvw, true);
        b bqC = b.bqC();
        r.a aVar = this.kvx;
        if (aVar != null) {
            bqC.kxI = new d(aVar);
            bqC.kxJ = new com.tencent.mm.plugin.ai.f.f(aVar);
            bqC.kxK = new com.tencent.mm.plugin.ai.f.a();
        }
        Log.i("MicroMsg.PluginAi", "[%d] init DB finish cost[%d]", Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(238853);
    }

    private void closeDB() {
        AppMethodBeat.i(238854);
        if (this.kvx != null) {
            this.kvx.uS(hashCode());
        }
        this.kvx = null;
        AppMethodBeat.o(238854);
    }
}

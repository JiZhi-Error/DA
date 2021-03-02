package com.tencent.mm.plugin.expt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.expt.f.a;
import com.tencent.mm.plugin.expt.i.b;
import com.tencent.mm.plugin.expt.i.d;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginExpt extends f implements c, a {
    private static HashMap<Integer, h.b> kvw;
    private r.a kvx;

    static {
        AppMethodBeat.i(121796);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        kvw = hashMap;
        hashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.expt.PluginExpt.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        kvw.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.expt.PluginExpt.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        kvw.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.expt.PluginExpt.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.expt.roomexpt.b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(121796);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(121789);
        alias(a.class);
        AppMethodBeat.o(121789);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(121790);
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(s.class);
        }
        AppMethodBeat.o(121790);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        boolean z = false;
        AppMethodBeat.i(121791);
        saveUINToMMKV();
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.b.class, a.cRk());
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.cRz());
        }
        com.tencent.mm.kernel.g.b(e.class, com.tencent.mm.plugin.expt.g.d.cRu());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.c.class, com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.a.class, com.tencent.mm.plugin.expt.e.a.cRf());
        if (gVar.ca != null) {
            com.tencent.mm.plugin.expt.i.c.cSa();
            if (Util.getInt(com.tencent.mm.plugin.expt.i.c.c(b.a.clicfg_weixin_register_mm_life_call, ""), 0) > 0) {
                z = true;
            }
            if (z) {
                gVar.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.g.d.cRu());
            }
            gVar.ca.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.e.a.cRf());
        }
        com.tencent.mm.plugin.expt.hellhound.b.e(gVar);
        com.tencent.mm.plugin.expt.d.a.cMI();
        if (gVar.aBb()) {
            pin(com.tencent.mm.plugin.expt.d.b.b.cMS());
        }
        AppMethodBeat.o(121791);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-expt";
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        r.a aVar;
        boolean z = false;
        AppMethodBeat.i(121792);
        Log.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", Integer.valueOf(hashCode()), Integer.valueOf(a.cRk().hashCode()));
        saveUINToMMKV();
        initDB();
        a cRk = a.cRk();
        r.a aVar2 = this.kvx;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(cRk.hashCode());
        if (aVar2 != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.i("MicroMsg.ExptService", "reset DB [%d] dataDB[%b]", objArr);
        if (aVar2 != null) {
            cRk.sJX = new d(aVar2);
            cRk.sJY = new com.tencent.mm.plugin.expt.i.b(aVar2);
        }
        com.tencent.mm.plugin.expt.roomexpt.a.cRz().sKG = new com.tencent.mm.plugin.expt.roomexpt.b(this.kvx);
        com.tencent.mm.plugin.expt.d.a cMI = com.tencent.mm.plugin.expt.d.a.cMI();
        cMI.sxz = new com.tencent.mm.plugin.expt.d.b.a.a();
        cMI.sxA = new com.tencent.mm.plugin.expt.d.b.b.a();
        com.tencent.mm.plugin.expt.d.i.b bVar = cMI.sxv;
        if (bVar.syB != null) {
            bVar.syB.uS(bVar.hashCode());
        }
        bVar.syB = null;
        try {
            aVar = r.a(bVar.hashCode(), com.tencent.mm.kernel.g.aAh().cachePath + "Edge.db", new HashMap(), true);
        } catch (Exception e2) {
            Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] resetDB createDBInstance throw Exception : " + e2.getMessage());
            aVar = null;
        }
        if (aVar != null) {
            bVar.syB = aVar;
        }
        if (com.tencent.mm.plugin.expt.d.b.cML()) {
            cMI.sxB.removeMessages(1003);
            cMI.sxB.sendEmptyMessageDelayed(1003, 5000);
        }
        EventCenter.instance.add(com.tencent.mm.plugin.expt.j.a.cSe().gmC);
        AppMethodBeat.o(121792);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(121793);
        Log.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", Integer.valueOf(hashCode()), Integer.valueOf(a.cRk().hashCode()));
        com.tencent.mm.plugin.expt.d.i.b bVar = com.tencent.mm.plugin.expt.d.a.cMI().sxv;
        if (bVar.syB != null) {
            bVar.syB.uS(bVar.hashCode());
        }
        bVar.syB = null;
        resetUIN();
        closeDB();
        EventCenter.instance.removeListener(com.tencent.mm.plugin.expt.j.a.cSe().gmC);
        AppMethodBeat.o(121793);
    }

    private void initDB() {
        AppMethodBeat.i(121794);
        if (this.kvx != null) {
            closeDB();
        }
        this.kvx = r.a(hashCode(), com.tencent.mm.kernel.g.aAh().cachePath + "WxExpt.db", kvw, true);
        AppMethodBeat.o(121794);
    }

    private void closeDB() {
        AppMethodBeat.i(121795);
        if (this.kvx != null) {
            this.kvx.uS(hashCode());
        }
        this.kvx = null;
        a cRk = a.cRk();
        cRk.sJX = null;
        cRk.sJY = null;
        AppMethodBeat.o(121795);
    }

    private int getUIN() {
        int azs;
        AppMethodBeat.i(184289);
        if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.kernel.g.aAf();
            azs = com.tencent.mm.kernel.a.getUin();
        } else {
            azs = com.tencent.mm.kernel.a.azs();
        }
        AppMethodBeat.o(184289);
        return azs;
    }

    private void saveUINToMMKV() {
        boolean z;
        AppMethodBeat.i(184290);
        if (MMApplicationContext.isMainProcess()) {
            long currentTicks = Util.currentTicks();
            int uin = getUIN();
            if (uin != 0) {
                com.tencent.mm.plugin.expt.h.d.cRY();
                z = com.tencent.mm.plugin.expt.h.d.HB(uin);
            } else {
                z = false;
            }
            Log.i("MicroMsg.PluginExpt", "save uin to mmkv uin[%d] save[%b] cost[%d]", Integer.valueOf(uin), Boolean.valueOf(z), Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        AppMethodBeat.o(184290);
    }

    private void resetUIN() {
        AppMethodBeat.i(184291);
        if (MMApplicationContext.isMainProcess()) {
            long currentTicks = Util.currentTicks();
            com.tencent.mm.plugin.expt.h.d.cRY();
            Log.i("MicroMsg.PluginExpt", "reset uin to mmkv uin[%d] save[%b] cost[%d]", 0, Boolean.valueOf(com.tencent.mm.plugin.expt.h.d.HB(0)), Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        AppMethodBeat.o(184291);
    }
}

package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class e implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private ax yBQ;
    private d yBR = new d();

    public e() {
        AppMethodBeat.i(26136);
        AppMethodBeat.o(26136);
    }

    static {
        AppMethodBeat.i(26141);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.label.e.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ax.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.label.e.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return aw.SQL_CREATE;
            }
        });
        AppMethodBeat.o(26141);
    }

    private static e ece() {
        AppMethodBeat.i(26137);
        bg.aVz();
        e eVar = (e) cg.KG("plugin.label");
        if (eVar == null) {
            synchronized (e.class) {
                if (eVar == null) {
                    try {
                        eVar = new e();
                        bg.aVz().a("plugin.label", eVar);
                    } catch (Throwable th) {
                        AppMethodBeat.o(26137);
                        throw th;
                    }
                }
            }
        }
        AppMethodBeat.o(26137);
        return eVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(26138);
        b bVar = new b();
        a.yBS = bVar;
        b.jcc = bVar;
        EventCenter.instance.addListener(this.yBR);
        AppMethodBeat.o(26138);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(26139);
        a.yBS = null;
        EventCenter.instance.removeListener(this.yBR);
        AppMethodBeat.o(26139);
    }

    public static ax ecf() {
        AppMethodBeat.i(26140);
        g.aAf().azk();
        if (ece().yBQ == null) {
            e ece = ece();
            bg.aVF();
            ece.yBQ = new ax(c.getDataDB());
        }
        ax axVar = ece().yBQ;
        AppMethodBeat.o(26140);
        return axVar;
    }
}

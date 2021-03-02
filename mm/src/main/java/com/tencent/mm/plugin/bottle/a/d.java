package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class d implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private bw.a iDJ = new bw.a() {
        /* class com.tencent.mm.plugin.bottle.a.d.AnonymousClass2 */

        @Override // com.tencent.mm.storage.bw.a
        public final void a(az azVar, bw bwVar) {
            AppMethodBeat.i(22648);
            if (azVar == null) {
                AppMethodBeat.o(22648);
            } else if ("_USER_FOR_THROWBOTTLE_".equals(azVar.field_username)) {
                azVar.setUsername("");
                AppMethodBeat.o(22648);
            } else {
                if (1 != azVar.field_isSend && as.IG(azVar.field_username) && !bwVar.ayk(azVar.field_username)) {
                    c.ahm(azVar.field_username);
                }
                AppMethodBeat.o(22648);
            }
        }
    };
    private b pkW;

    public d() {
        AppMethodBeat.i(22649);
        AppMethodBeat.o(22649);
    }

    private static d ckT() {
        AppMethodBeat.i(22650);
        bg.aVz();
        d dVar = (d) cg.KG("plugin.bottle");
        if (dVar == null) {
            dVar = new d();
            bg.aVz().a("plugin.bottle", dVar);
        }
        AppMethodBeat.o(22650);
        return dVar;
    }

    public static b ckU() {
        AppMethodBeat.i(22651);
        g.aAf().azk();
        if (ckT().pkW == null) {
            d ckT = ckT();
            bg.aVF();
            ckT.pkW = new b(c.getDataDB());
        }
        b bVar = ckT().pkW;
        AppMethodBeat.o(22651);
        return bVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(22652);
        bg.aVF();
        c.aST().d(this.iDJ);
        AppMethodBeat.o(22652);
    }

    static {
        AppMethodBeat.i(22654);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.bottle.a.d.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(22654);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(22653);
        c.ckS();
        bg.aVF();
        c.aST().c(this.iDJ);
        AppMethodBeat.o(22653);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }
}

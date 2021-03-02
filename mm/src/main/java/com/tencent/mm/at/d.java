package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.subapp.a;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class d implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private b iWE;
    private af iWF;

    private static d bcl() {
        d dVar;
        AppMethodBeat.i(20534);
        bg.aVz();
        a aVar = (a) cg.KG("plugin.subapp");
        d dVar2 = aVar == null ? null : (d) aVar.aSI(d.class.getName());
        if (dVar2 == null) {
            d dVar3 = new d();
            aVar.b(d.class.getName(), dVar3);
            dVar = dVar3;
        } else {
            dVar = dVar2;
        }
        AppMethodBeat.o(20534);
        return dVar;
    }

    public static b bcm() {
        AppMethodBeat.i(20535);
        g.aAf().azk();
        if (bcl().iWE == null) {
            d bcl = bcl();
            bg.aVF();
            bcl.iWE = new b(c.getDataDB());
        }
        b bVar = bcl().iWE;
        AppMethodBeat.o(20535);
        return bVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
    }

    static {
        AppMethodBeat.i(20537);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.at.d.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(20537);
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
        AppMethodBeat.i(20536);
        if (this.iWF == null) {
            this.iWF = new af(new c());
        }
        ay.a.iDq = this.iWF;
        Log.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", this.iWF);
        g.b(i.class, new com.tencent.mm.pluginsdk.ui.applet.c());
        g.b(j.class, new p());
        AppMethodBeat.o(20536);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }
}

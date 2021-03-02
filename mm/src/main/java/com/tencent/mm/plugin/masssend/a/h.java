package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class h implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private cj.a zjF = new cj.a() {
        /* class com.tencent.mm.plugin.masssend.a.h.AnonymousClass2 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(26365);
            String a2 = z.a(aVar.heO.KHn);
            Log.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(a2)));
            h.ehG().aDM(a2);
            h.ehG().ehB();
            h.ehG();
            c.Ha(Util.nowMilliSecond());
            AppMethodBeat.o(26365);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private b znv;
    private c znw;
    private i znx = new i();
    private g zny = new g();

    public h() {
        AppMethodBeat.i(26366);
        AppMethodBeat.o(26366);
    }

    private static h ehE() {
        AppMethodBeat.i(26367);
        bg.aVz();
        h hVar = (h) cg.KG("plugin.masssend");
        if (hVar == null) {
            hVar = new h();
            bg.aVz().a("plugin.favorite", hVar);
        }
        AppMethodBeat.o(26367);
        return hVar;
    }

    public static b ehF() {
        AppMethodBeat.i(26368);
        g.aAf().azk();
        if (ehE().znv == null) {
            h ehE = ehE();
            bg.aVF();
            ehE.znv = new b(c.getDataDB());
        }
        b bVar = ehE().znv;
        AppMethodBeat.o(26368);
        return bVar;
    }

    public static c ehG() {
        AppMethodBeat.i(26369);
        if (ehE().znw == null) {
            ehE().znw = new c();
        }
        c cVar = ehE().znw;
        AppMethodBeat.o(26369);
        return cVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(26370);
        bg.getSysCmdMsgExtension().b("masssendapp", this.zjF, false);
        EventCenter.instance.removeListener(this.znx);
        EventCenter.instance.removeListener(this.zny);
        AppMethodBeat.o(26370);
    }

    static {
        AppMethodBeat.i(26372);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.masssend.a.h.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(26372);
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
        AppMethodBeat.i(26371);
        bg.getSysCmdMsgExtension().a("masssendapp", this.zjF, false);
        EventCenter.instance.addListener(this.znx);
        EventCenter.instance.addListener(this.zny);
        AppMethodBeat.o(26371);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }
}

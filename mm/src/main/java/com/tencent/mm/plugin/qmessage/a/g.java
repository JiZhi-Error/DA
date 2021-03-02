package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class g implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private e Bqn;
    private f Bqo = new f();
    private a Bqp = new a();
    private b Bqq = new b();

    public g() {
        AppMethodBeat.i(27727);
        AppMethodBeat.o(27727);
    }

    private static g eFY() {
        AppMethodBeat.i(27728);
        bg.aVz();
        g gVar = (g) cg.KG("plugin.qmessage");
        if (gVar == null) {
            gVar = new g();
            bg.aVz().a("plugin.qmessage", gVar);
        }
        AppMethodBeat.o(27728);
        return gVar;
    }

    public static e eFZ() {
        AppMethodBeat.i(27729);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eFY().Bqn == null) {
            g eFY = eFY();
            bg.aVF();
            eFY.Bqn = new e(c.getDataDB());
        }
        e eVar = eFY().Bqn;
        AppMethodBeat.o(27729);
        return eVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(27730);
        h.d.b(36, this.Bqo);
        h.d.b(39, this.Bqo);
        EventCenter.instance.removeListener(this.Bqp);
        EventCenter.instance.removeListener(this.Bqq);
        AppMethodBeat.o(27730);
    }

    static {
        AppMethodBeat.i(27735);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.qmessage.a.g.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        AppMethodBeat.o(27735);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
        AppMethodBeat.i(27731);
        Log.d("MicroMsg.SubCoreQMsg", "clear plugin");
        if ((i2 & 32) != 0) {
            eGb();
        }
        AppMethodBeat.o(27731);
    }

    public static void eGa() {
        String str;
        AppMethodBeat.i(27732);
        bg.aVF();
        if (c.aST().bjY("qmessage") == null) {
            az azVar = new az();
            azVar.setUsername("qmessage");
            azVar.setContent("");
            azVar.yA(Util.nowMilliSecond());
            azVar.nv(0);
            azVar.nt(0);
            bg.aVF();
            c.aST().e(azVar);
            AppMethodBeat.o(27732);
            return;
        }
        bg.aVF();
        ca aEx = c.aSQ().aEx("qmessage");
        az azVar2 = new az();
        azVar2.setUsername("qmessage");
        if (aEx == null) {
            str = "";
        } else {
            str = aEx.field_content;
        }
        azVar2.setContent(str);
        azVar2.yA(Util.nowMilliSecond());
        azVar2.nv(0);
        azVar2.nt(0);
        bg.aVF();
        c.aST().a(azVar2, "qmessage");
        AppMethodBeat.o(27732);
    }

    public static void eGb() {
        AppMethodBeat.i(27733);
        bp.aVS();
        bg.aVF();
        c.aST().bjX("@qqim");
        bg.aVF();
        c.aST().bjW("qmessage");
        AppMethodBeat.o(27733);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(27734);
        h.d.a(36, this.Bqo);
        h.d.a(39, this.Bqo);
        EventCenter.instance.addListener(this.Bqp);
        EventCenter.instance.addListener(this.Bqq);
        AppMethodBeat.o(27734);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }
}

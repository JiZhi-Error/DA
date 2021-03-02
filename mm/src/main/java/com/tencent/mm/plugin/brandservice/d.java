package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.brandservice.b.o;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class d implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private a pmK;
    private b pmL;

    private static d clo() {
        AppMethodBeat.i(5558);
        d dVar = (d) y.at(d.class);
        AppMethodBeat.o(5558);
        return dVar;
    }

    static {
        AppMethodBeat.i(5562);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.brandservice.d.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.iBh;
            }
        });
        AppMethodBeat.o(5562);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(5559);
        Log.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
        if (this.pmK == null) {
            this.pmK = new a();
        }
        EventCenter.instance.addListener(this.pmK);
        ((n) g.ah(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.brandservice.ui.a.d());
        ((n) g.ah(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.brandservice.ui.a.b());
        AppMethodBeat.o(5559);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(5560);
        if (this.pmK != null) {
            EventCenter.instance.removeListener(this.pmK);
        }
        ((n) g.ah(n.class)).unregisterFTSUILogic(96);
        ((n) g.ah(n.class)).unregisterFTSUILogic(4208);
        AppMethodBeat.o(5560);
    }

    public static class a extends IListener<uk> {
        public a() {
            AppMethodBeat.i(160481);
            this.__eventId = uk.class.getName().hashCode();
            AppMethodBeat.o(160481);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uk ukVar) {
            AppMethodBeat.i(5557);
            uk ukVar2 = ukVar;
            if (!(ukVar2 instanceof uk)) {
                Log.f("MicroMsg.BrandService.SubCoreBrandService", "mismatched event");
                AppMethodBeat.o(5557);
                return false;
            }
            if (!(ukVar2.eaK == null || Util.isNullOrNil(ukVar2.eaK.dYs) || ukVar2.eaK.eaL == null)) {
                o oVar = new o(ukVar2.eaK.dYs, ukVar2.eaK.eaL);
                g.aAi();
                g.azz().a(oVar, 0);
            }
            AppMethodBeat.o(5557);
            return true;
        }
    }

    public static b clp() {
        AppMethodBeat.i(5561);
        g.aAf().azk();
        if (clo().pmL == null) {
            clo().pmL = new b(g.aAh().hqK);
        }
        b bVar = clo().pmL;
        AppMethodBeat.o(5561);
        return bVar;
    }
}

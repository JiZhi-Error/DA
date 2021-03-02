package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.wear.model.e.c;
import com.tencent.mm.plugin.wear.model.e.d;
import com.tencent.mm.plugin.wear.model.e.e;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.g;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g.b;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class a implements bd {
    private static boolean Ixy = false;
    private q Ixn;
    private r Ixo;
    private d Ixp;
    private e Ixq;
    private g Ixr;
    private b Ixs;
    private WearMessageLogic Ixt;
    private i Ixu;
    private j Ixv;
    private com.tencent.mm.plugin.wear.model.g.a Ixw;
    private h Ixx;

    public a() {
        AppMethodBeat.i(29952);
        Log.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", getClass().getClassLoader());
        AppMethodBeat.o(29952);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    private static a fVJ() {
        AppMethodBeat.i(29953);
        bg.aVz();
        a aVar = (a) cg.KG("plugin.wear");
        if (aVar == null) {
            aVar = new a();
            bg.aVz().a("plugin.wear", aVar);
        }
        AppMethodBeat.o(29953);
        return aVar;
    }

    public static g fVK() {
        AppMethodBeat.i(29954);
        if (fVJ().Ixr == null) {
            fVJ().Ixr = new g();
        }
        g gVar = fVJ().Ixr;
        AppMethodBeat.o(29954);
        return gVar;
    }

    public static b fVL() {
        AppMethodBeat.i(29955);
        b bVar = fVJ().Ixs;
        AppMethodBeat.o(29955);
        return bVar;
    }

    public static d fVM() {
        AppMethodBeat.i(29956);
        d dVar = fVJ().Ixp;
        AppMethodBeat.o(29956);
        return dVar;
    }

    public static j fVN() {
        AppMethodBeat.i(29957);
        j jVar = fVJ().Ixv;
        AppMethodBeat.o(29957);
        return jVar;
    }

    public static com.tencent.mm.plugin.wear.model.g.a fVO() {
        AppMethodBeat.i(29958);
        com.tencent.mm.plugin.wear.model.g.a aVar = fVJ().Ixw;
        AppMethodBeat.o(29958);
        return aVar;
    }

    public static q fVP() {
        AppMethodBeat.i(29959);
        q qVar = fVJ().Ixn;
        AppMethodBeat.o(29959);
        return qVar;
    }

    public static r fVQ() {
        AppMethodBeat.i(29960);
        r rVar = fVJ().Ixo;
        AppMethodBeat.o(29960);
        return rVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
        AppMethodBeat.i(29961);
        Log.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", Integer.valueOf(i2));
        AppMethodBeat.o(29961);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(29962);
        o.e.JSY = new c();
        Log.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", Boolean.valueOf(z));
        this.Ixn = new q();
        this.Ixo = new r();
        this.Ixv = new j();
        this.Ixq = new e();
        this.Ixr = new g();
        this.Ixs = new b();
        this.Ixp = new d();
        this.Ixt = new WearMessageLogic();
        this.Ixu = new i();
        this.Ixw = new com.tencent.mm.plugin.wear.model.g.a();
        this.Ixx = new b();
        h.d.a(63, this.Ixx);
        this.Ixn.a(this.Ixp.IxG);
        this.Ixn.a(this.Ixp.IxH);
        this.Ixn.a(this.Ixp.IxI);
        this.Ixn.a(new com.tencent.mm.plugin.wear.model.e.h());
        this.Ixn.a(new g());
        this.Ixn.a(new d());
        this.Ixn.a(new c());
        this.Ixn.a(new e());
        this.Ixn.a(new f());
        this.Ixn.a(new k());
        this.Ixn.a(new m());
        this.Ixn.a(new com.tencent.mm.plugin.wear.model.e.o());
        this.Ixn.a(new n());
        this.Ixn.a(new l());
        this.Ixv.a(new com.tencent.mm.plugin.wear.model.f.c() {
            /* class com.tencent.mm.plugin.wear.model.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wear.model.f.c
            public final void send() {
                AppMethodBeat.i(29950);
                r unused = a.this.Ixo;
                r.a(20001, null, false);
                r unused2 = a.this.Ixo;
                r.a(20008, null, false);
                AppMethodBeat.o(29950);
            }

            @Override // com.tencent.mm.plugin.wear.model.f.d
            public final String getName() {
                return "PhoneStartTask";
            }
        });
        j jVar = this.Ixv;
        AnonymousClass2 r1 = new com.tencent.mm.plugin.wear.model.f.c() {
            /* class com.tencent.mm.plugin.wear.model.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.wear.model.f.c
            public final void send() {
                AppMethodBeat.i(29951);
                if (a.this.Ixp.fVX() != null) {
                    a.this.Ixp.fVX().fWd();
                }
                r unused = a.this.Ixo;
                r.a(20009, null, false);
                r unused2 = a.this.Ixo;
                r.a(20017, null, false);
                AppMethodBeat.o(29951);
            }

            @Override // com.tencent.mm.plugin.wear.model.f.d
            public final String getName() {
                return "SyncFileTask";
            }
        };
        if (jVar.ndA != null) {
            jVar.ndA.sendMessageDelayed(jVar.ndA.obtainMessage(0, r1), 5000);
        }
        AppMethodBeat.o(29962);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
        AppMethodBeat.i(29963);
        Log.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", Boolean.valueOf(z));
        AppMethodBeat.o(29963);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(29964);
        h.d.b(63, this.Ixx);
        this.Ixx = null;
        Log.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
        this.Ixn.IyG.clear();
        this.Ixn = null;
        this.Ixo = null;
        e eVar = this.Ixq;
        eVar.cve.stopTimer();
        eVar.ELJ.dead();
        eVar.IxL.dead();
        eVar.IxM.dead();
        eVar.ndY.dead();
        eVar.IxN.dead();
        eVar.IxO.dead();
        eVar.IxP.dead();
        eVar.gnH.dead();
        eVar.yYb.dead();
        bg.aVF();
        com.tencent.mm.model.c.aSQ().a(eVar.sMj);
        this.Ixq = null;
        this.Ixr = null;
        b bVar = this.Ixs;
        EventCenter.instance.removeListener(bVar.IxB);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(bVar.wYc);
        bVar.IxC.stopTimer();
        this.Ixs = null;
        d dVar = this.Ixp;
        dVar.IxF.finish();
        dVar.IxJ.reset();
        this.Ixp = null;
        MMApplicationContext.getContext().unregisterReceiver(this.Ixt);
        this.Ixt = null;
        this.Ixv.ndA.quit();
        this.Ixv = null;
        i iVar = this.Ixu;
        iVar.audioManager = null;
        iVar.fVY();
        MMApplicationContext.getContext().unregisterReceiver(iVar.Iyh);
        this.Ixu = null;
        Ixy = false;
        AppMethodBeat.o(29964);
    }

    public static void fVR() {
        Ixy = true;
    }
}

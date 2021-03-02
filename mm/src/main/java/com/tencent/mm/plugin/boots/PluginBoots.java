package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.br;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public class PluginBoots extends f implements com.tencent.mm.kernel.api.bucket.a, d, c, com.tencent.mm.plugin.boots.a.d {
    private com.tencent.mm.plugin.boots.b.a pkj;
    private com.tencent.mm.plugin.hp.b.c pkk = new com.tencent.mm.plugin.hp.b.c();
    private IListener<br> pkl = new IListener<br>() {
        /* class com.tencent.mm.plugin.boots.PluginBoots.AnonymousClass1 */

        {
            AppMethodBeat.i(161178);
            this.__eventId = br.class.getName().hashCode();
            AppMethodBeat.o(161178);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(br brVar) {
            AppMethodBeat.i(117359);
            br brVar2 = brVar;
            if (29 == brVar2.dEV.dEO && brVar2.dEV.dDe == 0) {
                Log.d("MicroMsg.Boots.PluginBoots", "hp_res received new hotpatch cache request");
                b.Mg(0);
            }
            AppMethodBeat.o(117359);
            return false;
        }
    };
    private IListener<bp> pkm = new IListener<bp>() {
        /* class com.tencent.mm.plugin.boots.PluginBoots.AnonymousClass2 */

        {
            AppMethodBeat.i(161179);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(161179);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(117360);
            bp bpVar2 = bpVar;
            if (29 == bpVar2.dEN.dEO && bpVar2.dEN.dEQ) {
                Log.d("MicroMsg.Boots.PluginBoots", "hp_res received new/updated download resource, path=%s", bpVar2.dEN.filePath);
                b.OP(0);
                com.tencent.mm.plugin.hp.b.c unused = PluginBoots.this.pkk;
                com.tencent.mm.plugin.hp.b.c.aBG(bpVar2.dEN.filePath);
            }
            AppMethodBeat.o(117360);
            return false;
        }
    };

    public PluginBoots() {
        AppMethodBeat.i(117361);
        AppMethodBeat.o(117361);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-boots";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(117362);
        Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots installed");
        alias(com.tencent.mm.plugin.boots.a.d.class);
        AppMethodBeat.o(117362);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void uninstalled() {
        AppMethodBeat.i(117363);
        Log.d("MicroMsg.Boots.PluginBoots", "uninstalled");
        super.uninstalled();
        AppMethodBeat.o(117363);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(117364);
        Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots dependency");
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        AppMethodBeat.o(117364);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(117365);
        y.b("HotPatchDownload", "WebNetFile", 2592000000L, com.tencent.mm.plugin.appbrand.jsapi.openvoice.a.CTRL_INDEX);
        super.configure(gVar);
        AppMethodBeat.o(117365);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(117366);
        Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots execute %s", gVar.mProcessName);
        if (com.tencent.mm.plugin.boots.b.a.pkM == null) {
            com.tencent.mm.plugin.boots.b.a.pkM = new com.tencent.mm.plugin.boots.b.a();
        }
        this.pkj = com.tencent.mm.plugin.boots.b.a.pkM;
        if (gVar.aBb() || gVar.FY(":patch")) {
            e.dZm();
            e.b(com.tencent.mm.app.d.dks);
            EventCenter.instance.addListener(this.pkk);
            EventCenter.instance.addListener(this.pkm);
            EventCenter.instance.addListener(this.pkl);
        }
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
        }
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.boots.a.c.class, new com.tencent.mm.kernel.c.e(new a()));
        }
        if (gVar.aBb()) {
            com.tencent.mm.plugin.hp.c.a.dZf();
        }
        AppMethodBeat.o(117366);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(117367);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("ACTIVE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.boots.PluginBoots.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.boots.b.a.a.SQL_CREATE;
            }
        });
        AppMethodBeat.o(117367);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(117368);
        Log.d("MicroMsg.Boots.PluginBoots", "[cpan] boots onDataBaseOpened");
        if (this.pkj != null) {
            this.pkj.pkN = new com.tencent.mm.plugin.boots.b.a.a(hVar);
        }
        AppMethodBeat.o(117368);
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.plugin.boots.a.d
    public com.tencent.mm.plugin.boots.a.e getTinkerLogic() {
        return this.pkj;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    static final class a extends com.tencent.mm.model.y implements com.tencent.mm.kernel.a.b.b {
        a() {
            super(com.tencent.mm.plugin.hp.b.d.class);
        }

        @Override // com.tencent.mm.kernel.a.b.b
        public final void parallelsDependency() {
        }
    }
}

package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.openim.b.r;
import com.tencent.mm.openim.b.t;
import com.tencent.mm.openim.e.b;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.HashMap;

public class PluginOpenIM extends f implements a, c {
    public static HashMap<Integer, h.b> baseDBFactories;
    private i gNh = new i() {
        /* class com.tencent.mm.openim.PluginOpenIM.AnonymousClass3 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(151167);
            if (qVar instanceof j) {
                oz ozVar = new oz();
                ozVar.dUZ.dVa = ((j) qVar).dVa;
                EventCenter.instance.publish(ozVar);
            }
            AppMethodBeat.o(151167);
        }
    };
    private IListener jGM = new IListener<oy>() {
        /* class com.tencent.mm.openim.PluginOpenIM.AnonymousClass1 */

        {
            AppMethodBeat.i(161785);
            this.__eventId = oy.class.getName().hashCode();
            AppMethodBeat.o(161785);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(oy oyVar) {
            AppMethodBeat.i(151165);
            g.aAi();
            g.aAg().hqi.a(new r(), 0);
            AppMethodBeat.o(151165);
            return true;
        }
    };
    private IListener jGN = new IListener<jz>() {
        /* class com.tencent.mm.openim.PluginOpenIM.AnonymousClass2 */

        {
            AppMethodBeat.i(161786);
            this.__eventId = jz.class.getName().hashCode();
            AppMethodBeat.o(161786);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jz jzVar) {
            AppMethodBeat.i(151166);
            String str = jzVar.dOT.userName;
            g.aAi();
            g.aAg().hqi.a(new j(str), 0);
            AppMethodBeat.o(151166);
            return true;
        }
    };
    private d jGO;
    private b jGP;
    private com.tencent.mm.openim.e.f jGQ;

    public PluginOpenIM() {
        AppMethodBeat.i(151168);
        AppMethodBeat.o(151168);
    }

    public d getAppIdInfoStg() {
        AppMethodBeat.i(151169);
        g.aAf().azk();
        if (this.jGP == null) {
            g.aAi();
            this.jGO = new d(g.aAh().hqK);
        }
        d dVar = this.jGO;
        AppMethodBeat.o(151169);
        return dVar;
    }

    public b getAccTypeInfoStg() {
        AppMethodBeat.i(151170);
        g.aAf().azk();
        if (this.jGP == null) {
            g.aAi();
            this.jGP = new b(g.aAh().hqK);
        }
        b bVar = this.jGP;
        AppMethodBeat.o(151170);
        return bVar;
    }

    public com.tencent.mm.openim.e.f getWordingInfoStg() {
        AppMethodBeat.i(151171);
        g.aAf().azk();
        if (this.jGQ == null) {
            g.aAi();
            this.jGQ = new com.tencent.mm.openim.e.f(g.aAh().hqK);
        }
        com.tencent.mm.openim.e.f fVar = this.jGQ;
        AppMethodBeat.o(151171);
        return fVar;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(151172);
        Log.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
        EventCenter.instance.add(this.jGM);
        this.jGN.alive();
        g.aAi();
        g.b(com.tencent.mm.openim.a.a.class, new t());
        g.aAi();
        g.aAg().hqi.a(u.CTRL_INDEX, (i) g.af(com.tencent.mm.openim.a.a.class));
        g.aAi();
        g.aAg().hqi.a(913, this.gNh);
        AppMethodBeat.o(151172);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(151173);
        Log.i("MicroMsg.PluginOpenIM", "onAccountRelease");
        EventCenter.instance.removeListener(this.jGM);
        this.jGN.dead();
        g.aAi();
        g.aAg().hqi.b(u.CTRL_INDEX, (i) g.af(com.tencent.mm.openim.a.a.class));
        g.aAi();
        g.aAg().hqi.b(913, this.gNh);
        AppMethodBeat.o(151173);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(151174);
        if (gVar.aBb()) {
            y.a("openim", "openim", TPAudioFrame.TP_CH_STEREO_LEFT, 7776000000L, 3);
        }
        AppMethodBeat.o(151174);
    }

    static {
        AppMethodBeat.i(151175);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("OpenIMAccTypeInfo_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.openim.PluginOpenIM.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("OpenIMAppIdInfo_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.openim.PluginOpenIM.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("OpenIMWordingInfo_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.openim.PluginOpenIM.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.openim.e.f.SQL_CREATE;
            }
        });
        AppMethodBeat.o(151175);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }
}

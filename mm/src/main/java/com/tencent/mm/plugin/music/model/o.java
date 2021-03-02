package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.c.et;
import com.tencent.mm.g.c.fg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.f;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.plugin.music.model.a.a;
import com.tencent.mm.plugin.music.model.e.b;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class o implements bd {
    private IListener AgM = new f();
    private b AkL;
    private ClipboardManager AkM;
    private d AkN;
    private IListener<com.tencent.mm.g.a.d> AkO = new IListener<com.tencent.mm.g.a.d>() {
        /* class com.tencent.mm.plugin.music.model.o.AnonymousClass4 */

        {
            AppMethodBeat.i(160405);
            this.__eventId = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(160405);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.d dVar) {
            AppMethodBeat.i(63028);
            if (!dVar.dBP.dBQ) {
                new a().euF();
            }
            AppMethodBeat.o(63028);
            return false;
        }
    };
    private IListener oVk = new IListener<ak>() {
        /* class com.tencent.mm.plugin.music.model.o.AnonymousClass3 */

        {
            AppMethodBeat.i(160404);
            this.__eventId = ak.class.getName().hashCode();
            AppMethodBeat.o(160404);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ak akVar) {
            AppMethodBeat.i(63027);
            al alVar = new al();
            alVar.dDm.dDn = new com.tencent.mm.plugin.music.ui.a(akVar.dDl.activity);
            EventCenter.instance.publish(alVar);
            AppMethodBeat.o(63027);
            return false;
        }
    };

    public o() {
        AppMethodBeat.i(63029);
        AppMethodBeat.o(63029);
    }

    private static o euC() {
        AppMethodBeat.i(63030);
        o oVar = (o) y.at(o.class);
        AppMethodBeat.o(63030);
        return oVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        AppMethodBeat.i(63031);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("Music".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.music.model.o.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(63025);
                String[] strArr = {MAutoStorage.getCreateSQLs(et.ajs(), "Music")};
                AppMethodBeat.o(63025);
                return strArr;
            }
        });
        hashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.music.model.o.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(63026);
                String[] strArr = {MAutoStorage.getCreateSQLs(fg.ajs(), "PieceMusicInfo")};
                AppMethodBeat.o(63026);
                return strArr;
            }
        });
        AppMethodBeat.o(63031);
        return hashMap;
    }

    public static b euD() {
        AppMethodBeat.i(63032);
        if (euC().AkL == null) {
            euC().AkL = new b(g.aAh().hqK);
        }
        b bVar = euC().AkL;
        AppMethodBeat.o(63032);
        return bVar;
    }

    public static d euE() {
        AppMethodBeat.i(63034);
        if (euC().AkN == null) {
            euC().AkN = new d(g.aAh().hqK);
        }
        d dVar = euC().AkN;
        AppMethodBeat.o(63034);
        return dVar;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(63035);
        this.AkO.alive();
        this.AgM.alive();
        b.create();
        this.oVk.alive();
        m mVar = new m();
        k.a(mVar);
        com.tencent.mm.plugin.music.f.c.b.a(e.class, mVar);
        com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.f());
        AppMethodBeat.o(63035);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(63036);
        k.euk();
        com.tencent.mm.plugin.music.f.c.b.ag(e.class);
        this.AkL = null;
        this.AkM = null;
        this.AkN = null;
        b.destroy();
        EventCenter.instance.removeListener(this.AgM);
        this.AgM.dead();
        this.oVk.dead();
        this.AkO.dead();
        AppMethodBeat.o(63036);
    }
}

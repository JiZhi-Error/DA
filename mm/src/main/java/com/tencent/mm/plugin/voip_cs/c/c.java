package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.voip_cs.c.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class c implements bd {
    private static c HqF = null;
    private a HqG = new a();
    private e HqH = new e();
    private d HqI = new d();
    private com.tencent.mm.plugin.voip_cs.b.a HqJ = new com.tencent.mm.plugin.voip_cs.b.a();
    private IListener HqK = new IListener<bu>() {
        /* class com.tencent.mm.plugin.voip_cs.c.c.AnonymousClass1 */

        {
            AppMethodBeat.i(161686);
            this.__eventId = bu.class.getName().hashCode();
            AppMethodBeat.o(161686);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bu buVar) {
            boolean z = true;
            AppMethodBeat.i(125341);
            bu buVar2 = buVar;
            if (buVar2 instanceof bu) {
                bu.a aVar = buVar2.dEZ;
                if (!(c.fMs().HrL == 1 || c.fMs().HrL == 2)) {
                    z = false;
                }
                aVar.isStarted = z;
            }
            AppMethodBeat.o(125341);
            return false;
        }
    };

    public c() {
        AppMethodBeat.i(125342);
        AppMethodBeat.o(125342);
    }

    private static c fMq() {
        AppMethodBeat.i(125343);
        c cVar = (c) y.at(c.class);
        AppMethodBeat.o(125343);
        return cVar;
    }

    public static a fMr() {
        AppMethodBeat.i(125344);
        a aVar = fMq().HqG;
        AppMethodBeat.o(125344);
        return aVar;
    }

    public static e fMs() {
        AppMethodBeat.i(125345);
        g.aAf().azk();
        if (fMq().HqH == null) {
            fMq().HqH = new e();
        }
        e eVar = fMq().HqH;
        AppMethodBeat.o(125345);
        return eVar;
    }

    public static d fMt() {
        AppMethodBeat.i(125346);
        d dVar = fMq().HqI;
        AppMethodBeat.o(125346);
        return dVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(125347);
        Log.d("MicroMsg.SubCoreVoipCS", "now account reset!");
        EventCenter.instance.addListener(this.HqJ);
        EventCenter.instance.addListener(this.HqK);
        AppMethodBeat.o(125347);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(125348);
        EventCenter.instance.removeListener(this.HqJ);
        EventCenter.instance.removeListener(this.HqK);
        AppMethodBeat.o(125348);
    }
}

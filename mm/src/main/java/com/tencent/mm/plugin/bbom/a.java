package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class a implements b {
    @Override // com.tencent.mm.plugin.auth.a.b
    public final void a(j.h hVar, j.i iVar, boolean z) {
        AppMethodBeat.i(22330);
        if ((iVar.Kzw.Nkx & 2) != 0) {
            ba baVar = iVar.Kzw.Nkz;
            if (!z) {
                bg.aVF();
                c.clearPluginData(baVar.KEc);
            }
            bf.iDu.Km(com.tencent.mm.aj.c.Me(z.aTY()));
            if (baVar.KDZ != 0) {
                bg.aVF();
                c.aSW().eJ(baVar.KDZ + "@qqim", 3);
            }
            com.tencent.mm.aj.c.e((long) baVar.KDZ, 3);
        } else {
            Log.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
        }
        o.run(1);
        if (z) {
            ji jiVar = new ji();
            jiVar.dOb.dOc = false;
            EventCenter.instance.publish(jiVar);
            AppMethodBeat.o(22330);
            return;
        }
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.bbom.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(22328);
                br.KA("ver" + d.KyO);
                ao.eAU().addAll(com.tencent.mm.plugin.r.a.eAS().gmW());
                EventCenter eventCenter = EventCenter.instance;
                if (eventCenter == null) {
                    Log.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
                    AppMethodBeat.o(22328);
                    return;
                }
                ji jiVar = new ji();
                jiVar.dOb.dOc = true;
                eventCenter.publish(jiVar);
                eventCenter.publish(new dz());
                eventCenter.publish(new ok());
                f.fJ(true);
                p.bdS().tE(3);
                Log.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
                AppMethodBeat.o(22328);
            }

            public final String toString() {
                AppMethodBeat.i(22329);
                String str = super.toString() + "|onGYNetEnd2";
                AppMethodBeat.o(22329);
                return str;
            }
        });
        AppMethodBeat.o(22330);
    }

    @Override // com.tencent.mm.plugin.auth.a.b
    public final void a(x.b bVar, String str, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(22331);
        bf.iDu.Km(com.tencent.mm.aj.c.Me(z.aTY()));
        com.tencent.mm.aj.c.e((long) i2, 3);
        bg.aVF();
        c.aSW().eJ(bVar.KAj.MyK, 2);
        if (i2 != 0) {
            bg.aVF();
            c.aSW().eJ(i2 + "@qqim", 3);
        }
        AppMethodBeat.o(22331);
    }
}

package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.aar;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.g.a;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        AppMethodBeat.i(30138);
        de deVar = aVar.heO;
        bg.aVF();
        if (Util.isNullOrNil((String) c.azQ().get(2, ""))) {
            AppMethodBeat.o(30138);
        } else {
            String a2 = z.a(deVar.KHl);
            String a3 = z.a(deVar.KHm);
            if (Util.isNullOrNil(a2) || Util.isNullOrNil(a3)) {
                Log.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
                AppMethodBeat.o(30138);
            } else {
                String a4 = z.a(deVar.KHn);
                Log.i("MicroMsg.YoExtension", "from  " + a2 + "content " + a4);
                a fVO = a.fVO();
                synchronized (fVO.IyJ) {
                    try {
                        aar aWq = a.aWq(a2);
                        if (fVO.IyJ.containsKey(a2) || aWq.ehF.ehG == 1) {
                            Log.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", a2);
                            aar aar = new aar();
                            aar.ehE.dDe = 2;
                            aar.ehE.username = a2;
                            EventCenter.instance.publish(aar);
                        } else {
                            Log.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", a2);
                            fVO.IyJ.put(a2, new a.C1931a(a2, a4));
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(30138);
                        throw th;
                    }
                }
                com.tencent.mm.plugin.wear.model.a.fVO().fWh();
                AppMethodBeat.o(30138);
            }
        }
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}

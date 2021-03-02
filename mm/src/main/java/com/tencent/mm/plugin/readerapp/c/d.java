package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.model.bv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class d extends IListener<qn> {
    public d() {
        AppMethodBeat.i(161675);
        this.__eventId = qn.class.getName().hashCode();
        AppMethodBeat.o(161675);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(qn qnVar) {
        boolean z;
        AppMethodBeat.i(102665);
        qn qnVar2 = qnVar;
        switch (qnVar2.dWV.opType) {
            case 3:
                qn.b bVar = qnVar2.dWW;
                cz czVar = qnVar2.dWV.dWX;
                int i2 = qnVar2.dWV.dWY;
                String str = qnVar2.dWV.dWZ;
                Log.i("MicroMsg.Sns.GetFavDataSource", "fav info, newsSvrid is %d, tweetId is %s", Integer.valueOf(i2), str);
                List<bv> Ae = g.eHI().Ae((long) i2);
                if (!Ae.isEmpty()) {
                    Log.i("MicroMsg.Sns.GetFavDataSource", "fav news msgs");
                    String nullAs = Util.nullAs(str, "");
                    int i3 = 0;
                    while (true) {
                        if (i3 < Ae.size()) {
                            if (nullAs.equals(Ae.get(i3).aVZ())) {
                                z = b.a(czVar, Ae.get(i3));
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                czVar.dFZ.dGe = R.string.c_2;
                z = false;
                bVar.dFE = z;
                break;
            case 4:
                g.eHI().sh(qnVar2.dWV.dXa);
                break;
        }
        AppMethodBeat.o(102665);
        return false;
    }
}

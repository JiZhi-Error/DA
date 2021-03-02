package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;

public final class k extends IListener<jp> {
    public k() {
        AppMethodBeat.i(160861);
        this.__eventId = jp.class.getName().hashCode();
        AppMethodBeat.o(160861);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(jp jpVar) {
        AppMethodBeat.i(69183);
        jp jpVar2 = jpVar;
        if (jpVar2 instanceof jp) {
            jpVar2.dOt.dOv = t.fQI().fRr();
            String trueName = t.fQI().getTrueName();
            if (!Util.isNullOrNil(trueName)) {
                String str = "";
                for (int i2 = 0; i2 < trueName.length() - 1; i2++) {
                    str = str + "*";
                }
                jpVar2.dOt.dOu = str + trueName.substring(trueName.length() - 1, trueName.length());
            } else {
                jpVar2.dOt.dOu = "";
            }
            AppMethodBeat.o(69183);
            return true;
        }
        AppMethodBeat.o(69183);
        return false;
    }
}

package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class v extends IListener<ml> {
    private static boolean dlS = false;
    private int dlT;
    private int dlU;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ml mlVar) {
        AppMethodBeat.i(19456);
        ml mlVar2 = mlVar;
        if (mlVar2 != null) {
            Log.w("MicroMsg.MediaLeakReporter", "event audio[%b %d] mediaplayer[%b %d] audioRecord[%b %d] hadRpt[%b]", Boolean.valueOf(mlVar2.dRT.dRU), Integer.valueOf(mlVar2.dRT.dRV), Boolean.valueOf(mlVar2.dRT.dRW), Integer.valueOf(mlVar2.dRT.dRX), Boolean.valueOf(mlVar2.dRT.dRY), Integer.valueOf(mlVar2.dRT.dRZ), Boolean.valueOf(dlS));
            if (mlVar2.dRT.dRU) {
                h.INSTANCE.idkeyStat(650, (long) this.dlT, 1, false);
            }
            if (mlVar2.dRT.dRW) {
                h.INSTANCE.idkeyStat(650, (long) this.dlU, 1, false);
            }
            if (mlVar2.dRT.dRY) {
                h.INSTANCE.idkeyStat(650, (long) (this.dlU + 1), 1, false);
            }
            if (!dlS && (mlVar2.dRT.dRV > 10 || mlVar2.dRT.dRX > 10 || mlVar2.dRT.dRZ > 0)) {
                h.INSTANCE.e("mediaLeak", g.anI(), null);
                dlS = true;
            }
        }
        AppMethodBeat.o(19456);
        return false;
    }

    public v(int i2, int i3) {
        AppMethodBeat.i(161231);
        this.dlT = i2;
        this.dlU = i3;
        this.__eventId = ml.class.getName().hashCode();
        AppMethodBeat.o(161231);
    }
}

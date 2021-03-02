package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends IListener<kf> {
    private SnsInfo DqO;
    private String DqR;
    private TimeLineObject DqS;

    public f() {
        AppMethodBeat.i(160634);
        this.__eventId = kf.class.getName().hashCode();
        AppMethodBeat.o(160634);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(kf kfVar) {
        AppMethodBeat.i(94894);
        kf kfVar2 = kfVar;
        if (!(kfVar2 instanceof kf)) {
            Log.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        } else {
            this.DqR = kfVar2.dPf.dHp;
            this.DqO = aj.faO().aQm(this.DqR);
            this.DqS = this.DqO.getTimeLine();
            if (this.DqS != null) {
                kfVar2.dPg.dPh = this.DqS;
                AppMethodBeat.o(94894);
                return true;
            }
        }
        AppMethodBeat.o(94894);
        return false;
    }
}

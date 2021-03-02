package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.su;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.eac;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public final class d extends IListener<kc> implements i {
    private int DqM;
    private SnsObject DqN;
    private SnsInfo DqO;
    private MTimerHandler DqP;

    public d() {
        AppMethodBeat.i(160632);
        this.__eventId = kc.class.getName().hashCode();
        AppMethodBeat.o(160632);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(kc kcVar) {
        AppMethodBeat.i(94892);
        boolean a2 = a(kcVar);
        AppMethodBeat.o(94892);
        return a2;
    }

    private boolean a(kc kcVar) {
        AppMethodBeat.i(94890);
        if (!(kcVar instanceof kc)) {
            Log.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
            AppMethodBeat.o(94890);
            return false;
        }
        this.DqM = kcVar.dPa.dJi;
        this.DqO = aj.faO().Zr(this.DqM);
        this.DqN = an.B(this.DqO);
        if (this.DqN == null || ((this.DqN.ExtFlag != 3 || this.DqN.BlackList == null || this.DqN.BlackList.size() <= 0) && (this.DqN.ExtFlag != 5 || this.DqN.GroupUser == null || this.DqN.GroupUser.size() <= 0))) {
            r rVar = new r(this.DqO.field_snsId);
            ((eac) rVar.rr.iLK.iLR).MZx = 1;
            g.aAi();
            g.aAg().hqi.a(210, this);
            g.aAi();
            g.aAg().hqi.a(rVar, 0);
            this.DqP = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.sns.d.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(94889);
                    su suVar = new su();
                    suVar.dZn.dPc = null;
                    EventCenter.instance.publish(suVar);
                    AppMethodBeat.o(94889);
                    return false;
                }
            }, false);
            this.DqP.startTimer(10000);
            AppMethodBeat.o(94890);
            return true;
        }
        kcVar.dPb.dPc = this.DqN;
        AppMethodBeat.o(94890);
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(94891);
        Log.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.DqP.stopTimer();
        if (i2 == 0 && i3 == 0) {
            SnsInfo JJ = aj.faO().JJ(this.DqO.field_snsId);
            su suVar = new su();
            suVar.dZn.dPc = an.B(JJ);
            EventCenter.instance.publish(suVar);
            AppMethodBeat.o(94891);
            return;
        }
        su suVar2 = new su();
        suVar2.dZn.dPc = null;
        EventCenter.instance.publish(suVar2);
        AppMethodBeat.o(94891);
    }
}

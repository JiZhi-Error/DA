package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends IListener<qj> implements i {
    private qj ksT;
    private c ksU;

    public k() {
        AppMethodBeat.i(161286);
        this.__eventId = qj.class.getName().hashCode();
        AppMethodBeat.o(161286);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(qj qjVar) {
        AppMethodBeat.i(20796);
        boolean a2 = a(qjVar);
        AppMethodBeat.o(20796);
        return a2;
    }

    private boolean a(qj qjVar) {
        AppMethodBeat.i(20793);
        if (qjVar instanceof qj) {
            this.ksT = qjVar;
            bg.azz().a(417, this);
            bg.azz().a(new e(this.ksT.dWK.url, this.ksT.dWK.appId, 1), 0);
        }
        AppMethodBeat.o(20793);
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(20794);
        Log.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", Integer.valueOf(i2), Integer.valueOf(i3));
        if (qVar instanceof e) {
            if (i3 == 0) {
                K(i3, true);
                AppMethodBeat.o(20794);
                return;
            }
            K(i3, false);
        }
        AppMethodBeat.o(20794);
    }

    private void K(int i2, boolean z) {
        AppMethodBeat.i(20795);
        Log.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", Integer.valueOf(i2), Boolean.valueOf(z));
        this.ksT.dWL.errCode = i2;
        if (i2 != 0) {
            this.ksT.dWL.dWM = false;
        } else if (!z) {
            g.l(this.ksU);
            this.ksT.dWL.dWM = false;
        } else {
            g.k(this.ksU);
            this.ksT.dWL.dWM = true;
            a.bqb();
            com.tencent.mm.plugin.address.d.a aVar = a.bqd().ksX;
            if (aVar.ktf.size() > 0) {
                b first = aVar.ktf.getFirst();
                this.ksT.dWL.dWN = first.kto;
                this.ksT.dWL.userName = first.ktm;
                this.ksT.dWL.dWO = first.ktn;
                this.ksT.dWL.dWP = first.ktk;
                this.ksT.dWL.dWQ = first.kth;
                this.ksT.dWL.dWR = first.kti;
                this.ksT.dWL.dWS = first.ktj;
                this.ksT.dWL.dWT = first.ktl;
            }
        }
        if (this.ksT.callback != null) {
            this.ksT.callback.run();
        }
        bg.azz().b(417, this);
        AppMethodBeat.o(20795);
    }
}

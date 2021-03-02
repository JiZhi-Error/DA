package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class n<REQ, RESP> extends q implements m {
    protected l GWA = com.tencent.mm.plugin.voip.model.m.fGM();
    i callback;
    protected d rr;
    private i wPq;

    public abstract i fIF();

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, final int i3, final int i4, final String str, s sVar, byte[] bArr) {
        jC(i3, i4);
        if (this.wPq != null) {
            this.wPq.onSceneEnd(i3, i4, str, this);
        }
        if (this.callback != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.a.n.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(115258);
                    if (n.this.callback != null) {
                        n.this.callback.onSceneEnd(i3, i4, str, n.this);
                    }
                    AppMethodBeat.o(115258);
                }
            });
        }
    }

    public int fIG() {
        return 0;
    }

    public void jC(int i2, int i3) {
    }

    public final void fII() {
        Log.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        g.azz().a(this, 0);
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int fIG = fIG();
        if (fIG != 0) {
            return fIG;
        }
        this.wPq = iVar;
        this.callback = fIF();
        return dispatch(gVar, this.rr, this);
    }

    public final <RESP> RESP fIJ() {
        return (RESP) this.rr.iLL.iLR;
    }

    public final <REQ> REQ fIK() {
        return (REQ) this.rr.iLK.iLR;
    }
}

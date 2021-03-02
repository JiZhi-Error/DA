package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    i callback;
    String gwF = "";
    private final s iMO = new b();
    private int iMt = 2;

    public e(String str) {
        AppMethodBeat.i(29764);
        bl.a aVar = (bl.a) this.iMO.getReqObj();
        aVar.iDU.UserName = str;
        aVar.iDU.Mdo = 1;
        Log.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", 1, str);
        AppMethodBeat.o(29764);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29765);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(29765);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return ce.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29766);
        bl.b bVar = (bl.b) sVar.getRespObj();
        this.gwF = bVar.iDV.Mdp;
        Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + " mTicket: " + this.gwF);
        if (i3 == 4 && i4 == -301) {
            bh.a(true, bVar.iDV.KQk, bVar.iDV.KQl, bVar.iDV.KQj);
            this.iMt--;
            if (this.iMt <= 0) {
                Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(29766);
                return;
            }
            Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(29766);
        } else if (i3 == 4 && i4 == -102) {
            final int i5 = sVar.getReqObj().getRsaInfo().ver;
            Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i5));
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.voiceprint.model.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(29763);
                    new com.tencent.mm.modelsimple.m().doScene(e.this.dispatcher(), new i() {
                        /* class com.tencent.mm.plugin.voiceprint.model.e.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(29762);
                            Log.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == 0 && i3 == 0) {
                                e.this.doScene(e.this.dispatcher(), e.this.callback);
                                AppMethodBeat.o(29762);
                                return;
                            }
                            e.this.callback.onSceneEnd(i2, i3, "", e.this);
                            AppMethodBeat.o(29762);
                        }
                    });
                    AppMethodBeat.o(29763);
                }
            });
            AppMethodBeat.o(29766);
        } else if (i3 == 0 || i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29766);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29766);
        }
    }
}

package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    String GQM = "";
    int GQN = 0;
    private String GQO = "";
    i callback;
    private final s iMO = new a();

    public g(String str) {
        AppMethodBeat.i(29773);
        bk.a aVar = (bk.a) this.iMO.getReqObj();
        Log.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", 73, str);
        aVar.iDS.Mdl = 73;
        aVar.iDS.Mdm = str;
        AppMethodBeat.o(29773);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(29774);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(29774);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 616;
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

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29775);
        Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        bk.b bVar = (bk.b) sVar.getRespObj();
        if (i3 == 4 && i4 == -102) {
            final int i5 = sVar.getReqObj().getRsaInfo().ver;
            Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i5));
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.voiceprint.model.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(29772);
                    new com.tencent.mm.modelsimple.m().doScene(g.this.dispatcher(), new i() {
                        /* class com.tencent.mm.plugin.voiceprint.model.g.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(29771);
                            Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == 0 && i3 == 0) {
                                g.this.doScene(g.this.dispatcher(), g.this.callback);
                                AppMethodBeat.o(29771);
                                return;
                            }
                            g.this.callback.onSceneEnd(i2, i3, "", g.this);
                            AppMethodBeat.o(29771);
                        }
                    });
                    AppMethodBeat.o(29772);
                }
            });
            AppMethodBeat.o(29775);
        } else if (i3 == 0 || i4 == 0) {
            if (bVar.iDT.Mdn != null) {
                this.GQM = new String(bVar.iDT.Mdn.MSr.getBufferToBytes());
                this.GQN = bVar.iDT.Mdn.MPS;
                Log.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", Integer.valueOf(this.GQN), this.GQO, this.GQM);
            } else {
                Log.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29775);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29775);
        }
    }
}

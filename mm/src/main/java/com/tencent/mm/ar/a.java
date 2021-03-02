package com.tencent.mm.ar;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ca;
import junit.framework.Assert;

public final class a extends q implements m {
    private i callback;
    private ca dCM = new ca();
    private MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.ar.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(20483);
            a.this.onGYNetEnd(999, 0, 0, "", null, null);
            AppMethodBeat.o(20483);
        }
    };

    public a(String str, String str2) {
        boolean z = true;
        AppMethodBeat.i(20484);
        this.dCM.setStatus(1);
        this.dCM.Cy(str);
        this.dCM.setCreateTime(bp.Kw(str));
        this.dCM.nv(1);
        this.dCM.setContent(str2);
        this.dCM.setType(ab.JG(str));
        bg.aVF();
        long aC = c.aSQ().aC(this.dCM);
        Assert.assertTrue(aC == -1 ? false : z);
        Log.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = ".concat(String.valueOf(aC)));
        AppMethodBeat.o(20484);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20485);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.dCM.field_msgId);
        this.handler.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.o(20485);
        return 999;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 522;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20486);
        Log.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.dCM.field_msgId);
        this.dCM.setStatus(2);
        this.dCM.setCreateTime(bp.C(this.dCM.field_talker, System.currentTimeMillis() / 1000));
        bg.aVF();
        c.aSQ().a(this.dCM.field_msgId, this.dCM);
        this.callback.onSceneEnd(0, 0, str, this);
        AppMethodBeat.o(20486);
    }
}

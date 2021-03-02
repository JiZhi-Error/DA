package com.tencent.mm.plugin.wallet.wecoin.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epw;
import com.tencent.mm.protocal.protobuf.epx;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;

public final class c extends q implements m {
    private i heq = null;
    private d rAy = null;

    public c() {
        AppMethodBeat.i(214137);
        d.a aVar = new d.a();
        aVar.iLN = new epw();
        aVar.iLO = new epx();
        aVar.funcId = 5249;
        aVar.uri = "/cgi-bin/micromsg-bin/verifysignaturetest";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rAy = aVar.aXF();
        AppMethodBeat.o(214137);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5249;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(214138);
        this.heq = iVar;
        epw epw = (epw) this.rAy.iLK.iLR;
        String RO = b.bjq().RO("TestSignData");
        byte[] bytes = RO.getBytes(StandardCharsets.ISO_8859_1);
        if (!TextUtils.isEmpty(RO)) {
            Log.i("MMVerifyCgiSignatureTest", "after sign data length " + RO.length() + " byte length " + bytes.length);
            epw.LoA = new com.tencent.mm.bw.b(bytes);
            epw.Nnu = new com.tencent.mm.bw.b("TestSignData".getBytes());
            Log.d("MMVerifyCgiSignatureTest", "zyzhang verify result ".concat(String.valueOf(b.bjq().bL("TestSignData", RO))));
            int dispatch = dispatch(gVar, this.rAy, this);
            AppMethodBeat.o(214138);
            return dispatch;
        }
        Log.e("MMVerifyCgiSignatureTest", "sign failed");
        AppMethodBeat.o(214138);
        return -1;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(214139);
        Log.i("MMVerifyCgiSignatureTest", "receive response " + i3 + " code " + i4 + " message " + str + " code " + sVar.getRespObj().getRetCode());
        epx epx = (epx) this.rAy.iLL.iLR;
        wl profile = sVar.getRespObj().getProfile();
        if (profile != null) {
            Log.d("MMVerifyCgiSignatureTest", "profile " + profile.startConnectTime + " " + profile.readPacketFinishedTime + " " + profile.taskStartTime + " " + profile.startHandshakeTime + " " + profile.handshakeSuccessfulTime);
        } else {
            Log.d("MMVerifyCgiSignatureTest", "profile is null");
        }
        if (epx == null || epx.BaseResponse == null) {
            Log.e("MMVerifyCgiSignatureTest", "response or BaseResponse is null " + (epx == null));
        } else {
            Log.d("MMVerifyCgiSignatureTest", "response ret " + epx.BaseResponse.Ret);
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(214139);
    }
}

package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.wxmm.v2helper;
import java.util.Map;

public final class x extends q implements m {
    private i callback;
    public int errCode;
    public int errType;
    private final long jky = Util.MILLSECONDS_OF_MINUTE;
    private Runnable jkz;
    public long msgId = -1;
    public d rr;

    public x(float f2, float f3, long j2) {
        AppMethodBeat.i(150940);
        ddi ddi = new ddi();
        ddi.LbC = f2;
        ddi.LbD = f3;
        ddi.LuW = 1;
        ddi.LuT = 0;
        d.a aVar = new d.a();
        aVar.iLN = new dqx();
        aVar.iLO = new dqy();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.funcId = v2helper.EMethodSetSpkEnhance;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dqx dqx = (dqx) this.rr.iLK.iLR;
        dqx.MTE = ddi;
        dqx.Scene = 1;
        dqx.MTF = -10000.0f;
        dqx.MTG = -10000.0f;
        this.msgId = j2;
        AppMethodBeat.o(150940);
    }

    public x(dqx dqx) {
        AppMethodBeat.i(150941);
        d.a aVar = new d.a();
        aVar.iLN = dqx;
        aVar.iLO = new dqy();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.funcId = v2helper.EMethodSetSpkEnhance;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(150941);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150942);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150942);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(150943);
        if (((dqx) ((d) sVar).iLK.iLR).MTE == null) {
            Log.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(150943);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(150943);
        return bVar2;
    }

    public final dqy bfB() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (dqy) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.ak.q
    public final long getReturnTimeout() {
        return Util.MILLSECONDS_OF_MINUTE;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150944);
        Log.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        this.errType = i3;
        this.errCode = i4;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        } else {
            Log.e("MicroMsg.NetSceneScanStreetView", "callback null");
        }
        Log.d("MicroMsg.NetSceneScanStreetView", "xml is %s", bfB().MbV);
        if (this.jkz != null) {
            this.jkz.run();
        }
        AppMethodBeat.o(150944);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return v2helper.EMethodSetSpkEnhance;
    }

    public static String PE(String str) {
        AppMethodBeat.i(150945);
        Map<String, String> parseXml = XmlParser.parseXml(str, "streetview", null);
        if (parseXml == null) {
            AppMethodBeat.o(150945);
            return null;
        }
        String str2 = parseXml.get(".streetview.link");
        AppMethodBeat.o(150945);
        return str2;
    }
}

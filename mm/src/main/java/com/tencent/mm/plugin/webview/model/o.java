package com.tencent.mm.plugin.webview.model;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class o extends q implements m {
    private i callback;
    public d rr;

    public o(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.i(78882);
        d.a aVar = new d.a();
        aVar.iLN = new bjt();
        aVar.iLO = new bju();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
        aVar.funcId = 1393;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bjt bjt = (bjt) this.rr.iLK.iLR;
        bjt.Lpg = str;
        bjt.KXJ = str2;
        bjt.LTm = (String) map.get("groupId");
        bjt.HXc = (String) map.get(AppMeasurement.Param.TIMESTAMP);
        bjt.qcM = (String) map.get("nonceStr");
        bjt.signature = (String) map.get("signature");
        bjt.LTn = map.get(NativeProtocol.WEB_DIALOG_PARAMS).toString();
        AppMethodBeat.o(78882);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78883);
        Log.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(78883);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1393;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78884);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78884);
        return dispatch;
    }

    public final bju gcv() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (bju) this.rr.iLL.iLR;
    }
}

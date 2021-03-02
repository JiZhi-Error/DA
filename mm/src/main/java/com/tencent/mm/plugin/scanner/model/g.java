package com.tencent.mm.plugin.scanner.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u0004\u0018\u00010#J\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\u0006J\b\u0010&\u001a\u00020\u0006H\u0016J>\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\u001c\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "source", "", "mode", "requestType", "sessionId", "", "frameId", "usingAI", "", "isAiCrop", "originImageWidth", "originImageHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "jsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "([BIIIJIZZIILcom/tencent/mm/protocal/protobuf/GoodsObject;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "getSession", "getSource", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class g extends q implements m {
    public static final a CFz = new a((byte) 0);
    private i callback;
    long dDZ;
    final d rr;
    public int source;

    static {
        AppMethodBeat.i(52161);
        AppMethodBeat.o(52161);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public g(byte[] bArr, int i2, int i3, int i4, long j2, int i5, boolean z, boolean z2, int i6, int i7, GoodsObject goodsObject, ms msVar, mt mtVar, mu muVar) {
        p.h(bArr, "imageData");
        AppMethodBeat.i(240402);
        this.source = i2;
        this.dDZ = j2;
        d.a aVar = new d.a();
        aVar.c(new mv());
        aVar.d(new mw());
        aVar.MB("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image");
        aVar.sG(2580);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRequest");
            AppMethodBeat.o(240402);
            throw tVar;
        }
        mv mvVar = (mv) aYJ;
        mvVar.mode = i3;
        mvVar.type = i4;
        mvVar.KRc = b.cD(bArr);
        mvVar.KRi = j2;
        mvVar.KRh = i5;
        mvVar.KRk = z;
        mvVar.KRj = z2;
        mvVar.KRm = i6;
        mvVar.KRn = i7;
        if (goodsObject != null) {
            mvVar.KRl = goodsObject;
        }
        mvVar.KRp = msVar;
        mvVar.KRq = mtVar;
        mvVar.KRo = muVar;
        mvVar.KRr = bp.aVP();
        Object[] objArr = new Object[3];
        objArr[0] = muVar != null ? Float.valueOf(muVar.latitude) : null;
        objArr[1] = muVar != null ? Float.valueOf(muVar.dTj) : null;
        objArr[2] = muVar != null ? Float.valueOf(muVar.KRb) : null;
        Log.v("MicroMsg.NetSceneAiScanImage", "alvinluo uploadImage location: %s, %s, %s", objArr);
        Log.i("MicroMsg.NetSceneAiScanImage", "alvinluo NetSceneAiScanImage imageSize: %d, sessionId: %d, scanId: %s, requestType: %d, mode: %d, source: %d, usingAI: %b, isAiCrop: %b, originWidth: %d, originHeight: %d, mode: %d, send_srv_time: %d", Integer.valueOf(bArr.length), Long.valueOf(j2), Integer.valueOf(mvVar.KRh), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(mvVar.mode), Long.valueOf(mvVar.KRr));
        AppMethodBeat.o(240402);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(52158);
        Log.i("MicroMsg.NetSceneAiScanImage", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(52158);
            return;
        }
        AppMethodBeat.o(52158);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2580;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(52159);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(52159);
        return dispatch;
    }
}

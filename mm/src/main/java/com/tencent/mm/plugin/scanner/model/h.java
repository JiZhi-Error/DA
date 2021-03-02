package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.model.a;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+Bi\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020\u0006J\b\u0010!\u001a\u00020\bH\u0016J>\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\u0018\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0016R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "type", "", "mode", "seqNum", "searchInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "decodeResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "cdnUploadResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "([BJIIILcom/tencent/mm/protocal/protobuf/BizAiScanImageSearchInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class h extends q implements m {
    public static final a CFA = new a((byte) 0);
    private i callback;
    long dDZ;
    final d rr;

    static {
        AppMethodBeat.i(240406);
        AppMethodBeat.o(240406);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImageScene$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ h(byte[] bArr, long j2, int i2, int i3, nd ndVar, mu muVar, ScanImagePHashInfo scanImagePHashInfo) {
        this(bArr, j2, i2, i3, ndVar, muVar, scanImagePHashInfo, null, null);
    }

    public h(byte[] bArr, long j2, int i2, int i3, nd ndVar, mu muVar, ScanImagePHashInfo scanImagePHashInfo, a.b bVar, a.C1673a aVar) {
        String str;
        String str2;
        Integer num;
        AppMethodBeat.i(240405);
        this.dDZ = j2;
        d.a aVar2 = new d.a();
        aVar2.c(new nb());
        aVar2.d(new nc());
        aVar2.MB("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_scene");
        aVar2.sG(1100);
        aVar2.sI(0);
        aVar2.sJ(0);
        d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneRequest");
            AppMethodBeat.o(240405);
            throw tVar;
        }
        nb nbVar = (nb) aYJ;
        nbVar.type = i2;
        nbVar.mode = i3;
        nbVar.KND = 0;
        if (bArr != null) {
            nbVar.KRc = b.cD(bArr);
        }
        nbVar.KRi = j2;
        nbVar.KRG = ndVar;
        nbVar.KRo = muVar;
        nbVar.KRD = (scanImagePHashInfo == null || (str = scanImagePHashInfo.pHash) == null) ? "" : str;
        nbVar.KRE = (scanImagePHashInfo == null || (str2 = scanImagePHashInfo.pHashVersion) == null) ? "" : str2;
        if (bVar != null) {
            nbVar.KRJ = bVar.xlg;
            nbVar.KRK = bVar.xlh;
        }
        if (aVar != null) {
            nbVar.KRI = aVar.aesKey;
            nbVar.KRH = aVar.fileID;
            nbVar.xve = aVar.imageUrl;
        }
        StringBuilder sb = new StringBuilder("alvinluo NetSceneAiScanImageScene imageSize: ");
        if (bArr != null) {
            num = Integer.valueOf(bArr.length);
        } else {
            num = null;
        }
        Log.i("MicroMsg.NetSceneAiScanImageScene", sb.append(num).append(", type: ").append(i2).append(", mode: ").append(i3).append(", sessionId: ").append(j2).append(", seqNum: 0, fileId:").append(aVar != null ? aVar.fileID : null).toString());
        Object[] objArr = new Object[6];
        objArr[0] = ndVar != null ? Integer.valueOf(ndVar.KRN) : null;
        objArr[1] = muVar != null ? Float.valueOf(muVar.latitude) : null;
        objArr[2] = muVar != null ? Float.valueOf(muVar.dTj) : null;
        objArr[3] = muVar != null ? Float.valueOf(muVar.KRb) : null;
        objArr[4] = scanImagePHashInfo != null ? scanImagePHashInfo.pHash : null;
        objArr[5] = scanImagePHashInfo != null ? scanImagePHashInfo.pHashVersion : null;
        Log.v("MicroMsg.NetSceneAiScanImageScene", "alvinluo NetSceneAiScanImageScene %s, %s, %s, %s, pHash: %s, pHashVersion: %s", objArr);
        AppMethodBeat.o(240405);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(240403);
        Log.i("MicroMsg.NetSceneAiScanImageScene", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(240403);
            return;
        }
        AppMethodBeat.o(240403);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1100;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(240404);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(240404);
        return dispatch;
    }
}

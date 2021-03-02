package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.scanner.model.a;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$BC\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\u0006J\b\u0010\u001a\u001a\u00020\bH\u0016J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0011\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/NetSceneBizImageOCR;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "sessionId", "", "source", "", "seqNum", "decodeResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "cdnUploadResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "([BJIILcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizOcrChatImageResponse;", "getSession", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class f extends q implements m {
    public static final a CIK = new a((byte) 0);
    private i callback;
    public long dDZ;
    public final d rr;

    static {
        AppMethodBeat.i(240557);
        AppMethodBeat.o(240557);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/NetSceneBizImageOCR$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ f(byte[] bArr, long j2, int i2) {
        this(bArr, j2, i2, null, null);
    }

    public f(byte[] bArr, long j2, int i2, a.b bVar, a.C1673a aVar) {
        AppMethodBeat.i(240556);
        this.dDZ = j2;
        d.a aVar2 = new d.a();
        aVar2.c(new oz());
        aVar2.d(new pa());
        aVar2.MB("/cgi-bin/mmbiz-bin/imgretrieval/ocr_chat_image");
        aVar2.sG(getType());
        aVar2.sI(0);
        aVar2.sJ(0);
        d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizOcrChatImageRequest");
            AppMethodBeat.o(240556);
            throw tVar;
        }
        oz ozVar = (oz) aYJ;
        ozVar.KRi = j2;
        ozVar.source = i2;
        ozVar.KND = 0;
        if (bArr != null) {
            ozVar.KRc = b.cD(bArr);
        }
        if (bVar != null) {
            Log.i("MicroMsg.NetSceneBizImageOCR", "alvinluo NetSceneBizImageOCR decodeResult: %s, %s", Integer.valueOf(bVar.xlg), Integer.valueOf(bVar.xlh));
            ozVar.KRJ = bVar.xlg;
            ozVar.KRK = bVar.xlh;
        }
        if (aVar != null) {
            Log.d("MicroMsg.NetSceneBizImageOCR", "alvinluo NetSceneBizImageOCR cdnUploadResult: %s, %s, %s", aVar.aesKey, aVar.fileID, aVar.imageUrl);
            ozVar.KRI = aVar.aesKey;
            ozVar.KRH = aVar.fileID;
            ozVar.xve = aVar.imageUrl;
        }
        Log.i("MicroMsg.NetSceneBizImageOCR", "alvinluo NetSceneBizImageOCR imageSize: " + (bArr != null ? Integer.valueOf(bArr.length) : null) + ", sessionId: " + j2 + ", source: " + i2 + ", seqNum: 0");
        AppMethodBeat.o(240556);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(240554);
        Log.i("MicroMsg.NetSceneBizImageOCR", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(240554);
            return;
        }
        AppMethodBeat.o(240554);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5131;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(240555);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(240555);
        return dispatch;
    }
}

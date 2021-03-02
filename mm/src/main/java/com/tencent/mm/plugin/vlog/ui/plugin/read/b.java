package com.tencent.mm.plugin.vlog.ui.plugin.read;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u001c\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J>\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "inputText", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "getInputText", "()Ljava/lang/String;", "outputSpeech", "", "getOutputSpeech", "()[B", "setOutputSpeech", "([B)V", "reqId", "", "getReqId", "()I", "setReqId", "(I)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-vlog_release"})
public final class b extends q implements m {
    public static final a GLU = new a((byte) 0);
    public byte[] GLS;
    public final String GLT;
    private i callback;
    public long durationMs;
    private d hJu;
    public int wJG;

    static {
        AppMethodBeat.i(191809);
        AppMethodBeat.o(191809);
    }

    public b(String str, String str2) {
        p.h(str, "finderUserName");
        p.h(str2, "inputText");
        AppMethodBeat.i(191808);
        this.GLT = str2;
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/micromsg-bin/findertexttospeech");
        aVar.sG(getType());
        bdm bdm = new bdm();
        bdm.finderUsername = str;
        bdm.GLT = this.GLT;
        aVar.c(bdm);
        aVar.d(new bdn());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
        AppMethodBeat.o(191808);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/NetSceneFinderTextToSpeech$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(191806);
        Log.i("MicroMsg.NetSceneFinderTextToSpeech", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(191806);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5207;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        byte[] bArr2;
        AppMethodBeat.i(191807);
        Log.i("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd, errType:" + i3 + ", errCode:" + i4);
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.NetSceneFinderTextToSpeech", "onGYNetEnd error");
        }
        com.tencent.mm.bw.a aYK = this.hJu.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTextToSpeechResp");
            AppMethodBeat.o(191807);
            throw tVar;
        }
        bdn bdn = (bdn) aYK;
        com.tencent.mm.bw.b bVar = bdn.LNl;
        if (bVar != null) {
            bArr2 = bVar.zy;
        } else {
            bArr2 = null;
        }
        this.GLS = bArr2;
        this.durationMs = bdn.durationMs;
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(191807);
            return;
        }
        AppMethodBeat.o(191807);
    }
}

package com.tencent.mm.live.b.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u0006\u001a\u00020\u0007J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isVerify", "", "Ljava/lang/Boolean;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/LiveVerifyRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;)V", "verifyUrl", "", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "getVerifyUrl", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class v extends q implements m {
    public static final a hKL = new a((byte) 0);
    private i callback;
    public String hJl;
    private d hJu;
    private cjf hKI;
    private cjg hKJ;
    public Boolean hKK;

    static {
        AppMethodBeat.i(207825);
        AppMethodBeat.o(207825);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public v() {
        AppMethodBeat.i(207824);
        d.a aVar = new d.a();
        aVar.c(new cjf());
        aVar.d(new cjg());
        aVar.sG(3895);
        aVar.MB("/cgi-bin/micromsg-bin/liveverify");
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
        com.tencent.mm.bw.a aYJ = this.hJu.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyRequest");
            AppMethodBeat.o(207824);
            throw tVar;
        }
        this.hKI = (cjf) aYJ;
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "live verify request.");
        AppMethodBeat.o(207824);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3895;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(207822);
        Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(207822);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        cjg cjg;
        AppMethodBeat.i(207823);
        if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(207823);
            throw tVar;
        }
        com.tencent.mm.bw.a aYK = ((d) sVar).aYK();
        if (aYK == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyResponse");
            AppMethodBeat.o(207823);
            throw tVar2;
        }
        this.hKJ = (cjg) aYK;
        if (i3 == 0 && i4 == 0 && (cjg = this.hKJ) != null) {
            this.hKK = Boolean.valueOf(cjg.KKE);
            this.hJl = cjg.KKF;
            Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "onGYNetEnd isVerify:" + (this.hKK == null ? BuildConfig.COMMAND : this.hKK));
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(207823);
            return;
        }
        AppMethodBeat.o(207823);
    }
}

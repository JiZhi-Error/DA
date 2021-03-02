package com.tencent.mm.plugin.byp.b;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\b&\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0004H\u0016J<\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J*\u0010-\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010.\u001a\u00020 H\u0016J\u0010\u0010/\u001a\u00020#2\u0006\u0010.\u001a\u00020 H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "bizType", "", "pack", "Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "(ILcom/tencent/mm/protocal/protobuf/BypMsgPack;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getPack", "()Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMsgInfoClientId", "", "getResponse", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onSendFailed", "resp", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public abstract class a extends q implements m {
    private static final Set<Long> pPw = Collections.synchronizedSet(new HashSet());
    public static final C0899a pPx = new C0899a((byte) 0);
    private i callback;
    d hJu;
    private final sq pPu = new sq();
    final sm pPv;

    public a(int i2, sm smVar) {
        p.h(smVar, "pack");
        this.pPv = smVar;
        d.a aVar = new d.a();
        this.pPu.LaH = this.pPv;
        this.pPu.LaG = i2;
        aVar.c(this.pPu);
        sr srVar = new sr();
        srVar.setBaseResponse(new BaseResponse());
        srVar.getBaseResponse().ErrMsg = new dqi();
        aVar.d(srVar);
        aVar.MB("/cgi-bin/micromsg-bin/bypsend");
        aVar.sG(3862);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R5\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend$Companion;", "", "()V", "TAG", "", "sendingSet", "", "", "kotlin.jvm.PlatformType", "", "getSendingSet", "()Ljava/util/Set;", "plugin-byp_release"})
    /* renamed from: com.tencent.mm.plugin.byp.b.a$a  reason: collision with other inner class name */
    public static final class C0899a {
        private C0899a() {
        }

        public /* synthetic */ C0899a(byte b2) {
            this();
        }
    }

    public long crU() {
        return 0;
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 3862;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        this.callback = iVar;
        pPw.add(Long.valueOf(crU()));
        return dispatch(gVar, this.hJu, this);
    }

    public void a(sr srVar) {
        p.h(srVar, "resp");
    }

    public void a(int i2, int i3, String str, sr srVar) {
        p.h(srVar, "resp");
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        p.h(sVar, "rr");
        com.tencent.mm.bw.a aYK = this.hJu.aYK();
        if (aYK == null) {
            throw new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BypSendResponse");
        }
        sr srVar = (sr) aYK;
        Log.i("Byp.CgiBypSend", "[onCgiBack] errType=" + i3 + " errCode=" + i4 + " errMsg=" + str + " resp=" + srVar);
        pPw.remove(Long.valueOf(crU()));
        if (i3 == 0 && i4 == 0) {
            a(srVar);
        } else {
            a(i3, i4, str, srVar);
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
        }
    }
}

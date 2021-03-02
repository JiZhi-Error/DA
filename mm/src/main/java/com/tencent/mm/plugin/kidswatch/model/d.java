package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B?\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J<\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0007H\u0014J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020(H\u0014J\u0010\u0010.\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0014R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/NetSceneExtReg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickName", "", "bindMobile", "regMode", "", "hasAvatar", "", "extRegUrl", "fileId", "aesKey", "(Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "openId", "getOpenId", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "serverTime", "getServerTime", "()I", "status", "getStatus", OpenSDKTool4Assistant.EXTRA_UIN, "getUin", ch.COL_USERNAME, "getUsername", "doScene", "autoAuth", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "setReSessionId", "regSessionId", "setSecurityCheckError", "e", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckError;", "Companion", "plugin-kidswatch_release"})
public final class d extends q implements m {
    public static final a yAW = new a((byte) 0);
    private i callback;
    private com.tencent.mm.ak.d rr;

    static {
        AppMethodBeat.i(256205);
        AppMethodBeat.o(256205);
    }

    public d(String str, String str2, boolean z, String str3, String str4, String str5) {
        int i2 = 0;
        p.h(str, "nickName");
        p.h(str2, "bindMobile");
        p.h(str3, "extRegUrl");
        p.h(str4, "fileId");
        p.h(str5, "aesKey");
        AppMethodBeat.i(256204);
        Log.d("MicroMsg.NetSceneExtReg", "NetSceneExtReg: nickname = " + str + ", bindMobile = " + str2 + ", regMode = 4, hasAvatar=" + z + ", extRegUrl:" + str3);
        d.a aVar = new d.a();
        aVar.c(new ala());
        aVar.d(new alb());
        aVar.MB("/cgi-bin/micromsg-bin/extreg");
        aVar.sG(5888);
        aVar.sI(0);
        aVar.sJ(0);
        com.tencent.mm.ak.d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
            AppMethodBeat.o(256204);
            throw tVar;
        }
        ala ala = (ala) aYJ;
        ala.oUJ = str;
        ala.KEb = str2;
        ala.LtW = 4;
        ala.LtX = z ? 1 : i2;
        ala.KQf = str3;
        ala.LtZ = str4;
        ala.Lua = str5;
        Log.i("MicroMsg.NetSceneExtReg", "fileId:" + str4 + ", aesKey:" + str5);
        AppMethodBeat.o(256204);
    }

    public final void PB(String str) {
        AppMethodBeat.i(256197);
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.bw.a aYJ = this.rr.aYJ();
            if (aYJ == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
                AppMethodBeat.o(256197);
                throw tVar;
            }
            ((ala) aYJ).KQa = str;
            Log.i("MicroMsg.NetSceneExtReg", "setRegSessionId %s", str);
        }
        AppMethodBeat.o(256197);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256198);
        p.h(gVar, "autoAuth");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(256198);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(256199);
        p.h(sVar, "rr");
        q.b bVar = q.b.EOk;
        AppMethodBeat.o(256199);
        return bVar;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(256200);
        p.h(aVar, "e");
        AppMethodBeat.o(256200);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5888;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256201);
        p.h(sVar, "rr");
        if (((com.tencent.mm.ak.d) sVar).aYJ() == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
            AppMethodBeat.o(256201);
            throw tVar;
        } else if (((com.tencent.mm.ak.d) sVar).aYK() == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
            AppMethodBeat.o(256201);
            throw tVar2;
        } else {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
            Log.i("MicroMsg.NetSceneExtReg", "errType:" + i3 + ", errCode:" + i4 + ", errType:" + str);
            AppMethodBeat.o(256201);
        }
    }

    public final String getUsername() {
        AppMethodBeat.i(256202);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
            AppMethodBeat.o(256202);
            throw tVar;
        }
        String str = ((alb) aYK).UserName;
        AppMethodBeat.o(256202);
        return str;
    }

    public final String getOpenId() {
        AppMethodBeat.i(256203);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
            AppMethodBeat.o(256203);
            throw tVar;
        }
        String str = ((alb) aYK).hio;
        p.g(str, "(rr.responseProtoBuf as ExtRegResponse).OpenID");
        AppMethodBeat.o(256203);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/NetSceneExtReg$Companion;", "", "()V", "MM_REGMODE_MOBILE_NOPWD", "", "REG_MODE_MOBILE", "TAG", "", "plugin-kidswatch_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

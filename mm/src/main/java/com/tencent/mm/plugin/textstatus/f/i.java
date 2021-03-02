package com.tencent.mm.plugin.textstatus.f;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.f.f.b;
import com.tencent.mm.plugin.textstatus.f.f.c;
import com.tencent.mm.plugin.textstatus.g.s;
import com.tencent.mm.plugin.textstatus.g.t;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0018\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\bH\u0016J<\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "topicId", "", "statusId", "userName", NativeProtocol.WEB_DIALOG_ACTION, "", "emotion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAction", "()I", "setAction", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getEmotion", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;)V", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class i extends q implements m {
    public static final a FZh = new a((byte) 0);
    private String FYf;
    private final s FZe;
    private t FZf;
    private final int FZg;
    private int action;
    private com.tencent.mm.ak.i callback;
    private final d iUB;
    private String userName;

    static {
        AppMethodBeat.i(216204);
        AppMethodBeat.o(216204);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusLike$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public i(String str, String str2, String str3, int i2, int i3) {
        p.h(str, "topicId");
        p.h(str2, "statusId");
        p.h(str3, "userName");
        AppMethodBeat.i(216203);
        this.FYf = str2;
        this.userName = str3;
        this.action = i2;
        this.FZg = i3;
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/textstatuslike");
        aVar.c(new s());
        aVar.d(new t());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusLikeReq");
            AppMethodBeat.o(216203);
            throw tVar;
        }
        this.FZe = (s) aYJ;
        this.FZe.GaI = str;
        this.FZe.Gas = this.FYf;
        this.FZe.username = this.userName;
        this.FZe.GaR = this.action;
        this.FZe.type = this.FZg;
        Log.i("MicroMsg.TxtStatus.NetSceneTextStatusLike", "topicId:" + str + ", statusId:" + this.FYf + ", username:" + this.userName + ", action:" + this.action + ", type:" + this.FZg);
        AppMethodBeat.o(216203);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4099;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(216201);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(216201);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(216202);
        p.h(sVar, "rr");
        Log.i("MicroMsg.TxtStatus.NetSceneTextStatusLike", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusLikeResp");
                AppMethodBeat.o(216202);
                throw tVar;
            }
            this.FZf = (t) aYK;
            f fVar = f.FXJ;
            c fvN = f.fvN();
            String str2 = this.FYf;
            String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA, "Account.username()");
            b lc = fvN.lc(str2, ceA);
            if (this.action == 1 && lc != null) {
                f fVar2 = f.FXJ;
                f.fvN().b(lc, new String[0]);
            } else if (this.action != 1) {
                if (lc == null) {
                    lc = new b();
                }
                lc.field_HashUserName = com.tencent.mm.plugin.auth.a.a.ceA();
                lc.field_TextStatusId = this.FYf;
                lc.field_Type = this.FZg;
                lc.field_Read = 1;
                lc.field_CreateTime = cl.aWB();
                if (((int) lc.systemRowid) == -1) {
                    f fVar3 = f.FXJ;
                    f.fvN().a(lc);
                } else {
                    f fVar4 = f.FXJ;
                    f.fvN().a(lc, new String[0]);
                }
            }
        }
        com.tencent.mm.ak.i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(216202);
            return;
        }
        AppMethodBeat.o(216202);
    }
}

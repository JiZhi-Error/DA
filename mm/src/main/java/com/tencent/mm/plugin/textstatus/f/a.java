package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.g.e;
import com.tencent.mm.plugin.textstatus.g.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J<\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneDeleteSelfHistory;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "statusId", "", "scene", "", "(Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getStatusId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class a extends q implements m {
    public static final C1820a FYN = new C1820a((byte) 0);
    public final String FYf;
    private i callback;
    private final d iUB;

    static {
        AppMethodBeat.i(216174);
        AppMethodBeat.o(216174);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneDeleteSelfHistory$Companion;", "", "()V", "TAG", "", "TEXT_STATUS_DELETE_SELF_HISTORY_SCENE_DELETE", "", "TEXT_STATUS_DELETE_SELF_HISTORY_SCENE_HIDE", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.f.a$a  reason: collision with other inner class name */
    public static final class C1820a {
        private C1820a() {
        }

        public /* synthetic */ C1820a(byte b2) {
            this();
        }
    }

    public a(String str, int i2) {
        p.h(str, "statusId");
        AppMethodBeat.i(216173);
        this.FYf = str;
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/textstatusdeleteselfhistory");
        aVar.c(new e());
        aVar.d(new f());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusDeleteSelfHistoryReq");
            AppMethodBeat.o(216173);
            throw tVar;
        }
        e eVar = (e) aYJ;
        eVar.Gas = this.FYf;
        eVar.scene = i2;
        Log.i("MicroMsg.TxtStatus.NetSceneDeleteSelfHistory", "statusId:" + this.FYf);
        AppMethodBeat.o(216173);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5967;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(216171);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(216171);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        com.tencent.mm.plugin.textstatus.f.f.a aVar;
        AppMethodBeat.i(216172);
        p.h(sVar, "rr");
        Log.i("MicroMsg.TxtStatus.NetSceneDeleteSelfHistory", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            com.tencent.mm.plugin.textstatus.f.f.d fvM = com.tencent.mm.plugin.textstatus.b.f.fvM();
            String str2 = this.FYf;
            String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA, "Account.username()");
            p.h(str2, "statusId");
            p.h(ceA, "userName");
            if ((fvM.db.delete(com.tencent.mm.plugin.textstatus.f.f.d.TABLE, "StatusID = ?", new String[]{str2}) > 0) && (aVar = fvM.hXr().get(ceA)) != null && p.j(aVar.field_StatusID, str2)) {
                fvM.hXr().remove(ceA);
                fvM.doNotify(ceA);
            }
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(216172);
            return;
        }
        AppMethodBeat.o(216172);
    }
}

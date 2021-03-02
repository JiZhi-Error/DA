package com.tencent.mm.plugin.mv.a.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.mv.a.j;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012J\b\u0010\u001b\u001a\u00020\tH\u0016J>\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetMVRecommendList;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "currentPageData", "Lcom/tencent/mm/protocal/protobuf/MvReportData;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "songInfoBase64", "", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/MvReportData;Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfoBase64", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class h extends m {
    public static final a AqJ = new a((byte) 0);
    public csb Aqj;
    private final String Aqk;
    private final axy Aqo;
    private csa Aqy;
    private i callback;
    private final d iUB;

    static {
        AppMethodBeat.i(256842);
        AppMethodBeat.o(256842);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(cst cst, axy axy, String str, int i2) {
        super(i2);
        p.h(axy, "songInfo");
        p.h(str, "songInfoBase64");
        AppMethodBeat.i(259197);
        this.Aqo = axy;
        this.Aqk = str;
        d.a aVar = new d.a();
        aVar.sG(6860);
        aVar.MB("/cgi-bin/micromsg-bin/musiclivegetrelatedlist");
        aVar.c(new csa());
        aVar.d(new csb());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListReq");
            AppMethodBeat.o(259197);
            throw tVar;
        }
        this.Aqy = (csa) aYJ;
        csa csa = this.Aqy;
        if (csa != null) {
            csa.scene = 102;
        }
        csa csa2 = this.Aqy;
        if (csa2 != null) {
            am amVar = am.tuw;
            csa2.LBM = am.a(cst);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 2);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("songid", this.Aqo.AqO);
        jSONObject.put("mvquery", jSONObject2);
        jSONObject.put("songinfobufferbase64", this.Aqk);
        csa csa3 = this.Aqy;
        if (csa3 != null) {
            csa3.source = jSONObject.toString();
            AppMethodBeat.o(259197);
            return;
        }
        AppMethodBeat.o(259197);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6860;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256839);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256839);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256840);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListResp");
                AppMethodBeat.o(256840);
                throw tVar;
            }
            this.Aqj = (csb) aYK;
            csb csb = new csb();
            csb csb2 = this.Aqj;
            csb.parseFrom(csb2 != null ? csb2.toByteArray() : null);
            com.tencent.mm.plugin.mv.a.h hVar = com.tencent.mm.plugin.mv.a.h.Aqi;
            String str2 = this.Aqk;
            p.h(str2, "songInfoBase64");
            p.h(csb, "response");
            if (com.tencent.mm.plugin.mv.a.h.mxg) {
                long currentTicks = Util.currentTicks();
                Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "putMvRecommendList, songInfoBase64:" + str2.hashCode() + ", response:" + csb.hashCode() + ", timestamp:" + currentTicks);
                com.tencent.mm.plugin.mv.a.h.Aqg.put(new j(str2), new com.tencent.mm.plugin.mv.a.i(csb, currentTicks));
                hVar.Hs(currentTicks);
            }
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(256840);
                return;
            }
            AppMethodBeat.o(256840);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256840);
            return;
        }
        AppMethodBeat.o(256840);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetMVRecommendList$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

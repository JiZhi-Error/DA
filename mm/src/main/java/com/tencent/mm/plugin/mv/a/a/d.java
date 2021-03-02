package com.tencent.mm.plugin.mv.a.a;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerDataUIC;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0014\u001a\u00020\u0010H\u0016J>\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFeedRecommendList;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "context", "Landroid/content/Context;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Landroid/content/Context;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class d extends m {
    public static final a Aqz = new a((byte) 0);
    public csb Aqj;
    private csa Aqy;
    private i callback;
    private final com.tencent.mm.ak.d iUB;

    static {
        AppMethodBeat.i(256826);
        AppMethodBeat.o(256826);
    }

    public d(Context context, b bVar) {
        aov aov;
        aov aov2;
        p.h(context, "context");
        AppMethodBeat.i(256825);
        d.a aVar = new d.a();
        aVar.sG(6860);
        aVar.MB("/cgi-bin/micromsg-bin/musiclivegetrelatedlist");
        aVar.c(new csa());
        aVar.d(new csb());
        com.tencent.mm.ak.d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListReq");
            AppMethodBeat.o(256825);
            throw tVar;
        }
        this.Aqy = (csa) aYJ;
        csa csa = this.Aqy;
        if (csa != null) {
            csa.scene = 101;
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        MusicMvMakerDataUIC musicMvMakerDataUIC = (MusicMvMakerDataUIC) com.tencent.mm.ui.component.a.ko(context).get(MusicMvMakerDataUIC.class);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bgmid", musicMvMakerDataUIC.Aqo.AqO);
        jSONObject.put("songname", musicMvMakerDataUIC.Aqo.BPc);
        jSONObject.put("singername", musicMvMakerDataUIC.Aqo.lDR);
        jSONObject.put("songdesc", "");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", 1);
        jSONObject2.put("bgmquery", jSONObject);
        com.tencent.mm.plugin.mv.ui.a aVar3 = com.tencent.mm.plugin.mv.ui.a.ArA;
        jSONObject2.put("songinfobufferbase64", com.tencent.mm.plugin.mv.ui.a.b(musicMvMakerDataUIC.Aqo));
        csa csa2 = this.Aqy;
        if (csa2 != null) {
            csa2.source = jSONObject2.toString();
        }
        Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "create NetSceneMusicMvGetFeedRecommendList songId:" + musicMvMakerDataUIC.Aqo.AqO);
        csa csa3 = this.Aqy;
        if (csa3 != null) {
            csa3.LBM = new aov();
        }
        csa csa4 = this.Aqy;
        if (!(csa4 == null || (aov2 = csa4.LBM) == null)) {
            aov2.scene = 93;
        }
        csa csa5 = this.Aqy;
        if (!(csa5 == null || (aov = csa5.LBM) == null)) {
            aov.ulj = cl.aWz();
        }
        csa csa6 = this.Aqy;
        if (csa6 != null) {
            csa6.LDs = bVar;
            AppMethodBeat.o(256825);
            return;
        }
        AppMethodBeat.o(256825);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6860;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256823);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256823);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256824);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListResp");
                AppMethodBeat.o(256824);
                throw tVar;
            }
            this.Aqj = (csb) aYK;
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(256824);
                return;
            }
            AppMethodBeat.o(256824);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256824);
            return;
        }
        AppMethodBeat.o(256824);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFeedRecommendList$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

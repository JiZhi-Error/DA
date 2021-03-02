package com.tencent.mm.plugin.mv.a.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001a\u001a\u00020\u0005H\u0016J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetBeatTrack;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicTotalDuration", "", "mvHashCode", "pageHashCode", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;III)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getMusicTotalDuration", "()I", "getMvHashCode", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class c extends m {
    public static final a Aqx = new a((byte) 0);
    public final axy Aqo;
    private cry Aqt;
    public crz Aqu;
    public final int Aqv;
    public final int Aqw;
    private i callback;
    private final d iUB;

    static {
        AppMethodBeat.i(256822);
        AppMethodBeat.o(256822);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(axy axy, int i2, int i3, int i4) {
        super(i4);
        p.h(axy, "songInfo");
        AppMethodBeat.i(259195);
        this.Aqo = axy;
        this.Aqv = i2;
        this.Aqw = i3;
        d.a aVar = new d.a();
        aVar.sG(5904);
        aVar.MB("/cgi-bin/micromsg-bin/musiclivegetbeattrack");
        aVar.c(new cry());
        aVar.d(new crz());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetBeatTrackReq");
            AppMethodBeat.o(259195);
            throw tVar;
        }
        this.Aqt = (cry) aYJ;
        cry cry = this.Aqt;
        if (cry != null) {
            cry.MwX = this.Aqo.AqO;
        }
        cry cry2 = this.Aqt;
        if (cry2 != null) {
            cry2.MqW = this.Aqo.BPc;
        }
        cry cry3 = this.Aqt;
        if (cry3 != null) {
            cry3.lDR = this.Aqo.lDR;
        }
        cry cry4 = this.Aqt;
        if (cry4 != null) {
            cry4.Mxa = this.Aqo.musicDataUrl;
        }
        cry cry5 = this.Aqt;
        if (cry5 != null) {
            cry5.qHg = this.Aqo.LIg;
        }
        cry cry6 = this.Aqt;
        if (cry6 != null) {
            cry6.Mxb = this.Aqv;
        }
        cry cry7 = this.Aqt;
        if (cry7 != null) {
            cry7.Aqo = this.Aqo;
            AppMethodBeat.o(259195);
            return;
        }
        AppMethodBeat.o(259195);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5904;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256819);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256819);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256820);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i("MicroMsg.Mv.NetSceneMusicMvGetBeatTrack", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetBeatTrackResp");
                AppMethodBeat.o(256820);
                throw tVar;
            }
            this.Aqu = (crz) aYK;
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(256820);
                return;
            }
            AppMethodBeat.o(256820);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256820);
            return;
        }
        AppMethodBeat.o(256820);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetBeatTrack$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

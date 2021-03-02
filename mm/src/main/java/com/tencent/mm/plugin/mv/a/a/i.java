package com.tencent.mm.plugin.mv.a.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J>\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetSongStatus;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCommReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setCommReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;)V", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class i extends m {
    private csc AqK;
    public csd AqL;
    private final axy Aqo;
    private final String TAG = "MicroMsg.Mv.NetSceneMusicMvGetSongStatus";
    private com.tencent.mm.ak.i callback;
    private d iUB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(axy axy, int i2) {
        super(i2);
        p.h(axy, "songInfo");
        AppMethodBeat.i(259198);
        this.Aqo = axy;
        d.a aVar = new d.a();
        aVar.sG(5292);
        aVar.MB("/cgi-bin/micromsg-bin/musiclivegetsongstatus");
        aVar.c(new csc());
        aVar.d(new csd());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqResp");
        a aYJ = aXF.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetSongStatusReq");
            AppMethodBeat.o(259198);
            throw tVar;
        }
        this.AqK = (csc) aYJ;
        csc csc = this.AqK;
        if (csc != null) {
            csc.MwX = this.Aqo.AqO;
        }
        csc csc2 = this.AqK;
        if (csc2 != null) {
            csc2.Mxj = this.Aqo.LIf;
        }
        csc csc3 = this.AqK;
        if (csc3 != null) {
            csc3.Mxk = this.Aqo.LIg;
        }
        csc csc4 = this.AqK;
        if (csc4 != null) {
            csc4.MwY = this.Aqo;
        }
        this.iUB = aXF;
        Log.i(this.TAG, "create NetSceneMusicMvGetSongStatus " + this.Aqo.AqO + ' ' + this.Aqo.BPc + ' ' + this.Aqo.lDR);
        AppMethodBeat.o(259198);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(256843);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256843);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5292;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256844);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            d dVar = this.iUB;
            a aYK = dVar != null ? dVar.aYK() : null;
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetSongStatusResp");
                AppMethodBeat.o(256844);
                throw tVar;
            }
            this.AqL = (csd) aYK;
            com.tencent.mm.ak.i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(256844);
                return;
            }
            AppMethodBeat.o(256844);
            return;
        }
        com.tencent.mm.ak.i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256844);
            return;
        }
        AppMethodBeat.o(256844);
    }
}

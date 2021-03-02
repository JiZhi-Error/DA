package com.tencent.mm.plugin.mv.a.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J>\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvCheckPermission;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;)V", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class a extends m {
    private crw Aqm;
    public crx Aqn;
    private final axy Aqo;
    private final String TAG = "MicroMsg.Mv.NetSceneMusicMvCheckPermission";
    private i callback;
    private d iUB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(axy axy, int i2) {
        super(i2);
        p.h(axy, "songInfo");
        AppMethodBeat.i(259194);
        this.Aqo = axy;
        d.a aVar = new d.a();
        aVar.sG(5286);
        aVar.MB("/cgi-bin/micromsg-bin/musiclivecheckpermission");
        aVar.c(new crw());
        aVar.d(new crx());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqResp");
        com.tencent.mm.bw.a aYJ = aXF.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveCheckPermissionReq");
            AppMethodBeat.o(259194);
            throw tVar;
        }
        this.Aqm = (crw) aYJ;
        crw crw = this.Aqm;
        if (crw != null) {
            crw.MwY = this.Aqo;
        }
        this.iUB = aXF;
        AppMethodBeat.o(259194);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256812);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256812);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5286;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256813);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            d dVar = this.iUB;
            com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveCheckPermissionResp");
                AppMethodBeat.o(256813);
                throw tVar;
            }
            this.Aqn = (crx) aYK;
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(256813);
                return;
            }
            AppMethodBeat.o(256813);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256813);
            return;
        }
        AppMethodBeat.o(256813);
    }
}

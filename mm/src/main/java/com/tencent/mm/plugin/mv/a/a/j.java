package com.tencent.mm.plugin.mv.a.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J>\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u00032\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0004\u001a\u0004\u0018\u00010&H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvHeartbeat;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songId", "", "cookie", "Lcom/tencent/mm/protobuf/ByteString;", "offline", "", "pageHashCode", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCookie", "()Lcom/tencent/mm/protobuf/ByteString;", "getOffline", "()Z", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatResp;", "getSongId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "", "Companion", "plugin-mv_release"})
public final class j extends m {
    public static final a AqR = new a((byte) 0);
    private cse AqM;
    public csf AqN;
    private final String AqO;
    private final b AqP;
    private final boolean AqQ;
    private i callback;
    private final d iUB;

    static {
        AppMethodBeat.i(256849);
        AppMethodBeat.o(256849);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(String str, b bVar, boolean z, int i2) {
        super(i2);
        p.h(str, "songId");
        p.h(bVar, "cookie");
        AppMethodBeat.i(259199);
        this.AqO = str;
        this.AqP = bVar;
        this.AqQ = z;
        d.a aVar = new d.a();
        aVar.sG(6820);
        aVar.MB("/cgi-bin/micromsg-bin/musicliveheartbeat");
        aVar.c(new cse());
        aVar.d(new csf());
        d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveHeartbeatReq");
            AppMethodBeat.o(259199);
            throw tVar;
        }
        this.AqM = (cse) aYJ;
        cse cse = this.AqM;
        if (cse != null) {
            cse.MwX = this.AqO;
        }
        cse cse2 = this.AqM;
        if (cse2 != null) {
            cse2.AqP = this.AqP;
        }
        cse cse3 = this.AqM;
        if (cse3 != null) {
            cse3.AqQ = this.AqQ;
            AppMethodBeat.o(259199);
            return;
        }
        AppMethodBeat.o(259199);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6820;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256846);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256846);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.mv.a.a.m, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256847);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i("MicroMsg.Mv.NetSceneMusicMvHeartbeat", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveHeartbeatResp");
                AppMethodBeat.o(256847);
                throw tVar;
            }
            this.AqN = (csf) aYK;
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(256847);
                return;
            }
            AppMethodBeat.o(256847);
            return;
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(256847);
            return;
        }
        AppMethodBeat.o(256847);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvHeartbeat$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

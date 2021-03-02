package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007J\b\u0010 \u001a\u00020\u0005H\u0016J\u0006\u0010!\u001a\u00020\"J>\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00032\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetDraft;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUserName", "", "objectType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUserName", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getObjectType", "()I", "getPullType", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getObjectList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getResponseLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bf extends ax {
    public static final a tvi = new a((byte) 0);
    private i callback;
    public d iUB;
    private final b lastBuffer;
    private final int objectType;
    private int pullType;
    private final String sBN;

    static {
        AppMethodBeat.i(242388);
        AppMethodBeat.o(242388);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetDraft$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public bf(String str, int i2, b bVar, int i3, bbn bbn) {
        super(bbn);
        AppMethodBeat.i(242387);
        this.sBN = str;
        this.objectType = i2;
        this.lastBuffer = bVar;
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/findergetdraft");
        arv arv = new arv();
        arv.username = this.sBN;
        arv.objectType = this.objectType;
        arv.lastBuffer = this.lastBuffer;
        am amVar = am.tuw;
        arv.LBM = am.a(bbn);
        aVar.c(arv);
        aVar.d(new arw());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.iUB = aXF;
        this.pullType = i3;
        Log.i("Finder.NetSceneFinderGetDraft", "NetSceneFinderGetDraft init finderUserName " + this.sBN + " objectType: " + this.objectType + " lastBuffer:" + this.lastBuffer);
        AppMethodBeat.o(242387);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5801;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242385);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(242385);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242386);
        Log.i("Finder.NetSceneFinderMVUserPage", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0 && this.iUB.aYK() == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
            AppMethodBeat.o(242386);
            throw tVar;
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242386);
    }
}

package com.tencent.mm.plugin.finder.cgi;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u0006\u0010!\u001a\u00020\u0014J>\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u000e\u0010\u000e\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", SearchIntents.EXTRA_QUERY, "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "isFromHistory", "", "()Z", "setFromHistory", "(Z)V", "isFromHotSearch", "setFromHotSearch", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "isHotWordRequest", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cf extends ax {
    public static final a twm = new a((byte) 0);
    private final String TAG;
    private i callback;
    private d iUB;
    public boolean twi;
    public boolean twj;
    private b twk;
    public bcb twl;

    static {
        AppMethodBeat.i(242504);
        AppMethodBeat.o(242504);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cf(String str, int i2, String str2, b bVar, int i3, bbn bbn, int i4) {
        this(str, i2, str2, bVar, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? null : bbn, (b) null);
        AppMethodBeat.i(242503);
        AppMethodBeat.o(242503);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cf(String str, int i2, String str2, b bVar, int i3, bbn bbn, b bVar2) {
        super(bbn);
        p.h(str, SearchIntents.EXTRA_QUERY);
        p.h(str2, "requestId");
        AppMethodBeat.i(242502);
        this.TAG = "Finder.NetSceneFinderSearch";
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/findersearch");
        bca bca = new bca();
        bca.query = str;
        bca.offset = i2;
        bca.tVM = bVar;
        bca.scene = i3;
        bca.dPI = str2;
        am amVar = am.tuw;
        bca.uli = am.a(bbn);
        bca.LLg = bVar2;
        this.twk = bVar2;
        aVar.c(bca);
        aVar.d(new bcb());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.iUB = aXF;
        Log.i(this.TAG, "NetSceneFinderSearch init query " + str + " offset " + i2);
        this.twl = new bcb();
        AppMethodBeat.o(242502);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch$Companion;", "", "()V", "GET_HOT_WORD_SCENE", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3820;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165268);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(165268);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242501);
        Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        com.tencent.mm.bw.a aYK = this.iUB.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
            AppMethodBeat.o(242501);
            throw tVar;
        }
        this.twl = (bcb) aYK;
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
        }
        bbn bbn = this.ttO;
        if (bbn != null) {
            LinkedList<FinderObject> linkedList = this.twl.tbD;
            p.g(linkedList, "response.objectList");
            for (T t : linkedList) {
                String str2 = t.sessionBuffer;
                if (str2 != null) {
                    k kVar = k.vfA;
                    k.e(t.id, bbn.tCE, str2);
                }
            }
            AppMethodBeat.o(242501);
            return;
        }
        AppMethodBeat.o(242501);
    }
}

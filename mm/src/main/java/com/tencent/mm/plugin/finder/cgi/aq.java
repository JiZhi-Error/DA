package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u001c\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u0006\u00100\u001a\u00020\u0013J\b\u00101\u001a\u0004\u0018\u00010\nJ\b\u00102\u001a\u00020\fH\u0016J\u0006\u00103\u001a\u00020\u0004J>\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "feedId", "", "encryptedFeedId", "maxId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "getReq_username", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getAdFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getPrivateLock", "getResponseBuffer", "getType", "getWording", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aq extends ax implements m {
    public static final a tuJ = new a((byte) 0);
    private i callback;
    private final long feedId;
    public int pullType;
    public d rr;
    public boolean tuG = true;
    private final String tuH;
    private final String tuI;

    static {
        AppMethodBeat.i(242334);
        AppMethodBeat.o(242334);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aq(String str, long j2, String str2, long j3, b bVar, int i2, bbn bbn) {
        super(bbn);
        String str3;
        String str4;
        p.h(str, "req_username");
        p.h(str2, "encryptedFeedId");
        AppMethodBeat.i(242333);
        this.tuH = str;
        this.feedId = j2;
        this.tuI = str2;
        c.a aVar = c.tsp;
        g asG = c.a.asG(this.tuH);
        if (asG == null || (str4 = asG.field_firstPageMD5) == null) {
            str3 = "";
        } else {
            str3 = str4;
        }
        d.a aVar2 = new d.a();
        aVar2.MB("/cgi-bin/micromsg-bin/finderaduserpage");
        aVar2.sG(getType());
        aol aol = new aol();
        aol.username = this.tuH;
        aol.DIf = j3;
        aol.firstPageMD5 = str3;
        am amVar = am.tuw;
        aol.LAv = am.cXZ();
        aol.LAt = z.aUg();
        am amVar2 = am.tuw;
        aol.uli = am.a(bbn);
        aov aov = aol.uli;
        if (aov != null) {
            aov.scene = bbn != null ? bbn.tyh : 0;
        }
        if (n.I(aol.username, aol.LAt, false)) {
            aol.LAu = 1;
        }
        aol.LAw = this.feedId;
        aol.tNK = this.tuI;
        aol.lastBuffer = bVar;
        aom aom = new aom();
        aVar2.c(aol);
        aVar2.d(aom);
        d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        this.pullType = i2;
        Log.i("Finder.NetSceneAdFeedListval", "NetSceneFinderUserPage init maxId " + j3 + " username " + this.tuH + " pullType " + i2 + " fpMD5 " + str3);
        AppMethodBeat.o(242333);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6692;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(242331);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242331);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242332);
        Log.i("Finder.NetSceneAdFeedListval", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
                AppMethodBeat.o(242332);
                throw tVar;
            }
            this.tuG = ((aom) aYK).continueFlag == 1;
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242332);
    }
}

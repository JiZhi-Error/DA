package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B;\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rBI\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u001c\u0010A\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EJ\b\u0010G\u001a\u0004\u0018\u00010\u0003J\b\u0010H\u001a\u0004\u0018\u00010\u0003J\b\u0010I\u001a\u00020\u0005H\u0016J\u0006\u0010J\u001a\u00020KJ\b\u0010L\u001a\u00020KH\u0016J>\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010\u00112\b\u00109\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010V\u001a\u00020NH\u0002R\u000e\u0010\u0017\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001a\u00102\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u000e\u00109\u001a\u00020:X.¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"¨\u0006W"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLiveRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "objectId", "", "nonceId", "", "sessionBuffer", "scene", "baseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "TAG", "getBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "setBaseRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "getFeedId", "()J", "setFeedId", "(J)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "getNonceId", "setNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getSessionBuffer", "setSessionBuffer", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class bn extends ax {
    private final String TAG = "NetSceneFinderGetLiveRelatedList";
    private i callback;
    private String category = "";
    private long feedId;
    private String hwg = "";
    private float iUY;
    private float iUZ;
    private final b lastBuffer;
    public int pullType;
    public d rr;
    private String sessionBuffer = "";
    private int tvr = -1;
    private bcc tvs;
    private aov tvt;

    public bn(long j2, String str, String str2, b bVar, int i2, float f2, float f3, aov aov) {
        p.h(str, "nonceId");
        p.h(str2, "sessionBuffer");
        p.h(aov, "baseRequest");
        AppMethodBeat.i(260188);
        this.feedId = j2;
        this.hwg = str;
        this.sessionBuffer = str2;
        this.lastBuffer = bVar;
        this.tvr = i2;
        this.iUZ = f2;
        this.iUY = f3;
        this.tvs = null;
        this.tvt = aov;
        d.a aVar = new d.a();
        aVar.sG(getType());
        asv asv = new asv();
        asv.object_id = this.feedId;
        asv.object_nonce_id = this.hwg;
        asv.dTj = this.iUZ;
        asv.latitude = this.iUY;
        asv.LDs = this.lastBuffer;
        asv.LER = this.sessionBuffer;
        aov aov2 = this.tvt;
        if (aov2 == null) {
            am amVar = am.tuw;
            aov2 = am.a(this.ttO);
        }
        asv.LBM = aov2;
        asv.scene = this.tvr;
        aVar.c(asv);
        aVar.d(new asw());
        aVar.MB("/cgi-bin/micromsg-bin/findergetliverelatedlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "feedId " + this.feedId + "  category " + this.category + " lastBuffer relScene:" + this.tvr + ' ' + this.lastBuffer);
        AppMethodBeat.o(260188);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6479;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242434);
        this.callback = iVar;
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        int dispatch = dispatch(gVar, dVar, this);
        AppMethodBeat.o(242434);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242435);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("feedId ").append(this.feedId).append(", ");
            al alVar = al.tuv;
            Log.i(str2, append.append(al.dQ(cYr())).toString());
            Iterator<T> it = cYr().iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242435);
    }

    public final LinkedList<FinderObject> cYr() {
        AppMethodBeat.i(242436);
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        a aYK = dVar.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRelatedListResponse");
            AppMethodBeat.o(242436);
            throw tVar;
        }
        LinkedList<FinderObject> linkedList = ((asw) aYK).object;
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        AppMethodBeat.o(242436);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final boolean cXQ() {
        return true;
    }
}

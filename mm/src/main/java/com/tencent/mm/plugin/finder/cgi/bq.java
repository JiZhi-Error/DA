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
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001BC\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u001c\u0010@\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DJ\b\u0010F\u001a\u0004\u0018\u00010\u0005J\b\u0010G\u001a\u0004\u0018\u00010\u0005J\b\u0010H\u001a\u00020\u0003H\u0016J\u0006\u0010I\u001a\u00020JJ\b\u0010K\u001a\u00020JH\u0016J>\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00032\b\u0010Q\u001a\u0004\u0018\u00010\u00122\b\u00109\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010U\u001a\u00020MH\u0002R\u000e\u0010\u0017\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001a\u00102\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u000e\u00109\u001a\u00020:X.¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00104¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "relScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "objectId", "", "nonceId", "", "scene", "baseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "(IJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "TAG", "getBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "setBaseRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "feedId", "getFeedId", "()J", "setFeedId", "(J)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "getNonceId", "setNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "getRelScene", "setRelScene", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "setSectionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;)V", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "realInit", "plugin-finder_release"})
public final class bq extends ax {
    private final String TAG = "Finder.NetSceneFinderGetRelatedList";
    private i callback;
    private String category = "";
    private final int dLS;
    private long feedId;
    private String hwg = "";
    private float iUY;
    private float iUZ;
    private final b lastBuffer;
    public int pullType;
    private d rr;
    private int tvr = -1;
    private bcc tvs;
    private aov tvt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bq(int i2, b bVar, float f2, float f3, bcc bcc, bbn bbn) {
        super(bbn);
        p.h(bcc, "sectionInfo");
        AppMethodBeat.i(242450);
        this.dLS = i2;
        this.lastBuffer = bVar;
        this.tvr = 2;
        this.iUZ = f2;
        this.iUY = f3;
        this.tvs = bcc;
        cYE();
        AppMethodBeat.o(242450);
    }

    public bq(int i2, long j2, String str, b bVar, int i3, float f2, float f3, aov aov) {
        p.h(str, "nonceId");
        p.h(aov, "baseRequest");
        AppMethodBeat.i(242451);
        this.dLS = i2;
        this.feedId = j2;
        this.hwg = str;
        this.lastBuffer = bVar;
        this.tvr = i3;
        this.iUZ = f2;
        this.iUY = f3;
        this.tvs = null;
        this.tvt = aov;
        cYE();
        AppMethodBeat.o(242451);
    }

    private final void cYE() {
        AppMethodBeat.i(242444);
        d.a aVar = new d.a();
        aVar.sG(getType());
        ato ato = new ato();
        ato.hFK = this.feedId;
        ato.objectNonceId = this.hwg;
        ato.dLS = this.dLS;
        ato.dTj = this.iUZ;
        ato.latitude = this.iUY;
        ato.lastBuffer = this.lastBuffer;
        aov aov = this.tvt;
        if (aov == null) {
            am amVar = am.tuw;
            aov = am.a(this.ttO);
        }
        ato.LAI = aov;
        ato.scene = this.tvr;
        ato.tvs = this.tvs;
        aVar.c(ato);
        aVar.d(new atp());
        aVar.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetRelatedList feedId " + this.feedId + " tabType " + this.dLS + " category " + this.category + " lastBuffer " + this.lastBuffer);
        AppMethodBeat.o(242444);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3688;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242445);
        this.callback = iVar;
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        int dispatch = dispatch(gVar, dVar, this);
        AppMethodBeat.o(242445);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242446);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.dLS).append(", ");
            al alVar = al.tuv;
            Log.i(str2, append.append(al.dQ(cYr())).toString());
            Iterator<T> it = cYr().iterator();
            while (it.hasNext()) {
                d(it.next());
            }
            d dVar = this.rr;
            if (dVar == null) {
                p.btv("rr");
            }
            a aYK = dVar.aYK();
            if (aYK instanceof atp) {
                com.tencent.mm.plugin.finder.preload.a aVar = com.tencent.mm.plugin.finder.preload.a.uTO;
                baw baw = ((atp) aYK).preloadInfo;
                LinkedList<FinderObject> linkedList = ((atp) aYK).object;
                p.g(linkedList, "resp.`object`");
                com.tencent.mm.plugin.finder.preload.a.a(baw, linkedList, 3688);
            }
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242446);
    }

    public final b cYm() {
        AppMethodBeat.i(242447);
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        a aYK = dVar.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(242447);
            throw tVar;
        }
        b bVar = ((atp) aYK).lastBuffer;
        AppMethodBeat.o(242447);
        return bVar;
    }

    public final LinkedList<FinderObject> cYr() {
        AppMethodBeat.i(242448);
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        a aYK = dVar.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(242448);
            throw tVar;
        }
        LinkedList<FinderObject> linkedList = ((atp) aYK).object;
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        AppMethodBeat.o(242448);
        return linkedList;
    }

    public final boolean cYp() {
        AppMethodBeat.i(242449);
        d dVar = this.rr;
        if (dVar == null) {
            p.btv("rr");
        }
        a aYK = dVar.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(242449);
            throw tVar;
        } else if (((atp) aYK).continueFlag != 0) {
            AppMethodBeat.o(242449);
            return true;
        } else {
            AppMethodBeat.o(242449);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final boolean cXQ() {
        return true;
    }
}

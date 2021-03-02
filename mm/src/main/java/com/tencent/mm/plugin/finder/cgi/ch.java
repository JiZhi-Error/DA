package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003J\b\u0010 \u001a\u00020\u000eH\u0016J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\"H\u0016J>\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "responseList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getResponseList", "()Ljava/util/ArrayList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ch extends ax {
    private final String TAG = "Finder.NetSceneFinderSnsGetLiveObjectList";
    private i callback;
    private final b lastBuffer;
    public int pullType;
    public d rr;
    public final ArrayList<bo> twn = new ArrayList<>();

    public ch(b bVar, bbn bbn) {
        super(bbn);
        AppMethodBeat.i(242511);
        this.lastBuffer = bVar;
        d.a aVar = new d.a();
        aVar.sG(getType());
        bco bco = new bco();
        bco.lastBuffer = this.lastBuffer;
        am amVar = am.tuw;
        bco.LAI = am.a(bbn);
        aVar.c(bco);
        aVar.d(new bcp());
        aVar.MB("/cgi-bin/micromsg-bin/findersnsgetliveobjectlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderSnsGetLiveObjectList pullType:" + this.pullType + " lastBuffer:" + (this.lastBuffer == null ? BuildConfig.COMMAND : MD5Util.getMD5String(this.lastBuffer.zy)));
        AppMethodBeat.o(242511);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6847;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242509);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242509);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        LinkedList<Long> linkedList;
        awe awe;
        AppMethodBeat.i(242510);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
                AppMethodBeat.o(242510);
                throw tVar;
            }
            bcp bcp = (bcp) aYK;
            LinkedList<FinderObject> linkedList2 = bcp.LLG;
            LinkedList<bcm> linkedList3 = bcp.LLI;
            bcn bcn = bcp.LLH;
            if (!(bcn == null || (linkedList = bcn.LLF) == null)) {
                for (T t : linkedList) {
                    if (linkedList2 != null) {
                        for (T t2 : linkedList2) {
                            long j2 = t2.id;
                            if (t != null && j2 == t.longValue()) {
                                awe awe2 = t2.liveInfo;
                                long j3 = awe2 != null ? awe2.liveId : 0;
                                int i5 = 0;
                                Iterator<bo> it = this.twn.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        i5 = -1;
                                        break;
                                    }
                                    bo next = it.next();
                                    if ((next instanceof y) && (awe = ((y) next).uOo.liveInfo) != null && awe.liveId == j3) {
                                        break;
                                    }
                                    i5++;
                                }
                                if (i5 >= 0) {
                                    Log.i(this.TAG, "exist: " + ((Object) t) + ", " + j3 + ", filter");
                                } else {
                                    ArrayList<bo> arrayList = this.twn;
                                    p.g(t2, LocaleUtil.ITALIAN);
                                    arrayList.add(new y(t2));
                                }
                            }
                        }
                    }
                    if (linkedList3 != null) {
                        for (T t3 : linkedList3) {
                            long j4 = t3.uOx;
                            if (t != null && j4 == t.longValue()) {
                                this.twn.add(new ak(t3.uOx));
                            }
                        }
                    }
                }
            }
            if (this.twn.isEmpty() && linkedList2 != null) {
                if (!linkedList2.isEmpty()) {
                    ArrayList<bo> arrayList2 = this.twn;
                    LinkedList<FinderObject> linkedList4 = linkedList2;
                    ArrayList arrayList3 = new ArrayList(j.a(linkedList4, 10));
                    for (T t4 : linkedList4) {
                        p.g(t4, LocaleUtil.ITALIAN);
                        arrayList3.add(new y(t4));
                    }
                    arrayList2.addAll(arrayList3);
                }
            }
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SNS_LIVE_LIST_SETTING_ENABLE_INT_SYNC, Integer.valueOf(bcp.LLJ ? 1 : 0));
            Log.i(this.TAG, "responseList size:" + this.twn.size() + ", resp.enableSetting:" + bcp.LLJ);
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242510);
            return;
        }
        AppMethodBeat.o(242510);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final boolean cXQ() {
        return true;
    }
}

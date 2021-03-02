package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.stats.LoggingConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.component.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015B#\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aB?\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u001eJ\u0010\u00108\u001a\u0002092\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>J\b\u0010@\u001a\u0004\u0018\u00010\tJ\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u0004\u0018\u00010\tJ\b\u0010D\u001a\u00020\u0007H\u0016J\b\u0010E\u001a\u0004\u0018\u00010\u0005J\u0006\u0010F\u001a\u00020GJ>\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\b\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016R\u000e\u0010\u001f\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#¨\u0006P"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "feedId", "", "nonceId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "category", "scene", "fromUserName", "toUserName", "sessionId", "sessionBuffer", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "poiLatitude", "", "poiLongitude", "(JLjava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;FF)V", LoggingConstants.LOG_FILE_PREFIX, "Lcom/tencent/mm/protocal/protobuf/Stats;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "(Lcom/tencent/mm/protocal/protobuf/Stats;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "", "get_column_feed_info", "Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "(Lcom/tencent/mm/protobuf/ByteString;ILjava/util/List;Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "getFromUserName", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "getTabType", "getToUserName", "buildStatsRequest", "", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getResponseBuffer", "getType", "getWording", "hasContinue", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bh extends ax {
    private final String TAG;
    private i callback;
    private String category;
    private final String dJw;
    private final int dLS;
    private final String dYs;
    public final long feedId;
    private final String hwg;
    public int pullType;
    private d rr;
    private int scene;
    private final String sessionId;
    private final b tvj;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ bh(long r18, java.lang.String r20, int r21, com.tencent.mm.bw.b r22, java.lang.String r23, int r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, com.tencent.mm.protocal.protobuf.bbn r28, float r29, float r30, int r31) {
        /*
            r17 = this;
            r2 = r31 & 16
            if (r2 == 0) goto L_0x005c
            java.lang.String r9 = ""
        L_0x0007:
            r2 = r31 & 64
            if (r2 == 0) goto L_0x0059
            java.lang.String r11 = ""
        L_0x000e:
            r0 = r31
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0056
            java.lang.String r12 = ""
        L_0x0017:
            r0 = r31
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0053
            java.lang.String r13 = ""
        L_0x0020:
            r0 = r31
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0050
            r15 = 0
        L_0x0027:
            r0 = r31
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x004d
            r16 = 0
        L_0x002f:
            r3 = r17
            r4 = r18
            r6 = r20
            r7 = r21
            r8 = r22
            r10 = r24
            r14 = r28
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r2 = 260187(0x3f85b, float:3.646E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r2 = 260187(0x3f85b, float:3.646E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x004d:
            r16 = r30
            goto L_0x002f
        L_0x0050:
            r15 = r29
            goto L_0x0027
        L_0x0053:
            r13 = r27
            goto L_0x0020
        L_0x0056:
            r12 = r26
            goto L_0x0017
        L_0x0059:
            r11 = r25
            goto L_0x000e
        L_0x005c:
            r9 = r23
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.bh.<init>(long, java.lang.String, int, com.tencent.mm.bw.b, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.protocal.protobuf.bbn, float, float, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bh(long j2, String str, int i2, b bVar, String str2, int i3, String str3, String str4, String str5, bbn bbn, float f2, float f3) {
        super(bbn);
        p.h(str, "nonceId");
        AppMethodBeat.i(260186);
        this.TAG = "Finder.NetSceneFinderGetFeedRelList";
        this.feedId = j2;
        this.hwg = str;
        this.dLS = i2;
        this.category = str2;
        this.scene = i3;
        this.dYs = str3;
        this.dJw = str4;
        this.sessionId = str5;
        this.tvj = null;
        d.a aVar = new d.a();
        aVar.sG(getType());
        ato ato = new ato();
        ato.hFK = j2;
        ato.objectNonceId = str;
        ato.dLS = i2;
        a aVar2 = a.PRN;
        a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        ato.dTj = dHP.first.floatValue();
        ato.latitude = dHP.second.floatValue();
        if (f3 != 0.0f) {
            ato.dTj = f3;
        }
        if (f2 != 0.0f) {
            ato.latitude = f2;
        }
        ato.lastBuffer = bVar;
        am amVar = am.tuw;
        ato.LAI = am.a(bbn);
        aoz aoz = new aoz();
        aoz.xjU = str2;
        ato.LEr = aoz;
        ato.dkU = str3;
        ato.dkV = str4;
        ato.scene = i3;
        ato.LEs = null;
        ato.LEt = str5;
        ato.LEu = null;
        a(ato);
        aVar.c(ato);
        aVar.d(new atp());
        aVar.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "[init] fromUserName=" + str3 + ",toUserName=" + str4 + " feedId=" + com.tencent.mm.ac.d.zs(j2) + " tabType=" + i2 + ' ' + "commentScene=" + (bbn != null ? bbn.tCE : 0) + " category=" + str2 + " nonceId=" + str + " lastBuffer=" + bVar + " scene=" + i3 + " sessionId=" + str5 + " sessionBuffer=false");
        AppMethodBeat.o(260186);
    }

    public bh(ecq ecq, bbn bbn, ato ato) {
        long j2;
        boolean z = false;
        long j3 = 0;
        p.h(ato, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        AppMethodBeat.i(242404);
        this.TAG = "Finder.NetSceneFinderGetFeedRelList";
        this.feedId = ato.hFK;
        this.hwg = ato.objectNonceId;
        this.dLS = ato.dLS;
        aoz aoz = ato.LEr;
        this.category = aoz != null ? aoz.xjU : null;
        this.scene = ato.scene;
        this.dYs = ato.dkU;
        this.dJw = ato.dkV;
        this.sessionId = ato.LEt;
        this.tvj = ato.LEu;
        ato ato2 = new ato();
        ato2.lastBuffer = ato.lastBuffer;
        ato2.hFK = ato.hFK;
        ato2.dLS = ato.dLS;
        ato2.objectNonceId = ato.objectNonceId;
        ato2.LEp = ato.LEp;
        ato2.scene = ato.scene;
        ato2.LEq = ato.LEq;
        ato2.tvs = ato.tvs;
        ato2.LEr = ato.LEr;
        ato2.txf = ato.txf;
        ato2.dkU = ato.dkU;
        ato2.dkV = ato.dkV;
        ato2.LEs = ato.LEs;
        ato2.LEt = ato.LEt;
        ato2.LEu = ato.LEu;
        ato2.LEv = ato.LEv;
        ato2.tVd = ato.tVd;
        ato2.LEw = ato.LEw;
        ato2.LEx = ato.LEx;
        a aVar = a.PRN;
        a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        ato2.dTj = dHP.first.floatValue();
        am amVar = am.tuw;
        ato2.LAI = am.a(bbn);
        ato2.latitude = dHP.second.floatValue();
        ato2.LEw.add(ecq);
        a(ato2);
        d.a aVar2 = new d.a();
        aVar2.sG(getType());
        aVar2.c(ato2);
        aVar2.d(new atp());
        aVar2.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
        d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        String str = this.TAG;
        StringBuilder append = new StringBuilder("[init1] fromUserName=").append(this.dYs).append(",toUserName=").append(this.dJw).append(" feedId=").append(com.tencent.mm.ac.d.zs(this.feedId)).append(" tabType=").append(this.dLS).append(' ').append("commentScene=").append(bbn != null ? bbn.tCE : 0).append(" category=").append(this.category).append(" nonceId=").append(this.hwg).append(" lastBuffer=").append(ato2.lastBuffer).append(" scene=").append(this.scene).append(" sessionId=").append(this.sessionId).append(" sessionBuffer=").append(this.tvj != null ? true : z).append(' ').append("get_column_feed_info=");
        blo blo = ato2.tVd;
        if (blo != null) {
            j2 = blo.id;
        } else {
            j2 = 0;
        }
        StringBuilder append2 = append.append(com.tencent.mm.ac.d.zs(j2)).append(", switch_column_info=");
        efo efo = ato2.LEv;
        StringBuilder append3 = append2.append(com.tencent.mm.ac.d.zs(efo != null ? efo.id : 0)).append(' ').append("get_related_column_topic_info=");
        buj buj = ato2.LEx;
        Log.i(str, append3.append(com.tencent.mm.ac.d.zs(buj != null ? buj.id : j3)).toString());
        AppMethodBeat.o(242404);
    }

    public bh(b bVar, int i2, List<? extends ecq> list, blo blo, bbn bbn) {
        Long l;
        boolean z = false;
        Long l2 = null;
        AppMethodBeat.i(242405);
        this.TAG = "Finder.NetSceneFinderGetFeedRelList";
        ato ato = new ato();
        this.feedId = ato.hFK;
        this.hwg = ato.objectNonceId;
        this.dLS = ato.dLS;
        aoz aoz = ato.LEr;
        this.category = aoz != null ? aoz.xjU : null;
        this.dYs = ato.dkU;
        this.dJw = ato.dkV;
        this.sessionId = ato.LEt;
        this.tvj = ato.LEu;
        this.scene = i2;
        ato.scene = i2;
        if (list != null) {
            ato.LEw.addAll(list);
        }
        ato.lastBuffer = bVar;
        ato.tVd = blo;
        a aVar = a.PRN;
        a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        ato.dTj = dHP.first.floatValue();
        am amVar = am.tuw;
        ato.LAI = am.a(bbn);
        ato.latitude = dHP.second.floatValue();
        a(ato);
        d.a aVar2 = new d.a();
        aVar2.sG(getType());
        aVar2.c(ato);
        aVar2.d(new atp());
        aVar2.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
        d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        String str = this.TAG;
        StringBuilder append = new StringBuilder("[init2] fromUserName=").append(this.dYs).append(", toUserName=").append(this.dJw).append(" feedId=").append(com.tencent.mm.ac.d.zs(this.feedId)).append(" tabType=").append(this.dLS).append(' ').append("commentScene=").append(bbn != null ? bbn.tCE : 0).append(" category=").append(this.category).append(" nonceId=").append(this.hwg).append(' ').append("lastBuffer=").append(ato.lastBuffer).append(" scene=").append(i2).append(" sessionId=").append(this.sessionId).append(" sessionBuffer=").append(this.tvj != null ? true : z).append(' ').append("get_column_feed_info=");
        blo blo2 = ato.tVd;
        if (blo2 != null) {
            l = Long.valueOf(blo2.id);
        } else {
            l = null;
        }
        StringBuilder append2 = append.append(l).append(", switch_column_info=");
        efo efo = ato.LEv;
        StringBuilder append3 = append2.append(efo != null ? Long.valueOf(efo.id) : null).append(" cardBuffer=").append(bVar).append("get_related_column_topic_info=");
        buj buj = ato.LEx;
        Log.i(str, append3.append(buj != null ? Long.valueOf(buj.id) : l2).append(" stats=").append(ato.LEw.size()).toString());
        AppMethodBeat.o(242405);
    }

    private final void a(ato ato) {
        AppMethodBeat.i(242394);
        apc apc = new apc();
        apc.osName = com.tencent.mm.protocal.d.KyL;
        apc.osVersion = com.tencent.mm.protocal.d.KyM;
        apc.deviceBrand = com.tencent.mm.protocal.d.KyI;
        apc.deviceModel = com.tencent.mm.protocal.d.KyJ;
        apc.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        k kVar = k.vfA;
        apc.netType = k.dod();
        apc.LBf = CdnLogic.getRecentAverageSpeed(2);
        b.a aVar = com.tencent.mm.plugin.finder.video.reporter.b.whK;
        apc.LBg = com.tencent.mm.plugin.finder.video.reporter.b.whI;
        apc.LBh.add("h264");
        if (e.sX(4)) {
            apc.LBh.add("h265");
        }
        ato.LAv = apc;
        h hVar = h.veu;
        h.aq(this.dLS, true);
        AppMethodBeat.o(242394);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3688;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242395);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242395);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242396);
        h hVar = h.veu;
        h.aq(this.dLS, false);
        h.b(h.veu, this.dLS);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.dLS).append(", ");
            al alVar = al.tuv;
            Log.i(str2, append.append(al.dQ(cYr())).toString());
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK instanceof atp) {
                com.tencent.mm.plugin.finder.preload.a aVar = com.tencent.mm.plugin.finder.preload.a.uTO;
                baw baw = ((atp) aYK).preloadInfo;
                LinkedList<FinderObject> linkedList = ((atp) aYK).object;
                p.g(linkedList, "resp.`object`");
                com.tencent.mm.plugin.finder.preload.a.a(baw, linkedList, 3688);
                h hVar2 = h.veu;
                h.gd(this.dLS, ((atp) aYK).object.size());
            }
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
        AppMethodBeat.o(242396);
    }

    public final com.tencent.mm.bw.b cYm() {
        AppMethodBeat.i(242397);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(242397);
            throw tVar;
        }
        com.tencent.mm.bw.b bVar = ((atp) aYK).lastBuffer;
        AppMethodBeat.o(242397);
        return bVar;
    }

    public final atp cYq() {
        AppMethodBeat.i(242398);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(242398);
            throw tVar;
        }
        atp atp = (atp) aYK;
        AppMethodBeat.o(242398);
        return atp;
    }

    public final String getWording() {
        AppMethodBeat.i(242399);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(242399);
            throw tVar;
        }
        String str = ((atp) aYK).LAH;
        AppMethodBeat.o(242399);
        return str;
    }

    public final LinkedList<FinderObject> cYr() {
        AppMethodBeat.i(242400);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(242400);
            throw tVar;
        }
        LinkedList<FinderObject> linkedList = ((atp) aYK).object;
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        AppMethodBeat.o(242400);
        return linkedList;
    }

    public final boolean cYp() {
        AppMethodBeat.i(242401);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(242401);
            throw tVar;
        } else if (((atp) aYK).continueFlag != 0) {
            AppMethodBeat.o(242401);
            return true;
        } else {
            AppMethodBeat.o(242401);
            return false;
        }
    }
}

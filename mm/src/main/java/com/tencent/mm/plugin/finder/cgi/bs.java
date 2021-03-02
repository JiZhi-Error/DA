package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.protocal.protobuf.eiz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB7\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0010B?\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0014B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0015BI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0017B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0018BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0019B]\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010!J\u001c\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010=\u001a\u0004\u0018\u00010>J\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\u0005J\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BJ\u0006\u0010D\u001a\u00020\u0005J\b\u0010E\u001a\u0004\u0018\u00010FJ\b\u0010G\u001a\u0004\u0018\u00010HJ\u0006\u0010I\u001a\u00020\u0005J\b\u0010J\u001a\u0004\u0018\u00010\tJ\b\u0010K\u001a\u0004\u0018\u00010LJ\u0006\u0010M\u001a\u00020\u0005J\b\u0010N\u001a\u0004\u0018\u00010OJ\b\u0010P\u001a\u0004\u0018\u00010 J\u0006\u0010Q\u001a\u00020\u0007J\b\u0010R\u001a\u00020\u0005H\u0016J>\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010\u00032\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016R\u000e\u0010\"\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100¨\u0006]"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "topic", "", "topicType", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "topicId", "(Ljava/lang/Long;JLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "eventTopicId", "encryptedTopicId", "innerTabType", "(JLjava/lang/Long;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "topicBuffer", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;Ljava/lang/Long;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Ljava/lang/Long;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "poiClassifyId", "longitude", "", "latitude", "tabType", "topicRecommend", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/lang/String;FFLjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "getTopicType", "setTopicType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getContinueFlag", "getDisableFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFlag", "getMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getRequest", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListRequest;", "getRequestTopicType", "getRespLastBuffer", "getSubTitle", "Lcom/tencent/mm/protocal/protobuf/PoiTopicSubTitle;", "getTabType", "getTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicRecommends", "getTotalCount", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bs extends ax {
    private final String TAG;
    private i callback;
    public int pullType;
    public d rr;
    public String tvB;
    public int tvC;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bs(String str, Long l, b bVar, bcc bcc, bbn bbn) {
        super(bbn);
        p.h(str, "topic");
        AppMethodBeat.i(242461);
        this.TAG = "Finder.NetSceneFinderGetTopicFeed";
        d.a aVar = new d.a();
        aVar.sG(getType());
        atu atu = new atu();
        atu.tvC = 4;
        atu.dST = str;
        atu.LDs = bVar;
        if (l != null) {
            l.longValue();
            atu.trn = l.longValue();
        }
        atu.tvs = bcc;
        am amVar = am.tuw;
        atu.LCA = am.a(bbn);
        aVar.c(atu);
        aVar.sG(getType());
        aVar.d(new atv());
        aVar.MB("/cgi-bin/micromsg-bin/findergettopiclist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + str + ", " + l);
        this.tvC = 4;
        AppMethodBeat.o(242461);
    }

    public bs(long j2, Long l, String str, int i2, b bVar, bbn bbn) {
        super(bbn);
        String str2;
        AppMethodBeat.i(242462);
        this.TAG = "Finder.NetSceneFinderGetTopicFeed";
        d.a aVar = new d.a();
        aVar.sG(getType());
        atu atu = new atu();
        atu.tvC = 7;
        atu.twp = j2;
        if (l != null) {
            l.longValue();
            atu.trn = l.longValue();
        }
        if (!Util.isNullOrNil(str)) {
            atu.fromType = 4;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        atu.tTQ = str2;
        atu.LDs = bVar;
        atu.tTH = i2;
        am amVar = am.tuw;
        atu.LCA = am.a(bbn);
        aVar.c(atu);
        aVar.sG(getType());
        aVar.d(new atv());
        aVar.MB("/cgi-bin/micromsg-bin/findergettopiclist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetTopicFeed get eventTopic init eventTopicId:" + j2 + ", " + l + " encryptedTopicId:" + str + " innerTabType:" + i2);
        this.tvC = this.tvC;
        AppMethodBeat.o(242462);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bs(String str, Long l, b bVar, bcc bcc, bbn bbn, byte b2) {
        super(bbn);
        p.h(str, "topic");
        AppMethodBeat.i(242463);
        this.TAG = "Finder.NetSceneFinderGetTopicFeed";
        d.a aVar = new d.a();
        aVar.sG(getType());
        atu atu = new atu();
        atu.tvC = 1;
        atu.dST = str;
        atu.LDs = bVar;
        if (l != null) {
            l.longValue();
            atu.trn = l.longValue();
        }
        atu.tvs = bcc;
        am amVar = am.tuw;
        atu.LCA = am.a(bbn);
        aVar.c(atu);
        aVar.sG(getType());
        aVar.d(new atv());
        aVar.MB("/cgi-bin/micromsg-bin/findergettopiclist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + str + ", " + l);
        this.tvC = this.tvC;
        AppMethodBeat.o(242463);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bs(String str, long j2, b bVar, Long l, b bVar2, bcc bcc, bbn bbn) {
        super(bbn);
        p.h(str, "topic");
        AppMethodBeat.i(242464);
        this.TAG = "Finder.NetSceneFinderGetTopicFeed";
        d.a aVar = new d.a();
        aVar.sG(getType());
        atu atu = new atu();
        atu.tvC = 5;
        atu.dST = str;
        atu.twp = j2;
        atu.LDs = bVar2;
        atu.LEF = bVar;
        if (l != null) {
            l.longValue();
            atu.trn = l.longValue();
        }
        atu.tvs = bcc;
        am amVar = am.tuw;
        atu.LCA = am.a(bbn);
        aVar.c(atu);
        aVar.sG(getType());
        aVar.d(new atv());
        aVar.MB("/cgi-bin/micromsg-bin/findergettopiclist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + str + ", " + l);
        this.tvC = this.tvC;
        AppMethodBeat.o(242464);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bs(String str, long j2, b bVar, Long l, int i2, bbn bbn) {
        super(bbn);
        p.h(str, "topic");
        AppMethodBeat.i(242465);
        this.TAG = "Finder.NetSceneFinderGetTopicFeed";
        d.a aVar = new d.a();
        aVar.sG(getType());
        atu atu = new atu();
        atu.tvC = i2;
        atu.dST = str;
        atu.twp = j2;
        atu.LDs = null;
        atu.LEF = bVar;
        if (l != null) {
            l.longValue();
            atu.trn = l.longValue();
        }
        am amVar = am.tuw;
        atu.LCA = am.a(bbn);
        aVar.c(atu);
        aVar.sG(getType());
        aVar.d(new atv());
        aVar.MB("/cgi-bin/micromsg-bin/findergettopiclist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + str + ", " + l);
        this.tvC = i2;
        AppMethodBeat.o(242465);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bs(String str, float f2, float f3, Long l, b bVar, int i2, dmk dmk, bcc bcc, bbn bbn) {
        super(bbn);
        p.h(str, "poiClassifyId");
        AppMethodBeat.i(242466);
        this.TAG = "Finder.NetSceneFinderGetTopicFeed";
        d.a aVar = new d.a();
        aVar.sG(getType());
        atu atu = new atu();
        atu.tvC = 2;
        atu.dST = str;
        atu.dTj = f2;
        atu.latitude = f3;
        atu.LDs = bVar;
        if (l != null) {
            l.longValue();
            atu.trn = l.longValue();
        }
        atu.tvs = bcc;
        atu.fromType = 1;
        if (bcc != null) {
            atu.fromType = 2;
        }
        atu.dLS = i2;
        if (dmk != null) {
            eiz eiz = new eiz();
            LinkedList<Long> linkedList = new LinkedList<>();
            LinkedList<bds> linkedList2 = dmk.MPW;
            p.g(linkedList2, "topicRecommend.topic_list");
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                linkedList.add(Long.valueOf(it.next().twp));
            }
            eiz.NiM = linkedList;
            atu.LEE = eiz;
            this.tvB = dmk.MPW.get(0).dST;
        }
        am amVar = am.tuw;
        atu.LCA = am.a(bbn);
        aVar.c(atu);
        aVar.sG(getType());
        aVar.d(new atv());
        aVar.MB("/cgi-bin/micromsg-bin/findergettopiclist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetTopicFeed get poi init: " + str + ' ' + l);
        this.tvC = this.tvC;
        AppMethodBeat.o(242466);
    }

    public /* synthetic */ bs(String str, float f2, float f3, Long l, b bVar, dmk dmk, bcc bcc, bbn bbn) {
        this(str, f2, f3, l, bVar, -1, dmk, bcc, bbn);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 817;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165233);
        k kVar = k.vfA;
        bbn bbn = this.ttO;
        k.Ku(bbn != null ? bbn.tCE : 0);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165233);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242457);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("pullType ").append(this.pullType).append(" selectedTag").append(this.tvB).append(' ');
            al alVar = al.tuv;
            Log.i(str2, append.append(al.dQ(cYH())).toString());
            a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
                AppMethodBeat.o(242457);
                throw tVar;
            }
            atv atv = (atv) aYK;
            com.tencent.mm.plugin.finder.preload.a aVar = com.tencent.mm.plugin.finder.preload.a.uTO;
            baw baw = atv.preloadInfo;
            LinkedList<FinderObject> linkedList = atv.object;
            p.g(linkedList, "resp.`object`");
            com.tencent.mm.plugin.finder.preload.a.a(baw, linkedList, 817);
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        bbn bbn = this.ttO;
        if (bbn != null) {
            for (T t : cYH()) {
                k kVar = k.vfA;
                k.e(t.id, bbn.tCE, t.sessionBuffer);
            }
            AppMethodBeat.o(242457);
            return;
        }
        AppMethodBeat.o(242457);
    }

    public final int getTabType() {
        AppMethodBeat.i(260189);
        a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListRequest");
            AppMethodBeat.o(260189);
            throw tVar;
        }
        int i2 = ((atu) aYJ).tTH;
        AppMethodBeat.o(260189);
        return i2;
    }

    public final int hSG() {
        AppMethodBeat.i(260190);
        a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListRequest");
            AppMethodBeat.o(260190);
            throw tVar;
        }
        int i2 = ((atu) aYJ).tvC;
        AppMethodBeat.o(260190);
        return i2;
    }

    public final LinkedList<FinderObject> cYH() {
        AppMethodBeat.i(242458);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(242458);
            throw tVar;
        }
        LinkedList<FinderObject> linkedList = ((atv) aYK).object;
        p.g(linkedList, "(rr.responseProtoBuf as …picListResponse).`object`");
        AppMethodBeat.o(242458);
        return linkedList;
    }

    public final long cYI() {
        AppMethodBeat.i(165236);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(165236);
            throw tVar;
        }
        long j2 = ((atv) aYK).tTn;
        AppMethodBeat.o(165236);
        return j2;
    }

    public final b cYz() {
        AppMethodBeat.i(165237);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(165237);
            throw tVar;
        }
        b bVar = ((atv) aYK).lastBuffer;
        AppMethodBeat.o(165237);
        return bVar;
    }

    public final int cYA() {
        AppMethodBeat.i(165238);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(165238);
            throw tVar;
        }
        int i2 = ((atv) aYK).continueFlag;
        AppMethodBeat.o(165238);
        return i2;
    }

    public final bdr getBgmInfo() {
        AppMethodBeat.i(242459);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(242459);
            throw tVar;
        }
        bds bds = ((atv) aYK).LEG;
        if (bds != null) {
            bdr bdr = bds.LNw;
            AppMethodBeat.o(242459);
            return bdr;
        }
        AppMethodBeat.o(242459);
        return null;
    }

    public final bds cYJ() {
        AppMethodBeat.i(242460);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
            AppMethodBeat.o(242460);
            throw tVar;
        }
        bds bds = ((atv) aYK).LEG;
        AppMethodBeat.o(242460);
        return bds;
    }
}

package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J>\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", ch.COL_USERNAME, "", "cmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "isMegaVideo", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "actionExt", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdItemList", "getCmdRetList", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bx extends ax implements m {
    private static final int tvL = 1;
    private static final int tvM = 3;
    private static final int tvN = 4;
    private static final int tvO = 5;
    private static final int tvP = 7;
    private static final int tvQ = 8;
    private static final int tvR = 9;
    private static final int tvS = 10;
    private static final int tvT = 12;
    private static final int tvU = 13;
    private static final int tvV = 14;
    public static final a tvW = new a((byte) 0);
    private final String TAG;
    private i callback;
    private d rr;
    private final JSONObject ttQ;
    private final JSONObject tuL;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog$Companion;", "", "()V", "CmdIdDelFansSetting", "", "getCmdIdDelFansSetting", "()I", "CmdIdModFeedReproduction", "getCmdIdModFeedReproduction", "CmdIdModMsgMuteSetting", "getCmdIdModMsgMuteSetting", "CmdIdModProfileStickySetting", "getCmdIdModProfileStickySetting", "CmdModBlackList", "getCmdModBlackList", "CmdModFeedSetting", "getCmdModFeedSetting", "CmdModMsgSessionMuteSetting", "getCmdModMsgSessionMuteSetting", "CmdModRecommendSetting", "getCmdModRecommendSetting", "CmdModUserInfo", "getCmdModUserInfo", "CmdModWxMsgSessionMuteSetting", "getCmdModWxMsgSessionMuteSetting", "MFinder_Oplog_CmdId_ModBlockPosterSetting", "getMFinder_Oplog_CmdId_ModBlockPosterSetting", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165249);
        AppMethodBeat.o(165249);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final b cXS() {
        return b.Enable;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final JSONObject cXV() {
        return this.tuL;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final JSONObject cXW() {
        return this.ttQ;
    }

    public /* synthetic */ bx(String str, List list) {
        this(str, list, false);
        AppMethodBeat.i(165248);
        AppMethodBeat.o(165248);
    }

    public bx(String str, List<? extends apf> list, boolean z) {
        int i2;
        int i3 = 0;
        p.h(str, ch.COL_USERNAME);
        p.h(list, "cmdList");
        AppMethodBeat.i(242482);
        this.TAG = "Finder.NetSceneFinderOplog";
        this.ttQ = new JSONObject();
        this.tuL = new JSONObject();
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/finderoplog");
        baa baa = new baa();
        baa.username = str;
        baa.sKS.addAll(list);
        am amVar = am.tuw;
        baa.uli = am.cXY();
        aov aov = baa.uli;
        if (aov == null) {
            p.hyc();
        }
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        aov.scene = i2;
        aVar.c(baa);
        aVar.d(new bab());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        List<? extends apf> list2 = list;
        synchronized (list2) {
            try {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    this.tuL.put("req".concat(String.valueOf(i3)), it.next().cmdId);
                    i3++;
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(242482);
                throw th;
            }
        }
        this.tuL.put("isMegaVideo", z);
        Log.i(this.TAG, "NetSceneFinderOplog init ");
        AppMethodBeat.o(242482);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3870;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165244);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165244);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242481);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        Log.i(this.TAG, "retList " + cYN().size());
        this.ttQ.put("retsize", cYN().size());
        int i5 = 0;
        for (apg apg : cYN()) {
            this.ttQ.put("resp".concat(String.valueOf(i5)), apg.retCode);
            this.ttQ.put("respm".concat(String.valueOf(i5)), apg.qwG);
            i5++;
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
        }
        for (apg apg2 : cYN()) {
            Log.i(this.TAG, "retCode " + apg2.retCode + " retMsg " + apg2.qwG);
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            int i6 = apg2.retCode;
            String str2 = apg2.qwG;
            if (!Util.isNullOrNil(str2)) {
                if (i6 == -4006) {
                    if (str2 != null) {
                        com.tencent.mm.plugin.finder.spam.a.avm(str2);
                    }
                    e.INSTANCE.idkeyStat(1264, 0, 1, false);
                } else if (i6 == -4007) {
                    if (str2 != null) {
                        com.tencent.mm.plugin.finder.spam.a.avm(str2);
                    }
                    e.INSTANCE.idkeyStat(1264, 1, 1, false);
                } else if (i6 == -4017) {
                    if (str2 != null) {
                        com.tencent.mm.plugin.finder.spam.a.avm(str2);
                    }
                    e.INSTANCE.idkeyStat(1264, 2, 1, false);
                } else if (i6 == -4005) {
                    if (str2 != null) {
                        com.tencent.mm.plugin.finder.spam.a.avm(str2);
                    }
                    e.INSTANCE.idkeyStat(1264, 5, 1, false);
                } else if (i6 == -4019) {
                    if (str2 != null) {
                        com.tencent.mm.plugin.finder.spam.a.avm(str2);
                    }
                    e.INSTANCE.idkeyStat(1264, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.finder.spam.a.u(4, i6, str2);
                }
            }
        }
        AppMethodBeat.o(242481);
    }

    public final List<apf> cYM() {
        AppMethodBeat.i(165246);
        d dVar = this.rr;
        if (dVar == null) {
            p.hyc();
        }
        com.tencent.mm.bw.a aYJ = dVar.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogRequest");
            AppMethodBeat.o(165246);
            throw tVar;
        }
        LinkedList<apf> linkedList = ((baa) aYJ).sKS;
        p.g(linkedList, "(rr!!.requestProtoBuf as…nderOplogRequest).cmdList");
        LinkedList<apf> linkedList2 = linkedList;
        AppMethodBeat.o(165246);
        return linkedList2;
    }

    public final List<apg> cYN() {
        AppMethodBeat.i(165247);
        d dVar = this.rr;
        if (dVar == null) {
            p.hyc();
        }
        com.tencent.mm.bw.a aYK = dVar.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogResponse");
            AppMethodBeat.o(165247);
            throw tVar;
        }
        LinkedList<apg> linkedList = ((bab) aYK).pUe;
        p.g(linkedList, "(rr!!.responseProtoBuf a…derOplogResponse).retList");
        LinkedList<apg> linkedList2 = linkedList;
        AppMethodBeat.o(165247);
        return linkedList2;
    }
}

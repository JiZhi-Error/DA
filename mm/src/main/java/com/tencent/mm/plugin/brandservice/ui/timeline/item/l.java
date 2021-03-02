package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.util.Base64;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.csz;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dlj;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u001a\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, hxF = {"TAG", "", "value", "", "isOpenFollow", "()Z", "setOpenFollow", "(Z)V", "doBizFeedbackReq", "", "cardType", "", "levelType", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "selectFeedback", "", "bizInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getRecycleCardList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecycleCard;", "getRecycleCardListProto", "isSupportStyle", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "plugin-brandservice_release"})
public final class l {
    private static boolean put = true;

    public static final boolean CT(int i2) {
        switch (i2) {
            case 0:
            case 3:
            case 5:
            case 101:
            case 102:
            case 103:
            case 1001:
                return true;
            default:
                return false;
        }
    }

    public static final boolean cmL() {
        return put;
    }

    public static final void cmM() {
        AppMethodBeat.i(195298);
        put = ((b) g.af(b.class)).a(b.a.clicfg_open_timeline_reccard_follow, 1) == 1;
        AppMethodBeat.o(195298);
    }

    public static final String cmN() {
        AppMethodBeat.i(195299);
        dlj dlj = new dlj();
        dlj.gCs = m(null);
        byte[] encode = Base64.encode(dlj.toByteArray(), 2);
        p.g(encode, "Base64.encode(recycleCar…eArray(), Base64.NO_WRAP)");
        Charset charset = StandardCharsets.UTF_8;
        p.g(charset, "StandardCharsets.UTF_8");
        String str = new String(encode, charset);
        AppMethodBeat.o(195299);
        return str;
    }

    private static LinkedList<dli> m(z zVar) {
        AppMethodBeat.i(195300);
        y yVar = y.NPP;
        List<z> kL = ag.ban().kL(620757041, j.na(j.mZ(y.aTI().decodeInt("RecycleCardMaxMsgCount", 10), 2), 50));
        LinkedList<dli> linkedList = new LinkedList<>();
        if (kL != null) {
            ArrayList<z> arrayList = new ArrayList();
            for (T t : kL) {
                if (zVar == null || ((z) t).field_msgId != zVar.field_msgId) {
                    arrayList.add(t);
                }
            }
            for (z zVar2 : arrayList) {
                dli dli = new dli();
                p.g(zVar2, "info");
                ege gAD = zVar2.gAD();
                dli.KUp = gAD != null ? gAD.dSJ : null;
                dli.KVE = zVar2.field_msgId;
                dli.MPi = String.valueOf(zVar2.field_msgId);
                linkedList.add(dli);
            }
        }
        AppMethodBeat.o(195300);
        return linkedList;
    }

    public static final void a(int i2, ege ege, List<String> list, z zVar) {
        AppMethodBeat.i(195301);
        p.h(ege, "wrapper");
        p.h(zVar, "bizInfo");
        switch (ege.style) {
            case 101:
            case 102:
            case 103:
                if (ege.Nga == null || Util.isNullOrNil(ege.Nga.KUf)) {
                    AppMethodBeat.o(195301);
                    return;
                }
                d.a aVar = new d.a();
                aVar.c(new oj());
                aVar.d(new ok());
                aVar.MB("/cgi-bin/mmbiz-bin/timeline/bizfeedback");
                aVar.sG(4898);
                x xVar = x.SXb;
                d aXF = aVar.aXF();
                com.tencent.mm.bw.a aYJ = aXF.aYJ();
                if (aYJ == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFeedbackReq");
                    AppMethodBeat.o(195301);
                    throw tVar;
                }
                oj ojVar = (oj) aYJ;
                ojVar.KUg = 3;
                LinkedList<os> linkedList = new LinkedList<>();
                LinkedList<pj> linkedList2 = ege.Nga.KUf;
                p.g(linkedList2, "wrapper.extraInfo.BizInfo");
                LinkedList<pj> linkedList3 = linkedList2;
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList3, 10));
                for (T t : linkedList3) {
                    os osVar = new os();
                    osVar.KSV = t.UserName;
                    LinkedList<String> linkedList4 = new LinkedList<>();
                    LinkedList<pi> linkedList5 = t.KWy;
                    p.g(linkedList5, "it.AppMsg");
                    LinkedList<pi> linkedList6 = linkedList5;
                    ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(linkedList6, 10));
                    Iterator<T> it = linkedList6.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next().KSj);
                    }
                    linkedList4.addAll(arrayList2);
                    x xVar2 = x.SXb;
                    osVar.KUB = linkedList4;
                    osVar.KUE = t.oUJ;
                    x xVar3 = x.SXb;
                    arrayList.add(osVar);
                }
                linkedList.addAll(arrayList);
                x xVar4 = x.SXb;
                ojVar.KUf = linkedList;
                ojVar.KUh = ege.style;
                String str = ege.event;
                if (str == null) {
                    str = "";
                }
                ojVar.KUi = str;
                ojVar.KUj = ege.MOC;
                String str2 = ege.Nga.KUk;
                if (str2 == null) {
                    str2 = "";
                }
                ojVar.KUk = str2;
                String str3 = ege.Nga.KUo;
                if (str3 == null) {
                    str3 = "";
                }
                ojVar.KUo = str3;
                ojVar.KUp = ege.dSJ;
                ojVar.gCs = m(zVar);
                y yVar = y.NPP;
                y.Bt(11);
                Log.i("MicroMsg.BizTLRecCardUtil", "doBizFeedbackReq recycleCardList size = " + ojVar.gCs.size());
                switch (i2) {
                    case 1:
                        oi oiVar = new oi();
                        oiVar.KSV = ege.Nga.KUf.get(0).UserName;
                        if (!Util.isNullOrNil(list)) {
                            LinkedList<csz> linkedList7 = new LinkedList<>();
                            if (list == null) {
                                p.hyc();
                            }
                            List<String> list2 = list;
                            ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(list2, 10));
                            Iterator<T> it2 = list2.iterator();
                            while (it2.hasNext()) {
                                csz csz = new csz();
                                csz.iAc = it2.next();
                                x xVar5 = x.SXb;
                                arrayList3.add(csz);
                            }
                            linkedList7.addAll(arrayList3);
                            x xVar6 = x.SXb;
                            oiVar.KJk = linkedList7;
                        }
                        x xVar7 = x.SXb;
                        ojVar.KUm = oiVar;
                        break;
                    case 3:
                        switch (ege.style) {
                            case 102:
                                uc ucVar = new uc();
                                if (!Util.isNullOrNil(list)) {
                                    LinkedList<csz> linkedList8 = new LinkedList<>();
                                    if (list == null) {
                                        p.hyc();
                                    }
                                    List<String> list3 = list;
                                    ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(list3, 10));
                                    Iterator<T> it3 = list3.iterator();
                                    while (it3.hasNext()) {
                                        csz csz2 = new csz();
                                        csz2.iAc = it3.next();
                                        x xVar8 = x.SXb;
                                        arrayList4.add(csz2);
                                    }
                                    linkedList8.addAll(arrayList4);
                                    x xVar9 = x.SXb;
                                    ucVar.KJk = linkedList8;
                                }
                                x xVar10 = x.SXb;
                                ojVar.KUl = ucVar;
                                break;
                            default:
                                uc ucVar2 = new uc();
                                ucVar2.dDH = 1;
                                x xVar11 = x.SXb;
                                ojVar.KUl = ucVar2;
                                break;
                        }
                }
                x xVar12 = x.SXb;
                x xVar13 = x.SXb;
                aa.a(aXF, new a(aXF));
                AppMethodBeat.o(195301);
                return;
            default:
                AppMethodBeat.o(195301);
                return;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a implements aa.a {
        final /* synthetic */ d puu;

        a(d dVar) {
            this.puu = dVar;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, d dVar, q qVar) {
            AppMethodBeat.i(195297);
            p.h(dVar, "<anonymous parameter 3>");
            p.h(qVar, "<anonymous parameter 4>");
            d dVar2 = this.puu;
            p.g(dVar2, "rr");
            final ok okVar = (ok) dVar2.aYK();
            if (okVar == null) {
                AppMethodBeat.o(195297);
            } else {
                y yVar = y.NPP;
                y.aTI().encode("RecycleCardMaxMsgCount", okVar.KUq);
                com.tencent.mm.ac.d.b("MicroMsg.BizRecycleCardLogic", new kotlin.g.a.a<x>() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.l.a.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(195296);
                        y yVar = y.NPP;
                        LinkedList<dli> linkedList = okVar.gCs;
                        p.g(linkedList, "resp.list");
                        y.a(linkedList, y.b.RECYCLE_CARD_SCENE_FEEDBACK);
                        x xVar = x.SXb;
                        AppMethodBeat.o(195296);
                        return xVar;
                    }
                });
                AppMethodBeat.o(195297);
            }
            return 0;
        }
    }
}

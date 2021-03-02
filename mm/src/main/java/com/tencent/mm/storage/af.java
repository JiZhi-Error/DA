package com.tencent.mm.storage;

import android.net.Uri;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0016\u001a\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0016\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u001a\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0016\u001a\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\n\u001a\u001a\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"\u001a\"\u0010#\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00162\u0006\u0010$\u001a\u00020\n\u001a\u001a\u0010%\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0016\u001a\u0006\u0010&\u001a\u00020\u001c\u001a\u001e\u0010'\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0001\u001a\u000e\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0001\u001a\n\u0010,\u001a\u00020\u001c*\u00020\u0014\u001a\n\u0010-\u001a\u00020\u0001*\u00020\u000e\u001a\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0/*\u00020\n¢\u0006\u0002\u00100\u001a\n\u00101\u001a\u00020\u001c*\u00020\"\u001a\n\u00102\u001a\u00020\u001c*\u00020\u0014\u001a\u001e\u00103\u001a\u00020\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0016\u001a$\u00104\u001a\u00020\u0012*\b\u0012\u0004\u0012\u0002050\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0016\u001a\u0012\u00106\u001a\u00020\u0012*\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"BIZTIMELINFO_CARDTYPE_AD", "", "BIZTIMELINFO_CARDTYPE_BIZ", "BIZTIMELINFO_CARDTYPE_RECCARD_CANVAS", "BIZTIMELINFO_CARDTYPE_RECFEED", "BIZTIMELINFO_CARDTYPE_RECFEED_TAG", "BIZTIMELINFO_CARDTYPE_RECOMMEND", "BIZTIMELINFO_CARDTYPE_STYL103", "BIZTIMELINFO_CARDTYPE_UNFOLLOW", "TAG", "", "fillBizMsgItem", "Ljava/util/LinkedList;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "getExtraFromXML", "", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "values", "", "getFromCanvasXml", "getRecCardAppMsgs", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "insertCanvasCardImmediately", "isCanvasCard", "", "isContact", "userName", "isTLRecCardWrapperLegal", "isTLRecFeedLegal", "recFeed", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "onBizRecommendExpt", "content", "postInsertCanvasCard", "recCanvasSupport", "report21461", "redDotFlag", "insertRet", "testInsertCard", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "duplicateCardId", "getCardType", "getMidAndIdx", "", "(Ljava/lang/String;)[Ljava/lang/String;", "isShowBigPic", "isUnderLineMsg", "parseExtraFromXML", "parseFromXML", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "setCardId", "plugin-biz_release"})
public final class af {
    public static final void a(ege ege, Map<String, String> map) {
        AppMethodBeat.i(212636);
        p.h(ege, "wrapper");
        p.h(map, "values");
        b(ege, map);
        AppMethodBeat.o(212636);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(com.tencent.mm.protocal.protobuf.ege r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.af.b(com.tencent.mm.protocal.protobuf.ege, java.util.Map):void");
    }

    public static final void a(LinkedList<pj> linkedList, Map<String, String> map) {
        AppMethodBeat.i(212638);
        p.h(linkedList, "$this$parseFromXML");
        p.h(map, "values");
        int i2 = 0;
        while (i2 <= 9) {
            String str = ".sysmsg.BizAccountRecommend.BizAccount" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (Util.isNullOrNil(map.get(str + ".UserName"))) {
                break;
            }
            pj pjVar = new pj();
            pjVar.UserName = map.get(str + ".UserName");
            pjVar.oUJ = map.get(str + ".NickName");
            pjVar.xLi = map.get(str + ".RecommendReason");
            pjVar.keb = map.get(str + ".Signature");
            pjVar.KQY = map.get(str + ".BrandIconUrl");
            pjVar.KWx = map.get(str + ".AppMsgRecReason");
            pjVar.KWr = new LinkedList<>();
            int i3 = 0;
            while (i3 <= 20) {
                String str2 = map.get(str + ".NegativeFeedbackReason" + (i3 == 0 ? "" : Integer.valueOf(i3)));
                if (Util.isNullOrNil(str2)) {
                    break;
                }
                pjVar.KWr.add(str2);
                i3++;
            }
            pjVar.KWs = Util.getInt(map.get(str + ".ShowNegativeFeedbackReason"), 1);
            pjVar.KWy = new LinkedList<>();
            linkedList.add(pjVar);
            int i4 = 0;
            while (i4 <= 1) {
                String str3 = str + ".AppMsg" + (i4 == 0 ? "" : Integer.valueOf(i4));
                if (Util.isNullOrNil(map.get(str3 + ".Title"))) {
                    break;
                }
                pi piVar = new pi();
                piVar.Title = map.get(str3 + ".Title");
                piVar.KSh = map.get(str3 + ".Digest");
                piVar.KSj = map.get(str3 + ".ContentUrl");
                piVar.KSl = map.get(str3 + ".CoverImgUrl");
                piVar.KSm = map.get(str3 + ".CoverImgUrl_1_1");
                piVar.KSn = map.get(str3 + ".CoverImgUrl_235_1");
                piVar.iAb = Util.getInt(map.get(str3 + ".ItemShowType"), -1);
                piVar.KSu = map.get(str3 + ".VideoId");
                piVar.KSv = Util.getInt(map.get(str3 + ".VideoWidth"), -1);
                piVar.KSw = Util.getInt(map.get(str3 + ".VideoHeight"), -1);
                piVar.KSx = Util.getInt(map.get(str3 + ".VideoDuration"), -1);
                piVar.CreateTime = Util.getInt(map.get(str3 + ".CreateTime"), -1);
                piVar.KWt = map.get(str3 + ".VoicePlayUrl");
                piVar.KWu = Util.getInt(map.get(str3 + ".VoiceDuration"), -1);
                piVar.KWr = new LinkedList<>();
                int i5 = 0;
                while (i5 <= 20) {
                    String str4 = map.get(str3 + ".NegativeFeedbackReason" + (i5 == 0 ? "" : Integer.valueOf(i5)));
                    if (Util.isNullOrNil(str4)) {
                        break;
                    }
                    piVar.KWr.add(str4);
                    i5++;
                }
                piVar.KWs = Util.getInt(map.get(str3 + ".ShowNegativeFeedbackReason"), 1);
                piVar.KWv = Util.getInt(map.get(str3 + ".RecRk"), 0);
                piVar.KWw = map.get(str3 + ".RecInfo");
                pjVar.KWy.add(piVar);
                i4++;
            }
            i2++;
        }
        AppMethodBeat.o(212638);
    }

    public static final LinkedList<String> a(z zVar, ow owVar) {
        AppMethodBeat.i(212639);
        p.h(zVar, "info");
        p.h(owVar, "item");
        LinkedList<String> linkedList = new LinkedList<>();
        if (!zVar.gAu() || zVar.gAD() == null) {
            AppMethodBeat.o(212639);
            return linkedList;
        }
        for (T t : F(zVar)) {
            owVar.duo.add(t.KSj);
            String str = t.KWw;
            if (!(str == null || n.aL(str))) {
                owVar.KVF.add(t.KWw);
            }
        }
        AppMethodBeat.o(212639);
        return linkedList;
    }

    public static final LinkedList<pi> F(z zVar) {
        LinkedList<ega> linkedList;
        ege gAD;
        ale ale;
        LinkedList<pj> linkedList2;
        LinkedList<pi> linkedList3;
        AppMethodBeat.i(212640);
        p.h(zVar, "info");
        LinkedList<pi> linkedList4 = new LinkedList<>();
        if (!zVar.gAu() || zVar.gAD() == null) {
            AppMethodBeat.o(212640);
            return linkedList4;
        }
        ege gAD2 = zVar.gAD();
        if (gAD2.style == 3 || gAD2.style == 5 || gAD2.style == 0) {
            efz gAC = zVar.gAC();
            if (!(gAC == null || (linkedList = gAC.KWy) == null)) {
                for (T t : linkedList) {
                    pi piVar = new pi();
                    piVar.KSj = t.KSj;
                    piVar.Title = t.Title;
                    linkedList4.add(piVar);
                }
            }
        } else if (!(!(gAD2.style == 101 || gAD2.style == 102 || gAD2.style == 103) || (gAD = zVar.gAD()) == null || (ale = gAD.Nga) == null || (linkedList2 = ale.KUf) == null)) {
            for (T t2 : linkedList2) {
                if (!(t2 == null || (linkedList3 = t2.KWy) == null)) {
                    Iterator<T> it = linkedList3.iterator();
                    while (it.hasNext()) {
                        linkedList4.add(it.next());
                    }
                }
            }
        }
        AppMethodBeat.o(212640);
        return linkedList4;
    }

    private static boolean IS(String str) {
        AppMethodBeat.i(212641);
        p.h(str, "userName");
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        if (Kn == null || !Kn.arv()) {
            if (Kn == null || Kn.arH() <= 0) {
                ay.a.aVo().a(str, "", null);
            }
            AppMethodBeat.o(212641);
            return false;
        }
        AppMethodBeat.o(212641);
        return true;
    }

    public static final boolean a(dkr dkr) {
        AppMethodBeat.i(212642);
        p.h(dkr, "$this$isShowBigPic");
        if (dkr.MOH == 0) {
            AppMethodBeat.o(212642);
            return true;
        }
        AppMethodBeat.o(212642);
        return false;
    }

    public static final boolean b(dkr dkr) {
        AppMethodBeat.i(212643);
        p.h(dkr, "recFeed");
        LinkedList<dlb> linkedList = dkr.MOG;
        if (linkedList == null || linkedList.isEmpty()) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] RecommendItem is illegal");
            AppMethodBeat.o(212643);
            return false;
        }
        if (dkr.KUh == 2002) {
            String str = dkr.Luk;
            if (str == null || n.aL(str)) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] AggregationTitle is illegal");
                AppMethodBeat.o(212643);
                return false;
            }
            String str2 = dkr.Luj;
            if (str2 == null || n.aL(str2)) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] AggregationUrl is illegal");
                AppMethodBeat.o(212643);
                return false;
            }
            String str3 = dkr.MOI;
            if (str3 == null || n.aL(str3)) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] RecommendWording is illegal");
                AppMethodBeat.o(212643);
                return false;
            }
        }
        LinkedList<dlb> linkedList2 = dkr.MOG;
        p.g(linkedList2, "recFeed.RecommendItem");
        for (T t : linkedList2) {
            cdu cdu = t.MOY;
            String str4 = cdu != null ? cdu.Title : null;
            if (str4 == null || n.aL(str4)) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] Title is illegal");
                AppMethodBeat.o(212643);
                return false;
            }
            cdu cdu2 = t.MOY;
            String str5 = cdu2 != null ? cdu2.KSj : null;
            if (str5 == null || n.aL(str5)) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] ContentUrl is illegal");
                AppMethodBeat.o(212643);
                return false;
            }
            cdu cdu3 = t.MOY;
            int i2 = cdu3 != null ? cdu3.iAb : -1;
            if (i2 == 5 || i2 == 8 || i2 == 10 || i2 == 0) {
                mr mrVar = t.MOX;
                String str6 = mrVar != null ? mrVar.oUJ : null;
                if (str6 == null || n.aL(str6)) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] NickName is illegal");
                    AppMethodBeat.o(212643);
                    return false;
                }
                mr mrVar2 = t.MOX;
                String str7 = mrVar2 != null ? mrVar2.UserName : null;
                if (str7 == null || n.aL(str7)) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] NickName is illegal");
                    AppMethodBeat.o(212643);
                    return false;
                }
                cdu cdu4 = t.MOY;
                if (cdu4 != null && 5 == cdu4.iAb) {
                    cdu cdu5 = t.MOY;
                    if ((cdu5 != null ? cdu5.Mjm : null) == null) {
                        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] VideoInfo is illegal");
                        AppMethodBeat.o(212643);
                        return false;
                    }
                }
                cdu cdu6 = t.MOY;
                if (cdu6 != null && 7 == cdu6.iAb) {
                    cdu cdu7 = t.MOY;
                    if ((cdu7 != null ? cdu7.Mjn : null) == null) {
                        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] VoiceInfo is illegal");
                        AppMethodBeat.o(212643);
                        return false;
                    }
                }
            } else {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] ItemShowType is illegal, itemShowType=" + i2 + '.');
                AppMethodBeat.o(212643);
                return false;
            }
        }
        AppMethodBeat.o(212643);
        return true;
    }

    private static /* synthetic */ boolean e(ege ege) {
        AppMethodBeat.i(212645);
        boolean b2 = b(ege, (z) null);
        AppMethodBeat.o(212645);
        return b2;
    }

    public static final boolean b(ege ege, z zVar) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(212644);
        p.h(ege, "wrapper");
        int i2 = ege.style;
        if (i2 != 1001) {
            efz efz = ege.NfY;
            if (efz == null) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal recCard null");
                AppMethodBeat.o(212644);
                return false;
            } else if (efz.Lug == null) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal CardTitle null");
                AppMethodBeat.o(212644);
                return false;
            } else if (efz.KWx == null) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal AppMsgRecReason null");
                AppMethodBeat.o(212644);
                return false;
            } else {
                egb egb = efz.NfT;
                if (egb == null) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo null");
                    AppMethodBeat.o(212644);
                    return false;
                } else if (egb.UserName == null) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo UserName null");
                    AppMethodBeat.o(212644);
                    return false;
                } else if (egb.oUJ == null) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo NickName null");
                    AppMethodBeat.o(212644);
                    return false;
                } else if (egb.NfV == null) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo RecReason null");
                    AppMethodBeat.o(212644);
                    return false;
                } else if (Util.isNullOrNil(efz.KWy)) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg null");
                    AppMethodBeat.o(212644);
                    return false;
                } else if (i2 != 5 || efz.KWy.size() >= 2) {
                    if (i2 == 101 || i2 == 102 || i2 == 103) {
                        if (ege.Nga == null || Util.isNullOrNil(ege.Nga.KUf) || ege.Nga.KUf.size() >= 3) {
                            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + i2 + " BizInfo size >= 3");
                            AppMethodBeat.o(212644);
                            return false;
                        } else if (ege.Nga.KHa == 1) {
                            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + i2 + " extraInfo flag = 1");
                            if (zVar != null) {
                                ag.ban().MX(zVar.field_msgId);
                            }
                            AppMethodBeat.o(212644);
                            return false;
                        } else {
                            LinkedList<pj> linkedList = ege.Nga.KUf;
                            p.g(linkedList, "wrapper.extraInfo.BizInfo");
                            int size = linkedList.size();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size) {
                                    z = false;
                                    break;
                                } else if (ege.Nga.KUf.get(i3).KHa != 1) {
                                    z = true;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            if (!z) {
                                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + i2 + " bizLegal illegal");
                                if (zVar != null) {
                                    ag.ban().MX(zVar.field_msgId);
                                }
                                AppMethodBeat.o(212644);
                                return false;
                            }
                            if (i2 != 103) {
                                LinkedList<pj> linkedList2 = ege.Nga.KUf;
                                p.g(linkedList2, "wrapper.extraInfo.BizInfo");
                                int size2 = linkedList2.size();
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= size2) {
                                        z3 = true;
                                        break;
                                    }
                                    String str = ege.Nga.KUf.get(i4).UserName;
                                    p.g(str, "wrapper.extraInfo.BizInfo[i].UserName");
                                    if (!IS(str)) {
                                        z3 = false;
                                        break;
                                    }
                                    i4++;
                                }
                                if (z3) {
                                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + i2 + " bizLegal contact");
                                    if (zVar != null) {
                                        ag.ban().MX(zVar.field_msgId);
                                    }
                                    AppMethodBeat.o(212644);
                                    return false;
                                }
                            }
                            LinkedList<pj> linkedList3 = ege.Nga.KUf;
                            p.g(linkedList3, "wrapper.extraInfo.BizInfo");
                            int size3 = linkedList3.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size3) {
                                    z2 = true;
                                    break;
                                } else if (Util.isNullOrNil(ege.Nga.KUf.get(i5).KWy)) {
                                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + i2 + " AppMsg null");
                                    AppMethodBeat.o(212644);
                                    return false;
                                } else if (ege.Nga.KUf.get(i5).KWy.get(0).KHa == 1) {
                                    z2 = false;
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                            if (!z2) {
                                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + i2 + " AppMsg illegal");
                                AppMethodBeat.o(212644);
                                return false;
                            }
                            LinkedList<pi> linkedList4 = ege.Nga.KUf.get(0).KWy;
                            p.g(linkedList4, "wrapper.extraInfo.BizInfo[0].AppMsg");
                            boolean z4 = true;
                            for (T t : linkedList4) {
                                z4 = (t.iAb == 8 || t.iAb == 7 || t.iAb == 6 || t.iAb == 10) ? false : z4;
                            }
                            if (!z4) {
                                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + i2 + " showTypeLegal illegal");
                                AppMethodBeat.o(212644);
                                return false;
                            }
                        }
                    }
                    AppMethodBeat.o(212644);
                    return true;
                } else {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg video size < 2");
                    AppMethodBeat.o(212644);
                    return false;
                }
            }
        } else if (ege.Ngc == null) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo = null");
            AppMethodBeat.o(212644);
            return false;
        } else if (Util.isNullOrNil(ege.Ngc.data)) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo.data = null");
            AppMethodBeat.o(212644);
            return false;
        } else if (Util.isNullOrNil(ege.Ngc.appId) || Util.isNullOrNil(ege.Ngc.MOE)) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal appid or path error, appId = " + ege.Ngc.appId + ", path = " + ege.Ngc.MOE);
            AppMethodBeat.o(212644);
            return false;
        } else {
            AppMethodBeat.o(212644);
            return true;
        }
    }

    public static final int G(z zVar) {
        int i2 = 1;
        AppMethodBeat.i(212646);
        p.h(zVar, "$this$getCardType");
        if (zVar.gAt()) {
            i2 = 0;
        } else if (zVar.gAu()) {
            ege gAD = zVar.gAD();
            if (gAD != null) {
                switch (gAD.style) {
                    case 101:
                    case 102:
                        i2 = 3;
                        break;
                    case 103:
                        i2 = 7;
                        break;
                    case 1001:
                        i2 = 5;
                        break;
                }
            }
        } else if (zVar.gAv()) {
            i2 = 4;
        } else if (zVar.gAs()) {
            dkr dkr = zVar.NQr;
            i2 = (dkr == null || dkr.KUh != 2002) ? 9 : 10;
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(212646);
        return i2;
    }

    public static final boolean gBp() {
        AppMethodBeat.i(212647);
        r rVar = r.NPl;
        if (!r.gzM()) {
            AppMethodBeat.o(212647);
            return false;
        } else if (!g.aAc() || !((b) g.af(b.class)).CT(1001)) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt style = %s not support", 1001);
            AppMethodBeat.o(212647);
            return false;
        } else {
            AppMethodBeat.o(212647);
            return true;
        }
    }

    public static final boolean bU(Map<String, String> map) {
        AppMethodBeat.i(212648);
        p.h(map, "values");
        if (!Util.isNullOrNil(map.get(".sysmsg.BizRecommendExpt.Data"))) {
            AppMethodBeat.o(212648);
            return true;
        }
        AppMethodBeat.o(212648);
        return false;
    }

    public static final ege bV(Map<String, String> map) {
        AppMethodBeat.i(212649);
        p.h(map, "values");
        String str = map.get(".sysmsg.BizRecommendExpt.Title");
        int i2 = Util.getInt(map.get(".sysmsg.BizRecommendExpt.Pos"), -1);
        int i3 = Util.getInt(map.get(".sysmsg.BizRecommendExpt.Weight"), -1);
        long j2 = Util.getLong(map.get(".sysmsg.BizRecommendExpt.RecID"), 0);
        int i4 = Util.getInt(map.get(".sysmsg.BizRecommendExpt.RedDotFlag"), -1);
        String str2 = map.get(".sysmsg.BizRecommendExpt.BusinessId");
        String str3 = map.get(".sysmsg.BizRecommendExpt.CardID");
        String str4 = map.get(".sysmsg.BizRecommendExpt.Data");
        String str5 = map.get(".sysmsg.BizRecommendExpt.RecSummary");
        String str6 = map.get(".sysmsg.BizRecommendExpt.AppId");
        String str7 = map.get(".sysmsg.BizRecommendExpt.TemplatePathType");
        int i5 = Util.getInt(map.get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
        String str8 = map.get(".sysmsg.BizRecommendExpt.ExtraData");
        if (i2 >= 0 || i3 >= 0) {
            ege ege = new ege();
            ege.pos = i2;
            ege.weight = i3;
            ege.MOC = j2;
            dkp dkp = new dkp();
            dkp.title = str;
            dkp.pos = i2;
            dkp.weight = i3;
            dkp.MOC = j2;
            dkp.businessId = str2;
            dkp.cardId = str3;
            dkp.data = str4;
            dkp.Lui = str5;
            dkp.appId = str6;
            dkp.MOE = str7;
            ege.Ngc = dkp;
            ege.style = 1001;
            ege.Ngb = i5;
            ege.dSJ = str8;
            ege.MOD = i4;
            AppMethodBeat.o(212649);
            return ege;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] getFromCanvasXml pos = " + i2 + ", weight = " + i3);
        AppMethodBeat.o(212649);
        return null;
    }

    public static final void bW(Map<String, String> map) {
        long aE;
        long j2;
        AppMethodBeat.i(212651);
        p.h(map, "values");
        aa ban = ag.ban();
        p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
        z gAM = ban.gAM();
        if (gAM == null) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is null");
            AppMethodBeat.o(212651);
            return;
        }
        ege bV = bV(map);
        if (bV == null) {
            AppMethodBeat.o(212651);
            return;
        }
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
        if (bV.MOD != 2) {
            if (gAM.field_status == 4) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is exposed");
                AppMethodBeat.o(212651);
                return;
            }
            StringBuilder sb = new StringBuilder("BizLatestRecommendCardInfo");
            p.g(g.aAf(), "MMKernel.account()");
            singleMMKV.encode(sb.append(com.tencent.mm.kernel.a.ayV()).toString(), "");
        }
        if (!e(bV)) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard illegal");
            AppMethodBeat.o(212651);
        } else if (g(bV)) {
            AppMethodBeat.o(212651);
        } else {
            aa ban2 = ag.ban();
            p.g(ban2, "SubCoreBiz.getBizTimeLineInfoStorage()");
            long gAS = ban2.gAS();
            h.INSTANCE.idkeyStat(1149, 1, 1, false);
            aa ban3 = ag.ban();
            p.g(ban3, "SubCoreBiz.getBizTimeLineInfoStorage()");
            long gAO = ban3.gAO();
            z zVar = new z();
            zVar.field_msgId = ag.ban().gAW();
            zVar.field_msgSvrId = 0;
            zVar.field_type = 620757041;
            zVar.field_talker = "";
            zVar.field_talkerId = 0;
            zVar.field_createTime = gAO - 1000;
            zVar.nc(1);
            zVar.field_status = 3;
            a(zVar, bV);
            zVar.c(bV);
            long j3 = 0;
            if (bV.Ngc.weight >= 0) {
                j3 = j.aN((long) bV.Ngc.weight, 255);
            } else if (bV.Ngc.pos == 0) {
                j3 = ab.Na(gAM.field_orderFlag);
                zVar.field_createTime = gAO + 1000;
            } else {
                z ajV = ag.ban().ajV(bV.Ngc.pos - 1);
                if (ajV == null) {
                    Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "postInsertCanvasCard lastTimeLineInfo is null");
                } else {
                    j3 = ab.Na(ajV.field_orderFlag);
                    zVar.field_createTime = ajV.field_createTime - 1000;
                }
            }
            long j4 = (j3 << 24) & 4278190080L;
            if (bV.MOD != 2) {
                aE = ab.aE(gAS, zVar.field_createTime / 1000);
                j2 = gAS;
            } else if (gAS <= 10) {
                AppMethodBeat.o(212651);
                return;
            } else {
                aE = ab.aF(gAS, zVar.field_createTime / 1000);
                j2 = -1 + gAS;
                zVar.field_hasShow = 1;
                zVar.field_status = 4;
                zVar.iF(2);
            }
            zVar.field_orderFlag = aE | (j2 << 32) | j4;
            ab.E(zVar);
            boolean b2 = ag.ban().b(zVar, bV.MOD != 2);
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard result = " + b2 + ", redDotFlag = " + bV.MOD + ", orderFlag = " + zVar.field_orderFlag);
            if (b2) {
                r rVar = r.NPl;
                if (r.gzP()) {
                    m.IAG.fWS();
                }
                r.NPl.z(zVar);
                com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(82);
                s sVar = s.NPC;
                int i2 = bV.pos;
                int i3 = bV.Ngb;
                int i4 = bV.style;
                long j5 = bV.MOC;
                dkp dkp = bV.Ngc;
                String str = dkp != null ? dkp.cardId : null;
                ale ale = bV.Nga;
                s.a(zVar, 2, i2, i3, i4, j5, str, ale != null ? ale.KUo : null, bV.dSJ);
            }
            AppMethodBeat.o(212651);
        }
    }

    public static final void a(z zVar, ege ege) {
        String str = null;
        AppMethodBeat.i(212652);
        p.h(zVar, "$this$setCardId");
        p.h(ege, "wrapper");
        zVar.field_recommendCardId = "";
        switch (ege.style) {
            case 101:
            case 102:
            case 103:
                ale ale = ege.Nga;
                if (ale != null) {
                    str = ale.KUk;
                }
                zVar.field_recommendCardId = str;
                AppMethodBeat.o(212652);
                return;
            case 1001:
                dkp dkp = ege.Ngc;
                if (dkp != null) {
                    str = dkp.cardId;
                }
                zVar.field_recommendCardId = str;
                break;
        }
        AppMethodBeat.o(212652);
    }

    public static final boolean g(ege ege) {
        String str = null;
        AppMethodBeat.i(212653);
        p.h(ege, "$this$duplicateCardId");
        switch (ege.style) {
            case 101:
            case 102:
            case 103:
                aa ban = ag.ban();
                ale ale = ege.Nga;
                if (ale != null) {
                    str = ale.KUk;
                }
                if (ban.biY(str) != null) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] duplicateCardId");
                    AppMethodBeat.o(212653);
                    return true;
                }
                break;
            case 1001:
                aa ban2 = ag.ban();
                dkp dkp = ege.Ngc;
                if (dkp != null) {
                    str = dkp.cardId;
                }
                if (ban2.biY(str) != null) {
                    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] canvas duplicateCardId");
                    AppMethodBeat.o(212653);
                    return true;
                }
                break;
        }
        AppMethodBeat.o(212653);
        return false;
    }

    public static final void a(ege ege, int i2, int i3) {
        LinkedList<pj> linkedList;
        AppMethodBeat.i(212654);
        p.h(ege, "wrapper");
        switch (ege.style) {
            case 101:
            case 102:
            case 103:
                ale ale = ege.Nga;
                if (!(ale == null || (linkedList = ale.KUf) == null)) {
                    ArrayList arrayList = new ArrayList();
                    for (T t : linkedList) {
                        if (t.KHa == 0) {
                            arrayList.add(t);
                        }
                    }
                    int i4 = 0;
                    for (Object obj : arrayList) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            kotlin.a.j.hxH();
                        }
                        pj pjVar = (pj) obj;
                        pi piVar = pjVar.KWy.get(0);
                        if (piVar != null) {
                            if ((piVar.KHa & 1) == 0) {
                                String str = piVar.KSj;
                                p.g(str, "it.ContentUrl");
                                String[] bjc = bjc(str);
                                h.INSTANCE.a(21461, pjVar.UserName, bjc[0], bjc[1], Integer.valueOf(piVar.iAb), ege.Nga.KUo, ege.Nga.KUk, Integer.valueOf(i4), Long.valueOf(ege.MOC), ege.Nga.Lui, Integer.valueOf(ege.style), piVar.KWw, Integer.valueOf(ege.weight), Integer.valueOf(i2), Integer.valueOf(ege.Ngb), Integer.valueOf(ege.pos), Integer.valueOf(i3));
                            }
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    }
                    AppMethodBeat.o(212654);
                    return;
                }
        }
        AppMethodBeat.o(212654);
    }

    public static final String[] bjc(String str) {
        AppMethodBeat.i(212655);
        p.h(str, "$this$getMidAndIdx");
        String[] strArr = {"", ""};
        if (!Util.isNullOrNil(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("mid");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                strArr[0] = queryParameter;
                String queryParameter2 = parse.getQueryParameter("idx");
                if (queryParameter2 == null) {
                    queryParameter2 = "";
                }
                strArr[1] = queryParameter2;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(212655);
        return strArr;
    }

    public static final void akc(int i2) {
        AppMethodBeat.i(212656);
        String str = "card_id_" + System.currentTimeMillis();
        if (i2 == 1001) {
            String str2 = "<sysmsg type=\"BizRecommendExpt\">\n<BizRecommendExpt>\n<Title><![CDATA[猜你喜欢]]></Title>\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1591189349</RecID>\n<RedDotFlag>1</RedDotFlag>\n<BusinessId>0</BusinessId>\n<CardID><![CDATA[" + str + "]]></CardID>\n<Data><![CDATA[{\"Title\":\"猜你喜欢\",\"BizAccount\":[{\"Flag\":0,\"UserName\":\"gh_f05ff0331d78\",\"NickName\":\"" + ("中国国家地理" + (System.currentTimeMillis() % 10000)) + "\",\"RecommendReason\":\"\",\"Signature\":\"《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！\",\"BrandIconUrl\":\"http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png\",\"AppMsgRecReason\":\"近期更新\",\"AppMsg\":[{\"Flag\":0,\"Title\":\"气温超过50°的极热之地，你敢去吗？\",\"Digest\":\"我是摘要测试测试\",\"ContentUrl\":\"https://mp.weixin.qq.com/s/oKmmWfX9G3Yfbmp5aDeyTQ\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593296809,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":0,\"RecRk\":1,\"RecInfo\":\"something\",\"AppMsgId\":2698324179,\"ItemIdx\":1,\"AuthorAppUin\":1014597342,\"CanReward\":0,\"CanPaid\":0},{\"Flag\":0,\"Title\":\"深度雄文，西部高原屏障对中华民族战略安全的重大意义！\",\"Digest\":\"深度参考长按右边的二维码关注2013年4月在中国的阿克塞欣的斗拉特别里奥地地区中印两国爆发“帐蓬对峙”，20\",\"ContentUrl\":\"http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593211927,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":180,\"RecRk\":2,\"RecInfo\":\"great\",\"AppMsgId\":2698324092,\"ItemIdx\":4,\"AuthorAppUin\":1654122144,\"CanReward\":0,\"CanPaid\":0}],\"NegativeFeedbackReason\":[\"不看此公众号\",\"内容低质\",\"内容重复\",\"内容过时\",\"希望减少推荐\"],\"ShowNegativeFeedbackReason\":1,\"BizUin\":3007693851}],\"Pos\":1,\"Weight\":200,\"RecID\":10086,\"Style\":1001,\"Event\":\"hengqing\",\"RedDotFlag\":1,\"RecSummary\":\"深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！\",\"CardId\":\"cdd97abeab063a0e00cea86f805bb17c\",\"ExpType\":\"tools\"}]]></Data>\n<RecSummary><![CDATA[气温超过50°的极热之地，你敢去吗？]]></RecSummary>\n<AppId><![CDATA[wxf337cbaa27790d8e]]></AppId>\n<ExtraData><![CDATA[{\"type\":1,\"real_data\":\"{\\\"biz_info\\\":[{\\\"username\\\":\\\"gh_49f4cd2ce99b\\\",\\\"nickname\\\":\\\"皮皮浪老师\\\",\\\"appmsg_info\\\":[{\\\"url\\\":\\\"http:\\\\\\/\\\\\\/mp.weixin.qq.com\\\\\\/s?__biz=MzA4OTE5NzQ5MQ==&mid=2247483877&idx=1&sn=e693e539daef056fa051e66374e41b48&chksm=901fdf39a768562fe6aaaeed3dfc9909d781ea8c45862cc335ed527eafcdb51f4aca774f67c3#rd\\\",\\\"title\\\":\\\"皮皮浪的复盘讲解（二十二）——围空不要拆二\\\",\\\"rec_rk\\\":1,\\\"rec_info\\\":\\\"something\\\",\\\"item_show_type\\\":5}]}],\\\"style\\\":1001,\\\"event\\\":\\\"hengqing\\\",\\\"card_id\\\":\\\"33a95e9794780cc0f584220dbb9fcfe2\\\",\\\"exp_type\\\":\\\"tools\\\"}\"}]]></ExtraData>\n<TemplatePath><![CDATA[re.js]]></TemplatePath>\n<TemplatePathType><![CDATA[re]]></TemplatePathType>\n</BizRecommendExpt>\n</sysmsg>";
            int a2 = n.a((CharSequence) str2, "<sysmsg", 0, false, 6);
            if (a2 == -1) {
                AppMethodBeat.o(212656);
            } else if (str2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(212656);
                throw tVar;
            } else {
                String substring = str2.substring(a2);
                p.g(substring, "(this as java.lang.String).substring(startIndex)");
                Map<String, String> parseXml = XmlParser.parseXml(substring, "sysmsg", null);
                if (parseXml == null) {
                    Log.e("MicroMsg.BizTimeLineStorageLogicExKt", "XmlParser values is null, msgContent %s", str2);
                    AppMethodBeat.o(212656);
                    return;
                }
                ege bV = bV(parseXml);
                if (bV == null) {
                    p.hyc();
                }
                f(bV);
                AppMethodBeat.o(212656);
            }
        } else {
            String str3 = "";
            if (i2 == 1) {
                str3 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[深度雄文，西部高原屏障对中华民族战略安全的重大意义！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593211927</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + str + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
            } else if (i2 == 2) {
                str3 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[教你一套坐公交车自救秘籍，你想要吗？]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247494577&idx=1&sn=b0e489f3f5517b7942526aab7710052c&chksm=ebb4fd0adcc3741cc503f47ca2e1193af82db286d2baa438bb8d6209de9e192d8aaac5281d2a#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/Y7rtYuVxk9QHKGicgHASZibRp09iaGwSnnAN4cHzBvfupOIsibv78UfUGAJtcH1wT7wmAOicHib1k8a2FErDx7DFMNpg/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[wxv_543960396546260993]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>314</VideoDuration>\n<CreateTime>1542015514</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[" + str + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
            } else if (i2 == 3) {
                str3 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[" + str + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
            } else if (i2 == 4) {
                str3 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>101</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + str + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
            } else if (i2 == 5) {
                str3 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[推荐公众号]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_240fbf8b33e4]]></UserName>\n<NickName><![CDATA[36氪]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></RecommendReason>\n<Signature><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/QicyPhNHD5vYf0JyXiavcUmicQ7icOk55ygRlyOhCa9r132trMAiaYtqL0QzacfMLPolhsiaXGibWC0JskibLic02W6Mw1g/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[8点1氪：微信回应或遭苹果下架；格力口罩昨日开售：KN95每只5.5元；美股史上第二次触发熔断]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI2NDk5NzA0Mw==&mid=2247569208&idx=1&sn=27b7704f80c8271dcad2e52ee63cdf01&chksm=eaa79ee4ddd017f21d63e7a780c1941812f847bf968b40b2d81329b4e9f5a4f70f4e6e814c79#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStEcNCOLwrocic2Vvr0J3qPNiaKYEn2vYIsQbGFBYM5PSAF9NecOalcnFw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStkWNVPziaEt1aEVBPnYyrzlpAbEXicqQ8zRmNgDBfupiccdibuBpeCHpKeQ/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1583799540</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<BizAccount>\n<UserName><![CDATA[gh_363b924965e9]]></UserName>\n<NickName><![CDATA[人民日报]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[参与、沟通、记录时代。]]></RecommendReason>\n<Signature><![CDATA[参与、沟通、记录时代。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/xrFYciaHL08CtD0lEHt59N8SQicW1gI0WjYKCEpzgRCPFBlJGI1rIfRl4bFSTLoFnI4iaylWmJVqd8semEK1OGylg/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[发请柬啦！我们邀请所有人，共同见证一场盛大的婚礼！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=2666316160&idx=1&sn=54684fd350167a7f3bed5bde5ce9dc64&chksm=bdb4a8c38ac321d5852e261a2e31f038fd0e98ec66bee2920d88ee4cdf11979bdede1e0c908e#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsyACCQygrAQqFY1EZiaRwHJYMD7v2x2LLBp0YsHwku3In19N5D3aYZx9A/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsy1kWLuqdNxNVFWIUWBC0DTgnyAkt5cAicI2DyfkVZ14Bx5oemgWmiaphg/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1589804841</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对D不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1589808970</RecID>\n<Style>103</Style>\n<Event></Event>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + str + "]]></CardId>\n<AggregationUrl><![CDATA[http://wwww.baidu.com]]></AggregationUrl>\n<AggregationTitle><![CDATA[大家都在看的大事件 >]]></AggregationTitle>\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n" + "\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
            }
            ab.X(str3, null);
            AppMethodBeat.o(212656);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ege NRw;
        final /* synthetic */ Map NRx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ege ege, Map map) {
            super(0);
            this.NRw = ege;
            this.NRx = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(212635);
            ege ege = this.NRw;
            String str = (String) this.NRx.get(".sysmsg.BizAccountRecommend.Event");
            if (str == null) {
                str = "";
            }
            ege.event = str;
            this.NRw.Ngb = Util.getInt((String) this.NRx.get(".sysmsg.BizAccountRecommend.UseServerTime"), 0);
            ege ege2 = this.NRw;
            ale ale = new ale();
            ale.Lug = this.NRw.NfY.Lug;
            LinkedList<pj> linkedList = new LinkedList<>();
            af.a(linkedList, this.NRx);
            ale.KUf = linkedList;
            String str2 = (String) this.NRx.get(".sysmsg.BizAccountRecommend.RecSummary");
            if (str2 == null) {
                str2 = "";
            }
            ale.Lui = str2;
            String str3 = (String) this.NRx.get(".sysmsg.BizAccountRecommend.CardId");
            if (str3 == null) {
                str3 = "";
            }
            ale.KUk = str3;
            String str4 = (String) this.NRx.get(".sysmsg.BizAccountRecommend.ExpType");
            if (str4 == null) {
                str4 = "";
            }
            ale.KUo = str4;
            ege2.Nga = ale;
            x xVar = x.SXb;
            AppMethodBeat.o(212635);
            return xVar;
        }
    }

    public static final z f(ege ege) {
        long gAO;
        AppMethodBeat.i(212650);
        p.h(ege, "wrapper");
        if (!b(ege, (z) null)) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately illegal");
            AppMethodBeat.o(212650);
            return null;
        } else if (g(ege)) {
            AppMethodBeat.o(212650);
            return null;
        } else {
            aa ban = ag.ban();
            p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
            z gAM = ban.gAM();
            if (ege.Ngb == 1) {
                gAO = Math.abs((ege.MOC * 1000) - bp.aVP()) <= Util.MILLSECONDS_OF_DAY ? ege.MOC * 1000 : bp.aVP();
            } else {
                aa ban2 = ag.ban();
                p.g(ban2, "SubCoreBiz.getBizTimeLineInfoStorage()");
                gAO = ban2.gAO() + 1000;
            }
            z zVar = new z();
            zVar.field_msgId = ag.ban().gAW();
            zVar.field_msgSvrId = 0;
            zVar.field_type = 620757041;
            zVar.field_talker = "";
            zVar.field_talkerId = 0;
            zVar.field_createTime = gAO;
            zVar.nc(1);
            zVar.field_status = 3;
            a(zVar, ege);
            zVar.c(ege);
            aa ban3 = ag.ban();
            p.g(ban3, "SubCoreBiz.getBizTimeLineInfoStorage()");
            long gAo = ban3.gAo();
            long j2 = 0;
            if (gAM != null) {
                if (ege.Ngc.weight >= 0) {
                    j2 = Math.min((long) ege.Ngc.weight, ab.Na(gAM.field_orderFlag));
                } else if (ege.Ngc.pos == 0) {
                    j2 = ab.Na(gAM.field_orderFlag);
                } else {
                    z ajV = ag.ban().ajV(ege.Ngc.pos - 1);
                    if (ajV == null) {
                        Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "insertCanvasCardImmediately lastTimeLineInfo is null");
                    } else {
                        j2 = ab.Na(ajV.field_orderFlag);
                    }
                }
            }
            long j3 = 4278190080L & (j2 << 24);
            long aE = ab.aE(gAo, zVar.field_createTime / 1000);
            if (aE >= 4294967296L) {
                Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately serialNumber is too big %d", Long.valueOf(aE));
                gAo = ag.ban().gAT();
                aE = ab.aE(gAo, zVar.field_createTime / 1000);
            }
            zVar.field_orderFlag = aE | (gAo << 32) | j3;
            ab.E(zVar);
            boolean B = ag.ban().B(zVar);
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately result = " + B + ", title = " + ege.Ngc.title);
            if (B) {
                r rVar = r.NPl;
                if (r.gzP()) {
                    m.IAG.fWS();
                }
                r.NPl.z(zVar);
                ad adVar = ad.NRn;
                if (ad.gBk()) {
                    ad adVar2 = ad.NRn;
                    ad.aka(ab.NQN);
                }
            }
            com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(82);
            s sVar = s.NPC;
            int i2 = ege.pos;
            int i3 = ege.Ngb;
            int i4 = ege.style;
            long j4 = ege.MOC;
            dkp dkp = ege.Ngc;
            String str = dkp != null ? dkp.cardId : null;
            ale ale = ege.Nga;
            s.a(zVar, 1, i2, i3, i4, j4, str, ale != null ? ale.KUo : null, ege.dSJ);
            AppMethodBeat.o(212650);
            return zVar;
        }
    }
}

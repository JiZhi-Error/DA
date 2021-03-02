package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002JJ\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2:\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016JJ\u0010\u001c\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2:\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016JT\u0010\u001d\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2:\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016JT\u0010\u001e\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2:\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016JT\u0010\u001f\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2:\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/MiniProgramPayloadHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBuyPayloadForBubbleClick", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "locClickId", "", "getDetailPayloadForBubbleClick", "getHalfMiniProgramHeight", "", "getNormalPayloadForBubbleClick", "getPayloadForAddProduct", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "gotoHalfScreen", "bundle", "getPayloadForOrder", "getPayloadForProductBuyClick", "getPayloadForProductItemClick", "getPayloadForVisitorBubbleClick", "printPayload", "plugin-finder_release"})
public final class g {
    private static final String TAG = TAG;
    public static final g ufT = new g();

    static {
        AppMethodBeat.i(245869);
        AppMethodBeat.o(245869);
    }

    private g() {
    }

    public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, x> mVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        AppMethodBeat.i(245862);
        p.h(gVar, "liveData");
        String obj = Util.getUuidRandom().toString();
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            c.a aVar = c.sFa;
            c.a.apD(obj);
        }
        com.tencent.mm.plugin.appbrand.api.g gVar2 = new com.tencent.mm.plugin.appbrand.api.g();
        awc awc = gVar.uEl;
        if (awc == null || (str = awc.LGE) == null) {
            str = "";
        }
        gVar2.appId = str;
        awc awc2 = gVar.uEl;
        if (awc2 == null || (str2 = awc2.LGA) == null) {
            str2 = "";
        }
        gVar2.kHw = str2;
        com.tencent.mm.plugin.finder.live.model.x xVar = new com.tencent.mm.plugin.finder.live.model.x();
        awc awc3 = gVar.uEl;
        if (awc3 != null) {
            str3 = awc3.ukr;
        } else {
            str3 = null;
        }
        xVar.ukr = str3;
        gVar2.kHx = xVar;
        gVar2.scene = 1177;
        StringBuilder append = new StringBuilder("live_list_order:").append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
        awc awc4 = gVar.uEl;
        if (awc4 != null) {
            str4 = awc4.vtD;
        } else {
            str4 = null;
        }
        gVar2.dCw = append.append(str4).append(':').append(gVar.sessionId).append(':').append(obj).append(':').append(Util.getUuidRandom()).toString();
        com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
            c.a aVar2 = c.sFa;
            String str6 = gVar2.appId;
            String zs = b.zs(gVar.liveInfo.liveId);
            awc awc5 = gVar.uEl;
            if (awc5 != null) {
                str5 = awc5.vtD;
            }
            c.a.f(obj, str6, zs, str5, b.zs(gVar.sessionId));
        }
        k kVar = k.vkd;
        s dpl = k.dpl();
        String str7 = gVar2.dCw;
        p.g(str7, "sceneNote");
        dpl.auR(str7);
        mVar.invoke(Boolean.FALSE, gVar2);
        AppMethodBeat.o(245862);
    }

    public static void b(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, x> mVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        AppMethodBeat.i(245863);
        p.h(gVar, "liveData");
        String obj = Util.getUuidRandom().toString();
        com.tencent.mm.plugin.appbrand.api.g gVar2 = new com.tencent.mm.plugin.appbrand.api.g();
        awc awc = gVar.uEl;
        if (awc == null || (str = awc.LGD) == null) {
            str = "";
        }
        gVar2.appId = str;
        awc awc2 = gVar.uEl;
        if (awc2 == null || (str2 = awc2.LGB) == null) {
            str2 = "";
        }
        gVar2.kHw = str2;
        com.tencent.mm.plugin.finder.live.model.x xVar = new com.tencent.mm.plugin.finder.live.model.x();
        awc awc3 = gVar.uEl;
        if (awc3 != null) {
            str3 = awc3.ukr;
        } else {
            str3 = null;
        }
        xVar.ukr = str3;
        gVar2.kHx = xVar;
        gVar2.scene = 1176;
        if (gVar.liveInfo.liveId == 0) {
            str4 = "pre_live_add";
        } else {
            str4 = "post_live_add";
        }
        StringBuilder append = new StringBuilder().append(str4).append(':').append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
        awc awc4 = gVar.uEl;
        if (awc4 != null) {
            str5 = awc4.vtD;
        }
        gVar2.dCw = append.append(str5).append(':').append(gVar.sessionId).append(':').append(obj).toString();
        k kVar = k.vkd;
        s dpl = k.dpl();
        String str6 = gVar2.dCw;
        p.g(str6, "sceneNote");
        dpl.auR(str6);
        c.a aVar = c.sFa;
        c.a.apD(obj);
        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
        String str7 = gVar2.appId;
        p.g(str7, "bundle.appId");
        com.tencent.mm.plugin.finder.report.k.a(3, str7, obj, 1176, String.valueOf(gVar.sessionId), str4, gVar.dPI);
        mVar.invoke(Boolean.FALSE, gVar2);
        AppMethodBeat.o(245863);
    }

    public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, axg axg, m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, x> mVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9 = null;
        AppMethodBeat.i(245864);
        p.h(gVar, "liveData");
        if (axg == null) {
            Log.i(TAG, new StringBuilder("[getPayloadForProductItemClick] fail, liveData is null:false,data is null:true!").toString());
            AppMethodBeat.o(245864);
            return;
        }
        y yVar = y.vXH;
        boolean c2 = y.c(axg);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean duW = com.tencent.mm.plugin.finder.storage.c.duW();
        byte[] uuidRandom = Util.getUuidRandom();
        String str10 = TAG;
        StringBuilder sb = new StringBuilder("[getPayloadForProductItemClick] appId:");
        det det = axg.LHI;
        if (det != null) {
            str = det.appId;
        } else {
            str = null;
        }
        Log.i(str10, sb.append(str).append(", isThirdParty:").append(c2).append(", detailPageFirst:").append(duW).append(",clickId:").append(uuidRandom).append('!').toString());
        com.tencent.mm.plugin.appbrand.api.g gVar2 = new com.tencent.mm.plugin.appbrand.api.g();
        det det2 = axg.LHI;
        if (det2 == null || (str2 = det2.appId) == null) {
            str2 = "";
        }
        gVar2.appId = str2;
        det det3 = axg.LHI;
        if (det3 == null || (str3 = det3.path) == null) {
            str3 = "";
        }
        gVar2.kHw = str3;
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            gVar2.scene = 1176;
            if (gVar.liveInfo.liveId == 0) {
                str7 = "pre_live_detail";
            } else {
                str7 = "post_live_detail";
            }
            StringBuilder append = new StringBuilder().append(str7).append(':').append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
            awc awc = gVar.uEl;
            if (awc != null) {
                str8 = awc.vtD;
            } else {
                str8 = null;
            }
            gVar2.dCw = append.append(str8).append(':').append(gVar.sessionId).append(':').append(uuidRandom).toString();
            str4 = str7;
        } else {
            gVar2.scene = 1177;
            str4 = "live_list_detail";
            StringBuilder append2 = new StringBuilder().append(str4).append(':').append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
            awc awc2 = gVar.uEl;
            if (awc2 != null) {
                str5 = awc2.vtD;
            } else {
                str5 = null;
            }
            gVar2.dCw = append2.append(str5).append(':').append(gVar.sessionId).append(':').append(uuidRandom).toString();
        }
        k kVar = k.vkd;
        s dpl = k.dpl();
        String str11 = gVar2.dCw;
        p.g(str11, "sceneNote");
        dpl.auR(str11);
        com.tencent.mm.plugin.finder.live.model.x xVar = new com.tencent.mm.plugin.finder.live.model.x();
        String str12 = axg.dSJ;
        if (str12 == null) {
            str12 = "";
        }
        xVar.atG(str12);
        xVar.uko = axg.uko;
        awc awc3 = gVar.uEl;
        if (awc3 != null) {
            str6 = awc3.ukr;
        } else {
            str6 = null;
        }
        xVar.ukr = str6;
        xVar.uks = 1;
        xVar.ukt = uuidRandom;
        com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            c.a aVar = c.sFa;
            c.a.apD(String.valueOf(xVar.ukt));
        } else {
            c.a aVar2 = c.sFa;
            String valueOf = String.valueOf(xVar.ukt);
            String str13 = gVar2.appId;
            String zs = b.zs(gVar.liveInfo.liveId);
            awc awc4 = gVar.uEl;
            if (awc4 != null) {
                str9 = awc4.vtD;
            }
            c.a.f(valueOf, str13, zs, str9, b.zs(gVar.sessionId));
        }
        gVar2.kHx = xVar;
        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
        String str14 = gVar2.appId;
        p.g(str14, "bundle.appId");
        com.tencent.mm.plugin.finder.report.k.a(3, str14, uuidRandom.toString(), 1176, String.valueOf(gVar.sessionId), str4, gVar.dPI);
        mVar.invoke(Boolean.FALSE, gVar2);
        AppMethodBeat.o(245864);
    }

    public static void b(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, axg axg, m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, x> mVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13 = null;
        AppMethodBeat.i(245865);
        p.h(gVar, "liveData");
        if (axg == null) {
            Log.i(TAG, new StringBuilder("[getPayloadForProductBuyClick] fail, liveData is null:false,data is null:true!").toString());
            AppMethodBeat.o(245865);
            return;
        }
        y yVar = y.vXH;
        boolean c2 = y.c(axg);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean duW = com.tencent.mm.plugin.finder.storage.c.duW();
        byte[] uuidRandom = Util.getUuidRandom();
        String str14 = TAG;
        StringBuilder sb = new StringBuilder("[getPayloadForProductBuyClick] appId:");
        det det = axg.LHI;
        StringBuilder append = sb.append(det != null ? det.appId : null).append(",purchase appId:");
        det det2 = axg.LHN;
        Log.i(str14, append.append(det2 != null ? det2.appId : null).append(", isThirdParty:").append(c2).append(", detailPageFirst:").append(duW).append(",clickId:").append(uuidRandom).append('!').toString());
        if (!c2) {
            if (!c2) {
                com.tencent.mm.plugin.appbrand.api.g gVar2 = new com.tencent.mm.plugin.appbrand.api.g();
                com.tencent.mm.plugin.finder.live.model.x xVar = new com.tencent.mm.plugin.finder.live.model.x();
                String str15 = axg.dSJ;
                if (str15 == null) {
                    str15 = "";
                }
                xVar.atG(str15);
                xVar.uko = axg.uko;
                awc awc = gVar.uEl;
                if (awc != null) {
                    str = awc.ukr;
                } else {
                    str = null;
                }
                xVar.ukr = str;
                xVar.atH("push");
                xVar.uks = 2;
                xVar.ukt = uuidRandom;
                gVar2.kHx = xVar;
                det det3 = axg.LHN;
                if (det3 == null || (str2 = det3.appId) == null) {
                    str2 = "";
                }
                gVar2.appId = str2;
                det det4 = axg.LHN;
                if (det4 == null || (str3 = det4.path) == null) {
                    str3 = "";
                }
                gVar2.kHw = str3;
                gVar2.scene = 1177;
                StringBuilder append2 = new StringBuilder("live_list_buy:").append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
                awc awc2 = gVar.uEl;
                if (awc2 != null) {
                    str4 = awc2.vtD;
                } else {
                    str4 = null;
                }
                gVar2.dCw = append2.append(str4).append(':').append(gVar.sessionId).append(':').append(uuidRandom).toString();
                k kVar = k.vkd;
                s dpl = k.dpl();
                String str16 = gVar2.dCw;
                p.g(str16, "sceneNote");
                dpl.auR(str16);
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                gVar2.kHL = new HalfScreenConfig(true, deU(), true, HalfScreenConfig.a.SLIDE, true, new HalfScreenConfig.BackgroundShapeConfig(context.getResources().getDimension(R.dimen.a59), true, true, 24), true, null, 128);
                c.a aVar = c.sFa;
                String obj = uuidRandom.toString();
                String str17 = gVar2.appId;
                String zs = b.zs(gVar.liveInfo.liveId);
                awc awc3 = gVar.uEl;
                if (awc3 != null) {
                    str13 = awc3.vtD;
                }
                c.a.f(obj, str17, zs, str13, b.zs(gVar.sessionId));
                mVar.invoke(Boolean.TRUE, gVar2);
            }
            AppMethodBeat.o(245865);
        } else if (duW) {
            com.tencent.mm.plugin.appbrand.api.g gVar3 = new com.tencent.mm.plugin.appbrand.api.g();
            com.tencent.mm.plugin.finder.live.model.x xVar2 = new com.tencent.mm.plugin.finder.live.model.x();
            String str18 = axg.dSJ;
            if (str18 == null) {
                str18 = "";
            }
            xVar2.atG(str18);
            xVar2.uko = axg.uko;
            awc awc4 = gVar.uEl;
            if (awc4 != null) {
                str9 = awc4.ukr;
            } else {
                str9 = null;
            }
            xVar2.ukr = str9;
            xVar2.uks = 2;
            xVar2.ukt = uuidRandom;
            gVar3.kHx = xVar2;
            det det5 = axg.LHI;
            if (det5 == null || (str10 = det5.appId) == null) {
                str10 = "";
            }
            gVar3.appId = str10;
            det det6 = axg.LHI;
            if (det6 == null || (str11 = det6.path) == null) {
                str11 = "";
            }
            gVar3.kHw = str11;
            gVar3.scene = 1177;
            StringBuilder append3 = new StringBuilder("live_list_buy:").append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
            awc awc5 = gVar.uEl;
            if (awc5 != null) {
                str12 = awc5.vtD;
            } else {
                str12 = null;
            }
            gVar3.dCw = append3.append(str12).append(':').append(gVar.sessionId).append(':').append(uuidRandom).toString();
            c.a aVar2 = c.sFa;
            String obj2 = uuidRandom.toString();
            String str19 = gVar3.appId;
            String zs2 = b.zs(gVar.liveInfo.liveId);
            awc awc6 = gVar.uEl;
            if (awc6 != null) {
                str13 = awc6.vtD;
            }
            c.a.f(obj2, str19, zs2, str13, b.zs(gVar.sessionId));
            k kVar2 = k.vkd;
            s dpl2 = k.dpl();
            String str20 = gVar3.dCw;
            p.g(str20, "sceneNote");
            dpl2.auR(str20);
            mVar.invoke(Boolean.FALSE, gVar3);
            AppMethodBeat.o(245865);
        } else {
            com.tencent.mm.plugin.appbrand.api.g gVar4 = new com.tencent.mm.plugin.appbrand.api.g();
            com.tencent.mm.plugin.finder.live.model.x xVar3 = new com.tencent.mm.plugin.finder.live.model.x();
            String str21 = axg.dSJ;
            if (str21 == null) {
                str21 = "";
            }
            xVar3.atG(str21);
            xVar3.uko = axg.uko;
            awc awc7 = gVar.uEl;
            if (awc7 != null) {
                str5 = awc7.ukr;
            } else {
                str5 = null;
            }
            xVar3.ukr = str5;
            xVar3.atH("push");
            xVar3.uks = 2;
            xVar3.ukt = uuidRandom;
            gVar4.kHx = xVar3;
            det det7 = axg.LHN;
            if (det7 == null || (str6 = det7.appId) == null) {
                str6 = "";
            }
            gVar4.appId = str6;
            det det8 = axg.LHN;
            if (det8 == null || (str7 = det8.path) == null) {
                str7 = "";
            }
            gVar4.kHw = str7;
            gVar4.scene = 1177;
            StringBuilder append4 = new StringBuilder("live_list_buy:").append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
            awc awc8 = gVar.uEl;
            if (awc8 != null) {
                str8 = awc8.vtD;
            } else {
                str8 = null;
            }
            gVar4.dCw = append4.append(str8).append(':').append(gVar.sessionId).append(':').append(uuidRandom).toString();
            k kVar3 = k.vkd;
            s dpl3 = k.dpl();
            String str22 = gVar4.dCw;
            p.g(str22, "sceneNote");
            dpl3.auR(str22);
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            gVar4.kHL = new HalfScreenConfig(true, deU(), true, HalfScreenConfig.a.SLIDE, true, new HalfScreenConfig.BackgroundShapeConfig(context2.getResources().getDimension(R.dimen.a59), true, true, 24), true, null, 128);
            c.a aVar3 = c.sFa;
            String obj3 = uuidRandom.toString();
            String str23 = gVar4.appId;
            String zs3 = b.zs(gVar.liveInfo.liveId);
            awc awc9 = gVar.uEl;
            if (awc9 != null) {
                str13 = awc9.vtD;
            }
            c.a.f(obj3, str23, zs3, str13, b.zs(gVar.sessionId));
            mVar.invoke(Boolean.TRUE, gVar4);
            AppMethodBeat.o(245865);
        }
    }

    public static void c(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, axg axg, m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, x> mVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        AppMethodBeat.i(245866);
        p.h(gVar, "liveData");
        if (axg == null) {
            Log.i(TAG, "[getPayloadForVisitorBubbleClick] fail, data is null!");
            AppMethodBeat.o(245866);
            return;
        }
        y yVar = y.vXH;
        boolean c2 = y.c(axg);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean duW = com.tencent.mm.plugin.finder.storage.c.duW();
        byte[] uuidRandom = Util.getUuidRandom();
        String str14 = TAG;
        StringBuilder sb = new StringBuilder("[getPayloadForVisitorBubbleClick] appId:");
        det det = axg.LHI;
        StringBuilder append = sb.append(det != null ? det.appId : null).append(",purchase appId:");
        det det2 = axg.LHN;
        if (det2 != null) {
            str = det2.appId;
        } else {
            str = null;
        }
        Log.i(str14, append.append(str).append(", isThirdParty:").append(c2).append(",detailFirst:").append(duW).append(",locClickId:").append(uuidRandom).append('!').toString());
        if (!c2) {
            if (!c2) {
                Boolean bool = Boolean.TRUE;
                p.g(uuidRandom, "locClickId");
                com.tencent.mm.plugin.appbrand.api.g gVar2 = new com.tencent.mm.plugin.appbrand.api.g();
                gVar2.scene = 1177;
                StringBuilder append2 = new StringBuilder("live_bubble:").append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
                awc awc = gVar.uEl;
                if (awc != null) {
                    str2 = awc.vtD;
                } else {
                    str2 = null;
                }
                gVar2.dCw = append2.append(str2).append(':').append(gVar.sessionId).append(':').append(uuidRandom).toString();
                k kVar = k.vkd;
                s dpl = k.dpl();
                String str15 = gVar2.dCw;
                p.g(str15, "sceneNote");
                dpl.auR(str15);
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                gVar2.kHL = new HalfScreenConfig(true, deU(), true, HalfScreenConfig.a.POPUP, true, new HalfScreenConfig.BackgroundShapeConfig(context.getResources().getDimension(R.dimen.a59), true, true, 24), true, null, 128);
                det det3 = axg.LHN;
                if (det3 == null || (str3 = det3.appId) == null) {
                    str3 = "";
                }
                gVar2.appId = str3;
                det det4 = axg.LHN;
                if (det4 == null || (str4 = det4.path) == null) {
                    str4 = "";
                }
                gVar2.kHw = str4;
                com.tencent.mm.plugin.finder.live.model.x xVar = new com.tencent.mm.plugin.finder.live.model.x();
                String str16 = axg.dSJ;
                if (str16 == null) {
                    str16 = "";
                }
                xVar.atG(str16);
                xVar.uko = axg.uko;
                xVar.ukr = axg.ukr;
                xVar.uks = 3;
                xVar.ukt = uuidRandom;
                c.a aVar = c.sFa;
                String obj = uuidRandom.toString();
                String str17 = gVar2.appId;
                String zs = b.zs(gVar.liveInfo.liveId);
                awc awc2 = gVar.uEl;
                if (awc2 != null) {
                    str5 = awc2.vtD;
                } else {
                    str5 = null;
                }
                c.a.f(obj, str17, zs, str5, b.zs(gVar.sessionId));
                gVar2.kHx = xVar;
                mVar.invoke(bool, gVar2);
            }
            AppMethodBeat.o(245866);
        } else if (duW) {
            Boolean bool2 = Boolean.FALSE;
            p.g(uuidRandom, "locClickId");
            com.tencent.mm.plugin.appbrand.api.g gVar3 = new com.tencent.mm.plugin.appbrand.api.g();
            gVar3.scene = 1177;
            StringBuilder append3 = new StringBuilder("live_bubble:").append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
            awc awc3 = gVar.uEl;
            if (awc3 != null) {
                str10 = awc3.vtD;
            } else {
                str10 = null;
            }
            gVar3.dCw = append3.append(str10).append(':').append(gVar.sessionId).append(':').append(uuidRandom).toString();
            k kVar2 = k.vkd;
            s dpl2 = k.dpl();
            String str18 = gVar3.dCw;
            p.g(str18, "sceneNote");
            dpl2.auR(str18);
            det det5 = axg.LHI;
            if (det5 == null || (str11 = det5.appId) == null) {
                str11 = "";
            }
            gVar3.appId = str11;
            det det6 = axg.LHI;
            if (det6 == null || (str12 = det6.path) == null) {
                str12 = "";
            }
            gVar3.kHw = str12;
            com.tencent.mm.plugin.finder.live.model.x xVar2 = new com.tencent.mm.plugin.finder.live.model.x();
            String str19 = axg.dSJ;
            if (str19 == null) {
                str19 = "";
            }
            xVar2.atG(str19);
            xVar2.uko = axg.uko;
            xVar2.ukr = axg.ukr;
            xVar2.uks = 3;
            xVar2.ukt = uuidRandom;
            c.a aVar2 = c.sFa;
            String obj2 = uuidRandom.toString();
            String str20 = gVar3.appId;
            String zs2 = b.zs(gVar.liveInfo.liveId);
            awc awc4 = gVar.uEl;
            if (awc4 != null) {
                str13 = awc4.vtD;
            } else {
                str13 = null;
            }
            c.a.f(obj2, str20, zs2, str13, b.zs(gVar.sessionId));
            gVar3.kHx = xVar2;
            mVar.invoke(bool2, gVar3);
            AppMethodBeat.o(245866);
        } else {
            Boolean bool3 = Boolean.TRUE;
            p.g(uuidRandom, "locClickId");
            com.tencent.mm.plugin.appbrand.api.g gVar4 = new com.tencent.mm.plugin.appbrand.api.g();
            gVar4.scene = 1177;
            StringBuilder append4 = new StringBuilder("live_bubble:").append(gVar.liveInfo.liveId).append(':').append(gVar.hwd).append(':');
            awc awc5 = gVar.uEl;
            if (awc5 != null) {
                str6 = awc5.vtD;
            } else {
                str6 = null;
            }
            gVar4.dCw = append4.append(str6).append(':').append(gVar.sessionId).append(':').append(uuidRandom).toString();
            k kVar3 = k.vkd;
            s dpl3 = k.dpl();
            String str21 = gVar4.dCw;
            p.g(str21, "sceneNote");
            dpl3.auR(str21);
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            gVar4.kHL = new HalfScreenConfig(true, deU(), true, HalfScreenConfig.a.POPUP, true, new HalfScreenConfig.BackgroundShapeConfig(context2.getResources().getDimension(R.dimen.a59), true, true, 24), true, null, 128);
            det det7 = axg.LHN;
            if (det7 == null || (str7 = det7.appId) == null) {
                str7 = "";
            }
            gVar4.appId = str7;
            det det8 = axg.LHN;
            if (det8 == null || (str8 = det8.path) == null) {
                str8 = "";
            }
            gVar4.kHw = str8;
            com.tencent.mm.plugin.finder.live.model.x xVar3 = new com.tencent.mm.plugin.finder.live.model.x();
            String str22 = axg.dSJ;
            if (str22 == null) {
                str22 = "";
            }
            xVar3.atG(str22);
            xVar3.uko = axg.uko;
            xVar3.ukr = axg.ukr;
            xVar3.uks = 3;
            xVar3.ukt = uuidRandom;
            c.a aVar3 = c.sFa;
            String obj3 = uuidRandom.toString();
            String str23 = gVar4.appId;
            String zs3 = b.zs(gVar.liveInfo.liveId);
            awc awc6 = gVar.uEl;
            if (awc6 != null) {
                str9 = awc6.vtD;
            } else {
                str9 = null;
            }
            c.a.f(obj3, str23, zs3, str9, b.zs(gVar.sessionId));
            gVar4.kHx = xVar3;
            mVar.invoke(bool3, gVar4);
            AppMethodBeat.o(245866);
        }
    }

    private static int deU() {
        AppMethodBeat.i(245867);
        float f2 = (float) au.az(MMApplicationContext.getContext()).y;
        Resources resources = MMApplicationContext.getResources();
        p.g(resources, "MMApplicationContext.getResources()");
        if (resources.getConfiguration().orientation == 2) {
            f2 = (float) au.az(MMApplicationContext.getContext()).x;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int duX = (int) (f2 * (((float) com.tencent.mm.plugin.finder.storage.c.duX()) / 100.0f));
        AppMethodBeat.o(245867);
        return duX;
    }

    public static void c(com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(245868);
        p.h(gVar, "bundle");
        Log.i(TAG, "[appId:" + gVar.appId + ",path:" + gVar.kHw + ",halfScreen:" + gVar.kHL.isEnable() + ",scene:" + gVar.scene + ",sceneNote:" + gVar.dCw + ",extraData:" + gVar.kHx + ']');
        AppMethodBeat.o(245868);
    }
}

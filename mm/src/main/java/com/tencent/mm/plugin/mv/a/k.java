package com.tencent.mm.plugin.mv.a;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.stats.LoggingConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.g.b.a.om;
import com.tencent.mm.g.b.a.oo;
import com.tencent.mm.g.b.a.op;
import com.tencent.mm.g.b.a.oq;
import com.tencent.mm.g.b.a.or;
import com.tencent.mm.g.b.a.os;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.s;
import com.tencent.mm.plugin.mv.a.d;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvChattingUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.thumbplayer.d.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J.\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u001e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bJ6\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013J&\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J>\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%J\u001e\u0010&\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J \u0010'\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010)J&\u0010*\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010+\u001a\u00020,J\u0018\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MvReportLogic;", "", "()V", "TAG", "", "getMvPlayTime", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getOnlineUserObj", "Lcom/tencent/mm/plugin/mv/model/OnlineUserObj;", "context", "Landroid/content/Context;", "getPlayMusicTime", "reportComment", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", NativeProtocol.WEB_DIALOG_ACTION, "", "commentId", "reportCommentLike", "reportMvExit", "reportMvInfo", "jumpRet", "jumpScene", "reportMvLike", "reportMvMainUIEnter", "reportMvMainUIExit", "reportMvMakerPlayInfo", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", FirebaseAnalytics.b.INDEX, "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "cdnVideoPlayInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "effectReportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "reportMvMusicCardAction", "reportMvPlayInfo", "playInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "reportMvStat", "record", "Lcom/tencent/mm/plugin/mv/model/StatRecord;", "reportStat", LoggingConstants.LOG_FILE_PREFIX, "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-mv_release"})
public final class k {
    public static final k Aql = new k();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "o1", "", "", "kotlin.jvm.PlatformType", "o2", "compare"})
    public static final class a<T> implements Comparator<Map.Entry<? extends Integer, ? extends Long>> {
        public static final a UZt = new a();

        static {
            AppMethodBeat.i(259177);
            AppMethodBeat.o(259177);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Map.Entry<? extends Integer, ? extends Long> entry, Map.Entry<? extends Integer, ? extends Long> entry2) {
            AppMethodBeat.i(259176);
            Map.Entry<? extends Integer, ? extends Long> entry3 = entry;
            Map.Entry<? extends Integer, ? extends Long> entry4 = entry2;
            if (((Number) entry3.getValue()).longValue() > ((Number) entry4.getValue()).longValue()) {
                AppMethodBeat.o(259176);
                return -1;
            } else if (((Number) entry3.getValue()).longValue() < ((Number) entry4.getValue()).longValue()) {
                AppMethodBeat.o(259176);
                return 1;
            } else {
                AppMethodBeat.o(259176);
                return 0;
            }
        }
    }

    static {
        AppMethodBeat.i(256811);
        AppMethodBeat.o(256811);
    }

    private k() {
    }

    public static void a(Context context, axy axy, e eVar) {
        String str;
        boolean z;
        long j2;
        long j3;
        String str2 = null;
        AppMethodBeat.i(256810);
        p.h(context, "context");
        p.h(axy, "songInfo");
        p.h(eVar, "musicMv");
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        gk gkVar = new gk();
        if (cst != null) {
            gkVar.tW(cst.sGQ);
            gkVar.qn((long) cst.scene);
            gkVar.ub(cst.MxJ);
        }
        String str3 = axy.BPc;
        if (str3 != null) {
            str = n.j(str3, ",", " ", false);
        } else {
            str = null;
        }
        gkVar.tX(str);
        gkVar.ua(axy.LIf);
        gkVar.tY(axy.LIg);
        gkVar.tZ(axy.musicDataUrl);
        String str4 = axy.LIh;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            j2 = 2;
        } else {
            j2 = 1;
        }
        gkVar.qo(j2);
        Long l = eVar.ApE;
        if (l != null) {
            j3 = l.longValue();
        } else {
            j3 = 0;
        }
        gkVar.uc(d.zs(j3));
        gkVar.ud(eVar.ApF);
        gkVar.ue(axy.AqO);
        gkVar.Qf(1);
        String str5 = axy.lDR;
        if (str5 != null) {
            str2 = n.j(str5, ",", " ", false);
        }
        gkVar.bvO(str2);
        gkVar.bfK();
        b bVar = b.QYu;
        b.a(gkVar);
        AppMethodBeat.o(256810);
    }

    public static void b(Context context, axy axy, e eVar) {
        String str;
        long j2;
        boolean z;
        String str2;
        FinderContact finderContact;
        String str3 = null;
        AppMethodBeat.i(259178);
        p.h(context, "context");
        p.h(axy, "songInfo");
        p.h(eVar, "musicMv");
        Log.i("MicroMsg.Mv.MvReportLogic", "reportMVExit");
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        oo ooVar = new oo();
        if (cst != null) {
            Log.i("MicroMsg.Mv.MvReportLogic", "reportMVExit, isComment:" + cst.MxP + ", isDragProcess:" + cst.Vkc + ", StartPlayMusicTick:" + cst.Vkd + ", PausePlayMusicTime:" + cst.Vke + ", scene:" + cst.scene);
            ooVar.bvP(cst.sGQ);
            String str4 = axy.BPc;
            if (str4 != null) {
                str = n.j(str4, ",", " ", false);
            } else {
                str = null;
            }
            ooVar.bvQ(str);
            ooVar.bvR(axy.LIg);
            ooVar.bvS(axy.musicDataUrl);
            ooVar.Qm((long) cst.scene);
            ooVar.bvT(cst.MxJ);
            ooVar.bvU(axy.LIf);
            Long l = eVar.ApE;
            if (l != null) {
                j2 = l.longValue();
            } else {
                j2 = 0;
            }
            ooVar.bvV(d.zs(j2));
            ooVar.bvW(eVar.ApF);
            String str5 = axy.LIh;
            if (str5 == null || str5.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            ooVar.Qn(z ? 2 : 1);
            n mm = mm(context);
            ooVar.Qo(mm.UZu);
            ooVar.Qp(mm.UZv);
            ooVar.Qq((long) cst.MxN);
            ooVar.Qs((long) cst.MxP);
            ooVar.bvX(axy.AqO);
            ooVar.Qm((long) cst.scene);
            ooVar.Qt(((long) axy.duration) / 1000);
            ooVar.Qu(mn(context));
            ooVar.Qr(k(eVar));
            Log.i("MicroMsg.Mv.MvReportLogic", "playMusicTime:" + ooVar.aFP() + ", PauseMusicTick:" + cst.Vkf);
            ooVar.Qv((long) cst.Vkc);
            e.a aVar2 = e.ApR;
            FinderObject a2 = e.a.a(eVar);
            if (a2 == null || (finderContact = a2.contact) == null || (str2 = finderContact.username) == null) {
                str2 = "";
            }
            ooVar.bvY(str2);
            String str6 = axy.lDR;
            if (str6 != null) {
                str3 = n.j(str6, ",", " ", false);
            }
            ooVar.bvZ(str3);
        }
        ooVar.bfK();
        b bVar = b.QYu;
        b.a(ooVar);
        AppMethodBeat.o(259178);
    }

    public static void a(Context context, axy axy, e eVar, o oVar) {
        long j2;
        int i2;
        String str;
        String str2;
        int i3;
        FinderObjectDesc finderObjectDesc;
        AppMethodBeat.i(259179);
        p.h(context, "context");
        p.h(axy, "songInfo");
        p.h(eVar, "musicMv");
        p.h(oVar, "record");
        ecq ecq = new ecq();
        Long l = eVar.ApE;
        if (l != null) {
            j2 = l.longValue();
        } else {
            j2 = 0;
        }
        ecq.hFK = j2;
        ecq.objectNonceId = eVar.ApF;
        ecq.NcN = new epf();
        ecq.NcO = new cxr();
        FinderObject finderObject = eVar.ApN;
        if (finderObject == null || (finderObjectDesc = finderObject.objectDesc) == null) {
            i2 = 0;
        } else {
            i2 = finderObjectDesc.mediaType;
        }
        ecq.mediaType = i2;
        FinderObject finderObject2 = eVar.ApN;
        if (finderObject2 == null || (str = finderObject2.username) == null) {
            str = z.aUg();
        }
        if (str == null) {
            str = "";
        }
        ecq.finderUsername = str;
        ecq.NcP = oVar.loa;
        FinderObject finderObject3 = eVar.ApN;
        if (finderObject3 == null || (str2 = finderObject3.sessionBuffer) == null) {
            str2 = "";
        }
        ecq.sessionBuffer = str2;
        ecq.NcW = oVar.loa;
        long aWA = cl.aWA();
        epf epf = ecq.NcN;
        if (epf != null) {
            epf.Nnc = axy.duration;
            epf.ElR = (int) ((aWA - oVar.loa) / 1000);
            epf.sGB = aWA - oVar.loa;
            epf.Nnd = eVar.UZl;
            epf.Nne = eVar.UZl;
            epf.Nnf = epf.sGB;
            epf.iJF = eVar.UZk;
            epf.Nng = aWA;
            epf.Nnh = eVar.UZm;
        }
        cxr cxr = ecq.NcO;
        if (cxr != null) {
            cxr.MCf = oVar.vfY;
            epf epf2 = ecq.NcN;
            if (epf2 != null) {
                i3 = (int) epf2.sGB;
            } else {
                i3 = 0;
            }
            cxr.MCg = i3;
            cxr.MCq = oVar.vfX;
            cxr.MCh = oVar.UZx;
        }
        Log.i("MicroMsg.Mv.MvReportLogic", "print stats: " + ecq + " index:" + oVar.index);
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        bbn bbn = new bbn();
        if (cst != null) {
            bbn.sGQ = cst.sGQ;
            bbn.tCE = 91;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(ecq);
        s sVar = s.vhF;
        s.a(linkedList, bbn, 0);
        AppMethodBeat.o(259179);
    }

    public static void a(Context context, axy axy, e eVar, int i2, int i3, int i4) {
        String str;
        boolean z;
        String str2 = null;
        AppMethodBeat.i(259180);
        p.h(context, "context");
        p.h(axy, "songInfo");
        p.h(eVar, "musicMv");
        Log.i("MicroMsg.Mv.MvReportLogic", "reportMvInfo, action:".concat(String.valueOf(i2)));
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        op opVar = new op();
        if (cst != null) {
            opVar.bwa(cst.sGQ);
            String str3 = axy.BPc;
            if (str3 != null) {
                str = n.j(str3, ",", " ", false);
            } else {
                str = null;
            }
            opVar.bwb(str);
            opVar.bwc(axy.AqO);
            opVar.bwd(axy.LIg);
            opVar.bwe(axy.musicDataUrl);
            String str4 = axy.lDR;
            if (str4 != null) {
                str2 = n.j(str4, ",", " ", false);
            }
            opVar.bwf(str2);
            opVar.Qw((long) i2);
            opVar.bwg(axy.LIf);
            String str5 = axy.LIh;
            if (str5 == null || str5.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            opVar.Qx(z ? 2 : 1);
            opVar.bwh(axy.LIi);
            opVar.bwi(axy.Djf);
            opVar.Qw((long) i2);
            opVar.Qy((long) i3);
            opVar.Qz((long) i4);
        }
        opVar.bfK();
        b bVar = b.QYu;
        b.a(opVar);
        AppMethodBeat.o(259180);
    }

    public static void a(Context context, axy axy, e eVar, int i2) {
        String str;
        long j2;
        String str2;
        FinderContact finderContact;
        String str3 = null;
        AppMethodBeat.i(259181);
        p.h(context, "context");
        p.h(axy, "songInfo");
        p.h(eVar, "musicMv");
        Log.i("MicroMsg.Mv.MvReportLogic", "reportMvLike, action:".concat(String.valueOf(i2)));
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        oq oqVar = new oq();
        if (cst != null) {
            oqVar.bwj(cst.sGQ);
            oqVar.QC(mn(context));
            oqVar.QD(k(eVar));
        }
        String str4 = axy.BPc;
        if (str4 != null) {
            str = n.j(str4, ",", " ", false);
        } else {
            str = null;
        }
        oqVar.bwk(str);
        oqVar.bwl(axy.AqO);
        oqVar.bwm(axy.LIg);
        oqVar.bwn(axy.musicDataUrl);
        String str5 = axy.lDR;
        if (str5 != null) {
            str3 = n.j(str5, ",", " ", false);
        }
        oqVar.bws(str3);
        oqVar.QB(((long) axy.duration) / 1000);
        Long l = eVar.ApE;
        if (l != null) {
            j2 = l.longValue();
        } else {
            j2 = 0;
        }
        oqVar.bwo(d.zs(j2));
        oqVar.bwp(eVar.ApF);
        e.a aVar2 = e.ApR;
        FinderObject a2 = e.a.a(eVar);
        if (a2 == null || (finderContact = a2.contact) == null || (str2 = finderContact.username) == null) {
            str2 = "";
        }
        oqVar.bwq(str2);
        oqVar.QA((long) i2);
        oqVar.bfK();
        b bVar = b.QYu;
        b.a(oqVar);
        AppMethodBeat.o(259181);
    }

    public static void a(Context context, axy axy, e eVar, int i2, long j2) {
        String str;
        long j3;
        String str2;
        FinderContact finderContact;
        String str3 = null;
        AppMethodBeat.i(259182);
        p.h(context, "context");
        p.h(axy, "songInfo");
        p.h(eVar, "musicMv");
        Log.i("MicroMsg.Mv.MvReportLogic", "reportCommentLike, action:".concat(String.valueOf(i2)));
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        oq oqVar = new oq();
        if (cst != null) {
            oqVar.bwj(cst.sGQ);
            oqVar.QC(mn(context));
            oqVar.QD(k(eVar));
        }
        String str4 = axy.BPc;
        if (str4 != null) {
            str = n.j(str4, ",", " ", false);
        } else {
            str = null;
        }
        oqVar.bwk(str);
        oqVar.bwl(axy.AqO);
        oqVar.bwm(axy.LIg);
        oqVar.bwn(axy.musicDataUrl);
        String str5 = axy.lDR;
        if (str5 != null) {
            str3 = n.j(str5, ",", " ", false);
        }
        oqVar.bws(str3);
        oqVar.QB(((long) axy.duration) / 1000);
        Long l = eVar.ApE;
        if (l != null) {
            j3 = l.longValue();
        } else {
            j3 = 0;
        }
        oqVar.bwo(d.zs(j3));
        oqVar.bwp(eVar.ApF);
        e.a aVar2 = e.ApR;
        FinderObject a2 = e.a.a(eVar);
        if (a2 == null || (finderContact = a2.contact) == null || (str2 = finderContact.username) == null) {
            str2 = "";
        }
        oqVar.bwq(str2);
        oqVar.QA((long) i2);
        oqVar.bwr(String.valueOf(j2));
        oqVar.bfK();
        b bVar = b.QYu;
        b.a(oqVar);
        AppMethodBeat.o(259182);
    }

    public static void b(Context context, axy axy, e eVar, int i2, long j2) {
        String str;
        long j3;
        String str2;
        FinderContact finderContact;
        String str3 = null;
        AppMethodBeat.i(259183);
        p.h(context, "context");
        p.h(axy, "songInfo");
        p.h(eVar, "musicMv");
        Log.i("MicroMsg.Mv.MvReportLogic", "reportComment, action:".concat(String.valueOf(i2)));
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        om omVar = new om();
        if (cst != null) {
            omVar.aYK(cst.sGQ);
            omVar.PT(mn(context));
            omVar.PU(k(eVar));
        }
        String str4 = axy.BPc;
        if (str4 != null) {
            str = n.j(str4, ",", " ", false);
        } else {
            str = null;
        }
        omVar.aYL(str);
        omVar.aZk(axy.AqO);
        omVar.aZl(axy.LIg);
        omVar.aZm(axy.musicDataUrl);
        String str5 = axy.lDR;
        if (str5 != null) {
            str3 = n.j(str5, ",", " ", false);
        }
        omVar.bnJ(str3);
        omVar.PS(((long) axy.duration) / 1000);
        Long l = eVar.ApE;
        if (l != null) {
            j3 = l.longValue();
        } else {
            j3 = 0;
        }
        omVar.aZn(d.zs(j3));
        omVar.baX(eVar.ApF);
        e.a aVar2 = e.ApR;
        FinderObject a2 = e.a.a(eVar);
        if (a2 == null || (finderContact = a2.contact) == null || (str2 = finderContact.username) == null) {
            str2 = "";
        }
        omVar.bla(str2);
        omVar.PR((long) i2);
        omVar.ble(String.valueOf(j2));
        omVar.bfK();
        b bVar = b.QYu;
        b.a(omVar);
        AppMethodBeat.o(259183);
    }

    public static void a(Context context, axy axy, int i2) {
        String str;
        String str2 = null;
        AppMethodBeat.i(259184);
        p.h(context, "context");
        p.h(axy, "songInfo");
        Log.i("MicroMsg.Mv.MvReportLogic", "reportMvMusicCardAction, action:".concat(String.valueOf(i2)));
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        ol olVar = new ol();
        if (cst != null) {
            olVar.axG(cst.sGQ);
            olVar.PQ((long) cst.scene);
            olVar.aWS(cst.MxJ);
        }
        String str3 = axy.BPc;
        if (str3 != null) {
            str = n.j(str3, ",", " ", false);
        } else {
            str = null;
        }
        olVar.aDr(str);
        olVar.aTg(axy.AqO);
        olVar.aTq(axy.LIg);
        olVar.aWL(axy.musicDataUrl);
        String str4 = axy.lDR;
        if (str4 != null) {
            str2 = n.j(str4, ",", " ", false);
        }
        olVar.aWM(str2);
        olVar.aYJ(axy.LIf);
        olVar.PP((long) i2);
        olVar.bfK();
        b bVar = b.QYu;
        b.a(olVar);
        AppMethodBeat.o(259184);
    }

    public static void a(Context context, e eVar, com.tencent.mm.plugin.thumbplayer.d.d dVar) {
        String str;
        int i2;
        AppMethodBeat.i(259185);
        p.h(context, "context");
        p.h(eVar, "musicMv");
        if (dVar == null) {
            AppMethodBeat.o(259185);
        } else if (dVar.VfL.isEmpty()) {
            AppMethodBeat.o(259185);
        } else {
            dVar.vgo = Util.ticksToNow(dVar.gXF);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
            os osVar = new os();
            if (cst != null) {
                osVar.bww(cst.sGQ);
                osVar.QJ((long) cst.scene);
            }
            osVar.bwy(eVar.ApF);
            Long l = eVar.ApE;
            if (l != null) {
                str = String.valueOf(l.longValue());
            } else {
                str = null;
            }
            osVar.bwx(str);
            osVar.QK(dVar.VfK);
            osVar.QM(dVar.vgo);
            Collection<com.tencent.mm.plugin.thumbplayer.d.b> values = dVar.VfL.values();
            p.g(values, "playInfo.mediaReportInfo.values");
            Iterator<T> it = values.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = it.next().Vfy + i3;
            }
            osVar.QL((long) i3);
            osVar.bwz(dVar.hXD());
            Collection<com.tencent.mm.plugin.thumbplayer.d.b> values2 = dVar.VfL.values();
            p.g(values2, "mediaReportInfo.values");
            Iterator<T> it2 = values2.iterator();
            int i4 = 0;
            while (it2.hasNext()) {
                if (it2.next().hXC()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i4 = i2 + i4;
            }
            osVar.QN((long) i4);
            osVar.bfK();
            dVar.VfL.clear();
            c cVar = dVar.VfJ;
            if (cVar != null) {
                cVar.reset();
            }
            b bVar = b.QYu;
            b.a(osVar);
            AppMethodBeat.o(259185);
        }
    }

    public static void a(Context context, csp csp, int i2, d dVar, com.tencent.mm.plugin.thumbplayer.d.b bVar, c cVar) {
        boolean z;
        String str;
        int i3;
        boolean z2 = false;
        int i4 = 1;
        AppMethodBeat.i(259186);
        p.h(context, "context");
        if (csp == null || dVar == null || bVar == null || cVar == null) {
            AppMethodBeat.o(259186);
            return;
        }
        bVar.stop();
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        or orVar = new or();
        if (cst != null) {
            orVar.bwt(cst.sGQ);
            orVar.QE((long) cst.scene);
        }
        d.h hVar = dVar.App;
        if (hVar != null) {
            z = hVar.dkS();
        } else {
            z = false;
        }
        if (dVar.Apq != null) {
            z2 = true;
        }
        FinderObject finderObject = csp.MxE;
        if (finderObject == null || (str = String.valueOf(finderObject.id)) == null) {
            str = "";
        }
        orVar.bwu(str);
        FinderObject finderObject2 = csp.MxE;
        orVar.bwv(finderObject2 != null ? finderObject2.objectNonceId : null);
        orVar.abO(i2);
        if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        orVar.akp(i3);
        if (!z) {
            i4 = 2;
        }
        orVar.akq(i4);
        orVar.QF(bVar.Vfx);
        orVar.QG((long) bVar.Vfy);
        orVar.QH((long) bVar.errType);
        orVar.QI((long) bVar.errCode);
        orVar.bfK();
        bVar.gXF = Util.currentTicks();
        cVar.reset();
        b bVar2 = b.QYu;
        b.a(orVar);
        AppMethodBeat.o(259186);
    }

    public static n mm(Context context) {
        Integer num;
        long j2 = 1;
        AppMethodBeat.i(259187);
        p.h(context, "context");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.ko(context).get(MusicMvChattingUIC.class);
        p.g(viewModel, "UICProvider.of(context).…vChattingUIC::class.java)");
        HashMap<Integer, Long> hashMap = ((MusicMvChattingUIC) viewModel).AsY;
        LinkedList<Map.Entry> linkedList = new LinkedList();
        linkedList.addAll(hashMap.entrySet());
        j.a((List) linkedList, (Comparator) a.UZt);
        long j3 = 1;
        for (Map.Entry entry : linkedList) {
            if (j2 < ((Number) entry.getKey()).longValue()) {
                j2 = (long) ((Number) entry.getKey()).intValue();
            } else {
                j2 = j2;
            }
            if (j3 > ((Number) entry.getKey()).longValue()) {
                j3 = (long) ((Number) entry.getKey()).intValue();
            }
        }
        Map.Entry entry2 = (Map.Entry) j.kt(linkedList);
        n nVar = new n(j2, j3, (entry2 == null || (num = (Integer) entry2.getKey()) == null) ? 0 : (long) num.intValue());
        AppMethodBeat.o(259187);
        return nVar;
    }

    public static long mn(Context context) {
        AppMethodBeat.i(259188);
        p.h(context, "context");
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        if (cst == null) {
            AppMethodBeat.o(259188);
            return 0;
        } else if (cst.Vkf > 0) {
            long currentTicks = Util.currentTicks() - cst.Vkf;
            Log.i("MicroMsg.Mv.MvReportLogic", "pause music now, pauseTime:".concat(String.valueOf(currentTicks)));
            long currentTicks2 = (Util.currentTicks() - cst.Vkd) - currentTicks;
            AppMethodBeat.o(259188);
            return currentTicks2;
        } else {
            long currentTicks3 = (Util.currentTicks() - cst.Vkd) - cst.Vke;
            AppMethodBeat.o(259188);
            return currentTicks3;
        }
    }

    private static long k(e eVar) {
        long j2;
        AppMethodBeat.i(259189);
        p.h(eVar, "musicMv");
        if (eVar.UZk > 0) {
            j2 = (eVar.UZl + cl.aWA()) - eVar.UZk;
        } else {
            j2 = eVar.UZl;
        }
        long j3 = j2 / 1000;
        AppMethodBeat.o(259189);
        return j3;
    }
}

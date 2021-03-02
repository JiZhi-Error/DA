package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.Cdo;
import com.tencent.mm.g.b.a.ai;
import com.tencent.mm.g.b.a.bb;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.g.b.a.bf;
import com.tencent.mm.g.b.a.bk;
import com.tencent.mm.g.b.a.bl;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.g.b.a.bs;
import com.tencent.mm.g.b.a.bz;
import com.tencent.mm.g.b.a.cc;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.g.b.a.ci;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.cu;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.g.b.a.cx;
import com.tencent.mm.g.b.a.cz;
import com.tencent.mm.g.b.a.da;
import com.tencent.mm.g.b.a.db;
import com.tencent.mm.g.b.a.dd;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.g.b.a.dp;
import com.tencent.mm.g.b.a.ds;
import com.tencent.mm.g.b.a.du;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.g.b.a.dx;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.b.a.ef;
import com.tencent.mm.g.b.a.eg;
import com.tencent.mm.g.b.a.eh;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.g.b.a.gu;
import com.tencent.mm.g.b.a.oj;
import com.tencent.mm.g.b.a.ox;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.live.h;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMFragmentActivity;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.u;
import kotlin.x;
import org.xwalk.core.NetworkUtil;

public final class k {
    public static final String TAG = TAG;
    private static final BigInteger TWO_64 = BigInteger.ONE.shiftLeft(64);
    public static final k vfA = new k();
    private static String vfu = "";
    private static final LongSparseArray<Long> vfv = new LongSparseArray<>();
    private static HashMap<String, String> vfw = new HashMap<>();
    private static final LongSparseArray<Long> vfx = new LongSparseArray<>();
    private static final HashMap<String, String> vfy = new HashMap<>();
    private static final SparseArray<Long> vfz = new SparseArray<>();

    static {
        AppMethodBeat.i(166595);
        AppMethodBeat.o(166595);
    }

    private k() {
    }

    public static FinderItem Fc(long j2) {
        AppMethodBeat.i(166576);
        e.a aVar = e.vFX;
        FinderItem Fy = e.a.Fy(j2);
        if (Fy == null) {
            i iVar = i.vvu;
            Fy = i.dqb().get(Long.valueOf(j2));
        }
        if (Fy == null) {
            FinderTopicFeedUI.a aVar2 = FinderTopicFeedUI.udw;
            Fy = (FinderItem) FinderTopicFeedUI.tZo.get(Long.valueOf(j2));
        }
        if (Fy == null) {
            FinderAtTimelineUI.a aVar3 = FinderAtTimelineUI.tZp;
            Fy = (FinderItem) FinderAtTimelineUI.tZo.get(Long.valueOf(j2));
        }
        AppMethodBeat.o(166576);
        return Fy;
    }

    public static bm Fd(long j2) {
        AppMethodBeat.i(250628);
        e.a aVar = e.vFX;
        FinderObject FD = e.a.FD(j2);
        if (FD != null) {
            bm bmVar = new bm(FD);
            AppMethodBeat.o(250628);
            return bmVar;
        }
        AppMethodBeat.o(250628);
        return null;
    }

    public static void auJ(String str) {
        vfu = str;
    }

    public static String dob() {
        return vfu;
    }

    public static String G(long j2, int i2) {
        AppMethodBeat.i(250629);
        String str = vfw.get(new StringBuilder().append(j2).append('_').append(i2).toString());
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(250629);
        return str;
    }

    public static String H(long j2, int i2) {
        AppMethodBeat.i(250630);
        String str = vfy.get(new StringBuilder().append(j2).append('_').append(i2).toString());
        AppMethodBeat.o(250630);
        return str;
    }

    public static long Fe(long j2) {
        AppMethodBeat.i(250631);
        Long l = vfv.get(j2);
        if (l != null) {
            long longValue = l.longValue();
            AppMethodBeat.o(250631);
            return longValue;
        }
        AppMethodBeat.o(250631);
        return 0;
    }

    public static long Ff(long j2) {
        AppMethodBeat.i(250632);
        Long l = vfx.get(j2);
        if (l != null) {
            long longValue = l.longValue();
            AppMethodBeat.o(250632);
            return longValue;
        }
        AppMethodBeat.o(250632);
        return 0;
    }

    public static void d(long j2, int i2, String str) {
        String j3;
        AppMethodBeat.i(250633);
        if (!(str == null || (j3 = n.j(str, ",", ";", false)) == null)) {
            switch (i2) {
                case 46:
                    vfy.put(j2 + "_46", j3);
                    break;
                case 47:
                    vfy.put(j2 + "_47", j3);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    vfy.put(j2 + "_48", j3);
                    break;
                default:
                    vfy.put(new StringBuilder().append(j2).append('_').append(i2).toString(), j3);
                    break;
            }
        }
        vfx.put(j2, Long.valueOf(cl.aWA()));
        AppMethodBeat.o(250633);
    }

    public static void e(long j2, int i2, String str) {
        String j3;
        AppMethodBeat.i(250634);
        if (!(str == null || (j3 = n.j(str, ",", ";", false)) == null)) {
            switch (i2) {
                case 1:
                case 32:
                    vfw.put(j2 + "_32", j3);
                    vfw.put(j2 + "_1", j3);
                    break;
                case 6:
                case 23:
                    vfw.put(j2 + "_6", j3);
                    vfw.put(j2 + "_23", j3);
                    break;
                case 8:
                case 33:
                    vfw.put(j2 + "_33", j3);
                    vfw.put(j2 + "_8", j3);
                    break;
                case 9:
                case 22:
                    vfw.put(j2 + "_9", j3);
                    vfw.put(j2 + "_22", j3);
                    break;
                case 15:
                case 16:
                case 43:
                    vfw.put(j2 + "_15", j3);
                    vfw.put(j2 + "_16", j3);
                    break;
                case 21:
                case 24:
                    vfw.put(j2 + "_24", j3);
                    vfw.put(j2 + "_21", j3);
                    break;
                case 26:
                case 27:
                    vfw.put(j2 + "_26", j3);
                    vfw.put(j2 + "_27", j3);
                    break;
                case bv.CTRL_INDEX:
                case 60:
                    vfw.put(j2 + "_59", j3);
                    vfw.put(j2 + "_60", j3);
                    break;
                default:
                    vfw.put(new StringBuilder().append(j2).append('_').append(i2).toString(), j3);
                    break;
            }
        }
        vfv.put(j2, Long.valueOf(cl.aWA()));
        AppMethodBeat.o(250634);
    }

    public static long Kt(int i2) {
        AppMethodBeat.i(250635);
        Long l = vfz.get(i2);
        if (l != null) {
            long longValue = l.longValue();
            AppMethodBeat.o(250635);
            return longValue;
        }
        AppMethodBeat.o(250635);
        return 0;
    }

    public static void Ku(int i2) {
        AppMethodBeat.i(250636);
        vfz.put(i2, Long.valueOf(cl.aWA()));
        AppMethodBeat.o(250636);
    }

    public static void I(long j2, int i2) {
        AppMethodBeat.i(166577);
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            bb bbVar = new bb();
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            bbVar.iI(cMD);
            bbVar.iJ(d.zs(Fc.getId()));
            bbVar.dc((long) i2);
            bbVar.cX((long) Fc.getLikeCount());
            bbVar.cY((long) Fc.getCommentCount());
            bbVar.cZ((long) Fc.getFriendLikeCount());
            bbVar.db((long) Fc.getMediaType());
            bbVar.iK("");
            bbVar.da((long) i2);
            bbVar.bfK();
            a(bbVar);
            AppMethodBeat.o(166577);
            return;
        }
        AppMethodBeat.o(166577);
    }

    public static void a(long j2, String str, int i2, int i3) {
        AppMethodBeat.i(250637);
        p.h(str, "topic");
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            eg egVar = new eg();
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            egVar.qM(cMD);
            egVar.qN("");
            egVar.lK((long) i3);
            egVar.qO(Fg(Fc.getId()));
            egVar.lL((long) Fc.getMediaType());
            w wVar = w.vXp;
            egVar.qP(n.j(w.z(str, i2, 0), ",", ";", false));
            egVar.qQ("");
            egVar.lM((long) Fc.getFeedObject().likeCount);
            egVar.lN((long) Fc.getFeedObject().commentCount);
            egVar.lO((long) Fc.getFeedObject().friendLikeCount);
            egVar.bfK();
            a(egVar);
            AppMethodBeat.o(250637);
            return;
        }
        AppMethodBeat.o(250637);
    }

    public static void a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, bbn bbn) {
        AppMethodBeat.i(250638);
        dv dvVar = new dv();
        dvVar.afh();
        dvVar.qc(str);
        dvVar.qd(str2);
        dvVar.qe(str3);
        dvVar.kV((long) i2);
        dvVar.kW((long) i3);
        dvVar.kY((long) i4);
        dvVar.kZ((long) i5);
        dvVar.la((long) i6);
        if (bbn != null) {
            dvVar.qa(bbn.sessionId);
            dvVar.kX((long) bbn.tCE);
            dvVar.qb(bbn.sGE);
        }
        dvVar.bfK();
        a(dvVar);
        AppMethodBeat.o(250638);
    }

    public static void a(String str, String str2, int i2, int i3, String str3, int i4, int i5, String str4, int i6, bbn bbn) {
        AppMethodBeat.i(250639);
        dw dwVar = new dw();
        dwVar.qf(str);
        dwVar.qg(str2);
        dwVar.kX(i2);
        dwVar.kY(i3);
        dwVar.qh(str3);
        dwVar.kZ(i4);
        dwVar.la(i5);
        dwVar.afi();
        if (bbn != null) {
            dwVar.qi(bbn.sessionId);
            dwVar.lb(bbn.tCE);
            dwVar.qj(bbn.sGE);
        }
        dwVar.qk(str4);
        dwVar.afj();
        dwVar.lc(i6);
        dwVar.bfK();
        a(dwVar);
        AppMethodBeat.o(250639);
    }

    public static void a(String str, String str2, int i2, int i3, String str3, int i4, int i5, String str4, int i6, int i7, bbn bbn) {
        AppMethodBeat.i(250640);
        dd ddVar = new dd();
        ddVar.ol(str);
        ddVar.om(str2);
        ddVar.kB(i2);
        ddVar.kC(i3);
        ddVar.on(str3);
        ddVar.kD(i4);
        ddVar.kE(i5);
        ddVar.afc();
        if (bbn != null) {
            ddVar.oo(bbn.sessionId);
            ddVar.kF(bbn.tCE);
            ddVar.op(bbn.sGE);
        }
        ddVar.oq(str4);
        ddVar.kG(i6);
        ddVar.kH(i7);
        ddVar.bfK();
        a(ddVar);
        AppMethodBeat.o(250640);
    }

    public static void a(String str, int i2, int i3, bbn bbn) {
        AppMethodBeat.i(250641);
        ch chVar = new ch();
        if (bbn != null) {
            chVar.lI(bbn.sessionId);
            chVar.lJ(bbn.sGE);
            chVar.kb(bbn.tCE);
        }
        chVar.lK(str);
        chVar.kc(i2);
        chVar.adc();
        chVar.ade();
        chVar.kd(i3);
        chVar.bfK();
        a(chVar);
        AppMethodBeat.o(250641);
    }

    public static void a(int i2, boolean z, String str, int i3, long j2, String str2) {
        AppMethodBeat.i(166579);
        p.h(str, "topic");
        p.h(str2, "receiver");
        eh ehVar = new eh();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        ehVar.qR(cMD);
        ehVar.lP((long) i2);
        ehVar.lQ(z ? 1 : 2);
        w wVar = w.vXp;
        ehVar.qS(n.j(w.z(str, i3, j2), ",", ";", false));
        ehVar.qT("");
        ehVar.lR(j2);
        ehVar.qU(str2);
        ehVar.bfK();
        a(ehVar);
        AppMethodBeat.o(166579);
    }

    public static void a(int i2, boolean z, String str, long j2, String str2, bbn bbn) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        AppMethodBeat.i(250642);
        p.h(str, "receiver");
        cf cfVar = new cf();
        cfVar.fP(bbn != null ? (long) bbn.tCE : 0);
        cfVar.fJ((long) i2);
        cfVar.fK(z ? 1 : 2);
        cfVar.fQ(j2);
        cfVar.lu(str);
        if (bbn == null || (str3 = bbn.sessionId) == null) {
            str3 = "";
        }
        cfVar.lr(str3);
        if (bbn == null || (str4 = bbn.sGE) == null) {
            str4 = "";
        }
        cfVar.ly(str4);
        if (bbn == null || (str5 = bbn.sGQ) == null) {
            str5 = "";
        }
        cfVar.lz(str5);
        if (bbn == null || (str9 = bbn.extraInfo) == null || (str6 = n.j(str9, ",", ";", false)) == null) {
            str6 = "";
        }
        cfVar.lB(str6);
        if (bbn == null || (str8 = bbn.sGH) == null || (str7 = n.j(str8, ",", ";", false)) == null) {
            str7 = "";
        }
        cfVar.lC(str7);
        if (str2 == null) {
            str2 = "";
        }
        cfVar.lG(str2);
        cfVar.bfK();
        a(cfVar);
        AppMethodBeat.o(250642);
    }

    public static void a(long j2, long j3, long j4, String str, long j5, int i2) {
        AppMethodBeat.i(250643);
        p.h(str, "paperWording");
        ai aiVar = new ai();
        aiVar.il(Fg(j2));
        aiVar.bZ(j3);
        aiVar.im(Fg(j4));
        aiVar.in(str);
        aiVar.ca(j5);
        aiVar.bY(cl.aWA());
        aiVar.io(G(j2, i2));
        aiVar.bfK();
        a(aiVar);
        AppMethodBeat.o(250643);
    }

    public static void J(long j2, int i2) {
        AppMethodBeat.i(166580);
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            dn dnVar = new dn();
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            dnVar.pg(cMD);
            dnVar.kk((long) i2);
            w wVar = w.vXp;
            dnVar.ph(n.j(w.z(Fc), ",", ";", false));
            dnVar.pi("");
            dnVar.pj(Fg(Fc.getId()));
            dnVar.kl((long) Fc.getFeedObject().likeCount);
            dnVar.bfK();
            a(dnVar);
            AppMethodBeat.o(166580);
            return;
        }
        AppMethodBeat.o(166580);
    }

    public static /* synthetic */ void a(k kVar, long j2, int i2, String str, int i3) {
        AppMethodBeat.i(250645);
        kVar.a(j2, i2, str, i3, 0);
        AppMethodBeat.o(250645);
    }

    public final void a(long j2, int i2, String str, int i3, int i4) {
        AppMethodBeat.i(250644);
        p.h(str, "fromUser");
        a(j2, i2, 1L, str, i3, i4);
        AppMethodBeat.o(250644);
    }

    public static /* synthetic */ void a(long j2, int i2, long j3, String str, int i3, int i4) {
        AppMethodBeat.i(250647);
        a(j2, i2, j3, str, i3, i4, (String) null);
        AppMethodBeat.o(250647);
    }

    public static void a(long j2, int i2, long j3, String str, int i3, int i4, String str2) {
        long j4;
        bq bqVar;
        azr azr;
        azk azk;
        azr azr2;
        azr azr3;
        AppMethodBeat.i(250646);
        p.h(str, "fromUser");
        bq bqVar2 = new bq();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        bqVar2.jP(cMD);
        bqVar2.eq((long) i2);
        bqVar2.er(j3);
        bqVar2.jQ(str);
        bqVar2.jR(Fg(j2));
        bqVar2.et((long) i3);
        bqVar2.eu((long) i4);
        if (str2 != null) {
            bqVar2.jW(str2);
        }
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            bqVar2.jS(Fc.getFeedObject().username);
            w wVar = w.vXp;
            bqVar2.jT(n.j(w.z(Fc), ",", ";", false));
            LinkedList<cjl> mediaList = Fc.getMediaList();
            ArrayList arrayList = new ArrayList(j.a(mediaList, 10));
            Iterator<T> it = mediaList.iterator();
            while (it.hasNext()) {
                bqVar2.es(Util.isNullOrNil(it.next().coverUrl) ? 0 : 1);
                arrayList.add(x.SXb);
            }
            FinderObjectDesc finderObjectDesc = Fc.getFinderObject().objectDesc;
            bqVar2.jU((finderObjectDesc == null || (azr3 = finderObjectDesc.feedBgmInfo) == null) ? null : azr3.groupId);
            FinderObjectDesc finderObjectDesc2 = Fc.getFeedObject().objectDesc;
            if (((finderObjectDesc2 == null || (azr2 = finderObjectDesc2.feedBgmInfo) == null) ? null : azr2.musicInfo) != null) {
                FinderObjectDesc finderObjectDesc3 = Fc.getFeedObject().objectDesc;
                String str3 = (finderObjectDesc3 == null || (azr = finderObjectDesc3.feedBgmInfo) == null || (azk = azr.musicInfo) == null) ? null : azk.wWb;
                if (!(str3 == null || str3.length() == 0)) {
                    j4 = 2;
                    bqVar = bqVar2;
                    bqVar.ev(j4);
                }
            }
            j4 = 1;
            bqVar = bqVar2;
            bqVar.ev(j4);
        }
        bqVar2.bfK();
        a(bqVar2);
        AppMethodBeat.o(250646);
    }

    public static void x(int i2, String str, String str2) {
        AppMethodBeat.i(166581);
        p.h(str, "fromUser");
        p.h(str2, "nameCardUser");
        String str3 = ((c) g.af(c.class)).cMD() + ',' + i2 + ",2," + str + ",0," + str2;
        Log.i(TAG, "18944 ".concat(String.valueOf(str3)));
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(18944, str3);
        AppMethodBeat.o(166581);
    }

    public static void e(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(166582);
        p.h(str, "fromUser");
        p.h(str2, "topic");
        StringBuilder append = new StringBuilder().append(((c) g.af(c.class)).cMD()).append(',').append(i2).append(",3,").append(str).append(",0,,");
        w wVar = w.vXp;
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(18944, append.append(w.dO(str2, i3)).toString());
        AppMethodBeat.o(166582);
    }

    public static /* synthetic */ void a(long j2, int i2, long j3, String str, bbn bbn, long j4, FinderItem finderItem, int i3) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        cf cfVar;
        long j5;
        String str8;
        boolean z;
        azr azr;
        azk azk;
        azr azr2;
        azr azr3;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        cf cfVar2;
        long j6;
        azr azr4;
        azk azk2;
        azr azr5;
        azr azr6;
        String str17;
        String str18;
        AppMethodBeat.i(250648);
        if ((i3 & 32) != 0) {
            j4 = 0;
        }
        if ((i3 & 64) != 0) {
            finderItem = null;
        }
        p.h(str, "receiver");
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            cf cfVar3 = new cf();
            if (bbn == null || (str12 = bbn.sessionId) == null) {
                str12 = "";
            }
            cfVar3.lr(str12);
            cfVar3.fJ((long) i2);
            cfVar3.fK(j3);
            cfVar3.ls(Fg(Fc.getId()));
            cfVar3.lt(Fc.getFeedObject().username);
            cfVar3.lu(str);
            cfVar3.fL((long) Fc.getLikeCount());
            cfVar3.fM((long) Fc.getCommentCount());
            cfVar3.fN((long) Fc.getFriendLikeCount());
            cfVar3.lv("");
            cfVar3.fO((long) Fc.getMediaType());
            w wVar = w.vXp;
            cfVar3.lw(n.j(w.z(Fc), ",", ";", false));
            cfVar3.lx("");
            cfVar3.fP(bbn != null ? (long) bbn.tCE : 0);
            if (bbn == null || (str13 = bbn.sGE) == null) {
                str13 = "";
            }
            cfVar3.ly(str13);
            if (bbn == null || (str14 = bbn.sGQ) == null) {
                str14 = "";
            }
            cfVar3.lz(str14);
            cfVar3.lA(G(j2, bbn != null ? bbn.tCE : 0));
            cfVar3.fQ(j4);
            if (bbn == null || (str18 = bbn.extraInfo) == null || (str15 = n.j(str18, ",", ";", false)) == null) {
                str15 = "";
            }
            cfVar3.lB(str15);
            if (bbn == null || (str17 = bbn.sGH) == null || (str16 = n.j(str17, ",", ";", false)) == null) {
                str16 = "";
            }
            cfVar3.lC(str16);
            FinderObjectDesc finderObjectDesc = Fc.getFinderObject().objectDesc;
            cfVar3.lE((finderObjectDesc == null || (azr6 = finderObjectDesc.feedBgmInfo) == null) ? null : azr6.groupId);
            FinderObjectDesc finderObjectDesc2 = Fc.getFeedObject().objectDesc;
            if (((finderObjectDesc2 == null || (azr5 = finderObjectDesc2.feedBgmInfo) == null) ? null : azr5.musicInfo) != null) {
                FinderObjectDesc finderObjectDesc3 = Fc.getFeedObject().objectDesc;
                String str19 = (finderObjectDesc3 == null || (azr4 = finderObjectDesc3.feedBgmInfo) == null || (azk2 = azr4.musicInfo) == null) ? null : azk2.wWb;
                if (!(str19 == null || str19.length() == 0)) {
                    j6 = 2;
                    cfVar2 = cfVar3;
                    cfVar2.fR(j6);
                    cfVar3.bfK();
                    a(cfVar3);
                    AppMethodBeat.o(250648);
                }
            }
            cfVar2 = cfVar3;
            j6 = 1;
            cfVar2.fR(j6);
            cfVar3.bfK();
            a(cfVar3);
            AppMethodBeat.o(250648);
        } else if (finderItem != null) {
            cf cfVar4 = new cf();
            if (bbn == null || (str2 = bbn.sessionId) == null) {
                str2 = "";
            }
            cfVar4.lr(str2);
            cfVar4.fJ((long) i2);
            cfVar4.fK(j3);
            cfVar4.ls(String.valueOf(finderItem.getId()));
            cfVar4.lt(finderItem.getUserName());
            cfVar4.lu(str);
            cfVar4.fL(0);
            cfVar4.fM(0);
            cfVar4.fN(0);
            cfVar4.lv("");
            cfVar4.fO((long) finderItem.getMediaType());
            w wVar2 = w.vXp;
            cfVar4.lw(n.j(w.z(finderItem), ",", ";", false));
            cfVar4.lx("");
            cfVar4.fP(bbn != null ? (long) bbn.tCE : 0);
            if (bbn == null || (str3 = bbn.sGE) == null) {
                str3 = "";
            }
            cfVar4.ly(str3);
            if (bbn == null || (str4 = bbn.sGQ) == null) {
                str4 = "";
            }
            cfVar4.lz(str4);
            cfVar4.lA(G(j2, bbn != null ? bbn.tCE : 0));
            cfVar4.fQ(j4);
            if (bbn == null || (str11 = bbn.extraInfo) == null || (str5 = n.j(str11, ",", ";", false)) == null) {
                str5 = "";
            }
            cfVar4.lB(str5);
            if (bbn == null || (str10 = bbn.sGH) == null || (str6 = n.j(str10, ",", ";", false)) == null) {
                str6 = "";
            }
            cfVar4.lC(str6);
            if (bbn == null || (str9 = bbn.sGH) == null || (str7 = n.j(str9, ",", ";", false)) == null) {
                str7 = "";
            }
            cfVar4.lC(str7);
            FinderObjectDesc finderObjectDesc4 = finderItem.getFinderObject().objectDesc;
            cfVar4.lE((finderObjectDesc4 == null || (azr3 = finderObjectDesc4.feedBgmInfo) == null) ? null : azr3.groupId);
            FinderObjectDesc finderObjectDesc5 = finderItem.getFeedObject().objectDesc;
            if (((finderObjectDesc5 == null || (azr2 = finderObjectDesc5.feedBgmInfo) == null) ? null : azr2.musicInfo) != null) {
                FinderObjectDesc finderObjectDesc6 = finderItem.getFeedObject().objectDesc;
                if (finderObjectDesc6 == null || (azr = finderObjectDesc6.feedBgmInfo) == null || (azk = azr.musicInfo) == null) {
                    str8 = null;
                } else {
                    str8 = azk.wWb;
                }
                String str20 = str8;
                if (str20 == null || str20.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    j5 = 2;
                    cfVar = cfVar4;
                    cfVar.fR(j5);
                    cfVar4.bfK();
                    a(cfVar4);
                    AppMethodBeat.o(250648);
                }
            }
            cfVar = cfVar4;
            j5 = 1;
            cfVar.fR(j5);
            cfVar4.bfK();
            a(cfVar4);
            AppMethodBeat.o(250648);
        } else {
            AppMethodBeat.o(250648);
        }
    }

    public static /* synthetic */ void a(bm bmVar, int i2, long j2, String str, bbn bbn) {
        AppMethodBeat.i(250650);
        a(bmVar, i2, j2, str, bbn, 0);
        AppMethodBeat.o(250650);
    }

    public static void a(bm bmVar, int i2, long j2, String str, bbn bbn, long j3) {
        String str2;
        String str3;
        String str4;
        String str5;
        long j4;
        String str6;
        String str7;
        String str8;
        String str9;
        long j5 = 0;
        AppMethodBeat.i(250649);
        p.h(bmVar, "item");
        p.h(str, "receiver");
        cf cfVar = new cf();
        if (bbn == null || (str2 = bbn.sessionId) == null) {
            str2 = "";
        }
        cfVar.lr(str2);
        cfVar.fJ((long) i2);
        cfVar.fK(j2);
        cfVar.ls(Fg(bmVar.dkW()));
        FinderContact finderContact = bmVar.contact;
        if (finderContact == null || (str3 = finderContact.username) == null) {
            str3 = "";
        }
        cfVar.lt(str3);
        cfVar.lu(str);
        cfVar.fL((long) bmVar.getFeedObject().likeCount);
        cfVar.lv("");
        w wVar = w.vXp;
        cng cng = bmVar.tuP;
        if (cng == null) {
            cng = new cng();
        }
        cfVar.lw(n.j(w.a(cng), ",", ";", false));
        cfVar.lx("");
        cfVar.fP(bbn != null ? (long) bbn.tCE : 0);
        if (bbn == null || (str4 = bbn.sGE) == null) {
            str4 = "";
        }
        cfVar.ly(str4);
        if (bbn == null || (str5 = bbn.sGQ) == null) {
            str5 = "";
        }
        cfVar.lz(str5);
        cng cng2 = bmVar.tuP;
        if (cng2 != null) {
            j4 = cng2.id;
        } else {
            j4 = 0;
        }
        cfVar.lA(H(j4, bbn != null ? bbn.tCE : 0));
        cfVar.fQ(j3);
        if (bbn == null || (str9 = bbn.extraInfo) == null || (str6 = n.j(str9, ",", ";", false)) == null) {
            str6 = "";
        }
        cfVar.lB(str6);
        if (bbn == null || (str8 = bbn.sGH) == null || (str7 = n.j(str8, ",", ";", false)) == null) {
            str7 = "";
        }
        cfVar.lC(str7);
        cng cng3 = bmVar.tuP;
        if (cng3 != null) {
            j5 = cng3.id;
        }
        cfVar.lD(Fg(j5));
        cfVar.bfK();
        a(cfVar);
        AppMethodBeat.o(250649);
    }

    public static void a(long j2, int i2, long j3, String str, long j4, bbn bbn) {
        String str2;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        AppMethodBeat.i(250651);
        p.h(str, "receiver");
        cf cfVar = new cf();
        cfVar.fP(bbn != null ? (long) bbn.tCE : 0);
        cfVar.fJ((long) i2);
        cfVar.fK(j3);
        cfVar.fQ(j4);
        cfVar.lu(str);
        if (bbn == null || (str2 = bbn.sessionId) == null) {
            str2 = "";
        }
        cfVar.lr(str2);
        if (bbn != null) {
            i3 = bbn.tCE;
        } else {
            i3 = 0;
        }
        cfVar.lA(G(j2, i3));
        if (bbn == null || (str3 = bbn.sGE) == null) {
            str3 = "";
        }
        cfVar.ly(str3);
        if (bbn == null || (str4 = bbn.sGQ) == null) {
            str4 = "";
        }
        cfVar.lz(str4);
        if (bbn == null || (str8 = bbn.extraInfo) == null || (str5 = n.j(str8, ",", ";", false)) == null) {
            str5 = "";
        }
        cfVar.lB(str5);
        if (bbn == null || (str7 = bbn.sGH) == null || (str6 = n.j(str7, ",", ";", false)) == null) {
            str6 = "";
        }
        cfVar.lC(str6);
        cfVar.lF(d.zs(j2));
        cfVar.bfK();
        a(cfVar);
        AppMethodBeat.o(250651);
    }

    public static void j(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(166584);
        p.h(str, "author");
        p.h(str2, "receiver");
        String str3 = ((c) g.af(c.class)).cMD() + ',' + str + ',' + str2 + ',' + 0 + ',' + i2 + ',' + i3;
        Log.i(TAG, "18949 ".concat(String.valueOf(str3)));
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(18949, str3);
        AppMethodBeat.o(166584);
    }

    public static void h(FinderObject finderObject) {
        AppMethodBeat.i(166585);
        p.h(finderObject, com.tencent.mm.g.c.ch.COL_FINDEROBJECT);
        String str = ((c) g.af(c.class)).cMD() + ',' + 1 + ',' + Fg(finderObject.id) + ',' + finderObject.username + ',' + finderObject.recommendType;
        Log.i(TAG, "18953 ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(18953, str);
        AppMethodBeat.o(166585);
    }

    public static void f(FinderItem finderItem) {
        AppMethodBeat.i(166586);
        p.h(finderItem, "finderItem");
        FinderObject finderObject = finderItem.getFinderObject();
        String str = ((c) g.af(c.class)).cMD() + ',' + Fg(finderObject.id) + ',' + finderObject.username + ',' + finderItem.getMediaType() + ',' + finderObject.recommendType + ',' + finderObject.likeCount + ',' + finderObject.commentCount + ',' + finderObject.friendLikeCount;
        Log.i(TAG, "18950 ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(18950, str);
        AppMethodBeat.o(166586);
    }

    public static void a(int i2, int i3, int i4, boolean z, int i5, int i6, int i7, boolean z2, boolean z3, bbn bbn) {
        int i8;
        String str;
        String str2;
        int i9 = 0;
        AppMethodBeat.i(261318);
        StringBuilder append = new StringBuilder().append(((c) g.af(c.class)).cMD()).append(',').append(i2).append(',').append(i3).append(',').append(i4).append(',');
        if (z) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        StringBuilder append2 = append.append(i8).append(',').append(i5).append(',').append(i6).append(',').append(i7).append(',').append(z2 ? 1 : 0).append(',');
        if (!z3) {
            i9 = 1;
        }
        StringBuilder append3 = append2.append(i9).append(',');
        if (bbn == null || (str = bbn.sGQ) == null) {
            str = "";
        }
        StringBuilder append4 = append3.append(str).append(',');
        if (bbn == null || (str2 = bbn.sGE) == null) {
            str2 = "";
        }
        String sb = append4.append(str2).toString();
        Log.i(TAG, "18947 ".concat(String.valueOf(sb)));
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(18947, sb);
        AppMethodBeat.o(261318);
    }

    public static void auK(String str) {
        AppMethodBeat.i(166588);
        p.h(str, com.tencent.mm.g.c.ch.COL_USERNAME);
        String str2 = ((c) g.af(c.class)).cMD() + ',' + str;
        Log.i(TAG, "18973 ".concat(String.valueOf(str2)));
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(18973, str2);
        AppMethodBeat.o(166588);
    }

    public static /* synthetic */ void e(bbn bbn) {
        AppMethodBeat.i(250654);
        a(2, 1, 0, bbn);
        AppMethodBeat.o(250654);
    }

    public static void a(int i2, int i3, int i4, bbn bbn) {
        AppMethodBeat.i(250653);
        p.h(bbn, "contextObj");
        ci ciVar = new ci();
        ciVar.fT((long) bbn.tCE);
        ciVar.lL(bbn.sessionId);
        ciVar.lM(bbn.sGQ);
        ciVar.lN(bbn.sGE);
        ciVar.lL(bbn.sessionId);
        ciVar.fV(cl.aWA());
        ciVar.fU((long) i2);
        ciVar.fW((long) i3);
        ciVar.fX((long) i4);
        ciVar.adf();
        ciVar.bfK();
        a(ciVar);
        AppMethodBeat.o(250653);
    }

    public static void a(String str, int i2, bbn bbn) {
        AppMethodBeat.i(250655);
        p.h(str, "exposeFeedId");
        p.h(bbn, "contextObj");
        com.tencent.mm.plugin.report.e.INSTANCE.a(20585, str, Long.valueOf(cl.aWA()), Integer.valueOf(i2), Integer.valueOf(bbn.tCE), bbn.sGE, bbn.sessionId);
        AppMethodBeat.o(250655);
    }

    public static void a(int i2, String str, int i3, String str2, int i4, bbn bbn) {
        AppMethodBeat.i(250656);
        p.h(str, "actionFeedId");
        p.h(str2, "totalFeedId");
        p.h(bbn, "contextObj");
        com.tencent.mm.plugin.report.e.INSTANCE.a(20586, Integer.valueOf(i2), str, Integer.valueOf(i3), Long.valueOf(cl.aWA()), str2, Integer.valueOf(i4), Integer.valueOf(bbn.tCE), bbn.sGE, bbn.sessionId);
        AppMethodBeat.o(250656);
    }

    public static void a(bbn bbn, String str, String str2, int i2, int i3) {
        AppMethodBeat.i(250657);
        p.h(bbn, "contextObj");
        p.h(str, "poiText");
        p.h(str2, "filterTextItems");
        ej ejVar = new ej();
        ejVar.qW(bbn.sessionId);
        ejVar.qX(bbn.sGQ);
        ejVar.qY(bbn.sGE);
        ejVar.lT((long) bbn.tyh);
        ejVar.qZ(str);
        ejVar.ra(str2);
        ejVar.lU((long) i2);
        ejVar.lV((long) i3);
        switch (bbn.tCE) {
            case 22:
                ejVar.lW(1);
                break;
            case 26:
                ejVar.lW(2);
                break;
        }
        ejVar.lX((long) bbn.tCE);
        ejVar.bfK();
        a(ejVar);
        AppMethodBeat.o(250657);
    }

    public static /* synthetic */ void a(k kVar, String str, int i2, String str2, String str3, long j2, String str4, int i3, String str5) {
        AppMethodBeat.i(250659);
        kVar.a(str, i2, 1, str2, str3, j2, str4, i3, str5, 0);
        AppMethodBeat.o(250659);
    }

    public final void a(String str, int i2, int i3, String str2, String str3, long j2, String str4, int i4, String str5, int i5) {
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(250658);
        p.h(str, "currUI");
        p.h(str2, "redDotId");
        p.h(str3, "redDotWording");
        p.h(str4, "contextId");
        p.h(str5, "report_ext_info");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() != 1) {
            switch (i2) {
                case -1:
                case 1002:
                    i6 = 2;
                    i7 = 1;
                    i8 = 6;
                    break;
                case 1:
                    i6 = 1;
                    i7 = 1;
                    i8 = 3;
                    break;
                case 2:
                    i6 = 1;
                    i7 = 2;
                    i8 = 3;
                    break;
                case 3:
                    i6 = 3;
                    i7 = 1;
                    i8 = 4;
                    break;
                case 4:
                    i6 = 3;
                    i7 = 2;
                    i8 = 4;
                    break;
                case 5:
                    i6 = 1;
                    i7 = 2;
                    i8 = 1;
                    break;
                case 7:
                    i6 = 8;
                    i7 = 0;
                    i8 = 3;
                    break;
                case 8:
                    i6 = 7;
                    i7 = 0;
                    i8 = 4;
                    break;
                default:
                    AppMethodBeat.o(250658);
                    return;
            }
        } else {
            switch (i2) {
                case -1:
                case 1002:
                    i6 = 2;
                    i7 = 1;
                    i8 = i4;
                    break;
                case 1:
                    i6 = 5;
                    i7 = 0;
                    i8 = 3;
                    break;
                case 2:
                    i6 = 1;
                    i7 = 0;
                    i8 = 3;
                    break;
                case 5:
                    i6 = 1;
                    i7 = 0;
                    i8 = 1;
                    break;
                case 7:
                    i6 = 8;
                    i7 = 0;
                    i8 = i4;
                    break;
                case 8:
                    i6 = 7;
                    i7 = 0;
                    i8 = i4;
                    break;
                case 1001:
                    i6 = 6;
                    i7 = 0;
                    i8 = 1;
                    break;
                case 1003:
                    i6 = 3;
                    i7 = 1;
                    i8 = 3;
                    break;
                case 1004:
                    i6 = 3;
                    i7 = 2;
                    i8 = 3;
                    break;
                case 1005:
                    i6 = 9;
                    i7 = 0;
                    i8 = 100;
                    break;
                default:
                    AppMethodBeat.o(250658);
                    return;
            }
        }
        bbn bbn = new bbn();
        bbn.sGQ = str4;
        bbn.sGE = "";
        a(str, i6, i3, i8, i7, 0, str2, str3, j2, bbn, i5, str5);
        AppMethodBeat.o(250658);
    }

    public static /* synthetic */ void a(String str, int i2, int i3, int i4, int i5, int i6, String str2, String str3, long j2, bbn bbn, int i7, int i8, int i9) {
        int i10;
        int i11;
        String str4;
        String str5;
        bbn bbn2;
        int i12;
        int i13;
        AppMethodBeat.i(250660);
        if ((i9 & 16) != 0) {
            i10 = 0;
        } else {
            i10 = i5;
        }
        if ((i9 & 32) != 0) {
            i11 = 0;
        } else {
            i11 = i6;
        }
        if ((i9 & 64) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i9 & 128) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        long j3 = (i9 & 256) != 0 ? 0 : j2;
        if ((i9 & 512) != 0) {
            bbn2 = null;
        } else {
            bbn2 = bbn;
        }
        if ((i9 & 1024) != 0) {
            i12 = 0;
        } else {
            i12 = i7;
        }
        if ((i9 & 2048) != 0) {
            i13 = 0;
        } else {
            i13 = i8;
        }
        p.h(str, "currUI");
        p.h(str5, "redDotWording");
        a(str, i2, i3, i4, i10, i11, str4, str5, j3, bbn2, i12, i13, "");
        AppMethodBeat.o(250660);
    }

    private static /* synthetic */ void a(String str, int i2, int i3, int i4, int i5, int i6, String str2, String str3, long j2, bbn bbn, int i7, String str4) {
        AppMethodBeat.i(250662);
        a(str, i2, i3, i4, i5, 0, str2, str3, j2, bbn, 0, i7, str4);
        AppMethodBeat.o(250662);
    }

    private static void a(String str, int i2, int i3, int i4, int i5, int i6, String str2, String str3, long j2, bbn bbn, int i7, int i8, String str4) {
        String str5;
        String str6;
        AppMethodBeat.i(250661);
        p.h(str, "currUI");
        p.h(str3, "redDotWording");
        p.h(str4, "report_ext_info");
        du duVar = new du();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        duVar.pS(cMD);
        duVar.pT(str);
        duVar.kL((long) i2);
        duVar.kM((long) i3);
        duVar.kO((long) i4);
        duVar.kP(BuildInfo.DEBUG ? 0 : 2);
        duVar.kN((long) i5);
        if (str2 == null) {
            str2 = "";
        }
        duVar.pU(str2);
        duVar.kQ((long) i6);
        duVar.pV(str3);
        duVar.pW(Fg(j2));
        if (bbn == null || (str5 = bbn.sGQ) == null) {
            str5 = "";
        }
        duVar.pX(str5);
        if (bbn == null || (str6 = bbn.sGE) == null) {
            str6 = "";
        }
        duVar.pY(str6);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        duVar.kR(com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1 ? 2 : 1);
        a ah = g.ah(aj.class);
        p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
        z redDotManager = ((aj) ah).getRedDotManager();
        p.g(redDotManager, "MMKernel.plugin(IPluginF…class.java).redDotManager");
        duVar.kS(redDotManager.daH() ? 1 : 2);
        duVar.kT((long) i7);
        duVar.kU((long) i8);
        if (!Util.isNullOrNil(str4)) {
            duVar.pZ(str4);
        }
        duVar.bfK();
        a(duVar);
        AppMethodBeat.o(250661);
    }

    public static String Fg(long j2) {
        AppMethodBeat.i(166591);
        BigInteger valueOf = BigInteger.valueOf(j2);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(TWO_64);
        }
        String bigInteger = valueOf.toString();
        p.g(bigInteger, "b.toString()");
        AppMethodBeat.o(166591);
        return bigInteger;
    }

    public static /* synthetic */ void a(bbn bbn, long j2, int i2, int i3, int i4, String str, int i5) {
        AppMethodBeat.i(250664);
        a(bbn, j2, i2, i3, i4, str, i5, false, false, 0, 0L);
        AppMethodBeat.o(250664);
    }

    public static void a(bbn bbn, long j2, int i2, int i3, int i4, String str, int i5, boolean z, boolean z2, int i6, long j3) {
        boolean z3;
        String G;
        String str2;
        String str3;
        AppMethodBeat.i(250663);
        p.h(bbn, "contextObj");
        p.h(str, "replyUsername");
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            com.tencent.mm.g.b.a.bm bmVar = new com.tencent.mm.g.b.a.bm();
            bmVar.jt(bbn.sessionId);
            bmVar.ju("");
            bmVar.jv(Fg(j2));
            bmVar.jw(Fc.getUserName());
            bmVar.dU((long) i2);
            bmVar.dV((long) i3);
            bmVar.dW((long) i4);
            bmVar.jx(str);
            bmVar.dX((long) i5);
            bmVar.dY((long) Fc.getLikeCount());
            bmVar.dZ((long) Fc.getCommentCount());
            bmVar.ea((long) Fc.getFriendLikeCount());
            bmVar.eb((long) Fc.getMediaType());
            w wVar = w.vXp;
            bmVar.jy(n.j(w.z(Fc), ",", ";", false));
            bmVar.jz("");
            bmVar.ec((long) bbn.tCE);
            bmVar.ed(p.j(Fc.getUserName(), com.tencent.mm.model.z.aUg()) ? 1 : 0);
            bmVar.ee(z ? 1 : 0);
            String str4 = bbn.sGQ;
            if (str4 == null) {
                str4 = "";
            }
            bmVar.jA(str4);
            String str5 = bbn.sGE;
            if (str5 == null) {
                str5 = "";
            }
            bmVar.jB(str5);
            int i7 = bbn.tCE;
            if (i7 == 45 || i7 == 46 || i7 == 47 || i7 == 48 || i7 == 53 || i7 == 54) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                G = H(j3, bbn.tCE);
            } else {
                G = G(j2, bbn.tCE);
            }
            bmVar.jC(G);
            bmVar.ef(z2 ? 1 : 0);
            String str6 = bbn.extraInfo;
            if (str6 == null || (str2 = n.j(str6, ",", ";", false)) == null) {
                str2 = "";
            }
            bmVar.jD(str2);
            String str7 = bbn.sGH;
            if (str7 == null || (str3 = n.j(str7, ",", ";", false)) == null) {
                str3 = "";
            }
            bmVar.jE(str3);
            bmVar.eg((long) i6);
            bmVar.bfK();
            a(bmVar);
            AppMethodBeat.o(250663);
            return;
        }
        AppMethodBeat.o(250663);
    }

    public static void a(bbn bbn, long j2, String str, int i2) {
        String str2;
        String str3;
        AppMethodBeat.i(250665);
        p.h(bbn, "contextObj");
        p.h(str, "finderUsername");
        com.tencent.mm.g.b.a.bm bmVar = new com.tencent.mm.g.b.a.bm();
        bmVar.jt(bbn.sessionId);
        bmVar.ju("");
        bmVar.ec((long) bbn.tCE);
        bmVar.jw(str);
        bmVar.dU(3);
        bmVar.dV((long) i2);
        bmVar.jx("");
        bmVar.dX(2);
        bmVar.jA(bbn.sGQ);
        bmVar.jB(bbn.sGE);
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            bmVar.jv(Fg(j2));
            bmVar.dY((long) Fc.getFeedObject().likeCount);
            bmVar.dZ((long) Fc.getFeedObject().commentCount);
            bmVar.ea((long) Fc.getFeedObject().friendLikeCount);
            bmVar.eb((long) Fc.getMediaType());
            w wVar = w.vXp;
            bmVar.jy(n.j(w.z(Fc), ",", ";", false));
            bmVar.jz("");
            bmVar.jC(G(j2, bbn.tyh));
        } else {
            bmVar.jv(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            bmVar.jy("");
            bmVar.jz("");
        }
        String str4 = bbn.extraInfo;
        if (str4 == null || (str2 = n.j(str4, ",", ";", false)) == null) {
            str2 = "";
        }
        bmVar.jD(str2);
        String str5 = bbn.sGH;
        if (str5 == null || (str3 = n.j(str5, ",", ";", false)) == null) {
            str3 = "";
        }
        bmVar.jE(str3);
        bmVar.bfK();
        a(bmVar);
        AppMethodBeat.o(250665);
    }

    public static void a(int i2, String str, String str2, long j2, int i3) {
        AppMethodBeat.i(250666);
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            bn bnVar = new bn();
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            bnVar.jF(cMD);
            bnVar.jG("");
            bnVar.jH(Fg(j2));
            bnVar.jI(Fc.getUserName());
            bnVar.eh((long) Fc.getLikeCount());
            bnVar.ei((long) Fc.getCommentCount());
            bnVar.ej((long) Fc.getFriendLikeCount());
            bnVar.jW(i3);
            bnVar.ek((long) i2);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            bnVar.el(com.tencent.mm.plugin.finder.storage.c.dsr().value().intValue() == 1 ? 1 : 0);
            bnVar.jJ(str);
            bnVar.jK(str2);
            bnVar.bfK();
            a(bnVar);
            AppMethodBeat.o(250666);
            return;
        }
        AppMethodBeat.o(250666);
    }

    public static void a(String str, String str2, String str3, int i2, long j2, long j3, long j4, int i3) {
        AppMethodBeat.i(250667);
        com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.INSTANCE;
        Object[] objArr = new Object[8];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        if (str2 == null) {
            str2 = "";
        }
        objArr[1] = str2;
        if (str3 == null) {
            str3 = "";
        }
        objArr[2] = str3;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = d.zs(j2);
        objArr[5] = Long.valueOf(j3);
        objArr[6] = Long.valueOf(j4);
        objArr[7] = Integer.valueOf(i3 == 4 ? 1 : 0);
        eVar.a(21834, objArr);
        AppMethodBeat.o(250667);
    }

    public static void Kv(int i2) {
        AppMethodBeat.i(166594);
        switch (i2) {
            case -21020:
                x.a aVar = x.vig;
                x.a.pl(x.vhW);
                AppMethodBeat.o(166594);
                return;
            case -21009:
                x.a aVar2 = x.vig;
                x.a.pl(x.vhV);
                AppMethodBeat.o(166594);
                return;
            case -10012:
                x.a aVar3 = x.vig;
                x.a.pl(x.vhT);
                AppMethodBeat.o(166594);
                return;
            case HttpClientWrapper.RET_CODE_FILE_NOT_FOUND /*{ENCODED_INT: -10004}*/:
                x.a aVar4 = x.vig;
                x.a.pl(x.vhU);
                AppMethodBeat.o(166594);
                return;
            case -1010:
                x.a aVar5 = x.vig;
                x.a.pl(x.vhQ);
                AppMethodBeat.o(166594);
                return;
            case -1007:
                x.a aVar6 = x.vig;
                x.a.pl(x.vhR);
                AppMethodBeat.o(166594);
                return;
            case -1004:
                x.a aVar7 = x.vig;
                x.a.pl(x.vhS);
                AppMethodBeat.o(166594);
                return;
            case 403:
                x.a aVar8 = x.vig;
                x.a.pl(x.vhY);
                AppMethodBeat.o(166594);
                return;
            case 404:
                x.a aVar9 = x.vig;
                x.a.pl(x.vhX);
                AppMethodBeat.o(166594);
                return;
            case 405:
                x.a aVar10 = x.vig;
                x.a.pl(x.vie);
                AppMethodBeat.o(166594);
                return;
            case 416:
                x.a aVar11 = x.vig;
                x.a.pl(x.vic);
                AppMethodBeat.o(166594);
                return;
            case 502:
                x.a aVar12 = x.vig;
                x.a.pl(x.vib);
                AppMethodBeat.o(166594);
                return;
            case 503:
                x.a aVar13 = x.vig;
                x.a.pl(x.vhZ);
                AppMethodBeat.o(166594);
                return;
            default:
                x.a aVar14 = x.vig;
                x.a.pl(x.vif);
                AppMethodBeat.o(166594);
                return;
        }
    }

    public static void a(int i2, long j2, int i3, int i4, String str) {
        long j3 = 1;
        AppMethodBeat.i(250668);
        com.tencent.mm.g.b.a.bv bvVar = new com.tencent.mm.g.b.a.bv();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        bvVar.kk(cMD);
        bvVar.kn(Fg(j2));
        bvVar.eN((long) i2);
        bvVar.eM((long) i3);
        switch (i3) {
            case 7:
            case 8:
                bvVar.eJ(1);
                break;
            default:
                bvVar.eJ(2);
                break;
        }
        bvVar.eI((long) i4);
        if (str == null) {
            str = "";
        }
        bvVar.kl(str);
        bvVar.km(com.tencent.mm.model.z.aUg());
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            bvVar.eK((long) Fc.getLikeCount());
            bvVar.eL((long) Fc.getCommentCount());
        }
        if (BuildInfo.DEBUG) {
            j3 = 0;
        }
        bvVar.eO(j3);
        bvVar.bfK();
        a(bvVar);
        AppMethodBeat.o(250668);
    }

    public static void dA(String str, int i2) {
        AppMethodBeat.i(178395);
        p.h(str, com.tencent.mm.g.c.ch.COL_USERNAME);
        da daVar = new da();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        daVar.oh(cMD);
        daVar.og(str);
        daVar.iG((long) i2);
        daVar.bfK();
        a(daVar);
        AppMethodBeat.o(178395);
    }

    public static void gS(String str, String str2) {
        AppMethodBeat.i(178396);
        p.h(str, "contextId");
        p.h(str2, NativeProtocol.WEB_DIALOG_ACTION);
        ek ekVar = new ek();
        ekVar.rc(str);
        ekVar.rb(str2);
        ekVar.lY(cl.aWA());
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        ekVar.rd(cMD);
        ekVar.lZ(BuildInfo.DEBUG ? 0 : 1);
        ekVar.bfK();
        a(ekVar);
        AppMethodBeat.o(178396);
    }

    public static void g(FinderItem finderItem) {
        AppMethodBeat.i(250669);
        p.h(finderItem, "finderItem");
        FinderFeedReportObject finderFeedReportObject = finderItem.field_reportObject;
        if (finderFeedReportObject != null) {
            dh dhVar = new dh();
            dhVar.oC(Fg(finderItem.getId()));
            dhVar.oD(finderFeedReportObject.sessionId);
            dhVar.oE(finderItem.getFeedObject().username);
            com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
            dhVar.oF(n.j(com.tencent.mm.plugin.finder.utils.d.w(finderItem), ",", ";", false));
            dhVar.bfK();
            a(dhVar);
            AppMethodBeat.o(250669);
            return;
        }
        AppMethodBeat.o(250669);
    }

    public static void a(bbn bbn, FinderItem finderItem, String str) {
        AppMethodBeat.i(250670);
        p.h(bbn, "contextObj");
        p.h(finderItem, "finderItem");
        p.h(str, "clickUsername");
        bk bkVar = new bk();
        bkVar.jo(Fg(finderItem.getId()));
        bkVar.jp(((c) g.af(c.class)).cMD());
        bkVar.jq(finderItem.getFeedObject().username);
        bkVar.jr(com.tencent.mm.model.z.aUg());
        bkVar.js(str);
        bkVar.dL((long) bbn.tCE);
        bkVar.dM((long) finderItem.getFeedObject().orgRecommendType);
        bkVar.dN((long) finderItem.getFeedObject().likeCount);
        bkVar.dO((long) finderItem.getFeedObject().commentCount);
        bkVar.bfK();
        a(bkVar);
        AppMethodBeat.o(250670);
    }

    public static String doc() {
        AppMethodBeat.i(250671);
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "UUID.randomUUID().toString()");
        AppMethodBeat.o(250671);
        return uuid;
    }

    public static void ai(int i2, long j2) {
        AppMethodBeat.i(250672);
        ef efVar = new ef();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        efVar.qL(cMD);
        efVar.lI((long) i2);
        efVar.lJ(j2);
        efVar.bfK();
        a(efVar);
        AppMethodBeat.o(250672);
    }

    public static void d(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(250673);
        db dbVar = new db();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        dbVar.oi(cMD);
        dbVar.iH((long) i2);
        dbVar.iK(0);
        dbVar.iI((long) i3);
        dbVar.iJ((long) i4);
        dbVar.oj(u.Pb(u.Pc(j2)));
        dbVar.bfK();
        a(dbVar);
        AppMethodBeat.o(250673);
    }

    public static void a(int i2, int i3, int i4, int i5, long j2) {
        AppMethodBeat.i(250674);
        db dbVar = new db();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        dbVar.oi(cMD);
        dbVar.iH((long) i2);
        dbVar.iK((long) i3);
        dbVar.iI((long) i4);
        dbVar.iJ((long) i5);
        dbVar.oj(u.Pb(u.Pc(j2)));
        dbVar.bfK();
        a(dbVar);
        AppMethodBeat.o(250674);
    }

    public static void ge(int i2, int i3) {
        AppMethodBeat.i(250675);
        dx dxVar = new dx();
        dxVar.lb((long) i2);
        dxVar.lc((long) i3);
        dxVar.bfK();
        a(dxVar);
        AppMethodBeat.o(250675);
    }

    public static /* synthetic */ void a(int i2, int i3, bbn bbn) {
        AppMethodBeat.i(250677);
        a(i2, i3, bbn, 0);
        AppMethodBeat.o(250677);
    }

    public static void a(int i2, int i3, bbn bbn, int i4) {
        long j2 = 0;
        AppMethodBeat.i(250676);
        p.h(bbn, "contextObj");
        bz bzVar = new bz();
        bzVar.fi(i2 > 0 ? (long) i2 : 0);
        if (i3 > 0) {
            j2 = (long) i3;
        }
        bzVar.fj(j2);
        bzVar.fk(cl.aWA());
        bzVar.kF(bbn.sessionId);
        bzVar.kH(bbn.sGQ);
        bzVar.kG(bbn.sGE);
        bzVar.fl((long) i4);
        switch (i3) {
            case 1:
                a ah = g.ah(PluginFinder.class);
                p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                if (((PluginFinder) ah).getRedDotManager().asW("TLRecommendTab") != null) {
                    bzVar.acX();
                    break;
                }
                break;
            case 2:
                a ah2 = g.ah(PluginFinder.class);
                p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                if (((PluginFinder) ah2).getRedDotManager().asW("finder_tl_nearby_tab") != null) {
                    bzVar.acX();
                    break;
                }
                break;
            case 3:
                a ah3 = g.ah(PluginFinder.class);
                p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
                if (((PluginFinder) ah3).getRedDotManager().asW("TLFollow") != null) {
                    bzVar.acX();
                    break;
                }
                break;
            case 4:
                a ah4 = g.ah(PluginFinder.class);
                p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
                if (((PluginFinder) ah4).getRedDotManager().asW("finder_tl_hot_tab") != null) {
                    bzVar.acX();
                    break;
                }
                break;
        }
        bzVar.bfK();
        a(bzVar);
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_ALL_CLICK_TAB_CONTEXT_ID_STRING, bzVar.acW());
        if (i3 != 2) {
            com.tencent.mm.kernel.e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_TAB_CLICK_TAB_CONTEXT_ID_STRING, bzVar.acW());
        }
        Log.i(TAG, "finderReportTabChange clickTabContextId [%s] toTab[%d]", bzVar.acW(), Integer.valueOf(i3));
        AppMethodBeat.o(250676);
    }

    public static /* synthetic */ void a(bbn bbn, long j2, RecyclerView recyclerView) {
        AppMethodBeat.i(261320);
        a(bbn, j2, recyclerView, 0);
        AppMethodBeat.o(261320);
    }

    public static void a(bbn bbn, long j2, RecyclerView recyclerView, int i2) {
        String str;
        String str2;
        cc ccVar;
        long j3;
        azr azr;
        azk azk;
        azr azr2;
        azr azr3;
        azs azs;
        long j4;
        AppMethodBeat.i(261319);
        p.h(bbn, "contextObj");
        p.h(recyclerView, "recyclerView");
        FinderItem Fc = Fc(j2);
        if (Fc != null) {
            cc ccVar2 = new cc();
            ccVar2.fp((long) bbn.tCE);
            ccVar2.kQ(bbn.sessionId);
            ccVar2.kR(bbn.sGQ);
            ccVar2.kS(bbn.sGE);
            ccVar2.kT(d.zs(j2));
            ccVar2.fr(cl.aWA());
            String str3 = bbn.wza;
            if (str3 == null || (str = n.j(str3, ",", ";", false)) == null) {
                str = "";
            }
            ccVar2.kV(str);
            ccVar2.fs((long) Fc.getMediaType());
            y yVar = y.vXH;
            String jSONObject = y.dCI().toString();
            p.g(jSONObject, "FinderUtil.getScreenInfo().toString()");
            ccVar2.kX(n.j(jSONObject, ",", ";", false));
            y yVar2 = y.vXH;
            String jSONArray = y.r(recyclerView).toString();
            p.g(jSONArray, "FinderUtil.getCurrentScr…(recyclerView).toString()");
            ccVar2.kU(n.j(jSONArray, ",", ";", false));
            ccVar2.fq(Kt(bbn.tCE));
            ccVar2.kW(G(j2, bbn.tCE));
            if (bbn.tCE == 15) {
                switch (Fc.getFeedObject().recommendReasonType) {
                    case 1:
                        j4 = 1;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    default:
                        j4 = 0;
                        break;
                    case 9:
                        j4 = 6;
                        break;
                    case 10:
                        j4 = 2;
                        break;
                    case 11:
                        j4 = 3;
                        break;
                    case 12:
                        j4 = 5;
                        break;
                    case 13:
                        j4 = 4;
                        break;
                }
                ccVar2.ft(j4);
                String str4 = Fc.getFeedObject().recommendReason;
                if (str4 == null) {
                    str4 = "";
                }
                ccVar2.kY(str4);
            }
            FinderObjectDesc finderObjectDesc = Fc.getFeedObject().objectDesc;
            if (!(finderObjectDesc == null || (azs = finderObjectDesc.event) == null)) {
                ccVar2.la(d.zs(azs.twd));
                ccVar2.PJ((long) i2);
            }
            FinderObjectDesc finderObjectDesc2 = Fc.getFeedObject().objectDesc;
            if (finderObjectDesc2 == null || (azr3 = finderObjectDesc2.feedBgmInfo) == null || (str2 = azr3.groupId) == null) {
                str2 = "";
            }
            ccVar2.kZ(str2);
            FinderObjectDesc finderObjectDesc3 = Fc.getFeedObject().objectDesc;
            if (((finderObjectDesc3 == null || (azr2 = finderObjectDesc3.feedBgmInfo) == null) ? null : azr2.musicInfo) != null) {
                FinderObjectDesc finderObjectDesc4 = Fc.getFeedObject().objectDesc;
                String str5 = (finderObjectDesc4 == null || (azr = finderObjectDesc4.feedBgmInfo) == null || (azk = azr.musicInfo) == null) ? null : azk.wWb;
                if (!(str5 == null || str5.length() == 0)) {
                    j3 = 2;
                    ccVar = ccVar2;
                    ccVar.fu(j3);
                    ccVar2.bfK();
                    a(ccVar2);
                    AppMethodBeat.o(261319);
                    return;
                }
            }
            ccVar = ccVar2;
            j3 = 1;
            ccVar.fu(j3);
            ccVar2.bfK();
            a(ccVar2);
            AppMethodBeat.o(261319);
            return;
        }
        AppMethodBeat.o(261319);
    }

    public static void a(bbn bbn, long j2, int i2, String str) {
        AppMethodBeat.i(250679);
        p.h(bbn, "contextObj");
        if (Fc(j2) != null) {
            dp dpVar = new dp();
            dpVar.kq((long) bbn.tCE);
            dpVar.pr(bbn.sGQ);
            dpVar.pt(bbn.sGE);
            dpVar.pq(bbn.sessionId);
            dpVar.pp(d.zs(j2));
            if (str == null) {
                str = "";
            }
            dpVar.po(str);
            dpVar.kp((long) i2);
            dpVar.bfK();
            a(dpVar);
        }
        AppMethodBeat.o(250679);
    }

    public static void ac(Context context, int i2) {
        AppMethodBeat.i(250680);
        p.h(context, "context");
        cz czVar = new cz();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            czVar.of(fH.sessionId);
        } else {
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            czVar.of(cMD);
        }
        czVar.iF((long) i2);
        czVar.bfK();
        a(czVar);
        AppMethodBeat.o(250680);
    }

    public static /* synthetic */ void a(bbn bbn, int i2) {
        AppMethodBeat.i(250682);
        a(bbn, i2, 0);
        AppMethodBeat.o(250682);
    }

    public static void a(bbn bbn, int i2, int i3) {
        AppMethodBeat.i(250681);
        p.h(bbn, "contextObj");
        be beVar = new be();
        beVar.dr((long) bbn.tCE);
        beVar.jc(bbn.sessionId);
        beVar.jd(bbn.sGQ);
        beVar.je(bbn.sGE);
        beVar.ds((long) i2);
        if (i3 != 0) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            beVar.dt(((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mr(i3) ? 1 : 0);
        }
        beVar.bfK();
        a(beVar);
        AppMethodBeat.o(250681);
    }

    public static void f(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(250683);
        p.h(str, "tipsId");
        p.h(str2, "revokeId");
        ds dsVar = new ds();
        dsVar.kw((long) i2);
        dsVar.kx((long) cl.aWB());
        dsVar.pG(str);
        dsVar.pH(str2);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        dsVar.ky(com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1 ? 2 : 1);
        dsVar.kz((long) i3);
        dsVar.bfK();
        a(dsVar);
        AppMethodBeat.o(250683);
    }

    public static void a(com.tencent.mm.plugin.report.a aVar) {
        AppMethodBeat.i(250684);
        p.h(aVar, "struct");
        String str = TAG;
        StringBuilder append = new StringBuilder("report").append(aVar.getId()).append(' ');
        String abW = aVar.abW();
        p.g(abW, "struct.toShowString()");
        Log.i(str, append.append(n.j(abW, APLogFileUtil.SEPARATOR_LINE, " ", false)).toString());
        AppMethodBeat.o(250684);
    }

    public static int Kw(int i2) {
        switch (i2) {
            case 0:
            default:
                return 3;
            case 1:
                return 18;
            case 2:
                return 15;
            case 3:
                return 17;
            case 4:
                return 20;
        }
    }

    public static int Kx(int i2) {
        switch (i2) {
            case 3:
            default:
                return 0;
            case 15:
                return 2;
            case 17:
                return 3;
            case 18:
                return 1;
            case 20:
                return 4;
        }
    }

    public static String fp(Context context) {
        String str;
        AppMethodBeat.i(250685);
        p.h(context, "context");
        int i2 = 0;
        if (context instanceof MMFragmentActivity) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            i2 = ((FinderHomeUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(FinderHomeUIC.class)).dIf();
        }
        switch (i2) {
            case 1:
                str = "7";
                break;
            case 2:
                str = "9";
                break;
            case 3:
                str = "6";
                break;
            case 4:
                str = "8";
                break;
            default:
                str = "2";
                break;
        }
        AppMethodBeat.o(250685);
        return str;
    }

    public static int dod() {
        AppMethodBeat.i(250686);
        int i2 = 0;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            i2 = 1;
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            i2 = 2;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            i2 = 3;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            i2 = 4;
        } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
            i2 = 5;
        }
        AppMethodBeat.o(250686);
        return i2;
    }

    public static /* synthetic */ void a(Context context, long j2, boolean z, long j3, long j4, boolean z2) {
        AppMethodBeat.i(250688);
        a(context, j2, z, j3, j4, z2, 0);
        AppMethodBeat.o(250688);
    }

    public static void a(Context context, long j2, boolean z, long j3, long j4, boolean z2, long j5) {
        AppMethodBeat.i(250687);
        p.h(context, "context");
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        bbn dIx = fH != null ? fH.dIx() : null;
        df dfVar = new df();
        dfVar.ov(dIx != null ? dIx.sessionId : null);
        dfVar.jb(j2);
        dfVar.jc(z ? 1 : 0);
        dfVar.jd(j3);
        dfVar.je(j4);
        dfVar.jf(System.currentTimeMillis());
        dfVar.jg(z2 ? 1 : 0);
        dfVar.jh(j5);
        dfVar.bfK();
        AppMethodBeat.o(250687);
    }

    public static /* synthetic */ void b(Context context, long j2, long j3) {
        AppMethodBeat.i(250690);
        a(context, j2, j3, false);
        AppMethodBeat.o(250690);
    }

    public static void a(Context context, long j2, long j3, boolean z) {
        AppMethodBeat.i(250689);
        p.h(context, "context");
        dy dyVar = new dy();
        dyVar.ld(j2);
        dyVar.le(j3);
        dyVar.lf(z ? 1 : 0);
        dyVar.bfK();
        AppMethodBeat.o(250689);
    }

    public static void c(String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(250691);
        p.h(str, "profileUsername");
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(20698, str + ',' + i2 + ',' + i3 + ',' + i4 + ',' + i5);
        AppMethodBeat.o(250691);
    }

    public static void ad(String str, int i2, int i3) {
        AppMethodBeat.i(250692);
        p.h(str, "fromUsername");
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(20699, str + ',' + i2 + ',' + i3);
        AppMethodBeat.o(250692);
    }

    public static void a(long j2, int i2, int i3, String str, String str2, String str3, String str4, int i4) {
        AppMethodBeat.i(250693);
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(20717, d.zs(j2) + ',' + i2 + ',' + i3 + ',' + Util.nullAsNil(str) + ',' + Util.nullAsNil(str2) + ',' + Util.nullAsNil(str3) + ',' + Util.nullAsNil(str4) + ',' + i4);
        AppMethodBeat.o(250693);
    }

    public static void a(Context context, int i2, int i3, Integer num) {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(250694);
        p.h(context, "context");
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        bbn dIx = fH != null ? fH.dIx() : null;
        bl blVar = new bl();
        blVar.dP(System.currentTimeMillis());
        blVar.dQ((long) i2);
        blVar.dR((long) i3);
        if (dIx != null) {
            j2 = (long) dIx.tCE;
        } else {
            j2 = 0;
        }
        blVar.dS(j2);
        if (num != null) {
            j3 = (long) num.intValue();
        }
        blVar.dT(j3);
        blVar.bfK();
        AppMethodBeat.o(250694);
    }

    public static void a(Context context, boolean z, int i2, boolean z2, boolean z3) {
        AppMethodBeat.i(250695);
        p.h(context, "context");
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        bbn dIx = fH != null ? fH.dIx() : null;
        em emVar = new em();
        emVar.me(dIx != null ? (long) dIx.tCE : 0);
        emVar.rl(dIx != null ? dIx.sessionId : null);
        emVar.rm(dIx != null ? dIx.sGQ : null);
        emVar.rn(dIx != null ? dIx.sGE : null);
        emVar.ro(d.zs(dIx != null ? dIx.wyW : 0));
        emVar.mf(z ? 1 : 2);
        emVar.mg((long) i2);
        emVar.mh(z2 ? 2 : 1);
        emVar.mi(z3 ? 2 : 1);
        emVar.bfK();
        AppMethodBeat.o(250695);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, String str6) {
        int i2 = 1;
        AppMethodBeat.i(250696);
        p.h(context, "context");
        p.h(str, "appuin");
        p.h(str2, "preWarmPath");
        p.h(str3, "liveid");
        p.h(str4, "finderid");
        p.h(str5, "shopwindowid");
        p.h(str6, "sessionid");
        cv cvVar = new cv();
        cvVar.nD(str);
        cvVar.aeo();
        cvVar.aep();
        cvVar.nF(str2);
        cvVar.km(z ? 1 : 0);
        if (!z2) {
            i2 = 0;
        }
        cvVar.kn(i2);
        cvVar.nG(str3);
        cvVar.nH(str4);
        cvVar.nI(str5);
        cvVar.nJ(str6);
        cvVar.nE(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(context)));
        cvVar.hS(cl.aWA());
        cvVar.bfK();
        AppMethodBeat.o(250696);
    }

    public static void a(Context context, boolean z, boolean z2, String str, String str2, String str3, String str4, long j2, long j3, String str5, String str6) {
        AppMethodBeat.i(250697);
        p.h(context, "context");
        p.h(str, "liveid");
        p.h(str2, "finderid");
        p.h(str3, "shopwindowid");
        p.h(str4, "sessionid");
        p.h(str5, "appuin");
        p.h(str6, "appVersion");
        cu cuVar = new cu();
        cuVar.nw(str5);
        cuVar.aem();
        cuVar.nx(str6);
        cuVar.kk(z ? 1 : 0);
        cuVar.kl(z2 ? 1 : 0);
        cuVar.nz(str);
        cuVar.nA(str2);
        cuVar.nB(str3);
        cuVar.nC(str4);
        cuVar.aen();
        cuVar.ny(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(context)));
        cuVar.hQ(j2);
        cuVar.hR(j3);
        cuVar.bfK();
        AppMethodBeat.o(250697);
    }

    public static void a(Context context, boolean z, int i2, String str, String str2, int i3, String str3, boolean z2, boolean z3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(250698);
        p.h(context, "context");
        p.h(str, "clickId");
        p.h(str2, "appId");
        p.h(str3, "preWarmPath");
        p.h(str4, "liveid");
        p.h(str5, "finderid");
        p.h(str6, "shopwindowid");
        p.h(str7, "sessionid");
        cs csVar = new cs();
        csVar.kh(i3);
        csVar.kf(z ? 1 : 0);
        csVar.kg(i2);
        csVar.nt(str);
        csVar.nm(str2);
        csVar.aek();
        csVar.no(str3);
        csVar.ki(z2 ? 1 : 0);
        csVar.kj(z3 ? 1 : 0);
        csVar.np(str4);
        csVar.nq(str5);
        csVar.nr(str6);
        csVar.ns(str7);
        csVar.ael();
        csVar.nn(String.valueOf(NetworkUtil.getCurrentNetWorkStatus(context)));
        csVar.hN(cl.aWA());
        csVar.bfK();
        AppMethodBeat.o(250698);
    }

    public static void a(int i2, int i3, int i4, long j2, long j3, long j4, long j5, int i5, int i6, String str, int i7, int i8, String str2, int i9, int i10, String str3, String str4, String str5, long j6, long j7) {
        AppMethodBeat.i(250699);
        p.h(str, "statistics");
        p.h(str2, "cgiErrmsg");
        p.h(str3, "liveEventMsg");
        p.h(str4, "extra");
        p.h(str5, "snn");
        cx cxVar = new cx();
        cxVar.iv(BuildInfo.DEBUG ? 0 : 1);
        cxVar.kq(i2);
        cxVar.kr(i3);
        cxVar.ks(i4);
        h hVar = h.ufY;
        cxVar.kt(h.deY());
        cxVar.iw(j2);
        cxVar.ix(j3);
        cxVar.iy(j4);
        cxVar.iz(j5);
        cxVar.ku(i5);
        cxVar.kv(i6);
        cxVar.nV(n.j(str, ",", ";", false));
        cxVar.kw(i7);
        cxVar.kx(i8);
        cxVar.nW(str2);
        cxVar.ky(i9);
        cxVar.kz(i10);
        cxVar.nX(str3);
        cxVar.nY(str4);
        cxVar.nZ(str5);
        cxVar.iA(j6);
        cxVar.iB(j7);
        cxVar.oa(MD5Util.getMD5String(com.tencent.mm.model.z.aTY() + com.tencent.mm.model.z.aUa() + j2));
        cxVar.bfK();
        a(cxVar);
        AppMethodBeat.o(250699);
    }

    public static void a(bbn bbn, long j2, Integer num) {
        AppMethodBeat.i(250700);
        p.h(bbn, "contextObj");
        bf bfVar = new bf();
        bfVar.jf(d.zs(j2));
        bfVar.acz();
        bfVar.du((long) bbn.tCE);
        bfVar.dv(num != null ? (long) num.intValue() : 0);
        bfVar.bfK();
        AppMethodBeat.o(250700);
    }

    public static void a(long j2, String str, String str2, long j3, String str3, String str4, String str5) {
        AppMethodBeat.i(250701);
        p.h(str, "appId");
        p.h(str2, "clickId");
        p.h(str3, "sessionid");
        p.h(str4, "setting");
        p.h(str5, "requestId");
        gu guVar = new gu();
        guVar.qE(System.currentTimeMillis());
        guVar.qF(j2);
        guVar.uz(str);
        guVar.uC(str2);
        guVar.qG(j3);
        guVar.uB(com.tencent.mm.model.z.aUg());
        guVar.uA(str3);
        guVar.uy(str4);
        guVar.uD(str5);
        guVar.bfK();
        a(guVar);
        AppMethodBeat.o(250701);
    }

    public static void a(long j2, long j3, bbn bbn) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(261321);
        com.tencent.mm.g.b.a.a aVar = new com.tencent.mm.g.b.a.a();
        aVar.bE(j2);
        aVar.hD(String.valueOf(cl.aWA()));
        aVar.abU();
        aVar.hE(d.zs(j3));
        aVar.bD(bbn != null ? (long) bbn.tCE : 0);
        if (bbn != null) {
            str = bbn.sessionId;
        } else {
            str = null;
        }
        aVar.hA(str);
        if (bbn != null) {
            str2 = bbn.sGE;
        } else {
            str2 = null;
        }
        aVar.hB(str2);
        if (bbn != null) {
            str3 = bbn.sGQ;
        }
        aVar.hC(str3);
        aVar.bfK();
        a(aVar);
        AppMethodBeat.o(261321);
    }

    public static void a(long j2, String str, long j3, String str2, bbn bbn) {
        String str3;
        String str4;
        String str5 = null;
        AppMethodBeat.i(250703);
        p.h(str, NativeProtocol.WEB_DIALOG_ACTION);
        bc bcVar = new bc();
        bcVar.dd(j2);
        bcVar.iL(str);
        bcVar.df(j3);
        bcVar.iP(str2);
        bcVar.de(bbn != null ? (long) bbn.tCE : 0);
        if (bbn != null) {
            str3 = bbn.sessionId;
        } else {
            str3 = null;
        }
        bcVar.iM(str3);
        if (bbn != null) {
            str4 = bbn.sGE;
        } else {
            str4 = null;
        }
        bcVar.iN(str4);
        if (bbn != null) {
            str5 = bbn.sGQ;
        }
        bcVar.iO(str5);
        bcVar.bfK();
        a(bcVar);
        AppMethodBeat.o(250703);
    }

    public static void f(Context context, int i2, int i3) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(250704);
        p.h(context, "context");
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        bbn dIx = fH != null ? fH.dIx() : null;
        Cdo doVar = new Cdo();
        if (dIx != null) {
            str = dIx.sessionId;
        } else {
            str = null;
        }
        doVar.pk(str);
        if (dIx != null) {
            str2 = dIx.sGE;
        } else {
            str2 = null;
        }
        doVar.pl(str2);
        doVar.km(dIx != null ? (long) dIx.tCE : 0);
        doVar.pn(String.valueOf(System.currentTimeMillis()));
        if (dIx != null) {
            str3 = dIx.sGQ;
        }
        doVar.pm(str3);
        doVar.kn((long) i2);
        doVar.ko((long) i3);
        doVar.bfK();
        a(doVar);
        AppMethodBeat.o(250704);
    }

    public static /* synthetic */ void T(int i2, String str, String str2) {
        AppMethodBeat.i(261323);
        j(i2, str, str2, "");
        AppMethodBeat.o(261323);
    }

    public static void j(int i2, String str, String str2, String str3) {
        AppMethodBeat.i(261322);
        p.h(str, "userName");
        p.h(str2, "profileBizUin");
        dm dmVar = new dm();
        dmVar.kj((long) i2);
        dmVar.pe(str);
        dmVar.pf(str2);
        dmVar.atx(str3);
        dmVar.bfK();
        a(dmVar);
        AppMethodBeat.o(261322);
    }

    public static /* synthetic */ void a(FinderPoiFeedUI.a aVar, long j2, bbn bbn, String str, String str2, String str3) {
        AppMethodBeat.i(250707);
        a(aVar, j2, bbn, str, str2, str3, 0);
        AppMethodBeat.o(250707);
    }

    public static void a(FinderPoiFeedUI.a aVar, long j2, bbn bbn, String str, String str2, String str3, long j3) {
        String str4 = null;
        AppMethodBeat.i(250706);
        p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
        gm gmVar = new gm();
        gmVar.qt((long) aVar.ordinal());
        gmVar.qu(cl.aWA());
        gmVar.qv(j3);
        gmVar.qw(j2);
        gmVar.uk(bbn != null ? bbn.sGQ : null);
        if (bbn != null) {
            str4 = bbn.sessionId;
        }
        gmVar.ul(str4);
        gmVar.um(str);
        gmVar.un(str2);
        gmVar.uo(str3);
        gmVar.bfK();
        a(gmVar);
        AppMethodBeat.o(250706);
    }

    public static void dC(int i2, String str) {
        AppMethodBeat.i(261324);
        p.h(str, "msgId");
        oj ojVar = new oj();
        ojVar.aFb();
        ojVar.PL((long) i2);
        ojVar.atL(str);
        ojVar.bfK();
        a(ojVar);
        AppMethodBeat.o(261324);
    }

    public static void a(String str, int i2, bbn bbn, String str2) {
        AppMethodBeat.i(261325);
        p.h(str, "appId");
        p.h(str2, "resId");
        ox oxVar = new ox();
        oxVar.bwZ(str);
        oxVar.RC((long) i2);
        oxVar.bxd(str2);
        if (bbn != null) {
            oxVar.bxb(bbn.sGQ);
            oxVar.RD((long) bbn.tCE);
            oxVar.bxc(bbn.sGE);
            oxVar.bxa(bbn.sessionId);
        }
        oxVar.bfK();
        a(oxVar);
        AppMethodBeat.o(261325);
    }

    public static void a(s sVar, int i2, int i3) {
        AppMethodBeat.i(178394);
        p.h(sVar, "rootComment");
        FinderItem Fc = Fc(sVar.uOf.field_feedId);
        if (Fc != null) {
            bs bsVar = new bs();
            bsVar.ex((long) i2);
            bsVar.ey((long) sVar.uOf.dyb().levelTwoComment.size());
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            bsVar.jZ(cMD);
            bsVar.ka(Fg(Fc.getId()));
            bsVar.kb(Fc.getUserName());
            bsVar.eA(System.currentTimeMillis());
            bsVar.kc(sVar.uOf.getUsername());
            bsVar.ez((long) sVar.uOf.dyb().likeCount);
            bsVar.kd(Fg(sVar.lT()));
            bsVar.eB((long) sVar.uOf.dyb().expandCommentCount);
            switch (i3) {
                case 7:
                case 8:
                    bsVar.eC(1);
                    break;
                default:
                    bsVar.eC(2);
                    break;
            }
            bsVar.eD((long) (((sVar.uOf.dyb().displayFlag & 8) > 0 || (sVar.uOf.dyb().displayFlag & 2) > 0) ? 1 : 2));
            bsVar.eE((long) i3);
            bsVar.bfK();
            a(bsVar);
            AppMethodBeat.o(178394);
            return;
        }
        AppMethodBeat.o(178394);
    }
}

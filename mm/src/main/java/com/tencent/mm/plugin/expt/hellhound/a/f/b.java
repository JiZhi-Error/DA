package com.tencent.mm.plugin.expt.hellhound.a.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.i;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.plugin.expt.hellhound.core.stack.g;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b {
    private static b sIo;
    public final a sIp = new a();
    public final c sIq = new c();
    public String sIr = null;
    private int sIs = -1;
    private int sIt = -1;
    private long sIu = -1;
    private cyl sIv = null;

    public static b cPO() {
        AppMethodBeat.i(122044);
        if (sIo == null) {
            synchronized (b.class) {
                try {
                    if (sIo == null) {
                        sIo = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(122044);
                    throw th;
                }
            }
        }
        b bVar = sIo;
        AppMethodBeat.o(122044);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(122045);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
            k.cQB();
        }
        AppMethodBeat.o(122045);
    }

    public static void d(String str, String str2, int i2, long j2) {
        AppMethodBeat.i(220537);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizEnter: FALSE");
            AppMethodBeat.o(220537);
        } else if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPY()) {
            Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter, NOT 104-Biz Session !!");
            AppMethodBeat.o(220537);
        } else {
            if ("Biz".equals(str)) {
                Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter: %s -> %s", str2, com.tencent.mm.plugin.expt.hellhound.core.b.sza);
                if (!str2.contains("BizTimeLineUI")) {
                    str2.contains("BizConversationUI");
                }
                com.tencent.mm.plugin.expt.hellhound.a.f.d.b.x(com.tencent.mm.plugin.expt.hellhound.core.b.sza, i2, j2);
            }
            AppMethodBeat.o(220537);
        }
    }

    public static void e(String str, String str2, int i2, long j2) {
        AppMethodBeat.i(220538);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizExit: FALSE");
            AppMethodBeat.o(220538);
        } else if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPY()) {
            Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit, NOT 104-Biz Session !!");
            AppMethodBeat.o(220538);
        } else {
            if ("Biz".equals(str)) {
                Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit: %s", str2);
                if (str2.contains("BizTimeLineUI")) {
                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.x(str2, i2, j2);
                    AppMethodBeat.o(220538);
                    return;
                } else if (str2.contains("BizConversationUI")) {
                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.x(str2, i2, j2);
                }
            }
            AppMethodBeat.o(220538);
        }
    }

    public final void b(String str, int i2, long j2, int i3) {
        AppMethodBeat.i(220539);
        this.sIt = i3;
        this.sIu = j2;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
            com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
            AppMethodBeat.o(220539);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "frontbackEvent: %s, %d, %s", str, Integer.valueOf(i3), Long.valueOf(this.sIu));
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str)) {
            u(str, i3, this.sIu);
            AppMethodBeat.o(220539);
            return;
        }
        b(str, i2, i3, this.sIu);
        AppMethodBeat.o(220539);
    }

    public final void a(Activity activity, bn bnVar, int i2, bn bnVar2) {
        AppMethodBeat.i(122049);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitor, needSessionMonitor: FALSE");
            AppMethodBeat.o(122049);
        } else if (bnVar == null) {
            AppMethodBeat.o(122049);
        } else {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor monitor: %s", Integer.valueOf(i2));
            switch (i2) {
                case 0:
                case 1:
                case 2:
                case 3:
                    a(activity, bnVar, bnVar2, i2);
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, activity: %s, %d", bnVar.KFh.activityName, Integer.valueOf(i2));
                    break;
                case 4:
                case 5:
                    a(bnVar, i2, bnVar2);
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, fragment: %s, %d", bnVar.KFi, Integer.valueOf(i2));
                    break;
                case 7:
                    a(i2, bnVar2, bnVar.KFl);
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, session end: ChattingUIFragment");
                    break;
            }
            this.sIt = -1;
            AppMethodBeat.o(122049);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void i(int i2, int i3, long j2) {
        int i4 = 0;
        AppMethodBeat.i(184364);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorStorySession: FALSE");
            AppMethodBeat.o(184364);
            return;
        }
        switch (i2) {
            case 8:
                switch (i3) {
                    case 0:
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_StoryGallery_SHOW");
                        al(com.tencent.mm.plugin.expt.hellhound.core.b.syZ, j2);
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
                        Dr(j2);
                        AppMethodBeat.o(184364);
                        return;
                    case 1:
                    default:
                        AppMethodBeat.o(184364);
                        return;
                    case 2:
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_RESUME, Event-7, !!");
                        AppMethodBeat.o(184364);
                        return;
                }
            case 9:
                switch (i3) {
                    case 1:
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
                        Ds(j2);
                        Fragment c2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.syZ);
                        if (c2 != null) {
                            i4 = c2.hashCode();
                        }
                        w(com.tencent.mm.plugin.expt.hellhound.core.b.syZ, i4, j2);
                        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl) null, com.tencent.mm.plugin.expt.hellhound.core.b.sze, i4, j2);
                        break;
                    case 3:
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
                        d.cNM();
                        bn cNR = e.cNR();
                        if (cNR == null) {
                            AppMethodBeat.o(184364);
                            return;
                        } else if (cNR.KFh == null) {
                            AppMethodBeat.o(184364);
                            return;
                        } else {
                            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(cNR.KFh.activityName);
                            Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGalleryViewSession, topActivity: %s", aoE);
                            if ("StoryCaptureUI".equals(aoE)) {
                                cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                                if (cQo == null) {
                                    AppMethodBeat.o(184364);
                                    return;
                                }
                                com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cQo);
                            }
                            AppMethodBeat.o(184364);
                            return;
                        }
                }
        }
        AppMethodBeat.o(184364);
    }

    public static void t(String str, int i2, long j2) {
        AppMethodBeat.i(220540);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorScanSession: FALSE");
            AppMethodBeat.o(220540);
            return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.y(str, i2, j2);
        AppMethodBeat.o(220540);
    }

    public static void e(Activity activity, int i2) {
        AppMethodBeat.i(122053);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnActivityAsync: FALSE");
            AppMethodBeat.o(122053);
            return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.f(activity, i2);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.c.f(activity, i2);
        AppMethodBeat.o(122053);
    }

    public static void a(Fragment fragment, int i2) {
        AppMethodBeat.i(122054);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnFragment: FALSE");
            AppMethodBeat.o(122054);
            return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.b(fragment, i2);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.c.b(fragment, i2);
        AppMethodBeat.o(122054);
    }

    public static void cPP() {
        AppMethodBeat.i(122055);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, handleMMProcessRestart: FALSE");
            com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
            AppMethodBeat.o(122055);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "handleMMProcessRestart");
        cbo cQs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
        if (cQs == null) {
            AppMethodBeat.o(122055);
        } else if (!cQs.Mht.isEmpty() || !cQs.Mhr.isEmpty()) {
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
            cbl cQH = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cQH();
            if (cQH.Mhn.isEmpty()) {
                AppMethodBeat.o(122055);
                return;
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
            Log.i("HABBYGE-MALI.HellSessionReport", "reportWhenMMProcessRestart BEGIN !!");
            Log.i("HABBYGE-MALI.HellSessionReportProcessRestart", "HellSessionReportProcessRestart.report()");
            j.a(cQH, cQs, true);
            cbm last = cQH.Mhn.getLast();
            if (cQs.Mhq <= 0) {
                cQs.Mhq = last.startTime;
            }
            Iterator<cyl> it = cQs.Mhr.iterator();
            while (it.hasNext()) {
                cyl next = it.next();
                if (next.endTime <= 0) {
                    next.endTime = last.startTime;
                }
            }
            Iterator<cyh> it2 = cQs.Mht.iterator();
            while (it2.hasNext()) {
                cyh next2 = it2.next();
                if (next2.endTime <= 0) {
                    next2.endTime = last.startTime;
                }
            }
            j.a(cQs, cQH.Mhn.getFirst());
            cQH.Mhn.removeLast();
            j.d(cQs, cQH, (cyl) null);
            AppMethodBeat.o(122055);
        } else {
            AppMethodBeat.o(122055);
        }
    }

    private void Dr(long j2) {
        boolean z;
        AppMethodBeat.i(122056);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView");
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            cQo = a((Activity) null, "MoreTabUI", "StoryGalleryView", 0, j2);
            if (cQo == null) {
                Log.e("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, 不是合法session ~~~");
                AppMethodBeat.o(122056);
                return;
            }
            z = true;
        } else {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, curSession: %s", cQo.sessionId);
            z = false;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, "StoryGalleryView", 0, j2);
        if (z) {
            cQo.iOu = 0;
            String cPR = m.cPR();
            if (cPR == null) {
                cPR = "";
            }
            cQo.kvy = cPR;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(cQo);
            e(cQo);
            AppMethodBeat.o(122056);
            return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cQo);
        AppMethodBeat.o(122056);
    }

    private void Ds(long j2) {
        AppMethodBeat.i(122057);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, 不是合法session !!!");
            AppMethodBeat.o(122057);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, curSession: %s", cQo.sessionId);
        if ("142".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cQo.sessionId))) {
            a(cQo, j2);
            AppMethodBeat.o(122057);
            return;
        }
        if (!"StoryGalleryView".equals(cQo.MDn)) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "curActivity: %s IS NOT curSession: %s startPage: %s", "StoryGalleryView", cQo.sessionId, cQo.MDn);
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cQo);
        }
        AppMethodBeat.o(122057);
    }

    private void u(String str, int i2, long j2) {
        AppMethodBeat.i(122058);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOnFrontBack, pageName: %s", str);
        switch (i2) {
            case 7:
                this.sIs = 7;
                ai(str, j2);
                AppMethodBeat.o(122058);
                return;
            case 8:
                this.sIs = 8;
                aj(str, j2);
                break;
        }
        AppMethodBeat.o(122058);
    }

    private void ai(String str, long j2) {
        String str2;
        int hashCode;
        cyl cyl;
        cbm cQL;
        AppMethodBeat.i(122059);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(122059);
            return;
        }
        cbo cQs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
        if (cQs == null) {
            cQs = new cbo();
        }
        cQs.Mhp = j2;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(cQs);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event: %s, %s", str, Long.valueOf(cQs.Mhp));
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, no Session: %s", str);
        } else if (cQo.MDr) {
            String aqn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cQo.sessionId);
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSid: %s", aqn);
            if (!(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqs(aqn) || "131".equals(aqn) || "144".equals(aqn)) || !com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str)) {
                if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(aqn) && (cQL = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQL()) != null) {
                    Log.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s", cQL.dRM, cQL.dMl);
                    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(cQL.dRM) && (cQL.dMl.equals("FloatBall") || com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(cQL.dMl))) {
                        String cPQ = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPQ();
                        cyl cQq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQq();
                        Log.w("HABBYGE-MALI.HellSessionMonitor", "lstSessionId: %s", cPQ);
                        if (cQq != null) {
                            Log.w("HABBYGE-MALI.HellSessionMonitor", "lstSession: %s", cQq.sessionId);
                        }
                        cQo.startTime = j2;
                        cQo.endTime = j2;
                        cQo.MDn = "FloatBall";
                        cQo.iOu = 1;
                        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cQo);
                        a(cQo, j2);
                        AppMethodBeat.o(122059);
                        return;
                    }
                }
                cQo.MDr = false;
                cQo.iOu = 0;
                cQo.startTime = j2;
                String cPR = m.cPR();
                if (cPR == null) {
                    cPR = "";
                }
                cQo.kvy = cPR;
                if ("142".equals(aqn)) {
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: StoryGalleryView");
                    str2 = "StoryGalleryView";
                    hashCode = 0;
                    cyl = cQo;
                } else {
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: ChattingUIFragment");
                    Fragment c2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
                    str2 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
                    if (c2 == null) {
                        hashCode = 0;
                        cyl = cQo;
                    } else {
                        hashCode = c2.hashCode();
                        cyl = cQo;
                    }
                }
                com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cyl, str2, hashCode, j2);
                com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cQo);
                e(cQo);
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSession: %s, %s, %s, %d", cQo.sessionId, cQo.MDn, cQo.MDq, Integer.valueOf(cQo.MDo));
                AppMethodBeat.o(122059);
                return;
            }
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, AppBrand 7Event !!!");
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aqH(cQo.sessionId);
            AppMethodBeat.o(122059);
            return;
        }
        AppMethodBeat.o(122059);
    }

    private void aj(String str, long j2) {
        AppMethodBeat.i(122060);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo != null) {
            cQo.MDr = true;
            cQo.endTime = j2;
            Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn8Event, curSession: %s, %s", cQo.sessionId, str);
            cbo cQs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
            if (cQs == null) {
                AppMethodBeat.o(122060);
                return;
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ap(str, j2);
            cQs.Mhq = j2;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(cQs);
            a(cQo, j2);
            g(cQo);
            a(cQo, str);
            AppMethodBeat.o(122060);
            return;
        }
        d.cNM();
        bn apc = g.apc(str);
        if (apc != null) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, curAR: %s, %s, %s, %s", apc.KFh.activityName, apc.KFk, apc.KFi, apc.KFj);
            if (TextUtils.isEmpty(apc.KFi)) {
                str = apc.KFh.activityName;
            } else {
                str = apc.KFi;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        }
        al(str, j2);
        cbo cQs2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
        if (cQs2 == null) {
            AppMethodBeat.o(122060);
            return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ap(str, j2);
        cQs2.Mhq = j2;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(cQs2);
        g(null);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, 无Session: %s", str);
        AppMethodBeat.o(122060);
    }

    private void b(String str, int i2, int i3, long j2) {
        AppMethodBeat.i(220541);
        switch (i3) {
            case 7:
                v(str, i2, j2);
                AppMethodBeat.o(220541);
                return;
            case 8:
                ak(str, j2);
                break;
        }
        AppMethodBeat.o(220541);
    }

    private void ak(String str, long j2) {
        String aoE;
        AppMethodBeat.i(122063);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo != null) {
            cQo.MDr = true;
            cQo.endTime = j2;
            cbo cQs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
            if (cQs == null) {
                AppMethodBeat.o(122063);
                return;
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ap(str, j2);
            cQs.Mhq = j2;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(cQs);
            a(cQo, j2);
            g(cQo);
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event: %s, %s", cQo.sessionId, cQo.MDn);
            a(cQo, str);
            AppMethodBeat.o(122063);
        } else if (str == null) {
            AppMethodBeat.o(122063);
        } else {
            d.cNM();
            bn apc = g.apc(str);
            if (apc != null) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, curAR: %s, %s, %s, %s", apc.KFh.activityName, apc.KFk, apc.KFi, apc.KFj);
                if (TextUtils.isEmpty(apc.KFi)) {
                    aoE = apc.KFh.activityName;
                } else {
                    aoE = apc.KFi;
                }
            } else {
                aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
            }
            if (!TextUtils.isEmpty(aoE)) {
                aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(aoE);
            }
            al(aoE, j2);
            cbo cQs2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
            if (cQs2 == null) {
                AppMethodBeat.o(122063);
                return;
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ap(str, j2);
            cQs2.Mhq = j2;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(cQs2);
            g(null);
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, 无Session: %s", aoE);
            AppMethodBeat.o(122063);
        }
    }

    public final void w(String str, int i2, long j2) {
        Fragment cOk;
        AppMethodBeat.i(220543);
        if (TextUtils.isEmpty(str)) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "addUnknownPage: page is NULL");
            AppMethodBeat.o(220543);
            return;
        }
        cyh cyh = new cyh();
        cyh.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        cyh.aHK = i2;
        if (this.sIt == 7) {
            cyh.startTime = this.sIu;
            this.sIt = -1;
        } else {
            cyh.startTime = j2;
        }
        cyh.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQm();
        if ("LauncherUI".equals(cyh.dMl)) {
            Fragment apm = h.apm("com.tencent.mm.ui.LauncherUI");
            if (apm != null) {
                cyh.dMl = apm.getClass().getSimpleName();
                cyh.aHK = apm.hashCode();
            }
        } else if (("FinderHomeUI".equals(cyh.dMl) || "FinderConversationUI".equals(cyh.dMl)) && (cOk = com.tencent.mm.plugin.expt.hellhound.a.b.b.k.cOk()) != null) {
            cyh.dMl = cOk.getClass().getSimpleName();
        }
        String cPR = m.cPR();
        if (cPR == null) {
            cPR = "";
        }
        cyh.kvy = cPR;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart, unknow: %s, %s, %s", cyh.dMl, Long.valueOf(cyh.startTime), cyh.kvy);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(cyh);
        m.add(cyh.dMl + "_" + cyh.startTime);
        l.c(cyh);
        am(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(cyh.dMl), j2);
        AppMethodBeat.o(220543);
    }

    public static void al(String str, long j2) {
        AppMethodBeat.i(184367);
        cyh cQr = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQr();
        if (cQr == null) {
            AppMethodBeat.o(184367);
            return;
        }
        cQr.endTime = j2;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose, unknow: %s, %s, %s, %s", str, cQr.dMl, Long.valueOf(cQr.startTime), Long.valueOf(cQr.endTime));
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(cQr);
        an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(cQr.dMl), j2);
        AppMethodBeat.o(184367);
    }

    private void a(Activity activity, bn bnVar, bn bnVar2, int i2) {
        AppMethodBeat.i(184368);
        if (bnVar == null) {
            AppMethodBeat.o(184368);
        } else if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFh.activityName))) {
            j(i2, bnVar.KFh.aHK, bnVar.KFh.timestamp);
            AppMethodBeat.o(184368);
        } else {
            a(activity, bnVar, bnVar2, i2, bnVar.KFh.timestamp);
            AppMethodBeat.o(184368);
        }
    }

    private void a(Activity activity, bn bnVar, bn bnVar2, int i2, long j2) {
        AppMethodBeat.i(122068);
        switch (i2) {
            case 0:
                a(activity, bnVar, bnVar2, j2);
                AppMethodBeat.o(122068);
                return;
            case 1:
            case 2:
            case 3:
                a(bnVar, i2, j2);
                break;
        }
        AppMethodBeat.o(122068);
    }

    private void a(Activity activity, bn bnVar, bn bnVar2, long j2) {
        long j3;
        cyl cyl;
        boolean z;
        cyl a2;
        AppMethodBeat.i(122069);
        if (bnVar == null) {
            AppMethodBeat.o(122069);
            return;
        }
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFh.activityName);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, curActivityName: %s", aoE);
        if (bnVar.KFh.timestamp <= 0) {
            j3 = j2;
        } else {
            j3 = bnVar.KFh.timestamp;
        }
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        String e2 = e(bnVar, bnVar2);
        if (cQo == null) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, newSession: %s, %s", aoE, e2);
            cyl a3 = a(activity, e2, aoE, bnVar.KFh.aHK, j3);
            if (a3 == null) {
                Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityIn, illegal session ~~~");
                AppMethodBeat.o(122069);
                return;
            }
            z = true;
            cyl = a3;
        } else {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, curSession: %s, %s, %s", cQo.sessionId, e2, aoE);
            if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(cQo.sessionId)) {
                AppMethodBeat.o(122069);
                return;
            } else if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoT(e2) || (a2 = a(activity, e2, aoE, bnVar.KFh.aHK, j3)) == null) {
                cyl = cQo;
                z = false;
            } else {
                a2.MDt = true;
                a(cQo, j3);
                h(cQo);
                z = true;
                cyl = a2;
            }
        }
        if (aoE != null && !aoE.equals("LauncherUI")) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cyl, aoE, bnVar.KFh.aHK, j3);
        }
        if (z) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, isNewSession: %s", cyl.sessionId);
            cyl.iOu = 0;
            String cPR = m.cPR();
            if (cPR == null) {
                cPR = "";
            }
            cyl.kvy = cPR;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(cyl);
            e(cyl);
            AppMethodBeat.o(122069);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, setPageFlow: %s", cyl.sessionId);
        AppMethodBeat.o(122069);
    }

    private static String e(bn bnVar, bn bnVar2) {
        AppMethodBeat.i(184369);
        String str = null;
        if (bnVar == null || TextUtils.isEmpty(bnVar.KFj)) {
            if (bnVar2 != null) {
                if (!TextUtils.isEmpty(bnVar2.KFi)) {
                    str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar2.KFi);
                } else if (!TextUtils.isEmpty(bnVar2.KFj)) {
                    str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar2.KFi);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lnARA, lastPageName: %s", str);
                AppMethodBeat.o(184369);
                return str;
            }
            String cNW = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.cNW();
            Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-1: %s", cNW);
            if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(cNW)) {
                d.cNM();
                bn cNR = e.cNR();
                if (cNR != null) {
                    cNW = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(cNR.KFi);
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-2: %s", cNW);
                    if (TextUtils.isEmpty(cNW)) {
                        cNW = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(cNR.KFj);
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, lastPageName-3: %s", cNW);
                    }
                }
            } else {
                cNW = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(cNW);
            }
            Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName: %s", cNW);
            if (TextUtils.isEmpty(cNW)) {
                String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.szb;
                AppMethodBeat.o(184369);
                return str2;
            }
            AppMethodBeat.o(184369);
            return cNW;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, curAR.lastPageName: %s", bnVar.KFj);
        String str3 = bnVar.KFj;
        AppMethodBeat.o(184369);
        return str3;
    }

    @SuppressLint({"NewApi"})
    private void a(bn bnVar, int i2, long j2) {
        String str;
        boolean z;
        AppMethodBeat.i(122071);
        if (bnVar == null) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "HelLSessionMonitor, activityOut: NULL");
            AppMethodBeat.o(122071);
            return;
        }
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, 不是合法session !!!");
            AppMethodBeat.o(122071);
            return;
        }
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFh.activityName);
        if (aoE == null) {
            AppMethodBeat.o(122071);
            return;
        }
        String aqn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cQo.sessionId);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityOut, curSesssion: %s, %s", aqn, aoE);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqs(aqn) || "131".equals(aqn) || "144".equals(aqn)) {
            if (com.tencent.mm.plugin.expt.hellhound.core.b.aoK(cQo.MDs)) {
                if (com.tencent.mm.plugin.expt.hellhound.core.b.aoK(aoE)) {
                    a(cQo, j2);
                    AppMethodBeat.o(122071);
                    return;
                }
                d.cNM();
                bn cNR = e.cNR();
                if (cNR != null) {
                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, cNR.KFh.activityName, cNR.KFh.aHK, j2);
                }
                AppMethodBeat.o(122071);
                return;
            } else if ("AppBrandLaunchProxyUI".equals(aoE)) {
                Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrandLaunchProxyUI out ~~");
                AppMethodBeat.o(122071);
                return;
            } else {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrand cur: %s, start: %s", aoE, cQo.MDs);
                if (com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(aoE) && aoE.equals(cQo.MDs)) {
                    a(cQo, j2);
                    AppMethodBeat.o(122071);
                    return;
                } else if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(aoE) || !"AppBrandLaunchProxyUI".equals(cQo.MDs)) {
                    d.cNM();
                    bn cNR2 = e.cNR();
                    if (cNR2 != null) {
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, dstAR: %s", cNR2.KFh.activityName);
                    }
                    if (com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(aoE) && cNR2 != null && com.tencent.mm.plugin.expt.hellhound.core.b.aoz(cNR2.KFh.activityName)) {
                        a(cQo, j2);
                        AppMethodBeat.o(122071);
                        return;
                    } else if (cNR2 != null && !com.tencent.mm.plugin.expt.hellhound.core.b.aoz(cNR2.KFh.activityName)) {
                        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, cNR2.KFh.activityName, cNR2.KFh.aHK, j2);
                    }
                } else {
                    a(cQo, j2);
                }
            }
        }
        if ("132".equals(aqn)) {
            if ("GameCenterUI".equals(aoE)) {
                Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameCenterUI out ~~");
                AppMethodBeat.o(122071);
                return;
            } else if ("GameWebViewUI".equals(aoE) || "LuggageGameWebViewUI".equals(aoE) || "GameWebViewMpUI".equals(aoE) || "LuggageGameWebViewMpUI".equals(aoE)) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", aoE);
                a(cQo, j2);
                AppMethodBeat.o(122071);
                return;
            }
        }
        if ("142".equals(aqn)) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, StoryGallery Session(142)");
            if ("StoryCaptureUI".equals(aoE)) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", aoE);
                a(cQo, j2);
                AppMethodBeat.o(122071);
                return;
            }
        }
        if (!"110".equals(aqn)) {
            if (bnVar.KFk == null || bnVar.KFk.isEmpty()) {
                str = null;
            } else {
                String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFk);
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, nextActivity: %s, %d", aoE2, Integer.valueOf(i2));
                if (i2 != 2 && !"LauncherUI".equals(aoE2)) {
                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, aoE2, 0, j2);
                }
                str = aoE2;
            }
            if (!aoE.equals(cQo.MDn)) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, curActivity: %s is not curSession: %s preActivity %s", aoE, cQo.sessionId, cQo.MDn);
                if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arb(aqn) && "WebViewUI".equals(aoE)) {
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isScanSession true !!");
                    a(cQo, j2);
                }
                AppMethodBeat.o(122071);
                return;
            }
            boolean z2 = true;
            if ("WebViewUI".equals(aoE)) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, WebViewUI: %s, %s", com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.apk("minimize_secene"), com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.apk("KPublisherId"));
                boolean z3 = false;
                if (cQo.MDp != null) {
                    Iterator<cgh> it = cQo.MDp.MDh.iterator();
                    z = false;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        cgh next = it.next();
                        if (next != null) {
                            if (!"minimize_secene".equals(next.key) || !"1".equals(next.value)) {
                                if ("KPublisherId".equals(next.key) && "jd_store".equals(next.value)) {
                                    z = true;
                                    if (z3) {
                                        break;
                                    }
                                }
                                z = z;
                            } else if (z) {
                                z3 = true;
                                break;
                            } else {
                                z3 = true;
                            }
                        }
                    }
                } else {
                    z = false;
                }
                if (!z3 || !z) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if ("LauncherUI".equals(str) && "148".equals(aqn)) {
                    z2 = true;
                }
            }
            if (z2) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isStartPageOfSession true: %s", aoE);
                if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arb(aqn)) {
                    boolean cPK = com.tencent.mm.plugin.expt.hellhound.a.e.a.cPK();
                    Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, scan session: %s", Boolean.valueOf(cPK));
                    if (cPK) {
                        com.tencent.mm.plugin.expt.hellhound.a.e.a.cPL();
                        d.cNM();
                        String aoE3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(e.cNR().KFh.activityName);
                        Log.d("HABBYGE-MALI.HellSessionMonitor", "scan session: %s, %s", aoE, aoE3);
                        if (!"BaseScanUI".equals(aoE) || !"LauncherUI".equals(aoE3)) {
                            AppMethodBeat.o(122071);
                            return;
                        }
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "BaseScanUI, LauncherUI");
                    } else {
                        AppMethodBeat.o(122071);
                        return;
                    }
                }
                if ("ContactInfoUI".equals(aoE) && "122".equals(aqn) && i2 == 2) {
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, EVENT_ACTIVITY_OUT_SLIENCE: ContactInfoUI");
                    String GR = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(100);
                    String GR2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(101);
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, from: %s, to: %s", GR, GR2);
                    if ("com.tencent.mm.plugin.profile.ui.ContactInfoUI".equals(GR) && "com.tencent.mm.ui.chatting.ChattingUI".equals(GR2)) {
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "ContactInfoUI->ChattingUI YES");
                        AppMethodBeat.o(122071);
                        return;
                    }
                }
                if ("FinderSelfUI".equals(aoE)) {
                    Log.w("HABBYGE-MALI.HellSessionMonitor", "123-session -> 60s finder share path...");
                    AppMethodBeat.o(122071);
                    return;
                }
                a(cQo, j2);
            }
            AppMethodBeat.o(122071);
        } else if ("WalletOfflineCoinPurseUI".equals(aoE) || "WalletOfflineEntranceUI".equals(aoE)) {
            if (i2 != 2) {
                a(cQo, j2);
            }
            AppMethodBeat.o(122071);
        } else {
            d.cNM();
            bn cNR3 = e.cNR();
            if (cNR3 != null) {
                com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, cNR3.KFh.activityName, cNR3.KFh.aHK, j2);
            }
            AppMethodBeat.o(122071);
        }
    }

    private void j(int i2, int i3, long j2) {
        AppMethodBeat.i(220544);
        switch (i2) {
            case 0:
                Z(i3, j2);
                AppMethodBeat.o(220544);
                return;
            case 1:
            case 2:
            case 3:
                aa(i2, j2);
                break;
        }
        AppMethodBeat.o(220544);
    }

    private void Z(int i2, long j2) {
        AppMethodBeat.i(220545);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            String GR = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(100);
            String GR2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(101);
            String GR3 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(102);
            String GR4 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(104);
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoB(GR) || !com.tencent.mm.plugin.expt.hellhound.core.b.aoy(GR2) || !com.tencent.mm.plugin.expt.hellhound.core.b.aoB(GR3) || !com.tencent.mm.plugin.expt.hellhound.core.b.aoy(GR4)) {
                Log.e("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, 不是合法session !!!");
                AppMethodBeat.o(220545);
                return;
            }
            ab(i2, j2);
            AppMethodBeat.o(220545);
            return;
        }
        String aqn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cQo.sessionId);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, curSessionId: %s", aqn);
        if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqu(aqn)) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, "com.tencent.mm.ui.chatting.ChattingUI", i2, j2);
            AppMethodBeat.o(220545);
            return;
        }
        com.tencent.mm.vending.j.c<String, Integer> cPM = a.cPM();
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, userName: %s", (String) cPM.get(0));
        int intValue = ((Integer) cPM.get(1)).intValue();
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType: %d", Integer.valueOf(intValue));
        if (intValue == cQo.MDo) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType same !!!");
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, "com.tencent.mm.ui.chatting.ChattingUI", i2, j2);
            AppMethodBeat.o(220545);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType difference !!!");
        a(cQo, j2);
        ab(i2, j2);
        AppMethodBeat.o(220545);
    }

    private void aa(int i2, long j2) {
        AppMethodBeat.i(122074);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, 不是合法session !!!");
            AppMethodBeat.o(122074);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curSessionId: %s", cQo.sessionId);
        if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqu(cQo.sessionId)) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session: %s", cQo.sessionId);
            d.cNM();
            bn cNR = e.cNR();
            if (cNR != null) {
                String str = cNR.KFh.activityName;
                Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session, page: %s", str);
                if (i2 != 2) {
                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, str, cNR.KFh.aHK, j2);
                }
            }
            AppMethodBeat.o(122074);
            return;
        }
        com.tencent.mm.vending.j.c<String, Integer> cPM = a.cPM();
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, userName: %s", (String) cPM.get(0));
        int intValue = ((Integer) cPM.get(1)).intValue();
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, newChattingType: %s, %d", Integer.valueOf(intValue), Integer.valueOf(cQo.MDo));
        if (intValue != cQo.MDo) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curChattingType不等: %d", Integer.valueOf(intValue));
            AppMethodBeat.o(122074);
        } else if ("ChattingUI".equals(cQo.MDn)) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, CHATTING_UI");
            a(cQo, j2);
            AppMethodBeat.o(122074);
        } else if (i2 == 2) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, SLIENCE: %s", cQo.MDn);
            a(cQo, j2);
            AppMethodBeat.o(122074);
        } else {
            d.cNM();
            bn cNR2 = e.cNR();
            if (cNR2 != null) {
                com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, cNR2.KFh.activityName, cNR2.KFh.aHK, j2);
                com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cQo);
            }
            AppMethodBeat.o(122074);
        }
    }

    private void ab(int i2, long j2) {
        AppMethodBeat.i(220546);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "newChattingUISession");
        cyl a2 = a((Activity) null, com.tencent.mm.plugin.expt.hellhound.core.b.szb, "ChattingUI", i2, j2);
        if (a2 == null) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "_doChattingUIInContinue, 不是合法session ~~~");
            AppMethodBeat.o(220546);
            return;
        }
        String cPR = m.cPR();
        if (cPR == null) {
            cPR = "";
        }
        a2.kvy = cPR;
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(a2, "com.tencent.mm.ui.chatting.ChattingUI", i2, j2);
        a2.iOu = 0;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(a2);
        e(a2);
        AppMethodBeat.o(220546);
    }

    private void a(bn bnVar, int i2, bn bnVar2) {
        int i3 = 0;
        AppMethodBeat.i(184370);
        com.tencent.mm.vending.j.c<String, String> b2 = b(bnVar, i2, bnVar2);
        if (b2 == null) {
            AppMethodBeat.o(184370);
            return;
        }
        String str = (String) b2.get(0);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment: %s, %s, %d", str, (String) b2.get(1), Integer.valueOf(i2));
        if (i2 == 4) {
            if ("ChattingUIFragment".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str))) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
                a(6, bnVar2, bnVar.KFl);
            } else {
                cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                if (cQo != null && cQo.sessionId.startsWith("142")) {
                    AppMethodBeat.o(184370);
                    return;
                } else if (cQo == null || !com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(bnVar.KFi)) {
                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl) null, bnVar.KFi, bnVar.KFm, bnVar.KFl);
                    if (cQo == null) {
                        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFi);
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, curSession == null: %s", aoE);
                        if ("ChattingUIFragment".equals(aoE)) {
                            a(6, bnVar2, bnVar.KFl);
                        } else {
                            Fragment c2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), bnVar.KFi);
                            w(bnVar.KFi, c2 == null ? 0 : c2.hashCode(), bnVar.KFl);
                        }
                    } else if (com.tencent.mm.plugin.expt.hellhound.core.b.aoS(bnVar.KFi)) {
                        Log.i("HABBYGE-MALI.HellSessionMonitor", "curAR.currFragment: %s", bnVar.KFi);
                        a(cQo, bnVar.KFl);
                        Fragment c3 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), bnVar.KFi);
                        if (c3 != null) {
                            i3 = c3.hashCode();
                        }
                        w(bnVar.KFi, i3, bnVar.KFl);
                    }
                } else {
                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cQo, bnVar.KFi, bnVar.KFm, bnVar.KFl);
                    AppMethodBeat.o(184370);
                    return;
                }
            }
        } else if (i2 == 5) {
            if ("ChattingUIFragment".equals(str) || com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(str)) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, out event, no need handle, curFragment=%s", str);
                AppMethodBeat.o(184370);
                return;
            } else if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPQ())) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "isFloatSession, out event, no need handle, curFragment=%s", str);
                AppMethodBeat.o(184370);
                return;
            } else {
                al(str, bnVar.KFl);
            }
        }
        if (this.sIs != -1) {
            this.sIs = -1;
        }
        AppMethodBeat.o(184370);
    }

    private void a(int i2, bn bnVar, long j2) {
        int i3 = 0;
        AppMethodBeat.i(122077);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorChatUIFragment: %d", Integer.valueOf(i2));
        if (i2 == 6) {
            Fragment apl = h.apl(com.tencent.mm.plugin.expt.hellhound.core.b.sza);
            if (apl != null) {
                i3 = apl.hashCode();
            }
            b(bnVar, i3, j2);
            AppMethodBeat.o(122077);
            return;
        }
        if (i2 == 7) {
            Dt(j2);
        }
        AppMethodBeat.o(122077);
    }

    private void b(bn bnVar, int i2, long j2) {
        cyl cyl;
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        AppMethodBeat.i(220547);
        boolean z = false;
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            String str = null;
            if (bnVar != null) {
                str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFj);
            }
            cyl a2 = a((Activity) null, str, "ChattingUIFragment", i2, j2);
            if (a2 == null) {
                Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curSession == null");
                AppMethodBeat.o(220547);
                return;
            }
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, lastPage: %s", str);
            z = true;
            cyl = a2;
        } else {
            cyl = cQo;
        }
        if (z) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart new Session: %s", Long.valueOf(j2));
            Fragment c2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
            String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
            if (c2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = c2.hashCode();
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cyl, str2, hashCode4, j2);
            cyl.iOu = 0;
            String cPR = m.cPR();
            if (cPR == null) {
                cPR = "";
            }
            cyl.kvy = cPR;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(cyl);
            e(cyl);
            AppMethodBeat.o(220547);
        } else if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arb(cyl.sessionId)) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, NOT, sessionId: %s", cyl.sessionId);
            Fragment c3 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
            String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
            if (c3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = c3.hashCode();
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cyl, str3, hashCode3, j2);
            AppMethodBeat.o(220547);
        } else {
            com.tencent.mm.vending.j.c<String, Integer> cPN = a.cPN();
            int intValue = ((Integer) cPN.get(1)).intValue();
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart: %s, %d", (String) cPN.get(0), Integer.valueOf(intValue));
            if (intValue == cyl.MDo) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType == chatType");
                if (this.sIs != 7) {
                    Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event-NOT");
                    Fragment c4 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
                    String str4 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
                    if (c4 == null) {
                        hashCode2 = 0;
                    } else {
                        hashCode2 = c4.hashCode();
                    }
                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cyl, str4, hashCode2, j2);
                    AppMethodBeat.o(220547);
                    return;
                }
                Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event");
                AppMethodBeat.o(220547);
                return;
            }
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType!=chatType: %d, %d", Integer.valueOf(intValue), Integer.valueOf(cyl.MDo));
            a(cyl, j2);
            cyl a3 = a((Activity) null, com.tencent.mm.plugin.expt.hellhound.core.b.szb, "ChattingUIFragment", i2, j2);
            if (a3 != null) {
                Fragment c5 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
                String str5 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
                if (c5 == null) {
                    hashCode = 0;
                } else {
                    hashCode = c5.hashCode();
                }
                com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(a3, str5, hashCode, j2);
                a3.iOu = 0;
                String cPR2 = m.cPR();
                if (cPR2 == null) {
                    cPR2 = "";
                }
                a3.kvy = cPR2;
                com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(a3);
                e(a3);
            }
            AppMethodBeat.o(220547);
        }
    }

    private void Dt(long j2) {
        AppMethodBeat.i(122079);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, curSession不合法");
            AppMethodBeat.o(122079);
            return;
        }
        com.tencent.mm.vending.j.c<String, Integer> cPN = a.cPN();
        int intValue = ((Integer) cPN.get(1)).intValue();
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose: %s, %d", (String) cPN.get(0), Integer.valueOf(intValue));
        if (intValue == cQo.MDo) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, ==");
            a(cQo, j2);
            AppMethodBeat.o(122079);
            return;
        }
        Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, != %d", Integer.valueOf(cQo.MDo));
        AppMethodBeat.o(122079);
    }

    public final cyl a(Activity activity, String str, String str2, int i2, long j2) {
        String a2;
        AppMethodBeat.i(220548);
        if (str2 == null) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "newSession: dstPageName is NULL");
            AppMethodBeat.o(220548);
            return null;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession: srcPageName: %s, dstPageName: %s", str, str2);
        cgh cgh = null;
        cgh cgh2 = null;
        if ("WebViewUI".equals(str2)) {
            cgh = new cgh();
            cgh.key = "minimize_secene";
            cgh.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.apk("minimize_secene");
            cgh2 = new cgh();
            cgh2.key = "KPublisherId";
            cgh2.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.apk("KPublisherId");
            ArrayList arrayList = new ArrayList();
            arrayList.add(cgh.value);
            arrayList.add(cgh2.value);
            a2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(activity, str, str2, arrayList);
            Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession(WebViewUI)sid = %s, %s", a2, Long.valueOf(j2));
        } else {
            a2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(activity, str, str2, null);
            Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession(no args)sid = %s, %s", a2, Long.valueOf(j2));
        }
        if (TextUtils.isEmpty(a2)) {
            AppMethodBeat.o(220548);
            return null;
        }
        cyl cyl = new cyl();
        cyl.sessionId = a2 + "_" + j2;
        cyl.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQm();
        cyl.MDn = str2;
        cyl.MDu = i2;
        cyl.MDq = str;
        cyl.startTime = j2;
        if ("WebViewUI".equals(cyl.MDn)) {
            cyl.MDp = new cyi();
            cyl.MDp.MDh.add(cgh);
            cyl.MDp.MDh.add(cgh2);
        } else {
            if ("ChattingUI".equals(cyl.MDn)) {
                com.tencent.mm.vending.j.c<String, Integer> cPM = a.cPM();
                cyl.userName = (String) cPM.get(0);
                cyl.MDo = ((Integer) cPM.get(1)).intValue();
            } else if ("ChattingUIFragment".equals(cyl.MDn)) {
                com.tencent.mm.vending.j.c<String, Integer> cPN = a.cPN();
                cyl.userName = (String) cPN.get(0);
                cyl.MDo = ((Integer) cPN.get(1)).intValue();
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(cyl);
            Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession, %s", cyl.sessionId);
        }
        cyl.MDs = str2;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession: %s, %s", cyl.sessionId, cyl.MDs);
        this.sIr = cyl.sessionId;
        AppMethodBeat.o(220548);
        return cyl;
    }

    private static com.tencent.mm.vending.j.c<String, String> b(bn bnVar, int i2, bn bnVar2) {
        String str;
        String str2;
        AppMethodBeat.i(122081);
        if (bnVar == null) {
            AppMethodBeat.o(122081);
            return null;
        }
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFh.activityName);
        if (i2 == 4) {
            str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFi);
            if (!TextUtils.isEmpty(bnVar.KFj) && bnVar2 != null && !TextUtils.isEmpty(bnVar2.KFj)) {
                str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar2.KFj);
            }
            str2 = null;
        } else if (i2 == 5) {
            str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bnVar.KFj);
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_getCurLastFragment, EVENT_FRAGMENT_OUT: %s", str);
            str2 = null;
        } else {
            str2 = null;
            str = null;
        }
        if (str2 != null) {
            aoE = str2;
        }
        com.tencent.mm.vending.j.c<String, String> Q = com.tencent.mm.vending.j.a.Q(str, aoE);
        AppMethodBeat.o(122081);
        return Q;
    }

    public static void e(cyl cyl) {
        AppMethodBeat.i(122082);
        if (cyl == null) {
            AppMethodBeat.o(122082);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart: %s, %s, %s", cyl.sessionId, Long.valueOf(cyl.startTime), cyl.kvy);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.k.a(cyl);
        m.add(cyl.sessionId);
        l.o(cyl);
        com.tencent.mm.plugin.expt.hellhound.a.d.a aVar = com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW;
        com.tencent.mm.plugin.expt.hellhound.a.d.a.aqa(cyl.sessionId);
        am(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cyl.sessionId), cyl.startTime);
        AppMethodBeat.o(122082);
    }

    public final void a(cyl cyl, long j2) {
        AppMethodBeat.i(122084);
        if (cyl == null) {
            Log.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession == null");
            AppMethodBeat.o(122084);
        } else if (!cyl.MDr || cyl.iOu != 1) {
            cbl cQH = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cQH();
            if (!cQH.Mhn.isEmpty()) {
                cbm last = cQH.Mhn.getLast();
                if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(last.dRM)) {
                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.b(last);
                }
            }
            cyl.endTime = j2;
            cyl.iOu = 1;
            com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(cyl);
            Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose temp: %s, %s, %s, %b, %d", cyl.sessionId, Long.valueOf(cyl.startTime), Long.valueOf(cyl.endTime), Boolean.valueOf(cyl.MDr), Integer.valueOf(cyl.iOu));
            com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(cyl.MDn, j2, com.tencent.mm.plugin.expt.hellhound.a.d.g.MATCH_PAGE_SESSION_CLOSE);
            an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cyl.sessionId), j2);
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.n(cyl);
            if (cyl.MDt) {
                ao(cyl.sessionId, j2);
            }
            com.tencent.mm.plugin.expt.hellhound.a.e.a.cPL();
            com.tencent.mm.plugin.expt.hellhound.a.b.b.k.b(cyl);
            f(cyl);
            AppMethodBeat.o(122084);
        } else {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: The Repeated sesson close Event: %s", cyl.sessionId);
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aqH(cyl.sessionId);
            AppMethodBeat.o(122084);
        }
    }

    private static void f(cyl cyl) {
        AppMethodBeat.i(220549);
        if (cyl.sessionId.startsWith("143") && !com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEl) {
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte) 0);
            bVar.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
            bVar.dMl = "All";
            bVar.sGC = cyl.startTime;
            bVar.sGD = cyl.endTime;
            bVar.sGB = cyl.endTime - cyl.startTime;
            bVar.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
            bVar.sGF = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cyl.sessionId);
            bVar.dYn = c.b.INOUT.value;
            com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(bVar);
        }
        AppMethodBeat.o(220549);
    }

    private static void g(cyl cyl) {
        String str;
        AppMethodBeat.i(177388);
        Object[] objArr = new Object[1];
        if (cyl == null) {
            str = "NULL";
        } else {
            str = cyl.sessionId;
        }
        objArr[0] = str;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, report: %s", objArr);
        cbo cQs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
        if (cQs == null) {
            AppMethodBeat.o(177388);
            return;
        }
        cbl cQH = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cQH();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(cQs);
        i.c(cQs, cQH, cyl);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQn();
        com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
        AppMethodBeat.o(177388);
    }

    public final String cPQ() {
        AppMethodBeat.i(220550);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo != null) {
            String aqn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cQo.sessionId);
            if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqu(cQo.sessionId)) {
                aqn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.k(cQo);
            }
            AppMethodBeat.o(220550);
            return aqn;
        }
        String str = null;
        if (this.sIr != null) {
            str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(this.sIr);
        }
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(220550);
            return "-2";
        }
        AppMethodBeat.o(220550);
        return str;
    }

    public final String cPR() {
        AppMethodBeat.i(122086);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo() || !com.tencent.mm.plugin.expt.hellhound.a.cNq() || com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0) {
            AppMethodBeat.o(122086);
            return "-1";
        }
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo != null) {
            String str = cQo.sessionId;
            AppMethodBeat.o(122086);
            return str;
        } else if (this.sIr == null) {
            AppMethodBeat.o(122086);
            return "-2";
        } else {
            String str2 = this.sIr;
            AppMethodBeat.o(122086);
            return str2;
        }
    }

    public static Pair<String, String> cPS() {
        AppMethodBeat.i(220551);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo() || !com.tencent.mm.plugin.expt.hellhound.a.cNq() || com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0) {
            AppMethodBeat.o(220551);
            return null;
        }
        dvn cQF = m.cQF();
        if (cQF == null || cQF.Mhr.isEmpty()) {
            cbo cQs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
            if (cQs == null) {
                AppMethodBeat.o(220551);
                return null;
            }
            int size = cQs.Mhr.size();
            if (size <= 0) {
                Pair<String, String> a2 = a((cyl) null, (cyl) null, cQs);
                AppMethodBeat.o(220551);
                return a2;
            } else if (size < 2) {
                Pair<String, String> a3 = a(cQs.Mhr.getLast(), (cyl) null, cQs);
                AppMethodBeat.o(220551);
                return a3;
            } else if (size == 2) {
                cyl last = cQs.Mhr.getLast();
                cyl cyl = cQs.Mhr.get(0);
                if (last.sessionId.equals(cyl.sessionId)) {
                    cyl = null;
                }
                Pair<String, String> a4 = a(last, cyl, cQs);
                AppMethodBeat.o(220551);
                return a4;
            } else {
                cyl last2 = cQs.Mhr.getLast();
                for (int i2 = size - 2; i2 >= 0; i2--) {
                    cyl cyl2 = cQs.Mhr.get(i2);
                    if (!last2.sessionId.equals(cyl2.sessionId)) {
                        Pair<String, String> a5 = a(last2, cyl2, cQs);
                        AppMethodBeat.o(220551);
                        return a5;
                    }
                }
                Pair<String, String> a6 = a(last2, (cyl) null, cQs);
                AppMethodBeat.o(220551);
                return a6;
            }
        } else {
            int size2 = cQF.Mhr.size();
            if (size2 < 2) {
                Pair<String, String> create = Pair.create(cQF.Mhr.getLast(), cQF.Mhr.getLast());
                AppMethodBeat.o(220551);
                return create;
            } else if (size2 == 2) {
                Pair<String, String> create2 = Pair.create(cQF.Mhr.getLast(), cQF.Mhr.get(size2 - 2));
                AppMethodBeat.o(220551);
                return create2;
            } else {
                String last3 = cQF.Mhr.getLast();
                String str = last3;
                for (int i3 = size2 - 2; i3 >= 0; i3--) {
                    str = cQF.Mhr.get(i3);
                    if (!last3.equals(str)) {
                        Pair<String, String> create3 = Pair.create(last3, str);
                        AppMethodBeat.o(220551);
                        return create3;
                    }
                }
                Pair<String, String> create4 = Pair.create(last3, str);
                AppMethodBeat.o(220551);
                return create4;
            }
        }
    }

    private static Pair<String, String> a(cyl cyl, cyl cyl2, cbo cbo) {
        AppMethodBeat.i(220552);
        int size = cbo.Mht.size();
        if (cyl == null && cyl2 == null) {
            if (size <= 0) {
                AppMethodBeat.o(220552);
                return null;
            } else if (size < 2) {
                cyh last = cbo.Mht.getLast();
                Pair<String, String> create = Pair.create(last.dMl + "_" + last.startTime, null);
                AppMethodBeat.o(220552);
                return create;
            } else if (size == 2) {
                cyh last2 = cbo.Mht.getLast();
                cyh cyh = cbo.Mht.get(0);
                Pair<String, String> create2 = Pair.create(last2.dMl + "_" + last2.startTime, cyh.dMl + "_" + cyh.startTime);
                AppMethodBeat.o(220552);
                return create2;
            } else {
                cyh last3 = cbo.Mht.getLast();
                for (int i2 = size - 2; i2 >= 0; i2--) {
                    cyh cyh2 = cbo.Mht.get(i2);
                    if (!last3.dMl.equals(cyh2.dMl)) {
                        Pair<String, String> create3 = Pair.create(last3.dMl + "_" + last3.startTime, cyh2.dMl + "_" + cyh2.startTime);
                        AppMethodBeat.o(220552);
                        return create3;
                    }
                }
                cyh cyh3 = cbo.Mht.get(size - 2);
                Pair<String, String> create4 = Pair.create(last3.dMl + "_" + last3.startTime, cyh3.dMl + "_" + cyh3.startTime);
                AppMethodBeat.o(220552);
                return create4;
            }
        } else if (cyl == null || cyl2 != null) {
            if (cyl == null) {
                AppMethodBeat.o(220552);
                return null;
            } else if (size <= 0) {
                Pair<String, String> create5 = Pair.create(cyl.sessionId, cyl2.sessionId);
                AppMethodBeat.o(220552);
                return create5;
            } else if (size < 2) {
                cyh last4 = cbo.Mht.getLast();
                if (last4.startTime > cyl.startTime) {
                    Pair<String, String> create6 = Pair.create(last4.dMl + "_" + last4.startTime, cyl.sessionId);
                    AppMethodBeat.o(220552);
                    return create6;
                } else if (last4.startTime > cyl2.startTime) {
                    Pair<String, String> create7 = Pair.create(cyl.sessionId, last4.dMl + "_" + last4.startTime);
                    AppMethodBeat.o(220552);
                    return create7;
                } else {
                    Pair<String, String> create8 = Pair.create(cyl.sessionId, cyl2.sessionId);
                    AppMethodBeat.o(220552);
                    return create8;
                }
            } else {
                cyh last5 = cbo.Mht.getLast();
                cyh cyh4 = cbo.Mht.get(size - 2);
                if (last5.startTime <= cyl.startTime) {
                    if (last5.startTime <= cyl2.startTime) {
                        Pair<String, String> create9 = Pair.create(cyl.sessionId, cyl2.sessionId);
                        AppMethodBeat.o(220552);
                        return create9;
                    }
                    Pair<String, String> create10 = Pair.create(cyl.sessionId, last5.dMl + "_" + last5.startTime);
                    AppMethodBeat.o(220552);
                    return create10;
                } else if (cyl.startTime >= cyh4.startTime) {
                    Pair<String, String> create11 = Pair.create(last5.dMl + "_" + last5.startTime, cyl.sessionId);
                    AppMethodBeat.o(220552);
                    return create11;
                } else {
                    Pair<String, String> create12 = Pair.create(last5.dMl + "_" + last5.startTime, cyh4.dMl + "_" + cyh4.startTime);
                    AppMethodBeat.o(220552);
                    return create12;
                }
            }
        } else if (size <= 0) {
            Pair<String, String> create13 = Pair.create(cyl.sessionId, null);
            AppMethodBeat.o(220552);
            return create13;
        } else if (size < 2) {
            cyh last6 = cbo.Mht.getLast();
            if (last6.startTime <= cyl.startTime) {
                Pair<String, String> create14 = Pair.create(cyl.sessionId, last6.dMl + "_" + last6.startTime);
                AppMethodBeat.o(220552);
                return create14;
            }
            Pair<String, String> create15 = Pair.create(last6.dMl + "_" + last6.startTime, cyl.sessionId);
            AppMethodBeat.o(220552);
            return create15;
        } else if (size == 2) {
            cyh last7 = cbo.Mht.getLast();
            cyh cyh5 = cbo.Mht.get(size - 2);
            if (last7.startTime <= cyl.startTime) {
                Pair<String, String> create16 = Pair.create(cyl.sessionId, last7.dMl + "_" + last7.startTime);
                AppMethodBeat.o(220552);
                return create16;
            } else if (cyh5.startTime <= cyl.startTime) {
                Pair<String, String> create17 = Pair.create(last7.dMl + "_" + last7.startTime, cyl.sessionId);
                AppMethodBeat.o(220552);
                return create17;
            } else {
                Pair<String, String> create18 = Pair.create(last7.dMl + "_" + last7.startTime, cyh5.dMl + "_" + cyh5.startTime);
                AppMethodBeat.o(220552);
                return create18;
            }
        } else {
            cyh last8 = cbo.Mht.getLast();
            if (last8.startTime <= cyl.startTime) {
                Pair<String, String> create19 = Pair.create(cyl.sessionId, last8.dMl + "_" + last8.startTime);
                AppMethodBeat.o(220552);
                return create19;
            }
            cyh cyh6 = cbo.Mht.get(size - 2);
            if (cyh6.startTime <= cyl.startTime) {
                Pair<String, String> create20 = Pair.create(last8.dMl + "_" + last8.startTime, cyl.sessionId);
                AppMethodBeat.o(220552);
                return create20;
            } else if (!last8.dMl.equals(cyh6.dMl)) {
                Pair<String, String> create21 = Pair.create(last8.dMl + "_" + last8.startTime, cyh6.dMl + "_" + cyh6.startTime);
                AppMethodBeat.o(220552);
                return create21;
            } else {
                for (int i3 = size - 2; i3 >= 0; i3--) {
                    cyh cyh7 = cbo.Mht.get(i3);
                    if (cyh7.dMl.equals(last8.dMl)) {
                        if (cyh7.startTime <= cyl.startTime) {
                            Pair<String, String> create22 = Pair.create(last8.dMl + "_" + last8.startTime, cyl.sessionId);
                            AppMethodBeat.o(220552);
                            return create22;
                        }
                    } else if (cyh7.startTime <= cyl.startTime) {
                        Pair<String, String> create23 = Pair.create(last8.dMl + "_" + last8.startTime, cyl.sessionId);
                        AppMethodBeat.o(220552);
                        return create23;
                    } else {
                        Pair<String, String> create24 = Pair.create(last8.dMl + "_" + last8.startTime, cyh7.dMl + "_" + cyh7.startTime);
                        AppMethodBeat.o(220552);
                        return create24;
                    }
                }
                Pair<String, String> create25 = Pair.create(last8.dMl + "_" + last8.startTime, cyl.sessionId);
                AppMethodBeat.o(220552);
                return create25;
            }
        }
    }

    private static void am(String str, long j2) {
        AppMethodBeat.i(220553);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "notify session start [%s] [%d]", str, Long.valueOf(j2));
        uc ucVar = new uc();
        ucVar.eav.sessionId = str;
        ucVar.eav.eaw = j2;
        ucVar.eav.type = 0;
        EventCenter.instance.publish(ucVar);
        AppMethodBeat.o(220553);
    }

    private static void an(String str, long j2) {
        AppMethodBeat.i(220554);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "notify session close [%s] [%d]", str, Long.valueOf(j2));
        uc ucVar = new uc();
        ucVar.eav.sessionId = str;
        ucVar.eav.eaw = j2;
        ucVar.eav.type = 1;
        EventCenter.instance.publish(ucVar);
        AppMethodBeat.o(220554);
    }

    public static Map<Long, Long> aqj(String str) {
        HashMap hashMap;
        AppMethodBeat.i(122087);
        List<cbm> aqQ = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aqQ(str);
        if (aqQ == null || aqQ.isEmpty()) {
            AppMethodBeat.o(122087);
            return null;
        }
        String aqn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(str);
        if (aqn == null) {
            hashMap = null;
        } else {
            List<dvk> aqw = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqw(aqn);
            if (aqw == null || aqw.isEmpty()) {
                hashMap = null;
            } else {
                HashMap hashMap2 = new HashMap();
                for (cbm cbm : aqQ) {
                    Map<Long, dvi> a2 = i.a(cbm, aqw);
                    if (a2 != null) {
                        for (Map.Entry<Long, dvi> entry : a2.entrySet()) {
                            long longValue = entry.getKey().longValue();
                            dvi value = entry.getValue();
                            if (hashMap2.containsKey(Long.valueOf(longValue))) {
                                dvi dvi = (dvi) hashMap2.get(Long.valueOf(longValue));
                                if (dvi != null) {
                                    if (value.index < 0) {
                                        dvi.MWp.clear();
                                        hashMap2.remove(Long.valueOf(longValue));
                                    } else if (value.index == 0) {
                                        dvi.MWp.clear();
                                        dvi.MWp.add(cbm);
                                    } else {
                                        dvi.MWp.add(cbm);
                                    }
                                }
                            } else if (value.index >= 0 && !value.MWo) {
                                dvi dvi2 = new dvi();
                                dvi2.index = value.index;
                                dvi2.LPM = value.LPM;
                                dvi2.vtY = value.vtY;
                                dvi2.LPN = longValue;
                                dvi2.dRM = str;
                                dvi2.MWp.add(cbm);
                                hashMap2.put(Long.valueOf(longValue), dvi2);
                            }
                        }
                    }
                }
                hashMap = hashMap2;
            }
        }
        if (hashMap == null || hashMap.isEmpty()) {
            AppMethodBeat.o(122087);
            return null;
        }
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry2 : hashMap.entrySet()) {
            LinkedList<cbm> linkedList = ((dvi) entry2.getValue()).MWp;
            if (linkedList != null && !linkedList.isEmpty()) {
                hashMap3.put(entry2.getKey(), Long.valueOf(linkedList.get(0).startTime));
            }
        }
        AppMethodBeat.o(122087);
        return hashMap3;
    }

    public static Map<Long, Long> aqk(String str) {
        HashMap hashMap;
        AppMethodBeat.i(185583);
        List<cbm> aqQ = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aqQ(str);
        if (aqQ == null || aqQ.isEmpty()) {
            aqQ = com.tencent.mm.plugin.expt.hellhound.a.f.c.j.aqO(str);
        }
        if (aqQ == null || aqQ.isEmpty()) {
            AppMethodBeat.o(185583);
            return null;
        }
        String aqn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(str);
        if (aqn == null) {
            hashMap = null;
        } else {
            List<dvk> aqw = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqw(aqn);
            if (aqw == null || aqw.isEmpty()) {
                hashMap = null;
            } else {
                HashMap hashMap2 = new HashMap();
                for (cbm cbm : aqQ) {
                    Map<Long, dvi> a2 = i.a(cbm, aqw);
                    if (a2 != null) {
                        for (Map.Entry<Long, dvi> entry : a2.entrySet()) {
                            long longValue = entry.getKey().longValue();
                            dvi value = entry.getValue();
                            if (hashMap2.containsKey(Long.valueOf(longValue))) {
                                if (value.MWo) {
                                    dvi dvi = (dvi) hashMap2.get(Long.valueOf(longValue));
                                    if (dvi == null) {
                                        dvi = new dvi();
                                        hashMap2.put(Long.valueOf(longValue), dvi);
                                    }
                                    dvi.MWp.add(cbm);
                                }
                            } else if (value.MWo) {
                                dvi dvi2 = new dvi();
                                dvi2.index = value.index;
                                dvi2.LPM = value.LPM;
                                dvi2.vtY = value.vtY;
                                dvi2.LPN = longValue;
                                dvi2.dRM = str;
                                dvi2.MWp.add(cbm);
                                hashMap2.put(Long.valueOf(longValue), dvi2);
                            }
                        }
                    }
                }
                hashMap = hashMap2;
            }
        }
        if (hashMap == null || hashMap.isEmpty()) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "getMatchedSessionPages, Empty !!");
            AppMethodBeat.o(185583);
            return null;
        }
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry2 : hashMap.entrySet()) {
            LinkedList<cbm> linkedList = ((dvi) entry2.getValue()).MWp;
            if (linkedList != null && !linkedList.isEmpty()) {
                hashMap3.put(entry2.getKey(), Long.valueOf(linkedList.get(0).startTime));
            }
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.c.j.akH(str);
        AppMethodBeat.o(185583);
        return hashMap3;
    }

    public final void b(boolean z, String str, long j2) {
        AppMethodBeat.i(220555);
        if (z) {
            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
            if ("AppBrandLaunchProxyUI".equals(aoE) || "AppBrandPreLoadingUI".equals(aoE)) {
                AppMethodBeat.o(220555);
                return;
            }
        }
        Log.w("HABBYGE-MALI.HellSessionMonitor", "onFloatSessionExit: %b, %s", Boolean.valueOf(z), str);
        a.g(z, j2);
        AppMethodBeat.o(220555);
    }

    private static void a(cyl cyl, String str) {
        AppMethodBeat.i(122066);
        if (cyl == null) {
            AppMethodBeat.o(122066);
            return;
        }
        if (cyl.sessionId.startsWith("142")) {
            if (str == null || com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str)) {
                boolean b2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.b(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.syZ);
                Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isActive: %b", Boolean.valueOf(b2));
                if (!b2) {
                    AppMethodBeat.o(122066);
                    return;
                }
            } else {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isStoryGalleryViewShow: FALSE");
            }
        }
        cbo cbo = new cbo();
        cyl cyl2 = new cyl();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(cyl);
        cyl2.sessionId = cyl.sessionId;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, curSession.session: %s", cyl.sessionId);
        cyl2.MDr = true;
        cyl2.iOu = 1;
        cyl2.MDt = cyl.MDt;
        cyl2.MDn = cyl.MDn;
        cyl2.MDo = cyl.MDo;
        cyl2.userName = cyl.userName;
        cyl2.MDp = cyl.MDp;
        cyl2.MDq = cyl.MDq;
        cyl2.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQm();
        cbo.Mhr.addLast(cyl2);
        cbo.Mhs = cbo.Mhr.size() - 1;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession.session: %s, %s", cyl2.sessionId, cyl2.MDn);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(cbo);
        AppMethodBeat.o(122066);
    }

    private void h(cyl cyl) {
        if (cyl != null) {
            this.sIv = cyl;
        }
    }

    private void ao(String str, long j2) {
        AppMethodBeat.i(220556);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cNT() == 8) {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession 8Event!!");
            this.sIv = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aqG(str);
            AppMethodBeat.o(220556);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: %s", str);
        cyl aqG = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aqG(str);
        if (aqG == null) {
            if (this.sIv != null) {
                Log.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, mLastSession4Nested: %s", this.sIv.sessionId);
                aqG = this.sIv;
            } else {
                Log.e("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: LastSession NULL !!");
                AppMethodBeat.o(220556);
                return;
            }
        }
        aqG.iOu = 0;
        aqG.MDt = false;
        aqG.startTime = j2;
        aqG.endTime = 0;
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(aqG.MDn);
        if (aoE != null && !aoE.equals("LauncherUI")) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(aqG, aoE, aqG.MDu, j2);
        }
        String cPR = m.cPR();
        if (cPR == null) {
            cPR = "";
        }
        aqG.kvy = cPR;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(aqG);
        e(aqG);
        AppMethodBeat.o(220556);
    }

    private void v(String str, int i2, long j2) {
        cyl cyl;
        dvl cQD;
        AppMethodBeat.i(220542);
        cbo cQs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
        if (cQs == null) {
            cQs = new cbo();
        }
        cQs.Mhp = j2;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(cQs);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, 无Session: %s", str);
            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
            if (!"LauncherUI".equals(aoE)) {
                w(aoE, i2, j2);
                com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl) null, aoE, i2, j2);
            }
        } else if (cQo.MDr) {
            cbm cQL = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQL();
            if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(cQo.sessionId) && cQL != null) {
                String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
                Log.w("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, lstItem: %s, %s, %s", cQL.dRM, cQL.dMl, aoE2);
                if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(cQL.dRM)) {
                    dvl cQD2 = l.cQD();
                    boolean z = cQD2 == null || !cQD2.MWw;
                    if (cQL.dMl.equals("FloatBall") || ((com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(cQL.dMl) && z) || (cQL.dMl.equals(aoE2) && !aoE2.equals("WebViewUI") && !aoE2.equals("WebviewMpUI")))) {
                        cQo.startTime = j2;
                        cQo.endTime = j2;
                        cQo.MDn = "FloatBall";
                        cQo.iOu = 1;
                        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cQo);
                        a(cQo, j2);
                        AppMethodBeat.o(220542);
                        return;
                    }
                }
            }
            if (cQL == null || !com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(cQo.sessionId) || (cQD = l.cQD()) == null || !com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(cQL.dMl) || !"FloatingBall".equals(cQo.MDn) || !cQD.MWw || cQD.MWs == null) {
                cyl = cQo;
            } else {
                Log.e("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, floatSession, lastSession: %s", cQD.MWs);
                cyl = cQD.MWs;
            }
            cyl.MDr = false;
            cyl.iOu = 0;
            cyl.startTime = j2;
            String cPR = m.cPR();
            if (cPR == null) {
                cPR = "";
            }
            cyl.kvy = cPR;
            Log.i("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, curSession: %s, %s", cyl.MDn, str);
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(cyl, str, i2, j2);
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cyl);
            e(cyl);
            Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, curSession: %s, %s, %s, %d", cyl.sessionId, cyl.MDn, cyl.MDq, Integer.valueOf(cyl.MDo));
            AppMethodBeat.o(220542);
            return;
        }
        AppMethodBeat.o(220542);
    }
}

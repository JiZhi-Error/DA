package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.j;
import com.tencent.mm.g.a.aal;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.c.c;
import com.tencent.mm.plugin.expt.hellhound.a.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.d.g;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public final class b implements d {
    private static final d.a syR = new d.a() {
        /* class com.tencent.mm.plugin.expt.hellhound.b.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void d(String str, int i2, long j2) {
            AppMethodBeat.i(220388);
            a.sHW.a(str, j2, g.MATCH_PAGE_FINISH);
            com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl().af(str, j2);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(true, str, j2);
            c.a(103, str, i2, j2);
            k.apO(str);
            k.apQ(str);
            k.apV(str);
            AppMethodBeat.o(220388);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void e(String str, int i2, long j2) {
            AppMethodBeat.i(220389);
            a.sHW.a(str, j2, g.MATCH_PAGE_FINISH);
            com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl().af(str, j2);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(true, str, j2);
            c.a(103, str, i2, j2);
            k.apO(str);
            k.apQ(str);
            k.apV(str);
            AppMethodBeat.o(220389);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void aog(String str) {
            AppMethodBeat.i(220390);
            com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arc(str);
            AppMethodBeat.o(220390);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void aoh(String str) {
            AppMethodBeat.i(220391);
            com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arc(str);
            AppMethodBeat.o(220391);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void f(String str, int i2, long j2) {
            Fragment apm;
            AppMethodBeat.i(220392);
            c.a(100, str, i2, j2);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.t(str, i2, j2);
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo(), str, i2, j2);
            a.sHW.a(str, j2, g.MATCH_PAGE_RESUME);
            if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str) && (apm = h.apm(str)) != null) {
                String simpleName = apm.getClass().getSimpleName();
                if (!"ChattingUIFragment".equals(simpleName)) {
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(simpleName);
                }
            }
            AppMethodBeat.o(220392);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void g(String str, int i2, long j2) {
            AppMethodBeat.i(220393);
            c.a(101, str, i2, j2);
            AppMethodBeat.o(220393);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void h(String str, int i2, long j2) {
            AppMethodBeat.i(220394);
            c.a(102, str, i2, j2);
            AppMethodBeat.o(220394);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void dj(String str, int i2) {
            AppMethodBeat.i(220395);
            com.tencent.mm.plugin.expt.hellhound.a.f.e.a.dp(str, i2);
            com.tencent.mm.plugin.expt.hellhound.a.f.e.c.dp(str, i2);
            com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str))) {
                com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c cVar = cPO.sIq;
                Log.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, stopMonitor");
                com.tencent.mm.hellhoundlib.a.axP();
                com.tencent.mm.hellhoundlib.a.b(cVar.sIU, cVar.sIV);
            }
            com.tencent.mm.plugin.expt.hellhound.a.f.g.a.ard(str);
            AppMethodBeat.o(220395);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void aoi(String str) {
            AppMethodBeat.i(220396);
            Log.i("HABBYGE-MALI.HellhoundService", "onResumed: %s", str);
            AppMethodBeat.o(220396);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void aoj(String str) {
            AppMethodBeat.i(220397);
            Log.i("HABBYGE-MALI.HellhoundService", "onPaused: %s", str);
            AppMethodBeat.o(220397);
        }

        @Override // com.tencent.mm.plugin.expt.b.d.a
        public final void aof(String str) {
            AppMethodBeat.i(184299);
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_mmkv_fbm__", new byte[0]);
            com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str))) {
                com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c cVar = cPO.sIq;
                Log.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, startMonitor");
                com.tencent.mm.hellhoundlib.a.axP();
                com.tencent.mm.hellhoundlib.a.a(cVar.sIU, cVar.sIV);
            }
            AppMethodBeat.o(184299);
        }
    };

    private b() {
    }

    public static void e(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(121834);
        if (gVar == null) {
            AppMethodBeat.o(121834);
            return;
        }
        Log.i("HABBYGE-MALI.HellhoundService", "IHellhoundService Start !!!");
        com.tencent.mm.kernel.g.b(d.class, new b());
        d dVar = (d) com.tencent.mm.kernel.g.af(d.class);
        EventCenter.instance.add(com.tencent.mm.plugin.expt.hellhound.a.f.b.c.cQa().sIA);
        EventCenter.instance.add(com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cQe().sID);
        EventCenter.instance.add(e.cQg().sIG);
        dVar.a(syR);
        dVar.a(new d.c() {
            /* class com.tencent.mm.plugin.expt.hellhound.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.expt.b.d.c
            public final void i(String str, int i2, long j2) {
                AppMethodBeat.i(220383);
                Log.i("HABBYGE-MALI.HellhoundService", "HellhoundService, backToFront: %s", str);
                a.syQ = false;
                k.n(str, i2, j2);
                com.tencent.mm.plugin.expt.hellhound.a.c.d.a(str, j.cL(String.valueOf(i2)), j2, e.a.MMActivity_Back2Front);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(str, i2, j2, 7);
                com.tencent.mm.plugin.expt.hellhound.a.b.a.a(str, Integer.valueOf(i2), 2);
                aal aal = new aal();
                aal.ehk.type = 7;
                aal.ehk.activity = str;
                aal.ehk.ehl = j2;
                EventCenter.instance.publish(aal);
                AppMethodBeat.o(220383);
            }

            @Override // com.tencent.mm.plugin.expt.b.d.c
            public final void j(String str, int i2, long j2) {
                AppMethodBeat.i(220384);
                Log.i("HABBYGE-MALI.HellhoundService", "HellhoundService, frontToBack: %s", str);
                a.syQ = true;
                k.m(str, i2, j2);
                com.tencent.mm.plugin.expt.hellhound.a.c.d.a(str, j.cL(String.valueOf(i2)), j2, e.a.MMActivity_Front2Back);
                a.sHW.a(str, j2, g.MATCH_PAGE_8_EVENT);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(str, i2, j2, 8);
                com.tencent.mm.plugin.expt.hellhound.a.b.a.a(str, Integer.valueOf(i2), 3);
                aal aal = new aal();
                aal.ehk.type = 8;
                aal.ehk.activity = str;
                aal.ehk.ehl = j2;
                EventCenter.instance.publish(aal);
                AppMethodBeat.o(220384);
            }

            @Override // com.tencent.mm.plugin.expt.b.d.c
            public final void a(String str, int i2, int i3, long j2, int i4) {
                AppMethodBeat.i(220385);
                Log.i("HABBYGE-MALI.HellhoundService", "frontToBackMMProcessEnd: %s, %d", str, Integer.valueOf(i3));
                int cL = j.cL(String.valueOf(i2));
                e.a aVar = e.a.MMActivity_Front2Back;
                gw gwVar = new gw();
                gwVar.euv = i3;
                gw uK = gwVar.uJ(com.tencent.mm.kernel.g.aAe().azG().mProcessName).uK(str);
                uK.eLd = (long) i4;
                uK.erY = (long) aVar.value;
                gw qH = uK.qH(j2);
                qH.eHx = (long) cL;
                com.tencent.mm.plugin.expt.g.e.cRy().a(qH);
                Log.i("HABBYGE-MALI.HellFrontBackReport", "[进程尾部补偿8] frontback-pure-report [%s]", qH.abW());
                a.sHW.a(str, j2, g.MATCH_PAGE_8_EVENT);
                a.sHW.a("UNDEFINED", j2, g.MATCH_PAGE_MM_PROCESS_RESTEART);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPP();
                m.reset();
                l.reset();
                AppMethodBeat.o(220385);
            }
        });
        com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
        com.tencent.mm.plugin.expt.hellhound.core.a.a(new f() {
            /* class com.tencent.mm.plugin.expt.hellhound.b.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.expt.hellhound.core.stack.f
            @Deprecated
            public final void a(Activity activity, bn bnVar, bn bnVar2) {
                AppMethodBeat.i(121805);
                Object[] objArr = new Object[2];
                objArr[0] = bnVar.KFh.activityName;
                objArr[1] = bnVar2 == null ? "NULL" : bnVar2.KFh.activityName;
                Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPush: %s, %s", objArr);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(activity, bnVar, 0, bnVar2);
                AppMethodBeat.o(121805);
            }

            @Override // com.tencent.mm.plugin.expt.hellhound.core.stack.f
            public final void a(bn bnVar, bn bnVar2) {
                AppMethodBeat.i(121806);
                Object[] objArr = new Object[3];
                objArr[0] = bnVar.KFh.activityName;
                objArr[1] = Long.valueOf(bnVar.KFh.timestamp);
                objArr[2] = bnVar2 == null ? "NULL" : bnVar2.KFh.activityName;
                Log.i("HABBYGE-MALI.HellhoundService", "onPushStackAsync: %s, %s, %s", objArr);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a((Activity) null, bnVar, 0, bnVar2);
                AppMethodBeat.o(121806);
            }

            @Override // com.tencent.mm.plugin.expt.hellhound.core.stack.f
            public final void b(bn bnVar, bn bnVar2) {
                AppMethodBeat.i(121807);
                if (bnVar == null) {
                    AppMethodBeat.o(121807);
                    return;
                }
                Object[] objArr = new Object[2];
                objArr[0] = bnVar.KFh.activityName;
                objArr[1] = bnVar2 == null ? "NULL" : bnVar2.KFh.activityName;
                Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPop: %s, %s", objArr);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a((Activity) null, bnVar, 1, bnVar2);
                com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(3, bnVar.KFh.activityName, (Activity) null);
                com.tencent.mm.plugin.expt.hellhound.a.b.a.b bVar = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
                com.tencent.mm.plugin.expt.hellhound.a.b.a.b.apq(bnVar.KFh.activityName);
                AppMethodBeat.o(121807);
            }

            @Override // com.tencent.mm.plugin.expt.hellhound.core.stack.f
            public final void c(bn bnVar, bn bnVar2) {
                AppMethodBeat.i(121808);
                if (bnVar == null) {
                    AppMethodBeat.o(121808);
                    return;
                }
                Object[] objArr = new Object[2];
                objArr[0] = bnVar.KFh.activityName;
                objArr[1] = bnVar2 == null ? "NULL" : bnVar2.KFh.activityName;
                Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPopWithSlience: %s, %s", objArr);
                a.sHW.a(bnVar.KFh.activityName, bnVar.KFh.timestamp, g.MATCH_PAGE_SLIENCE_POP_STACK);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a((Activity) null, bnVar, 2, bnVar2);
                com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(3, bnVar.KFh.activityName, (Activity) null);
                com.tencent.mm.plugin.expt.hellhound.a.b.a.b bVar = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
                com.tencent.mm.plugin.expt.hellhound.a.b.a.b.apq(bnVar.KFh.activityName);
                AppMethodBeat.o(121808);
            }

            @Override // com.tencent.mm.plugin.expt.hellhound.core.stack.f
            public final void d(bn bnVar, bn bnVar2) {
                AppMethodBeat.i(121809);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a((Activity) null, bnVar, 3, bnVar2);
                AppMethodBeat.o(121809);
            }
        });
        dVar.a(new d.b() {
            /* class com.tencent.mm.plugin.expt.hellhound.b.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.expt.b.d.b
            public final void b(String str, String str2, int i2, long j2) {
                bn bnVar;
                AppMethodBeat.i(220386);
                Log.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onResume: %s, %s", str, str2);
                com.tencent.mm.plugin.expt.hellhound.a.f.e.a.df(com.tencent.mm.plugin.expt.hellhound.core.a.cNx().cNw());
                com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                com.tencent.mm.plugin.expt.hellhound.a.f.b.d(str, str2, i2, j2);
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                bn cNR = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
                if (cNR == null) {
                    AppMethodBeat.o(220386);
                    return;
                }
                if (cNR.KFi == null || cNR.KFi.isEmpty()) {
                    cNR.KFi = str2;
                    cNR.KFm = i2;
                } else {
                    String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(cNR.KFi);
                    String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str2);
                    if (aoE == null || !aoE.equals(aoE2)) {
                        cNR.KFi = str2;
                        cNR.KFm = i2;
                    }
                }
                cNR.KFl = j2;
                bn cNQ = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNQ();
                Object[] objArr = new Object[2];
                objArr[0] = cNR.KFi;
                objArr[1] = TextUtils.isEmpty(cNR.KFj) ? cNQ == null ? "Null" : cNQ.KFh.activityName : cNR.KFj;
                Log.i("HABBYGE-MALI.HellhoundService", "fragment, in: %s, %s", objArr);
                bfi cOj = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOj();
                if (cOj == null) {
                    cOj = new bfi();
                }
                cOj.LOV = str2;
                com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(cOj);
                if (TextUtils.isEmpty(cNR.KFj)) {
                    bnVar = cNQ;
                } else {
                    bnVar = cNR;
                }
                cPO.a((Activity) null, cNR, 4, bnVar);
                String aoE3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(cNR.KFi);
                Fragment fragment = null;
                if (com.tencent.mm.plugin.expt.hellhound.core.b.aoS(aoE3)) {
                    fragment = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ(aoE3);
                } else if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(aoE3)) {
                    fragment = k.cOk();
                }
                if (fragment != null) {
                    String canonicalName = fragment.getClass().getCanonicalName();
                    Log.i("HABBYGE-MALI.HellhoundService", "fragment, onResume: %s", canonicalName);
                    a.sHW.a(canonicalName, j2, g.MATCH_PAGE_RESUME);
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(fragment, 0);
                }
                AppMethodBeat.o(220386);
            }

            @Override // com.tencent.mm.plugin.expt.b.d.b
            public final void c(String str, String str2, int i2, long j2) {
                AppMethodBeat.i(220387);
                Log.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onPause: %s, %s", str, str2);
                com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                com.tencent.mm.plugin.expt.hellhound.a.f.b.e(str, str2, i2, j2);
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                bn apc = com.tencent.mm.plugin.expt.hellhound.core.stack.g.apc(str);
                if (apc == null) {
                    AppMethodBeat.o(220387);
                    return;
                }
                if (apc.KFj == null || apc.KFj.isEmpty()) {
                    apc.KFj = str2;
                } else {
                    String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(apc.KFj);
                    String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str2);
                    if (aoE == null || !aoE.equals(aoE2)) {
                        apc.KFj = str2;
                    }
                }
                apc.KFl = j2;
                Log.i("HABBYGE-MALI.HellhoundService", "fragment, out: %s", apc.KFj);
                bfi cOj = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOj();
                if (cOj == null) {
                    cOj = new bfi();
                }
                cOj.LOU = str2;
                com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(cOj);
                String aoE3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(apc.KFj);
                Fragment fragment = null;
                if (com.tencent.mm.plugin.expt.hellhound.core.b.aoS(aoE3)) {
                    fragment = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ(aoE3);
                } else if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(aoE3)) {
                    fragment = k.cOk();
                }
                if (fragment != null) {
                    String canonicalName = fragment.getClass().getCanonicalName();
                    Log.i("HABBYGE-MALI.HellhoundService", "fragment, onPause: %s", canonicalName);
                    a.sHW.a(canonicalName, j2, g.MATCH_PAGE_FINISH);
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(fragment, 2);
                }
                cPO.a((Activity) null, apc, 5, (bn) null);
                AppMethodBeat.o(220387);
            }

            @Override // com.tencent.mm.plugin.expt.b.d.b
            public final void Dm(long j2) {
                AppMethodBeat.i(184296);
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                bn apc = com.tencent.mm.plugin.expt.hellhound.core.stack.g.apc("com.tencent.mm.ui.LauncherUI");
                if (apc == null) {
                    AppMethodBeat.o(184296);
                    return;
                }
                Log.i("HABBYGE-MALI.HellhoundService", "fragment, onChattingUIFragmentSessionEnd: %s", apc.KFj);
                Fragment aoQ = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(apc.KFj));
                if (aoQ != null) {
                    String canonicalName = aoQ.getClass().getCanonicalName();
                    Log.i("HABBYGE-MALI.HellhoundService", "chat fragment, onPause: %s", canonicalName);
                    a.sHW.a(canonicalName, j2, g.MATCH_PAGE_FINISH);
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(aoQ, 2);
                }
                apc.KFl = j2;
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a((Activity) null, apc, 7, (bn) null);
                AppMethodBeat.o(184296);
            }

            @Override // com.tencent.mm.plugin.expt.b.d.b
            public final void R(int i2, long j2) {
                AppMethodBeat.i(184297);
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().i(8, i2, j2);
                Fragment aoQ = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ("MoreTabUI");
                if (aoQ != null) {
                    Log.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewResume: MoreTabUI");
                    a.sHW.a(com.tencent.mm.plugin.expt.hellhound.core.b.syZ, j2, g.MATCH_PAGE_RESUME);
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(aoQ, 0);
                }
                AppMethodBeat.o(184297);
            }

            @Override // com.tencent.mm.plugin.expt.b.d.b
            public final void S(int i2, long j2) {
                AppMethodBeat.i(184298);
                Fragment aoQ = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ("MoreTabUI");
                if (aoQ != null) {
                    Log.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewPause: MoreTabUI");
                    a.sHW.a(com.tencent.mm.plugin.expt.hellhound.core.b.syZ, j2, g.MATCH_PAGE_FINISH);
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(aoQ, 2);
                }
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().i(9, i2, j2);
                AppMethodBeat.o(184298);
            }
        });
        dVar.k(gVar.ca);
        c.a(104, "", 0, 0);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a aVar = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().sIp;
        Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBallSessionHandler, startMonitor");
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(aVar.sIU, aVar.sIV);
        com.tencent.mm.plugin.expt.hellhound.a.h.a.startMonitor();
        com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.startMonitor();
        com.tencent.mm.plugin.expt.hellhound.a.e.a.cMH();
        com.tencent.mm.plugin.expt.hellhound.core.b.c.e eVar = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAU;
        com.tencent.mm.plugin.expt.hellhound.core.b.c.f fVar = (com.tencent.mm.plugin.expt.hellhound.core.b.c.f) com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAQ.getValue();
        fVar.sAr = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAT;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("onClick", "(Landroid/view/View;)V"));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("android/view/View$OnClickListener", arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Pair("onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z"));
        linkedHashMap.put("android/view/View$OnDragListener", arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new Pair("onLongClick", "(Landroid/view/View;)Z"));
        linkedHashMap.put("android/view/View$OnLongClickListener", arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new Pair("onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z"));
        linkedHashMap.put("android/view/View$OnKeyListener", arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new Pair("onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z"));
        linkedHashMap.put("android/view/View$OnTouchListener", arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new Pair("onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z"));
        linkedHashMap.put("android/view/View$OnHoverListener", arrayList6);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(new Pair("onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V"));
        linkedHashMap.put("android/widget/AdapterView$OnItemClickListener", arrayList7);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(new Pair("onItemLongClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V"));
        linkedHashMap.put("android/widget/AdapterView$OnItemLongClickListener", arrayList8);
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(new Pair("onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V"));
        linkedHashMap.put("android/widget/AdapterView$OnItemSelectedListener", arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(new Pair("onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V"));
        linkedHashMap.put("android/support/v7/widget/RecyclerView$OnItemTouchListener", arrayList10);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(linkedHashMap, fVar.sBa);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", arrayList11);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(linkedHashMap2, fVar.sBc);
        com.tencent.mm.plugin.expt.hellhound.core.b.c.a aVar2 = (com.tencent.mm.plugin.expt.hellhound.core.b.c.a) com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAR.getValue();
        aVar2.sAr = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAT;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(new Pair("onSingleTapUp", "(Landroid/view/MotionEvent;)Z"));
        arrayList12.add(new Pair(e.a.NAME, "(Landroid/view/MotionEvent;)V"));
        linkedHashMap3.put("android/view/GestureDetector$OnGestureListener", arrayList12);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(new Pair("onDoubleTap", "(Landroid/view/MotionEvent;)Z"));
        linkedHashMap3.put("android/view/GestureDetector$OnDoubleTapListener", arrayList13);
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(new Pair("onContextClick", "(Landroid/view/MotionEvent;)Z"));
        linkedHashMap3.put("android/view/GestureDetector$OnContextClickListener", arrayList14);
        ArrayList arrayList15 = new ArrayList();
        arrayList15.add(new Pair("onSingleTapUp", "(Landroid/view/MotionEvent;)Z"));
        arrayList15.add(new Pair(e.a.NAME, "(Landroid/view/MotionEvent;)V"));
        arrayList15.add(new Pair("onDoubleTap", "(Landroid/view/MotionEvent;)Z"));
        arrayList15.add(new Pair("onContextClick", "(Landroid/view/MotionEvent;)Z"));
        linkedHashMap3.put("android/view/GestureDetector$SimpleOnGestureListener", arrayList15);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(linkedHashMap3, aVar2.sAv);
        ArrayList arrayList16 = new ArrayList();
        arrayList16.add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        linkedHashMap4.put("android/view/GestureDetector", arrayList16);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(linkedHashMap4, aVar2.sAu);
        k kVar = k.sFY;
        k.cMH();
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a aVar3 = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.szV;
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.cMH();
        com.tencent.mm.plugin.expt.c.b.cMH();
        com.tencent.mm.plugin.expt.c.a aVar4 = com.tencent.mm.plugin.expt.c.a.sxl;
        com.tencent.mm.plugin.expt.c.a.cMH();
        com.tencent.mm.plugin.expt.c.c.cMH();
        AppMethodBeat.o(121834);
    }

    @Override // com.tencent.mm.plugin.expt.b.d
    public final void a(d.a aVar) {
        AppMethodBeat.i(121835);
        com.tencent.mm.plugin.expt.hellhound.core.a.cNx().syT.a(aVar);
        AppMethodBeat.o(121835);
    }

    @Override // com.tencent.mm.plugin.expt.b.d
    public final void a(d.c cVar) {
        AppMethodBeat.i(121836);
        c.cPx().sHQ = cVar;
        AppMethodBeat.o(121836);
    }

    @Override // com.tencent.mm.plugin.expt.b.d
    public final void a(d.b bVar) {
        AppMethodBeat.i(121837);
        com.tencent.mm.plugin.expt.hellhound.core.a.cNx().syU.b(bVar);
        AppMethodBeat.o(121837);
    }

    @Override // com.tencent.mm.plugin.expt.b.d
    public final void k(Application application) {
        AppMethodBeat.i(121838);
        com.tencent.mm.plugin.expt.hellhound.core.a cNx = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
        Log.i("HABBYGE-MALI.HellhoundMonitor", "Hellhound.startMonitor()");
        cNx.syT.l(application);
        AppMethodBeat.o(121838);
    }

    static {
        AppMethodBeat.i(121839);
        AppMethodBeat.o(121839);
    }
}

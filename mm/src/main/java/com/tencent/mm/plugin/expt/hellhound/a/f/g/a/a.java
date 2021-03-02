package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    public final Map<String, List<Pair<String, String>>> sIU = new HashMap();
    public final c sIV = new C1019a((byte) 0);

    public a() {
        AppMethodBeat.i(122268);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("show", "(Landroid/animation/AnimatorListenerAdapter;)V"));
        arrayList.add(Pair.create(MessengerShareContentUtility.SHARE_BUTTON_HIDE, "(Landroid/animation/AnimatorListenerAdapter;)V"));
        this.sIU.put("com/tencent/mm/plugin/ball/view/FloatMenuView", arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Pair.create("onAttachedToWindow", "()V"));
        arrayList2.add(Pair.create("onDetachedFromWindow", "()V"));
        arrayList2.add(Pair.create("show", "(ZLandroid/animation/AnimatorListenerAdapter;)V"));
        arrayList2.add(Pair.create(MessengerShareContentUtility.SHARE_BUTTON_HIDE, "(Landroid/animation/AnimatorListenerAdapter;)V"));
        this.sIU.put("com/tencent/mm/plugin/ball/view/FloatBallView", arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Pair.create("onFloatMenuBackgroundClicked", "()V"));
        arrayList3.add(Pair.create("onFloatMenuBackPressed", "()V"));
        arrayList3.add(Pair.create("onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V"));
        arrayList3.add(Pair.create("onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V"));
        this.sIU.put("com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", arrayList3);
        AppMethodBeat.o(122268);
    }

    public static void g(boolean z, long j2) {
        AppMethodBeat.i(220596);
        b.mk(false);
        Pair<Integer, Integer> cQN = b.cQN();
        if (cQN == null) {
            AppMethodBeat.o(220596);
            return;
        }
        int intValue = ((Integer) cQN.first).intValue();
        int intValue2 = ((Integer) cQN.second).intValue();
        Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, finish: %b, %d, %d", Boolean.valueOf(z), Integer.valueOf(intValue), Integer.valueOf(intValue2));
        if (intValue != 2 || intValue2 == 3 || intValue2 == 4) {
            cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
            if (cQo == null) {
                Log.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, curSession == null");
                AppMethodBeat.o(220596);
            } else if (z) {
                String aqn = b.aqn(cQo.sessionId);
                if (aqn == null || !aqn.equals("145")) {
                    Log.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, sid: %s, %s", aqn, cQo.sessionId);
                    AppMethodBeat.o(220596);
                    return;
                }
                int method = b.getMethod();
                if (method == 3 || method == 4) {
                    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, state, read %d", Integer.valueOf(b.cQM()));
                    if (b.cQM() == 8) {
                        a(cQo, true, intValue, intValue2, j2);
                    }
                }
                AppMethodBeat.o(220596);
            } else {
                a(cQo, false, intValue, intValue2, j2);
                AppMethodBeat.o(220596);
            }
        } else {
            Log.w("HABBYGE-MALI.FloatBallSessionHandler", "FoatBall, onFloatSessionExit: onFloatMenuItemClicked");
            AppMethodBeat.o(220596);
        }
    }

    private static void a(cyl cyl, boolean z, int i2, int i3, long j2) {
        AppMethodBeat.i(184389);
        a(cyl, j2, i2, i3);
        dvl cQD = l.cQD();
        if (cQD == null) {
            AppMethodBeat.o(184389);
        } else if (cQD.MWw) {
            b(cQD.MWs, j2);
            AppMethodBeat.o(184389);
        } else {
            Log.i("HABBYGE-MALI.FloatBallSessionHandler", "_onFloatSessionExit, lastValidateSession[FALSE], finish=%b, floatClickEvent=%s, floatEventType=%s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3));
            if (!z && i2 == 1 && i3 == 1) {
                com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().w(cQD.MWt.dMl, cQD.MWt.aHK, j2);
                com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl) null, cQD.MWt.dMl, cQD.MWt.aHK, j2);
            }
            AppMethodBeat.o(184389);
        }
    }

    private static void b(cyl cyl, long j2) {
        AppMethodBeat.i(122270);
        String aqn = b.aqn(cyl.sessionId);
        if (aqn == null) {
            AppMethodBeat.o(122270);
            return;
        }
        cyl a2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(cyl, aqn + "_" + j2, j2);
        cbm aoF = com.tencent.mm.plugin.expt.hellhound.core.b.aoF(cyl.sessionId);
        if (aoF != null) {
            Log.i("HABBYGE-MALI.FloatBallSessionHandler", "restoreLastSesssion, curPage: %s", aoF.dRM);
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(a2, aoF.dMl, aoF.aHK, j2);
        }
        String cPR = m.cPR();
        if (cPR == null) {
            cPR = "";
        }
        a2.kvy = cPR;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(a2);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(a2);
        AppMethodBeat.o(122270);
    }

    private static void a(cyl cyl, long j2, int i2, int i3) {
        AppMethodBeat.i(122271);
        if (cyl == null) {
            Log.e("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, 不是合法session !!!");
            AppMethodBeat.o(122271);
            return;
        }
        Log.i("HABBYGE-MALI.FloatBallSessionHandler", "_exitFloatSession, curSession: %s, %d, %d", cyl.sessionId, Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(cyl, j2);
        AppMethodBeat.o(122271);
    }

    public static void Hp(int i2) {
        AppMethodBeat.i(220597);
        Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSession, %d", Integer.valueOf(i2));
        b.fN(-1, i2);
        b.Hq(i2);
        AppMethodBeat.o(220597);
    }

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a$a  reason: collision with other inner class name */
    static final class C1019a implements c {
        private C1019a() {
        }

        /* synthetic */ C1019a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(184388);
            if ("com/tencent/mm/plugin/ball/view/FloatMenuView".equals(str)) {
                if ("show".equals(str2) && "(Landroid/animation/AnimatorListenerAdapter;)V".equals(str3)) {
                    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(208, Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.o(184388);
                    return;
                } else if (MessengerShareContentUtility.SHARE_BUTTON_HIDE.equals(str2) && "(Landroid/animation/AnimatorListenerAdapter;)V".equals(str3)) {
                    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(211, Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.o(184388);
                    return;
                }
            } else if ("com/tencent/mm/plugin/ball/view/FloatBallView".equals(str)) {
                if ("onAttachedToWindow".equals(str2) && "()V".equals(str3)) {
                    ben ben = new ben();
                    ben.type = 5;
                    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(210, ben);
                    AppMethodBeat.o(184388);
                    return;
                } else if ("onDetachedFromWindow".equals(str2) && "()V".equals(str3)) {
                    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(212, Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.o(184388);
                    return;
                } else if ("show".equals(str2) && "(ZLandroid/animation/AnimatorListenerAdapter;)V".equals(str3)) {
                    ben ben2 = new ben();
                    ben2.type = 3;
                    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(210, ben2);
                    AppMethodBeat.o(184388);
                    return;
                }
            } else if ("onFloatMenuBackgroundClicked".equals(str2) && "()V".equals(str3)) {
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(213);
                AppMethodBeat.o(184388);
                return;
            } else if ("onFloatMenuBackPressed".equals(str2) && "()V".equals(str3)) {
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(214);
                AppMethodBeat.o(184388);
                return;
            } else if ("onFloatMenuItemClicked".equals(str2) && "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V".equals(str3)) {
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(215);
                AppMethodBeat.o(184388);
                return;
            } else if ("onFloatMenuItemRemoved".equals(str2) && "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V".equals(str3)) {
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(216);
            }
            AppMethodBeat.o(184388);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }
}

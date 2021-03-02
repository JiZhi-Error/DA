package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;

final class b {
    private final boolean szI;
    private final d szW;
    final i szX = new i() {
        /* class com.tencent.mm.plugin.expt.hellhound.core.b.b.b.AnonymousClass1 */

        {
            AppMethodBeat.i(161595);
            AppMethodBeat.o(161595);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.core.b.b.i
        public final void onEnter() {
            AppMethodBeat.i(220430);
            b.a(b.this, 1, System.currentTimeMillis());
            AppMethodBeat.o(220430);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.core.b.b.i
        public final void onExit() {
            AppMethodBeat.i(220431);
            b.a(b.this, 4, System.currentTimeMillis());
            AppMethodBeat.o(220431);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.core.b.b.i
        public final void onResume() {
            AppMethodBeat.i(220432);
            b.a(b.this, 2, System.currentTimeMillis());
            AppMethodBeat.o(220432);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.core.b.b.i
        public final void onPause() {
            AppMethodBeat.i(220433);
            b.a(b.this, 3, System.currentTimeMillis());
            AppMethodBeat.o(220433);
        }
    };

    public b(d dVar) {
        AppMethodBeat.i(121989);
        this.szW = dVar;
        this.szI = a.cNt();
        AppMethodBeat.o(121989);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void V(int i2, long j2) {
        int hashCode;
        AppMethodBeat.i(184316);
        switch (i2) {
            case 1:
                if (this.szW != null) {
                    Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentEnter");
                    a.lW(true);
                    c<FragmentActivity, Fragment> cOh = cOh();
                    if (cOh != null) {
                        FragmentActivity fragmentActivity = (FragmentActivity) cOh.get(0);
                        Fragment c2 = h.c(fragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.syW);
                        d dVar = this.szW;
                        String str = com.tencent.mm.plugin.expt.hellhound.core.b.syW;
                        if (c2 == null) {
                            hashCode = 0;
                        } else {
                            hashCode = c2.hashCode();
                        }
                        dVar.a(fragmentActivity, str, hashCode, j2, false);
                        Fragment fragment = (Fragment) cOh.get(1);
                        this.szW.a(fragmentActivity, fragment, com.tencent.mm.plugin.expt.hellhound.core.b.sza, fragment.hashCode(), j2, false);
                    }
                }
                AppMethodBeat.o(184316);
                return;
            case 2:
                Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentResume");
                c<FragmentActivity, Fragment> cOh2 = cOh();
                if (cOh2 != null) {
                    if (a.cNj()) {
                        if (a.cNl()) {
                            a.lX(false);
                            a.cNm();
                        } else {
                            a.cNk();
                        }
                    }
                    FragmentActivity fragmentActivity2 = (FragmentActivity) cOh2.get(0);
                    Fragment fragment2 = (Fragment) cOh2.get(1);
                    if (fragment2 != null) {
                        this.szW.a(fragmentActivity2, fragment2, fragment2.getClass().getCanonicalName(), fragment2.hashCode(), j2, false);
                    }
                }
                AppMethodBeat.o(184316);
                return;
            case 3:
                Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentPause");
                c<FragmentActivity, Fragment> cOh3 = cOh();
                if (cOh3 != null) {
                    a.lW(a.cNj());
                    FragmentActivity fragmentActivity3 = (FragmentActivity) cOh3.get(0);
                    Fragment fragment3 = (Fragment) cOh3.get(1);
                    if (fragment3 != null) {
                        this.szW.a(fragmentActivity3, fragment3.getClass().getCanonicalName(), fragment3.hashCode(), j2, false);
                    }
                }
                AppMethodBeat.o(184316);
                return;
            case 4:
                if (this.szW != null) {
                    Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "onChatUIFragmentExit");
                    a.lW(false);
                    a.lX(false);
                    a.cNm();
                    c<FragmentActivity, Fragment> cOh4 = cOh();
                    if (cOh4 != null) {
                        FragmentActivity fragmentActivity4 = (FragmentActivity) cOh4.get(0);
                        this.szW.a(fragmentActivity4, j2);
                        Fragment c3 = h.c(fragmentActivity4, com.tencent.mm.plugin.expt.hellhound.core.b.syW);
                        this.szW.a(fragmentActivity4, c3, com.tencent.mm.plugin.expt.hellhound.core.b.syW, c3 == null ? 0 : c3.hashCode(), j2, false);
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(184316);
    }

    private static c<FragmentActivity, Fragment> cOh() {
        String canonicalName;
        AppMethodBeat.i(220434);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        bn cNR = e.cNR();
        if (cNR != null) {
            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(cNR.KFh.activityName);
            Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, topActivityName: %s", aoE);
            if ("ChattingUI".equals(aoE)) {
                Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, ChattingUI");
                AppMethodBeat.o(220434);
                return null;
            }
        }
        FragmentActivity cNA = com.tencent.mm.plugin.expt.hellhound.core.b.cNA();
        if (cNA == null) {
            AppMethodBeat.o(220434);
            return null;
        }
        Fragment aa = h.aa(cNA);
        if (aa == null) {
            Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, curFragment NULL");
            AppMethodBeat.o(220434);
            return null;
        }
        String canonicalName2 = aa.getClass().getCanonicalName();
        Fragment c2 = h.c(cNA, com.tencent.mm.plugin.expt.hellhound.core.b.sza);
        if (c2 == null) {
            canonicalName = null;
        } else {
            canonicalName = c2.getClass().getCanonicalName();
        }
        Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, fragment: %s, %s", canonicalName2, canonicalName);
        boolean equals = com.tencent.mm.plugin.expt.hellhound.core.b.sza.equals(canonicalName2);
        boolean equals2 = com.tencent.mm.plugin.expt.hellhound.core.b.sza.equals(canonicalName);
        if (equals || equals2) {
            c<FragmentActivity, Fragment> Q = com.tencent.mm.vending.j.a.Q(cNA, equals ? aa : c2);
            AppMethodBeat.o(220434);
            return Q;
        }
        Log.e("HABBYGE-MALI.ChatUIFragmentProxy", "getPage, NOT ChattingUIFragment");
        AppMethodBeat.o(220434);
        return null;
    }

    static /* synthetic */ void a(b bVar, int i2, long j2) {
        AppMethodBeat.i(220435);
        Log.i("HABBYGE-MALI.ChatUIFragmentProxy", "sendMsg, mChatUIStatusListener: %d", Integer.valueOf(i2));
        if (bVar.szI) {
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(i2, Long.valueOf(j2));
            AppMethodBeat.o(220435);
            return;
        }
        bVar.V(i2, j2);
        AppMethodBeat.o(220435);
    }
}

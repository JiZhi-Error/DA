package com.tencent.mm.plugin.music.model;

import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class a extends FloatBallHelper {
    String TAG = "MicroMsg.GlobalMusicFloatBallHelper";

    /* renamed from: com.tencent.mm.plugin.music.model.a$a  reason: collision with other inner class name */
    static class C1535a {
        static a AjU = new a("MicroMsg.GlobalMusicFloatBallHelper");

        static {
            AppMethodBeat.i(63000);
            AppMethodBeat.o(63000);
        }
    }

    public static a eun() {
        return C1535a.AjU;
    }

    protected a(String str) {
        AppMethodBeat.i(219820);
        this.TAG = str;
        G(euo(), "MusicFloatBall");
        ciw().hDa = 1;
        cit();
        AppMethodBeat.o(219820);
    }

    /* access modifiers changed from: protected */
    public int euo() {
        return 6;
    }

    public final void x(f fVar) {
        AppMethodBeat.i(219821);
        if (!ciq()) {
            jT(true);
            agT(fVar.jeX);
            agU(fVar.jeY);
            eU("song_id", fVar.jeV);
            eU("db_music_id", b.S(fVar));
            A(fVar);
            ciw().oWx = fVar.jeT;
            cit();
            B(fVar);
            z(fVar);
        }
        AppMethodBeat.o(219821);
    }

    /* access modifiers changed from: protected */
    public boolean y(f fVar) {
        AppMethodBeat.i(219822);
        if (fVar.jfx || euo() != 6) {
            AppMethodBeat.o(219822);
            return false;
        }
        AppMethodBeat.o(219822);
        return true;
    }

    public final void a(final mx mxVar) {
        final String string;
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(219823);
        if (!k.isInit()) {
            Log.e(this.TAG, "floatBallMusicActionListener don't anything, must init MusicPlayerManager first with MusicLogic before!");
            AppMethodBeat.o(219823);
            return;
        }
        switch (mxVar.dSE.action) {
            case 0:
            case 1:
                if (bZp()) {
                    string = MMApplicationContext.getContext().getString(R.string.e3e);
                } else if (com.tencent.mm.q.a.atx()) {
                    string = MMApplicationContext.getContext().getString(R.string.e3g);
                } else if (m.isVoipStarted() || m.fKH() || com.tencent.mm.q.a.att() || com.tencent.mm.q.a.atw()) {
                    string = MMApplicationContext.getContext().getString(R.string.e3h);
                } else {
                    if (!m.fKI()) {
                        if (g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null) {
                            Iterator<AppBrandBackgroundRunningApp> it = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g) g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).byZ().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if ((it.next().beL & 4) > 0) {
                                        Log.i(this.TAG, "isAnyAppInVOIP, already exist wxa using VOIP");
                                        z = true;
                                    }
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            string = (com.tencent.mm.q.a.p(null, false) || com.tencent.mm.q.a.atu()) ? MMApplicationContext.getContext().getString(R.string.e3b) : null;
                        }
                    }
                    string = MMApplicationContext.getContext().getString(R.string.e3g);
                }
                if (Util.isNullOrNil(string)) {
                    z2 = false;
                } else {
                    com.tencent.mm.ay.a.bea();
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.music.model.a.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(219819);
                            Toast.makeText(MMApplicationContext.getContext(), string, 0).show();
                            AppMethodBeat.o(219819);
                        }
                    });
                    z2 = true;
                }
                if (!z2) {
                    if (!ciq()) {
                        jT(true);
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    f bef = com.tencent.mm.ay.a.bef();
                    if (!y(bef)) {
                        Log.w(this.TAG, "can not hand musicPlayerEvent and ignore");
                        AppMethodBeat.o(219823);
                        return;
                    }
                    agT(bef.jeX);
                    agU(bef.jeY);
                    eU("song_id", bef.jeV);
                    eU("db_music_id", b.S(bef));
                    A(bef);
                    Log.i(this.TAG, "onMusicPlayerEvent isFromNewMusicPlayer: %s, newBall: %s", Boolean.valueOf(bef.jfx), Boolean.valueOf(z3));
                    if (z3) {
                        ciw().oWx = bef.jeT;
                        cit();
                        z(bef);
                    }
                    B(bef);
                    AppMethodBeat.o(219823);
                    return;
                }
                break;
            case 2:
            case 3:
            case 7:
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.music.model.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(219818);
                        if (com.tencent.mm.ay.a.bec()) {
                            Log.i(a.this.TAG, "delay stop and playing music again");
                            AppMethodBeat.o(219818);
                        } else if (!a.this.ciq()) {
                            AppMethodBeat.o(219818);
                        } else {
                            BallInfo cim = a.this.cim();
                            if (cim == null || !cim.oWr) {
                                a.this.eup();
                                AppMethodBeat.o(219818);
                                return;
                            }
                            a.this.ciw().opType = mxVar.dSE.action == 2 ? 10 : 11;
                            a.this.cit();
                            a.this.cir();
                            AppMethodBeat.o(219818);
                        }
                    }
                }, 200);
                AppMethodBeat.o(219823);
                return;
            case 13:
            case 14:
                if (ciq()) {
                    f bef2 = com.tencent.mm.ay.a.bef();
                    agT(bef2.jeX);
                    agU(bef2.jeY);
                    eU("song_id", bef2.jeV);
                    eU("db_music_id", b.S(bef2));
                    B(bef2);
                    break;
                }
                break;
        }
        AppMethodBeat.o(219823);
    }

    public final void Q(BallInfo ballInfo) {
        AppMethodBeat.i(219824);
        Log.v(this.TAG, "onFloatBallInfoClicked, type: %d, key: %s", Integer.valueOf(ballInfo.type), ballInfo.key);
        AppMethodBeat.o(219824);
    }

    public void C(BallInfo ballInfo) {
        AppMethodBeat.i(219825);
        f bef = com.tencent.mm.ay.a.bef();
        String eT = ballInfo.eT("song_id", "~");
        String str = bef == null ? "" : bef.jeV;
        Log.i(this.TAG, "onFloatBallInfoRemoved, stop music id:%s current:%s", eT, str);
        if (bef != null && com.tencent.mm.ay.a.bec() && eT.equals(str)) {
            com.tencent.mm.ay.a.bea();
        }
        if (ballInfo.oWo != null && (ballInfo.oWo instanceof FloatBallMusicLyricView)) {
            FloatBallMusicLyricView floatBallMusicLyricView = (FloatBallMusicLyricView) ballInfo.oWo;
            floatBallMusicLyricView.lEl.dead();
            k.euj().etW().c(floatBallMusicLyricView.AhI);
        }
        AppMethodBeat.o(219825);
    }

    public final void B(BallInfo ballInfo) {
        AppMethodBeat.i(219826);
        Log.v(this.TAG, "onFloatBallInfoAdded, type: %d, key: %s", Integer.valueOf(ballInfo.type), ballInfo.key);
        AppMethodBeat.o(219826);
    }

    public final void R(BallInfo ballInfo) {
        AppMethodBeat.i(219827);
        Log.v(this.TAG, "onFloatBallInfoExposed, type: %d, key: %s", Integer.valueOf(ballInfo.type), ballInfo.key);
        AppMethodBeat.o(219827);
    }

    /* access modifiers changed from: protected */
    public void z(f fVar) {
        AppMethodBeat.i(219828);
        if (fVar != null) {
            Log.i(this.TAG, "addMusicFloatBall isFromNewMusicPlayer: %s", Boolean.valueOf(fVar.jfx));
            if (!fVar.jfx) {
                cis();
            }
        }
        AppMethodBeat.o(219828);
    }

    /* access modifiers changed from: protected */
    public void A(f fVar) {
        AppMethodBeat.i(219829);
        if (!fVar.jfx) {
            this.oWE.state = d.eV(this.oWE.state, 2);
            BH(this.oWE.state);
        }
        AppMethodBeat.o(219829);
    }

    /* access modifiers changed from: protected */
    public void eup() {
        AppMethodBeat.i(219830);
        BH(d.eW(this.oWE.state, 2));
        AppMethodBeat.o(219830);
    }

    private void B(f fVar) {
        AppMethodBeat.i(219831);
        if (fVar.jfx) {
            AppMethodBeat.o(219831);
            return;
        }
        if (this.oWE.oWo == null) {
            this.oWE.oWo = new FloatBallMusicLyricView(MMApplicationContext.getContext());
        }
        if (this.oWE.oWo instanceof FloatBallMusicLyricView) {
            ((FloatBallMusicLyricView) this.oWE.oWo).setMusicWrapper(fVar);
            ((FloatBallMusicLyricView) this.oWE.oWo).onResume();
        }
        AppMethodBeat.o(219831);
    }

    private boolean bZp() {
        Exception e2;
        boolean z;
        AppMethodBeat.i(219832);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
            if (telephonyManager != null) {
                int callState = telephonyManager.getCallState();
                switch (callState) {
                    case 0:
                        z = false;
                        break;
                    case 1:
                    case 2:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                try {
                    Log.i(this.TAG, "isPhoneInUse, isPhoneInUse:%s, callState:%s", Boolean.valueOf(z), Integer.valueOf(callState));
                } catch (Exception e3) {
                    e2 = e3;
                    Log.printErrStackTrace(this.TAG, e2, "isPhoneInUse, exception:%s", e2);
                    AppMethodBeat.o(219832);
                    return z;
                }
            } else {
                z = false;
            }
        } catch (Exception e4) {
            e2 = e4;
            z = false;
            Log.printErrStackTrace(this.TAG, e2, "isPhoneInUse, exception:%s", e2);
            AppMethodBeat.o(219832);
            return z;
        }
        AppMethodBeat.o(219832);
        return z;
    }
}

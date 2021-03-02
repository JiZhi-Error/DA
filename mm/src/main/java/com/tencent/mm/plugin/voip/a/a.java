package com.tencent.mm.plugin.voip.a;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public final class a extends FloatBallHelper {
    private long hCC;

    /* synthetic */ a(byte b2) {
        this();
    }

    /* renamed from: com.tencent.mm.plugin.voip.a.a$a  reason: collision with other inner class name */
    public static class C1887a {
        public static a GST = new a((byte) 0);

        static {
            AppMethodBeat.i(184041);
            AppMethodBeat.o(184041);
        }
    }

    public static a fFk() {
        return C1887a.GST;
    }

    private a() {
        AppMethodBeat.i(184042);
        this.hCC = 0;
        G(9, "VOIPFloatBall");
        ciw().hDa = 10;
        if (c.fFg() != null) {
            ciw().dPJ = String.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
        }
        cit();
        AppMethodBeat.o(184042);
    }

    public final void a(final int i2, final boolean z, final View view) {
        AppMethodBeat.i(184043);
        if (view != null && (i2 == 4 || i2 == 8)) {
            if (!ciq()) {
                AnonymousClass1 r0 = new Runnable() {
                    /* class com.tencent.mm.plugin.voip.a.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(184040);
                        Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", Integer.valueOf(i2), view);
                        a.this.oWE.oWr = true;
                        a.this.oWE.nno = false;
                        a.this.oWE.vk = view;
                        a.this.oWE.gqx = c.fFg().GYW;
                        a.this.oWE.oWq = true;
                        if (!c.fFg().GYW) {
                            c.fFg().GYW = true;
                        }
                        a aVar = a.this;
                        int i2 = i2;
                        boolean z = z;
                        aVar.ciw().oWy = z ? TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL : i2 == 4 ? "2" : "1";
                        aVar.ciw().iNV = z ? null : String.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
                        aVar.ciw().hCZ = 2;
                        aVar.cit();
                        a.this.bh(i2, z);
                        a.this.bi(i2, z);
                        a.this.bj(i2, z);
                        a.this.cis();
                        AppMethodBeat.o(184040);
                    }
                };
                long nowMilliSecond = (200 + this.hCC) - Util.nowMilliSecond();
                if (nowMilliSecond <= 0) {
                    r0.run();
                    AppMethodBeat.o(184043);
                    return;
                }
                Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, add delayed:%s", Long.valueOf(nowMilliSecond));
                MMHandlerThread.postToMainThreadDelayed(r0, nowMilliSecond);
            } else if (this.oWE.vk != view) {
                Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", Integer.valueOf(i2), view, this.oWE.vk);
                this.oWE.oWr = true;
                this.oWE.vk = view;
                this.oWE.nno = false;
                this.oWE.oWq = true;
                bh(i2, z);
                bi(i2, z);
                bj(i2, z);
                cis();
                AppMethodBeat.o(184043);
                return;
            } else {
                Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, state:%s, view:%s", Integer.valueOf(i2), view);
                AppMethodBeat.o(184043);
                return;
            }
        }
        AppMethodBeat.o(184043);
    }

    public final void b(FrameLayout frameLayout) {
        AppMethodBeat.i(235473);
        if (ciq()) {
            Log.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, has ball, view:%s", frameLayout);
            this.hCC = Util.nowMilliSecond();
            cir();
            AppMethodBeat.o(235473);
            return;
        }
        Log.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, no ball, view:%s", frameLayout);
        AppMethodBeat.o(235473);
    }

    /* access modifiers changed from: package-private */
    public final void bh(int i2, boolean z) {
        if (!z) {
            this.oWE.state = i2;
        } else if (i2 == 4) {
            this.oWE.state = 512;
        } else if (i2 == 8) {
            this.oWE.state = 1024;
        }
    }

    /* access modifiers changed from: package-private */
    public final void bi(int i2, boolean z) {
        AppMethodBeat.i(235474);
        if (this.oWE.oWm == null) {
            this.oWE.oWm = new Point();
        }
        int aH = at.aH(MMApplicationContext.getContext(), R.dimen.ct);
        if (i2 == 8) {
            if (!z) {
                this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), R.dimen.a77) + (aH * 2);
                this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), R.dimen.a77) + (aH * 2);
            } else {
                this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), R.dimen.a79);
                this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), R.dimen.a78);
            }
        } else if (i2 == 4) {
            if (!z) {
                this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), R.dimen.a7b) + (aH * 2);
                this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), R.dimen.a7_) + (aH * 2);
            } else {
                this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), R.dimen.a79);
                this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), R.dimen.a78);
            }
        }
        Log.v("MicroMsg.VoipFloatBallHelper", "setVoipViewSize %s, margin: %d", this.oWE.oWm, Integer.valueOf(aH));
        AppMethodBeat.o(235474);
    }

    /* access modifiers changed from: package-private */
    public final void bj(int i2, boolean z) {
        AppMethodBeat.i(235475);
        if ((z || i2 == 4) && this.oWE.oWt == null) {
            this.oWE.oWt = new BallInfo.a();
        }
        if (z) {
            at.aH(MMApplicationContext.getContext(), R.dimen.ct);
            int aH = at.aH(MMApplicationContext.getContext(), R.dimen.a79);
            int aH2 = at.aH(MMApplicationContext.getContext(), R.dimen.a79);
            int aH3 = at.aH(MMApplicationContext.getContext(), R.dimen.a78);
            this.oWE.oWt.oWv = new Point(aH, aH3);
            this.oWE.oWt.oWw = new Point(aH2, aH3);
            Log.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %d, endWidth: %d, endHeight: %d", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(aH), Integer.valueOf(aH2), Integer.valueOf(aH3));
            AppMethodBeat.o(235475);
        } else if (i2 == 4) {
            int aH4 = at.aH(MMApplicationContext.getContext(), R.dimen.ct);
            int aH5 = at.aH(MMApplicationContext.getContext(), R.dimen.a7b) + (aH4 * 2);
            int aH6 = at.aH(MMApplicationContext.getContext(), R.dimen.a7_) + (aH4 * 2);
            int aH7 = at.aH(MMApplicationContext.getContext(), R.dimen.a75) + (aH4 * 2);
            int aH8 = (aH4 * 2) + at.aH(MMApplicationContext.getContext(), R.dimen.a73);
            this.oWE.oWt.oWv = new Point(aH5, aH6);
            this.oWE.oWt.oWw = new Point(aH7, aH8);
            Log.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %s, endSize: %s", Boolean.valueOf(z), Integer.valueOf(i2), this.oWE.oWt.oWv, this.oWE.oWt.oWw);
            AppMethodBeat.o(235475);
        } else {
            this.oWE.oWt = null;
            AppMethodBeat.o(235475);
        }
    }

    public final void wR(boolean z) {
        AppMethodBeat.i(235476);
        Log.i("MicroMsg.VoipFloatBallHelper", "updateHideWhenAppBackground %b", Boolean.valueOf(z));
        if (this.oWE != null) {
            this.oWE.oWu = z;
            cit();
        }
        AppMethodBeat.o(235476);
    }

    public final void fFl() {
        AppMethodBeat.i(235477);
        Log.i("MicroMsg.VoipFloatBallHelper", "switchVoipVoice");
        this.oWE.state = 8;
        ((b) g.af(b.class)).u(this.oWE);
        AppMethodBeat.o(235477);
    }
}

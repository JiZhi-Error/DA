package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class r {
    public static r GYJ;
    v2protocal GYA = new v2protocal(new MMHandler(Looper.getMainLooper()));
    private boolean GYB = false;
    boolean GYC = false;
    WeakReference<a> GYD;
    int GYE = -1;
    boolean GYF = false;
    private int GYG = 0;
    public int GYH;
    public int GYI;
    MTimerHandler GYK = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip.model.r.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            a aVar;
            AppMethodBeat.i(115079);
            if (!r.this.GYF) {
                AppMethodBeat.o(115079);
                return false;
            }
            byte[] bArr = new byte[4];
            r.this.GYA.setAppCmd(54, bArr, 1);
            if (bArr[0] == 1) {
                if (r.this.GYz != 1) {
                    v2protocal.Hbf++;
                }
                r rVar = r.this;
                if (!rVar.GYC && c.fFj()) {
                    rVar.GYC = true;
                    Log.i("MicroMsg.VoipNetStatusChecker", "onNetWorkChangeToMobileNet");
                    if (!(rVar.GYD == null || (aVar = rVar.GYD.get()) == null)) {
                        aVar.dZQ();
                    }
                }
            }
            r.this.GYz = bArr[0];
            r rVar2 = r.this;
            byte[] bArr2 = new byte[4];
            int[] iArr = {-1, -1};
            if (rVar2.GYA.setAppCmd(10, bArr2, 4) < 0) {
                Log.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
            } else {
                int byteArrayToInt = Util.byteArrayToInt(bArr2);
                iArr[0] = byteArrayToInt;
                iArr[1] = rVar2.GYA.GetNetBottleneckSide();
                Log.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", Integer.valueOf(byteArrayToInt), Integer.valueOf(iArr[1]));
            }
            if (iArr[0] != -1) {
                r.this.GYE = iArr[0];
                r.this.GYH = r.this.GYE + r.this.GYH;
                r.this.GYI++;
                if (iArr[1] == 0) {
                    r.a(r.this, true);
                } else {
                    r.a(r.this, false);
                }
            }
            AppMethodBeat.o(115079);
            return true;
        }
    }, true);
    int GYz = 0;

    public interface a {
        void dZQ();

        void dZR();

        void ql(boolean z);
    }

    public static r fHo() {
        AppMethodBeat.i(115082);
        if (GYJ == null) {
            GYJ = new r();
        }
        r rVar = GYJ;
        AppMethodBeat.o(115082);
        return rVar;
    }

    private r() {
        AppMethodBeat.i(115083);
        AppMethodBeat.o(115083);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(115084);
        this.GYD = new WeakReference<>(aVar);
        AppMethodBeat.o(115084);
    }

    public final void fHp() {
        AppMethodBeat.i(115085);
        Log.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
        this.GYE = -1;
        this.GYF = true;
        this.GYI = 0;
        this.GYH = 0;
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.r.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(115080);
                r.this.GYK.startTimer(2000);
                AppMethodBeat.o(115080);
            }
        }, 3000);
        AppMethodBeat.o(115085);
    }

    public final void fHq() {
        AppMethodBeat.i(115086);
        Log.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
        this.GYE = -1;
        this.GYB = false;
        this.GYC = false;
        this.GYF = false;
        this.GYI = 0;
        this.GYH = 0;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.r.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(115081);
                r.this.GYK.stopTimer();
                AppMethodBeat.o(115081);
            }
        });
        AppMethodBeat.o(115086);
    }

    static /* synthetic */ void a(r rVar, boolean z) {
        a aVar;
        AppMethodBeat.i(235662);
        if (rVar.GYE < 5) {
            rVar.GYG = 0;
            if (!rVar.GYB) {
                rVar.GYB = true;
                Log.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
                if (rVar.GYD != null) {
                    a aVar2 = rVar.GYD.get();
                    if (aVar2 != null) {
                        aVar2.ql(z);
                    }
                    AppMethodBeat.o(235662);
                    return;
                }
            }
        } else if (rVar.GYB) {
            if (rVar.GYG <= 0) {
                Log.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
                rVar.GYG++;
                AppMethodBeat.o(235662);
                return;
            }
            rVar.GYB = false;
            Log.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
            if (!(rVar.GYD == null || (aVar = rVar.GYD.get()) == null)) {
                aVar.dZR();
            }
        }
        AppMethodBeat.o(235662);
    }
}

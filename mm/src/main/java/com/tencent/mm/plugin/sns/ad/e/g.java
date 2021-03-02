package com.tencent.mm.plugin.sns.ad.e;

import android.os.CountDownTimer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class g {
    protected final long DsM;
    final int DsN;
    public b DsO;
    public a DsP;
    protected final long mStartTime;

    public interface a {
        void IO(long j2);
    }

    public g(long j2, long j3) {
        this(j2, j3, (byte) 0);
    }

    private g(long j2, long j3, byte b2) {
        this.mStartTime = j2;
        this.DsM = j3;
        this.DsN = 1000;
    }

    /* access modifiers changed from: protected */
    public boolean isValid() {
        AppMethodBeat.i(201926);
        if (eWP() > this.DsM || this.DsM <= this.mStartTime || this.mStartTime < 0) {
            AppMethodBeat.o(201926);
            return false;
        }
        AppMethodBeat.o(201926);
        return true;
    }

    /* access modifiers changed from: protected */
    public long eWP() {
        AppMethodBeat.i(201927);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(201927);
        return currentTimeMillis;
    }

    public final void a(a aVar) {
        long j2;
        AppMethodBeat.i(201928);
        if (isValid()) {
            if (this.DsO != null && !this.DsO.mFinished) {
                this.DsO.cancel();
                this.DsO = null;
            }
            this.DsP = aVar;
            long eWP = eWP();
            if (eWP >= this.mStartTime) {
                j2 = this.DsM - eWP;
            } else {
                j2 = -1;
            }
            if (j2 > 0) {
                this.DsO = new b(this, j2);
                this.DsO.start();
            }
        }
        AppMethodBeat.o(201928);
    }

    /* access modifiers changed from: package-private */
    public final void onTick(long j2) {
        AppMethodBeat.i(201929);
        Log.d("SnsAd.CountDownTimer", "the millisUntilFinished is ".concat(String.valueOf(j2)));
        a aVar = this.DsP;
        if (aVar != null) {
            aVar.IO(j2);
        }
        AppMethodBeat.o(201929);
    }

    public static class b extends CountDownTimer {
        g DsQ;
        boolean mFinished;

        private b(long j2, long j3) {
            super(j2, j3);
            this.mFinished = false;
        }

        b(g gVar, long j2) {
            this(j2, (long) gVar.DsN);
            AppMethodBeat.i(201923);
            this.DsQ = gVar;
            AppMethodBeat.o(201923);
        }

        public final void onTick(long j2) {
            AppMethodBeat.i(201924);
            g gVar = this.DsQ;
            if (gVar != null) {
                gVar.onTick(j2);
            }
            AppMethodBeat.o(201924);
        }

        public final void onFinish() {
            AppMethodBeat.i(201925);
            this.mFinished = true;
            g gVar = this.DsQ;
            if (gVar != null) {
                gVar.onTick(0);
            }
            AppMethodBeat.o(201925);
        }
    }
}

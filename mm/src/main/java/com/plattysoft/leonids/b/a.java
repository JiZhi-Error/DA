package com.plattysoft.leonids.b;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.plattysoft.leonids.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class a implements b, b {
    private C0127a hBT = new C0127a();

    /* renamed from: com.plattysoft.leonids.b.a$a  reason: collision with other inner class name */
    public static class C0127a {
        public long mEndTime;
        public Interpolator mInterpolator;
        public long mStartTime;
        public int oln;
        public float ooA;
        public int ooz;
        public float opP;

        public final void a(C0127a aVar) {
            this.oln = aVar.oln;
            this.ooz = aVar.ooz;
            this.mStartTime = aVar.mStartTime;
            this.mEndTime = aVar.mEndTime;
            this.ooA = aVar.ooA;
            this.opP = aVar.opP;
            this.mInterpolator = aVar.mInterpolator;
        }
    }

    public a(long j2, Interpolator interpolator) {
        AppMethodBeat.i(261928);
        this.hBT.oln = 255;
        this.hBT.ooz = 0;
        this.hBT.mStartTime = j2;
        this.hBT.mEndTime = 0;
        this.hBT.ooA = (float) (this.hBT.mEndTime - this.hBT.mStartTime);
        this.hBT.opP = (float) (this.hBT.ooz - this.hBT.oln);
        this.hBT.mInterpolator = interpolator;
        AppMethodBeat.o(261928);
    }

    @Override // com.plattysoft.leonids.a.b
    public final void a(com.plattysoft.leonids.a aVar, Random random) {
        AppMethodBeat.i(261929);
        C0127a aVar2 = aVar.hBT;
        aVar2.a(this.hBT);
        aVar2.mStartTime = (long) ((int) (((float) (aVar.mTimeToLive + this.hBT.mStartTime)) * random.nextFloat()));
        aVar2.mEndTime = (long) ((int) (((float) (aVar.mTimeToLive + this.hBT.mStartTime)) + aVar2.ooA));
        if (aVar2.mInterpolator == null) {
            aVar2.mInterpolator = new LinearInterpolator();
        }
        AppMethodBeat.o(261929);
    }

    @Override // com.plattysoft.leonids.b.b
    public final void a(com.plattysoft.leonids.a aVar, long j2) {
        AppMethodBeat.i(261930);
        C0127a aVar2 = aVar.hBT;
        if (j2 < aVar2.mStartTime) {
            aVar.mAlpha = aVar2.oln;
            AppMethodBeat.o(261930);
        } else if (j2 > aVar2.mEndTime) {
            aVar.mAlpha = aVar2.ooz;
            AppMethodBeat.o(261930);
        } else {
            aVar.mAlpha = Math.min(255, Math.max((int) ((aVar2.opP * aVar2.mInterpolator.getInterpolation((((float) (j2 - aVar2.mStartTime)) * 1.0f) / aVar2.ooA)) + ((float) aVar2.oln)), 0));
            AppMethodBeat.o(261930);
        }
    }
}

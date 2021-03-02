package com.tencent.i.a.c.c.a;

import android.view.MotionEvent;
import com.tencent.h.a.a;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.b.c.a.b;
import com.tencent.i.a.b.c.b;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.c.c.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f extends a {
    private AtomicBoolean SrB = new AtomicBoolean(true);
    private MotionEvent.PointerCoords SsQ = new MotionEvent.PointerCoords();
    private final d SsR = new d(new d.b(), new d.a());
    private long SsS = 0;
    private a SsT = new a() {
        /* class com.tencent.i.a.c.c.a.f.AnonymousClass1 */

        @Override // com.tencent.h.a.a
        public final void boF() {
            AppMethodBeat.i(214779);
            h.i("sensor_MultiTouch", "[method: mPauseRunnable ] mPauseRunnable");
            f.this.pause();
            AppMethodBeat.o(214779);
        }
    };

    public f(c cVar, b bVar) {
        super(cVar, bVar);
        AppMethodBeat.i(214780);
        AppMethodBeat.o(214780);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.i.a.c.c.a.a
    public final void a(MotionEvent motionEvent, b.a aVar) {
        AppMethodBeat.i(214781);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 0:
            case 5:
                motionEvent.getPointerCoords(actionIndex, this.SsQ);
                i a2 = a(1, motionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size);
                h.i("sensor_MultiTouch", "[method: handleDown ] pointerId : ".concat(String.valueOf(pointerId)));
                boolean hqB = this.SsR.SsI.hqB();
                if (this.SrB.get() || hqB) {
                    h.i("sensor_MultiTouch", "[method: handleDown pauseEngineWhenDown111 ] isMainTouchSet : " + hqB + ", isEngineStop : " + this.SrB.get());
                } else {
                    h.i("sensor_MultiTouch", "[method: handleDown pauseEngineWhenDown444 ] ----pause engine----");
                    OL(0);
                }
                c cVar = new c(pointerId, a2);
                d.b bVar = this.SsR.SsI;
                bVar.SsN.put(Integer.valueOf(cVar.SsF), cVar);
                bVar.SsM.offer(Integer.valueOf(cVar.SsF));
                this.SsR.SsI.hqC();
                OK(a2.Ssw);
                this.SsR.SsJ.asD(pointerId);
                a(aVar, pointerId, a2);
                AppMethodBeat.o(214781);
                return;
            case 1:
            case 3:
            case 6:
                motionEvent.getPointerCoords(actionIndex, this.SsQ);
                i a3 = a(actionMasked == 3 ? 4 : 3, motionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size);
                a(aVar, pointerId, a3);
                c asF = this.SsR.SsI.asF(pointerId);
                h.i("sensor_MultiTouch", "[method: handleUp ] main pointer up id : ".concat(String.valueOf(pointerId)));
                if (asF != null && (asF.SsG || this.SsR.SsI.SsM.size() <= 0)) {
                    long abs = Math.abs(a3.Ssw - this.SsS);
                    long max = Math.max(Math.min(2000 - abs, 500L), 0L);
                    h.i("sensor_MultiTouch", "[method: handleUp ]  touch interval : " + abs + ", delay pause : " + max);
                    OK(a3.Ssw);
                    OL(max);
                }
                this.SsR.SsJ.asE(pointerId);
                break;
            case 2:
                for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                    motionEvent.getPointerCoords(i2, this.SsQ);
                    a(aVar, motionEvent.getPointerId(i2), a(2, motionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size));
                }
                this.SsR.SsI.hqC();
                OK(motionEvent.getEventTime());
                AppMethodBeat.o(214781);
                return;
        }
        AppMethodBeat.o(214781);
    }

    private void OK(long j2) {
        AppMethodBeat.i(214782);
        if (this.SrB.get()) {
            this.SrB.set(false);
            h.i("sensor_MultiTouch", "[method: resumeEngine ] engine is restart");
            this.SsS = j2;
            this.SsB.hqe();
            OL(2000);
        }
        AppMethodBeat.o(214782);
    }

    private void OL(long j2) {
        AppMethodBeat.i(214783);
        if (this.SsE != null) {
            this.SsE.hqz().removeCallbacks(this.SsT);
        }
        if (j2 <= 0) {
            pause();
            AppMethodBeat.o(214783);
            return;
        }
        if (this.SsE != null) {
            this.SsE.hqz().postDelayed(this.SsT, j2);
        }
        AppMethodBeat.o(214783);
    }

    /* access modifiers changed from: package-private */
    public final void pause() {
        AppMethodBeat.i(214784);
        if (this.SsB != null) {
            this.SrB.set(true);
            h.i("sensor_MultiTouch", "[method: multi_pause ] " + this.SsB.YY());
            this.SsB.hqf();
        }
        AppMethodBeat.o(214784);
    }

    private void a(int i2, i iVar) {
        AppMethodBeat.i(214785);
        iVar.Ssz = this.SsR.SsJ.asD(i2);
        AppMethodBeat.o(214785);
    }

    private void a(b.a aVar, int i2, i iVar) {
        AppMethodBeat.i(214786);
        if (aVar != null) {
            a(i2, iVar);
            h.i("sensor_MultiTouch", "[method: onCallBack ] info : " + iVar.Ssz);
            aVar.b(iVar);
        }
        AppMethodBeat.o(214786);
    }
}

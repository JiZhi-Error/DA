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

public final class g extends a {
    private MotionEvent.PointerCoords SsQ = new MotionEvent.PointerCoords();
    private final d SsR = new d(null, new d.a());
    private AtomicBoolean SsV = new AtomicBoolean(false);
    private AtomicBoolean SsW = new AtomicBoolean(false);
    a SsX = new a() {
        /* class com.tencent.i.a.c.c.a.g.AnonymousClass1 */

        @Override // com.tencent.h.a.a
        public final void boF() {
            AppMethodBeat.i(214787);
            h.i("sensor_SingleTouch", "[method: run ] mTimeLimitRunnable " + g.this.SsX);
            if (g.this.SsB != null) {
                g.this.SsB.hqg();
            }
            AppMethodBeat.o(214787);
        }
    };

    public g(c cVar, b bVar) {
        super(cVar, bVar);
        AppMethodBeat.i(214788);
        h.i("sensor_SingleTouch", "[method: SingleTouch ] " + this.SsX);
        AppMethodBeat.o(214788);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.i.a.c.c.a.a
    public final void a(MotionEvent motionEvent, b.a aVar) {
        long j2;
        AppMethodBeat.i(214789);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                motionEvent.getPointerCoords(actionIndex, this.SsQ);
                i a2 = a(1, motionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size);
                if (this.SsB != null) {
                    boolean YY = this.SsB.YY();
                    h.i("sensor_SingleTouch", "[method: resumeEngine ] ".concat(String.valueOf(YY)));
                    if (YY && this.SsV.compareAndSet(false, true)) {
                        h.i("sensor_SingleTouch", "[method: resumeEngine ] start resume");
                        this.SsB.hqe();
                    }
                }
                if (this.SsW.compareAndSet(false, true)) {
                    h.i("sensor_SingleTouch", "[method: setMasterDataCallBack ] ");
                    hqE();
                    h.i("sensor_SingleTouch", "[method: postMaxDurationRunnable ] ");
                    if (this.SsB.hqh() != null) {
                        j2 = this.SsB.hqh().dyB;
                    } else {
                        j2 = 10000;
                    }
                    if (this.SsE != null) {
                        this.SsE.hqz().postDelayed(this.SsX, j2);
                    }
                }
                a(aVar, pointerId, a2);
                AppMethodBeat.o(214789);
                return;
            case 1:
            case 6:
                motionEvent.getPointerCoords(actionIndex, this.SsQ);
                a(aVar, pointerId, a(3, motionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size));
                this.SsR.SsJ.asE(pointerId);
                hqD();
                AppMethodBeat.o(214789);
                return;
            case 2:
                for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                    motionEvent.getPointerCoords(i2, this.SsQ);
                    a(aVar, motionEvent.getPointerId(i2), a(2, motionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size));
                }
                AppMethodBeat.o(214789);
                return;
            case 3:
                motionEvent.getPointerCoords(actionIndex, this.SsQ);
                a(aVar, pointerId, a(4, motionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size));
                this.SsR.SsJ.asE(pointerId);
                hqD();
                AppMethodBeat.o(214789);
                return;
            case 4:
            default:
                AppMethodBeat.o(214789);
                return;
        }
    }

    private void hqD() {
        AppMethodBeat.i(214790);
        h.i("sensor_SingleTouch", "[method: cancelRunnable ] ");
        if (this.SsR.SsJ.hqA() <= 0) {
            h.i("sensor_SingleTouch", "[method: cancelRunnable remove] ");
            hqE();
            resetFlag();
        }
        AppMethodBeat.o(214790);
    }

    private void hqE() {
        AppMethodBeat.i(214791);
        h.i("sensor_SingleTouch", "[method: removeMaxDurationRunnable ] " + this.SsX);
        if (this.SsE != null) {
            this.SsE.hqz().removeCallbacks(this.SsX);
        }
        AppMethodBeat.o(214791);
    }

    private void resetFlag() {
        AppMethodBeat.i(214792);
        this.SsW.set(false);
        this.SsV.set(false);
        AppMethodBeat.o(214792);
    }

    private void a(int i2, i iVar) {
        AppMethodBeat.i(214793);
        iVar.Ssz = this.SsR.SsJ.asD(i2);
        AppMethodBeat.o(214793);
    }

    private void a(b.a aVar, int i2, i iVar) {
        AppMethodBeat.i(214794);
        if (aVar != null) {
            a(i2, iVar);
            h.i("sensor_SingleTouch", "[method: onCallBack ] info : " + iVar.Ssz);
            aVar.b(iVar);
        }
        AppMethodBeat.o(214794);
    }
}

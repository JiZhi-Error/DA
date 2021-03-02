package com.tencent.i.a.b.c;

import android.view.MotionEvent;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.b.c.a.e;
import com.tencent.i.a.b.c.a.f;
import com.tencent.i.a.c.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends com.tencent.i.a.b.c.a.a implements com.tencent.i.a.c.c.a.a.b {
    f Srp;
    public AbstractC0143b Srq;
    private a Srr = new a() {
        /* class com.tencent.i.a.b.c.b.AnonymousClass1 */

        @Override // com.tencent.i.a.b.c.b.a
        public final void b(i iVar) {
            AppMethodBeat.i(214709);
            synchronized (b.this.mLock) {
                try {
                    if (!(b.this.Srp == null || iVar == null)) {
                        b.this.Srp.a(iVar);
                    }
                } finally {
                    AppMethodBeat.o(214709);
                }
            }
        }
    };
    final Object mLock = new Object();

    public interface a {
        void b(i iVar);
    }

    /* renamed from: com.tencent.i.a.b.c.b$b  reason: collision with other inner class name */
    public interface AbstractC0143b {
        void a(MotionEvent motionEvent, a aVar, com.tencent.i.a.c.c.a.b bVar);
    }

    public b(c cVar) {
        super(cVar);
        AppMethodBeat.i(214710);
        AppMethodBeat.o(214710);
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final int getTaskId() {
        return 10;
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final boolean hqp() {
        AppMethodBeat.i(214711);
        h.i("sensor_TouchTask", "[method: start ] ");
        AppMethodBeat.o(214711);
        return true;
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final boolean Qt() {
        AppMethodBeat.i(214712);
        h.i("sensor_TouchTask", "[method: stop ] ");
        synchronized (this.mLock) {
            try {
                this.Srp = null;
            } catch (Throwable th) {
                AppMethodBeat.o(214712);
                throw th;
            }
        }
        AppMethodBeat.o(214712);
        return true;
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final void a(e eVar) {
        this.Srp = (f) eVar;
    }

    @Override // com.tencent.i.a.c.c.a.a.b
    public final void a(MotionEvent motionEvent, com.tencent.i.a.c.c.a.b bVar) {
        AppMethodBeat.i(214713);
        if (this.Srt.get() && this.Srq != null) {
            this.Srq.a(motionEvent, this.Srr, bVar);
        }
        AppMethodBeat.o(214713);
    }
}

package com.b.a.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public abstract class e {
    private a chy;
    long chz;
    final Handler handler;

    /* access modifiers changed from: package-private */
    public abstract void IZ();

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private boolean chA;
        private boolean started;

        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(87957);
            if (this.chA) {
                AppMethodBeat.o(87957);
                return;
            }
            e.this.IZ();
            e.this.handler.postDelayed(this, e.this.chz);
            AppMethodBeat.o(87957);
        }

        static /* synthetic */ void a(a aVar, long j2) {
            AppMethodBeat.i(87958);
            if (aVar.started || aVar.chA) {
                AppMethodBeat.o(87958);
                return;
            }
            e.this.handler.postDelayed(aVar, j2);
            aVar.started = true;
            AppMethodBeat.o(87958);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(87959);
            aVar.chA = true;
            e.this.handler.removeCallbacks(aVar);
            AppMethodBeat.o(87959);
        }
    }

    e(Handler handler2) {
        this.handler = handler2 == null ? new Handler() : handler2;
    }

    /* access modifiers changed from: package-private */
    public final void n(long j2, long j3) {
        stop();
        this.chz = j2;
        this.chy = new a(this, (byte) 0);
        a.a(this.chy, j3);
    }

    /* access modifiers changed from: package-private */
    public final void stop() {
        if (this.chy != null) {
            a.a(this.chy);
        }
    }
}

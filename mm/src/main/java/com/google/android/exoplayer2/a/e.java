package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface e {
    void c(d dVar);

    void c(String str, long j2, long j3);

    void d(int i2, long j2, long j3);

    void d(Format format);

    void d(d dVar);

    void dG(int i2);

    public static final class a {
        final e beP;
        final Handler handler;

        public a(Handler handler2, e eVar) {
            AppMethodBeat.i(91769);
            this.handler = eVar != null ? (Handler) com.google.android.exoplayer2.i.a.checkNotNull(handler2) : null;
            this.beP = eVar;
            AppMethodBeat.o(91769);
        }

        public final void e(final d dVar) {
            AppMethodBeat.i(91770);
            if (this.beP != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.a.e.a.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(91767);
                        a.this.beP.d(dVar);
                        AppMethodBeat.o(91767);
                    }
                });
            }
            AppMethodBeat.o(91770);
        }
    }
}

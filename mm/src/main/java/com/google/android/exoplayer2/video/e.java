package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface e {
    void a(int i2, int i3, int i4, float f2);

    void a(d dVar);

    void b(d dVar);

    void b(String str, long j2, long j3);

    void c(Surface surface);

    void c(Format format);

    void h(int i2, long j2);

    public static final class a {
        final e bIT;
        final Handler handler;

        public a(Handler handler2, e eVar) {
            AppMethodBeat.i(93316);
            this.handler = eVar != null ? (Handler) com.google.android.exoplayer2.i.a.checkNotNull(handler2) : null;
            this.bIT = eVar;
            AppMethodBeat.o(93316);
        }

        public final void m(final int i2, final long j2) {
            AppMethodBeat.i(93317);
            if (this.bIT != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.video.e.a.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(93312);
                        a.this.bIT.h(i2, j2);
                        AppMethodBeat.o(93312);
                    }
                });
            }
            AppMethodBeat.o(93317);
        }

        public final void b(final int i2, final int i3, final int i4, final float f2) {
            AppMethodBeat.i(93318);
            if (this.bIT != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.video.e.a.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(93313);
                        a.this.bIT.a(i2, i3, i4, f2);
                        AppMethodBeat.o(93313);
                    }
                });
            }
            AppMethodBeat.o(93318);
        }

        public final void d(final Surface surface) {
            AppMethodBeat.i(93319);
            if (this.bIT != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.video.e.a.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(93314);
                        a.this.bIT.c(surface);
                        AppMethodBeat.o(93314);
                    }
                });
            }
            AppMethodBeat.o(93319);
        }

        public final void e(final d dVar) {
            AppMethodBeat.i(93320);
            if (this.bIT != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.video.e.a.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(93315);
                        a.this.bIT.b(dVar);
                        AppMethodBeat.o(93315);
                    }
                });
            }
            AppMethodBeat.o(93320);
        }
    }
}

package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public interface b {
    void a(int i2, Format format, long j2);

    void a(j jVar, int i2, Format format, long j2, long j3, long j4);

    void a(j jVar, int i2, Format format, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z);

    void b(j jVar, int i2, Format format, long j2, long j3, long j4);

    void c(j jVar, int i2, Format format, long j2, long j3, long j4);

    void vl();

    public static final class a {
        public final b bvb;
        private final long bvc;
        public final Handler handler;

        public a(Handler handler2, b bVar) {
            this(handler2, bVar, (byte) 0);
        }

        private a(Handler handler2, b bVar, byte b2) {
            AppMethodBeat.i(196038);
            this.handler = bVar != null ? (Handler) com.google.android.exoplayer2.i.a.checkNotNull(handler2) : null;
            this.bvb = bVar;
            this.bvc = 0;
            AppMethodBeat.o(196038);
        }

        public final void a(final j jVar, final int i2, final int i3, final Format format, final int i4, final Object obj, final long j2, final long j3, final long j4) {
            AppMethodBeat.i(92568);
            if (this.bvb != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.source.b.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(92560);
                        a.this.bvb.a(jVar, i3, format, a.a(a.this, j2), a.a(a.this, j3), j4);
                        AppMethodBeat.o(92560);
                    }
                });
            }
            AppMethodBeat.o(92568);
        }

        public final void a(j jVar, long j2, long j3, long j4) {
            AppMethodBeat.i(196039);
            a(jVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            AppMethodBeat.o(196039);
        }

        public final void a(final j jVar, final int i2, final int i3, final Format format, final int i4, final Object obj, final long j2, final long j3, final long j4, final long j5, final long j6) {
            AppMethodBeat.i(92570);
            if (this.bvb != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.source.b.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(92561);
                        a.this.bvb.b(jVar, i3, format, a.a(a.this, j2), a.a(a.this, j3), j4);
                        AppMethodBeat.o(92561);
                    }
                });
            }
            AppMethodBeat.o(92570);
        }

        public final void b(j jVar, long j2, long j3, long j4) {
            AppMethodBeat.i(196040);
            b(jVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            AppMethodBeat.o(196040);
        }

        public final void b(final j jVar, final int i2, final int i3, final Format format, final int i4, final Object obj, final long j2, final long j3, final long j4, final long j5, final long j6) {
            AppMethodBeat.i(92572);
            if (this.bvb != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.source.b.a.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(92562);
                        a.this.bvb.c(jVar, i3, format, a.a(a.this, j2), a.a(a.this, j3), j4);
                        AppMethodBeat.o(92562);
                    }
                });
            }
            AppMethodBeat.o(92572);
        }

        public final void a(j jVar, long j2, long j3, long j4, IOException iOException, boolean z) {
            AppMethodBeat.i(196041);
            a(jVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, iOException, z);
            AppMethodBeat.o(196041);
        }

        public final void a(final j jVar, final int i2, final int i3, final Format format, final int i4, final Object obj, final long j2, final long j3, final long j4, final long j5, final long j6, final IOException iOException, final boolean z) {
            AppMethodBeat.i(92574);
            if (this.bvb != null) {
                this.handler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.source.b.a.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(92563);
                        a.this.bvb.a(jVar, i3, format, a.a(a.this, j2), a.a(a.this, j3), j4, j5, j6, iOException, z);
                        AppMethodBeat.o(92563);
                    }
                });
            }
            AppMethodBeat.o(92574);
        }

        public final void vm() {
            AppMethodBeat.i(92576);
            this.handler.post(new Runnable() {
                /* class com.google.android.exoplayer2.source.b.a.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(92565);
                    a.this.bvb.vl();
                    AppMethodBeat.o(92565);
                }
            });
            AppMethodBeat.o(92576);
        }

        static /* synthetic */ long a(a aVar, long j2) {
            AppMethodBeat.i(92577);
            long v = com.google.android.exoplayer2.b.v(j2);
            if (v == -9223372036854775807L) {
                AppMethodBeat.o(92577);
                return -9223372036854775807L;
            }
            long j3 = aVar.bvc + v;
            AppMethodBeat.o(92577);
            return j3;
        }
    }
}

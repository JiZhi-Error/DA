package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.id3.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {
    public static final c btY = new c() {
        /* class com.google.android.exoplayer2.metadata.c.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.metadata.c
        public final boolean g(Format format) {
            AppMethodBeat.i(92469);
            String str = format.bdq;
            if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
                AppMethodBeat.o(92469);
                return true;
            }
            AppMethodBeat.o(92469);
            return false;
        }

        @Override // com.google.android.exoplayer2.metadata.c
        public final a h(Format format) {
            AppMethodBeat.i(92470);
            String str = format.bdq;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1248341703:
                    if (str.equals("application/id3")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1154383568:
                    if (str.equals("application/x-emsg")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1652648887:
                    if (str.equals("application/x-scte35")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a aVar = new a();
                    AppMethodBeat.o(92470);
                    return aVar;
                case 1:
                    com.google.android.exoplayer2.metadata.emsg.a aVar2 = new com.google.android.exoplayer2.metadata.emsg.a();
                    AppMethodBeat.o(92470);
                    return aVar2;
                case 2:
                    com.google.android.exoplayer2.metadata.scte35.a aVar3 = new com.google.android.exoplayer2.metadata.scte35.a();
                    AppMethodBeat.o(92470);
                    return aVar3;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    AppMethodBeat.o(92470);
                    throw illegalArgumentException;
            }
        }
    };

    boolean g(Format format);

    a h(Format format);
}

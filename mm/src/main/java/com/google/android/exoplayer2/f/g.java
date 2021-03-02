package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.a.c;
import com.google.android.exoplayer2.f.c.a;
import com.google.android.exoplayer2.f.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.ITPPlayer;

public interface g {
    public static final g bAj = new g() {
        /* class com.google.android.exoplayer2.f.g.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.f.g
        public final boolean g(Format format) {
            AppMethodBeat.i(92822);
            String str = format.bdq;
            if (ITPPlayer.TP_MIMETYPE_TEXT_VTT.equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str)) {
                AppMethodBeat.o(92822);
                return true;
            }
            AppMethodBeat.o(92822);
            return false;
        }

        @Override // com.google.android.exoplayer2.f.g
        public final e k(Format format) {
            AppMethodBeat.i(92823);
            String str = format.bdq;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals(ITPPlayer.TP_MIMETYPE_TEXT_VTT)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals("application/x-mp4-cea-608")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals("application/cea-708")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    com.google.android.exoplayer2.f.g.g gVar = new com.google.android.exoplayer2.f.g.g();
                    AppMethodBeat.o(92823);
                    return gVar;
                case 1:
                    a aVar = new a(format.bds);
                    AppMethodBeat.o(92823);
                    return aVar;
                case 2:
                    b bVar = new b();
                    AppMethodBeat.o(92823);
                    return bVar;
                case 3:
                    com.google.android.exoplayer2.f.e.a aVar2 = new com.google.android.exoplayer2.f.e.a();
                    AppMethodBeat.o(92823);
                    return aVar2;
                case 4:
                    com.google.android.exoplayer2.f.d.a aVar3 = new com.google.android.exoplayer2.f.d.a();
                    AppMethodBeat.o(92823);
                    return aVar3;
                case 5:
                    com.google.android.exoplayer2.f.f.a aVar4 = new com.google.android.exoplayer2.f.f.a(format.bds);
                    AppMethodBeat.o(92823);
                    return aVar4;
                case 6:
                case 7:
                    com.google.android.exoplayer2.f.a.a aVar5 = new com.google.android.exoplayer2.f.a.a(format.bdq, format.bdE);
                    AppMethodBeat.o(92823);
                    return aVar5;
                case '\b':
                    c cVar = new c(format.bdE);
                    AppMethodBeat.o(92823);
                    return cVar;
                case '\t':
                    com.google.android.exoplayer2.f.b.a aVar6 = new com.google.android.exoplayer2.f.b.a(format.bds);
                    AppMethodBeat.o(92823);
                    return aVar6;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    AppMethodBeat.o(92823);
                    throw illegalArgumentException;
            }
        }
    };

    boolean g(Format format);

    e k(Format format);
}

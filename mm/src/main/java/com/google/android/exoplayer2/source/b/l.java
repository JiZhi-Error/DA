package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.f.g.h;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class l implements e {
    private static final Pattern byK = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern byL = Pattern.compile("MPEGTS:(\\d+)");
    private final u bnh;
    private g bph;
    private final m byM = new m();
    private byte[] byN = new byte[1024];
    private final String language;
    private int sampleSize;

    static {
        AppMethodBeat.i(62932);
        AppMethodBeat.o(62932);
    }

    public l(String str, u uVar) {
        AppMethodBeat.i(62926);
        this.language = str;
        this.bnh = uVar;
        AppMethodBeat.o(62926);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(62927);
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.o(62927);
        throw illegalStateException;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        AppMethodBeat.i(62928);
        this.bph = gVar;
        gVar.a(new l.a(-9223372036854775807L));
        AppMethodBeat.o(62928);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(62929);
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.o(62929);
        throw illegalStateException;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final int a(f fVar, k kVar) {
        int length;
        AppMethodBeat.i(62930);
        int length2 = (int) fVar.getLength();
        if (this.sampleSize == this.byN.length) {
            byte[] bArr = this.byN;
            if (length2 != -1) {
                length = length2;
            } else {
                length = this.byN.length;
            }
            this.byN = Arrays.copyOf(bArr, (length * 3) / 2);
        }
        int read = fVar.read(this.byN, this.sampleSize, this.byN.length - this.sampleSize);
        if (read != -1) {
            this.sampleSize = read + this.sampleSize;
            if (length2 == -1 || this.sampleSize != length2) {
                AppMethodBeat.o(62930);
                return 0;
            }
        }
        m mVar = new m(this.byN);
        try {
            h.I(mVar);
            long j2 = 0;
            long j3 = 0;
            while (true) {
                String readLine = mVar.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    Matcher J = h.J(mVar);
                    if (J == null) {
                        ag(0);
                    } else {
                        long bn = h.bn(J.group(1));
                        long ao = this.bnh.ao(u.ar((j3 + bn) - j2));
                        com.google.android.exoplayer2.c.m ag = ag(ao - bn);
                        this.byM.n(this.byN, this.sampleSize);
                        ag.a(this.byM, this.sampleSize);
                        ag.a(ao, 1, this.sampleSize, 0, null);
                    }
                    AppMethodBeat.o(62930);
                    return -1;
                } else if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = byK.matcher(readLine);
                    if (!matcher.find()) {
                        o oVar = new o("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(String.valueOf(readLine)));
                        AppMethodBeat.o(62930);
                        throw oVar;
                    }
                    Matcher matcher2 = byL.matcher(readLine);
                    if (!matcher2.find()) {
                        o oVar2 = new o("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(String.valueOf(readLine)));
                        AppMethodBeat.o(62930);
                        throw oVar2;
                    }
                    j2 = h.bn(matcher.group(1));
                    j3 = u.aq(Long.parseLong(matcher2.group(1)));
                }
            }
        } catch (com.google.android.exoplayer2.f.f e2) {
            o oVar3 = new o(e2);
            AppMethodBeat.o(62930);
            throw oVar3;
        }
    }

    private com.google.android.exoplayer2.c.m ag(long j2) {
        AppMethodBeat.i(62931);
        com.google.android.exoplayer2.c.m dV = this.bph.dV(0);
        dV.f(Format.a(ITPPlayer.TP_MIMETYPE_TEXT_VTT, this.language, j2));
        this.bph.uy();
        AppMethodBeat.o(62931);
        return dV;
    }
}

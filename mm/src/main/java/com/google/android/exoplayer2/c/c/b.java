package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.j;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements e {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.c.b.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92037);
            e[] eVarArr = {new b()};
            AppMethodBeat.o(92037);
            return eVarArr;
        }
    };
    private static final int bks = x.bJ("Xing");
    private static final int bkt = x.bJ("Info");
    private static final int bku = x.bJ("VBRI");
    private Metadata bdo;
    private final m bin;
    private g bir;
    private a bkA;
    private long bkB;
    private long bkC;
    private int bkD;
    private final long bkv;
    private final j bkw;
    private final i bkx;
    private com.google.android.exoplayer2.c.m bky;
    private int bkz;
    private final int flags;

    interface a extends l {
        long N(long j2);
    }

    static {
        AppMethodBeat.i(92045);
        AppMethodBeat.o(92045);
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        this(i2, -9223372036854775807L);
    }

    public b(int i2, long j2) {
        AppMethodBeat.i(92038);
        this.flags = i2;
        this.bkv = j2;
        this.bin = new m(10);
        this.bkw = new j();
        this.bkx = new i();
        this.bkB = -9223372036854775807L;
        AppMethodBeat.o(92038);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92039);
        boolean a2 = a(fVar, true);
        AppMethodBeat.o(92039);
        return a2;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        AppMethodBeat.i(92040);
        this.bir = gVar;
        this.bky = this.bir.dV(0);
        this.bir.uy();
        AppMethodBeat.o(92040);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        this.bkz = 0;
        this.bkB = -9223372036854775807L;
        this.bkC = 0;
        this.bkD = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015a  */
    @Override // com.google.android.exoplayer2.c.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.c.f r23, com.google.android.exoplayer2.c.k r24) {
        /*
        // Method dump skipped, instructions count: 972
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.b.a(com.google.android.exoplayer2.c.f, com.google.android.exoplayer2.c.k):int");
    }

    private boolean a(f fVar, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        int dW;
        AppMethodBeat.i(92042);
        int i6 = z ? 16384 : 131072;
        fVar.uv();
        if (fVar.getPosition() == 0) {
            e(fVar);
            int uw = (int) fVar.uw();
            if (!z) {
                fVar.dP(uw);
            }
            i5 = 0;
            i4 = uw;
            i3 = 0;
            i2 = 0;
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        while (true) {
            byte[] bArr = this.bin.data;
            if (i2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!fVar.b(bArr, 0, 4, z2)) {
                break;
            }
            this.bin.setPosition(0);
            int readInt = this.bin.readInt();
            if ((i3 == 0 || j(readInt, (long) i3)) && (dW = j.dW(readInt)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                    readInt = i3;
                } else {
                    j.a(readInt, this.bkw);
                }
                fVar.dQ(dW - 4);
                i3 = readInt;
            } else {
                int i7 = i5 + 1;
                if (i5 == i6) {
                    if (!z) {
                        o oVar = new o("Searched too many bytes.");
                        AppMethodBeat.o(92042);
                        throw oVar;
                    }
                    AppMethodBeat.o(92042);
                    return false;
                } else if (z) {
                    fVar.uv();
                    fVar.dQ(i4 + i7);
                    i5 = i7;
                    i3 = 0;
                    i2 = 0;
                } else {
                    fVar.dP(1);
                    i5 = i7;
                    i3 = 0;
                    i2 = 0;
                }
            }
        }
        if (z) {
            fVar.dP(i4 + i5);
        } else {
            fVar.uv();
        }
        this.bkz = i3;
        AppMethodBeat.o(92042);
        return true;
    }

    private void e(f fVar) {
        AppMethodBeat.i(92043);
        int i2 = 0;
        while (true) {
            fVar.b(this.bin.data, 0, 10);
            this.bin.setPosition(0);
            if (this.bin.xf() == com.google.android.exoplayer2.metadata.id3.a.bqj) {
                this.bin.eZ(3);
                int xj = this.bin.xj();
                int i3 = xj + 10;
                if (this.bdo == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.bin.data, 0, bArr, 0, 10);
                    fVar.b(bArr, 10, xj);
                    this.bdo = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.bhW : null).d(bArr, i3);
                    if (this.bdo != null) {
                        this.bkx.c(this.bdo);
                    }
                } else {
                    fVar.dQ(xj);
                }
                i2 += i3;
            } else {
                fVar.uv();
                fVar.dQ(i2);
                AppMethodBeat.o(92043);
                return;
            }
        }
    }

    private a f(f fVar) {
        AppMethodBeat.i(92044);
        fVar.b(this.bin.data, 0, 4);
        this.bin.setPosition(0);
        j.a(this.bin.readInt(), this.bkw);
        a aVar = new a(fVar.getPosition(), this.bkw.bitrate, fVar.getLength());
        AppMethodBeat.o(92044);
        return aVar;
    }

    private static boolean j(int i2, long j2) {
        return ((long) (-128000 & i2)) == (-128000 & j2);
    }
}

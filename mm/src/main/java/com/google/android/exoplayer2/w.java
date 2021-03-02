package com.google.android.exoplayer2;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class w {
    public static final w bel = new w() {
        /* class com.google.android.exoplayer2.w.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.w
        public final int tD() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.w
        public final b a(int i2, b bVar, boolean z, long j2) {
            AppMethodBeat.i(92921);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(92921);
            throw indexOutOfBoundsException;
        }

        @Override // com.google.android.exoplayer2.w
        public final int tE() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.w
        public final a a(int i2, a aVar, boolean z) {
            AppMethodBeat.i(92922);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(92922);
            throw indexOutOfBoundsException;
        }

        @Override // com.google.android.exoplayer2.w
        public final int ae(Object obj) {
            return -1;
        }
    };

    public static final class b {
        public long bdJ;
        public long beA;
        public long beB;
        public Object bem;
        public long beu;
        public long bev;
        public boolean bew;
        public boolean bex;
        public int bey;
        public int bez;
    }

    public abstract a a(int i2, a aVar, boolean z);

    public abstract b a(int i2, b bVar, boolean z, long j2);

    public abstract int ae(Object obj);

    public abstract int tD();

    public abstract int tE();

    public static final class a {
        public Object bcT;
        public long bdJ;
        public int bdi;
        public Object bem;
        public long ben;
        public long[] beo;
        public int[] bep;
        public int[] beq;
        public int[] ber;
        public long[][] bes;
        public long bet;

        public final int tF() {
            if (this.beo == null) {
                return 0;
            }
            return this.beo.length;
        }

        public final boolean dH(int i2) {
            return this.bep[i2] != -1 && this.ber[i2] == this.bep[i2];
        }

        public final int E(long j2) {
            AppMethodBeat.i(92923);
            if (this.beo == null) {
                AppMethodBeat.o(92923);
                return -1;
            }
            int length = this.beo.length - 1;
            while (length >= 0 && (this.beo[length] == Long.MIN_VALUE || this.beo[length] > j2)) {
                length--;
            }
            if (length < 0 || dH(length)) {
                AppMethodBeat.o(92923);
                return -1;
            }
            AppMethodBeat.o(92923);
            return length;
        }

        public final int F(long j2) {
            AppMethodBeat.i(92924);
            if (this.beo == null) {
                AppMethodBeat.o(92924);
                return -1;
            }
            int i2 = 0;
            while (i2 < this.beo.length && this.beo[i2] != Long.MIN_VALUE && (j2 >= this.beo[i2] || dH(i2))) {
                i2++;
            }
            if (i2 < this.beo.length) {
                AppMethodBeat.o(92924);
                return i2;
            }
            AppMethodBeat.o(92924);
            return -1;
        }

        public final boolean ba(int i2, int i3) {
            return i3 < this.beq[i2];
        }

        public final long bb(int i2, int i3) {
            if (i3 >= this.bes[i2].length) {
                return -9223372036854775807L;
            }
            return this.bes[i2][i3];
        }
    }

    public final boolean isEmpty() {
        return tD() == 0;
    }

    public int aZ(int i2, int i3) {
        switch (i3) {
            case 0:
                if (i2 == tD() - 1) {
                    return -1;
                }
                return i2 + 1;
            case 1:
                return i2;
            case 2:
                if (i2 == tD() - 1) {
                    return 0;
                }
                return i2 + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final b a(int i2, b bVar) {
        return a(i2, bVar, false, 0L);
    }

    public final int a(int i2, a aVar, b bVar, int i3) {
        int i4 = a(i2, aVar, false).bdi;
        if (a(i4, bVar).bez != i2) {
            return i2 + 1;
        }
        int aZ = aZ(i4, i3);
        if (aZ == -1) {
            return -1;
        }
        return a(aZ, bVar).bey;
    }

    public final boolean b(int i2, a aVar, b bVar, int i3) {
        return a(i2, aVar, bVar, i3) == -1;
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i2, long j2) {
        return a(bVar, aVar, i2, j2, 0);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i2, long j2, long j3) {
        com.google.android.exoplayer2.i.a.bh(i2, tD());
        a(i2, bVar, false, j3);
        if (j2 == -9223372036854775807L) {
            j2 = bVar.beA;
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = bVar.bey;
        long j4 = bVar.beB + j2;
        long j5 = a(i3, aVar, false).bdJ;
        while (j5 != -9223372036854775807L && j4 >= j5 && i3 < bVar.bez) {
            j4 -= j5;
            i3++;
            j5 = a(i3, aVar, false).bdJ;
        }
        return Pair.create(Integer.valueOf(i3), Long.valueOf(j4));
    }
}

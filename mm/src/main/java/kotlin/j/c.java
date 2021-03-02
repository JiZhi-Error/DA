package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b'\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0019"}, hxF = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"})
public abstract class c {
    public static final c SYN = kotlin.e.a.hxN();
    public static final a SYO = a.SYQ;
    public static final b SYP = new b((byte) 0);

    public abstract int atK(int i2);

    public int nextInt() {
        return atK(32);
    }

    public int nextInt(int i2) {
        return nextInt(0, i2);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble() {
        int atK = atK(26);
        return ((double) (((long) atK(27)) + (((long) atK) << 27))) / 9.007199254740992E15d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double nextDouble(double r10, double r12) {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.j.c.nextDouble(double, double):double");
    }

    public float nextFloat() {
        return ((float) atK(24)) / 1.6777216E7f;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"})
    public static final class b extends c {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        @Override // kotlin.j.c
        public final int atK(int i2) {
            AppMethodBeat.i(129560);
            int atK = c.SYN.atK(i2);
            AppMethodBeat.o(129560);
            return atK;
        }

        @Override // kotlin.j.c
        public final int nextInt() {
            AppMethodBeat.i(259491);
            int nextInt = c.SYN.nextInt();
            AppMethodBeat.o(259491);
            return nextInt;
        }

        @Override // kotlin.j.c
        public final int nextInt(int i2) {
            AppMethodBeat.i(259492);
            int nextInt = c.SYN.nextInt(i2);
            AppMethodBeat.o(259492);
            return nextInt;
        }

        @Override // kotlin.j.c
        public final int nextInt(int i2, int i3) {
            AppMethodBeat.i(129562);
            int nextInt = c.SYN.nextInt(i2, i3);
            AppMethodBeat.o(129562);
            return nextInt;
        }

        @Override // kotlin.j.c
        public final long nextLong() {
            AppMethodBeat.i(259493);
            long nextLong = c.SYN.nextLong();
            AppMethodBeat.o(259493);
            return nextLong;
        }

        @Override // kotlin.j.c
        public final long nextLong(long j2, long j3) {
            AppMethodBeat.i(259494);
            long nextLong = c.SYN.nextLong(j2, j3);
            AppMethodBeat.o(259494);
            return nextLong;
        }

        @Override // kotlin.j.c
        public final double nextDouble() {
            AppMethodBeat.i(259495);
            double nextDouble = c.SYN.nextDouble();
            AppMethodBeat.o(259495);
            return nextDouble;
        }

        @Override // kotlin.j.c
        public final double nextDouble(double d2, double d3) {
            AppMethodBeat.i(129564);
            double nextDouble = c.SYN.nextDouble(d2, d3);
            AppMethodBeat.o(129564);
            return nextDouble;
        }

        @Override // kotlin.j.c
        public final float nextFloat() {
            AppMethodBeat.i(259496);
            float nextFloat = c.SYN.nextFloat();
            AppMethodBeat.o(259496);
            return nextFloat;
        }
    }

    static {
        kotlin.e.a aVar = kotlin.e.b.SYe;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, hxF = {"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"})
    public static final class a extends c {
        public static final a SYQ = new a();

        static {
            AppMethodBeat.i(129567);
            AppMethodBeat.o(129567);
        }

        private a() {
        }

        @Override // kotlin.j.c
        public final int atK(int i2) {
            AppMethodBeat.i(129566);
            int atK = c.SYN.atK(i2);
            AppMethodBeat.o(129566);
            return atK;
        }
    }

    public int nextInt(int i2, int i3) {
        int nextInt;
        int i4;
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(d.V(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
        int i5 = i3 - i2;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                i4 = atK(d.axy(i5));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i4 = nextInt % i5;
                } while ((nextInt - i4) + (i5 - 1) < 0);
            }
            return i4 + i2;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i2 <= nextInt2 && i3 > nextInt2) {
                return nextInt2;
            }
        }
    }

    public long nextLong(long j2, long j3) {
        long nextLong;
        long j4;
        if (!(j3 > j2)) {
            throw new IllegalArgumentException(d.V(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
        long j5 = j3 - j2;
        if (j5 > 0) {
            if (((-j5) & j5) == j5) {
                int i2 = (int) j5;
                int i3 = (int) (j5 >>> 32);
                if (i2 != 0) {
                    j4 = ((long) atK(d.axy(i2))) & Util.MAX_32BIT_VALUE;
                } else if (i3 == 1) {
                    j4 = ((long) nextInt()) & Util.MAX_32BIT_VALUE;
                } else {
                    j4 = (((long) atK(d.axy(i3))) << 32) + ((long) nextInt());
                }
            } else {
                do {
                    nextLong = nextLong() >>> 1;
                    j4 = nextLong % j5;
                } while ((nextLong - j4) + (j5 - 1) < 0);
            }
            return j4 + j2;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j2 <= nextLong2 && j3 > nextLong2) {
                return nextLong2;
            }
        }
    }
}

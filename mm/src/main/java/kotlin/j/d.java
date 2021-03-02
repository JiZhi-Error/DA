package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, hxF = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"})
public final class d {
    public static final c Pf(long j2) {
        AppMethodBeat.i(129568);
        e eVar = new e((int) j2, (int) (j2 >> 32));
        AppMethodBeat.o(129568);
        return eVar;
    }

    public static final int a(c cVar, f fVar) {
        AppMethodBeat.i(259489);
        p.h(cVar, "$this$nextInt");
        p.h(fVar, "range");
        if (fVar.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot get random in empty range: ".concat(String.valueOf(fVar)));
            AppMethodBeat.o(259489);
            throw illegalArgumentException;
        } else if (fVar.SYV < Integer.MAX_VALUE) {
            int nextInt = cVar.nextInt(fVar.SYU, fVar.SYV + 1);
            AppMethodBeat.o(259489);
            return nextInt;
        } else if (fVar.SYU > Integer.MIN_VALUE) {
            int nextInt2 = cVar.nextInt(fVar.SYU - 1, fVar.SYV) + 1;
            AppMethodBeat.o(259489);
            return nextInt2;
        } else {
            int nextInt3 = cVar.nextInt();
            AppMethodBeat.o(259489);
            return nextInt3;
        }
    }

    public static final int axy(int i2) {
        AppMethodBeat.i(259490);
        int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i2);
        AppMethodBeat.o(259490);
        return numberOfLeadingZeros;
    }

    public static final int mX(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }

    public static final String V(Object obj, Object obj2) {
        AppMethodBeat.i(129569);
        p.h(obj, "from");
        p.h(obj2, "until");
        String str = "Random range is empty: [" + obj + ", " + obj2 + ").";
        AppMethodBeat.o(129569);
        return str;
    }
}

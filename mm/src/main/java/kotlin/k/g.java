package kotlin.k;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.e.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, hxF = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class g implements Iterable<Long>, kotlin.g.b.a.a {
    public static final a SZd = new a((byte) 0);
    public final long BMh;
    public final long SZc;
    public final long first;

    static {
        AppMethodBeat.i(129320);
        AppMethodBeat.o(129320);
    }

    public g(long j2, long j3, long j4) {
        AppMethodBeat.i(129319);
        if (j4 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be non-zero.");
            AppMethodBeat.o(129319);
            throw illegalArgumentException;
        } else if (j4 == Long.MIN_VALUE) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
            AppMethodBeat.o(129319);
            throw illegalArgumentException2;
        } else {
            this.first = j2;
            if (j4 > 0) {
                if (j2 < j3) {
                    j3 -= c.t(j3, j2, j4);
                }
            } else if (j4 >= 0) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Step is zero.");
                AppMethodBeat.o(129319);
                throw illegalArgumentException3;
            } else if (j2 > j3) {
                j3 += c.t(j2, j3, -j4);
            }
            this.SZc = j3;
            this.BMh = j4;
            AppMethodBeat.o(129319);
        }
    }

    public boolean isEmpty() {
        return this.BMh > 0 ? this.first > this.SZc : this.first < this.SZc;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(129316);
        if (!(obj instanceof g) || ((!isEmpty() || !((g) obj).isEmpty()) && !(this.first == ((g) obj).first && this.SZc == ((g) obj).SZc && this.BMh == ((g) obj).BMh))) {
            AppMethodBeat.o(129316);
            return false;
        }
        AppMethodBeat.o(129316);
        return true;
    }

    public int hashCode() {
        AppMethodBeat.i(129317);
        if (isEmpty()) {
            AppMethodBeat.o(129317);
            return -1;
        }
        int i2 = (int) (((((this.first ^ (this.first >>> 32)) * 31) + (this.SZc ^ (this.SZc >>> 32))) * 31) + (this.BMh ^ (this.BMh >>> 32)));
        AppMethodBeat.o(129317);
        return i2;
    }

    public String toString() {
        AppMethodBeat.i(129318);
        if (this.BMh > 0) {
            String str = this.first + ".." + this.SZc + " step " + this.BMh;
            AppMethodBeat.o(129318);
            return str;
        }
        String str2 = this.first + " downTo " + this.SZc + " step " + (-this.BMh);
        AppMethodBeat.o(129318);
        return str2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, hxF = {"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g u(long j2, long j3, long j4) {
            AppMethodBeat.i(129321);
            g gVar = new g(j2, j3, j4);
            AppMethodBeat.o(129321);
            return gVar;
        }
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Long> iterator() {
        AppMethodBeat.i(129315);
        h hVar = new h(this.first, this.SZc, this.BMh);
        AppMethodBeat.o(129315);
        return hVar;
    }
}

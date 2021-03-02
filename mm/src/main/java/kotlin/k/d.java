package kotlin.k;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.e.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, hxF = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class d implements Iterable<Integer>, kotlin.g.b.a.a {
    public static final a SYW = new a((byte) 0);
    public final int SYU;
    public final int SYV;
    public final int lCq;

    static {
        AppMethodBeat.i(129297);
        AppMethodBeat.o(129297);
    }

    public d(int i2, int i3, int i4) {
        AppMethodBeat.i(129296);
        if (i4 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be non-zero.");
            AppMethodBeat.o(129296);
            throw illegalArgumentException;
        } else if (i4 == Integer.MIN_VALUE) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            AppMethodBeat.o(129296);
            throw illegalArgumentException2;
        } else {
            this.SYU = i2;
            if (i4 > 0) {
                if (i2 < i3) {
                    i3 -= c.bf(i3, i2, i4);
                }
            } else if (i4 >= 0) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Step is zero.");
                AppMethodBeat.o(129296);
                throw illegalArgumentException3;
            } else if (i2 > i3) {
                i3 += c.bf(i2, i3, -i4);
            }
            this.SYV = i3;
            this.lCq = i4;
            AppMethodBeat.o(129296);
        }
    }

    public boolean isEmpty() {
        return this.lCq > 0 ? this.SYU > this.SYV : this.SYU < this.SYV;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(129293);
        if (!(obj instanceof d) || ((!isEmpty() || !((d) obj).isEmpty()) && !(this.SYU == ((d) obj).SYU && this.SYV == ((d) obj).SYV && this.lCq == ((d) obj).lCq))) {
            AppMethodBeat.o(129293);
            return false;
        }
        AppMethodBeat.o(129293);
        return true;
    }

    public int hashCode() {
        AppMethodBeat.i(129294);
        if (isEmpty()) {
            AppMethodBeat.o(129294);
            return -1;
        }
        int i2 = (((this.SYU * 31) + this.SYV) * 31) + this.lCq;
        AppMethodBeat.o(129294);
        return i2;
    }

    public String toString() {
        AppMethodBeat.i(129295);
        if (this.lCq > 0) {
            String str = this.SYU + ".." + this.SYV + " step " + this.lCq;
            AppMethodBeat.o(129295);
            return str;
        }
        String str2 = this.SYU + " downTo " + this.SYV + " step " + (-this.lCq);
        AppMethodBeat.o(129295);
        return str2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, hxF = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d bg(int i2, int i3, int i4) {
            AppMethodBeat.i(129305);
            d dVar = new d(i2, i3, i4);
            AppMethodBeat.o(129305);
            return dVar;
        }
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Integer> iterator() {
        AppMethodBeat.i(129292);
        e eVar = new e(this.SYU, this.SYV, this.lCq);
        AppMethodBeat.o(129292);
        return eVar;
    }
}

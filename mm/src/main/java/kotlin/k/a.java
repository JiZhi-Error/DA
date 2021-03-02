package kotlin.k;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, hxF = {"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"})
final class a implements b<Double> {
    private final double SYS;
    private final double SYT = 1.7777777777777777d;

    public a(double d2) {
        this.SYS = d2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.k.c, kotlin.k.b
    public final /* synthetic */ boolean contains(Double d2) {
        AppMethodBeat.i(206220);
        double doubleValue = d2.doubleValue();
        if (doubleValue < this.SYS || doubleValue > this.SYT) {
            AppMethodBeat.o(206220);
            return false;
        }
        AppMethodBeat.o(206220);
        return true;
    }

    private boolean isEmpty() {
        return this.SYS > this.SYT;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(206221);
        if (!(obj instanceof a) || ((!isEmpty() || !((a) obj).isEmpty()) && !(this.SYS == ((a) obj).SYS && this.SYT == ((a) obj).SYT))) {
            AppMethodBeat.o(206221);
            return false;
        }
        AppMethodBeat.o(206221);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(206222);
        if (isEmpty()) {
            AppMethodBeat.o(206222);
            return -1;
        }
        int hashCode = (Double.valueOf(this.SYS).hashCode() * 31) + Double.valueOf(this.SYT).hashCode();
        AppMethodBeat.o(206222);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(206223);
        String str = this.SYS + ".." + this.SYT;
        AppMethodBeat.o(206223);
        return str;
    }
}

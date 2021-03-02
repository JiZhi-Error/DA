package kotlin.k;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, hxF = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class f extends d implements c<Integer> {
    private static final f SZa = new f(1, 0);
    public static final a SZb = new a((byte) 0);

    public f(int i2, int i3) {
        super(i2, i3, 1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.k.c
    public final /* synthetic */ boolean contains(Integer num) {
        AppMethodBeat.i(129322);
        boolean contains = contains(num.intValue());
        AppMethodBeat.o(129322);
        return contains;
    }

    @Override // kotlin.k.d
    public final boolean equals(Object obj) {
        AppMethodBeat.i(129323);
        if (!(obj instanceof f) || ((!isEmpty() || !((f) obj).isEmpty()) && !(this.SYU == ((f) obj).SYU && this.SYV == ((f) obj).SYV))) {
            AppMethodBeat.o(129323);
            return false;
        }
        AppMethodBeat.o(129323);
        return true;
    }

    @Override // kotlin.k.d
    public final int hashCode() {
        AppMethodBeat.i(129324);
        if (isEmpty()) {
            AppMethodBeat.o(129324);
            return -1;
        }
        int i2 = (this.SYU * 31) + this.SYV;
        AppMethodBeat.o(129324);
        return i2;
    }

    @Override // kotlin.k.d
    public final String toString() {
        AppMethodBeat.i(129325);
        String str = this.SYU + ".." + this.SYV;
        AppMethodBeat.o(129325);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(129326);
        AppMethodBeat.o(129326);
    }

    public final boolean contains(int i2) {
        return this.SYU <= i2 && i2 <= this.SYV;
    }

    @Override // kotlin.k.d
    public final boolean isEmpty() {
        return this.SYU > this.SYV;
    }
}

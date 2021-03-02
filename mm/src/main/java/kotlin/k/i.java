package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i extends g implements c<Long> {
    private static final i SZg = new i(1, 0);
    public static final a SZh = new a((byte) 0);

    public i(long j2, long j3) {
        super(j2, j3, 1);
    }

    @Override // kotlin.k.c
    public final /* synthetic */ boolean contains(Long l) {
        AppMethodBeat.i(129298);
        long longValue = l.longValue();
        if (this.first > longValue || longValue > this.SZc) {
            AppMethodBeat.o(129298);
            return false;
        }
        AppMethodBeat.o(129298);
        return true;
    }

    @Override // kotlin.k.g
    public final boolean equals(Object obj) {
        AppMethodBeat.i(129299);
        if (!(obj instanceof i) || ((!isEmpty() || !((i) obj).isEmpty()) && !(this.first == ((i) obj).first && this.SZc == ((i) obj).SZc))) {
            AppMethodBeat.o(129299);
            return false;
        }
        AppMethodBeat.o(129299);
        return true;
    }

    @Override // kotlin.k.g
    public final int hashCode() {
        AppMethodBeat.i(129300);
        if (isEmpty()) {
            AppMethodBeat.o(129300);
            return -1;
        }
        int i2 = (int) ((31 * (this.first ^ (this.first >>> 32))) + (this.SZc ^ (this.SZc >>> 32)));
        AppMethodBeat.o(129300);
        return i2;
    }

    @Override // kotlin.k.g
    public final String toString() {
        AppMethodBeat.i(129301);
        String str = this.first + ".." + this.SZc;
        AppMethodBeat.o(129301);
        return str;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(129302);
        AppMethodBeat.o(129302);
    }

    @Override // kotlin.k.g
    public final boolean isEmpty() {
        return this.first > this.SZc;
    }
}

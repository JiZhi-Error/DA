package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.b.g.c;

public final class d implements Comparable<d> {
    private final String key;
    private final String value;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(d dVar) {
        AppMethodBeat.i(40543);
        d dVar2 = dVar;
        int compareTo = this.key.compareTo(dVar2.key);
        if (compareTo != 0) {
            AppMethodBeat.o(40543);
            return compareTo;
        }
        int compareTo2 = this.value.compareTo(dVar2.value);
        AppMethodBeat.o(40543);
        return compareTo2;
    }

    public d(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public final String hQi() {
        AppMethodBeat.i(40540);
        String concat = c.encode(this.key).concat("=").concat(c.encode(this.value));
        AppMethodBeat.o(40540);
        return concat;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(40541);
        if (obj == null) {
            AppMethodBeat.o(40541);
            return false;
        } else if (obj == this) {
            AppMethodBeat.o(40541);
            return true;
        } else if (!(obj instanceof d)) {
            AppMethodBeat.o(40541);
            return false;
        } else {
            d dVar = (d) obj;
            if (!dVar.key.equals(this.key) || !dVar.value.equals(this.value)) {
                AppMethodBeat.o(40541);
                return false;
            }
            AppMethodBeat.o(40541);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(40542);
        int hashCode = this.key.hashCode() + this.value.hashCode();
        AppMethodBeat.o(40542);
        return hashCode;
    }
}

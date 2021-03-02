package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c<T> {
    private static final c<Void> UjR = new c<>(a.OnCompleted);
    private final a UjQ;
    public final Throwable throwable = null;
    private final T value = null;

    static {
        AppMethodBeat.i(90087);
        AppMethodBeat.o(90087);
    }

    private c(a aVar) {
        this.UjQ = aVar;
    }

    private boolean hasValue() {
        boolean z;
        if (this.UjQ == a.OnNext) {
            z = true;
        } else {
            z = false;
        }
        return z && this.value != null;
    }

    private boolean hQx() {
        boolean z;
        if (this.UjQ == a.OnError) {
            z = true;
        } else {
            z = false;
        }
        return z && this.throwable != null;
    }

    public enum a {
        OnNext,
        OnError,
        OnCompleted;

        public static a valueOf(String str) {
            AppMethodBeat.i(90082);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(90082);
            return aVar;
        }

        static {
            AppMethodBeat.i(90083);
            AppMethodBeat.o(90083);
        }
    }

    public final String toString() {
        AppMethodBeat.i(90084);
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(this.UjQ);
        if (hasValue()) {
            append.append(' ').append((Object) this.value);
        }
        if (hQx()) {
            append.append(' ').append(this.throwable.getMessage());
        }
        append.append(']');
        String sb = append.toString();
        AppMethodBeat.o(90084);
        return sb;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(90086);
        if (obj == null) {
            AppMethodBeat.o(90086);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(90086);
            return true;
        } else if (obj.getClass() != getClass()) {
            AppMethodBeat.o(90086);
            return false;
        } else {
            c cVar = (c) obj;
            if (cVar.UjQ != this.UjQ) {
                AppMethodBeat.o(90086);
                return false;
            } else if (this.value != cVar.value && (this.value == null || !this.value.equals(cVar.value))) {
                AppMethodBeat.o(90086);
                return false;
            } else if (this.throwable == cVar.throwable || (this.throwable != null && this.throwable.equals(cVar.throwable))) {
                AppMethodBeat.o(90086);
                return true;
            } else {
                AppMethodBeat.o(90086);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(90085);
        int hashCode = this.UjQ.hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + this.value.hashCode();
        }
        if (hQx()) {
            hashCode = (hashCode * 31) + this.throwable.hashCode();
        }
        AppMethodBeat.o(90085);
        return hashCode;
    }
}

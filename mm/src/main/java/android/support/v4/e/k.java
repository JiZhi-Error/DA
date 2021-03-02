package android.support.v4.e;

public final class k<F, S> {
    public final F first;
    public final S second;

    public k(F f2, S s) {
        this.first = f2;
        this.second = s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!j.equals(kVar.first, this.first) || !j.equals(kVar.second, this.second)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 0;
        int hashCode = this.first == null ? 0 : this.first.hashCode();
        if (this.second != null) {
            i2 = this.second.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
    }

    public static <A, B> k<A, B> c(A a2, B b2) {
        return new k<>(a2, b2);
    }
}

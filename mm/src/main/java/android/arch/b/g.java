package android.arch.b;

import java.util.Collections;
import java.util.List;

final class g<T> {
    private static final g ez = new g(Collections.EMPTY_LIST);
    public final List<T> eA;
    public final int eB = 0;
    public final int eC = 0;
    public final int eD = 0;

    private g(List<T> list) {
        this.eA = list;
    }

    public final String toString() {
        return "Result " + this.eB + ", " + this.eA + ", " + this.eC + ", offset " + this.eD;
    }

    /* access modifiers changed from: package-private */
    public static abstract class a<T> {
        a() {
        }
    }
}

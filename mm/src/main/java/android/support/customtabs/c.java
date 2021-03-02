package android.support.customtabs;

import android.os.IBinder;

public final class c {
    private final d gF;
    private final a gG = new a() {
        /* class android.support.customtabs.c.AnonymousClass1 */
    };

    c(d dVar) {
        this.gF = dVar;
    }

    /* access modifiers changed from: package-private */
    public final IBinder aS() {
        return this.gF.asBinder();
    }

    public final int hashCode() {
        return aS().hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        return ((c) obj).aS().equals(this.gF.asBinder());
    }
}

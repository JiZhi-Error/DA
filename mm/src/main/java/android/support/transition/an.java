package android.support.transition;

import android.os.IBinder;

/* access modifiers changed from: package-private */
public final class an implements ap {
    private final IBinder En;

    an(IBinder iBinder) {
        this.En = iBinder;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof an) && ((an) obj).En.equals(this.En);
    }

    public final int hashCode() {
        return this.En.hashCode();
    }
}

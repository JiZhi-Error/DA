package android.support.transition;

import android.view.View;
import android.view.WindowId;

/* access modifiers changed from: package-private */
public final class ao implements ap {
    private final WindowId Eo;

    ao(View view) {
        this.Eo = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ao) && ((ao) obj).Eo.equals(this.Eo);
    }

    public final int hashCode() {
        return this.Eo.hashCode();
    }
}

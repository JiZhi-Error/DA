package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* access modifiers changed from: package-private */
public final class af implements ag {
    private final ViewOverlay DH;

    af(View view) {
        this.DH = view.getOverlay();
    }

    @Override // android.support.transition.ag
    public final void add(Drawable drawable) {
        this.DH.add(drawable);
    }

    @Override // android.support.transition.ag
    public final void remove(Drawable drawable) {
        this.DH.remove(drawable);
    }
}

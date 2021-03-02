package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class z implements aa {
    private final ViewGroupOverlay Dt;

    z(ViewGroup viewGroup) {
        this.Dt = viewGroup.getOverlay();
    }

    @Override // android.support.transition.ag
    public final void add(Drawable drawable) {
        this.Dt.add(drawable);
    }

    @Override // android.support.transition.ag
    public final void remove(Drawable drawable) {
        this.Dt.remove(drawable);
    }

    @Override // android.support.transition.aa
    public final void add(View view) {
        this.Dt.add(view);
    }

    @Override // android.support.transition.aa
    public final void remove(View view) {
        this.Dt.remove(view);
    }
}

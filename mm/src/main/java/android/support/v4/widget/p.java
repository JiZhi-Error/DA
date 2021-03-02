package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class p {
    public OverScroller UD;

    @Deprecated
    public static p a(Context context, Interpolator interpolator) {
        return new p(context, interpolator);
    }

    private p(Context context, Interpolator interpolator) {
        this.UD = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public final void startScroll(int i2, int i3, int i4, int i5, int i6) {
        this.UD.startScroll(i2, i3, i4, i5, i6);
    }
}

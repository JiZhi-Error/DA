package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

public final class i {
    public EdgeEffect Uv;

    @Deprecated
    public i(Context context) {
        this.Uv = new EdgeEffect(context);
    }

    @Deprecated
    public final void setSize(int i2, int i3) {
        this.Uv.setSize(i2, i3);
    }

    @Deprecated
    public final boolean G(float f2) {
        this.Uv.onPull(f2);
        return true;
    }

    public static void a(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
        } else {
            edgeEffect.onPull(f2);
        }
    }

    @Deprecated
    public final boolean ga() {
        this.Uv.onRelease();
        return this.Uv.isFinished();
    }

    @Deprecated
    public final boolean aX(int i2) {
        this.Uv.onAbsorb(i2);
        return true;
    }

    @Deprecated
    public final boolean draw(Canvas canvas) {
        return this.Uv.draw(canvas);
    }
}

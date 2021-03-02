package com.tencent.mm.plugin.festival.ui.a.a;

import android.view.animation.Interpolator;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/animation/interpolator/EaseInOut;", "Landroid/view/animation/Interpolator;", "()V", "getInterpolation", "", "input", "plugin-festival_release"})
public final class a implements Interpolator {
    public final float getInterpolation(float f2) {
        if (f2 < 0.5f) {
            float f3 = f2 * 2.0f;
            return f3 * 0.5f * f3 * f3 * f3 * f3;
        }
        float f4 = ((f2 - 0.5f) * 2.0f) - 1.0f;
        return (f4 * 0.5f * f4 * f4 * f4 * f4) + 1.0f;
    }
}

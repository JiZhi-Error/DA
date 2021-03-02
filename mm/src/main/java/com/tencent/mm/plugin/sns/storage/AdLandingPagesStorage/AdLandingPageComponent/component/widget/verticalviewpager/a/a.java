package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements ViewPager.d {
    @Override // android.support.v4.view.ViewPager.d
    public final void o(View view, float f2) {
        float f3 = 0.0f;
        AppMethodBeat.i(97128);
        if (0.0f <= f2 && f2 <= 1.0f) {
            f3 = 1.0f - f2;
        } else if (-1.0f < f2 && f2 < 0.0f) {
            f3 = f2 + 1.0f;
        }
        view.setAlpha(f3);
        view.setTranslationX(((float) view.getWidth()) * (-f2));
        view.setTranslationY(((float) view.getHeight()) * f2);
        AppMethodBeat.o(97128);
    }
}

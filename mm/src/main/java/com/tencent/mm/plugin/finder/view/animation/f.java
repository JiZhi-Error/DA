package com.tencent.mm.plugin.finder.view.animation;

import android.support.v4.view.u;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static void ej(View view) {
        AppMethodBeat.i(168682);
        u.g(view, 1.0f);
        u.i(view, 1.0f);
        u.h(view, 1.0f);
        u.f(view, 0.0f);
        u.e(view, 0.0f);
        u.ai(view);
        u.ak(view);
        u.aj(view);
        u.k(view, (float) (view.getMeasuredHeight() / 2));
        u.j(view, (float) (view.getMeasuredWidth() / 2));
        u.ah(view).a((Interpolator) null).k(0);
        AppMethodBeat.o(168682);
    }
}

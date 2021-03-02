package com.tencent.mm.ui.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.c.b.c;

public final class a {
    public static Animation he(Context context) {
        AppMethodBeat.i(141578);
        if (context == null) {
            Log.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            AppMethodBeat.o(141578);
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.r);
        if (-1 > 0) {
            loadAnimation.setDuration(-1);
        }
        loadAnimation.setInterpolator(new c());
        AppMethodBeat.o(141578);
        return loadAnimation;
    }
}

package com.tencent.mm.ui.f;

import android.graphics.drawable.AnimationDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends AnimationDrawable {
    private static String TAG = "MMAnimationDrawable";

    public final void start() {
        AppMethodBeat.i(142749);
        super.start();
        AppMethodBeat.o(142749);
    }

    public final void stop() {
        AppMethodBeat.i(142750);
        super.stop();
        AppMethodBeat.o(142750);
    }
}

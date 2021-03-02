package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o {
    public static void hp(View view) {
        AppMethodBeat.i(259388);
        hq(view);
        AppMethodBeat.o(259388);
    }

    public static void hq(View view) {
        AppMethodBeat.i(143210);
        if (view == null) {
            AppMethodBeat.o(143210);
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.o.AnonymousClass1 */
            final /* synthetic */ float QvN = 0.7f;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(143208);
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setAlpha(this.QvN);
                        break;
                    case 1:
                    case 3:
                        view.setAlpha(1.0f);
                        break;
                }
                if (view.isClickable() || view.isLongClickable()) {
                    AppMethodBeat.o(143208);
                    return false;
                }
                AppMethodBeat.o(143208);
                return true;
            }
        });
        AppMethodBeat.o(143210);
    }

    public static void hr(View view) {
        AppMethodBeat.i(205375);
        if (view != null) {
            view.setOnTouchListener(null);
        }
        AppMethodBeat.o(205375);
    }
}

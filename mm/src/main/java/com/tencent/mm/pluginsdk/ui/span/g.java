package com.tencent.mm.pluginsdk.ui.span;

import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.Log;

public final class g {
    private static int gp(View view) {
        AppMethodBeat.i(152265);
        int i2 = 0;
        if (view instanceof TextView) {
            i2 = ((TextView) view).getLineCount();
        } else if (view instanceof StaticTextView) {
            i2 = ((StaticTextView) view).getLineCount();
        }
        AppMethodBeat.o(152265);
        return i2;
    }

    private static int aD(View view, int i2) {
        AppMethodBeat.i(152266);
        if (view instanceof TextView) {
            if (((TextView) view).getLayout() == null) {
                AppMethodBeat.o(152266);
                return 0;
            }
            int lineEnd = ((TextView) view).getLayout().getLineEnd(i2);
            AppMethodBeat.o(152266);
            return lineEnd;
        } else if (!(view instanceof StaticTextView)) {
            AppMethodBeat.o(152266);
            return 0;
        } else if (((StaticTextView) view).getTvLayout() == null) {
            AppMethodBeat.o(152266);
            return 0;
        } else {
            int lineEnd2 = ((StaticTextView) view).getTvLayout().getLineEnd(i2);
            AppMethodBeat.o(152266);
            return lineEnd2;
        }
    }

    public static boolean a(View view, Spanned spanned) {
        AppMethodBeat.i(152267);
        if (!(view == null || spanned == null || !((view instanceof TextView) || (view instanceof StaticTextView)))) {
            int gp = gp(view);
            if (gp != 1 || spanned.length() <= 500) {
                for (int i2 = 1; i2 < gp; i2++) {
                    if (aD(view, i2) - aD(view, i2 - 1) > 500) {
                        Log.e("MicroMsg.InvalidTextCheck", "error black dot");
                        AppMethodBeat.o(152267);
                        return true;
                    }
                }
            } else {
                Log.e("MicroMsg.InvalidTextCheck", "error black dot");
                AppMethodBeat.o(152267);
                return true;
            }
        }
        AppMethodBeat.o(152267);
        return false;
    }
}

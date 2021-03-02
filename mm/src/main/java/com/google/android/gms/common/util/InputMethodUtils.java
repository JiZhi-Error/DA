package com.google.android.gms.common.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputMethodUtils {
    private InputMethodUtils() {
    }

    public static boolean hideSoftInput(Context context, View view) {
        AppMethodBeat.i(5261);
        InputMethodManager zzf = zzf(context);
        if (zzf != null) {
            zzf.hideSoftInputFromWindow(view.getWindowToken(), 0);
            AppMethodBeat.o(5261);
            return true;
        }
        AppMethodBeat.o(5261);
        return false;
    }

    public static boolean isAcceptingText(Context context) {
        AppMethodBeat.i(5263);
        InputMethodManager zzf = zzf(context);
        if (zzf != null) {
            boolean isAcceptingText = zzf.isAcceptingText();
            AppMethodBeat.o(5263);
            return isAcceptingText;
        }
        AppMethodBeat.o(5263);
        return false;
    }

    public static void restart(Context context, View view) {
        AppMethodBeat.i(5262);
        InputMethodManager zzf = zzf(context);
        if (zzf != null) {
            zzf.restartInput(view);
        }
        AppMethodBeat.o(5262);
    }

    public static boolean showSoftInput(Context context, View view) {
        AppMethodBeat.i(5260);
        InputMethodManager zzf = zzf(context);
        if (zzf != null) {
            zzf.showSoftInput(view, 0);
            AppMethodBeat.o(5260);
            return true;
        }
        AppMethodBeat.o(5260);
        return false;
    }

    private static InputMethodManager zzf(Context context) {
        AppMethodBeat.i(5259);
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        AppMethodBeat.o(5259);
        return inputMethodManager;
    }
}

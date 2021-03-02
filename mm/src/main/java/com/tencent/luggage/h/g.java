package com.tencent.luggage.h;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    public static boolean aM(Context context) {
        boolean z;
        AppMethodBeat.i(140517);
        if (context == null) {
            AppMethodBeat.o(140517);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(140517);
            return false;
        }
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            AppMethodBeat.o(140517);
            return false;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(140517);
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(140517);
            return false;
        }
        try {
            z = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e2) {
            z = false;
        }
        AppMethodBeat.o(140517);
        return z;
    }
}

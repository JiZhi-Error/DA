package com.tencent.mm.plugin.taskbar.ui.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Pair;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ao;

public final class b {
    public static boolean hq(Context context) {
        View findViewById;
        AppMethodBeat.i(238387);
        if ((context instanceof Activity) && (findViewById = ((ViewGroup) ((Activity) context).getWindow().getDecorView()).findViewById(16908290)) != null) {
            Rect rect = new Rect();
            findViewById.getGlobalVisibleRect(rect);
            if (rect.left > 0) {
                AppMethodBeat.o(238387);
                return true;
            }
        }
        AppMethodBeat.o(238387);
        return false;
    }

    public static Pair<Integer, Integer> aO(Activity activity) {
        WindowInsets rootWindowInsets;
        AppMethodBeat.i(238388);
        Pair<Integer, Integer> pair = new Pair<>(0, 0);
        if (activity == null || !MMHandlerThread.isMainThread()) {
            AppMethodBeat.o(238388);
            return pair;
        }
        try {
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 0 || rotation == 2) {
                AppMethodBeat.o(238388);
                return pair;
            } else if (Build.VERSION.SDK_INT < 28 || (rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets()) == null || rootWindowInsets.getDisplayCutout() == null) {
                int aP = ao.aP(activity);
                Log.i("MicroMsg.TaskBarUIUtils", "getLeftRightSafeInsets from statusbar %d %d", Integer.valueOf(aP), Integer.valueOf(rotation));
                if (rotation == 1) {
                    Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(aP), 0);
                    AppMethodBeat.o(238388);
                    return pair2;
                }
                Pair<Integer, Integer> pair3 = new Pair<>(0, Integer.valueOf(aP));
                AppMethodBeat.o(238388);
                return pair3;
            } else {
                DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
                Log.i("MicroMsg.TaskBarUIUtils", "getLeftRightSafeInsets from insets %d %d", Integer.valueOf(displayCutout.getSafeInsetLeft()), Integer.valueOf(displayCutout.getSafeInsetRight()));
                Pair<Integer, Integer> pair4 = new Pair<>(Integer.valueOf(displayCutout.getSafeInsetLeft()), Integer.valueOf(displayCutout.getSafeInsetRight()));
                AppMethodBeat.o(238388);
                return pair4;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.TaskBarUIUtils", "getSafeInsetsFailed", e2);
            AppMethodBeat.o(238388);
            return pair;
        }
    }
}

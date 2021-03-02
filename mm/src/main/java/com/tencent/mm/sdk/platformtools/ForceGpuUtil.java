package com.tencent.mm.sdk.platformtools;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ForceGpuUtil {
    private static final String TAG = "MicroMsg.ForceGpuUtil";
    public static boolean canGetTextureSize;

    static {
        AppMethodBeat.i(185116);
        canGetTextureSize = true;
        canGetTextureSize = true;
        setMaxTextureGet(true);
        AppMethodBeat.o(185116);
    }

    public static void setLayerType(View view) {
    }

    public static void decideLayerType(View view, int i2, int i3) {
        AppMethodBeat.i(157543);
        if (view == null) {
            AppMethodBeat.o(157543);
            return;
        }
        Help30Impl.getInstance().decideLayerType(view, i2, i3);
        AppMethodBeat.o(157543);
    }

    public static boolean canUseHardwareAcceleration(int i2, int i3) {
        AppMethodBeat.i(157544);
        boolean canUseHardwareAcceleration = Help30Impl.getInstance().canUseHardwareAcceleration(i2, i3);
        AppMethodBeat.o(157544);
        return canUseHardwareAcceleration;
    }

    public static int getMaxTextureSize() {
        AppMethodBeat.i(230294);
        int maxTextureSize = Help30Impl.getInstance().getMaxTextureSize();
        AppMethodBeat.o(230294);
        return maxTextureSize;
    }

    public static void setMaxTextureGet(boolean z) {
        AppMethodBeat.i(157545);
        Log.i(TAG, "setMaxTextureGet: %s, canGetTextureSize %s.", Boolean.valueOf(z), Boolean.valueOf(canGetTextureSize));
        if (z && canGetTextureSize) {
            Help30Impl.getInstance().updateTextureMaxSize();
        }
        AppMethodBeat.o(157545);
    }
}

package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

@Deprecated
public final class i extends KeyBoardUtil {
    public static final int apt() {
        return CONTENT_HEIGHT;
    }

    @TargetApi(11)
    public static final void v(Activity activity) {
        AppMethodBeat.i(155903);
        if (activity == null) {
            AppMethodBeat.o(155903);
            return;
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        CONTENT_HEIGHT = (activity.getResources().getDisplayMetrics().heightPixels - a.u(activity)) - rect.top;
        AppMethodBeat.o(155903);
    }

    public static final void C(Context context, int i2) {
        AppMethodBeat.i(155904);
        int minPanelHeightPx = KeyBoardUtil.getMinPanelHeightPx(context);
        int maxPanelHeightPx = KeyBoardUtil.getMaxPanelHeightPx(context);
        if (i2 >= minPanelHeightPx) {
            minPanelHeightPx = i2;
        }
        if (minPanelHeightPx <= maxPanelHeightPx) {
            maxPanelHeightPx = minPanelHeightPx;
        }
        saveKeyBordHeightPx(context, maxPanelHeightPx);
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(KeyBoardUtil.KEYBORD_HEIGHT_PX_PREFS, maxPanelHeightPx);
        AppMethodBeat.o(155904);
    }

    public static final int apu() {
        AppMethodBeat.i(155905);
        int i2 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt(KeyBoardUtil.KEYBORD_HEIGHT_PX_PREFS, 0);
        AppMethodBeat.o(155905);
        return i2;
    }
}

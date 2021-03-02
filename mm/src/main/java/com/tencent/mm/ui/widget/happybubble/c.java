package com.tencent.mm.ui.widget.happybubble;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static int[] getScreenWH(Context context) {
        AppMethodBeat.i(143558);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int[] iArr = {displayMetrics.widthPixels, displayMetrics.heightPixels};
        AppMethodBeat.o(143558);
        return iArr;
    }
}

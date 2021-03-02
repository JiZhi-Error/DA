package com.tencent.mm.ui.i;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static b QkV;
    private static b QkW;

    @TargetApi(11)
    public static void c(Activity activity, View view) {
        AppMethodBeat.i(142857);
        View decorView = activity.getWindow().getDecorView();
        QkV = b.kz(activity);
        QkW = b.kz(activity);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int height = ((AppCompatActivity) activity).getSupportActionBar().getHeight();
        QkV.setHeight((iArr[1] - i2) - height);
        QkW.setHeight((getScreenWH(activity)[1] - iArr[1]) - view.getHeight());
        QkV.showAtLocation(decorView, 48, 0, height + i2);
        QkW.showAtLocation(decorView, 80, 0, 0);
        AppMethodBeat.o(142857);
    }

    public static void dismiss() {
        AppMethodBeat.i(142858);
        if (QkV != null) {
            QkV.setAnimationStyle(-1);
            QkV.dismiss();
            QkV = null;
        }
        if (QkW != null) {
            QkW.setAnimationStyle(-1);
            QkW.dismiss();
            QkW = null;
        }
        AppMethodBeat.o(142858);
    }

    private static int[] getScreenWH(Context context) {
        AppMethodBeat.i(142859);
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        AppMethodBeat.o(142859);
        return iArr;
    }
}

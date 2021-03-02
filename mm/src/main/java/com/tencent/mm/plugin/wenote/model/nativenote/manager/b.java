package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class b {
    private static float cPs = Float.MAX_VALUE;
    private static float qQS = Float.MAX_VALUE;
    private static int qQT = -1;
    public static float qQU = 48.0f;

    private static float cDC() {
        float f2;
        synchronized (b.class) {
            if (cPs == Float.MAX_VALUE) {
                cPs = getDisplayMetrics().density;
            }
            f2 = cPs;
        }
        return f2;
    }

    public static float getTextSize() {
        return qQU;
    }

    public static void setTextSize(float f2) {
        qQU = f2;
    }

    public static int Fz(int i2) {
        return Math.round(((float) i2) * cDD());
    }

    public static int FA(int i2) {
        return Math.round(((float) i2) / cDD());
    }

    private static DisplayMetrics getDisplayMetrics() {
        Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static float cDD() {
        float f2;
        synchronized (b.class) {
            if (qQS == Float.MAX_VALUE) {
                qQS = getDisplayMetrics().density * MMApplicationContext.getContext().getResources().getConfiguration().fontScale;
            }
            f2 = qQS;
        }
        return f2;
    }

    public static int cDE() {
        if (qQT == -1) {
            qQT = Math.round(cDC() * 30.0f);
        }
        return qQT;
    }
}

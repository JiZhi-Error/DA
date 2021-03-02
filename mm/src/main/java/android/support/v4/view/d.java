package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

public final class d {
    public static void apply(int i2, int i3, int i4, Rect rect, Rect rect2, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(i2, i3, i4, rect, rect2, i5);
        } else {
            Gravity.apply(i2, i3, i4, rect, rect2);
        }
    }

    public static int getAbsoluteGravity(int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Gravity.getAbsoluteGravity(i2, i3);
        }
        return -8388609 & i2;
    }
}

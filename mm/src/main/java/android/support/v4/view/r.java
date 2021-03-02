package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class r {
    Object QG;

    private r(Object obj) {
        this.QG = obj;
    }

    public static r Y(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new r(PointerIcon.getSystemIcon(context, 1002));
        }
        return new r(null);
    }
}

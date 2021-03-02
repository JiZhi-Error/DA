package android.support.v4.view;

import android.os.Build;
import android.view.ViewGroup;

public final class w {
    public static int b(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return viewGroup.getLayoutMode();
        }
        return 0;
    }
}

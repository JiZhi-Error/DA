package android.support.transition;

import android.os.Build;
import android.view.ViewGroup;

final class ab {
    static void c(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            ad.c(viewGroup, z);
        } else {
            ac.c(viewGroup, z);
        }
    }
}

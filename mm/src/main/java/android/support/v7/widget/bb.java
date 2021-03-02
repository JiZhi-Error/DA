package android.support.v7.widget;

import android.os.Build;
import android.view.View;

public final class bb {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            bc.a(view, charSequence);
        }
    }
}

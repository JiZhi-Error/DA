package android.support.v4.view.a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public final class a {
    public static void a(AccessibilityEvent accessibilityEvent, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i2);
        }
    }
}

package android.support.v4.d;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public final class f {
    private static final Locale ROOT = new Locale("", "");

    public static int getLayoutDirectionFromLocale(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(ROOT)) {
            String b2 = b.b(locale);
            if (b2 == null) {
                switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                    case 1:
                    case 2:
                        return 1;
                    default:
                        return 0;
                }
            } else if (b2.equalsIgnoreCase("Arab") || b2.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }
}

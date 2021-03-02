package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SensitiveUserDataUtils {
    public static boolean isSensitiveUserData(View view) {
        AppMethodBeat.i(17542);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (isPassword(textView) || isCreditCard(textView) || isPersonName(textView) || isPostalAddress(textView) || isPhoneNumber(textView) || isEmail(textView)) {
                AppMethodBeat.o(17542);
                return true;
            }
            AppMethodBeat.o(17542);
            return false;
        }
        AppMethodBeat.o(17542);
        return false;
    }

    private static boolean isPassword(TextView textView) {
        AppMethodBeat.i(17543);
        if (textView.getInputType() == 128) {
            AppMethodBeat.o(17543);
            return true;
        }
        boolean z = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        AppMethodBeat.o(17543);
        return z;
    }

    private static boolean isEmail(TextView textView) {
        AppMethodBeat.i(17544);
        if (textView.getInputType() == 32) {
            AppMethodBeat.o(17544);
            return true;
        }
        String textOfView = ViewHierarchy.getTextOfView(textView);
        if (textOfView == null || textOfView.length() == 0) {
            AppMethodBeat.o(17544);
            return false;
        }
        boolean matches = Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
        AppMethodBeat.o(17544);
        return matches;
    }

    private static boolean isPersonName(TextView textView) {
        AppMethodBeat.i(17545);
        if (textView.getInputType() == 96) {
            AppMethodBeat.o(17545);
            return true;
        }
        AppMethodBeat.o(17545);
        return false;
    }

    private static boolean isPostalAddress(TextView textView) {
        AppMethodBeat.i(17546);
        if (textView.getInputType() == 112) {
            AppMethodBeat.o(17546);
            return true;
        }
        AppMethodBeat.o(17546);
        return false;
    }

    private static boolean isPhoneNumber(TextView textView) {
        AppMethodBeat.i(17547);
        if (textView.getInputType() == 3) {
            AppMethodBeat.o(17547);
            return true;
        }
        AppMethodBeat.o(17547);
        return false;
    }

    private static boolean isCreditCard(TextView textView) {
        boolean z;
        AppMethodBeat.i(17548);
        String replaceAll = ViewHierarchy.getTextOfView(textView).replaceAll("\\s", "");
        int length = replaceAll.length();
        if (length < 12 || length > 19) {
            AppMethodBeat.o(17548);
            return false;
        }
        boolean z2 = false;
        int i2 = 0;
        int i3 = length - 1;
        while (i3 >= 0) {
            char charAt = replaceAll.charAt(i3);
            if (charAt < '0' || charAt > '9') {
                AppMethodBeat.o(17548);
                return false;
            }
            int i4 = charAt - '0';
            if (z2 && (i4 = i4 * 2) > 9) {
                i4 = (i4 % 10) + 1;
            }
            i2 += i4;
            if (!z2) {
                z = true;
            } else {
                z = false;
            }
            i3--;
            z2 = z;
        }
        if (i2 % 10 == 0) {
            AppMethodBeat.o(17548);
            return true;
        }
        AppMethodBeat.o(17548);
        return false;
    }
}

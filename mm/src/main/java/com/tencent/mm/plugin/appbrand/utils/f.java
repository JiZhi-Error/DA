package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public final class f {
    private static final char[] INVALID = {'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] VALID = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    private static final Set<Object> lwZ = new HashSet();

    public static long currentTime() {
        AppMethodBeat.i(135350);
        long nowSecond = Util.nowSecond();
        AppMethodBeat.o(135350);
        return nowSecond;
    }

    public static String getMMString(int i2, Object... objArr) {
        AppMethodBeat.i(135351);
        String string = MMApplicationContext.getResources().getString(i2, objArr);
        AppMethodBeat.o(135351);
        return string;
    }

    static {
        AppMethodBeat.i(135362);
        AppMethodBeat.o(135362);
    }

    public static <T> T cP(T t) {
        AppMethodBeat.i(135352);
        lwZ.add(t);
        AppMethodBeat.o(135352);
        return t;
    }

    public static void bs(Object obj) {
        AppMethodBeat.i(135353);
        lwZ.remove(obj);
        AppMethodBeat.o(135353);
    }

    @Deprecated
    public static void bZm() {
        AppMethodBeat.i(135354);
        m.bZm();
        AppMethodBeat.o(135354);
    }

    @Deprecated
    public static m.a bZn() {
        AppMethodBeat.i(219591);
        m.a bZn = m.bZn();
        AppMethodBeat.o(219591);
        return bZn;
    }

    public static String afH(String str) {
        AppMethodBeat.i(135356);
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = 0;
            while (i3 < INVALID.length) {
                String str2 = VALID[i3];
                int i4 = 0;
                while (i4 < str2.length() && i2 + i4 < length && str2.charAt(i4) == str.charAt(i2 + i4)) {
                    i4++;
                }
                if (i4 == str2.length()) {
                    break;
                }
                i3++;
            }
            if (i3 != INVALID.length) {
                stringBuffer.append(INVALID[i3]);
                i2 = VALID[i3].length() + i2;
            } else {
                stringBuffer.append(str.charAt(i2));
                i2++;
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(135356);
        return stringBuffer2;
    }

    public static String afI(String str) {
        AppMethodBeat.i(135357);
        if (str == null) {
            AppMethodBeat.o(135357);
            return null;
        }
        String replace = str.replace((char) 8232, '\n').replace((char) 8233, '\n');
        AppMethodBeat.o(135357);
        return replace;
    }

    public static String d(ComponentName componentName) {
        AppMethodBeat.i(135358);
        String str = "[UNKNOWN]";
        if (componentName == null) {
            AppMethodBeat.o(135358);
        } else {
            PackageManager packageManager = MMApplicationContext.getContext().getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.o(135358);
            } else {
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
                    if (activityInfo != null) {
                        str = activityInfo.taskAffinity;
                        AppMethodBeat.o(135358);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", e2);
                }
                AppMethodBeat.o(135358);
            }
        }
        return str;
    }
}

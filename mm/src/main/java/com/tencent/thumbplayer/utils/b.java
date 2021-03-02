package com.tencent.thumbplayer.utils;

import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class b {
    public static final int SDK_INT = ((Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT);

    public static boolean isEmpty(Collection<? extends Object> collection) {
        AppMethodBeat.i(189618);
        if (collection == null || collection.size() <= 0) {
            AppMethodBeat.o(189618);
            return true;
        }
        AppMethodBeat.o(189618);
        return false;
    }

    public static boolean isEmpty(Map<? extends Object, ? extends Object> map) {
        AppMethodBeat.i(189619);
        if (map == null || map.size() <= 0) {
            AppMethodBeat.o(189619);
            return true;
        }
        AppMethodBeat.o(189619);
        return false;
    }

    public static void e(Object obj, String str) {
        AppMethodBeat.i(189620);
        if (obj == null) {
            if (TextUtils.isEmpty(str)) {
                str = "this argument should not be null!";
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
            AppMethodBeat.o(189620);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(189620);
    }

    public static String aSu(String str) {
        AppMethodBeat.i(189621);
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            StringBuilder sb = new StringBuilder(40);
            for (byte b2 : digest) {
                if (((b2 & 255) >> 4) == 0) {
                    sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(Integer.toHexString(b2 & 255));
                } else {
                    sb.append(Integer.toHexString(b2 & 255));
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(189621);
            return sb2;
        } catch (Exception e2) {
            g.e("TPCommonUtils", e2.toString());
            AppMethodBeat.o(189621);
            return null;
        }
    }

    public static int bqF(String str) {
        AppMethodBeat.i(189622);
        if (!TextUtils.isEmpty(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                AppMethodBeat.o(189622);
                return parseInt;
            } catch (NumberFormatException e2) {
                g.e("TPCommonUtils", e2);
            }
        }
        AppMethodBeat.o(189622);
        return 0;
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(189623);
        try {
            if (!Pattern.compile("-?[0-9]+(\\.[0-9]+)?").matcher(new BigDecimal(str).toString()).matches()) {
                AppMethodBeat.o(189623);
                return false;
            }
            AppMethodBeat.o(189623);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(189623);
            return false;
        }
    }

    public static boolean bnL(String str) {
        AppMethodBeat.i(189624);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(189624);
            return false;
        }
        try {
            boolean matches = str.split(":")[0].matches("^((https|http|ftp|rtsp|mms)?)");
            AppMethodBeat.o(189624);
            return matches;
        } catch (PatternSyntaxException e2) {
            AppMethodBeat.o(189624);
            return false;
        }
    }

    static {
        AppMethodBeat.i(189625);
        AppMethodBeat.o(189625);
    }
}

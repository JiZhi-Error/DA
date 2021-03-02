package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public class UnicodeUtils {
    private static final Pattern zzaal = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    static {
        AppMethodBeat.i(5300);
        AppMethodBeat.o(5300);
    }

    public static String unescape(String str) {
        AppMethodBeat.i(5299);
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = zzaal.matcher(str);
            StringBuffer stringBuffer = null;
            while (matcher.find()) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                matcher.appendReplacement(stringBuffer, new String(Character.toChars(Integer.parseInt(matcher.group().substring(2), 16))));
            }
            if (stringBuffer == null) {
                AppMethodBeat.o(5299);
                return str;
            }
            matcher.appendTail(stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(5299);
            return stringBuffer2;
        }
        AppMethodBeat.o(5299);
        return str;
    }
}

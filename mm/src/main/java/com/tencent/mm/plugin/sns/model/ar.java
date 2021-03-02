package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class ar {
    private static final Map<String, String> DMG = new HashMap();

    static {
        AppMethodBeat.i(95922);
        AppMethodBeat.o(95922);
    }

    public static String ki(String str, String str2) {
        AppMethodBeat.i(95920);
        if (str == null || str2 == null) {
            AppMethodBeat.o(95920);
            return "";
        }
        boolean equals = Looper.getMainLooper().equals(Looper.myLooper());
        if (equals && DMG.containsKey(str + str2)) {
            String str3 = DMG.get(str + str2);
            if (!Util.isNullOrNil(str3)) {
                AppMethodBeat.o(95920);
                return str3;
            }
        }
        String messageDigest = g.getMessageDigest(str2.getBytes());
        StringBuffer stringBuffer = new StringBuffer(str);
        if (messageDigest.length() > 0) {
            stringBuffer.append(messageDigest.charAt(0));
            stringBuffer.append(FilePathGenerator.ANDROID_DIR_SEP);
        }
        if (messageDigest.length() >= 2) {
            stringBuffer.append(messageDigest.charAt(1));
            stringBuffer.append(FilePathGenerator.ANDROID_DIR_SEP);
        }
        if (equals) {
            DMG.put(str + str2, stringBuffer.toString());
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(95920);
        return stringBuffer2;
    }

    public static synchronized void release() {
        synchronized (ar.class) {
            AppMethodBeat.i(95921);
            DMG.clear();
            AppMethodBeat.o(95921);
        }
    }
}

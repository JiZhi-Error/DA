package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TPDLProxyUtils {
    private static final String FILE_NAME = "TPDLProxyUtils";

    public static String byteArrayToString(byte[] bArr) {
        String str;
        AppMethodBeat.i(210157);
        if (bArr == null) {
            AppMethodBeat.o(210157);
            return "";
        }
        try {
            str = new String(bArr, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "byteArrayToString failed, error:" + th.toString());
            str = "";
        }
        AppMethodBeat.o(210157);
        return str;
    }

    public static int objectToInt(Object obj, int i2) {
        AppMethodBeat.i(210158);
        if (obj == null) {
            AppMethodBeat.o(210158);
        } else {
            try {
                i2 = ((Integer) obj).intValue();
                AppMethodBeat.o(210158);
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "object to int failed, error:" + th.toString());
                AppMethodBeat.o(210158);
            }
        }
        return i2;
    }

    public static long objectToLong(Object obj, long j2) {
        AppMethodBeat.i(210159);
        if (obj == null) {
            AppMethodBeat.o(210159);
        } else {
            try {
                j2 = ((Long) obj).longValue();
                AppMethodBeat.o(210159);
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "object to long failed, error:" + th.toString());
                AppMethodBeat.o(210159);
            }
        }
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0087 A[SYNTHETIC, Splitter:B:22:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d7 A[SYNTHETIC, Splitter:B:34:0x00d7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String serialize(java.lang.Object r10) {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils.serialize(java.lang.Object):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0088 A[SYNTHETIC, Splitter:B:23:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008d A[SYNTHETIC, Splitter:B:26:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d7 A[SYNTHETIC, Splitter:B:36:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dc A[SYNTHETIC, Splitter:B:39:0x00dc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object serializeToObject(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 302
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils.serializeToObject(java.lang.String):java.lang.Object");
    }

    public static String losePackageCheck(int i2) {
        AppMethodBeat.i(210162);
        String str = "";
        String str2 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ping -c " + i2 + " www.qq.com").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains(" packet loss")) {
                    str = readLine.substring(readLine.indexOf("received, ") + "received, ".length(), readLine.indexOf("%") + 1);
                }
                if (readLine.contains("avg")) {
                    int indexOf = readLine.indexOf(FilePathGenerator.ANDROID_DIR_SEP, 20);
                    str2 = readLine.substring(indexOf + 1, readLine.indexOf(".", indexOf));
                }
            }
        } catch (Throwable th) {
        }
        String str3 = str + ";" + str2;
        AppMethodBeat.o(210162);
        return str3;
    }
}

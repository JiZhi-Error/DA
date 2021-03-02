package com.tencent.matrix.g;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.XWalkAppVersion;

public final class d {
    private static final ThreadLocal<MessageDigest> dfc = new ThreadLocal<MessageDigest>() {
        /* class com.tencent.matrix.g.d.AnonymousClass1 */

        private static MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException("Initialize MD5 failed.", e2);
            }
        }
    };
    private static final ThreadLocal<MessageDigest> dfd = new ThreadLocal<MessageDigest>() {
        /* class com.tencent.matrix.g.d.AnonymousClass2 */

        private static MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException("Initialize SHA256-DIGEST failed.", e2);
            }
        }
    };
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String processName = null;

    public static String formatTime(String str, long j2) {
        return new SimpleDateFormat(str).format(new Date(j2));
    }

    public static String getProcessName(Context context) {
        if (processName != null) {
            return processName;
        }
        String processNameInternal = getProcessNameInternal(context);
        processName = processNameInternal;
        return processNameInternal;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b4 A[SYNTHETIC, Splitter:B:46:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c1 A[SYNTHETIC, Splitter:B:53:0x00c1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getProcessNameInternal(android.content.Context r7) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.g.d.getProcessNameInternal(android.content.Context):java.lang.String");
    }

    public static String g(Exception exc) {
        StackTraceElement[] stackTrace = exc.getStackTrace();
        if (stackTrace == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(exc.toString());
        for (int i2 = 2; i2 < stackTrace.length; i2++) {
            sb.append('[');
            sb.append(stackTrace[i2].getClassName());
            sb.append(':');
            sb.append(stackTrace[i2].getMethodName());
            sb.append("(" + stackTrace[i2].getLineNumber() + ")]");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    public static String getMD5String(String str) {
        byte[] digest = dfc.get().digest(str.getBytes());
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i2 = length + 0;
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = digest[i3];
            char c2 = hexDigits[(b2 & 240) >> 4];
            char c3 = hexDigits[b2 & 15];
            stringBuffer.append(c2);
            stringBuffer.append(c3);
        }
        return stringBuffer.toString();
    }

    public static long eT(String str) {
        if (str == null) {
            return 0;
        }
        try {
            if (str.length() <= 0) {
                return 0;
            }
            return Long.decode(str).longValue();
        } catch (NumberFormatException e2) {
            c.printErrStackTrace("Matrix.MatrixUtil", e2, "", new Object[0]);
            return 0;
        }
    }
}

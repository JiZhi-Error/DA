package com.tencent.mm.plugin.wallet.pwd.a;

import android.os.Build;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;

public final class u {
    private static String ls(String str, String str2) {
        AppMethodBeat.i(214067);
        Log.i("MicroMsg.SgLiveChecker", "url: " + str + " request: " + str2);
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestProperty("User-Agent", "QQPimSecure");
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestMethod("POST");
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpsURLConnection.getOutputStream(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            bufferedWriter.write(str2);
            bufferedWriter.close();
            int responseCode = httpsURLConnection.getResponseCode();
            Log.i("http_test", "responseCode: ".concat(String.valueOf(responseCode)));
            StringBuilder sb = new StringBuilder();
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
            }
            Log.i("MicroMsg.SgLiveChecker", "result: " + sb.toString());
            String sb2 = sb.toString();
            AppMethodBeat.o(214067);
            return sb2;
        } catch (IOException | MalformedURLException | ProtocolException e2) {
            AppMethodBeat.o(214067);
            return null;
        }
    }

    private static byte[] decode(String str) {
        AppMethodBeat.i(214068);
        try {
            if (Build.VERSION.SDK_INT >= 8) {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                AppMethodBeat.o(214068);
                return decode;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(214068);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[SYNTHETIC, Splitter:B:13:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[SYNTHETIC, Splitter:B:16:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004e A[SYNTHETIC, Splitter:B:34:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0053 A[SYNTHETIC, Splitter:B:37:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] aVb(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pwd.a.u.aVb(java.lang.String):byte[]");
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static byte[] getKey() {
            AppMethodBeat.i(214062);
            try {
                byte[] bytes = "DFG#$%^#%$RGHR(&*M<><".getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                AppMethodBeat.o(214062);
                return bytes;
            } catch (UnsupportedEncodingException e2) {
                AppMethodBeat.o(214062);
                return null;
            }
        }

        private static void a(byte[] bArr, int[] iArr) {
            int length = bArr.length >> 2;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                iArr[i2] = bArr[i3] & 255;
                int i5 = i4 + 1;
                iArr[i2] = ((bArr[i4] & 255) << 8) | iArr[i2];
                int i6 = i5 + 1;
                iArr[i2] = iArr[i2] | ((bArr[i5] & 255) << 16);
                iArr[i2] = iArr[i2] | ((bArr[i6] & 255) << 24);
                i2++;
                i3 = i6 + 1;
            }
            if (i3 < bArr.length) {
                int i7 = i3 + 1;
                iArr[i2] = bArr[i3] & 255;
                int i8 = 8;
                while (i7 < bArr.length) {
                    iArr[i2] = iArr[i2] | ((bArr[i7] & 255) << i8);
                    i7++;
                    i8 += 8;
                }
            }
        }

        private static byte[] cq(byte[] bArr) {
            AppMethodBeat.i(214063);
            if (bArr != null && bArr.length > 16) {
                try {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(bArr);
                    bArr = instance.digest();
                } catch (NoSuchAlgorithmException e2) {
                    bArr = null;
                }
            }
            AppMethodBeat.o(214063);
            return bArr;
        }

        public static byte[] cr(byte[] bArr) {
            AppMethodBeat.i(214064);
            byte[] cq = cq(getKey());
            if (bArr == null || cq == null || bArr.length == 0) {
                AppMethodBeat.o(214064);
                return bArr;
            } else if (bArr.length % 4 != 0 || bArr.length < 8) {
                AppMethodBeat.o(214064);
                return null;
            } else {
                int[] iArr = new int[(bArr.length >>> 2)];
                a(bArr, iArr);
                int length = cq.length % 4 == 0 ? cq.length >>> 2 : (cq.length >>> 2) + 1;
                if (length < 4) {
                    length = 4;
                }
                int[] iArr2 = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr2[i2] = 0;
                }
                a(cq, iArr2);
                int length2 = iArr.length - 1;
                int i3 = iArr[0];
                for (int i4 = ((52 / (length2 + 1)) + 6) * -1640531527; i4 != 0; i4 -= -1640531527) {
                    int i5 = (i4 >>> 2) & 3;
                    int i6 = length2;
                    while (i6 > 0) {
                        int i7 = iArr[i6 - 1];
                        i3 = iArr[i6] - (((i3 ^ i4) + (i7 ^ iArr2[(i6 & 3) ^ i5])) ^ (((i7 >>> 5) ^ (i3 << 2)) + ((i3 >>> 3) ^ (i7 << 4))));
                        iArr[i6] = i3;
                        i6--;
                    }
                    int i8 = iArr[length2];
                    i3 = iArr[0] - (((iArr2[(i6 & 3) ^ i5] ^ i8) + (i3 ^ i4)) ^ (((i8 >>> 5) ^ (i3 << 2)) + ((i3 >>> 3) ^ (i8 << 4))));
                    iArr[0] = i3;
                }
                int i9 = iArr[length2];
                if (i9 < 0 || i9 > ((iArr.length - 1) << 2)) {
                    AppMethodBeat.o(214064);
                    return null;
                }
                byte[] bArr2 = new byte[i9];
                int length3 = iArr.length - 1;
                int i10 = 0;
                int length4 = bArr2.length >> 2;
                if (length4 > length3) {
                    length4 = length3;
                }
                int i11 = 0;
                while (i11 < length4) {
                    int i12 = i10 + 1;
                    bArr2[i10] = (byte) (iArr[i11] & 255);
                    int i13 = i12 + 1;
                    bArr2[i12] = (byte) ((iArr[i11] >>> 8) & 255);
                    int i14 = i13 + 1;
                    bArr2[i13] = (byte) ((iArr[i11] >>> 16) & 255);
                    i10 = i14 + 1;
                    bArr2[i14] = (byte) ((iArr[i11] >>> 24) & 255);
                    i11++;
                }
                if (length3 > length4 && i10 < bArr2.length) {
                    int i15 = i10 + 1;
                    bArr2[i10] = (byte) (iArr[i11] & 255);
                    int i16 = 8;
                    while (i16 <= 24 && i15 < bArr2.length) {
                        bArr2[i15] = (byte) ((iArr[i11] >>> i16) & 255);
                        i16 += 8;
                        i15++;
                    }
                }
                AppMethodBeat.o(214064);
                return bArr2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean fOQ() {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pwd.a.u.fOQ():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057 A[Catch:{ Throwable -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0096 A[Catch:{ Throwable -> 0x00b2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String fOR() {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pwd.a.u.fOR():java.lang.String");
    }
}

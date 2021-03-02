package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class MMNativeWebP {
    public static final String TAG = "MMWEBP.JAVA";
    public static final int WEBP_MIN_HEADER_SIZE = 256;

    public static native Bitmap nativeDecodeByteArray(byte[] bArr, BitmapFactory.Options options);

    public static native byte[] nativeEncodeBitmap(Bitmap bitmap, int i2);

    public static native boolean nativeIsWebPImage(byte[] bArr);

    private static String exception2String(Exception exc) {
        AppMethodBeat.i(215384);
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(215384);
        return stringWriter2;
    }

    public static boolean IsWebPImageFile(String str) {
        boolean z = false;
        AppMethodBeat.i(215385);
        o oVar = new o(str);
        if (!oVar.exists()) {
            Log.w(TAG, "file %s not exists.", str);
            AppMethodBeat.o(215385);
        } else if (oVar.length() <= 256) {
            Log.w(TAG, "too small webp file:%s", str);
            AppMethodBeat.o(215385);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = s.ao(oVar);
                byte[] bArr = new byte[256];
                inputStream.read(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
                try {
                    z = nativeIsWebPImage(bArr);
                    AppMethodBeat.o(215385);
                } catch (NullPointerException e3) {
                    Log.e(TAG, "nativeIsWebPImage exception:%s", exception2String(e3));
                    AppMethodBeat.o(215385);
                } catch (RuntimeException e4) {
                    Log.e(TAG, "nativeIsWebPImage exception:%s", exception2String(e4));
                    AppMethodBeat.o(215385);
                }
            } catch (IOException e5) {
                Log.e(TAG, exception2String(e5));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.o(215385);
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                    }
                }
                AppMethodBeat.o(215385);
                throw th;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008f A[SYNTHETIC, Splitter:B:29:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094 A[SYNTHETIC, Splitter:B:32:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa A[SYNTHETIC, Splitter:B:39:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af A[SYNTHETIC, Splitter:B:42:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c6 A[SYNTHETIC, Splitter:B:49:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cb A[SYNTHETIC, Splitter:B:52:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d8 A[SYNTHETIC, Splitter:B:58:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00dd A[SYNTHETIC, Splitter:B:61:0x00dd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap DecodeWebPFile(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 271
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.MMNativeWebP.DecodeWebPFile(java.lang.String):android.graphics.Bitmap");
    }

    public static boolean SaveToWebPFile(Bitmap bitmap, int i2, String str) {
        AppMethodBeat.i(215387);
        if (bitmap == null || str.length() == 0) {
            AppMethodBeat.o(215387);
            return false;
        }
        OutputStream outputStream = null;
        try {
            byte[] nativeEncodeBitmap = nativeEncodeBitmap(bitmap, i2);
            if (nativeEncodeBitmap != null) {
                OutputStream ap = s.ap(new o(str));
                ap.write(nativeEncodeBitmap);
                ap.close();
                if (ap != null) {
                    try {
                        ap.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(215387);
                return true;
            }
            AppMethodBeat.o(215387);
            return false;
        } catch (IOException e3) {
            Log.e(TAG, exception2String(e3));
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(215387);
            return false;
        } catch (NullPointerException e5) {
            Log.e(TAG, exception2String(e5));
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(215387);
            return false;
        } catch (RuntimeException e7) {
            Log.e(TAG, exception2String(e7));
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e8) {
                }
            }
            AppMethodBeat.o(215387);
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e9) {
                }
            }
            AppMethodBeat.o(215387);
            throw th;
        }
    }
}

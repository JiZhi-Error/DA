package com.tencent.mm.plugin.appbrand.ac;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public final class d {
    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(140801);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[16384];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            try {
                int read = inputStreamReader.read(cArr);
                if (-1 != read) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    Util.qualityClose(inputStreamReader);
                    Util.qualityClose(inputStream);
                    String stringWriter2 = stringWriter.toString();
                    AppMethodBeat.o(140801);
                    return stringWriter2;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandIOUtil", "convertStreamToString: read, %s", e2.getMessage());
                Util.qualityClose(inputStreamReader);
                Util.qualityClose(inputStream);
                AppMethodBeat.o(140801);
                return "";
            } catch (Throwable th) {
                Util.qualityClose(inputStreamReader);
                Util.qualityClose(inputStream);
                AppMethodBeat.o(140801);
                throw th;
            }
        }
    }

    public static String afA(String str) {
        AppMethodBeat.i(140802);
        InputStream inputStream = null;
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open(str);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", str, Util.stackTraceToString(e2));
        }
        if (inputStream == null) {
            AppMethodBeat.o(140802);
            return "";
        }
        String convertStreamToString = convertStreamToString(inputStream);
        AppMethodBeat.o(140802);
        return convertStreamToString;
    }

    public static byte[] afB(String str) {
        AppMethodBeat.i(140803);
        InputStream inputStream = null;
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open(str);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", str, Util.stackTraceToString(e2));
        }
        if (inputStream == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(140803);
            return bArr;
        }
        byte[] H = H(inputStream);
        AppMethodBeat.o(140803);
        return H;
    }

    public static byte[] a(InputStream inputStream, long j2, long j3) {
        int read;
        int i2 = 0;
        AppMethodBeat.i(140804);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            int available = inputStream.available();
            if (available < 0) {
                byte[] bArr2 = new byte[0];
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(e2)));
                }
                AppMethodBeat.o(140804);
                return bArr2;
            } else if ((j2 + j3) - 1 > ((long) (available - 1))) {
                byte[] bArr3 = new byte[0];
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    Log.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(e3)));
                }
                AppMethodBeat.o(140804);
                return bArr3;
            } else {
                long j4 = (long) available;
                if (j3 < 0) {
                    j3 = j4;
                }
                inputStream.skip(j2);
                while (((long) i2) < j3 && (read = inputStream.read(bArr, 0, 16384)) != -1) {
                    int min = (int) Math.min((long) read, j3 - ((long) i2));
                    byteArrayOutputStream.write(bArr, 0, min);
                    i2 += min;
                }
                byteArrayOutputStream.flush();
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    Log.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(e4)));
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                AppMethodBeat.o(140804);
                return byteArray;
            }
        } catch (Exception e5) {
            Log.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray: ".concat(String.valueOf(e5)));
            byte[] bArr4 = new byte[0];
            try {
                inputStream.close();
            } catch (Exception e6) {
                Log.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(e6)));
            }
            AppMethodBeat.o(140804);
            return bArr4;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception e7) {
                Log.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(e7)));
            }
            AppMethodBeat.o(140804);
            throw th;
        }
    }

    public static byte[] H(InputStream inputStream) {
        AppMethodBeat.i(140805);
        byte[] a2 = a(inputStream, 0, -1);
        AppMethodBeat.o(140805);
        return a2;
    }

    public static boolean afC(String str) {
        AppMethodBeat.i(140806);
        if (Util.isNullOrNil(str) || (!URLUtil.isHttpsUrl(str) && !URLUtil.isHttpUrl(str))) {
            AppMethodBeat.o(140806);
            return false;
        }
        AppMethodBeat.o(140806);
        return true;
    }

    public static byte[] p(ByteBuffer byteBuffer) {
        AppMethodBeat.i(140807);
        if (byteBuffer == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(140807);
            return bArr;
        } else if (!byteBuffer.isDirect()) {
            byte[] array = byteBuffer.array();
            AppMethodBeat.o(140807);
            return array;
        } else {
            int position = byteBuffer.position();
            byteBuffer.position(0);
            byte[] bArr2 = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr2);
            byteBuffer.position(position);
            AppMethodBeat.o(140807);
            return bArr2;
        }
    }
}

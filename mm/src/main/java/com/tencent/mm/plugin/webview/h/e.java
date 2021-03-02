package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public final class e {
    public static int JcI = CommonUtils.MAX_TIMEOUT_MS;
    public static int JcJ = CommonUtils.MAX_TIMEOUT_MS;

    public static class a {
        public String data = "";
        public Map<String, String> njn = new HashMap();
        public int statusCode;

        public a() {
            AppMethodBeat.i(79231);
            AppMethodBeat.o(79231);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068 A[SYNTHETIC, Splitter:B:18:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cf A[SYNTHETIC, Splitter:B:40:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0115 A[SYNTHETIC, Splitter:B:57:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0192 A[SYNTHETIC, Splitter:B:83:0x0192] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01bc A[SYNTHETIC, Splitter:B:94:0x01bc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.webview.h.e.a a(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 508
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.h.e.a(java.lang.String, java.util.Map, java.lang.String):com.tencent.mm.plugin.webview.h.e$a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[SYNTHETIC, Splitter:B:26:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0 A[SYNTHETIC, Splitter:B:47:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010b A[SYNTHETIC, Splitter:B:61:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0162 A[SYNTHETIC, Splitter:B:79:0x0162] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x017f A[SYNTHETIC, Splitter:B:87:0x017f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.webview.h.e.a Q(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
        // Method dump skipped, instructions count: 435
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.h.e.Q(java.lang.String, java.util.Map):com.tencent.mm.plugin.webview.h.e$a");
    }

    private static InputStream e(String str, InputStream inputStream) {
        AppMethodBeat.i(79234);
        if (str == null || "identity".equalsIgnoreCase(str)) {
            AppMethodBeat.o(79234);
            return inputStream;
        } else if ("gzip".equalsIgnoreCase(str)) {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
            AppMethodBeat.o(79234);
            return gZIPInputStream;
        } else if ("deflate".equalsIgnoreCase(str)) {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(false), 512);
            AppMethodBeat.o(79234);
            return inflaterInputStream;
        } else {
            RuntimeException runtimeException = new RuntimeException("unsupported content-encoding: ".concat(String.valueOf(str)));
            AppMethodBeat.o(79234);
            throw runtimeException;
        }
    }

    private static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(79235);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 512);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine + "\n");
                } else {
                    closeQuietly(inputStreamReader);
                    closeQuietly(bufferedReader);
                    String sb2 = sb.toString();
                    AppMethodBeat.o(79235);
                    return sb2;
                }
            } catch (IOException e2) {
                Log.printInfoStack("MicroMsg.RequestUtil", "", e2);
                closeQuietly(inputStreamReader);
                closeQuietly(bufferedReader);
                AppMethodBeat.o(79235);
                return null;
            } catch (Exception e3) {
                Log.printInfoStack("MicroMsg.RequestUtil", "", e3);
                closeQuietly(inputStreamReader);
                closeQuietly(bufferedReader);
                AppMethodBeat.o(79235);
                return null;
            } catch (Throwable th) {
                closeQuietly(inputStreamReader);
                closeQuietly(bufferedReader);
                AppMethodBeat.o(79235);
                throw th;
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(79236);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Log.printInfoStack("MicroMsg.RequestUtil", "", e2);
                AppMethodBeat.o(79236);
                return;
            } catch (Exception e3) {
                Log.printInfoStack("MicroMsg.RequestUtil", "", e3);
                AppMethodBeat.o(79236);
                return;
            }
        }
        AppMethodBeat.o(79236);
    }
}

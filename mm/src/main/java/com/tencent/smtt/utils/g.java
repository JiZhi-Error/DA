package com.tencent.smtt.utils;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class g {

    public interface a {
        void a(int i2);
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z) {
        String b2;
        String str2 = null;
        AppMethodBeat.i(54016);
        if (z) {
            try {
                b2 = i.a().c();
            } catch (Exception e2) {
                AppMethodBeat.o(54016);
            }
        } else {
            b2 = h.a().b();
        }
        String str3 = str + b2;
        if (z) {
            try {
                bArr = i.a().a(bArr);
            } catch (Exception e3) {
            }
        } else {
            bArr = h.a().a(bArr);
        }
        if (bArr == null) {
            AppMethodBeat.o(54016);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(bArr.length));
            HttpURLConnection a2 = a(str3, hashMap);
            if (a2 != null) {
                b(a2, bArr);
                str2 = a(a2, aVar, z);
            }
            AppMethodBeat.o(54016);
        }
        return str2;
    }

    public static String a(String str, Map<String, String> map, byte[] bArr, a aVar, boolean z) {
        String str2 = null;
        AppMethodBeat.i(54017);
        if (bArr == null) {
            AppMethodBeat.o(54017);
        } else {
            HttpURLConnection a2 = a(str, map);
            if (a2 != null) {
                if (z) {
                    a(a2, bArr);
                } else {
                    b(a2, bArr);
                }
                str2 = a(a2, aVar, false);
            }
            AppMethodBeat.o(54017);
        }
        return str2;
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        AppMethodBeat.i(54018);
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
                if (Build.VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                AppMethodBeat.o(54018);
            } catch (Exception e2) {
                AppMethodBeat.o(54018);
                return httpURLConnection;
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            AppMethodBeat.o(54018);
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        GZIPOutputStream gZIPOutputStream2;
        AppMethodBeat.i(54019);
        try {
            gZIPOutputStream2 = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.flush();
                a(null);
                a(gZIPOutputStream2);
                AppMethodBeat.o(54019);
            } catch (Exception e2) {
                a(null);
                a(gZIPOutputStream2);
                AppMethodBeat.o(54019);
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                a(null);
                a(gZIPOutputStream);
                AppMethodBeat.o(54019);
                throw th;
            }
        } catch (Exception e3) {
            gZIPOutputStream2 = null;
            a(null);
            a(gZIPOutputStream2);
            AppMethodBeat.o(54019);
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            a(null);
            a(gZIPOutputStream);
            AppMethodBeat.o(54019);
            throw th;
        }
    }

    private static void b(HttpURLConnection httpURLConnection, byte[] bArr) {
        AppMethodBeat.i(54020);
        OutputStream outputStream = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e2) {
        } finally {
            a(outputStream);
            AppMethodBeat.o(54020);
        }
    }

    private static String a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        AppMethodBeat.i(54021);
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                    inputStream = new GZIPInputStream(inputStream2);
                } else if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) {
                    inputStream = inputStream2;
                } else {
                    inputStream = new InflaterInputStream(inputStream2, new Inflater(true));
                }
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[128];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        str = z ? new String(byteArrayOutputStream2.toByteArray(), ProtocolPackage.ServerEncoding) : new String(h.a().c(byteArrayOutputStream2.toByteArray()));
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        a(inputStream);
                        a(byteArrayOutputStream);
                        AppMethodBeat.o(54021);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    a(inputStream);
                    a(byteArrayOutputStream);
                    AppMethodBeat.o(54021);
                    throw th;
                }
            } else {
                byteArrayOutputStream2 = null;
                inputStream = null;
                str = null;
            }
            a(inputStream);
            a(byteArrayOutputStream2);
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
            a(inputStream);
            a(byteArrayOutputStream);
            AppMethodBeat.o(54021);
            throw th;
        }
        AppMethodBeat.o(54021);
        return str;
    }

    private static void a(Closeable closeable) {
        AppMethodBeat.i(54022);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(54022);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(54022);
    }
}

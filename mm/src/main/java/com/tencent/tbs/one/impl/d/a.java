package com.tencent.tbs.one.impl.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public final class a extends com.tencent.tbs.one.impl.a.a<Integer> {

    /* renamed from: b  reason: collision with root package name */
    String f2617b;

    /* renamed from: c  reason: collision with root package name */
    String f2618c;

    /* renamed from: d  reason: collision with root package name */
    Map<String, String> f2619d;

    /* renamed from: e  reason: collision with root package name */
    byte[] f2620e;

    /* renamed from: f  reason: collision with root package name */
    public AbstractC2197a f2621f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2622g;

    /* renamed from: h  reason: collision with root package name */
    private Context f2623h;

    /* renamed from: i  reason: collision with root package name */
    private int f2624i;

    /* renamed from: com.tencent.tbs.one.impl.d.a$a  reason: collision with other inner class name */
    public interface AbstractC2197a {
        void a(int i2, Map<String, List<String>> map, InputStream inputStream);
    }

    public a(Context context, String str) {
        this(context, str, "GET");
    }

    private a(Context context, String str, String str2) {
        this(context, str, str2, (byte) 0);
    }

    private a(Context context, String str, String str2, byte b2) {
        this(context, str, str2, null, null);
    }

    public a(Context context, String str, String str2, Map<String, String> map, byte[] bArr) {
        this.f2623h = context;
        this.f2617b = str;
        this.f2618c = str2;
        this.f2619d = map;
        this.f2620e = bArr;
    }

    private HttpURLConnection a(String str) {
        AppMethodBeat.i(174148);
        a(5);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(g.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setRequestProperty("Connection", "close");
            AppMethodBeat.o(174148);
            return httpURLConnection;
        } catch (MalformedURLException e2) {
            a(202, "Failed to parse url ".concat(String.valueOf(str)), e2);
            AppMethodBeat.o(174148);
            return null;
        } catch (IOException e3) {
            a(203, "Failed to open connection, url: ".concat(String.valueOf(str)), e3);
            AppMethodBeat.o(174148);
            return null;
        }
    }

    static /* synthetic */ void a(a aVar, String str, String str2, Map map, byte[] bArr) {
        InputStream inputStream;
        InputStream inputStream2;
        boolean z;
        AppMethodBeat.i(174150);
        if (aVar.f2622g) {
            ConnectivityManager connectivityManager = (ConnectivityManager) aVar.f2623h.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                z = activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
            } else {
                z = false;
            }
            if (!z) {
                aVar.a(201, "Network unavailable, current network is not wifi", null);
                AppMethodBeat.o(174150);
                return;
            }
        }
        HttpURLConnection a2 = aVar.a(str);
        if (a2 != null && aVar.c() && aVar.a(a2, str, str2, map, bArr) && aVar.c()) {
            aVar.a(50);
            try {
                int responseCode = a2.getResponseCode();
                Map<String, List<String>> headerFields = a2.getHeaderFields();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303) {
                    final String headerField = a2.getHeaderField("Location");
                    int i2 = aVar.f2624i + 1;
                    aVar.f2624i = i2;
                    if (i2 > 5) {
                        aVar.a(207, "Too many redirects, url:  " + str + ", statusCode: " + responseCode + ", location: " + headerField, null);
                        AppMethodBeat.o(174150);
                        return;
                    }
                    f.a("Redirecting from %s to %s", str, headerField);
                    m.d(new Runnable() {
                        /* class com.tencent.tbs.one.impl.d.a.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(174151);
                            a.a(a.this, headerField, a.this.f2618c, a.this.f2619d, a.this.f2620e);
                            AppMethodBeat.o(174151);
                        }
                    });
                    AppMethodBeat.o(174150);
                    return;
                }
                if (responseCode < 400) {
                    try {
                        inputStream2 = a2.getInputStream();
                        if (inputStream2 != null) {
                            try {
                                String contentEncoding = a2.getContentEncoding();
                                inputStream = (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) ? (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) ? inputStream2 : new InflaterInputStream(inputStream2, new Inflater(true)) : new GZIPInputStream(inputStream2);
                            } catch (IOException e2) {
                                e = e2;
                                c.a(inputStream2);
                                aVar.a(208, "Failed to read response data, url:  " + str + ", statusCode: " + responseCode, e);
                                AppMethodBeat.o(174150);
                                return;
                            }
                        } else {
                            f.a("No response stream from %s, statusCode: %d", str, Integer.valueOf(responseCode));
                            inputStream = inputStream2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        inputStream2 = null;
                        c.a(inputStream2);
                        aVar.a(208, "Failed to read response data, url:  " + str + ", statusCode: " + responseCode, e);
                        AppMethodBeat.o(174150);
                        return;
                    }
                } else {
                    inputStream = null;
                }
                if (aVar.f2621f != null) {
                    aVar.f2621f.a(responseCode, headerFields, inputStream);
                }
                c.a(inputStream);
                aVar.a(Integer.valueOf(responseCode));
            } catch (IOException e4) {
                aVar.a(206, "Failed to read response code, url:  ".concat(String.valueOf(str)), e4);
                AppMethodBeat.o(174150);
                return;
            }
        }
        AppMethodBeat.o(174150);
    }

    private boolean a(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, byte[] bArr) {
        OutputStream outputStream;
        Throwable th;
        Exception e2;
        ProtocolException e3;
        AppMethodBeat.i(174149);
        a(10);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        OutputStream outputStream2 = null;
        try {
            httpURLConnection.setRequestMethod(str2);
            if (str2.equals("POST") && bArr != null) {
                outputStream = httpURLConnection.getOutputStream();
                if (map != null) {
                    try {
                        String str3 = map.get("Content-Encoding");
                        if (!TextUtils.isEmpty(str3) && str3.equals("gzip")) {
                            outputStream2 = new GZIPOutputStream(new BufferedOutputStream(outputStream, 204800));
                            outputStream2.write(bArr);
                            outputStream2.flush();
                        }
                    } catch (ProtocolException e4) {
                        e3 = e4;
                        try {
                            a(204, "Failed to parse http method " + str2 + ", url:  " + str, e3);
                            c.a(outputStream);
                            AppMethodBeat.o(174149);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            c.a(outputStream);
                            AppMethodBeat.o(174149);
                            throw th;
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        a(205, "Failed to send request, url:  ".concat(String.valueOf(str)), e2);
                        c.a(outputStream);
                        AppMethodBeat.o(174149);
                        return false;
                    }
                }
                outputStream2 = outputStream;
                try {
                    outputStream2.write(bArr);
                    outputStream2.flush();
                } catch (ProtocolException e6) {
                    e3 = e6;
                    outputStream = outputStream2;
                    a(204, "Failed to parse http method " + str2 + ", url:  " + str, e3);
                    c.a(outputStream);
                    AppMethodBeat.o(174149);
                    return false;
                } catch (Exception e7) {
                    e2 = e7;
                    outputStream = outputStream2;
                    a(205, "Failed to send request, url:  ".concat(String.valueOf(str)), e2);
                    c.a(outputStream);
                    AppMethodBeat.o(174149);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = outputStream2;
                    c.a(outputStream);
                    AppMethodBeat.o(174149);
                    throw th;
                }
            }
            c.a(outputStream2);
            AppMethodBeat.o(174149);
            return true;
        } catch (ProtocolException e8) {
            e3 = e8;
            outputStream = null;
            a(204, "Failed to parse http method " + str2 + ", url:  " + str, e3);
            c.a(outputStream);
            AppMethodBeat.o(174149);
            return false;
        } catch (Exception e9) {
            e2 = e9;
            outputStream = null;
            a(205, "Failed to send request, url:  ".concat(String.valueOf(str)), e2);
            c.a(outputStream);
            AppMethodBeat.o(174149);
            return false;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            c.a(outputStream);
            AppMethodBeat.o(174149);
            throw th;
        }
    }

    private boolean c() {
        AppMethodBeat.i(174147);
        if (this.f2326a) {
            a(104, "Aborted", null);
            AppMethodBeat.o(174147);
            return false;
        }
        AppMethodBeat.o(174147);
        return true;
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        AppMethodBeat.i(174146);
        m.d(new Runnable() {
            /* class com.tencent.tbs.one.impl.d.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(174152);
                a.a(a.this, a.this.f2617b, a.this.f2618c, a.this.f2619d, a.this.f2620e);
                AppMethodBeat.o(174152);
            }
        });
        AppMethodBeat.o(174146);
    }
}

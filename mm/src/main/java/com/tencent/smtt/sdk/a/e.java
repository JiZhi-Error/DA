package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f1969a = "EmergencyManager";

    /* renamed from: f  reason: collision with root package name */
    private static final Object f1970f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static HandlerThread f1971g;

    /* renamed from: h  reason: collision with root package name */
    private static Handler f1972h;

    /* renamed from: b  reason: collision with root package name */
    private String f1973b;

    /* renamed from: c  reason: collision with root package name */
    private String f1974c;

    /* renamed from: d  reason: collision with root package name */
    private String f1975d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f1976e;

    public interface a {
        void a(String str);
    }

    static {
        AppMethodBeat.i(188292);
        AppMethodBeat.o(188292);
    }

    public e(Context context, String str, String str2) {
        this(context, str, str2, "POST");
    }

    public e(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(188288);
        this.f1973b = str;
        this.f1974c = str2;
        this.f1975d = str3;
        this.f1976e = new Handler(context.getMainLooper());
        AppMethodBeat.o(188288);
    }

    private static Handler b() {
        Handler handler;
        AppMethodBeat.i(188289);
        synchronized (f1970f) {
            try {
                if (f1972h == null) {
                    HandlerThread handlerThread = new HandlerThread("HttpThread");
                    f1971g = handlerThread;
                    handlerThread.start();
                    f1972h = new Handler(f1971g.getLooper());
                }
                handler = f1972h;
            } finally {
                AppMethodBeat.o(188289);
            }
        }
        return handler;
    }

    public void a(final a aVar) {
        AppMethodBeat.i(188290);
        b().post(new Runnable() {
            /* class com.tencent.smtt.sdk.a.e.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(188271);
                final String a2 = e.this.a(e.this.f1973b);
                if (a2 != null) {
                    e.this.f1976e.post(new Runnable() {
                        /* class com.tencent.smtt.sdk.a.e.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(188284);
                            if (aVar != null) {
                                aVar.a(a2);
                            }
                            AppMethodBeat.o(188284);
                        }
                    });
                    AppMethodBeat.o(188271);
                    return;
                }
                TbsLog.e(e.f1969a, "Unexpected result for an empty http response: " + e.this.f1973b);
                AppMethodBeat.o(188271);
            }
        });
        AppMethodBeat.o(188290);
    }

    public String a(String str) {
        AppMethodBeat.i(188291);
        TbsLog.e(f1969a, "Request url: " + this.f1973b + ",params: " + this.f1974c);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str.trim()).openConnection();
            httpURLConnection.setRequestMethod(this.f1975d);
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Content-Length", new StringBuilder().append(this.f1974c.length()).toString());
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(this.f1974c.getBytes());
            int responseCode = httpURLConnection.getResponseCode();
            if (200 == responseCode) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 != read) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        byteArrayOutputStream.flush();
                    } else {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString(ProtocolPackage.ServerEncoding);
                        AppMethodBeat.o(188291);
                        return byteArrayOutputStream2;
                    }
                }
            } else {
                TbsLog.e(f1969a, "Bad http request, code: ".concat(String.valueOf(responseCode)));
                AppMethodBeat.o(188291);
                return null;
            }
        } catch (Exception e2) {
            TbsLog.e(f1969a, "Http exception: " + e2.getMessage());
        }
    }
}

package com.google.android.exoplayer2.h;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o implements s {
    private static final Pattern bFq = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> bFr = new AtomicReference<>();
    private final w<? super o> bEI;
    private long bFA;
    private long bFB;
    private final boolean bFs;
    private final int bFt;
    private final int bFu;
    private final com.google.android.exoplayer2.i.o<String> bFv;
    private final s.f bFw;
    private final s.f bFx;
    private long bFy;
    private long bFz;
    private j bxj;
    private HttpURLConnection connection;
    private InputStream inputStream;
    private boolean opened;
    private final String userAgent;

    static {
        AppMethodBeat.i(93077);
        AppMethodBeat.o(93077);
    }

    public o(String str, w<? super o> wVar, int i2, int i3, boolean z, s.f fVar) {
        AppMethodBeat.i(93069);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(93069);
            throw illegalArgumentException;
        }
        this.userAgent = str;
        this.bFv = null;
        this.bEI = wVar;
        this.bFx = new s.f();
        this.bFt = i2;
        this.bFu = i3;
        this.bFs = z;
        this.bFw = fVar;
        AppMethodBeat.o(93069);
    }

    @Override // com.google.android.exoplayer2.h.g
    public final Uri getUri() {
        AppMethodBeat.i(93070);
        if (this.connection == null) {
            AppMethodBeat.o(93070);
            return null;
        }
        Uri parse = Uri.parse(this.connection.getURL().toString());
        AppMethodBeat.o(93070);
        return parse;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final long a(j jVar) {
        HttpURLConnection a2;
        AppMethodBeat.i(93071);
        this.bxj = jVar;
        this.bFB = 0;
        this.bFA = 0;
        try {
            URL url = new URL(jVar.uri.toString());
            byte[] bArr = jVar.bEO;
            long j2 = jVar.position;
            long j3 = jVar.length;
            boolean eW = jVar.eW(1);
            if (!this.bFs) {
                a2 = a(url, bArr, j2, j3, eW, true);
            } else {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 <= 20) {
                        a2 = a(url, bArr, j2, j3, eW, false);
                        int responseCode = a2.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr = null;
                        String headerField = a2.getHeaderField("Location");
                        a2.disconnect();
                        if (headerField == null) {
                            ProtocolException protocolException = new ProtocolException("Null location redirect");
                            AppMethodBeat.o(93071);
                            throw protocolException;
                        }
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if ("https".equals(protocol) || "http".equals(protocol)) {
                            i2 = i3;
                            url = url2;
                        } else {
                            ProtocolException protocolException2 = new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                            AppMethodBeat.o(93071);
                            throw protocolException2;
                        }
                    } else {
                        NoRouteToHostException noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i3)));
                        AppMethodBeat.o(93071);
                        throw noRouteToHostException;
                    }
                }
            }
            this.connection = a2;
            try {
                int responseCode2 = this.connection.getResponseCode();
                b.i("DefaultHttpDataSource", "open, responseCode:%d", Integer.valueOf(responseCode2));
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.connection.getHeaderFields();
                    wL();
                    s.e eVar = new s.e(responseCode2, headerFields, jVar);
                    if (responseCode2 == 416) {
                        eVar.initCause(new h());
                    }
                    AppMethodBeat.o(93071);
                    throw eVar;
                }
                String contentType = this.connection.getContentType();
                if (this.bFv == null || this.bFv.aj(contentType)) {
                    this.bFy = (responseCode2 != 200 || jVar.position == 0) ? 0 : jVar.position;
                    if (jVar.eW(1)) {
                        this.bFz = jVar.length;
                    } else if (jVar.length != -1) {
                        this.bFz = jVar.length;
                    } else {
                        long contentLength = getContentLength(this.connection);
                        this.bFz = contentLength != -1 ? contentLength - this.bFy : -1;
                    }
                    try {
                        this.inputStream = this.connection.getInputStream();
                        this.opened = true;
                        if (this.bEI != null) {
                            this.bEI.a(this, jVar);
                        }
                        long j4 = this.bFz;
                        AppMethodBeat.o(93071);
                        return j4;
                    } catch (IOException e2) {
                        wL();
                        s.c cVar = new s.c(e2, jVar, 1);
                        AppMethodBeat.o(93071);
                        throw cVar;
                    }
                } else {
                    wL();
                    s.d dVar = new s.d(contentType, jVar);
                    AppMethodBeat.o(93071);
                    throw dVar;
                }
            } catch (IOException e3) {
                wL();
                s.c cVar2 = new s.c("Unable to connect to " + jVar.uri.toString(), e3, jVar);
                AppMethodBeat.o(93071);
                throw cVar2;
            }
        } catch (IOException e4) {
            s.c cVar3 = new s.c("Unable to connect to " + jVar.uri.toString(), e4, jVar);
            AppMethodBeat.o(93071);
            throw cVar3;
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final void close() {
        long j2;
        AppMethodBeat.i(93073);
        try {
            if (this.inputStream != null) {
                HttpURLConnection httpURLConnection = this.connection;
                if (this.bFz == -1) {
                    j2 = this.bFz;
                } else {
                    j2 = this.bFz - this.bFB;
                }
                if (x.SDK_INT == 19 || x.SDK_INT == 20) {
                    try {
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        if (j2 != -1 ? j2 > 2048 : inputStream2.read() != -1) {
                            String name = inputStream2.getClass().getName();
                            if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                                Method declaredMethod = inputStream2.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod.setAccessible(true);
                                declaredMethod.invoke(inputStream2, new Object[0]);
                            }
                        }
                    } catch (Exception e2) {
                    }
                }
                try {
                    this.inputStream.close();
                } catch (IOException e3) {
                    s.c cVar = new s.c(e3, this.bxj, 3);
                    AppMethodBeat.o(93073);
                    throw cVar;
                }
            }
            this.inputStream = null;
            wL();
            if (this.opened) {
                this.opened = false;
                if (this.bEI != null) {
                    this.bEI.ai(this);
                    AppMethodBeat.o(93073);
                    return;
                }
            }
            AppMethodBeat.o(93073);
        } catch (Throwable th) {
            this.inputStream = null;
            wL();
            if (this.opened) {
                this.opened = false;
                if (this.bEI != null) {
                    this.bEI.ai(this);
                }
            }
            AppMethodBeat.o(93073);
            throw th;
        }
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j2, long j3, boolean z, boolean z2) {
        AppMethodBeat.i(93074);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.bFt);
        httpURLConnection.setReadTimeout(this.bFu);
        if (this.bFw != null) {
            for (Map.Entry<String, String> entry : this.bFw.wM().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.bFx.wM().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (!(j2 == 0 && j3 == -1)) {
            String str = "bytes=" + j2 + "-";
            if (j3 != -1) {
                str = str + ((j2 + j3) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.userAgent);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                AppMethodBeat.o(93074);
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        AppMethodBeat.o(93074);
        return httpURLConnection;
    }

    private static long getContentLength(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(93075);
        long j2 = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j2 = Long.parseLong(headerField);
            } catch (NumberFormatException e2) {
                b.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]", new Object[0]);
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField2)) {
            Matcher matcher = bFq.matcher(headerField2);
            if (matcher.find()) {
                try {
                    long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                    if (j2 < 0) {
                        j2 = parseLong;
                    } else if (j2 != parseLong) {
                        b.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]", new Object[0]);
                        j2 = Math.max(j2, parseLong);
                    }
                } catch (NumberFormatException e3) {
                    b.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(93075);
        return j2;
    }

    private void wL() {
        AppMethodBeat.i(93076);
        if (this.connection != null) {
            try {
                this.connection.disconnect();
            } catch (Exception e2) {
                b.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.connection = null;
        }
        AppMethodBeat.o(93076);
    }

    @Override // com.google.android.exoplayer2.h.g
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93072);
        try {
            if (this.bFA != this.bFy) {
                byte[] andSet = bFr.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.bFA != this.bFy) {
                    int read = this.inputStream.read(andSet, 0, (int) Math.min(this.bFy - this.bFA, (long) andSet.length));
                    if (Thread.interrupted()) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException();
                        AppMethodBeat.o(93072);
                        throw interruptedIOException;
                    } else if (read == -1) {
                        EOFException eOFException = new EOFException();
                        AppMethodBeat.o(93072);
                        throw eOFException;
                    } else {
                        this.bFA += (long) read;
                        if (this.bEI != null) {
                            this.bEI.d(this, read);
                        }
                    }
                }
                bFr.set(andSet);
            }
            if (i3 == 0) {
                AppMethodBeat.o(93072);
                return 0;
            }
            if (this.bFz != -1) {
                long j2 = this.bFz - this.bFB;
                if (j2 == 0) {
                    AppMethodBeat.o(93072);
                    return -1;
                }
                i3 = (int) Math.min((long) i3, j2);
            }
            int read2 = this.inputStream.read(bArr, i2, i3);
            if (read2 != -1) {
                this.bFB += (long) read2;
                if (this.bEI != null) {
                    this.bEI.d(this, read2);
                }
                AppMethodBeat.o(93072);
                return read2;
            } else if (this.bFz != -1) {
                EOFException eOFException2 = new EOFException();
                AppMethodBeat.o(93072);
                throw eOFException2;
            } else {
                AppMethodBeat.o(93072);
                return -1;
            }
        } catch (IOException e2) {
            s.c cVar = new s.c(e2, this.bxj, 2);
            AppMethodBeat.o(93072);
            throw cVar;
        }
    }
}

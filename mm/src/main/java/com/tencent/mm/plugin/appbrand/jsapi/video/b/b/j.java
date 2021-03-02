package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class j implements l {
    private static final Pattern bFq = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> bFr = new AtomicReference<>();
    protected String TAG;
    private long bFA;
    long bFB;
    private final boolean bFs;
    private final int bFt;
    private final int bFu;
    private long bFy;
    private long bFz;
    private HttpURLConnection connection;
    private long contentLength;
    private String contentType;
    private InputStream inputStream;
    private long kNt;
    private final s mxN;
    public g mxt;
    protected String mxw;
    private final i<String> myh;
    private final HashMap<String, String> myi;
    private final e<Map<String, List<String>>> myj;
    private boolean opened;
    private final String userAgent;

    static {
        AppMethodBeat.i(234750);
        AppMethodBeat.o(234750);
    }

    public j(String str) {
        this(str, (byte) 0);
    }

    private j(String str, byte b2) {
        this(str, null, null);
    }

    private j(String str, i<String> iVar, e<Map<String, List<String>>> eVar) {
        this(str, null, null, false, null);
    }

    public j(String str, i<String> iVar, s sVar, boolean z, e<Map<String, List<String>>> eVar) {
        AppMethodBeat.i(234736);
        this.TAG = "DefaultHttpDataSource";
        this.contentLength = -1;
        this.kNt = -1;
        this.mxw = "";
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(234736);
            throw illegalArgumentException;
        }
        this.userAgent = str;
        this.myh = iVar;
        this.mxN = sVar;
        this.myi = new HashMap<>();
        this.bFt = CommonUtils.MAX_TIMEOUT_MS;
        this.bFu = 12000;
        this.bFs = z;
        this.myj = eVar;
        AppMethodBeat.o(234736);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.t
    public final String getUri() {
        AppMethodBeat.i(234737);
        if (this.connection == null) {
            AppMethodBeat.o(234737);
            return null;
        }
        String url = this.connection.getURL().toString();
        AppMethodBeat.o(234737);
        return url;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l
    public final Map<String, List<String>> getResponseHeaders() {
        AppMethodBeat.i(234738);
        Map<String, List<String>> headerFields = this.connection == null ? null : this.connection.getHeaderFields();
        if (this.myj != null) {
            Map<String, List<String>> cI = this.myj.cI(headerFields);
            AppMethodBeat.o(234738);
            return cI;
        }
        AppMethodBeat.o(234738);
        return headerFields;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public long a(g gVar) {
        AppMethodBeat.i(234739);
        long b2 = b(gVar);
        AppMethodBeat.o(234739);
        return b2;
    }

    public final long b(g gVar) {
        long j2;
        String str;
        AppMethodBeat.i(234740);
        this.mxt = gVar;
        this.bFB = 0;
        this.bFA = 0;
        try {
            this.connection = c(gVar);
            try {
                int responseCode = this.connection.getResponseCode();
                h.log(4, getLogTag(), h.abs("uri=" + gVar.toString() + ", response header: \r\n" + f.T(this.connection.getHeaderFields())));
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.connection.getHeaderFields();
                    closeConnection();
                    l.f fVar = new l.f(responseCode, headerFields, gVar);
                    AppMethodBeat.o(234740);
                    throw fVar;
                }
                String contentType2 = this.connection.getContentType();
                Map<String, List<String>> headerFields2 = this.connection.getHeaderFields();
                if (this.myh == null || this.myh.aj(contentType2)) {
                    this.contentType = contentType2;
                    if (this.myj != null) {
                        d dVar = (d) this.myj;
                        String str2 = this.contentType;
                        if (!str2.equals("application/octet-stream") || TextUtils.isEmpty(dVar.mzR)) {
                            str = str2;
                        } else {
                            h.log(5, dVar.mzQ, "fix contentType from " + str2 + " to " + dVar.mzR);
                            str = dVar.mzR;
                        }
                        this.contentType = str;
                    }
                    this.bFy = (responseCode != 200 || gVar.position == 0) ? 0 : gVar.position;
                    if ((gVar.flags & 1) == 0) {
                        this.contentLength = b(this.connection, getLogTag());
                        this.kNt = a(this.connection, getLogTag());
                        if (gVar.length != -1) {
                            j2 = gVar.length;
                        } else {
                            j2 = this.contentLength != -1 ? this.contentLength - this.bFy : -1;
                        }
                        this.bFz = j2;
                    } else {
                        this.bFz = gVar.length;
                        this.contentLength = gVar.length;
                        this.kNt = -1;
                    }
                    try {
                        this.inputStream = this.connection.getInputStream();
                        this.opened = true;
                        if (this.mxN != null) {
                            this.mxN.onTransferStart();
                        }
                        long j3 = this.bFz;
                        AppMethodBeat.o(234740);
                        return j3;
                    } catch (IOException e2) {
                        closeConnection();
                        l.a aVar = new l.a(e2, gVar);
                        AppMethodBeat.o(234740);
                        throw aVar;
                    }
                } else {
                    closeConnection();
                    l.e eVar = new l.e(contentType2, headerFields2, gVar);
                    AppMethodBeat.o(234740);
                    throw eVar;
                }
            } catch (SocketTimeoutException e3) {
                closeConnection();
                l.h hVar = new l.h("getResponseCode SocketTimeoutException Unable to connect to " + gVar.uri.toString(), e3, gVar);
                AppMethodBeat.o(234740);
                throw hVar;
            } catch (InterruptedIOException e4) {
                closeConnection();
                l.b bVar = new l.b("getResponseCode InterruptedIOException Interrupt connection to " + gVar.uri.toString(), e4, gVar);
                AppMethodBeat.o(234740);
                throw bVar;
            } catch (IOException e5) {
                closeConnection();
                l.h hVar2 = new l.h("getResponseCode IOException Unable to connect to " + gVar.uri.toString(), e5, gVar);
                AppMethodBeat.o(234740);
                throw hVar2;
            } catch (ArrayIndexOutOfBoundsException e6) {
                closeConnection();
                h.log(6, getLogTag(), h.i(e6));
                l.g gVar2 = new l.g("getResponseCode Got malformed response when connect to " + gVar.uri.toString(), gVar);
                AppMethodBeat.o(234740);
                throw gVar2;
            }
        } catch (InterruptedIOException e7) {
            l.b bVar2 = new l.b("makeConnection InterruptedIOException Interrupt connection to " + gVar.uri.toString(), e7, gVar);
            AppMethodBeat.o(234740);
            throw bVar2;
        } catch (IOException e8) {
            l.h hVar3 = new l.h("makeConnection IOException Unable to connect to " + gVar.uri.toString(), e8, gVar);
            AppMethodBeat.o(234740);
            throw hVar3;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long available() {
        return this.contentLength;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void close() {
        long j2;
        AppMethodBeat.i(234742);
        try {
            if (this.inputStream != null) {
                HttpURLConnection httpURLConnection = this.connection;
                if (this.bFz == -1) {
                    j2 = this.bFz;
                } else {
                    j2 = this.bFz - this.bFB;
                }
                h.a(httpURLConnection, j2);
                try {
                    this.inputStream.close();
                    this.inputStream = null;
                } catch (IOException e2) {
                    l.a aVar = new l.a(e2, this.mxt);
                    AppMethodBeat.o(234742);
                    throw aVar;
                }
            }
        } finally {
            if (this.opened) {
                this.opened = false;
                if (this.mxN != null) {
                    this.mxN.onTransferEnd();
                }
            }
            closeConnection();
            AppMethodBeat.o(234742);
        }
    }

    private HttpURLConnection c(g gVar) {
        URL url;
        AppMethodBeat.i(234743);
        URL url2 = new URL(gVar.uri.toString());
        long j2 = gVar.position;
        long j3 = gVar.length;
        boolean z = (gVar.flags & 1) != 0;
        if (!this.bFs) {
            HttpURLConnection a2 = a(url2, j2, j3, z);
            AppMethodBeat.o(234743);
            return a2;
        }
        url2.toExternalForm();
        System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i2 <= 20) {
                HttpURLConnection a3 = a(url2, j2, j3, z);
                a3.setInstanceFollowRedirects(false);
                a3.connect();
                try {
                    Object a4 = m.a(new a(a3), this.bFu, "GetResponseCodeCallable", getLogTag());
                    if (a4 == null) {
                        closeConnection();
                        l.h hVar = new l.h("getResponseCode TimeoutException Unable to connect to " + gVar.uri.toString() + " within " + this.bFu, new IOException("getResponseCode Timeout " + this.bFu), gVar);
                        AppMethodBeat.o(234743);
                        throw hVar;
                    }
                    int intValue = ((Integer) a4).intValue();
                    if (intValue == 300 || intValue == 301 || intValue == 302 || intValue == 303 || intValue == 307 || intValue == 308) {
                        i3++;
                        String headerField = a3.getHeaderField("Location");
                        try {
                            arrayList.add(new URL(headerField).getHost());
                        } catch (MalformedURLException e2) {
                            h.log(5, getLogTag(), "MalformedURLException url=".concat(String.valueOf(headerField)));
                        }
                        a3.disconnect();
                        if (headerField == null) {
                            ProtocolException protocolException = new ProtocolException("Null location redirect");
                            AppMethodBeat.o(234743);
                            throw protocolException;
                        }
                        if (URLUtil.isNetworkUrl(headerField)) {
                            url = new URL(headerField);
                        } else {
                            url = new URL(url2, headerField);
                        }
                        String protocol = url.getProtocol();
                        if ("https".equals(protocol) || "http".equals(protocol)) {
                            h.log(2, getLogTag(), "redirect to url=" + url.toString() + ", fromUrl=" + url2);
                            i2 = i4;
                            url2 = url;
                        } else {
                            ProtocolException protocolException2 = new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                            AppMethodBeat.o(234743);
                            throw protocolException2;
                        }
                    } else {
                        if (i3 > 0 && com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp != null) {
                            System.currentTimeMillis();
                            com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK();
                            h.bJ(arrayList);
                        }
                        AppMethodBeat.o(234743);
                        return a3;
                    }
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                    h.log(4, getLogTag(), "GetResponseCodeCallable Interrupted");
                    l.b bVar = new l.b("GetResponseCodeCallable interrupted", this.mxt);
                    AppMethodBeat.o(234743);
                    throw bVar;
                } catch (ExecutionException e4) {
                    h.log(5, getLogTag(), "GetResponseCodeCallable ExecutionException " + h.i(e4));
                    l.b bVar2 = new l.b("Failed To Execute GetResponseCodeCallable", this.mxt);
                    AppMethodBeat.o(234743);
                    throw bVar2;
                }
            } else {
                NoRouteToHostException noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i4)));
                AppMethodBeat.o(234743);
                throw noRouteToHostException;
            }
        }
    }

    private HttpURLConnection a(URL url, long j2, long j3, boolean z) {
        HttpURLConnection httpURLConnection;
        AppMethodBeat.i(234744);
        if (h.c(url)) {
            httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(this.bFt);
        httpURLConnection.setReadTimeout(this.bFu);
        httpURLConnection.setDoOutput(false);
        if ((httpURLConnection instanceof HttpsURLConnection) && !com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxj) {
            k.a((HttpsURLConnection) httpURLConnection);
        }
        synchronized (this.myi) {
            try {
                for (Map.Entry<String, String> entry : this.myi.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                AppMethodBeat.o(234744);
                throw th;
            }
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
        h.log(4, getLogTag(), h.abs("send upstream request: \r\n" + httpURLConnection.getRequestMethod() + " " + url + APLogFileUtil.SEPARATOR_LINE + f.T(httpURLConnection.getRequestProperties())));
        AppMethodBeat.o(234744);
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.net.HttpURLConnection r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j.a(java.net.HttpURLConnection, java.lang.String):long");
    }

    private static long b(HttpURLConnection httpURLConnection, String str) {
        AppMethodBeat.i(234746);
        long j2 = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j2 = Long.parseLong(headerField);
            } catch (NumberFormatException e2) {
                h.log(6, str, "Unexpected Content-Length [" + headerField + "]");
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
                        h.log(5, str, "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
                        j2 = Math.max(j2, parseLong);
                    }
                } catch (NumberFormatException e3) {
                    h.log(6, str, "Unexpected Content-Range [" + headerField2 + "]");
                }
            }
        }
        AppMethodBeat.o(234746);
        return j2;
    }

    private void closeConnection() {
        AppMethodBeat.i(234747);
        if (this.connection != null) {
            this.connection.disconnect();
            this.connection = null;
        }
        AppMethodBeat.o(234747);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long getTotalLength() {
        return this.kNt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l
    public final i<String> bJR() {
        return this.myh;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void setLogTag(String str) {
        this.mxw = str;
    }

    public final String getLogTag() {
        AppMethodBeat.i(234749);
        String str = this.mxw + this.TAG;
        AppMethodBeat.o(234749);
        return str;
    }

    public static class a implements Callable<Integer> {
        private HttpURLConnection mConnection;

        public a(HttpURLConnection httpURLConnection) {
            this.mConnection = httpURLConnection;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Integer call() {
            AppMethodBeat.i(234735);
            Integer valueOf = Integer.valueOf(this.mConnection.getResponseCode());
            AppMethodBeat.o(234735);
            return valueOf;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(234741);
        try {
            if (this.bFA != this.bFy) {
                byte[] andSet = bFr.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                getLogTag();
                new StringBuilder("bytes skipped ").append(this.bFA).append(", bytesToSkip ").append(this.bFy);
                while (this.bFA != this.bFy) {
                    int min = (int) Math.min(this.bFy - this.bFA, (long) andSet.length);
                    getLogTag();
                    new StringBuilder("request skip ").append(min).append(" bytes");
                    int read = this.inputStream.read(andSet, 0, min);
                    getLogTag();
                    new StringBuilder("actual skip ").append(read).append(" bytes");
                    if (Thread.interrupted()) {
                        l.c cVar = new l.c("skipInternal interrupted", this.mxt);
                        AppMethodBeat.o(234741);
                        throw cVar;
                    } else if (read == -1) {
                        EOFException eOFException = new EOFException();
                        AppMethodBeat.o(234741);
                        throw eOFException;
                    } else {
                        this.bFA += (long) read;
                        if (this.mxN != null) {
                            this.mxN.xx(read);
                        }
                    }
                }
                bFr.set(andSet);
            }
            if (this.bFz != -1) {
                i3 = (int) Math.min((long) i3, this.bFz - this.bFB);
            }
            if (i3 == 0) {
                AppMethodBeat.o(234741);
                return -1;
            }
            int read2 = this.inputStream.read(bArr, i2, i3);
            if (read2 != -1) {
                this.bFB += (long) read2;
                if (this.mxN != null) {
                    this.mxN.xx(read2);
                }
                AppMethodBeat.o(234741);
                return read2;
            } else if (this.bFz == -1 || this.bFz == this.bFB) {
                AppMethodBeat.o(234741);
                return -1;
            } else {
                EOFException eOFException2 = new EOFException();
                AppMethodBeat.o(234741);
                throw eOFException2;
            }
        } catch (IOException e2) {
            l.a aVar = new l.a(e2, this.mxt);
            AppMethodBeat.o(234741);
            throw aVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final c bJP() {
        AppMethodBeat.i(234748);
        c abd = c.abd(this.contentType);
        AppMethodBeat.o(234748);
        return abd;
    }
}

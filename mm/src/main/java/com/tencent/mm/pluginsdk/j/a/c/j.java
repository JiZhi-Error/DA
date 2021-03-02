package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.b.a;
import com.tencent.mm.pluginsdk.j.a.b.b;
import com.tencent.mm.pluginsdk.j.a.b.d;
import com.tencent.mm.pluginsdk.j.a.b.f;
import com.tencent.mm.pluginsdk.j.a.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import javax.net.ssl.SSLContext;

public final class j {
    private static final Class[] JZW = {InterruptedException.class};
    private static final Class[] JZX = {UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, a.class, d.class, g.class};
    private static final Class[] JZY = {SocketException.class, SocketTimeoutException.class};
    private boolean JZV = false;

    j() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 226
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    static com.tencent.mm.pluginsdk.j.a.c.m a(com.tencent.mm.pluginsdk.j.a.c.e r15) {
        /*
        // Method dump skipped, instructions count: 741
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.j.a.c.j.a(com.tencent.mm.pluginsdk.j.a.c.e):com.tencent.mm.pluginsdk.j.a.c.m");
    }

    private static void gnY() {
        AppMethodBeat.i(152024);
        if (Thread.interrupted()) {
            InterruptedException interruptedException = new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
            AppMethodBeat.o(152024);
            throw interruptedException;
        }
        AppMethodBeat.o(152024);
    }

    private static void a(e eVar, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(152025);
        Log.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", eVar.gnA());
        Collection<b> gnV = eVar.gnV();
        if (gnV != null && gnV.size() > 0) {
            for (b bVar : gnV) {
                httpURLConnection.addRequestProperty(bVar.name, bVar.value);
            }
        }
        httpURLConnection.setRequestMethod(eVar.gnU());
        if ("GET".equalsIgnoreCase(eVar.gnU())) {
            httpURLConnection.setDoOutput(false);
        }
        httpURLConnection.setConnectTimeout(eVar.getConnectTimeout());
        httpURLConnection.setReadTimeout(eVar.getReadTimeout());
        httpURLConnection.setUseCaches(false);
        if (eVar.bwo()) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        String property = System.getProperty("http.agent");
        if (!Util.isNullOrNil(property)) {
            httpURLConnection.setRequestProperty("User-agent", property);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        AppMethodBeat.o(152025);
    }

    private static SSLContext bcs(String str) {
        AppMethodBeat.i(152026);
        try {
            SSLContext instance = SSLContext.getInstance(str);
            AppMethodBeat.o(152026);
            return instance;
        } catch (Exception e2) {
            AppMethodBeat.o(152026);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02c5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02c6, code lost:
        r5 = -1;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02f1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02f2, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ff, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0300, code lost:
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0306, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x030b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0312, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0319, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00db, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00dc, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0112, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0130, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0169, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01f4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02bc A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:1:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02f1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0306 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:66:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x030b A[ExcHandler: SocketException (e java.net.SocketException), Splitter:B:66:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0312 A[ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException), Splitter:B:66:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0319 A[ExcHandler: UnknownHostException (e java.net.UnknownHostException), Splitter:B:66:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00db A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:1:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0112 A[ExcHandler: UnknownHostException (e java.net.UnknownHostException), Splitter:B:1:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0130 A[ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException), Splitter:B:1:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0169 A[ExcHandler: SocketException (e java.net.SocketException), Splitter:B:1:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01f4 A[Catch:{ InterruptedException -> 0x01f4, UnknownHostException -> 0x0319, SSLHandshakeException -> 0x0312, SocketException -> 0x030b, SocketTimeoutException -> 0x0306, IOException -> 0x02ff }, ExcHandler: InterruptedException (e java.lang.InterruptedException), PHI: r4 
      PHI: (r4v18 java.io.InputStream) = (r4v16 java.io.InputStream), (r4v19 java.io.InputStream) binds: [B:66:0x01a1, B:73:0x01b6] A[DONT_GENERATE, DONT_INLINE], Splitter:B:66:0x01a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.pluginsdk.j.a.c.m a(com.tencent.mm.pluginsdk.j.a.c.e r14, java.net.HttpURLConnection r15, boolean r16) {
        /*
        // Method dump skipped, instructions count: 800
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.j.a.c.j.a(com.tencent.mm.pluginsdk.j.a.c.e, java.net.HttpURLConnection, boolean):com.tencent.mm.pluginsdk.j.a.c.m");
    }

    private static m a(e eVar, Exception exc) {
        AppMethodBeat.i(152028);
        int i2 = -1;
        if (exc instanceof f) {
            i2 = ((f) exc).httpStatusCode;
            exc = ((f) exc).JZJ;
        }
        Log.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", eVar.gnA(), exc);
        m mVar = new m(eVar, exc, i2, 3);
        AppMethodBeat.o(152028);
        return mVar;
    }

    private static m b(e eVar, Exception exc) {
        AppMethodBeat.i(152029);
        if (exc instanceof ProtocolException) {
            Log.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", eVar.gnA(), eVar.gnU());
            m a2 = a(eVar, exc);
            AppMethodBeat.o(152029);
            return a2;
        } else if (exc instanceof b) {
            Log.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", eVar.gnA(), exc.getClass().getSimpleName(), exc.getMessage());
            com.tencent.mm.pluginsdk.j.a.d.a.bej(eVar.getFilePath());
            AppMethodBeat.o(152029);
            return null;
        } else {
            for (Class cls : JZW) {
                if (cls.equals(exc.getClass())) {
                    Log.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", eVar.gnA(), exc);
                    m mVar = new m(eVar, exc, 4);
                    AppMethodBeat.o(152029);
                    return mVar;
                }
            }
            for (Class cls2 : JZY) {
                if (cls2.equals(exc.getClass())) {
                    AppMethodBeat.o(152029);
                    return null;
                }
            }
            for (Class cls3 : JZX) {
                if (cls3.equals(exc.getClass())) {
                    m a3 = a(eVar, exc);
                    AppMethodBeat.o(152029);
                    return a3;
                }
            }
            m a4 = a(eVar, exc);
            AppMethodBeat.o(152029);
            return a4;
        }
    }
}

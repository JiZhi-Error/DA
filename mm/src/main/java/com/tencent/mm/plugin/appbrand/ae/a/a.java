package com.tencent.mm.plugin.appbrand.ae.a;

import com.tencent.f.i.e;
import com.tencent.f.i.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.b;
import com.tencent.mm.plugin.appbrand.ae.c;
import com.tencent.mm.plugin.appbrand.ae.e.d;
import com.tencent.mm.plugin.appbrand.ae.e.f;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public abstract class a extends b implements e, g, com.tencent.mm.plugin.appbrand.ae.a, Runnable {
    private int connectTimeout = 0;
    private Future dBz;
    private Map<String, String> headers;
    private String jEY;
    private Timer mTimer = null;
    protected URI oiG = null;
    public c oiH = null;
    private InputStream oiI;
    OutputStream oiJ;
    private Proxy oiK = Proxy.NO_PROXY;
    private Runnable oiL;
    private CountDownLatch oiM = new CountDownLatch(1);
    private CountDownLatch oiN = new CountDownLatch(1);
    private com.tencent.mm.plugin.appbrand.ae.b.a oix;
    private Socket socket = null;

    public abstract void XY(String str);

    public abstract void a(h hVar);

    public abstract void af(int i2, String str);

    public abstract void onError(Exception exc);

    public a(URI uri, com.tencent.mm.plugin.appbrand.ae.b.a aVar, Map<String, String> map, int i2) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (aVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.oiG = uri;
            this.oix = aVar;
            this.headers = map;
            this.connectTimeout = i2;
            this.oiH = new c(this, aVar);
            this.oim = false;
        }
    }

    public final Socket getSocket() {
        return this.socket;
    }

    public final void connect() {
        if (this.oiL != null) {
            Log.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
            return;
        }
        this.oiL = this;
        com.tencent.f.h.RTc.aX(this.oiL);
    }

    @Override // com.tencent.f.i.g
    public String getKey() {
        return "WebsocketWriteThread";
    }

    public final void close() {
        if (this.oiL != null) {
            this.oiH.c(1000, "", false);
        }
    }

    public final void bQ(String str, int i2) {
        if (this.oiL != null) {
            az(i2, str);
        }
    }

    public final void abA(String str) {
        this.oiH.abA(str);
    }

    public void run() {
        int read;
        try {
            if (this.socket == null) {
                this.socket = new Socket(this.oiK);
            } else if (this.socket.isClosed()) {
                throw new IOException();
            }
            this.socket.setTcpNoDelay(this.oim);
            if (!this.socket.isBound()) {
                this.socket.connect(new InetSocketAddress(this.oiG.getHost(), getPort()), this.connectTimeout);
            }
            this.oiI = this.socket.getInputStream();
            this.oiJ = this.socket.getOutputStream();
            bZB();
            this.oiL = new C0535a(this, (byte) 0);
            com.tencent.f.h.RTc.aX(this.oiL);
            byte[] bArr = new byte[c.oin];
            while (!this.oiH.bZA() && !this.oiH.isClosed() && (read = this.oiI.read(bArr)) != -1) {
                try {
                    this.oiH.r(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException e2) {
                    this.oiH.bZz();
                    return;
                } catch (RuntimeException e3) {
                    onError(e3);
                    this.oiH.ax(1006, e3.getMessage());
                    return;
                }
            }
            this.oiH.bZz();
        } catch (Exception e4) {
            this.oiH.ax(-1, e4.getMessage());
        }
    }

    private int getPort() {
        int port = this.oiG.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.oiG.getScheme();
        if (scheme.equals("wss")) {
            return JsApiPauseDownloadTask.CTRL_INDEX;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme".concat(String.valueOf(scheme)));
    }

    @Override // com.tencent.f.i.e
    public final void a(Future future) {
        this.dBz = future;
    }

    private void bZB() {
        String rawPath = this.oiG.getRawPath();
        String rawQuery = this.oiG.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = FilePathGenerator.ANDROID_DIR_SEP;
        }
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        int port = getPort();
        d dVar = new d();
        dVar.afO(rawPath);
        dVar.put("Host", this.oiG.getHost() + (port != 80 ? ":".concat(String.valueOf(port)) : ""));
        if (this.headers != null) {
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                dVar.put(entry.getKey(), entry.getValue());
            }
        }
        c cVar = this.oiH;
        cVar.oiB = cVar.oix.a(dVar);
        cVar.oiF = dVar.bZL();
        if (cVar.oiF != null) {
            try {
                cVar.oiv.b(cVar.oiB);
                cVar.bV(com.tencent.mm.plugin.appbrand.ae.b.a.e(cVar.oiB));
            } catch (com.tencent.mm.plugin.appbrand.ae.c.b e2) {
                throw new com.tencent.mm.plugin.appbrand.ae.c.d("Handshake data rejected by client.");
            } catch (RuntimeException e3) {
                cVar.oiv.k(e3);
                throw new com.tencent.mm.plugin.appbrand.ae.c.d("rejected because of".concat(String.valueOf(e3)));
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public final void afM(String str) {
        XY(str);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public final void v(ByteBuffer byteBuffer) {
        l(byteBuffer);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b, com.tencent.mm.plugin.appbrand.ae.d
    public final void c(com.tencent.mm.plugin.appbrand.ae.d.d dVar) {
        a(dVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public final void d(f fVar) {
        this.oiM.countDown();
        a((h) fVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public final void ay(int i2, String str) {
        this.oiM.countDown();
        this.oiN.countDown();
        if (this.dBz != null) {
            this.dBz.cancel(false);
        }
        if (this.oiL != null && (this.oiL instanceof C0535a)) {
            ((C0535a) this.oiL).isStop = true;
        }
        try {
            if (this.socket != null) {
                this.socket.close();
            }
        } catch (IOException e2) {
            onError(e2);
        }
        af(i2, str);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d
    public final void k(Exception exc) {
        onError(exc);
    }

    public void l(ByteBuffer byteBuffer) {
    }

    public void a(com.tencent.mm.plugin.appbrand.ae.d.d dVar) {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ae.a.a$a  reason: collision with other inner class name */
    class C0535a implements com.tencent.f.i.h {
        volatile boolean isStop;

        private C0535a() {
            this.isStop = false;
        }

        /* synthetic */ C0535a(a aVar, byte b2) {
            this();
        }

        public final void run() {
            ByteBuffer poll;
            AppMethodBeat.i(156624);
            while (!this.isStop && !Thread.interrupted()) {
                try {
                    if ((!a.this.oiH.oir.isEmpty()) && (poll = a.this.oiH.oir.poll(1000, TimeUnit.MILLISECONDS)) != null) {
                        a.this.oiJ.write(poll.array(), 0, poll.limit());
                        a.this.oiJ.flush();
                    }
                } catch (InterruptedException e2) {
                    try {
                        for (ByteBuffer byteBuffer : a.this.oiH.oir) {
                            a.this.oiJ.write(byteBuffer.array(), 0, byteBuffer.limit());
                            a.this.oiJ.flush();
                        }
                    } catch (IOException e3) {
                        a.a(a.this, e3);
                        Log.printErrStackTrace("MicroMsg.AppBrandNetWork.WebSocketClient", e3, "[WebsocketWriteThread] run IOException", new Object[0]);
                        Log.w("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
                        try {
                            a.this.oiJ.close();
                        } catch (IOException e4) {
                        }
                        a.a(a.this);
                        AppMethodBeat.o(156624);
                        return;
                    } catch (Exception e5) {
                        a.a(a.this, e5);
                        Log.printErrStackTrace("MicroMsg.AppBrandNetWork.WebSocketClient", e5, "[WebsocketWriteThread] run Exception", new Object[0]);
                        Log.w("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
                        try {
                            a.this.oiJ.close();
                        } catch (IOException e6) {
                        }
                        a.a(a.this);
                        AppMethodBeat.o(156624);
                        return;
                    } catch (Throwable th) {
                        Log.w("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
                        try {
                            a.this.oiJ.close();
                        } catch (IOException e7) {
                        }
                        a.a(a.this);
                        AppMethodBeat.o(156624);
                        throw th;
                    }
                }
            }
            Log.w("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
            try {
                a.this.oiJ.close();
            } catch (IOException e8) {
            }
            a.a(a.this);
            AppMethodBeat.o(156624);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "WebsocketWriteThread";
        }
    }

    public final void a(Socket socket2) {
        if (this.socket != null) {
            Log.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.socket = socket2;
        }
    }

    public final boolean isOpen() {
        return this.oiH.isOpen();
    }

    public final void az(int i2, String str) {
        this.oiH.c(i2, str, false);
    }

    public final void o(ByteBuffer byteBuffer) {
        this.oiH.o(byteBuffer);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.a
    public final void b(com.tencent.mm.plugin.appbrand.ae.d.d dVar) {
        this.oiH.b(dVar);
    }

    public final String bjl() {
        return this.jEY;
    }

    public final void abz(String str) {
        this.jEY = str;
    }

    public final Timer bLn() {
        return this.mTimer;
    }

    public final void a(Timer timer) {
        this.mTimer = timer;
    }

    static /* synthetic */ void a(a aVar, Exception exc) {
        if (exc instanceof SSLException) {
            aVar.onError(exc);
        }
        aVar.oiH.bZz();
    }

    static /* synthetic */ void a(a aVar) {
        try {
            if (aVar.socket != null) {
                aVar.socket.close();
            }
        } catch (IOException e2) {
            aVar.onError(e2);
        }
    }
}

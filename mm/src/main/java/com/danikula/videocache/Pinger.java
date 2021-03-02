package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* access modifiers changed from: package-private */
public class Pinger {
    private static final String PING_REQUEST = "ping";
    private static final String PING_RESPONSE = "ping ok";
    private final String host;
    private final ExecutorService pingExecutor = Executors.newSingleThreadExecutor();
    private final int port;

    static /* synthetic */ boolean access$100(Pinger pinger) {
        AppMethodBeat.i(223183);
        boolean pingServer = pinger.pingServer();
        AppMethodBeat.o(223183);
        return pingServer;
    }

    Pinger(String str, int i2) {
        AppMethodBeat.i(223176);
        this.host = (String) Preconditions.checkNotNull(str);
        this.port = i2;
        AppMethodBeat.o(223176);
    }

    /* access modifiers changed from: package-private */
    public boolean ping(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(223177);
        Preconditions.checkArgument(i2 > 0);
        if (i3 > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int i4 = 0;
        while (i4 < i2) {
            try {
                if (((Boolean) this.pingExecutor.submit(new PingCallable()).get((long) i3, TimeUnit.MILLISECONDS)).booleanValue()) {
                    AppMethodBeat.o(223177);
                    return true;
                }
                i3 *= 2;
                i4++;
            } catch (TimeoutException e2) {
                Logger.warn("Error pinging server (attempt: " + i4 + ", timeout: " + i3 + "). ");
            } catch (InterruptedException | ExecutionException e3) {
                Logger.error("Error pinging server due to unexpected error");
            }
        }
        Logger.error(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i4), Integer.valueOf(i3 / 2), getDefaultProxies()));
        AppMethodBeat.o(223177);
        return false;
    }

    private List<Proxy> getDefaultProxies() {
        AppMethodBeat.i(223178);
        try {
            List<Proxy> select = ProxySelector.getDefault().select(new URI(getPingUrl()));
            AppMethodBeat.o(223178);
            return select;
        } catch (URISyntaxException e2) {
            IllegalStateException illegalStateException = new IllegalStateException(e2);
            AppMethodBeat.o(223178);
            throw illegalStateException;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isPingRequest(String str) {
        AppMethodBeat.i(223179);
        boolean equals = PING_REQUEST.equals(str);
        AppMethodBeat.o(223179);
        return equals;
    }

    /* access modifiers changed from: package-private */
    public void responseToPing(Socket socket) {
        AppMethodBeat.i(223180);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(PING_RESPONSE.getBytes());
        AppMethodBeat.o(223180);
    }

    private boolean pingServer() {
        AppMethodBeat.i(223181);
        HttpUrlSource httpUrlSource = new HttpUrlSource(getPingUrl());
        try {
            byte[] bytes = PING_RESPONSE.getBytes();
            httpUrlSource.open(0);
            byte[] bArr = new byte[bytes.length];
            httpUrlSource.read(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            Logger.info("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            httpUrlSource.close();
            AppMethodBeat.o(223181);
            return equals;
        } catch (ProxyCacheException e2) {
            Logger.error("Error reading ping response");
            httpUrlSource.close();
            AppMethodBeat.o(223181);
            return false;
        } catch (Throwable th) {
            httpUrlSource.close();
            AppMethodBeat.o(223181);
            throw th;
        }
    }

    private String getPingUrl() {
        AppMethodBeat.i(223182);
        String format = String.format(Locale.US, "http://%s:%d/%s", this.host, Integer.valueOf(this.port), PING_REQUEST);
        AppMethodBeat.o(223182);
        return format;
    }

    class PingCallable implements Callable<Boolean> {
        private PingCallable() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            AppMethodBeat.i(223174);
            Boolean valueOf = Boolean.valueOf(Pinger.access$100(Pinger.this));
            AppMethodBeat.o(223174);
            return valueOf;
        }
    }
}

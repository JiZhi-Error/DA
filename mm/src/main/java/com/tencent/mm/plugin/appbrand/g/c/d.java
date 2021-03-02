package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c.c;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class d {
    String ip;
    c.a lkG;
    int port;
    boolean running;
    ServerSocket serverSocket;

    /* synthetic */ d(byte b2) {
        this();
    }

    public static class c {
        private static d lkO = new d((byte) 0);

        static {
            AppMethodBeat.i(158975);
            AppMethodBeat.o(158975);
        }
    }

    private d() {
        this.running = false;
        this.port = -1;
    }

    public final synchronized void start() {
        AppMethodBeat.i(158976);
        if (this.running) {
            AppMethodBeat.o(158976);
        } else {
            this.running = true;
            try {
                this.ip = g.bBA();
                this.serverSocket = new ServerSocket(0, 32, InetAddress.getByName(this.ip));
                this.port = this.serverSocket.getLocalPort();
                new Thread(new b()).start();
                AppMethodBeat.o(158976);
            } catch (IOException e2) {
                AppMethodBeat.o(158976);
            }
        }
    }

    public final synchronized void stop() {
        AppMethodBeat.i(158977);
        if (!this.running) {
            AppMethodBeat.o(158977);
        } else {
            this.running = false;
            if (this.serverSocket != null && this.serverSocket.isClosed()) {
                try {
                    this.serverSocket.close();
                    AppMethodBeat.o(158977);
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(158977);
        }
    }

    public class b implements Runnable {
        b() {
            d.this = r1;
        }

        public final void run() {
            AppMethodBeat.i(158974);
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4);
            while (d.this.running) {
                try {
                    newScheduledThreadPool.submit(new a(d.this.serverSocket.accept()));
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(158974);
        }
    }

    class a implements Callable<Void> {
        private Socket socket;

        a(Socket socket2) {
            d.this = r1;
            this.socket = socket2;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ea, code lost:
            if (r3.equals("/upnp/cb/AVTransport") != false) goto L_0x00a6;
         */
        @Override // java.util.concurrent.Callable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.Void call() {
            /*
            // Method dump skipped, instructions count: 308
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.c.d.a.call():java.lang.Void");
        }

        private void a(com.tencent.mm.plugin.appbrand.g.c.b.d dVar, BufferedWriter bufferedWriter) {
            AppMethodBeat.i(158972);
            c.a aVar = d.this.lkG;
            if (aVar == null || aVar.b(dVar)) {
                bufferedWriter.write("HTTP/1.1 200 OK\r\nContent-Length: 0\r\n\r\n");
                AppMethodBeat.o(158972);
                return;
            }
            bufferedWriter.write("HTTP/1.1 500 Internal Server Error\r\nContent-Length: 0\r\n\r\n");
            AppMethodBeat.o(158972);
        }
    }
}

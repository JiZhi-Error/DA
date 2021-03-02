package com.tencent.mm.plugin.appbrand.g.c;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.List;

public class e {
    private static final String TAG = e.class.getSimpleName();
    protected f lkP;
    protected h lkQ;
    protected List<NetworkInterface> lkR;
    protected InetSocketAddress lkS;
    protected MulticastSocket lkT;
    protected MulticastSocket lkU;
    private int port;
    private boolean running = false;

    static {
        AppMethodBeat.i(158986);
        AppMethodBeat.o(158986);
    }

    public e(f fVar, List<NetworkInterface> list, h hVar, int i2) {
        AppMethodBeat.i(158980);
        this.lkP = fVar;
        this.port = i2;
        a(list, hVar);
        AppMethodBeat.o(158980);
    }

    private void a(List<NetworkInterface> list, h hVar) {
        AppMethodBeat.i(158981);
        this.lkQ = hVar;
        this.lkR = list;
        try {
            this.lkT = new MulticastSocket(this.port);
            this.lkT.setReuseAddress(true);
            this.lkT.setReceiveBufferSize(32768);
            com.tencent.mm.plugin.appbrand.g.a.i(TAG, "Creating wildcard socketNotify (for receiving multicast datagrams) on port: " + this.lkP.port);
            this.lkS = new InetSocketAddress(this.lkP.lkX, this.lkP.port);
            this.lkU = new MulticastSocket(this.lkP.port);
            this.lkU.setReuseAddress(true);
            this.lkU.setReceiveBufferSize(32768);
            for (NetworkInterface networkInterface : this.lkR) {
                com.tencent.mm.plugin.appbrand.g.a.i(TAG, "Joining multicast group: " + this.lkS + " on network interface: " + networkInterface.getDisplayName());
                this.lkU.joinGroup(this.lkS, networkInterface);
            }
            AppMethodBeat.o(158981);
        } catch (Exception e2) {
            Exception exc = new Exception("Could not initialize " + TAG + ": " + e2);
            AppMethodBeat.o(158981);
            throw exc;
        }
    }

    public final synchronized void start() {
        AppMethodBeat.i(158982);
        if (this.running) {
            AppMethodBeat.o(158982);
        } else {
            this.running = true;
            new Thread(new b(this, (byte) 0)).start();
            new Thread(new a(this, (byte) 0)).start();
            AppMethodBeat.o(158982);
        }
    }

    public final synchronized void close() {
        AppMethodBeat.i(158983);
        this.running = false;
        if (this.lkT != null && !this.lkT.isClosed()) {
            this.lkT.close();
        }
        if (this.lkU != null && !this.lkU.isClosed()) {
            try {
                com.tencent.mm.plugin.appbrand.g.a.i(TAG, "Leaving multicast group");
                for (NetworkInterface networkInterface : this.lkR) {
                    this.lkU.leaveGroup(this.lkS, networkInterface);
                }
            } catch (Exception e2) {
                com.tencent.mm.plugin.appbrand.g.a.i(TAG, "Could not leave multicast group: ".concat(String.valueOf(e2)));
            }
            this.lkU.close();
        }
        AppMethodBeat.o(158983);
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(e eVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(158979);
            try {
                e.a(e.this);
                AppMethodBeat.o(158979);
            } catch (Exception e2) {
                if (e2.getCause() != null) {
                    com.tencent.mm.plugin.appbrand.g.a.e(e.TAG, e2.getCause().toString());
                }
                AppMethodBeat.o(158979);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(158978);
            try {
                e.b(e.this);
                AppMethodBeat.o(158978);
            } catch (Exception e2) {
                if (e2.getCause() != null) {
                    com.tencent.mm.plugin.appbrand.g.a.e(e.TAG, e2.getCause().toString());
                }
                AppMethodBeat.o(158978);
            }
        }
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(158984);
        com.tencent.mm.plugin.appbrand.g.a.i(TAG, "Entering blocking search receiving loop, listening for UDP datagrams on port: " + eVar.lkT.getLocalPort());
        j.bBE();
        while (eVar.running) {
            try {
                byte[] bArr = new byte[eVar.lkP.lkY];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
                eVar.lkT.receive(datagramPacket);
                String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), ProtocolPackage.ServerEncoding);
                com.tencent.mm.plugin.appbrand.g.a.i(TAG, "loopSearch: content = ".concat(String.valueOf(str)));
                com.tencent.mm.plugin.appbrand.g.c.b.b Ye = j.Ye(str);
                if (Ye != null) {
                    eVar.lkQ.a(Ye);
                } else {
                    com.tencent.mm.plugin.appbrand.g.a.e(TAG, "discard this message");
                }
            } catch (IOException e2) {
                com.tencent.mm.plugin.appbrand.g.a.e(TAG, "search fail: " + Log.getStackTraceString(e2));
                eVar.running = false;
                AppMethodBeat.o(158984);
                throw e2;
            }
        }
        com.tencent.mm.plugin.appbrand.g.a.e(TAG, "loop end");
        AppMethodBeat.o(158984);
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(158985);
        com.tencent.mm.plugin.appbrand.g.a.i(TAG, "Entering blocking notify receiving loop, listening for UDP datagrams on port: " + eVar.lkU.getLocalPort());
        j.bBE();
        while (eVar.running) {
            try {
                byte[] bArr = new byte[eVar.lkP.lkY];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
                eVar.lkU.receive(datagramPacket);
                String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), ProtocolPackage.ServerEncoding);
                com.tencent.mm.plugin.appbrand.g.a.i(TAG, str);
                com.tencent.mm.plugin.appbrand.g.c.b.b Ye = j.Ye(str);
                if (Ye != null) {
                    eVar.lkQ.a(Ye);
                } else {
                    com.tencent.mm.plugin.appbrand.g.a.i(TAG, "receive a not care notify message");
                }
            } catch (IOException e2) {
                com.tencent.mm.plugin.appbrand.g.a.e(TAG, "notify fail: " + Log.getStackTraceString(e2));
                eVar.running = false;
                AppMethodBeat.o(158985);
                throw e2;
            }
        }
        com.tencent.mm.plugin.appbrand.g.a.e(TAG, "loop end");
        AppMethodBeat.o(158985);
    }
}

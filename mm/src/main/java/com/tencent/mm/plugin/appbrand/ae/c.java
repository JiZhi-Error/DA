package com.tencent.mm.plugin.appbrand.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.a;
import com.tencent.mm.plugin.appbrand.ae.b.a;
import com.tencent.mm.plugin.appbrand.ae.b.b;
import com.tencent.mm.plugin.appbrand.ae.d.d;
import com.tencent.mm.plugin.appbrand.ae.e.f;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c implements a {
    public static boolean DEBUG = false;
    public static int oin = 16384;
    public static final List<a> oio;
    private ByteBuffer oiA = ByteBuffer.allocate(0);
    public com.tencent.mm.plugin.appbrand.ae.e.a oiB = null;
    private String oiC = null;
    private Integer oiD = null;
    private Boolean oiE = null;
    public String oiF = null;
    public SelectionKey oip;
    public ByteChannel oiq;
    public final BlockingQueue<ByteBuffer> oir;
    public final BlockingQueue<ByteBuffer> ois;
    private volatile boolean oit = false;
    private a.EnumC0534a oiu = a.EnumC0534a.NOT_YET_CONNECTED;
    public final d oiv;
    private List<com.tencent.mm.plugin.appbrand.ae.b.a> oiw;
    public com.tencent.mm.plugin.appbrand.ae.b.a oix = null;
    public a.b oiy;
    private d.a oiz = null;

    static {
        AppMethodBeat.i(156623);
        ArrayList arrayList = new ArrayList(4);
        oio = arrayList;
        arrayList.add(new com.tencent.mm.plugin.appbrand.ae.b.c());
        oio.add(new b());
        oio.add(new com.tencent.mm.plugin.appbrand.ae.b.d());
        AppMethodBeat.o(156623);
    }

    public c(d dVar, com.tencent.mm.plugin.appbrand.ae.b.a aVar) {
        AppMethodBeat.i(156604);
        if (aVar == null && this.oiy == a.b.SERVER) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parameters must not be null");
            AppMethodBeat.o(156604);
            throw illegalArgumentException;
        }
        this.oir = new LinkedBlockingQueue();
        this.ois = new LinkedBlockingQueue();
        this.oiv = dVar;
        this.oiy = a.b.CLIENT;
        if (aVar != null) {
            this.oix = aVar.bZD();
        }
        AppMethodBeat.o(156604);
    }

    public final void r(ByteBuffer byteBuffer) {
        AppMethodBeat.i(156605);
        if (DEBUG) {
            Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.oiu != a.EnumC0534a.NOT_YET_CONNECTED) {
            if (this.oiu == a.EnumC0534a.OPEN) {
                t(byteBuffer);
                AppMethodBeat.o(156605);
                return;
            }
        } else if (s(byteBuffer) && !bZA() && !isClosed()) {
            if (byteBuffer.hasRemaining()) {
                t(byteBuffer);
                AppMethodBeat.o(156605);
                return;
            } else if (this.oiA.hasRemaining()) {
                t(this.oiA);
            }
        }
        AppMethodBeat.o(156605);
    }

    private boolean s(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        AppMethodBeat.i(156606);
        if (this.oiA.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.oiA.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.oiA.capacity() + byteBuffer.remaining());
                this.oiA.flip();
                allocate.put(this.oiA);
                this.oiA = allocate;
            }
            this.oiA.put(byteBuffer);
            this.oiA.flip();
            byteBuffer2 = this.oiA;
        }
        byteBuffer2.mark();
        try {
            if (this.oiy != a.b.SERVER) {
                if (this.oiy == a.b.CLIENT) {
                    this.oix.a(this.oiy);
                    f y = this.oix.y(byteBuffer2);
                    if (!(y instanceof h)) {
                        d(1002, "wrong http function", false);
                        AppMethodBeat.o(156606);
                        return false;
                    }
                    h hVar = (h) y;
                    if (this.oix.a(this.oiB, hVar) == a.b.MATCHED) {
                        c(hVar);
                        AppMethodBeat.o(156606);
                        return true;
                    }
                    c(1002, "draft refuses handshake " + ((int) hVar.bZN()) + " " + hVar.bZM(), false);
                }
                AppMethodBeat.o(156606);
                return false;
            } else if (this.oix == null) {
                for (com.tencent.mm.plugin.appbrand.ae.b.a aVar : this.oiw) {
                    com.tencent.mm.plugin.appbrand.ae.b.a bZD = aVar.bZD();
                    try {
                        bZD.a(this.oiy);
                        byteBuffer2.reset();
                        f y2 = bZD.y(byteBuffer2);
                        if (!(y2 instanceof com.tencent.mm.plugin.appbrand.ae.e.a)) {
                            d(1002, "wrong http function", false);
                            AppMethodBeat.o(156606);
                            return false;
                        }
                        com.tencent.mm.plugin.appbrand.ae.e.a aVar2 = (com.tencent.mm.plugin.appbrand.ae.e.a) y2;
                        if (bZD.c(aVar2) == a.b.MATCHED) {
                            this.oiF = aVar2.bZL();
                            try {
                                bV(com.tencent.mm.plugin.appbrand.ae.b.a.f(bZD.a(aVar2, this.oiv.bZy())));
                                this.oix = bZD;
                                c(aVar2);
                                AppMethodBeat.o(156606);
                                return true;
                            } catch (com.tencent.mm.plugin.appbrand.ae.c.b e2) {
                                d(e2.ojg, e2.getMessage(), false);
                                AppMethodBeat.o(156606);
                                return false;
                            } catch (RuntimeException e3) {
                                this.oiv.k(e3);
                                d(-1, e3.getMessage(), false);
                                AppMethodBeat.o(156606);
                                return false;
                            }
                        }
                    } catch (com.tencent.mm.plugin.appbrand.ae.c.d e4) {
                        Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e4.toString());
                    }
                }
                if (this.oix == null) {
                    c(1002, "no draft matches", false);
                }
                AppMethodBeat.o(156606);
                return false;
            } else {
                f y3 = this.oix.y(byteBuffer2);
                if (!(y3 instanceof com.tencent.mm.plugin.appbrand.ae.e.a)) {
                    d(1002, "wrong http function", false);
                    AppMethodBeat.o(156606);
                    return false;
                }
                com.tencent.mm.plugin.appbrand.ae.e.a aVar3 = (com.tencent.mm.plugin.appbrand.ae.e.a) y3;
                if (this.oix.c(aVar3) == a.b.MATCHED) {
                    c(aVar3);
                    AppMethodBeat.o(156606);
                    return true;
                }
                c(1002, "the handshake did finaly not match", false);
                AppMethodBeat.o(156606);
                return false;
            }
        } catch (com.tencent.mm.plugin.appbrand.ae.c.d e5) {
            try {
                Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e5.toString());
                a(e5);
            } catch (com.tencent.mm.plugin.appbrand.ae.c.a e6) {
                Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e6.toString());
                if (this.oiA.capacity() == 0) {
                    byteBuffer2.reset();
                    int i2 = e6.ojf;
                    if (i2 == 0) {
                        i2 = byteBuffer2.capacity() + 16;
                    }
                    this.oiA = ByteBuffer.allocate(i2);
                    this.oiA.put(byteBuffer);
                } else {
                    this.oiA.position(this.oiA.limit());
                    this.oiA.limit(this.oiA.capacity());
                }
            }
        }
    }

    private void t(ByteBuffer byteBuffer) {
        String str;
        AppMethodBeat.i(156607);
        try {
            for (d dVar : this.oix.x(byteBuffer)) {
                if (DEBUG) {
                    Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: ".concat(String.valueOf(dVar)));
                }
                d.a bZK = dVar.bZK();
                boolean bZI = dVar.bZI();
                if (bZK == d.a.CLOSING) {
                    int i2 = 1005;
                    if (dVar instanceof com.tencent.mm.plugin.appbrand.ae.d.a) {
                        com.tencent.mm.plugin.appbrand.ae.d.a aVar = (com.tencent.mm.plugin.appbrand.ae.d.a) dVar;
                        int bZE = aVar.bZE();
                        str = aVar.getMessage();
                        i2 = bZE;
                    } else {
                        str = "";
                    }
                    if (this.oiu == a.EnumC0534a.CLOSING) {
                        ax(i2, str);
                    } else if (this.oix.bZC() == a.EnumC0536a.TWOWAY) {
                        c(i2, str, true);
                    } else {
                        d(i2, str, false);
                    }
                } else if (bZK == d.a.PING) {
                    this.oiv.a(this, dVar);
                } else if (bZK == d.a.PONG) {
                    continue;
                } else if (!bZI || bZK == d.a.CONTINUOUS) {
                    if (bZK != d.a.CONTINUOUS) {
                        if (this.oiz != null) {
                            com.tencent.mm.plugin.appbrand.ae.c.b bVar = new com.tencent.mm.plugin.appbrand.ae.c.b("Previous continuous frame sequence not completed.");
                            AppMethodBeat.o(156607);
                            throw bVar;
                        }
                        this.oiz = bZK;
                    } else if (bZI) {
                        if (this.oiz == null) {
                            com.tencent.mm.plugin.appbrand.ae.c.b bVar2 = new com.tencent.mm.plugin.appbrand.ae.c.b("Continuous frame sequence was not started.");
                            AppMethodBeat.o(156607);
                            throw bVar2;
                        }
                        this.oiz = null;
                    } else if (this.oiz == null) {
                        com.tencent.mm.plugin.appbrand.ae.c.b bVar3 = new com.tencent.mm.plugin.appbrand.ae.c.b("Continuous frame sequence was not started.");
                        AppMethodBeat.o(156607);
                        throw bVar3;
                    }
                    try {
                        this.oiv.c(dVar);
                    } catch (RuntimeException e2) {
                        this.oiv.k(e2);
                    }
                } else if (this.oiz != null) {
                    com.tencent.mm.plugin.appbrand.ae.c.b bVar4 = new com.tencent.mm.plugin.appbrand.ae.c.b("Continuous frame sequence not completed.");
                    AppMethodBeat.o(156607);
                    throw bVar4;
                } else if (bZK == d.a.TEXT) {
                    try {
                        this.oiv.afM(com.tencent.mm.plugin.appbrand.ae.f.b.B(dVar.bZH()));
                    } catch (RuntimeException e3) {
                        this.oiv.k(e3);
                    }
                } else if (bZK == d.a.BINARY) {
                    try {
                        this.oiv.v(dVar.bZH());
                    } catch (RuntimeException e4) {
                        this.oiv.k(e4);
                    }
                } else {
                    com.tencent.mm.plugin.appbrand.ae.c.b bVar5 = new com.tencent.mm.plugin.appbrand.ae.c.b("non control or continious frame expected");
                    AppMethodBeat.o(156607);
                    throw bVar5;
                }
            }
            AppMethodBeat.o(156607);
        } catch (com.tencent.mm.plugin.appbrand.ae.c.b e5) {
            Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + e5.toString());
            this.oiv.k(e5);
            a(e5);
            AppMethodBeat.o(156607);
        }
    }

    public final void c(int i2, String str, boolean z) {
        AppMethodBeat.i(156608);
        if (this.oiu == a.EnumC0534a.CLOSING || this.oiu == a.EnumC0534a.CLOSED) {
            AppMethodBeat.o(156608);
            return;
        }
        if (this.oiu == a.EnumC0534a.OPEN) {
            if (i2 == 1006) {
                this.oiu = a.EnumC0534a.CLOSING;
                d(i2, str, false);
                AppMethodBeat.o(156608);
                return;
            }
            if (this.oix.bZC() != a.EnumC0536a.NONE) {
                try {
                    b(new com.tencent.mm.plugin.appbrand.ae.d.b(i2, str));
                } catch (com.tencent.mm.plugin.appbrand.ae.c.b e2) {
                    Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e2.toString());
                    this.oiv.k(e2);
                    d(1006, "generated frame is invalid", false);
                }
            }
            d(i2, str, z);
        } else if (i2 == -3) {
            d(-3, str, true);
        } else {
            d(-1, str, false);
        }
        if (i2 == 1002) {
            d(i2, str, z);
        }
        this.oiu = a.EnumC0534a.CLOSING;
        this.oiA = null;
        AppMethodBeat.o(156608);
    }

    public final synchronized void ax(int i2, String str) {
        AppMethodBeat.i(156609);
        if (this.oiu == a.EnumC0534a.CLOSED) {
            AppMethodBeat.o(156609);
        } else {
            if (this.oip != null) {
                this.oip.cancel();
            }
            if (this.oiq != null) {
                try {
                    this.oiq.close();
                } catch (IOException e2) {
                    this.oiv.k(e2);
                }
            }
            try {
                this.oiv.ay(i2, str);
            } catch (RuntimeException e3) {
                this.oiv.k(e3);
            }
            if (this.oix != null) {
                this.oix.reset();
            }
            this.oiB = null;
            this.oiu = a.EnumC0534a.CLOSED;
            this.oir.clear();
            AppMethodBeat.o(156609);
        }
    }

    private void zG(int i2) {
        AppMethodBeat.i(156610);
        ax(i2, "");
        AppMethodBeat.o(156610);
    }

    private synchronized void d(int i2, String str, boolean z) {
        AppMethodBeat.i(156611);
        if (this.oit) {
            AppMethodBeat.o(156611);
        } else {
            this.oiD = Integer.valueOf(i2);
            this.oiC = str;
            this.oiE = Boolean.valueOf(z);
            this.oit = true;
            if (this.oix != null) {
                this.oix.reset();
            }
            this.oiB = null;
            AppMethodBeat.o(156611);
        }
    }

    public final void abA(String str) {
        AppMethodBeat.i(156614);
        if (str == null) {
            Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
            AppMethodBeat.o(156614);
            return;
        }
        g(this.oix.aF(str, this.oiy == a.b.CLIENT));
        AppMethodBeat.o(156614);
    }

    public final void o(ByteBuffer byteBuffer) {
        AppMethodBeat.i(156615);
        if (byteBuffer == null) {
            Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
            AppMethodBeat.o(156615);
            return;
        }
        g(this.oix.a(byteBuffer, this.oiy == a.b.CLIENT));
        AppMethodBeat.o(156615);
    }

    private void g(Collection<d> collection) {
        AppMethodBeat.i(156616);
        if (!isOpen()) {
            com.tencent.mm.plugin.appbrand.ae.c.f fVar = new com.tencent.mm.plugin.appbrand.ae.c.f();
            AppMethodBeat.o(156616);
            throw fVar;
        }
        for (d dVar : collection) {
            b(dVar);
        }
        AppMethodBeat.o(156616);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.a
    public final void b(d dVar) {
        AppMethodBeat.i(156617);
        if (DEBUG) {
            Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        u(this.oix.d(dVar));
        AppMethodBeat.o(156617);
    }

    private void u(ByteBuffer byteBuffer) {
        AppMethodBeat.i(156618);
        if (DEBUG) {
            Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.oir.add(byteBuffer);
        AppMethodBeat.o(156618);
    }

    public final void bV(List<ByteBuffer> list) {
        AppMethodBeat.i(156619);
        for (ByteBuffer byteBuffer : list) {
            u(byteBuffer);
        }
        AppMethodBeat.o(156619);
    }

    private void c(f fVar) {
        AppMethodBeat.i(156620);
        if (DEBUG) {
            Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.oix.getClass().getSimpleName());
        }
        this.oiu = a.EnumC0534a.OPEN;
        try {
            this.oiv.d(fVar);
            AppMethodBeat.o(156620);
        } catch (RuntimeException e2) {
            this.oiv.k(e2);
            AppMethodBeat.o(156620);
        }
    }

    public final boolean isOpen() {
        return this.oiu == a.EnumC0534a.OPEN;
    }

    public final boolean bZA() {
        return this.oiu == a.EnumC0534a.CLOSING;
    }

    public final boolean isClosed() {
        return this.oiu == a.EnumC0534a.CLOSED;
    }

    public final int hashCode() {
        AppMethodBeat.i(156621);
        int hashCode = super.hashCode();
        AppMethodBeat.o(156621);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(156622);
        String obj = super.toString();
        AppMethodBeat.o(156622);
        return obj;
    }

    public final void bZz() {
        AppMethodBeat.i(156612);
        if (this.oiu == a.EnumC0534a.NOT_YET_CONNECTED) {
            zG(-1);
            AppMethodBeat.o(156612);
        } else if (this.oit) {
            int intValue = this.oiD.intValue();
            String str = this.oiC;
            this.oiE.booleanValue();
            ax(intValue, str);
            AppMethodBeat.o(156612);
        } else if (this.oix.bZC() == a.EnumC0536a.NONE) {
            zG(1000);
            AppMethodBeat.o(156612);
        } else if (this.oix.bZC() != a.EnumC0536a.ONEWAY || this.oiy == a.b.SERVER) {
            zG(1006);
            AppMethodBeat.o(156612);
        } else {
            zG(1000);
            AppMethodBeat.o(156612);
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.ae.c.b bVar) {
        AppMethodBeat.i(156613);
        c(bVar.ojg, bVar.getMessage(), false);
        AppMethodBeat.o(156613);
    }
}

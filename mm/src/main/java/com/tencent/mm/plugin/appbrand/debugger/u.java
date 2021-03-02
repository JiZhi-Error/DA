package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.a.a;
import com.tencent.mm.plugin.appbrand.ae.b.d;
import com.tencent.mm.plugin.appbrand.ae.d.d;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.plugin.appbrand.ae.f.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class u {
    a liS;
    private SSLSocketFactory liT;

    public u(com.tencent.mm.plugin.appbrand.s.a aVar) {
        AppMethodBeat.i(147090);
        SSLContext a2 = j.a(aVar);
        if (a2 != null) {
            this.liT = a2.getSocketFactory();
        }
        AppMethodBeat.o(147090);
    }

    public final void a(String str, final k.b bVar) {
        SSLSocketFactory sSLSocketFactory;
        AppMethodBeat.i(147091);
        Log.i("MicroMsg.RemoteDebugSocket", "connectSocket url is %s", str);
        try {
            URI uri = new URI(str);
            HashMap hashMap = new HashMap();
            if (str.startsWith("ws://localhost:")) {
                hashMap.put("Sec-WebSocket-Protocol", "client");
            }
            try {
                this.liS = new a(uri, new d(), hashMap) {
                    /* class com.tencent.mm.plugin.appbrand.debugger.u.AnonymousClass1 */
                    private com.tencent.mm.plugin.appbrand.ae.d.d liU = null;

                    @Override // com.tencent.mm.plugin.appbrand.ae.a.a
                    public final void a(h hVar) {
                        AppMethodBeat.i(147084);
                        Log.d("MicroMsg.RemoteDebugSocket", "onSocketOpen");
                        bVar.bAN();
                        AppMethodBeat.o(147084);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.ae.a.a
                    public final void XY(String str) {
                        AppMethodBeat.i(147085);
                        u.this.liS.abA(str);
                        Log.d("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", str);
                        bVar.bAO();
                        AppMethodBeat.o(147085);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.ae.a.a
                    public final void af(int i2, String str) {
                        AppMethodBeat.i(147086);
                        Log.i("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", str, Integer.valueOf(i2));
                        if (i2 == -1 || i2 == -2 || i2 == -3) {
                            if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                                bVar.XT("network is down");
                                i2 = 1006;
                            } else {
                                bVar.XT(str);
                            }
                            bVar.ae(i2, str);
                            AppMethodBeat.o(147086);
                            return;
                        }
                        bVar.ae(i2, str);
                        AppMethodBeat.o(147086);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.ae.a.a
                    public final void onError(Exception exc) {
                        AppMethodBeat.i(147087);
                        Log.e("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + exc.toString());
                        AppMethodBeat.o(147087);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.ae.a.a
                    public final void l(ByteBuffer byteBuffer) {
                        AppMethodBeat.i(147088);
                        bVar.k(byteBuffer);
                        AppMethodBeat.o(147088);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.ae.a.a
                    public final void a(com.tencent.mm.plugin.appbrand.ae.d.d dVar) {
                        AppMethodBeat.i(147089);
                        if (dVar.bZK() == d.a.CONTINUOUS || dVar.bZI()) {
                            if (dVar.bZK() == d.a.CONTINUOUS) {
                                if (this.liU == null) {
                                    AppMethodBeat.o(147089);
                                    return;
                                } else if (this.liU.bZH().position() > 10485760) {
                                    Log.e("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
                                    this.liU = null;
                                    AppMethodBeat.o(147089);
                                    return;
                                } else {
                                    try {
                                        this.liU.e(dVar);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.RemoteDebugSocket", e2.getMessage());
                                    }
                                    if (!dVar.bZI()) {
                                        AppMethodBeat.o(147089);
                                        return;
                                    }
                                    if (this.liU.bZK() == d.a.BINARY) {
                                        l(this.liU.bZH());
                                    } else if (this.liU.bZK() == d.a.TEXT) {
                                        try {
                                            XY(Util.nullAsNil(b.B(this.liU.bZH())));
                                        } catch (Exception e3) {
                                            Log.e("MicroMsg.RemoteDebugSocket", e3.getMessage());
                                        }
                                    }
                                    this.liU = null;
                                }
                            }
                            AppMethodBeat.o(147089);
                            return;
                        }
                        this.liU = dVar;
                        AppMethodBeat.o(147089);
                    }
                };
                if (l.C(str, "ws://")) {
                    this.liS.a(new Socket(Proxy.NO_PROXY));
                    this.liS.connect();
                    AppMethodBeat.o(147091);
                    return;
                }
                if (this.liT != null) {
                    sSLSocketFactory = this.liT;
                } else {
                    sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                }
                this.liS.a(sSLSocketFactory.createSocket());
                this.liS.connect();
                AppMethodBeat.o(147091);
            } catch (Exception e2) {
                Log.e("MicroMsg.RemoteDebugSocket", "onSocketMessage %s", android.util.Log.getStackTraceString(e2));
                AppMethodBeat.o(147091);
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.RemoteDebugSocket", "connect fail : %s ", e3.toString());
            bVar.XU("url not well format");
            AppMethodBeat.o(147091);
        }
    }

    public final boolean isOpen() {
        AppMethodBeat.i(147092);
        if (this.liS == null) {
            AppMethodBeat.o(147092);
            return false;
        }
        boolean isOpen = this.liS.oiH.isOpen();
        AppMethodBeat.o(147092);
        return isOpen;
    }

    public final boolean a(evf evf) {
        AppMethodBeat.i(147093);
        Log.d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
        if (!isOpen()) {
            Log.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
            AppMethodBeat.o(147093);
            return false;
        } else if (evf == null) {
            Log.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
            AppMethodBeat.o(147093);
            return false;
        } else {
            this.liS.o(v.g(evf));
            AppMethodBeat.o(147093);
            return true;
        }
    }

    public final boolean XX(String str) {
        AppMethodBeat.i(147094);
        if (this.liS == null) {
            Log.w("MicroMsg.RemoteDebugSocket", "client is null");
            AppMethodBeat.o(147094);
            return false;
        }
        this.liS.az(1000, str);
        Log.d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", 1000, str);
        AppMethodBeat.o(147094);
        return true;
    }
}

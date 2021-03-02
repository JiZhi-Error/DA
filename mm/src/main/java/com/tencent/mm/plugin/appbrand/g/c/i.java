package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import org.apache.http.client.methods.HttpPost;

public final class i {
    static i lli;
    MulticastSocket llj;
    InetAddress llk;
    int port = -1;

    i(boolean z) {
        AppMethodBeat.i(159011);
        try {
            this.llk = InetAddress.getByName("239.255.255.250");
            if (z) {
                this.llj = new MulticastSocket();
                this.llj.setBroadcast(true);
                this.port = this.llj.getLocalPort();
            }
            AppMethodBeat.o(159011);
        } catch (IOException e2) {
            com.tencent.mm.plugin.appbrand.g.a.a("TransporterImpl", e2, "");
            AppMethodBeat.o(159011);
        }
    }

    public static i bBD() {
        AppMethodBeat.i(159012);
        if (lli == null) {
            synchronized (a.class) {
                try {
                    if (lli == null) {
                        lli = new i(true);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(159012);
                    throw th;
                }
            }
        }
        i iVar = lli;
        AppMethodBeat.o(159012);
        return iVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.appbrand.g.c.b.e a(com.tencent.mm.plugin.appbrand.g.a.e r10) {
        /*
        // Method dump skipped, instructions count: 216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.c.i.a(com.tencent.mm.plugin.appbrand.g.a.e):com.tencent.mm.plugin.appbrand.g.c.b.e");
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(159014);
        if (this == lli) {
            this.llj.close();
        }
        super.finalize();
        AppMethodBeat.o(159014);
    }

    public static class a extends HttpPost {
        private e.a ljv;

        public a(String str, e.a aVar) {
            super(str);
            this.ljv = aVar;
        }

        public final String getMethod() {
            AppMethodBeat.i(159010);
            String name = this.ljv.name();
            AppMethodBeat.o(159010);
            return name;
        }
    }
}

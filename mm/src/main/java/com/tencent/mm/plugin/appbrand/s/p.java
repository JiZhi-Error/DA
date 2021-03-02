package com.tencent.mm.plugin.appbrand.s;

import android.annotation.TargetApi;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum p {
    INSTANCE;
    
    public final Map<b, NsdManager.DiscoveryListener> njd = new ConcurrentHashMap();

    public interface a {
        void c(c cVar);

        void d(c cVar);
    }

    public interface b {
        void a(c cVar);

        void b(c cVar);

        void bHE();

        void bHF();

        void bHG();

        void bHH();
    }

    private p(String str) {
        AppMethodBeat.i(144455);
        AppMethodBeat.o(144455);
    }

    static /* synthetic */ NsdManager bPL() {
        AppMethodBeat.i(144458);
        NsdManager bPK = bPK();
        AppMethodBeat.o(144458);
        return bPK;
    }

    public static p valueOf(String str) {
        AppMethodBeat.i(144454);
        p pVar = (p) Enum.valueOf(p.class, str);
        AppMethodBeat.o(144454);
        return pVar;
    }

    static {
        AppMethodBeat.i(144459);
        AppMethodBeat.o(144459);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(144456);
        synchronized (this.njd) {
            try {
                if (this.njd.containsKey(bVar)) {
                    try {
                        bPK().stopServiceDiscovery(this.njd.get(bVar));
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.LocalServiceMgr", th, "Throwable: stopScanServices", new Object[0]);
                    }
                    this.njd.remove(bVar);
                    AppMethodBeat.o(144456);
                }
            } finally {
                AppMethodBeat.o(144456);
            }
        }
    }

    public static NsdManager bPK() {
        AppMethodBeat.i(144457);
        NsdManager nsdManager = (NsdManager) MMApplicationContext.getContext().getSystemService("servicediscovery");
        AppMethodBeat.o(144457);
        return nsdManager;
    }

    public static class c {
        public String iBb;
        public String ip;
        public Map<String, String> njl = new HashMap();
        public int port;
        public String serviceName;

        @TargetApi(21)
        c(NsdServiceInfo nsdServiceInfo) {
            AppMethodBeat.i(144451);
            InetAddress host = nsdServiceInfo.getHost();
            if (host != null) {
                this.ip = host.getHostAddress();
            }
            this.port = nsdServiceInfo.getPort();
            this.serviceName = nsdServiceInfo.getServiceName();
            this.iBb = nsdServiceInfo.getServiceType();
            Map<String, byte[]> attributes = Build.VERSION.SDK_INT >= 21 ? nsdServiceInfo.getAttributes() : null;
            if (attributes != null) {
                for (String str : attributes.keySet()) {
                    byte[] bArr = attributes.get(str);
                    if (bArr != null) {
                        this.njl.put(str, new String(Base64.encode(bArr, 2)));
                    }
                }
            }
            AppMethodBeat.o(144451);
        }

        public c() {
            AppMethodBeat.i(144452);
            AppMethodBeat.o(144452);
        }
    }
}

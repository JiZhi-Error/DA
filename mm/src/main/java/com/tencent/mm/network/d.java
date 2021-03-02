package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class d {
    static a jDK;

    public interface a {
        g azD();
    }

    public static void a(a aVar) {
        AppMethodBeat.i(132657);
        Log.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", Boolean.FALSE, Util.getStack());
        jDK = aVar;
        AppMethodBeat.o(132657);
    }

    public static int b(boolean z, List<String> list, String str) {
        int i2 = -1;
        AppMethodBeat.i(132658);
        if (jDK == null) {
            AppMethodBeat.o(132658);
        } else {
            try {
                i2 = jDK.azD().a(str, z, list);
                AppMethodBeat.o(132658);
            } catch (Exception e2) {
                Log.e("MicroMsg.GprsSetting", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(132658);
            }
        }
        return i2;
    }

    public static int a(String str, boolean z, List<String> list) {
        AppMethodBeat.i(132659);
        if (jDK == null || jDK.azD() == null) {
            AppMethodBeat.o(132659);
            return -1;
        }
        int a2 = jDK.azD().a(str, z, list);
        AppMethodBeat.o(132659);
        return a2;
    }

    public static class b {
        public String host = null;
        public String ip = "";
        public int jDL = 0;
        private ArrayList<String> jDM = new ArrayList<>();
        public String jDN;
        public boolean jDO = false;
        private boolean jDP = false;
        public URL url = null;

        public b(String str) {
            AppMethodBeat.i(132654);
            this.jDN = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                if (d.jDK == null || d.jDK.azD() == null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = d.jDK == null ? "-1" : d.jDK.azD();
                    objArr[1] = Util.getStack();
                    Log.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", objArr);
                    AppMethodBeat.o(132654);
                    return;
                }
                this.jDL = d.jDK.azD().getHostByName(this.host, arrayList);
                Log.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", Integer.valueOf(this.jDL), this.host, str);
                if (arrayList.size() <= 0) {
                    this.jDL = 0;
                    AppMethodBeat.o(132654);
                } else if (1 != this.jDL) {
                    AppMethodBeat.o(132654);
                } else {
                    String str2 = (String) arrayList.remove(0);
                    this.ip = str2;
                    this.url = new URL(str.replaceFirst(this.host, RS(str2) ? "[" + str2 + "]" : str2));
                    AppMethodBeat.o(132654);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.GprsSetting", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(132654);
            }
        }

        public b(String str, boolean z) {
            AppMethodBeat.i(132655);
            this.jDO = z;
            this.jDN = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                if (d.jDK == null || d.jDK.azD() == null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = d.jDK == null ? "-1" : d.jDK.azD();
                    objArr[1] = Util.getStack();
                    Log.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", objArr);
                    AppMethodBeat.o(132655);
                    return;
                }
                this.jDL = d.jDK.azD().a(this.host, z, this.jDM);
                Log.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", Integer.valueOf(this.jDL), this.host, str, this.jDM);
                if (this.jDM.size() <= 0) {
                    this.jDL = 0;
                    AppMethodBeat.o(132655);
                } else if (1 != this.jDL) {
                    AppMethodBeat.o(132655);
                } else {
                    this.ip = this.jDM.remove(0);
                    if (RS(this.ip)) {
                        this.ip = "[" + this.ip + "]";
                    }
                    this.url = new URL(str.replaceFirst(this.host, this.ip));
                    AppMethodBeat.o(132655);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.GprsSetting", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(132655);
            }
        }

        private static boolean RS(String str) {
            AppMethodBeat.i(132656);
            try {
                if (!(InetAddress.getByName(str) instanceof Inet4Address)) {
                    AppMethodBeat.o(132656);
                    return true;
                }
                AppMethodBeat.o(132656);
                return false;
            } catch (Exception e2) {
                Log.e("MicroMsg.GprsSetting", "exception:%s", Util.stackTraceToString(e2));
                if (!str.contains(".")) {
                    AppMethodBeat.o(132656);
                    return true;
                }
                AppMethodBeat.o(132656);
                return false;
            }
        }
    }

    public static void reportFailIp(String str) {
        AppMethodBeat.i(132660);
        if (!(jDK == null || jDK.azD() == null)) {
            jDK.azD().reportFailIp(str);
        }
        AppMethodBeat.o(132660);
    }

    public static x RP(String str) {
        AppMethodBeat.i(259568);
        x a2 = a(str, null);
        AppMethodBeat.o(259568);
        return a2;
    }

    public static x a(String str, b bVar) {
        AppMethodBeat.i(132663);
        if (bVar == null) {
            bVar = new b(str);
        }
        Log.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", bVar.host, bVar.url, bVar.ip, Integer.valueOf(bVar.jDL));
        x xVar = new x(bVar.url, bVar.jDL);
        xVar.jEW = bVar.ip;
        if (1 == bVar.jDL) {
            xVar.setRequestProperty("Host", bVar.host);
            xVar.setRequestProperty("X-Online-Host", bVar.host);
        }
        AppMethodBeat.o(132663);
        return xVar;
    }

    public static z RQ(String str) {
        AppMethodBeat.i(132664);
        b bVar = new b(str);
        z zVar = new z(str, bVar.jDL);
        zVar.jFd = bVar.ip;
        if (1 == bVar.jDL) {
            zVar.setRequestProperty("Host", bVar.host);
            zVar.setRequestProperty("X-Online-Host", bVar.host);
        }
        AppMethodBeat.o(132664);
        return zVar;
    }

    public static int a(y yVar) {
        AppMethodBeat.i(132665);
        try {
            if (yVar.getResponseCode() != 200) {
                AppMethodBeat.o(132665);
                return -1;
            }
            AppMethodBeat.o(132665);
            return 0;
        } catch (Exception e2) {
            Log.e("MicroMsg.GprsSetting", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132665);
            return -3;
        }
    }

    public static aa RR(String str) {
        AppMethodBeat.i(132666);
        aa aaVar = new aa(str);
        AppMethodBeat.o(132666);
        return aaVar;
    }

    public static InputStream w(String str, int i2, int i3) {
        AppMethodBeat.i(132661);
        x a2 = a(str, null);
        a2.setConnectTimeout(i2);
        a2.setReadTimeout(i3);
        a2.setRequestMethod("GET");
        if (a(a2) != 0) {
            AppMethodBeat.o(132661);
            return null;
        }
        InputStream inputStream = a2.getInputStream();
        AppMethodBeat.o(132661);
        return inputStream;
    }
}

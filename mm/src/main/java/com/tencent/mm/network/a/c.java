package com.tencent.mm.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.InetUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.InetAddress;

public final class c {
    private InetAddress jGw;
    private int port;
    private int type;

    private c(InetAddress inetAddress, int i2, int i3) {
        this.jGw = inetAddress;
        this.port = i2;
        this.type = i3;
    }

    public final String toString() {
        AppMethodBeat.i(132965);
        String str = "hc";
        if (this.type == 2) {
            str = "dns";
        } else if (this.type == 3) {
            str = "svrdns";
        } else if (this.type == 4) {
            str = "waphc";
        } else if (this.type == 5) {
            str = "newdns";
        } else if (this.type == 6) {
            str = "auth";
        } else if (this.type == 7) {
            str = "debug";
        }
        String str2 = this.jGw.getHostAddress() + ":" + this.port + "(" + str + ")";
        AppMethodBeat.o(132965);
        return str2;
    }

    public static c RV(String str) {
        AppMethodBeat.i(132966);
        if (str == null) {
            AppMethodBeat.o(132966);
            return null;
        }
        String[] split = str.split(":");
        if (split == null || split.length != 3) {
            AppMethodBeat.o(132966);
            return null;
        }
        try {
            c cVar = new c(InetUtil.getByDottedAddress(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            AppMethodBeat.o(132966);
            return cVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.InAddress", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132966);
            return null;
        }
    }
}

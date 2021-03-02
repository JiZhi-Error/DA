package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.c;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a {
    public static InetAddress[] a() {
        InetAddress byName;
        String hostAddress;
        AppMethodBeat.i(15446);
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            ArrayList arrayList = new ArrayList(5);
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf("]: [");
                if (indexOf != -1) {
                    String substring = readLine.substring(1, indexOf);
                    String substring2 = readLine.substring(indexOf + 4, readLine.length() - 1);
                    if (!((!substring.endsWith(".dns") && !substring.endsWith(".dns1") && !substring.endsWith(".dns2") && !substring.endsWith(".dns3") && !substring.endsWith(".dns4")) || (byName = InetAddress.getByName(substring2)) == null || (hostAddress = byName.getHostAddress()) == null || hostAddress.length() == 0)) {
                        arrayList.add(byName);
                    }
                }
            }
            if (arrayList.size() > 0) {
                InetAddress[] inetAddressArr = (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
                AppMethodBeat.o(15446);
                return inetAddressArr;
            }
        } catch (IOException e2) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", (Throwable) e2);
        }
        AppMethodBeat.o(15446);
        return null;
    }

    public static InetAddress[] b() {
        InetAddress byName;
        String hostAddress;
        AppMethodBeat.i(15447);
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            ArrayList arrayList = new ArrayList(5);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i2 = 0; i2 < 4; i2++) {
                String str = (String) method.invoke(null, strArr[i2]);
                if (!(str == null || str.length() == 0 || (byName = InetAddress.getByName(str)) == null || (hostAddress = byName.getHostAddress()) == null || hostAddress.length() == 0 || arrayList.contains(byName))) {
                    arrayList.add(byName);
                }
            }
            if (arrayList.size() > 0) {
                InetAddress[] inetAddressArr = (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
                AppMethodBeat.o(15447);
                return inetAddressArr;
            }
        } catch (Exception e2) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", (Throwable) e2);
        }
        AppMethodBeat.o(15447);
        return null;
    }

    public static c c() {
        AppMethodBeat.i(15448);
        AnonymousClass1 r0 = new c() {
            /* class com.tencent.liteav.network.a.a.a.AnonymousClass1 */

            @Override // com.tencent.liteav.network.a.c
            public final e[] a(b bVar, d dVar) {
                AppMethodBeat.i(15449);
                InetAddress[] b2 = a.b();
                if (b2 == null) {
                    b2 = a.a();
                }
                if (b2 == null) {
                    IOException iOException = new IOException("cant get local dns server");
                    AppMethodBeat.o(15449);
                    throw iOException;
                }
                e[] a2 = new c(b2[0]).a(bVar, dVar);
                AppMethodBeat.o(15449);
                return a2;
            }
        };
        AppMethodBeat.o(15448);
        return r0;
    }
}

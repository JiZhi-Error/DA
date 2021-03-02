package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class g {
    private static final String TAG = g.class.getSimpleName();
    private static List<NetworkInterface> lkZ = new ArrayList();

    static {
        AppMethodBeat.i(158991);
        AppMethodBeat.o(158991);
    }

    public static List<NetworkInterface> bBz() {
        AppMethodBeat.i(158988);
        lkZ.clear();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                Iterator it = Collections.list(networkInterfaces).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((InetAddress) it2.next()).getHostAddress().startsWith("192.168")) {
                                lkZ.add(networkInterface);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        } catch (SocketException e2) {
        }
        List<NetworkInterface> list = lkZ;
        AppMethodBeat.o(158988);
        return list;
    }

    public static String bBA() {
        SocketException e2;
        AppMethodBeat.i(158989);
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String str2 = null;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (!inetAddresses.hasMoreElements()) {
                            break;
                        }
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!(nextElement instanceof Inet6Address)) {
                            String hostAddress = nextElement.getHostAddress();
                            if (!"127.0.0.1".equals(hostAddress)) {
                                str2 = hostAddress;
                                break;
                            }
                        }
                    }
                } catch (SocketException e3) {
                    e2 = e3;
                    str = str2;
                    new StringBuilder("can not get host ip : ").append(e2.getCause());
                    AppMethodBeat.o(158989);
                    return str;
                }
            }
            str = str2;
        } catch (SocketException e4) {
            e2 = e4;
            new StringBuilder("can not get host ip : ").append(e2.getCause());
            AppMethodBeat.o(158989);
            return str;
        }
        AppMethodBeat.o(158989);
        return str;
    }

    public static String u(String str, int i2, String str2) {
        AppMethodBeat.i(158990);
        if (str2.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            String str3 = HttpWrapperBase.PROTOCAL_HTTP + str + ":" + i2 + str2;
            AppMethodBeat.o(158990);
            return str3;
        }
        String str4 = HttpWrapperBase.PROTOCAL_HTTP + str + ":" + i2 + FilePathGenerator.ANDROID_DIR_SEP + str2;
        AppMethodBeat.o(158990);
        return str4;
    }
}

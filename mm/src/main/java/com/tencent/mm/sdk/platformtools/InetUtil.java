package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public final class InetUtil {
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    private InetUtil() {
    }

    static {
        AppMethodBeat.i(157562);
        AppMethodBeat.o(157562);
    }

    public static boolean isIPv4Address(String str) {
        AppMethodBeat.i(157559);
        boolean matches = IPV4_PATTERN.matcher(str).matches();
        AppMethodBeat.o(157559);
        return matches;
    }

    public static boolean isIPv6StdAddress(String str) {
        AppMethodBeat.i(230305);
        boolean matches = IPV6_STD_PATTERN.matcher(str).matches();
        AppMethodBeat.o(230305);
        return matches;
    }

    public static boolean isIPv6HexCompressedAddress(String str) {
        AppMethodBeat.i(230306);
        boolean matches = IPV6_HEX_COMPRESSED_PATTERN.matcher(str).matches();
        AppMethodBeat.o(230306);
        return matches;
    }

    public static boolean isIPv6Address(String str) {
        AppMethodBeat.i(157560);
        if (isIPv6StdAddress(str) || isIPv6HexCompressedAddress(str)) {
            AppMethodBeat.o(157560);
            return true;
        }
        AppMethodBeat.o(157560);
        return false;
    }

    public static InetAddress getByDottedAddress(String str) {
        AppMethodBeat.i(157561);
        if (isIPv4Address(str)) {
            InetAddress byName = InetAddress.getByName(str);
            AppMethodBeat.o(157561);
            return byName;
        } else if (isIPv6Address(str)) {
            InetAddress byName2 = InetAddress.getByName(str);
            AppMethodBeat.o(157561);
            return byName2;
        } else {
            UnknownHostException unknownHostException = new UnknownHostException("invalid ipv4 or ipv6 dotted string");
            AppMethodBeat.o(157561);
            throw unknownHostException;
        }
    }
}

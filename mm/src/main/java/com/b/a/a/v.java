package com.b.a.a;

import android.net.wifi.ScanResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.List;

/* access modifiers changed from: package-private */
public final class v {
    private static String cE(String str) {
        AppMethodBeat.i(87912);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("trying to manipulate null string");
            AppMethodBeat.o(87912);
            throw nullPointerException;
        }
        String str2 = "";
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != ':') {
                str2 = String.valueOf(str2) + str.charAt(i2);
            }
        }
        AppMethodBeat.o(87912);
        return str2;
    }

    static String a(List<ScanResult> list, boolean z) {
        AppMethodBeat.i(87913);
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (ScanResult scanResult : list) {
                if (scanResult.capabilities != null && !scanResult.capabilities.contains("IBSS")) {
                    try {
                        String bigInteger = new BigInteger(cE(scanResult.BSSID), 16).toString();
                        String valueOf = String.valueOf(scanResult.level);
                        sb.append(z ? "&WD[]=" : "|WD,");
                        sb.append(bigInteger);
                        sb.append(',');
                        sb.append(valueOf);
                        sb.append(',');
                        sb.append(valueOf);
                        sb.append(',');
                        sb.append(valueOf);
                        sb.append(',');
                        sb.append(1);
                        sb.append(',');
                        sb.append(1);
                        sb.append(',');
                        sb.append(0);
                        sb.append(',');
                        sb.append("");
                    } catch (NullPointerException e2) {
                    } catch (Error | NumberFormatException e3) {
                    }
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(87913);
        return sb2;
    }

    static boolean b(double d2, double d3) {
        AppMethodBeat.i(87914);
        if (Math.abs(d2) > 90.0d || Math.abs(d3) > 180.0d) {
            AppMethodBeat.o(87914);
            return false;
        }
        AppMethodBeat.o(87914);
        return true;
    }

    static String cF(String str) {
        AppMethodBeat.i(87915);
        if (str == null) {
            AppMethodBeat.o(87915);
            return null;
        }
        String replace = str.replace("&SD=", "|SD,");
        AppMethodBeat.o(87915);
        return replace;
    }

    static String cG(String str) {
        AppMethodBeat.i(87916);
        if (str == null) {
            AppMethodBeat.o(87916);
            return null;
        }
        String replace = str.replace("&GD=", "|GD,");
        AppMethodBeat.o(87916);
        return replace;
    }

    static String b(String str, long j2, String str2) {
        AppMethodBeat.i(87917);
        if (str == null || !str.startsWith("|")) {
            AppMethodBeat.o(87917);
            return null;
        }
        String str3 = "&OD[]=ST," + String.valueOf(j2) + ',' + str2 + str;
        AppMethodBeat.o(87917);
        return str3;
    }
}

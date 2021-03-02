package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.a.i;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;

public final class e {
    private static boolean U(String str, Map<String, String> map) {
        AppMethodBeat.i(151949);
        if (map.get(str) == null && map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            AppMethodBeat.o(151949);
            return true;
        }
        AppMethodBeat.o(151949);
        return false;
    }

    static void j(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(151950);
        if (U(String.format("%s.%s", str, str2), map)) {
            AppMethodBeat.o(151950);
            return;
        }
        boolean b2 = b(str, str2, map, true) | false;
        int i2 = 0;
        while (true) {
            i2++;
            if (U(String.format(Locale.US, "%s.%s%d", str, str2, Integer.valueOf(i2)), map)) {
                break;
            }
            b2 |= b(str, str2, map, true);
        }
        int bdZ = i.b.bdZ(str2);
        if (i.b.ahU(bdZ)) {
            j.F(0, 32);
            if (!b2) {
                j.F(0, 33);
                AppMethodBeat.o(151950);
                return;
            }
        } else if (i.b.ahV(bdZ)) {
            j.F(0, 35);
            if (!b2) {
                j.F(0, 36);
                AppMethodBeat.o(151950);
                return;
            }
        } else if (i.b.ahW(bdZ)) {
            j.F(0, 38);
            if (!b2) {
                j.F(0, 39);
            }
        }
        AppMethodBeat.o(151950);
    }

    private static boolean b(String str, String str2, Map<String, String> map, boolean z) {
        AppMethodBeat.i(223823);
        String format = String.format("%s.%s.%s", str, str2, "Resource");
        int bdZ = i.b.bdZ(str2);
        if (U(format, map)) {
            AppMethodBeat.o(223823);
            return true;
        }
        boolean a2 = a(bdZ, format, map, true) | false;
        int i2 = 0;
        while (true) {
            i2++;
            String format2 = String.format(Locale.US, "%s.%s.%s%d", str, str2, "Resource", Integer.valueOf(i2));
            if (!U(format2, map)) {
                a2 |= a(bdZ, format2, map, true);
            } else {
                AppMethodBeat.o(223823);
                return a2;
            }
        }
    }

    private static boolean a(int i2, String str, Map<String, String> map, boolean z) {
        AppMethodBeat.i(223824);
        if (map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            AppMethodBeat.o(223824);
            return true;
        } else if (i.b.ahW(i2)) {
            boolean W = W(str, map);
            AppMethodBeat.o(223824);
            return W;
        } else if (i.b.ahU(i2)) {
            boolean V = V(str, map);
            AppMethodBeat.o(223824);
            return V;
        } else if (i.b.ahV(i2)) {
            boolean b2 = b(str, map, z);
            AppMethodBeat.o(223824);
            return b2;
        } else {
            AppMethodBeat.o(223824);
            return false;
        }
    }

    private static boolean V(String str, Map<String, String> map) {
        int i2;
        AppMethodBeat.i(151953);
        Log.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
        String str2 = map.get(str + ".CDNUrl");
        int i3 = Util.getInt(map.get(str + ".subType"), -1);
        int i4 = Util.getInt(map.get(str + ".resType"), -1);
        String str3 = map.get(str + ".md5");
        int i5 = Util.getInt(map.get(str + ".priority"), 0);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3) || -1 == i3 || -1 == i4 || i5 < 0) {
            AppMethodBeat.o(151953);
            return false;
        }
        dov dov = new dov();
        dov.MSk = new doy();
        if (Util.getInt(map.get(str + ".fileEncrypt"), 0) > 0) {
            i2 = i.a.gnL();
        } else {
            i2 = 0;
        }
        if (Util.getInt(map.get(str + ".fileCompress"), 0) > 0) {
            i2 = i.a.ahS(i2);
        }
        dov.MJT = i3;
        dov.MSp = Util.getInt(map.get(str + ".networkType"), 2);
        dov.Lbj = Util.getInt(map.get(str + ".expireTime"), 1);
        dov.MSk.Url = str2;
        dov.MSk.MSu = Util.getInt(map.get(str + ".resVer"), 0);
        dov.MSk.MD5 = str3;
        dov.MSk.MSy = map.get(str + ".originalmd5");
        dov.MSk.MSv = i2;
        dov.MSk.MSw = null;
        dov.MSk.MSx = null;
        dov.MhZ = i5;
        dov.LWr = i.b.DoCache.cSx;
        dov.MSm = Util.getInt(map.get(str + ".reportID"), 0);
        dov.MSn = map.get(str + ".sampleID");
        dov.MSo = Util.getInt(map.get(str + ".retryTime"), 3);
        dov.MSq = Util.getInt(map.get(str + ".retryInterval"), 0);
        dov.JZb = 0;
        b.gnC().b(i4, dov, true);
        j.F((long) dov.MSm, 34);
        AppMethodBeat.o(151953);
        return true;
    }

    private static boolean b(String str, Map<String, String> map, boolean z) {
        boolean z2;
        AppMethodBeat.i(151954);
        Log.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
        int i2 = Util.getInt(map.get(str + ".resType"), -1);
        int i3 = Util.getInt(map.get(str + ".subType"), -1);
        if (-1 == i2 || -1 == i3) {
            AppMethodBeat.o(151954);
            return false;
        }
        dov dov = new dov();
        dov.MSl = new dox();
        dov.MJT = i3;
        dov.MSl.MSt = map.get(str + ".resKey");
        dov.MSl.MSs = Util.getInt(map.get(str + ".resKeyVersion"), 0);
        dov.MSn = map.get(str + ".sampleID");
        dov.MSm = Util.getInt(map.get(str + ".reportID"), 0);
        dov.LWr = i.b.DoDecrypt.cSx;
        dov.MSk = new doy();
        dov.MSk.MSy = map.get(str + ".originalmd5");
        b gnC = b.gnC();
        if (!z) {
            z2 = true;
        } else {
            z2 = false;
        }
        gnC.a(i2, dov, true, z2);
        j.F((long) dov.MSm, 37);
        AppMethodBeat.o(151954);
        return true;
    }

    private static boolean W(String str, Map<String, String> map) {
        AppMethodBeat.i(151955);
        Log.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
        int i2 = Util.getInt(map.get(str + ".resType"), -1);
        int i3 = Util.getInt(map.get(str + ".subType"), -1);
        if (-1 == i2 || -1 == i3) {
            AppMethodBeat.o(151955);
            return false;
        }
        dov dov = new dov();
        dov.MJT = i3;
        dov.MSk = new doy();
        dov.MSk.MSu = Util.getInt(map.get(str + ".resVer"), 0);
        dov.MSn = map.get(str + ".sampleID");
        dov.MSm = Util.getInt(map.get(str + ".reportID"), 0);
        dov.LWr = i.b.DoDelete.cSx;
        b.gnC().a(i2, dov, true);
        j.F((long) dov.MSm, 40);
        AppMethodBeat.o(151955);
        return true;
    }
}

package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vfs.s;

public final class bz {
    public String cityCode = "";
    public String countryCode = "";
    public int fuA = 0;
    public int fuI = 0;
    public String fuM = "";
    private String iFB = "";
    private String iFC = "";
    public String provinceCode = "";
    public String signature = "";

    public static bz aWj() {
        AppMethodBeat.i(42983);
        bz bzVar = new bz();
        bzVar.fuI = 1;
        bzVar.fuA = Util.nullAs((Integer) g.aAh().azQ().get(12290, (Object) null), 0);
        bzVar.iFB = (String) g.aAh().azQ().get(12293, (Object) null);
        bzVar.iFC = (String) g.aAh().azQ().get(12292, (Object) null);
        bzVar.signature = (String) g.aAh().azQ().get(12291, (Object) null);
        bzVar.fuM = (String) g.aAh().azQ().get(12307, (Object) null);
        bzVar.countryCode = (String) g.aAh().azQ().get(12324, (Object) null);
        bzVar.provinceCode = (String) g.aAh().azQ().get(12325, (Object) null);
        bzVar.cityCode = (String) g.aAh().azQ().get(12326, (Object) null);
        AppMethodBeat.o(42983);
        return bzVar;
    }

    public static bz aWk() {
        AppMethodBeat.i(42984);
        if (Util.nullAs((Integer) g.aAh().azQ().get(12289, (Object) null), 0) == 0) {
            AppMethodBeat.o(42984);
            return null;
        }
        bz aWj = aWj();
        AppMethodBeat.o(42984);
        return aWj;
    }

    public static cqm a(bz bzVar) {
        int length;
        AppMethodBeat.i(42985);
        g.aAh().azQ().set(12289, Integer.valueOf(bzVar.fuI));
        g.aAh().azQ().set(12290, Integer.valueOf(bzVar.fuA));
        if (a.aQ((String) g.aAh().azQ().get(12293, (Object) null), bzVar.getProvince())) {
            g.aAh().azQ().set(12293, bzVar.getProvince());
        }
        if (a.aQ((String) g.aAh().azQ().get(12292, (Object) null), bzVar.getCity())) {
            g.aAh().azQ().set(12292, bzVar.getCity());
        }
        if (a.aQ((String) g.aAh().azQ().get(12291, (Object) null), bzVar.signature)) {
            g.aAh().azQ().set(12291, bzVar.signature);
        }
        if (a.aQ((String) g.aAh().azQ().get(12307, (Object) null), bzVar.fuM)) {
            g.aAh().azQ().set(12307, bzVar.fuM);
        }
        if (a.aQ((String) g.aAh().azQ().get(12324, (Object) null), bzVar.countryCode)) {
            g.aAh().azQ().set(12324, bzVar.countryCode);
        }
        if (a.aQ((String) g.aAh().azQ().get(12325, (Object) null), bzVar.provinceCode)) {
            g.aAh().azQ().set(12325, bzVar.provinceCode);
        }
        if (a.aQ((String) g.aAh().azQ().get(12326, (Object) null), bzVar.cityCode)) {
            g.aAh().azQ().set(12326, bzVar.cityCode);
        }
        cqm cqm = new cqm();
        cqm.Mwf = 128;
        cqm.Lqk = new dqi().bhy("");
        cqm.Mjj = new dqi().bhy("");
        cqm.KDZ = 0;
        cqm.Mwg = new dqi().bhy("");
        cqm.Mwh = new dqi().bhy("");
        cqm.oTW = 0;
        byte[] aW = s.aW("", 0, -1);
        cqm.Mwd = new b(aW == null ? new byte[0] : aW);
        if (aW == null) {
            length = 0;
        } else {
            length = aW.length;
        }
        cqm.Mwc = length;
        cqm.kdY = bzVar.fuA;
        cqm.kec = bzVar.fuI;
        cqm.keb = Util.nullAsNil(bzVar.signature);
        cqm.kea = Util.nullAsNil(bzVar.cityCode);
        cqm.kdZ = Util.nullAsNil(bzVar.provinceCode);
        cqm.KEc = 0;
        cqm.MmM = Util.nullAsNil(bzVar.fuM);
        cqm.Mwm = 0;
        cqm.ked = "";
        cqm.MmO = 0;
        cqm.MmN = "";
        cqm.keh = Util.nullAsNil(bzVar.countryCode);
        AppMethodBeat.o(42985);
        return cqm;
    }

    static class a {
        public static boolean aQ(String str, String str2) {
            AppMethodBeat.i(42980);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(42980);
                return true;
            }
            String decode = decode(encode(str));
            if (Util.isNullOrNil(decode) || !decode.equals(str2)) {
                AppMethodBeat.o(42980);
                return true;
            }
            AppMethodBeat.o(42980);
            return false;
        }

        private static String encode(String str) {
            AppMethodBeat.i(42981);
            char[] charArray = str.toCharArray();
            String str2 = "";
            try {
                for (char c2 : charArray) {
                    str2 = str2 + String.format("%02x", Integer.valueOf(c2));
                }
                AppMethodBeat.o(42981);
                return str2;
            } catch (Exception e2) {
                AppMethodBeat.o(42981);
                return "";
            }
        }

        private static String decode(String str) {
            AppMethodBeat.i(42982);
            String str2 = "";
            if (Util.isNullOrNil(str) || str.length() % 2 != 0) {
                AppMethodBeat.o(42982);
                return "";
            }
            for (int i2 = 0; i2 < str.length(); i2 += 2) {
                try {
                    str2 = str2 + ((char) Integer.parseInt(str.substring(i2, i2 + 2), 16));
                } catch (Exception e2) {
                    AppMethodBeat.o(42982);
                    return "";
                }
            }
            AppMethodBeat.o(42982);
            return str2;
        }
    }

    public final String getCity() {
        AppMethodBeat.i(42986);
        if (!Util.isNullOrNil(this.countryCode)) {
            if (Util.isNullOrNil(this.provinceCode)) {
                this.iFC = "";
            } else if (Util.isNullOrNil(this.cityCode)) {
                RegionCodeDecoder.gEm();
                this.iFC = RegionCodeDecoder.mW(this.countryCode, this.provinceCode);
            } else {
                RegionCodeDecoder.gEm();
                this.iFC = RegionCodeDecoder.bs(this.countryCode, this.provinceCode, this.cityCode);
            }
        }
        if (Util.isNullOrNil(this.iFC)) {
            String nullAsNil = Util.nullAsNil(this.cityCode);
            AppMethodBeat.o(42986);
            return nullAsNil;
        }
        String str = this.iFC;
        AppMethodBeat.o(42986);
        return str;
    }

    public final String getProvince() {
        AppMethodBeat.i(42987);
        if (!Util.isNullOrNil(this.countryCode)) {
            if (Util.isNullOrNil(this.provinceCode) || Util.isNullOrNil(this.cityCode) || !RegionCodeDecoder.bkO(this.countryCode)) {
                RegionCodeDecoder.gEm();
                this.iFB = RegionCodeDecoder.bkP(this.countryCode);
            } else {
                RegionCodeDecoder.gEm();
                this.iFB = RegionCodeDecoder.mW(this.countryCode, this.provinceCode);
            }
        }
        if (Util.isNullOrNil(this.iFB)) {
            String nullAsNil = Util.nullAsNil(this.provinceCode);
            AppMethodBeat.o(42987);
            return nullAsNil;
        }
        String str = this.iFB;
        AppMethodBeat.o(42987);
        return str;
    }
}

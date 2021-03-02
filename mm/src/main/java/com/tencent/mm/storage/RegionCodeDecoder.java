package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class RegionCodeDecoder {
    private static RegionCodeDecoder Orw = null;
    public static final String Orx = (b.aKA() + "MicroMsg/regioncode/");
    public String Ory = "";
    private String Orz = "";

    static {
        AppMethodBeat.i(43296);
        AppMethodBeat.o(43296);
    }

    public static RegionCodeDecoder gEm() {
        AppMethodBeat.i(43277);
        if (Orw == null) {
            Orw = new RegionCodeDecoder();
        }
        RegionCodeDecoder regionCodeDecoder = Orw;
        if (!LocaleUtil.getApplicationLanguage().equals(regionCodeDecoder.Ory)) {
            regionCodeDecoder.gBs();
        }
        RegionCodeDecoder regionCodeDecoder2 = Orw;
        AppMethodBeat.o(43277);
        return regionCodeDecoder2;
    }

    public final void gBs() {
        AppMethodBeat.i(43278);
        o oVar = new o(Orx);
        if (!oVar.exists()) {
            oVar.mkdirs();
            ag(oVar);
        }
        String[] list = oVar.list();
        if (list == null || list.length == 0) {
            ag(oVar);
        }
        if (!s.YS(bkN(LocaleUtil.HONGKONG))) {
            Log.w("MicroMsg.RegionCodeDecoder", "forward compatbility for not HK language support");
            ah(oVar);
        }
        this.Ory = LocaleUtil.getApplicationLanguage();
        String gEn = gEn();
        if (Util.isNullOrNil(gEn)) {
            Log.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.Ory);
            AppMethodBeat.o(43278);
            return;
        }
        String str = Orx + gEn;
        String bkM = bkM(str);
        if (Util.isNullOrNil(bkM)) {
            Log.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.Ory);
            AppMethodBeat.o(43278);
        } else if (Util.isNullOrNil(this.Orz) || !this.Orz.equals(str) || !str.equals(bkM)) {
            Log.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new o(bkM).getName(), this.Ory);
            this.Orz = bkM;
            DecoderJni.buildFromFile(this.Orz);
            AppMethodBeat.o(43278);
        } else {
            AppMethodBeat.o(43278);
        }
    }

    private static String bkM(String str) {
        boolean equals;
        boolean z;
        boolean z2;
        AppMethodBeat.i(43279);
        o oVar = new o(str);
        String ae = ae(oVar);
        if (Util.isNullOrNil(ae)) {
            equals = false;
        } else {
            equals = ae.equals(af(oVar));
        }
        if (!equals) {
            if (s.nw("assets:///regioncode/" + oVar.getName(), str) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                o oVar2 = new o(oVar.heq(), "mmregioncode_en.txt");
                str = aa.z(oVar2.her());
                if (s.nw("assets:///regioncode/mmregioncode_en.txt", aa.z(oVar2.her())) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    AppMethodBeat.o(43279);
                    return null;
                }
            }
            o oVar3 = new o(str);
            e(oVar3, oVar3.heq());
            Log.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", oVar.getName(), oVar3.getName());
            AppMethodBeat.o(43279);
            return str;
        }
        AppMethodBeat.o(43279);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a A[SYNTHETIC, Splitter:B:16:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[SYNTHETIC, Splitter:B:22:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String ae(com.tencent.mm.vfs.o r9) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.RegionCodeDecoder.ae(com.tencent.mm.vfs.o):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0079 A[SYNTHETIC, Splitter:B:21:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089 A[SYNTHETIC, Splitter:B:29:0x0089] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(com.tencent.mm.vfs.o r8, com.tencent.mm.vfs.o r9) {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.RegionCodeDecoder.e(com.tencent.mm.vfs.o, com.tencent.mm.vfs.o):void");
    }

    private synchronized void ag(o oVar) {
        synchronized (this) {
            AppMethodBeat.i(43283);
            String[] strArr = null;
            if (oVar.exists()) {
                strArr = oVar.list();
            }
            if (!oVar.exists() || strArr == null || strArr.length == 0) {
                try {
                    String[] list = MMApplicationContext.getContext().getAssets().list("regioncode");
                    for (String str : list) {
                        Log.i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/".concat(String.valueOf(str)), aa.z(oVar.mUri) + FilePathGenerator.ANDROID_DIR_SEP + str);
                        String str2 = aa.z(oVar.mUri) + FilePathGenerator.ANDROID_DIR_SEP + str;
                        s.nw("assets:///regioncode/".concat(String.valueOf(str)), str2);
                        e(new o(str2), oVar);
                    }
                    AppMethodBeat.o(43283);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.RegionCodeDecoder", e2, "", new Object[0]);
                    AppMethodBeat.o(43283);
                }
            } else {
                AppMethodBeat.o(43283);
            }
        }
    }

    private synchronized void ah(o oVar) {
        synchronized (this) {
            AppMethodBeat.i(43284);
            String[] strArr = null;
            if (oVar.exists()) {
                strArr = oVar.list();
            }
            if (!oVar.exists() || strArr == null || strArr.length == 0) {
                try {
                    String[] list = MMApplicationContext.getContext().getAssets().list("regioncode");
                    for (String str : list) {
                        if (str.endsWith(LocaleUtil.HONGKONG) || str.endsWith(LocaleUtil.TAIWAN)) {
                            Log.i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/".concat(String.valueOf(str)), aa.z(oVar.mUri) + FilePathGenerator.ANDROID_DIR_SEP + str);
                            String str2 = aa.z(oVar.mUri) + FilePathGenerator.ANDROID_DIR_SEP + str;
                            s.nw("assets:///regioncode/".concat(String.valueOf(str)), str2);
                            e(new o(str2), oVar);
                        }
                    }
                    AppMethodBeat.o(43284);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.RegionCodeDecoder", e2, "", new Object[0]);
                    AppMethodBeat.o(43284);
                }
            } else {
                AppMethodBeat.o(43284);
            }
        }
    }

    public final String gEn() {
        AppMethodBeat.i(43285);
        String str = "mmregioncode_" + this.Ory + ".txt";
        String str2 = "mmregioncode_" + (this.Ory.equalsIgnoreCase(LocaleUtil.HONGKONG) ? LocaleUtil.TAIWAN : this.Ory) + ".txt";
        o oVar = new o(Orx);
        if (!oVar.exists()) {
            oVar.mkdirs();
            AppMethodBeat.o(43285);
            return null;
        } else if (new o(Orx + str).exists()) {
            AppMethodBeat.o(43285);
            return str;
        } else if (this.Ory.equalsIgnoreCase(LocaleUtil.HONGKONG) && new o(Orx + str2).exists()) {
            AppMethodBeat.o(43285);
            return str2;
        } else if (new o(Orx + "mmregioncode_en.txt").exists()) {
            AppMethodBeat.o(43285);
            return "mmregioncode_en.txt";
        } else {
            AppMethodBeat.o(43285);
            return null;
        }
    }

    @Deprecated
    public static String bkN(String str) {
        AppMethodBeat.i(43286);
        if (!Util.isNullOrNil(str)) {
            String str2 = Orx + "mmregioncode_" + str + ".txt";
            AppMethodBeat.o(43286);
            return str2;
        }
        AppMethodBeat.o(43286);
        return null;
    }

    public static final String bq(String str, String str2, String str3) {
        AppMethodBeat.i(43287);
        StringBuffer stringBuffer = new StringBuffer();
        if (!Util.isNullOrNil(str)) {
            stringBuffer.append(str);
            if (!Util.isNullOrNil(str2)) {
                stringBuffer.append('_');
                stringBuffer.append(str2);
                if (!Util.isNullOrNil(str3)) {
                    stringBuffer.append('_');
                    stringBuffer.append(str3);
                }
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43287);
        return stringBuffer2;
    }

    public static final boolean bkO(String str) {
        AppMethodBeat.i(43288);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43288);
            return false;
        }
        boolean equalsIgnoreCase = str.equalsIgnoreCase("cn");
        AppMethodBeat.o(43288);
        return equalsIgnoreCase;
    }

    public static String getLocName(String str) {
        AppMethodBeat.i(43289);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43289);
            return null;
        }
        String locName = DecoderJni.getLocName(str);
        AppMethodBeat.o(43289);
        return locName;
    }

    public static String getCountry(String str) {
        AppMethodBeat.i(259837);
        String locName = getLocName(str);
        AppMethodBeat.o(259837);
        return locName;
    }

    public static String mV(String str, String str2) {
        AppMethodBeat.i(163520);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(163520);
            return null;
        }
        String locName = getLocName(bq(str, str2, null));
        AppMethodBeat.o(163520);
        return locName;
    }

    public static String br(String str, String str2, String str3) {
        AppMethodBeat.i(163521);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
            AppMethodBeat.o(163521);
            return null;
        }
        String locName = getLocName(bq(str, str2, str3));
        AppMethodBeat.o(163521);
        return locName;
    }

    public static String mW(String str, String str2) {
        AppMethodBeat.i(43291);
        String mV = mV(str, str2);
        if (Util.isNullOrNil(mV)) {
            String nullAsNil = Util.nullAsNil(str2);
            AppMethodBeat.o(43291);
            return nullAsNil;
        }
        AppMethodBeat.o(43291);
        return mV;
    }

    public static String bs(String str, String str2, String str3) {
        AppMethodBeat.i(43292);
        String br = br(str, str2, str3);
        if (Util.isNullOrNil(br)) {
            String nullAsNil = Util.nullAsNil(str3);
            AppMethodBeat.o(43292);
            return nullAsNil;
        }
        AppMethodBeat.o(43292);
        return br;
    }

    public final Region[] gEo() {
        AppMethodBeat.i(43293);
        if (Util.isNullOrNil(this.Orz)) {
            AppMethodBeat.o(43293);
            return null;
        }
        Region[] countries = DecoderJni.getCountries(this.Orz);
        AppMethodBeat.o(43293);
        return countries;
    }

    public final Region[] bkQ(String str) {
        AppMethodBeat.i(43294);
        if (Util.isNullOrNil(this.Orz) || Util.isNullOrNil(str)) {
            AppMethodBeat.o(43294);
            return null;
        }
        Region[] provinces = DecoderJni.getProvinces(this.Orz, str);
        AppMethodBeat.o(43294);
        return provinces;
    }

    public final Region[] mX(String str, String str2) {
        AppMethodBeat.i(43295);
        if (Util.isNullOrNil(this.Orz) || Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(43295);
            return null;
        }
        Region[] cities = DecoderJni.getCities(this.Orz, str, str2);
        AppMethodBeat.o(43295);
        return cities;
    }

    public static class Region {
        private String code;
        private String countryCode;
        private boolean hasChildren = false;
        private boolean isCity = false;
        private boolean isCountry = false;
        private boolean isProvince = false;
        private String name;
        private Region parent = null;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public boolean hasChildren() {
            return this.hasChildren;
        }

        public void setHasChildren(boolean z) {
            this.hasChildren = z;
        }

        public void setParent(Region region) {
            this.parent = region;
        }

        public Region getParent() {
            return this.parent;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public boolean isCountry() {
            return this.isCountry;
        }

        public void setCountry(boolean z) {
            this.isCountry = z;
        }

        public boolean isProvince() {
            return this.isProvince;
        }

        public void setProvince(boolean z) {
            this.isProvince = z;
        }

        public boolean isCity() {
            return this.isCity;
        }

        public void setCity(boolean z) {
            this.isCity = z;
        }
    }

    /* access modifiers changed from: package-private */
    public static class DecoderJni {
        public static native void buildFromFile(String str);

        public static native Region[] getCities(String str, String str2, String str3);

        public static native Region[] getCountries(String str);

        public static native String getLocName(String str);

        public static native Region[] getProvinces(String str, String str2);

        public static native void release();

        private DecoderJni() {
        }
    }

    private static String af(o oVar) {
        AppMethodBeat.i(43282);
        String bhK = s.bhK(aa.z(oVar.mUri));
        if (Util.isNullOrNil(bhK)) {
            Log.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", oVar.getName());
            AppMethodBeat.o(43282);
            return null;
        }
        String mD5String = MD5Util.getMD5String(bhK + "#" + oVar.lastModified() + "#" + q.dr(true));
        AppMethodBeat.o(43282);
        return mD5String;
    }

    public static String bkP(String str) {
        AppMethodBeat.i(43290);
        String locName = getLocName(str);
        if (Util.isNullOrNil(locName)) {
            String nullAsNil = Util.nullAsNil(str);
            AppMethodBeat.o(43290);
            return nullAsNil;
        }
        AppMethodBeat.o(43290);
        return locName;
    }
}

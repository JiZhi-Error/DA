package com.tencent.mm.plugin.performance.diagnostic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a extends a.AbstractC1572a {
    private final String ATE;
    private final String ATF;
    private final String ATG;
    private final String ATH;
    private final String ATI;
    private final String ATJ;
    private final String ATK;
    private final String ATL;
    private final String ATM;

    public a(com.tencent.mm.plugin.performance.diagnostic.a<? extends com.tencent.wxperf.jni.a, ? extends a.AbstractC1572a> aVar) {
        super(aVar);
        AppMethodBeat.i(201047);
        this.ATE = aVar.eBC() + ".$hook";
        this.ATF = aVar.eBC() + ".$ignore";
        this.ATG = aVar.eBC() + ".$stack";
        this.ATH = aVar.eBC() + ".$min";
        this.ATI = aVar.eBC() + ".$max";
        this.ATJ = aVar.eBC() + ".$sampling";
        this.ATK = aVar.eBC() + ".$extreme";
        this.ATL = aVar.eBC() + ".$mmap";
        this.ATM = aVar.eBC() + ".$stacklog";
        AppMethodBeat.o(201047);
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a.AbstractC1572a
    public final void aB(Map<String, String> map) {
        String str;
        int i2;
        AppMethodBeat.i(201048);
        super.aB(map);
        String str2 = map.get(this.ATE);
        if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.MemoryHookConfigStg", "ERROR(MemoryHook): hook regex is blank");
            AppMethodBeat.o(201048);
            return;
        }
        String str3 = map.get(this.ATF);
        boolean equals = "1".equals(map.get(this.ATG));
        int i3 = Util.getInt(map.get(this.ATH), 0);
        int i4 = Util.getInt(map.get(this.ATI), 0);
        double d2 = Util.getDouble(map.get(this.ATJ), 1.0d);
        boolean equals2 = "1".equals(map.get(this.ATK));
        boolean equals3 = "1".equals(map.get(this.ATL));
        int i5 = Util.getInt(map.get(this.ATM), 52428800);
        if (equals2) {
            str = str3;
        } else if (str3 == null) {
            str = ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
        } else {
            if (!TextUtils.isEmpty(str3) && !str3.endsWith(";")) {
                str3 = str3 + ";";
            }
            str = str3 + ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
        }
        if (i5 > 524288000) {
            i2 = 524288000;
        } else {
            i2 = i5;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        this.djK.encode(this.ATE, str2);
        this.djK.encode(this.ATF, str);
        this.djK.encode(this.ATG, equals);
        this.djK.encode(this.ATH, i3);
        this.djK.encode(this.ATI, i4);
        this.djK.encode(this.ATJ, d2);
        this.djK.encode(this.ATK, equals2);
        this.djK.encode(this.ATL, equals3);
        this.djK.encode(this.ATM, i2);
        AppMethodBeat.o(201048);
    }

    public final String eBZ() {
        AppMethodBeat.i(201049);
        String aJV = aJV("");
        AppMethodBeat.o(201049);
        return aJV;
    }

    public final String aJV(String str) {
        AppMethodBeat.i(201050);
        String decodeString = this.djK.decodeString(this.ATE, str);
        AppMethodBeat.o(201050);
        return decodeString;
    }

    public final String eCa() {
        AppMethodBeat.i(201051);
        String decodeString = this.djK.decodeString(this.ATF, "");
        AppMethodBeat.o(201051);
        return decodeString;
    }

    public final boolean eCb() {
        AppMethodBeat.i(201052);
        boolean decodeBool = this.djK.decodeBool(this.ATG, false);
        AppMethodBeat.o(201052);
        return decodeBool;
    }

    public final int eCc() {
        AppMethodBeat.i(201053);
        int decodeInt = this.djK.decodeInt(this.ATH, 0);
        AppMethodBeat.o(201053);
        return decodeInt;
    }

    public final int eCd() {
        AppMethodBeat.i(201054);
        int decodeInt = this.djK.decodeInt(this.ATI, 0);
        AppMethodBeat.o(201054);
        return decodeInt;
    }

    public final double eCe() {
        AppMethodBeat.i(201055);
        double decodeDouble = this.djK.decodeDouble(this.ATJ, 1.0d);
        AppMethodBeat.o(201055);
        return decodeDouble;
    }

    public final boolean eCf() {
        AppMethodBeat.i(201056);
        boolean decodeBool = this.djK.decodeBool(this.ATK, false);
        AppMethodBeat.o(201056);
        return decodeBool;
    }

    public final boolean eCg() {
        AppMethodBeat.i(201057);
        boolean decodeBool = this.djK.decodeBool(this.ATL, false);
        AppMethodBeat.o(201057);
        return decodeBool;
    }

    public final int eCh() {
        AppMethodBeat.i(201058);
        int decodeInt = this.djK.decodeInt(this.ATM, 52428800);
        AppMethodBeat.o(201058);
        return decodeInt;
    }
}

package com.tencent.i.a.a.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.h.c.e;
import com.tencent.h.c.h;
import com.tencent.h.c.i;
import com.tencent.i.a.b;
import com.tencent.i.a.c.b.c;
import com.tencent.i.a.c.b.d;
import com.tencent.i.a.c.b.f;
import com.tencent.i.a.c.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static ArrayList<d> z(HashMap<String, String> hashMap) {
        AppMethodBeat.i(214689);
        ArrayList<d> arrayList = new ArrayList<>();
        if (hashMap == null || hashMap.isEmpty()) {
            AppMethodBeat.o(214689);
            return arrayList;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            d dVar = new d();
            dVar.Ssh = entry.getKey();
            dVar.Ssi = entry.getValue();
            h.i("sensor_ConvtUtil", "[method: toDetectFeatures ] [ " + dVar.Ssh + ", " + dVar.Ssi + " ]");
            arrayList.add(dVar);
        }
        AppMethodBeat.o(214689);
        return arrayList;
    }

    public static long a(com.tencent.i.a.c.b.a aVar) {
        AppMethodBeat.i(214690);
        if (!b(aVar) || !c(aVar)) {
            AppMethodBeat.o(214690);
            return 0;
        }
        ArrayList<g> arrayList = aVar.SrN.get(0).kgc.get(0).Ssd;
        g gVar = arrayList.get(0);
        g gVar2 = arrayList.get(arrayList.size() - 1);
        if (gVar == null || gVar2 == null) {
            AppMethodBeat.o(214690);
            return 0;
        }
        long abs = Math.abs(gVar2.RNA - gVar.RNA);
        h.i("sensor_ConvtUtil", "[method: getReqDuration ] calculate by sensor : ".concat(String.valueOf(abs)));
        AppMethodBeat.o(214690);
        return abs;
    }

    public static void a(f fVar, f fVar2) {
        AppMethodBeat.i(214691);
        if (fVar == null || fVar2 == null) {
            AppMethodBeat.o(214691);
        } else if (fVar.kgc == null || fVar.kgc.isEmpty() || fVar.kgc.get(0).Ssd == null) {
            AppMethodBeat.o(214691);
        } else if (fVar2.kgc == null || fVar2.kgc.isEmpty() || fVar2.kgc.get(0).Ssd == null) {
            AppMethodBeat.o(214691);
        } else {
            fVar.kgc.get(0).Ssd.addAll(fVar2.kgc.get(0).Ssd);
            AppMethodBeat.o(214691);
        }
    }

    public static void b(f fVar, f fVar2) {
        AppMethodBeat.i(214692);
        if (fVar == null || fVar2 == null) {
            AppMethodBeat.o(214692);
            return;
        }
        if (fVar.Ssn == null) {
            fVar.Ssn = new ArrayList<>();
        }
        if (fVar2.Ssn != null) {
            fVar.Ssn.addAll(fVar2.Ssn);
        }
        AppMethodBeat.o(214692);
    }

    public static boolean b(com.tencent.i.a.c.b.a aVar) {
        AppMethodBeat.i(214693);
        if (aVar == null || aVar.SrN == null || aVar.SrN.isEmpty()) {
            AppMethodBeat.o(214693);
            return false;
        }
        f fVar = aVar.SrN.get(0);
        if (fVar == null || fVar.kgc == null || fVar.kgc.isEmpty()) {
            AppMethodBeat.o(214693);
            return false;
        }
        c cVar = fVar.kgc.get(0);
        if (cVar == null || cVar.Ssd == null || cVar.Ssd.isEmpty()) {
            AppMethodBeat.o(214693);
            return false;
        }
        AppMethodBeat.o(214693);
        return true;
    }

    public static boolean c(com.tencent.i.a.c.b.a aVar) {
        AppMethodBeat.i(214694);
        if (aVar == null || aVar.SrN == null || aVar.SrN.isEmpty()) {
            AppMethodBeat.o(214694);
            return false;
        }
        f fVar = aVar.SrN.get(0);
        if (fVar == null || fVar.Ssn == null || fVar.Ssn.isEmpty()) {
            AppMethodBeat.o(214694);
            return false;
        } else if (fVar.Ssn == null || fVar.Ssn.isEmpty()) {
            AppMethodBeat.o(214694);
            return false;
        } else {
            AppMethodBeat.o(214694);
            return true;
        }
    }

    public static void a(com.tencent.i.a.a.c cVar, com.tencent.i.a.c.b.a aVar, b bVar) {
        int i2;
        AppMethodBeat.i(214695);
        if (cVar == null || aVar == null || bVar == null) {
            AppMethodBeat.o(214695);
            return;
        }
        aVar.channelId = 301096;
        aVar.SrO = 2;
        if (b.DATA_USAGE_TYPE_IDENTIFY == bVar) {
            i2 = 0;
        } else {
            i2 = b.DATA_USAGE_TYPE_IDENTIFY_TRAIN == bVar ? 3 : 2;
        }
        aVar.dataType = i2;
        aVar.SrP = cVar.SqO.SqY;
        aVar.vid = com.tencent.h.c.c.bpY(com.tencent.h.c.c.DO(true)) + "_" + com.tencent.h.c.c.bpY(com.tencent.h.c.c.DO(false)) + "_" + com.tencent.h.c.c.bpY(com.tencent.h.c.c.kZ(cVar.mAppContext));
        aVar.platform = 2;
        aVar.brand = Build.BRAND;
        aVar.model = Build.MODEL;
        aVar.IFo = com.tencent.h.c.c.getAppVersionCode(cVar.mAppContext);
        aVar.RLg = "24C8B65CA976DDE3";
        aVar.RNo = com.tencent.h.c.c.getAppPackageName(cVar.mAppContext);
        aVar.imsi = com.tencent.h.c.c.kY(cVar.mAppContext);
        aVar.RNp = Build.FINGERPRINT;
        aVar.sdkVer = Build.VERSION.SDK_INT;
        aVar.SrR = 2;
        aVar.imei = com.tencent.h.c.c.getIMEI(cVar.mAppContext);
        AppMethodBeat.o(214695);
    }

    public static Map<String, String> lu(Context context) {
        AppMethodBeat.i(214696);
        HashMap hashMap = new HashMap();
        try {
            Map<String, String> a2 = i.a(new i.a() {
                /* class com.tencent.i.a.a.b.a.AnonymousClass1 */

                @Override // com.tencent.h.c.i.a
                public final byte[] q(byte[] bArr, byte[] bArr2) {
                    AppMethodBeat.i(214686);
                    byte[] o = com.tencent.h.c.b.o(bArr, bArr2);
                    AppMethodBeat.o(214686);
                    return o;
                }

                @Override // com.tencent.h.c.i.a
                public final byte[] cV(byte[] bArr) {
                    AppMethodBeat.i(214687);
                    byte[] cV = com.tencent.h.c.a.cV(bArr);
                    AppMethodBeat.o(214687);
                    return cV;
                }

                @Override // com.tencent.h.c.i.a
                public final byte[] readFile(String str) {
                    AppMethodBeat.i(214688);
                    byte[] aa = e.aa(new File(str));
                    AppMethodBeat.o(214688);
                    return aa;
                }
            });
            if (a2 != null) {
                String str = a2.get("1");
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("turingU", str);
                }
                String str2 = a2.get("2");
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("turingO", str2);
                }
            }
            String hpT = com.tencent.h.c.c.hpT();
            if (!TextUtils.isEmpty(hpT)) {
                hashMap.put("turingSID", hpT);
            }
            String hkQ = com.tencent.h.c.c.hkQ();
            if (!TextUtils.isEmpty(hkQ)) {
                hashMap.put("turingKV", hkQ);
            }
            hashMap.put("turingDPL", String.valueOf(com.tencent.h.c.c.getScreenWidth(context)) + "*" + String.valueOf(com.tencent.h.c.c.getScreenHeight(context)));
            AppMethodBeat.o(214696);
            return hashMap;
        } catch (Throwable th) {
            AppMethodBeat.o(214696);
            return hashMap;
        }
    }
}

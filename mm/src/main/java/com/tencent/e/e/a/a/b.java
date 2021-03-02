package com.tencent.e.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.SparseArray;
import com.tencent.e.e.a.b.a;
import com.tencent.e.e.a.b.e;
import com.tencent.e.e.a.b.g;
import com.tencent.e.f.d;
import com.tencent.e.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static final int[] RMP = {1, 5, 4, 8, 9, 2};
    private static int RMQ = -1;

    public static a a(int i2, int i3, Context context, int i4, SparseArray<i> sparseArray, List<k> list) {
        AppMethodBeat.i(138393);
        a aVar = new a();
        aVar.RNm = 0;
        aVar.dUb = "";
        aVar.IFo = i.cU(context, context.getPackageName()).versionCode;
        aVar.RLg = "14D6ACDE3C2F2F48";
        aVar.channel = 500000;
        aVar.requestType = i4;
        aVar.RNo = bpY(context.getPackageName());
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            arrayList.addAll(sparseArray.valueAt(i5).kd(list));
        }
        if (arrayList.size() <= 0 || arrayList.get(0) == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid stateUnits");
            AppMethodBeat.o(138393);
            throw illegalArgumentException;
        }
        e eVar = new e();
        eVar.RNw = arrayList.get(0).RNB;
        eVar.RNx = arrayList;
        eVar.RMA = i2;
        eVar.action = i3;
        ArrayList<e> arrayList2 = new ArrayList<>();
        arrayList2.add(eVar);
        aVar.RNn = arrayList2;
        aVar.imei = bpY(d.getIMEI(context));
        aVar.imsi = bpY(d.kY(context));
        aVar.brand = bpY(Build.BRAND);
        aVar.model = bpY(Build.MODEL);
        aVar.RNp = bpY(Build.FINGERPRINT);
        aVar.RNq = hkF();
        aVar.sdkVer = Build.VERSION.SDK_INT;
        aVar.platform = 2;
        AppMethodBeat.o(138393);
        return aVar;
    }

    private static String bpY(String str) {
        return str == null ? "" : str;
    }

    private static int hkF() {
        AppMethodBeat.i(138394);
        if (RMQ == -1) {
            SensorManager sensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
            if (sensorManager == null) {
                int i2 = RMQ;
                AppMethodBeat.o(138394);
                return i2;
            }
            int i3 = 1;
            for (int i4 = 0; i4 < RMP.length; i4++) {
                i3 |= (sensorManager.getDefaultSensor(RMP[i4]) == null ? 0 : 1) << i4;
            }
            RMQ = i3;
        }
        int i5 = RMQ;
        AppMethodBeat.o(138394);
        return i5;
    }
}

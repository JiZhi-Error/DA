package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

public final class d {
    private final HashMap<c, Vector<Integer>> mMap = new HashMap<>();
    private b pfO = null;

    public d(b bVar) {
        AppMethodBeat.i(22439);
        this.pfO = bVar;
        AppMethodBeat.o(22439);
    }

    public final void a(int i2, String str, e eVar) {
        AppMethodBeat.i(22440);
        Log.i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", null, Integer.valueOf(i2));
        if (eVar == null) {
            Log.e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
            AppMethodBeat.o(22440);
            return;
        }
        c cVar = new c();
        cVar.pfL = null;
        cVar.pfM = eVar;
        cVar.dfJ = str;
        if (!this.mMap.containsKey(cVar)) {
            Vector<Integer> vector = new Vector<>();
            vector.add(Integer.valueOf(i2));
            this.mMap.put(cVar, vector);
            AppMethodBeat.o(22440);
            return;
        }
        Vector<Integer> vector2 = this.mMap.get(cVar);
        vector2.add(Integer.valueOf(i2));
        if (1 <= vector2.size()) {
            try {
                a(vector2, cVar);
            } catch (Exception e2) {
                Log.e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", e2.getMessage());
            } finally {
                vector2.clear();
                AppMethodBeat.o(22440);
            }
        } else {
            AppMethodBeat.o(22440);
        }
    }

    private void a(Vector<Integer> vector, c cVar) {
        int[] iArr;
        double pow;
        AppMethodBeat.i(22441);
        Log.i("MicroMsg.exdevie.IBeaconManager", "calDistance");
        int[] iArr2 = new int[vector.size()];
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            iArr2[i2] = vector.elementAt(i2).intValue();
        }
        a aVar = new a(iArr2);
        if (1 == aVar.pfK.length) {
            Log.d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
            iArr = aVar.pfK;
        } else {
            StringBuilder sb = new StringBuilder("");
            sb.append("Data Before GaussianFilter \r\n");
            for (int i3 = 0; i3 < aVar.pfK.length; i3++) {
                sb.append(" " + aVar.pfK[i3]);
            }
            Log.d("MicroMsg.exdevice.GaussianFilter", sb.toString());
            double x = i.x(aVar.pfK);
            double y = i.y(aVar.pfK);
            double doubleValue = i.i(0.15d, y).add(new BigDecimal(x)).doubleValue();
            double doubleValue2 = i.i(3.09d, y).add(new BigDecimal(x)).doubleValue();
            Log.d("MicroMsg.exdevice.GaussianFilter", "Mean = " + x + "SD = " + y + "LowerLimit = " + doubleValue + " UpperLimit = " + doubleValue2);
            int i4 = 0;
            int[] iArr3 = new int[aVar.pfK.length];
            for (int i5 = 0; i5 < aVar.pfK.length; i5++) {
                if (((double) aVar.pfK[i5]) >= doubleValue && ((double) aVar.pfK[i5]) <= doubleValue2) {
                    iArr3[i4] = aVar.pfK[i5];
                    i4++;
                }
            }
            Assert.assertTrue(i4 != 0);
            int[] iArr4 = new int[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                iArr4[i6] = iArr3[i6];
            }
            StringBuilder sb2 = new StringBuilder("");
            sb2.append("Data After GaussianFilter \r\n");
            for (int i7 = 0; i7 < iArr4.length; i7++) {
                sb2.append(" " + iArr4[i7]);
            }
            Log.d("MicroMsg.exdevice.GaussianFilter", sb2.toString());
            iArr = iArr4;
        }
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == ret || 0 == ret.length");
            AppMethodBeat.o(22441);
            throw nullPointerException;
        }
        double x2 = i.x(iArr);
        cVar.pfN = new BigDecimal(x2).divide(new BigDecimal(1), 3, 4).doubleValue();
        double d2 = (double) cVar.pfM.pfQ.pgu;
        double d3 = (1.0d * x2) / d2;
        if (d3 < 1.0d) {
            pow = Math.pow(d3, 10.0d);
        } else {
            pow = (Math.pow(d3, 9.9476d) * 0.92093d) + 0.54992d;
        }
        Log.i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", Double.valueOf(d2), Double.valueOf(x2), Double.valueOf(pow));
        this.pfO.a(pow, cVar);
        AppMethodBeat.o(22441);
    }
}

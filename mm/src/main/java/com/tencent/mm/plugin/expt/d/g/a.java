package com.tencent.mm.plugin.expt.d.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static void p(List<b> list, int i2) {
        String str;
        AppMethodBeat.i(220352);
        if (list == null || list.size() <= 0 || i2 <= 0) {
            AppMethodBeat.o(220352);
            return;
        }
        Log.i("EdgeComputingReporter", "[EdgeComputingReporter] reportData logID : ".concat(String.valueOf(i2)));
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (b bVar : list) {
            if (bVar == null) {
                AppMethodBeat.o(220352);
                return;
            }
            while (bVar.index > i3) {
                arrayList.add("");
                i3++;
            }
            if (bVar.index >= i3) {
                if (bVar.type == 2) {
                    str = String.valueOf(bVar.syi);
                } else if (bVar.type == 1) {
                    str = String.valueOf(bVar.intValue);
                } else if (bVar.type == 0) {
                    str = bVar.stringValue == null ? "" : bVar.stringValue;
                } else {
                    str = "";
                }
                if (str.contains(",")) {
                    str = str.replace(",", "\\$");
                }
                arrayList.add(str);
                i3++;
            }
        }
        if (arrayList.size() > 0) {
            h hVar = h.INSTANCE;
            h.r(i2, arrayList);
            Log.d("EdgeComputingReporter", "[EdgeComputingReporter] reportData vals : " + arrayList.size());
        }
        AppMethodBeat.o(220352);
    }

    public static void q(List<String> list, int i2) {
        AppMethodBeat.i(220353);
        if (list == null || list.size() <= 0 || i2 <= 0) {
            AppMethodBeat.o(220353);
            return;
        }
        Log.i("EdgeComputingReporter", "[EdgeComputingReporter] reportStrData logID : ".concat(String.valueOf(i2)));
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.contains(",")) {
                str = str.replace(",", "\\$");
            }
            arrayList.add(str);
        }
        h hVar = h.INSTANCE;
        h.r(i2, arrayList);
        Log.d("EdgeComputingReporter", "[EdgeComputingReporter] reportStrData vals : " + arrayList.size());
        AppMethodBeat.o(220353);
    }
}

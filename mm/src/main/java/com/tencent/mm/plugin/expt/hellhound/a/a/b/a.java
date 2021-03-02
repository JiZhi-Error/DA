package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class a {
    private static int sCq = 0;

    public static void a(ebf ebf, c<String, Integer> cVar) {
        AppMethodBeat.i(169318);
        if (ebf == null || cVar == null) {
            AppMethodBeat.o(169318);
            return;
        }
        ca caVar = new ca();
        caVar.euv = Process.myPid();
        ca kL = caVar.kI(g.aAe().azG().mProcessName).kJ(ebf.dRM).kK(ebf.dPM).kL(ebf.NaW);
        kL.eux = ebf.NaS;
        kL.euy = ebf.NaT;
        kL.euz = ebf.NaU;
        kL.euA = (String) cVar.get(0);
        kL.euB = ((Integer) cVar.get(1)).intValue();
        int i2 = sCq;
        sCq = i2 + 1;
        kL.euC = i2;
        List<ca> a2 = a(caVar);
        if (a2 == null) {
            AppMethodBeat.o(169318);
            return;
        }
        for (ca caVar2 : a2) {
            caVar2.euA = caVar2.euA.replace(",", "#");
            caVar2.bfK();
            Log.i("HABBYGE-MALI.FinderReport", "FinderReport-report-sub: %s", caVar2.abV());
        }
        AppMethodBeat.o(169318);
    }

    private static List<ca> a(ca caVar) {
        JSONArray jSONArray;
        AppMethodBeat.i(169319);
        ArrayList arrayList = new ArrayList();
        byte[] bytes = caVar.abV().getBytes();
        if (bytes.length <= 5120) {
            caVar.euD = 0;
            caVar.euE = 1;
            arrayList.add(caVar);
            AppMethodBeat.o(169319);
            return arrayList;
        }
        try {
            jSONArray = new JSONArray(caVar.euA);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FinderReport", e2, "finder, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
            jSONArray = null;
        }
        if (jSONArray == null) {
            AppMethodBeat.o(169319);
            return null;
        }
        int length = jSONArray.length();
        double ceil = Math.ceil(((double) bytes.length) / 5120.0d);
        int i2 = length / ((int) ceil);
        int i3 = length % ((int) ceil);
        int i4 = (int) ceil;
        if (i3 > 0) {
            i4++;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (((double) i7) < ceil) {
            ca caVar2 = new ca();
            caVar2.euv = caVar.euv;
            caVar2.kI(caVar.euw);
            caVar2.kJ(caVar.ekG);
            caVar2.kK(caVar.euG);
            caVar2.kL(caVar.euH);
            caVar2.eux = caVar.eux;
            caVar2.euy = caVar.euy;
            caVar2.euz = caVar.euz;
            caVar2.euC = caVar.euC;
            JSONArray jSONArray2 = new JSONArray();
            i6 = i7 * i2;
            while (i6 < (i7 + 1) * i2 && i6 < length - i3) {
                jSONArray2.put(jSONArray.opt(i6));
                i6++;
            }
            caVar2.euA = jSONArray2.toString();
            caVar2.euB = jSONArray2.length();
            caVar2.euD = i5;
            caVar2.euE = i4;
            arrayList.add(caVar2);
            i7++;
            i5++;
        }
        if (i3 > 0) {
            ca caVar3 = new ca();
            caVar3.euv = caVar.euv;
            caVar3.kI(caVar.euw);
            caVar3.kJ(caVar.ekG);
            caVar3.kK(caVar.euG);
            caVar3.kL(caVar.euH);
            caVar3.eux = caVar.eux;
            caVar3.euy = caVar.euy;
            caVar3.euz = caVar.euz;
            caVar3.euC = caVar.euC;
            JSONArray jSONArray3 = new JSONArray();
            while (i6 < length) {
                jSONArray3.put(jSONArray.opt(i6));
                i6++;
            }
            caVar3.euA = jSONArray3.toString();
            caVar3.euB = jSONArray3.length();
            caVar3.euD = i5;
            caVar3.euE = i4;
            arrayList.add(caVar3);
        }
        AppMethodBeat.o(169319);
        return arrayList;
    }
}

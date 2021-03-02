package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class g {
    private static int sCq = 0;

    public static void a(ebf ebf, c<String, Integer> cVar) {
        AppMethodBeat.i(169320);
        if (ebf == null || cVar == null) {
            AppMethodBeat.o(169320);
            return;
        }
        ez ezVar = new ez();
        ezVar.euv = Process.myPid();
        ez rW = ezVar.rV(com.tencent.mm.kernel.g.aAe().azG().mProcessName).rW(ebf.dRM);
        rW.eux = ebf.NaS;
        rW.euy = ebf.NaT;
        rW.euz = ebf.NaU;
        rW.euA = (String) cVar.get(0);
        rW.euB = ((Integer) cVar.get(1)).intValue();
        int i2 = sCq;
        sCq = i2 + 1;
        rW.euC = i2;
        Log.i("HABBYGE-MALI.SnsReport", "report16242: " + ezVar.abV());
        List<ez> a2 = a(ezVar);
        if (a2 == null) {
            AppMethodBeat.o(169320);
            return;
        }
        for (ez ezVar2 : a2) {
            ezVar2.euA = ezVar2.euA.replace(",", "#");
            ezVar2.bfK();
            Log.i("HABBYGE-MALI.SnsReport", "report16242-sub: " + ezVar2.abV());
        }
        AppMethodBeat.o(169320);
    }

    private static List<ez> a(ez ezVar) {
        JSONArray jSONArray;
        AppMethodBeat.i(169321);
        ArrayList arrayList = new ArrayList();
        byte[] bytes = ezVar.abV().getBytes();
        if (bytes.length <= 5120) {
            ezVar.euD = 0;
            ezVar.euE = 1;
            arrayList.add(ezVar);
            AppMethodBeat.o(169321);
            return arrayList;
        }
        try {
            jSONArray = new JSONArray(ezVar.euA);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SnsReport", e2, "Sns, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
            jSONArray = null;
        }
        if (jSONArray == null) {
            AppMethodBeat.o(169321);
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
            ez ezVar2 = new ez();
            ezVar2.euv = ezVar.euv;
            ezVar2.rV(ezVar.euw);
            ezVar2.rW(ezVar.ekG);
            ezVar2.eux = ezVar.eux;
            ezVar2.euy = ezVar.euy;
            ezVar2.euz = ezVar.euz;
            ezVar2.euC = ezVar.euC;
            JSONArray jSONArray2 = new JSONArray();
            i6 = i7 * i2;
            while (i6 < (i7 + 1) * i2 && i6 < length - i3) {
                jSONArray2.put(jSONArray.opt(i6));
                i6++;
            }
            ezVar2.euA = jSONArray2.toString();
            ezVar2.euB = jSONArray2.length();
            ezVar2.euD = i5;
            ezVar2.euE = i4;
            arrayList.add(ezVar2);
            i7++;
            i5++;
        }
        if (i3 > 0) {
            ez ezVar3 = new ez();
            ezVar3.euv = ezVar.euv;
            ezVar3.rV(ezVar.euw);
            ezVar3.rW(ezVar.ekG);
            ezVar3.eux = ezVar.eux;
            ezVar3.euy = ezVar.euy;
            ezVar3.euz = ezVar.euz;
            ezVar3.euC = ezVar.euC;
            JSONArray jSONArray3 = new JSONArray();
            while (i6 < length) {
                jSONArray3.put(jSONArray.opt(i6));
                i6++;
            }
            ezVar3.euA = jSONArray3.toString();
            ezVar3.euB = jSONArray3.length();
            ezVar3.euD = i5;
            ezVar3.euE = i4;
            arrayList.add(ezVar3);
        }
        AppMethodBeat.o(169321);
        return arrayList;
    }
}

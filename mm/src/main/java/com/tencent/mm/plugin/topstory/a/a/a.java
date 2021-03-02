package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import java.util.ArrayList;

public final class a {
    public static int ID = 845;

    public static void a(b bVar) {
        AppMethodBeat.i(91000);
        if (bVar.Gjx > 0) {
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(ID);
            iDKey.SetKey(0);
            iDKey.SetValue(bVar.Gjx);
            arrayList.add(iDKey);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(ID);
            iDKey2.SetKey(1);
            iDKey2.SetValue(1);
            arrayList.add(iDKey2);
            e.INSTANCE.b(arrayList, false);
        }
        if (bVar.Gjo > 0) {
            ArrayList<IDKey> arrayList2 = new ArrayList<>();
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(ID);
            iDKey3.SetKey(2);
            iDKey3.SetValue(bVar.Gjo);
            arrayList2.add(iDKey3);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(ID);
            iDKey4.SetKey(3);
            iDKey4.SetValue(1);
            arrayList2.add(iDKey4);
            e.INSTANCE.b(arrayList2, false);
        }
        if (bVar.Gjy > 0) {
            ArrayList<IDKey> arrayList3 = new ArrayList<>();
            IDKey iDKey5 = new IDKey();
            iDKey5.SetID(ID);
            iDKey5.SetKey(4);
            iDKey5.SetValue(bVar.Gjy);
            arrayList3.add(iDKey5);
            IDKey iDKey6 = new IDKey();
            iDKey6.SetID(ID);
            iDKey6.SetKey(5);
            iDKey6.SetValue(1);
            arrayList3.add(iDKey6);
            e.INSTANCE.b(arrayList3, false);
        }
        AppMethodBeat.o(91000);
    }
}

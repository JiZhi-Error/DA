package com.tencent.mm.plugin.scanner.model;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class t {
    public static LinkedList<String> gA(List<b> list) {
        AppMethodBeat.i(51637);
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < list.size(); i2++) {
            LinkedList<b.a> linkedList2 = list.get(i2).mRG;
            for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                b.a aVar = linkedList2.get(i3);
                if (a(aVar)) {
                    linkedList.add(aVar.key);
                }
            }
        }
        AppMethodBeat.o(51637);
        return linkedList;
    }

    public static Map<String, b.a> gB(List<String> list) {
        AppMethodBeat.i(51638);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            Log.d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i2 + ";" + Util.nullAsNil(str));
            b.a p = b.p(XmlParser.parseXml(str, NativeProtocol.WEB_DIALOG_ACTION, null), ".action");
            if (!(p == null || p.dDG == 2)) {
                hashMap.put(p.key, p);
            }
        }
        AppMethodBeat.o(51638);
        return hashMap;
    }

    public static boolean b(List<b> list, Map<String, b.a> map) {
        boolean z;
        AppMethodBeat.i(51639);
        if (map == null || map.size() <= 0 || list == null) {
            AppMethodBeat.o(51639);
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) != null) {
                LinkedList<b.a> linkedList = list.get(i2).mRG;
                int i3 = 0;
                boolean z3 = false;
                boolean z4 = z2;
                while (i3 < linkedList.size()) {
                    b.a aVar = linkedList.get(i3);
                    if (a(aVar)) {
                        b.a aVar2 = map.get(aVar.key);
                        if (aVar2 != null) {
                            Log.i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + aVar.key);
                            linkedList.remove(i3);
                            linkedList.add(i3, aVar2);
                            z3 = true;
                            z4 = true;
                        }
                        z = z3;
                    } else {
                        z = true;
                    }
                    i3++;
                    z3 = z;
                }
                list.get(i2).CEH = z3;
                z2 = z4;
            }
        }
        AppMethodBeat.o(51639);
        return z2;
    }

    public static boolean a(b.a aVar) {
        AppMethodBeat.i(51640);
        if (!Util.isNullOrNil(aVar.key)) {
            AppMethodBeat.o(51640);
            return true;
        }
        AppMethodBeat.o(51640);
        return false;
    }
}

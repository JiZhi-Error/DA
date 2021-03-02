package com.tencent.mm.plugin.editor.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
    public static float AO(long j2) {
        float f2 = 1.0f;
        AppMethodBeat.i(181669);
        float f3 = ((float) j2) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        float round = (float) Math.round(f2);
        AppMethodBeat.o(181669);
        return round;
    }

    public static String alR(String str) {
        AppMethodBeat.i(181670);
        String messageDigest = g.getMessageDigest((str + 18 + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(181670);
        return messageDigest;
    }

    public static String a(aml aml) {
        AppMethodBeat.i(181671);
        hb hbVar = new hb();
        hbVar.dLm.type = 27;
        hbVar.dLm.dLo = aml;
        EventCenter.instance.publish(hbVar);
        String str = hbVar.dLn.thumbPath;
        AppMethodBeat.o(181671);
        return str;
    }

    public static String b(aml aml) {
        AppMethodBeat.i(181672);
        hb hbVar = new hb();
        hbVar.dLm.type = 27;
        hbVar.dLm.dLo = aml;
        EventCenter.instance.publish(hbVar);
        String str = hbVar.dLn.path;
        AppMethodBeat.o(181672);
        return str;
    }

    public static ArrayList<a> a(Object obj, List<String> list) {
        AppMethodBeat.i(181673);
        if (obj == null) {
            AppMethodBeat.o(181673);
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        ArrayList<a> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.getType() != 1) {
                arrayList2.add(aVar);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (str.trim().equals("<ThisisNoteNodeHrObj>")) {
                i iVar = new i();
                iVar.qPA = false;
                iVar.qPG = false;
                if (i2 < arrayList2.size()) {
                    arrayList2.add(i2, iVar);
                } else {
                    arrayList2.add(iVar);
                }
            } else if (!str.trim().equals("<ThisisNoteNodeObj>")) {
                j jVar = new j();
                jVar.content = str;
                jVar.qPA = false;
                jVar.qPG = false;
                jVar.dLl = alR(jVar.toString());
                if (i2 < arrayList2.size()) {
                    arrayList2.add(i2, jVar);
                } else {
                    arrayList2.add(jVar);
                }
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
        AppMethodBeat.o(181673);
        return arrayList2;
    }
}
